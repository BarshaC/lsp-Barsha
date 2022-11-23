package org.howard.edu.lsp.assignment7;
import java.util.Collections;
import java.util.List;


public class Grader implements AverageStrategy{
	/*
	 * compute() function takes in the list of numbers and calculates the average grades
	 * Returns the average grades
	 */
	@Override
	public int compute(List<Integer> grades) throws EmptyListException {
		int total_grades_sum = 0;
		int count_length = grades.size();
		for (int i = 0; i < grades.size(); i++)
            total_grades_sum += grades.get(i);
		if (count_length < 1 ) {
			throw new EmptyListException("The list is Empty! Cannot compute average of empty list.");
		}
		int average = total_grades_sum/count_length; 
		return average;
	}
	/*
	 * compute() function takes in the list of numbers and calculates the average grades dropping the lowest grades
	 * Returns the average grades
	 */
	@Override
	public int compute_best_grade(List<Integer> grades) throws EmptyListException {
		int total_grades_sum = 0;
		if (grades.size() < 1) {
			throw new EmptyListException("The list is Empty! Cannot compute average of empty list.");
		}
		Collections.sort(grades); //Here collections sort the grades so the lowest two can be dropped
		for (int i = 0; i < grades.size(); i++)
            total_grades_sum += grades.get(i);
		int new_average = (total_grades_sum-(grades.get(0) + grades.get(1)))/(grades.size()-2);
		return new_average;	
	}

}
