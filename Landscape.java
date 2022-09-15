/**
 * Project: Queues
 * File: Landscape.java
 * Author: Ryan Mogauro
 * Date: 4/4/22
 * Course: CS231A
 */	
import java.awt.Graphics;
import java.util.ArrayList;

public class Landscape {
	
	private int width;
	private int height; 
	private ArrayList<CheckoutAgent> agents;
	private LinkedList<Customer> finCustomers; 
	
	// constructor. The list of finished customers should be initialized to an empty list.
	public Landscape(int w, int h, ArrayList<CheckoutAgent> checkouts ) {
		this.width = w; 
		this.height = h; 
		this.agents = checkouts; 
		this.finCustomers = new LinkedList<Customer>(); 
	}
	
	//return the height of the Landscape.
	public int getHeight() {
		return this.height; 
	}
	
	//return the width of the Landscape.
	public int getWidth() {
		return this.width; 
	}
	
	// return a string indicating how many checkouts and finished customers are in the landscape.
	public String toString() {
		return "Checkouts: " + agents.size() + "\n" + "Finished customers: " + finCustomers.size(); 
	}
	
	//add the Customer to the list of finished customers.
	public void addFinishedCustomer(Customer c ) {
		this.finCustomers.addLast(c); 
	}
	
	// loop through the CheckoutAgents, calling the draw method on each.
	public void draw( Graphics g ) {
		for(CheckoutAgent c: agents) {
			c.draw(g); 
		}
	}
	
	//calls update state on each agent in agents
	public void updateCheckouts() {
		for(CheckoutAgent c: agents) {
			c.updateState(this);
		}
	}
	
	//calculates and prints simulation statistics
	public void printFinishedCustomerStatistics() {
		 double totalTime = 0; 
		 for(Customer x: finCustomers) {
			 totalTime+=x.getTime(); 
		 }
		 double averageTime = (totalTime / finCustomers.size()); 
		 double powerSum1 = 0;
		 double powerSum2 = 0;
		 double stDev = 0;
		 int count = 0; 
		for(Customer x: finCustomers) {
		     powerSum1 += x.getTime();
		     powerSum2 += Math.pow(x.getTime(), 2);
		     stDev = Math.sqrt(count*powerSum2 - Math.pow(powerSum1, 2))/count;
		     System.out.println("Average time: " + averageTime + "\n" + "Standard Deviation: " + stDev); 
		     count++;
		 }
	 }

}
