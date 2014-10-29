package com.colinarms.queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoundedQueueTest {

	public BoundedQueueTest() {
	}

	@Test(expected = Exception.class)
	public void testDequeueWhenEmpty() throws Exception {
		BoundedQueue queue = new BoundedQueue(0);
		queue.dequeue();
	}

	@Test(expected = Exception.class)
	public void testEnqueueWhenFull() throws Exception {
		BoundedQueue queue = new BoundedQueue(3);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4); // this should throw exception

	}

	@Test
	public void testEnqueueOne() throws Exception {
		BoundedQueue queue = new BoundedQueue(3);
		queue.enqueue(123456);
		assertEquals(123456, queue.dequeue());
	}

	@Test
	public void testEnqueueMany() throws Exception {
		BoundedQueue queue = new BoundedQueue(1000);

		for (int i = 0; i < 1000; i++) {
			queue.enqueue(i);
		}

		for (int i = 0; i < 100; i++) {
			assertEquals(i, queue.dequeue());
		}

	}

}
