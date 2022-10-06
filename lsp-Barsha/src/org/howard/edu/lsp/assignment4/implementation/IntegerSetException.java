package org.howard.edu.lsp.assignment4.implementation;
/*
 * In this class, I have defined Exception. 
 * As the class IntegerSetException extends Exception which basically gets the properties of the Exception.
 * This IntergerException can be used in the other classes while defining a method, this class can be used.
 * 
 * */

public class IntegerSetException extends Exception{
   private static final long serialVersionUID = 1L;

	public IntegerSetException(String str)  
    {  
        super(str); 
    }  
}

