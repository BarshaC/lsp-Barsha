package org.howard.edu.lsp.assignment7;

import java.util.ArrayList;
import java.util.List;

import org.howard.edu.lsp.assignment7.*;
/*
 * Made this Driver class just to see if the implementation is working.
 * Detailed testings are added to the JUnit testing
 */
public class Driver {
	public static void main(String[] args) throws EmptyListException {
		List <Integer> lst_grades = new ArrayList<Integer>();
		lst_grades.add(45);
		lst_grades.add(70);
		lst_grades.add(70);
		lst_grades.add(54);
		lst_grades.add(90);
		try {
			Grader  computeGrade = new Grader();
			int result = computeGrade.compute(lst_grades);
			int curved_result = computeGrade.compute_best_grade(lst_grades);
			System.out.print("Average Grade: ");
			System.out.println(result);
			System.out.print("Average Grade without taking two lowest grades: ");
			System.out.println(curved_result);
			
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
		
	}
}
