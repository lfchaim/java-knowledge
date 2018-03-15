package br.com.whs.javaknowledge.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.whs.javaknowledge.commons.model.Genre;
import br.com.whs.javaknowledge.commons.model.Person;
import br.com.whs.javaknowledge.commons.util.JsonUtil;
import br.com.whs.javaknowledge.commons.util.ModelGenerator;

public class TestFilter {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		for( int i = 0; i < 10; i++ ) {
			try {
				list.add(ModelGenerator.createAndFill(Person.class));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		listFemale(list);
		older(list);
		average(list);
	}

	private static void listFemale(List<Person> list){
		List<Person> listFemale = list.stream()
	        .filter(p -> p.getGenre().equals(Genre.F))
	        .collect(Collectors.toList());
		System.out.println(listFemale.size()+"\n"+JsonUtil.getJson(listFemale));
	}
	
	private static void older(List<Person> list){
		Optional<Person> old = list.stream()
			.max((p1, p2) -> p1.getAge().compareTo(p2.getAge()));
		System.out.println("The older person is: "+old.get().getFirstName()+" age: "+old.get().getAge());
	}
	
	private static void average(List<Person> list){
		Double media = list.stream().collect(Collectors.averagingDouble(p -> p.getAge()));
		System.out.println("The average age is: "+media);
	}
	
}
