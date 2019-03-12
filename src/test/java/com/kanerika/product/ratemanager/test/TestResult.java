//package com.trax.ratemaneger.test;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Test;
//import org.junit.runner.JUnitCore;
//import org.junit.runner.Result;
//import org.junit.runner.RunWith;
//import org.junit.runner.notification.Failure;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import com.trax.ratemaneger.amendment.test.TestAmendmentController;		
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@AutoConfigureMockMvc
//@SpringBootTest
//public class TestResult /* extends TestAmendmentController */{
//
//	private static final Logger logger = LoggerFactory.getLogger(TestResult.class);
//
//	@Test
//	public void TestResults(){
//		Result result = JUnitCore.runClasses(TestAmendmentController.class);
//		for (Failure failure : result.getFailures()) {
//			logger.error(failure.toString());
//		}
////		System.out.println("Amendment Test Case Result  : " + result.wasSuccessful());
//		
//		assertEquals(true , result.wasSuccessful());
//	}
//}