/**
 * Project: Queues
 * File: Customer.java
 * Author: Ryan Mogauro
 * Date: 4/4/22
 * Course: CS231A
 */	
import java.util.ArrayList;

abstract class Customer {
	private int items; 
	private int timeSteps;
	
	// constructor method. (By default, the number of time steps is zero.)
	public Customer(int num_items) {
		this.items = num_items; 
		this.timeSteps = 0; 
	}
	
	//constructor method.
	public Customer(int num_items, int time_steps) {
		this.items = num_items; 
		this.timeSteps = time_steps;
	}
	
	//increments the number of time steps.
	public void incrementTime() {
		this.timeSteps++; 
	}
	
	//returns the number of time steps
	public int getTime() {
		return this.timeSteps; 
	}
	
	//decrements the number of items (indicating another item has been paid for).
	public void giveUpItem() {
		this.items--; 
	}
	
	// returns the number of items.
	public int getNumItems() {
		return this.items;
	}
	
	//since this is an abstract method, there is no body.
	public abstract int chooseLine(ArrayList<CheckoutAgent> checkouts);

}
