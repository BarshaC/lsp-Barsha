package org.howard.edu.lsp.midterm.problem1;
import java.io.*;
import java.util.*;

public class VotingMachine {
	
	static Scanner input = new Scanner(System.in);
	Hashtable<String, Integer> count = new Hashtable<>();
	
	public VotingMachine() {}
	
	public void addCandidate(Hashtable<String,Integer> count) {
		/*
		 * The user is prompted to enter the name of the candidate here.
		 * When at the beginning when the candidate name is entered the vote is 0 by default
		 */
		System.out.println("Name of the candidate: ");
		String name = input.nextLine();
		count.put(name, 0);
		
		} 

	public void castVotes(Hashtable<String, Integer> count) {
		/*
		 * 
		 */
		System.out.println("Enter candidate name to cast vote: ");
		input.nextLine();
		String currentEnteredCandidate = input.nextLine();
		if (count.containsKey(currentEnteredCandidate)) {
			int updatedVote = count.get(currentEnteredCandidate);
			updatedVote++;
			count.put(currentEnteredCandidate, updatedVote);					
		}
		else {
			System.out.println("CANDIDATE NOT FOUND.ENTER CORRECT NAME AGAIN!");
		}
	}

	public int getVotes(String name)  throws UnknownCandidateException {
		int output = 0;
		for (Map.Entry<String, Integer> entry: count.entrySet()) {
			if (!(count.containsKey(name))){
				throw new UnknownCandidateException("Cannot find the Candidate!");
		}
			else
				output =  entry.getValue();	
		}
		return output;
	}
	
	public int sum(Hashtable<String, Integer> count)  throws UnknownCandidateException {
		int totalVote = 0;
		for (Map.Entry<String, Integer> entry: count.entrySet()) {
			totalVote = totalVote + entry.getValue();
		}
		return totalVote;
	}
}
