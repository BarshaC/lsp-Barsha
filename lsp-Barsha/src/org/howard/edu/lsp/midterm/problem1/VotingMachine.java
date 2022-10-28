package org.howard.edu.lsp.midterm.problem1;
import java.io.*;
import java.util.*;

public class VotingMachine {
	
	public VotingMachine() {
		
	}
	
	public Hashtable<String,Integer> getmap() {
        return this.getmap();
    }
	
	public void addCandidate(String name) {
		// Add a candidate to the list, initialize number of votes to 0
		Hashtable< String, Integer> map = new Hashtable<>(); 
	} 

	public void castVotes(String name, int votes) {
		// Cast votes to the candidate with the given name
	}

	public int getVotes(String names)  throws UnknownCandidateException {
		return 0;
		// Return the number of votes for a given candidate.  Throws
// UnknownCandidateException if name not present.  Make this a 
// checked exception.
	}

	public int sum() {
		return 0;
		// Return the total number of votes for all candidates.	
	}


}
