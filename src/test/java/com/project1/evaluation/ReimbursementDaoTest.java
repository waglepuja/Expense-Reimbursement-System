package com.project1.evaluation;

import com.project1.dao.*;
import com.project1.model.Reimbursement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Timestamp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class ReimbursementDaoTest {

	private ReimbursementDao reimDao;
	
	// This annotation allows this method to run before the class is instantiated. 
	// That's why this class has to be static so that this can run before the above code.
		
	@BeforeAll
	public static void setUpBeforeClass() { //setUpBeforeClass is a method name, we can name this anything
		System.out.println("..........Before Class..........");
	}
		 
	// Used for tearing down or closing resources that are setup in the method with the BeforeAll
	//in JUnit 4 this was called AfterClass
	@AfterAll
	public static void tearDownAfterClass() {
		System.out.println("........After Class............");
	}
	
	// This annotation will allow method execute before each individual test
	// This is used when setting up for mocks. It does not need the word static
	// this used to be called Before in JUnit4
	@BeforeEach
	public void setUp() { 
		System.out.println("...........Before Method........");
		reimDao = new ReimbursementDao(); // creating a new instance of the ReimbursementDao class
	}
		
	// This annotation will allow the method to execute after each individual test. It is used to close resources opened in the 
	// the method with BeforeEach
	@AfterEach
	public void tearDown() {
		System.out.println(".........After Method...........");
	}
	
	@Test
	@Order(1) // Order One
	public void getReimbursementById() { // testing method
		System.out.println("in get reimbursement by id test");		
		
				
		Reimbursement reimbursement = new Reimbursement();
		reimbursement.setAmount(100.00);					
		//2021-05-02 23:01:34
		reimbursement.setReimbusermentSubmitted(java.sql.Timestamp.valueOf("2021-05-02 23:01:34.288"));
		reimbursement.setReimbursementResolved(null);
		reimbursement.setReimbursementDescription("Lunch with client");
		reimbursement.setReceipt((byte) 1);
		reimbursement.setAuthorID(3);
		reimbursement.setResolverId(4);
		reimbursement.setReimbursementStatusId(2);
		reimbursement.setReimbursementTypeId(3);
		reimbursement.setReimbursmentID(0);
		reimbursement.setAuthor(null);
		reimbursement.setResolver(null);
		
		Reimbursement reimb_result = reimDao.getReimbursementById(31);
		
		// checks if the result is the same as we expected
		assertEquals(reimbursement.getReimbusermentSubmitted(), reimb_result.getReimbusermentSubmitted());
		assertEquals(reimbursement.getReceipt(), reimb_result.getReceipt());
		assertEquals(reimbursement.getAuthor(), reimb_result.getAuthor());
		assertEquals(reimbursement.getResolverId(), reimb_result.getResolverId());
		assertEquals(reimbursement.getReimbursementStatusId(), reimb_result.getReimbursementStatusId());
		assertEquals(reimbursement.getReimbursementTypeId(), reimb_result.getReimbursementTypeId());
		assertEquals(reimbursement.getReimbursmentID(), reimb_result.getReimbursmentID());
		assertEquals(reimbursement.getAuthorID(), reimb_result.getAuthorID());
		assertEquals(reimbursement.getResolver(), reimb_result.getResolver());
		
	}
}
