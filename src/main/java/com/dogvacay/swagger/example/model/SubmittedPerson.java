package com.dogvacay.swagger.example.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;

@ApiModel
public class SubmittedPerson extends Person{
	
	private String submitted;
	
	
	public SubmittedPerson(Person person) {
		super(person.getFirstName(), person.getLastName(), person.getAge());
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		Date date = new Date();
		String formattedDate = sdf.format(date);
		this.setSubmitted(formattedDate);
		
    }

	public String getSubmitted(){
		return submitted;
	}
	public void setSubmitted(String submitted){
		this.submitted = submitted;
	}

}