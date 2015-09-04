package com.dogvacay.swagger.example.http;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dogvacay.swagger.example.model.Person;
import com.dogvacay.swagger.example.model.SubmittedPerson;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
public class ExampleController {

	/**
	 * 
	 * @param foo
	 * @return text/plain
	 * 
	 *         Simple echo "GET" query String service, pass parameter, value in,
	 *         or array or values, in a key value format.
	 * 
	 *         Uses @ApiOperation, @ApiResponses, @ApiResponse and @ApiParam
	 *         Swagger annotations.
	 * 
	 */
	@ApiOperation(httpMethod = "GET", value = "Basic RESTful query GET service", notes = "Simple example of a GET, query string method.", produces = "text/plain")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful GET command", response = String.class),
			@ApiResponse(code = 400, message = "Fields have validation errors") })

	@RequestMapping(value = "/echo", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String echo(
			@ApiParam(value = "Example values that could be considered for filter", required = true, defaultValue = "available", allowableValues = "bar,more-bars,a-lot-more-bars", allowMultiple = true) @RequestParam("foo") String foo) {

		// simple concatenation of "foo" paramter and timestamp
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		Date date = new Date();
		String formattedDate = sdf.format(date);
		return foo + " " + formattedDate;
	}

	/**
	 * 
	 * @param Person
	 * @return SubmittedPerson "POST" RESTful service, pass an Object ,
	 *         marshalled to a JSON representation of Person object returns an
	 *         inherited object SubmittedPersob in a key value format.
	 * 
	 *         Uses @ApiOperation, @ApiResponses, @ApiResponse and @ApiParam
	 *         Swagger annotations.
	 * 
	 */

	@ApiOperation(httpMethod = "POST", value = "Example Object (Person) RESTful POST  service", notes = "Example of JSON POST method.", response = SubmittedPerson.class, produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfule POST command", response = SubmittedPerson.class),
			@ApiResponse(code = 400, message = "Fields have validation errors") })

	@RequestMapping(value = "/submitperson", method = RequestMethod.POST)
	public SubmittedPerson personSubmit(@RequestBody Person person) {

		// Do something with Person
		SubmittedPerson submittedPerson = new SubmittedPerson(person);

		return submittedPerson;
	}
}
