/**
 * Project: Queues
 * File: MyQueue.java
 * Author: Ryan Mogauro
 * Date: 4/4/22
 * Course: CS231A
 */	
import java.util.Iterator;
public class MyQueue<T> implements Iterable<T>{
		private Node<T> head; 
		private Node<T> tail;  
		private int length; 

	private class Node<T>{
			private Node<T> next; 
			private Node<T> previous; 
			private T data; 
			
			
			//constructor that initializes next to null and the container field to item.
			public Node(T item) {
				this.next = null; 
				this.previous = null; 
				this.data = item; 
			}
			
			//returns the value of thing 
			public T getData() {
				return this.data; 
			}
			
			// sets next to the given node
			public void setNext(Node<T> n) {
				this.next = n; 
			}

			// sets previous to given node
			public void setPrevious(Node<T> n){
				this.previous = n; 
			}
			
			//returns the next field
			public Node<T> getNext() {
				return this.next; 
			}
			public Node<T> getPrev(){
				return this.previous; 
			}
		}
		
		//iterator class
		public class QueueIterator implements Iterator<T>{
			private Node<T> current; 
			
			//sets current to head
			public QueueIterator(Node<T> head) {
				this.current = head; 
			}
			
			//returns whether the current is null
			public boolean hasNext() {
				return this.current != null;
			}
			
			//returns next Node
			public T next() {
				if(this.hasNext()) {
					T data = this.current.getData(); 
					this.current = this.current.getNext();
					return data; 
					
				}
				return null; 
			}
		}
		
		//returns length of queue
		public int getSize() {
			return this.length; 
		}
		// Inserts item into this queue if possible. Returns true if successful.
		public boolean offer(T item) {
			Node<T> newNode = new Node<T>(item); 
			if(this.length == 0){
				this.head = newNode; 
				this.tail = newNode; 
			} else{
				newNode.setPrevious(this.tail);
				this.tail.setNext(newNode);
				this.tail = newNode; 
			}
			length++;
			return true; 

		}
		// Returns, but does not remove, the head of this queue, or returns null if this queue is empty.
		public T peek() {
			if(this.length == 0){
				return null; 
			}
			return this.head.getData();
		}
	 	// Returns and removes the head of this queue, or returns null if this queue is empty.
		public T poll() {
			T remove; 
	   		if(this.length == 0){
	   			remove = null;
	   		}else if(this.length == 1){
	   			remove = head.getData(); 
	   			this.tail = null;  
	   			this.head = null;
	   			this.length--;  
	   		}else {
	   			remove = head.getData()
;	   			this.head = head.getNext();
	   			this.head.setPrevious(null);
	   			this.length--; 
	   		}
	   		return remove;
		}
		
		//returns iterator object
		public Iterator<T> iterator(){
			return new QueueIterator(this.head);
		}

		//testing methods
		public static void main(String[] args) {
			MyQueue<Integer> queue = new MyQueue<Integer>();
			System.out.println(queue.poll());
			System.out.println(queue.peek());
			System.out.println(queue.offer(1));
			System.out.println(queue.offer(2));
			System.out.println(queue.offer(3));
			System.out.println(queue.offer(4));
			System.out.println(queue.offer(5));
			System.out.println(queue.length);
			for(int val: queue) {
				System.out.println("val:" + val);
			}
			System.out.println("this should be 1: " + queue.poll());
			System.out.println("this should be 2: " + queue.peek());
		}

}
