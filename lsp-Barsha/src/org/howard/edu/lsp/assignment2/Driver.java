package org.howard.edu.lsp.assignment2;


import java.util.Arrays;

/*
 * For the testing if the coding, Driver() calls out to the Combinations
 * On running, first test case, this is the outout:
 * List of numbers: [5, 5, 15, 10]
 * Target : 15
 * Combinations are: 
 * [2]			 15 -> 15
 * [3, 0]		10 + 5 -> 15
 * [3, 1]		10 + 5 -> 15
 * 
 *
 * 
 */

public class Driver {
	public static void main(String[] args) {
		Combinations comb = new Combinations();
		comb.compute(new int[] {5,5,15,10}, 15);
		comb.compute(new int[] {1,2,3,4,5,6}, 6);
		comb.compute(new int[] {1,2,3,4}, 100);
		comb.compute(new int[] {},14);
		comb.compute(new int[] {1,4,5,7,10}, 10);
		int[] arr = new int[100];
		for (int i = 0; i <100; ++i) {
			arr[i] = i;
		}
		comb.compute(arr, 37);
	}
}