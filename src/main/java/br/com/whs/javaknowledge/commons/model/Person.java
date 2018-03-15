package br.com.whs.javaknowledge.commons.model;

import java.util.Calendar;
import java.util.Date;

public class Person {

	private String firstName;
	private String lastName;
	private Date   bornDate;
	private Genre  genre;
	
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBornDate() {
		return bornDate;
	}
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}
    
	public Integer getAge() {
		Calendar now = Calendar.getInstance();
		Calendar born = Calendar.getInstance();
		born.setTime(bornDate);
		return now.get(Calendar.YEAR)-born.get(Calendar.YEAR);
	}
}
