package com.chithu.app.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Pojo2json {
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	private Pojo2json() {
		
	}
	public static ObjectMapper pojotoJSON() {
		 return mapper.enable(SerializationFeature.INDENT_OUTPUT);
	}

}
