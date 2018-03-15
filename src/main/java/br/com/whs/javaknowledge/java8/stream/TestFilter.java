package br.com.whs.javaknowledge.java8.stream;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.whs.javaknowledge.commons.model.Person;
import br.com.whs.javaknowledge.commons.util.ModelGenerator;

public class TestFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testStartsWith();
	}

	private static void testStartsWith() {
		try {
			Person p = ModelGenerator.createAndFill(Person.class);
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(p);
			System.out.println(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
