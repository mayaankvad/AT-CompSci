package histograms2;

@SuppressWarnings("unused")
public class HistoList
{
	private ListNode front;

	public HistoList()
	{
		front = null;
	}


	//ADDS NEW NODE TO THE FRONT OF THE LIST FOR LET IF IT DOES NOT EXIST.
	//IF IT EXISTS, IT BUMPS UP LET'S COUNT BY ONE
	public void add(Object obj)
	{

		// if list is empty add node
		if (front == null) {
			//front = new ListNode(let, 1, null);
			front = new ListNode(new ThingCount(obj, 1), null);
			return;
		}

		boolean found = false;
		ListNode search = front;

		// search for node with let
		while (search != null) {
			if (((ThingCount) search.getValue()).getThing().equals(obj)) {
				found = true;
				// if node exists increment count
				((ThingCount) search.getValue()).setCount(((ThingCount) search.getValue()).getCount() +1);
			}
			search = search.getNext();
		}

		// if node not exists add new node
		if (!found) {
			front = new ListNode(new ThingCount(obj, 1), front);
		}
	}

	//RETURNS THE INDEX POSITION OF LET IN THE LIST
	public int indexOf(Object obj)
	{
		int spot=-1;
		
		ListNode n = front;
		while(n != null) {
			spot++;
			
			if(n.getValue().equals(obj)) {
				return spot;
			}
			
			n = n.getNext();
			
		}
		
		return spot;
	}

	//RETURNS A REFERENCE TO THE NODE AT SPOT
	private ListNode nodeAt(int spot)
	{
		ListNode current=front;
		int c = 0;
		
		while(current != null) {
			if(c == spot) {
				return current;
			}
			current = current.getNext();
		}
		
		return null;
	}

	//RETURNS THE LIST AS A BIG STRING
	public String toString()
	{
		String output = "";
		
		ListNode n = front;
		while(n != null) {
			output += front.getValue();
			n = n.getNext();
		}
		
		return output;
	}
}