package org.howard.edu.lsp.midterm.problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {
	private String name;
	private int age;
	private String socialsecurityNumber;
	
	public Person(String name, int age,String socialsecurityNumber) {
		/*
		 * This is the constructor for the class.
		 * As convention it's named as the main class
		 * There are three attributes - name which is of type string, age of type integer and ssn of type string
		 */
		
		this.name = name;
		this.age = age;
		this.socialsecurityNumber = socialsecurityNumber;
	}
	
	@Override
	public boolean equals(Object obj) {
		/*
		 * Here the equals(Object) method is overridden 
		 * First, object is compared with itself then returns true
		 */
		if (obj == this) {
			return true;
		}
		/*
		 * This is also important to make sure that obj is instance of Person or not
		 */
		if (!(obj instanceof Person)) {
			return false;
		}
		/*
		 * Type casting 
		 * casting obj to Person so the data can be compared
		 */
		Person p = (Person) obj;
		String ssn1 = this.socialsecurityNumber.toString();
		String ssn2 = p.socialsecurityNumber.toString();
		/*
		 * Here Data is compared and returns boolean value accordingly
		 */
		
		if (ssn1 != ssn2) {
			return false;
		}
		return true;		
	}
	
	/*
	 * The toString() method is overridden below
	 * This also returns String
	 */
	
	@Override
	public String toString() {
		return name + " " + age + " "+ socialsecurityNumber;
		
	}
	
	
	
}
