package br.com.whs.javaknowledge.commons.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	public static String getJson(Object obj) {
		ObjectMapper om = new ObjectMapper();
		String ret = null;
		try {
			ret = om.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
}
