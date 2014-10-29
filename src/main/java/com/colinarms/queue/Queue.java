package com.colinarms.queue;

public interface Queue {

	public void enqueue(int num) throws Exception;

	public int dequeue() throws Exception;
}
