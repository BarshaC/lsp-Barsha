package org.howard.edu.lsp.assignment5;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;


class IntegerSetTest { 
	@Test
	@DisplayName("Test case for Clear")
	void testClear() {
		IntegerSet s1 = new IntegerSet();
		s1.add(100);
		s1.clear();
		assertTrue(s1.isEmpty());
		s1.add(1);
		assertFalse(s1.isEmpty());
	}

	@Test
	@DisplayName("Test case for Length") 
	void testLength() {
		IntegerSet s10 = new IntegerSet();
		s10.add(0);
		s10.add(2);
		s10.add(12);
		s10.add(13);
		assertTrue(4 == s10.length());
		assertFalse(5 == s10.length());
	}

	@Test
	@DisplayName("Test case for Contains")
	void testContains() {
		IntegerSet s3 = new IntegerSet();
		s3.add(0);
		s3.add(2);
		s3.add(12);
		s3.add(13);
		assertTrue(true == s3.contains(12));
		assertFalse(false == s3.contains(13));
		assertTrue(true == s3.contains(0));
		assertTrue(false == s3.contains(1));
	}

	@Test
	@DisplayName("Test case for Largest")
	void testLargest() throws IntegerSetException {
		IntegerSet s2 = new IntegerSet();
		s2.add(0);
		s2.add(2);
		s2.add(12);
		s2.add(13);
		s2.add(14);
		assertTrue(14 == s2.largest());
		assertFalse(13 == s2.largest());
		s2.remove(1);
		assertFalse(13 == s2.largest());
		assert(14 == s2.largest());			
	}
	
	@Test
	@DisplayName("Testing largest Exception")
	void testLargestThrowsException() {
		String expectedError;
		String messageToPrint;
		IntegerSet s1 = new IntegerSet();
		Exception esception = assertThrows(IntegerSetException.class, ()->{s1.largest();});
		expectedError = "Can't find the largest. The set is Empty.";
		String checkError = "Can't find the smallest. The set is Empty.";
		messageToPrint = esception.getMessage();
		assertEquals(expectedError, messageToPrint);
		assertNotEquals(checkError, messageToPrint);
	}
	@Test
	@DisplayName("Test case for Smallest")
	void testSmallest() throws IntegerSetException {
		IntegerSet s4 = new IntegerSet();
		s4.add(0);
		s4.add(2);
		s4.add(12);
		s4.add(13);
		s4.add(14);
		assertTrue(0 == s4.smallest());
		assertFalse(13 == s4.smallest());
		s4.remove(0);
		assertTrue(2 == s4.smallest());
		s4.clear();
		s4.add(5);
		assertTrue(5 == s4.smallest());
		s4.add(-1);
		assertTrue(-1 == s4.smallest());			
	}
	
	@Test
	@DisplayName("Testing smallest Exception")
	void testSmallestThrowsException() {
		String expectedError;
		String message;
		String checkError;
		IntegerSet s1 = new IntegerSet();
		Exception esception = assertThrows(IntegerSetException.class, ()->{s1.smallest();});
		expectedError = "Can't find smallest element. The set is Empty";
		checkError = "Can't find the largest. The set is Empty.";
		message = esception.getMessage();
		assertEquals(expectedError, message);
		assertNotEquals(checkError, message);
	}
	

	@Test
	@DisplayName("Testing for Add")
	void testAdd() {
		IntegerSet s1 = new IntegerSet();
		s1.add(1);
		s1.add(1);
		s1.add(2);
		s1.add(3);
		assertEquals("[1, 2, 3]", s1.toString());
		assertNotEquals("1", s1.toString());
		assertNotEquals(1, s1.toString());
		assertNotEquals("1234", s1.toString());
	}

	@Test
	@DisplayName("Testing for Remove")
	void testRemove() throws IntegerSetException{
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.remove(3);
		assertEquals("[1, 2, 3]", set1.toString());
		assertNotEquals("[100, 100, 100]", set1.toString());
	}
	@Test
	@DisplayName("Testing Remove Exception")
	void testRemoveThrowsException() {
		String expectedError;
		String messageToPrint;
		IntegerSet s1 = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, ()->{s1.remove(1);});
		expectedError = "Can't remove anything. The set is Empty!";
		String checkError = "The set is not Empty.";
		messageToPrint = exception.getMessage();
		assertEquals(expectedError, messageToPrint);
		assertNotEquals(checkError, messageToPrint);
	}

	@Test
	@DisplayName("Test case for InterSection of set")
	void testIntersection() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set2.add(3);
		set2.add(4);
		set2.add(5);
		set1.intersection(set2);
		assertEquals("[3]", set1.toString());
		assertNotEquals("[]", set1.toString());
		assertNotEquals("[1, 2, 3, 4, 5]", set1.toString());
		
	}

	@Test
	@DisplayName("Test case for Union of set")
	void testUnion() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set2.add(3);
		set2.add(4);
		set2.add(5);
		set1.union(set2);
		assertNotEquals("[1, 3, 3]", set1.toString());
		assertNotEquals("[]", set1.toString());
		assertEquals("[1, 2, 3, 4, 5]", set1.toString());
	}

	@Test
	@DisplayName("Test case for Diff method")
	void testDiff() {
		IntegerSet s1 = new IntegerSet();
		IntegerSet s2 = new IntegerSet();
		s1.add(0);
		s1.add(1);
		s1.add(2);
		s1.add(3);
		s2.add(3);
		s2.add(4);
		s2.add(25);
		s1.diff(s2);
		s2.diff(s1);
		assertEquals("[0, 1, 2]",s1.toString());
		assertEquals("[3, 4, 25]",s2.toString());
		assertEquals("[3, 4, 25]",s2.toString());
		assertNotEquals("[0, 1]",s1.toString());
		assertNotEquals("[0, 1, 2]",s2.toString());
		IntegerSet s7 = new IntegerSet();
		IntegerSet s8 = new IntegerSet();
		int[] setNums = {1,2,3,4};
		for (int x = 0; x < setNums.length; x++) {
			s7.add(setNums[x]);
		}
		s8.add(1);
		s8.add(6);
		s8.add(7);
		s7.diff(s8);
		s8.add(9);
		s8.diff(s7);
		assertEquals("[2, 3, 4]",s7.toString());
		assertEquals("[1, 6, 7, 9]", s8.toString());
		
	}

	@Test
	@DisplayName("Test case for IsEmpty method (boolean)")
	void testIsEmpty() {
		IntegerSet s1 = new IntegerSet();
		assertTrue(s1.isEmpty());
		s1.add(0);
		assertFalse(s1.isEmpty());
	}

	@Test
	@DisplayName("Test case for ToStrings")
	void testToString() throws IntegerSetException {
		IntegerSet set6 = new IntegerSet();
		set6.add(1);
		set6.add(2);
		set6.add(4);
		set6.remove(0);
		assertEquals("[2, 4]", set6.toString());
		assertNotEquals("[1, 2, 4]", set6.toString());
		assertNotEquals("124", set6.toString());		
	}
	@Test
	@DisplayName("Test case for equals (boolean)")
	public void testEquals() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set2.add(1);
		set2.add(2);
		set2.add(3);
		assertEquals(set2.toString(),set1.toString());
		
	}
		
}
