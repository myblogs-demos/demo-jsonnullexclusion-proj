package com.myblogs.jsonexcludenull.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.myblogs.jsonexcludenull.model.RegistrationResponse;

@SpringBootApplication
public class DemoApplication {
	
   private static boolean toExcludeNull;
	  
   @Value("${config.response.json.format.exclude_null}") 
   public void setToExcludeNull(boolean value) { 
	   	toExcludeNull = value; 
   }
	 
   public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		RegistrationResponse regResp = new RegistrationResponse();
		
		regResp.setSuccess(true);
		regResp.setErrorCode(null);
		regResp.setData("testdata");
		regResp.setMessage("Success");
		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		  
		if (toExcludeNull) mapper.setSerializationInclusion(Include.NON_NULL); 
		else mapper.setSerializationInclusion(Include.ALWAYS);
		        
		String regRespStr = null;
		try {
			regRespStr = mapper.writeValueAsString(regResp);
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		System.out.println("Formatted JSON Response: " + regRespStr);
	}
	
	/*
	 * @Bean public ObjectMapper objectMapper() { ObjectMapper mapper = new
	 * ObjectMapper();
	 * 
	 * mapper.enable(SerializationFeature.INDENT_OUTPUT);
	 * 
	 * if (toExcludeNull) mapper.setSerializationInclusion(Include.NON_NULL); else
	 * mapper.setSerializationInclusion(Include.ALWAYS);
	 * 
	 * return mapper; }
	 */

}
