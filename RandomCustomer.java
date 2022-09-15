/**
 * Project: Queues
 * File: RandomCustomer.java
 * Author: Ryan Mogauro
 * Date: 4/4/22
 * Course: CS231A
 */	
import java.util.ArrayList;
import java.util.Random;
public class RandomCustomer extends Customer{
	
	// constructor. This should call the super class's constructor with the given number of items and 1 as the initial value for the time steps. This is meant to simulate the amount of time the RandomCustomer spends choosing a line. The RandomCustomer spends one time-step choosing a line, so it needs to start its counter at 1.
	public RandomCustomer( int num_items ) {
		super(num_items,1);
	}
	
	// returns an integer randomly chosen from the range 0 (inclusive) to the lenght of the list (exclusive).
	public int chooseLine(ArrayList<CheckoutAgent> checkouts) {
		Random rand = new Random(); 
		return rand.nextInt(checkouts.size()); 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
