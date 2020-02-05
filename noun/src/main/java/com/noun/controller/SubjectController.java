package com.noun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SubjectController {
	@Value("${words}")
	private String words;
	@Autowired
	private RestTemplate restTemplate;
	
	  @GetMapping("/")
	  public @ResponseBody String getWord() {
	    String[] wordArray = words.split(",");
	    int i = (int)Math.round(Math.random() * (wordArray.length - 1));
	    return wordArray[i];
	  }
	
	
}
