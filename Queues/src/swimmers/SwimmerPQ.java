package swimmers;

import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.PriorityQueue;

public class SwimmerPQ  
{
	private Queue<Swimmer> pQueue;

	public SwimmerPQ()
	{
		this.pQueue = new PriorityQueue<Swimmer>();
	}

	public void add(Swimmer obj)
	{
		this.pQueue.offer(obj);
	}
	
	public Object getMin()
	{
		return this.pQueue.peek();
	}
	
	public Object removeMin()
	{
		return this.pQueue.poll();
	}
	
	public String getNaturalOrder()
	{
		return this.toString();	
	}

	//write a toString method
	public String toString() {
		return this.pQueue.toString();
	}
	
}