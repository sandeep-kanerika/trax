package com.kanerika.product.ratemanager.test;

import java.io.IOException;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trax.ratemanager.amendment.AmendmentsController;

//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@AutoConfigureMockMvc
@SpringBootTest
//@Import([IntegrationTestMockingConfig])
public abstract class TestRateManagerMain/* extends Runner */{

	@Autowired
	MockMvc mvc;
	   
	@Autowired
	WebApplicationContext webApplicationContext;
	/*
	 * @Test public void contextLoads() { }
	 */
	protected void setUp() {
	      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	protected String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	}
	protected <T> T mapFromJson(String json, Class<T> clazz) 
			throws JsonParseException, JsonMappingException, IOException {
	      
		ObjectMapper objectMapper = new ObjectMapper();
      	return objectMapper.readValue(json, clazz);
	}
	
}
