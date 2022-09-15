/**
 * Project: Queues
 * File: PickyCustomer
 * Author: Ryan Mogauro
 * Date: 4/4/22
 * Course: CS231A
 */	
import java.util.ArrayList;

public class PickyCustomer extends Customer{
	
	//constructor. This should call the super class's constructor with the given number of items and num_lines as the initial value for the time steps. The PickyCustomer examines the lengths of all the lines before choosing one, so its initial time needs to reflect that.
	public PickyCustomer( int num_items, int num_lines ) {
		super(num_items, num_lines); 
	}
	
	//returns the index of the CheckoutAgent with the shortest line.
	public int chooseLine(ArrayList<CheckoutAgent> checkouts) {
		int index = 0; 
		for(int i = 0; i<checkouts.size(); i++) {
			if(checkouts.get(index).getNumInQueue()> checkouts.get(i).getNumInQueue()) {
				index = i; 
			}
		}
		return index; 
	}
}
