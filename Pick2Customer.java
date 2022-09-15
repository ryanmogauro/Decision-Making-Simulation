/**
 * Project: Queues
 * File: Pick2Customer.java;
 * Author: Ryan Mogauro
 * Date: 4/4/22
 * Course: CS231A
 */	
import java.util.ArrayList;
import java.util.Random; 
public class Pick2Customer extends Customer{
	
	//constructor. This should call the super class's constructor with the given number of items and 2 as the initial value for the time steps. The Pick2Customer spends two time-step choosing a line because it randomly examines two lines before picking one.
	public Pick2Customer( int num_items ) {
		super(num_items, 2); 
	}
	
	//returns the index of the shorter of two randomly chosen queues.
	public int chooseLine(ArrayList<CheckoutAgent> checkouts) {
		Random rand = new Random(); 
		int rand1 = rand.nextInt(checkouts.size()); 
		int rand2 = rand.nextInt(checkouts.size()); 
		
		while(rand1 == rand2) {
			rand2 = rand.nextInt(checkouts.size()); 
		}
		
		if(checkouts.get(rand1).getNumInQueue() > checkouts.get(rand2).getNumInQueue()) {
			return rand2; 
		}
		
		return rand1;
	}
}
