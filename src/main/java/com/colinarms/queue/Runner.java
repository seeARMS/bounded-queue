package com.colinarms.queue;

import java.util.Scanner;

enum InputValue {
	ENQUEUE, DEQUEUE, HELP, QUIT
}

public class Runner {
	
	public static void main(String[] args) throws Exception {
		int size = 0;
		boolean loop = true;
		String[] input;
		int val;
		InputValue inVal;
		
		Scanner scanner = new Scanner(System.in);
		String command;
		
		System.out.println("Creating queue....");
		System.out.println("Please enter queue size: \n");
		
		try {
		    size = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}		
		
		BoundedQueue queue = new BoundedQueue(size);
		
		System.out.println("Queue of size " + size + " has been created.");
		
		System.out.println("Please enter a command, or type help to view available commands.\n");

		while(loop) {
			String stringInput = scanner.nextLine();
			input = stringInput.split(" ");
			command = input[0].toUpperCase();
			
			inVal = InputValue.valueOf(command);
			
			switch(inVal) {
			
				case HELP:
					System.out.println("Commands: ");
					System.out.println("enqueue [N]              enqueue a number");
					System.out.println("dequeue                  dequeue a number");
					System.out.println("help                     view this page");
					System.out.println("quit                     exit the program");

					break;
					
				case ENQUEUE:
					val = Integer.parseInt(input[1]);
					try {
						queue.enqueue(val);
						System.out.println(val + " was enqueued.");
					} catch (IllegalStateException e) {
						System.out.println(e.getMessage());
					}
					break;
				case DEQUEUE:
					try {
						val = queue.dequeue();
						System.out.println(val + " was dequeued.");
					} catch (IllegalStateException e) {
						System.out.println(e.getMessage());
					}
					break;
					
				case QUIT: 
					loop = false;
					break;
			}
			

		}
		
		scanner.close();
	}

}
