package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;

public class IntegerSet{
private ArrayList<Integer> set = new ArrayList<Integer>();
	
	public IntegerSet() {
		
	}
	public ArrayList<Integer> getSet() {
        return this.set;
    }
	
	public void clear() {
		//clear all objects from the ArrayList
		this.set.clear();
	}
	
	public int length() {
		/*
		 * Gets the length of the set
		 */
		return this.set.size();
	}
	
	public boolean equals(IntegerSet b) {
		/*
		 * If all the set of elements are same then check if they are equal
		 */
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
		set.remove(item);
		}
	
	public void intersection(IntegerSet intSetb) {
		this.set.retainAll(intSetb.getSet());
	}
	
	public void union(IntegerSet intSetb) {
		/*
		 * If both the sets are equal no need to do the union
		 * If both sets are not equal then add the unique element in the setB to the setA
		 */
		if (this.getSet().equals(intSetb.getSet())) {
			return;
		}
		else {
			for (int val = 0; val <intSetb.length();val++) {
				this.add(intSetb.getSet().get(val));
			}
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
		return this.getSet().toString();
	}

}
