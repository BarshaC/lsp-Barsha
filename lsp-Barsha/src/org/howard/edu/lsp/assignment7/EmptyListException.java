package org.howard.edu.lsp.assignment7;

/*
 *User defined EmptyListException
 */
public class EmptyListException extends Exception {
	private static final long serialVersionUID = 1;

	public EmptyListException(String str_exption)  
    {  
        super(str_exption); 
    } 

}
