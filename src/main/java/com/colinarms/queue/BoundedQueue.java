package com.colinarms.queue;

public class BoundedQueue {
	int size;
	int numInts;
	int start;
	int end;
	
	int[] array;
	
	public BoundedQueue(int size) {
		this.size = size;
		array 	= new int[size];
		start 	= 0;
		end		= 0;
		numInts = 0;
	}
	
	public void enqueue(int num) throws Exception {
		if (numInts == size)
			throw new Exception();
		
		array[start] = num;
		
        start = ++start == size ? 0 : start;
		
        numInts++;
	}
	
	public int dequeue() throws Exception {
		if (numInts == 0) 
			throw new Exception();
		
		int retrievedNum = array[end];
		array[end] = 0;
		
		numInts--;
		end = ++end == size ? 0 : end;
		
		return retrievedNum;
	}
}
