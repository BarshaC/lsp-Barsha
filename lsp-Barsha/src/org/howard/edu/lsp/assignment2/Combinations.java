package org.howard.edu.lsp.assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations{
	/*
	 * Combinations can take set of numbers in form of integer array and Target integer.
	 * And return set of indices which makes up that target number.
	 * 
	 * compute() - takes in the list of integers and target number and prints out the set of indexes
	 * recurr() - recursive function that prints out all sublist using DP[][](Dynamic Programming)where
	 * vector num[] stores the current sets
	 * printAllComb() - This helps in printing out all sublist filling out all possible entries to the DP
	 * At the end traversing DP[][] gives us the all the paths
	 */
	static boolean[][]DP;
	public void compute(int[] input, int sum) {
		int n = input.length;
		ArrayList<Integer> list = new ArrayList<Integer>(input.length);
		for (int i = 0; i < input.length; i++)
		  list.add(Integer.valueOf(input[i]));
		System.out.println("List of numbers: " + list);
		System.out.println("Target : " + sum);
		System.out.println("Combinations are: ");
		if (input.length == 0) {      
			System.out.println("[]");	//For the case when empty list is passed
		}
		printAllComb(input,n,sum);
		System.out.println("****************************************");
	}
		
	static void display(ArrayList<Integer> v) {
		System.out.println(v);
	}
	static void recurr(int input[], int i, int sum, ArrayList<Integer> num) {
		if (i ==0 && sum !=0 && DP[0][sum]) {
			num.add(i);
			display(num);
			num.clear();
			return;
		}
		if (i == 0 && sum == 0) {
			display(num);
			num.clear();
			return;
		}
		if (DP[i-1][sum]) {
			ArrayList<Integer> b = new ArrayList<>();
			b.addAll(num);
			recurr(input, i-1, sum, b);
		}
		if (sum >= input[i] && DP[i-1][sum-input[i]]) {
			num.add(i);
			recurr(input, i-1,sum-input[i],num);
		}
	}
	 static void printAllComb(int input[], int n, int sum) {
		if (n ==0 || sum <0) {
			return;
		}
		DP = new boolean[n][sum +1];
		for (int i =0; i<n; ++i) {
			DP[i][0] = true;
		}
		if (input[0] <=sum) {
			DP[0][input[0]] = true;
		}
		for (int i =1; i <n; ++i)
			for (int j = 0; j <sum +1; ++j)
				DP[i][j] = (input[i]<= j) ? (DP[i-1][j] || DP[i-1][j-input[i]]) : DP[i-1][j];
		if (DP[n-1][sum] == false){
			System.out.println("[]" );
			return;
		}
		ArrayList<Integer> arr = new ArrayList<>();
		recurr(input, n-1, sum, arr);				
	}
	
}
