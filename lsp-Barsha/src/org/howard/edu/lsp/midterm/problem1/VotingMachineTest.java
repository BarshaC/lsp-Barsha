package org.howard.edu.lsp.midterm.problem1;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Hashtable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;

class VotingMachineTest {
	@DisplayName("Test case for addcandidate")
	@Test
	void testAddCandidate() {
		VotingMachine vm = new VotingMachine();
		Hashtable<String, Integer> count = new Hashtable<>();
		count.put("Rahul", 0);
		vm.addCandidate(count);
		assertFalse(count.isEmpty());
	}
	@DisplayName("Test case for CastVote")
	@Test
	void testCastVotes() {
		VotingMachine vm = new VotingMachine();
		Hashtable<String, Integer> count = new Hashtable<>();
		count.put("Rahul", 1);
		vm.addCandidate(count);
		
	}
	@DisplayName("Test case for getVote")
	@Test
	void testGetVotes() {
		VotingMachine vm = new VotingMachine();
		Hashtable<String, Integer> count = new Hashtable<>();
		count.put("Vinit", 1);
		count.put("Rahul", 1);
		count.put("Vaisnav",1);
		count.put("Vaisnav",1);
		count.put("Vaisnav",1);
		try {
			assertEquals(vm.getVotes("Vaisnav"),3);
		} catch (UnknownCandidateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@DisplayName("Test case for testSum")
	@Test
	void testSum() throws UnknownCandidateException {
		VotingMachine vm = new VotingMachine();
		Hashtable<String, Integer> count = new Hashtable<>();
		count.put("Vinit", 1);
		count.put("Rahul", 1);
		count.put("Vaisnav",1);
		count.put("Vaisnav",1);
		count.put("Vaisnav",1);
		assertEquals(vm.sum(count),3);
	}
	@Test
	@DisplayName("Testing Remove Exception")
	void testGetVoteThrowsException() {
		String expectedError;
		String messageToPrint;
		VotingMachine vm = new VotingMachine();
		Hashtable<String, Integer> count = new Hashtable<>();
		count.put("Vinit", 1);
		count.put("Rahul", 1);
		count.put("Vaisnav",1);
		count.put("Vaisnav",1);
		count.put("Vaisnav",1);
		Exception exception = assertThrows(UnknownCandidateException.class, ()->{vm.getVotes("Vaisnav");});
		expectedError = "Can't remove anything. The set is Empty!";
		String checkError = "The set is not Empty.";
		messageToPrint = exception.getMessage();
		assertEquals(expectedError, messageToPrint);
		assertNotEquals(checkError, messageToPrint);
	}

}
