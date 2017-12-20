package histograms2;


public class HistoList
{
	private ListNode front;

	public HistoList( )
	{
	}


	//ADDS NEW NODE TO THE FRONT OF THE LIST FOR LET IF IT DOES NOT EXIST.
	//IF IT EXISTS, IT BUMPS UP LET'S COUNT BY ONE
	public void add(Object obj)
	{
	}

	//RETURNS THE INDEX POSITION OF LET IN THE LIST
	public int indexOf(Object obj)
	{
		int spot=-1;
		return -1;
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
			front = front.getNext();
		}
		
		return output;
	}
}