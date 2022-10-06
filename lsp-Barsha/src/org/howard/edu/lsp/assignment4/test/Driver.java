package org.howard.edu.lsp.assignment4.test;

import org.howard.edu.lsp.assignment4.implementation.IntegerSet;
import org.howard.edu.lsp.assignment4.implementation.IntegerSetException;
/*
 *Calls out to other functions and methods defined in the Integerset class and IntegersetException class which is user defined exception class
 * 
 *
 */
public class Driver {
	public static void main(String[] args) {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		set1.add(0);
		set1.add(1);
		set1.add(2);
		set2.add(2);
		set2.add(3);
		set2.add(4);
		set2.add(5);
		System.out.println("Using add method: ");
		System.out.println("After adding elements to set1: 0,1,2...");
		System.out.println("Set1 = " + set1) ;
		System.out.println("After add elements to set2: 2,3,4,5...");
		System.out.println("Set2 = " + set2) ;
		System.out.println("\nUnion of Set1 and Set2");
        System.out.println("Value of Set1 is: " + set1);
        System.out.println("Value of Set2 is: " + set2);
        System.out.println("After union Set1: " + set1);
        
        //Using length method
        System.out.println("\nLength of Set1 is: " + set1.length());
        System.out.println("Length of Set2 is: " + set2.length());
        
        //using union method
        System.out.println("\n//USING UNION METHOD");
        set1.union(set2);
        System.out.println("Value of Set1 is: " + set1);
        System.out.println("Value of Set2 is: " + set2);
        System.out.println("Value of union of Set1 and Set2");
        System.out.println("Set1 Union Set2 " + set1);
        
        //Using intersection method
        System.out.println("\n//USING INTERSECTION METHOD");
        set1.add(10);
        set2.add(11);
        set1.intersection(set2);
        System.out.println("Value of Set1 is: " + set1);
        System.out.println("Value of Set2 is: " + set2);
        System.out.println("Value of intersection of Set1 and Set2");
        System.out.println("Set1 Intersection Set2: " + set1);
        
        System.out.println("\n//USING DIFF METHOD");
        set1.add(13);
        System.out.println("Value of Set1 is: " + set1);
        System.out.println("Value of Set2 is: " + set2);
        System.out.println("Value of diff of Set1 and Set2");
        set1.diff(set2);
        
        System.out.println("\nSet1 =" + set1);

        try {
            System.out.println("\n Smallest value in Set1 is:" + set1.smallest());
        } catch(IntegerSetException ise) {
            System.out.println(ise);
        }
        
        set2.add(100);
        System.out.println("\nSet2 =" + set2);

        try {
            System.out.println("\n Largest value in Set2 is:" + set2.largest());
        } catch(IntegerSetException ise) {
            System.out.println(ise);
        }
        
        //Using clear()
        System.out.println("\nClearing out set1");
        set1.clear();
        System.out.println("\nAfter clearing out set1");
        System.out.println("\nTesting for the Exceptions by calling out largest and smallest");
        //Using Exception and testing them
        try {
            System.out.println("Largest value in Set1 is:" + set1.largest());
        } catch(IntegerSetException ise) {
            System.out.println(ise);
        }
        System.out.println("\nTesting for the Exceptions");
        try {
            System.out.println("Smallest value in Set1 is:" + set1.smallest());
        } catch(IntegerSetException ise) {
            System.out.println(ise);
        }
        System.out.println("\n//Removing an item from the set2");
        System.out.print("The set2 looks like this : ");
        System.out.println(set2.toString());
        try {
			set2.remove(2);
		} catch (IntegerSetException e) {
			e.printStackTrace();
		}
        System.out.print("After Removing an item from the set : ");
        System.out.println(set2.toString());
        
        //Using equals method
        set1.clear();
        set2.clear();
        System.out.println("\nChecking if set1 is empty: ");
        System.out.print(" Length if set1: ");
        System.out.println(set1.length());
        System.out.println(set1.isEmpty());
        set1.add(1);
        set1.add(2);
        set2.add(1);
        System.out.println("\nChecking if set1 and set2 are equal: " + set2.equals(set1));
        System.out.println("set1= " + set1.toString());
        System.out.println("set2= " + set2.toString());
        set2.add(2);
        System.out.println("\nChecking if set1 and set2 are equal: " + set2.equals(set1));
        System.out.println("set1 = " + set1.toString());
        System.out.println("set2 = " + set2.toString());
        System.out.println("\nChecking if set contains an item: ");
        System.out.println("Returns true as it contains 2" + set2.contains(2));
        //Testing for toString Function
        System.out.println("\nPrinting out set1 using toString()");
        System.out.println(set1.toString());
        
        
	}
	
}

