package histograms;

import java.util.TreeMap;

public class HistoList {
	private HistoNode front;

	public HistoList() {
		front = null;
	}

	// addLetter will add a new node to the front for let if let does not exist
	// addLetter will bump up the count if let already exists
	public void addLetter(char let) {

		// if list is empty add node
		if (front == null) {
			front = new HistoNode(let, 1, null);
			return;
		}

		boolean found = false;
		HistoNode search = front;

		// search for node with let
		while (search != null) {
			if (search.getLetter() == let) {
				found = true;
				// if node exists increment count
				search.setLetterCount(search.getLetterCount() + 1);
			}
			search = search.getNext();
		}

		// if node not exists add new node
		if (!found) {
			front = new HistoNode(let, 1, front);
		}

	}

	// removeLetter will remove a letter node or decrease the count
	public void removeLetter(char let) {
		HistoNode search = front;
		HistoNode before = null;

		// search for node with let
		while (search != null) {
			if (search.getLetter() == let) {

				int count = search.getLetterCount();
				if (count > 1) {
					search.setLetterCount(count - 1); // decrease count cause
														// there's more then one
				}
				// remove cause there is only 1
				else {

					before.setNext(search.getNext());

				}

				return;

			}
			before = search;
			search = search.getNext();
		}
	}

	// returns the index pos of let in the list if let exists
	public int indexOf(char let) {
		int pos = 0;
		HistoNode search = front;

		while (search != null) {
			if (search.getLetter() == let) {
				return pos;
			}
			search = search.getNext();
			pos++;

		}
		return -1;
	}

	// returns a reference to the node at spot
	public HistoNode nodeAt(int spot) {
		int count = 1;

		HistoNode search = front;

		while (search != null) {
			if (count == spot) {
				return search;
			}
			search = search.getNext();
			count++;
		}
		return null;
	}

	// returns a string will all values from list
	public String toString() {

		sort();

		HistoNode search = front;
		String output = "[ ";

		while (search != null) {
			output += search.getLetter() + ":" + search.getLetterCount() + ", ";
			search = search.getNext();
		}

		return output + "]";
	}

	// sorts alphabetically
	public void sort() {

		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();

		HistoNode n = front;
		while (n != null) {
			map.put(n.getLetter(), n.getLetterCount());
			n = n.getNext();
		}

		front = null;

		for (int i = map.size() - 1; i >= 0; i--) {
			Character ch = (Character) map.keySet().toArray()[i];
			Integer in = map.get(ch);
			front = new HistoNode(ch, in, front);
		}

	}

}
