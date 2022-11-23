package org.howard.edu.lsp.assignment7;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
 * JUnit for the functions compute grades and the exception error
 */
class GraderTest {
	/*
	 * This is the testing for the EmptyList Exception
	 * Here the testing checks if actually the exception is thrown when the empty list is passed 
	 * grade computation
	 * Also checks if the exception message is passed correctly
	 */
	@Test
	@DisplayName("Test for  EmptyListException")
	void testEmptyListException() {
		String expectedErrorMessage;
		Grader  computeGrade = new Grader();
		List <Integer> lst_grades = new ArrayList<Integer>();
		Exception exception = assertThrows(EmptyListException.class, ()->{computeGrade.compute(lst_grades);});
		expectedErrorMessage = "The list is Empty! Cannot compute average of empty list.";
		String exceptionMessage = exception.getMessage();
		String messageToCheck = "Random Error Message"; 
		assertEquals(expectedErrorMessage, exceptionMessage);
		assertNotEquals(expectedErrorMessage, messageToCheck);
	}
	
	@DisplayName("Testing for function Compute")
	@Test
	void testCompute() {
		List <Integer> lst_grades = new ArrayList<Integer>();
		lst_grades.add(17);
		lst_grades.add(87);
		lst_grades.add(90);
		lst_grades.add(80);
		lst_grades.add(93);
		Grader computeGrade = new Grader();
		try {
			int result = computeGrade.compute(lst_grades);
			assertEquals(result,73);
			assertNotEquals(result,73.4);
			assertNotEquals(result,734);
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
		lst_grades.clear(); //clears the list
		lst_grades.add(40); //adds new elements to the list so other cases can be checked
		lst_grades.add(40);
		lst_grades.add(31);
		Grader  computeGrade1 = new Grader();
		try {
			int result = computeGrade1.compute(lst_grades);
			assertNotEquals(result,71.67);
			assertEquals(result,37);
			assertNotEquals(result,72);
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
	}
	
	@DisplayName("Testing for function Compute_best_grades")
	@Test
	void testCompute_best_grade() {
		List <Integer> lst_grades = new ArrayList<Integer>();
		lst_grades.add(17);
		lst_grades.add(87);
		lst_grades.add(90);
		lst_grades.add(80);
		lst_grades.add(93);
		Grader computeGrade = new Grader();
		try {
			int result = computeGrade.compute(lst_grades);
			assertEquals(result,73);
			assertNotEquals(result,73.4);
			assertNotEquals(result,734);
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
		List <Integer> lst_grades_2 = new ArrayList<Integer>();
		lst_grades_2.add(40);
		lst_grades_2.add(40);
		lst_grades_2.add(31);
		Grader  computeGrade1 = new Grader();
		try {
			int result = computeGrade1.compute_best_grade(lst_grades_2);
			assertNotEquals(result,71.67);
			assertEquals(result,40.0);
			assertNotEquals(result,72);
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
	}

}
