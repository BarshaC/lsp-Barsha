package org.howard.edu.lsp.assignment4.implementation;
import java.util.ArrayList;
import java.util.List;

/*
 * IntegerSet class creates a set which is collection of elements. Elements can be anything.
 * I have added a getSet method which basically returns the set.
 * For my method clear, I have used built-in function clear which basically clears about anything the set contains.
 * For method equal, it checks if the two sets are equal.
 * Contains method checks if there is the value that the user is asking for.
 * Largest comes up with the Exception check which basically gives exception if the either there is no set or the elements of the set is empty.
 * Smallest same as Largest however, it checks for the smallest element in the set.
 * */
public class IntegerSet{
private List<Integer> set = new ArrayList<Integer>();
	
	public IntegerSet() {
		
	}
	public List<Integer> getSet() {
        return this.set;
    }
	
	public void clear() {
		//clear all objects from the ArrayList
		this.set.clear();
	}
	
	public int length() {
		return this.set.size();
	}
	
	public boolean equals(IntegerSet b) {
		return this.set.equals(b.getSet());
	}
	
	public boolean contains(int value) {
		return this.set.contains(value);
	}
	
	public int largest() throws IntegerSetException {
		if (this.isEmpty()) {
			throw new IntegerSetException("Can't find the largest. The set is Empty.");
		}
		int max = this.set.get(0);
		for (int i = 1; i< this.length();i++) {
			if (this.set.get(i)>max) {
				max = this.set.get(i);
			}
		}
		return max;
	}
	
	
	public int smallest() throws IntegerSetException {
		if (this.isEmpty()) {
			throw new IntegerSetException("Can't find smallest element. The set is Empty");
		}
		int min = this.set.get(0);
		for (int i = 1;i < this.length();i++) {
			if (this .set.get(i) < min) {
				min = this.set.get(i);
			}
		}
		return min;
		
		
	}
	
	public void add(int item) {
		if (!this.contains(item)) {
			this.set.add(item);
		}
	}
	
	public void remove(int item) throws IntegerSetException {
		if (this.isEmpty()) {
			throw new IntegerSetException("Can't remove anything. The set is Empty!");
		}
		if (this.contains(item)) {
			this.set.remove(item);
		}
	}
	
	public void intersection(IntegerSet intSetb) {
		this.set.retainAll(intSetb.getSet());
	}
	
	public void union(IntegerSet intSetb) {
		for (int item: intSetb.getSet()) {
			this.add(item);
		}
	}
	
	public void diff(IntegerSet intSetb) {
		this.set.removeAll(intSetb.getSet());
	}
	public boolean isEmpty() {
		if (this.length() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String output = "";
		for (int item: this.getSet()) {
			output += String.format("%d ", item);
		}
		return output;
	}

}



