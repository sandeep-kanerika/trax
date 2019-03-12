//package com.trax.ratemaneger.amendment.test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.ErrorCollector;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.Spy;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.trax.ratemaneger.amendment.Amendments;
//import com.trax.ratemaneger.amendment.AmendmentsController;
//import com.trax.ratemaneger.amendment.AmendmentsService;
//import com.trax.ratemaneger.test.TestRateManagerMain;
//
//@ContextConfiguration
////@WebMvcTest(AmendmentController.class)
////@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class TestAmendmentController extends TestRateManagerMain {
//
//	private static final Logger logger = LoggerFactory.getLogger(TestAmendmentController.class);
//
//	@InjectMocks
//	Amendments amendmentsTest;
//
//	@Mock
//	AmendmentsService amendmentServiceMock;
//
//	@Spy
//	Set<Amendments> amend = new HashSet<>();
//
//	@Rule		
//    public ErrorCollector collector = new ErrorCollector();	
//	
//	@Before
//	public void init() {
//		MockitoAnnotations.initMocks(this);
//	}
//	
//	@Before
//	public void testSetupAmendment() throws Exception {
//
////    	Set<Amendment> amset = new HashSet<>();
//		amend.add(new Amendments(1, (long) 1, 1231, "description", null, null, null, null, "buyerOrgName",
//				"sellerOrgName", "ratesetName", null, null, null, null, null, null, null, null, null, null, null, null,
//				null, null, null));
//		amend.add(new Amendments(2, (long) 2, 1232, "descriptions", null, null, null, null, "buyerOrgNames",
//				"sellerOrgNames", "ratesetNames", null, null, null, null, null, null, null, null, null, null, null,
//				null, null, null, null));
//		amend.add(new Amendments(4, (long) 2, 1234, "descriptiond", null, null, null, null, "buyerOrgNamed",
//				"sellerOrgNamed", "ratesetNamed", null, null, null, null, null, null, null, null, null, null, null,
//				null, null, null, null));
//		amend.add(new Amendments(5, (long) 1, 1235, "descriptionf", null, null, null, null, "buyerOrgNamef",
//				"sellerOrgNamef", "ratesetNamef", null, null, null, null, null, null, null, null, null, null, null,
//				null, null, null, null));
//		amend.add(new Amendments(6, (long) 2, 1236, "descriptiong", null, null, null, null, "buyerOrgNameg",
//				"sellerOrgNameg", "ratesetNameg", null, null, null, null, null, null, null, null, null, null, null,
//				null, null, null, null));
//	}
////    
////    @Test
////    public void testAmendment() throws Exception {
////        assertThat(RateManagerMainTests.class).isNotNull();
////        when(amendmentServiceMock.getById((long) 6)).thenReturn(amendmentTest);
////        MvcResult result= mvc.perform(get("/amendments/{id}/", 5))
////                .andExpect(status().isOk())
//////                .andExpect(view().name("Amendment"))
//////                .andExpect(MockMvcResultMatchers.model().attributeExists("product"))
//////                .andExpect(model().attribute("product", hasProperty("id", is(1))))
//////                .andExpect(model().attribute("product", hasProperty("productId", is("235268845711068308"))))
////                .andExpect(jsonPath("$.id").value(5))
////                .andDo(print())
////                .andReturn();
////        MockHttpServletResponse mockResponse=result.getResponse();
//////        assertThat(mockResponse.getContentType()).isEqualTo("text/html;charset=UTF-8");
////        assertThat(mockResponse.getContentType()).isEqualTo("application/json;charset=UTF-8");
////        Collection<String> responseHeaders = mockResponse.getHeaderNames();
////        assertNotNull(responseHeaders);
////        assertEquals(1, responseHeaders.size());
////        assertEquals("Check for Content-Type header", "Content-Type", responseHeaders.iterator().next());
//////        String responseAsString=mockResponse.getContentAsString();
//////        assertTrue(responseAsString.contains("Spring Framework Guru"));
//////        verify(amendmentServiceMock, times(1)).getById((long) 4);
////        verifyNoMoreInteractions(amendmentServiceMock);
////    }
//
//	@Test
//	public void testCreateAmendment() {
//		amendmentsTest = new Amendments(5, (long) 1, 123, "description", null, null, null, null, "buyerOrgName",
//				"sellerOrgName", "ratesetName", null, null, null, null, null, null, null, null, null, null, null, null,
//				null, null, null);
//
//		amendmentServiceMock.create(amendmentsTest);
//
//		try {
//			verify(amendmentServiceMock, times(1)).create(amendmentsTest);
//		} catch (Throwable t) {
//			collector.addError(t);
//		}
//	}
//
//	@Test
//	public void testGetAmendment() {
//		when(amendmentServiceMock.getById((long) 5)).thenReturn(new Amendments(5, (long) 1, 123, "description", null,
//				null, null, null, "buyerOrgName", "sellerOrgName", "ratesetName", null, null, null, null, null, null,
//				null, null, null, null, null, null, null, null, null));
//
//		amendmentsTest = amendmentServiceMock.getById(5L);
//
//		try {
//			assertEquals("description", amendmentsTest.getDescription());
//			assertEquals("buyerOrgName", amendmentsTest.getBuyerOrgName());
//			assertEquals("sellerOrgName", amendmentsTest.getSellerOrgName());
//		} catch (Throwable t) {
//			collector.addError(t);
//		}
//	}
//
//	@Test
//	public void testUpdateAmendment() {
//		when(amendmentServiceMock.getById(6l)).thenReturn(new Amendments(6, (long) 1, 123, "descriptions", null,
//				null, null, null, "buyerOrgNames", "sellerOrgNames", "ratesetNames", null, null, null, null, null, null,
//				null, null, null, null, null, null, null, null, null));
//		amendmentsTest = amendmentServiceMock.getById((long) 6);
//		amendmentServiceMock.update(amendmentsTest);
//
//		try {
//			assertEquals("descriptions", amendmentsTest.getDescription());
//			assertEquals("buyerOrgNames", amendmentsTest.getBuyerOrgName());
//			assertEquals("sellerOrgNames", amendmentsTest.getSellerOrgName());
//		} catch (Throwable t) {
//			collector.addError(t);
//		}
//
//		verify(amendmentServiceMock, times(1)).update(amendmentsTest);
//	}
//
//	@Test
//	public void testAmendmentIdNotPresent() {
//
//		when(amendmentServiceMock.getById(90L)).thenReturn(new Amendments());
//		amendmentsTest = amendmentServiceMock.getById(90L);
//		String id = amendmentsTest.getId();
//		try {
//			assertEquals("Amendment Id not found",null,id);
//		} catch (Throwable t) {
//			collector.addError(t);
//		}
//		
//	}
//	
////    @Test
////	public void testAmendmentById() throws Exception {
////    	mvc.perform(MockMvcRequestBuilders.get("/amendments/3").accept(MediaType.APPLICATION_JSON))
//////    	.andExpect(status().isOk())
////		.andExpect(jsonPath("$.id").exists())
////		.andExpect(jsonPath("$.status").exists())
////		.andExpect(jsonPath("$.approvers").exists())
////		.andExpect(jsonPath("$.id").value(3))
////		.andExpect(jsonPath("$.approvers").value("yes"))
////		.andExpect(jsonPath("$.referenceId" , CoreMatchers.is(129)))
//////		.andExpect(jsonPath("$.id").doesNotExist())
////		.andExpect(status().isOk())
////		.andDo(print());
////    	
////	}
////    
////    @Test
////    public void testUpdateAmendment(){
////       String uri = "/amendments";
////       amendmentTest = new Amendment();
////       amendmentTest.setId((long) 9);
////       amendmentTest.setReferenceId((long) 1980);
////       int status = 0;
////	   
////       try {
////    	   	String inputJson = super.mapToJson(amendmentTest);
////    	   	MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
////		      .contentType(MediaType.APPLICATION_JSON_VALUE)
////		      .content(inputJson)).andReturn();
////		   
////		   status = mvcResult.getResponse().getStatus();
////		   doThrow( new ResourceNotFoundException("Resource Not Found Exception!!")).when(amendmentServiceMock).getById(amendmentTest.getId());
////		   assertEquals(200, status);
////		   logger.info(String.valueOf(HttpStatus.OK) , status);
////       } catch (ResourceNotFoundException e) {
////    	   
////    	   logger.error(String.valueOf(HttpStatus.NOT_FOUND), e);
////       }
//////       assertEquals(content, "amendmentTest is updated successsfully");
////       catch (UnsupportedEncodingException e) {
////    	   logger.error(String.valueOf(HttpStatus.BAD_REQUEST), status);
////       } catch (Exception e) {
////    	   logger.error(String.valueOf(e), status);
//////		e.printStackTrace();
////       }
//////       logger.error("ResourceNotFoundException");
////    }
////    
//}
