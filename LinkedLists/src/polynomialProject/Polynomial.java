package polynomialProject;

import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial {

	enum Operation {
		ADD, SUBTRACT, MULTIPLY
	}

	private LinkedList<Term> terms;

	public Polynomial() {
		this.terms = new LinkedList<Term>();
	}

	public void addTerm(int coefficient, int power) {
		terms.addLast(new Term(coefficient, power));
	}
	
	public void addTerm(Term t) {
		this.addTerm(t.getCoefficient(), t.getPower());
	}

	public Polynomial add(Polynomial p) {
		return operate(p, Operation.ADD);
	}

	public Polynomial subtract(Polynomial p) {
		return operate(p, Operation.SUBTRACT);
	}

	// @TODO fix
	public Polynomial multiply(Polynomial p) {
		ListIterator<Term> iter = this.terms.listIterator();
		ListIterator<Term> pIter = p.getIterator();
		
		Polynomial product = new Polynomial();
		
		while(iter.hasNext()){
			Term term = iter.next();
			
			while(pIter.hasNext()) {
				product.addTerm(term.multiply(pIter.next()));
			}
			
			pIter = p.getIterator();
		}
		
		product.simplify();
		return product;
		
	}

	
	public Polynomial operate(Polynomial p, Operation op) {

		Polynomial res = new Polynomial();
		res.addAll(this);
		res.addAll(p);
		if (op == Operation.MULTIPLY) {
			// @TODO fix
			
		} else {
			res.simplify(op);
		}
		res.simplify();

		return res;
	}

	public void simplify() {
		this.simplify(Operation.ADD);
	}

	// @TODO fix multiply
	public void simplify(Operation op) {
		
		// Sort terms in order
		Collections.sort(this.terms);
		
		// define iterator
		ListIterator<Term> iter = terms.listIterator();
		
		// remove all 0 coefficient terms
		while(iter.hasNext()) {
			if(iter.next().getCoefficient() == 0) {
				iter.remove();
			}
		}

		// redefine iter with modified list
		iter = terms.listIterator();
		
		// if modified list has no elements, stop
		if(!iter.hasNext()) {
			return;
		}
		
		// main loop to combine like terms using operation op
		
		Term previous = iter.next();
		
		while (iter.hasNext()) {
			Term current = iter.next();

			if (current.getPower() == previous.getPower()) {
				Term x = null;

				switch (op) {
				case ADD:
					x = current.add(previous);
					break;
				case SUBTRACT:
					x = current.subtract(previous);
					break;
				default:
					break;
				}

				iter.remove();
				iter.previous();
				iter.remove();
				iter.add(x);

				previous = x;
			} else {
				previous = current;
			}
		}
		
	}

	public LinkedList<Term> getTerms() {
		this.simplify();
		return this.terms;
	}

	public ListIterator<Term> getIterator(){
		this.simplify();
		return this.terms.listIterator();
	}
	
	public void addAll(Polynomial o) {
		this.terms.addAll(o.getTerms());
		this.simplify();
	}

	public String toString() {
		return "" + this.terms;
	}

}
