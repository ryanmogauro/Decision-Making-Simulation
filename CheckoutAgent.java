/**
 * Project: Queues
 * File: CheckoutAgent.java
 * Author: Ryan Mogauro
 * Date: 4/4/22
 * Course: CS231A
 */	
import java.awt.Color;
import java.awt.Graphics;

public class CheckoutAgent {
	private int x; 
	private int y; 
	private MyQueue<Customer> customers; 
	
	//constructor. The queue should be initialized to an empty MyQueue<Customer>.
	public CheckoutAgent(int x, int y) {
		this.x = x;
		this.y = y; 
		this.customers = new MyQueue<Customer>(); 
	}
	
	//add a Customer to its queue.
	public void addCustomerToQueue( Customer c ) {
		customers.offer(c); 
	}
	
	//returns the number of Customers in its queue.
	public int getNumInQueue() {
		return customers.getSize();
	}
	
	//updates the state of the customer at front of queue if not empty
	//also calls incrementTime() on each customer in queue
	public void updateState(Landscape scape) {
		if(this.customers.peek() == null) {
			return;
		} else {
		for(Customer x: customers) {
			x.incrementTime();
		}
		this.customers.peek().giveUpItem(); 
		if(this.customers.peek().getNumItems() == 0) {
			scape.addFinishedCustomer(this.customers.peek());
			this.customers.poll();
			}
		}
	}
	
	//draws the CheckoutAgent as a rectangle near the bottom of the window with a height proportional to the number of Customers in the queue.
	public void draw(Graphics g) {
			g.setColor(Color.red);
			int height = 10 * this.getNumInQueue(); 
			g.fillRect(this.x, this.y-height, 10, height); 
	}
	
	//tests all methods to ensure they're working as intended
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckoutAgent ca = new CheckoutAgent(1,2); 
		System.out.println(ca.getNumInQueue()); 
		ca.updateState(null);
		Pick2Customer newCust = new Pick2Customer(1); 
		ca.addCustomerToQueue(newCust); 
	}

}
