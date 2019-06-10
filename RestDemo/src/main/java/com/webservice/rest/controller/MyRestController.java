package com.webservice.rest.controller;


import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.rest.pojo.Result;
import com.webservice.rest.pojo.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class MyRestController {
	@GetMapping("greet1")
	public String greet1User() {
		return "Good morning!!!"; 
	}
	
	@GetMapping("greet2")
	public String greet2User(@RequestParam("name") String name) {
		return name+", Good morning!!!"; 
	}
	
	@PostMapping("greet3")
	public String greet3User(@RequestParam("name") String name) {
		return name+", Good morning!!!"; 
	}
	
	@GetMapping("greet4/wish/{name}")
	public String greet4User(@PathVariable("name") String name) {
		return name+", Good morning!!!"; 
	}
	
	@GetMapping(value = "greet5",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public@ResponseBody User getUserDetails() {
		User u=new User();
		u.setUserId(1001);
		u.setUserName("User1");
		u.setEmail("user1@gmail.com");	
		return u;
	}
	
	@PostMapping(value="greet6",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public String saveUserDetails(@RequestBody User user) {
		System.out.println("User : "+user);
		return "Data saved...";
	}
	
	@PostMapping(value="greet7",produces = MediaType.APPLICATION_XML_VALUE ,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Accepts JSON Sends XML")
	public Result saveUserDetailsJSONReqXMLRes(@RequestBody User user) {
		System.out.println("User : "+user);
		Result result=new Result();
		result.setMsg("Data Saved");
		result.setDate(new Date());
		return result;
	}
}
