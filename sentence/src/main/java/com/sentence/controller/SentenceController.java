package com.sentence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sentence.service.SentenceService;

@RestController
public class SentenceController {

@Autowired SentenceService sentenceService;
	
	
	/**
	 * Display a small list of Sentences to the caller:
	 */
	@GetMapping("/sentence")
	public @ResponseBody String getSentence() {
	  return 
		"<h3>Some Sentences</h3><br/>" +	  
		sentenceService.buildSentence() + "<br/><br/>" +
		sentenceService.buildSentence() + "<br/><br/>" +
		sentenceService.buildSentence() + "<br/><br/>" +
		sentenceService.buildSentence() + "<br/><br/>" +
		sentenceService.buildSentence() + "<br/><br/>"
		;
	}
	
	
	
//	@Autowired
//	private RestTemplate restTemplate;
//
//	@GetMapping("/sentence")
//	public @ResponseBody String getSentence() {
//
//		return getWord("application-subject") + " " + getWord("application-verb") + " " + getWord("application-article")
//				+ " " + getWord("application-adjective") + " " + getWord("application-noun") + ".";
//	}
//
//	public String getWord(String service) {
////		List<ServiceInstance> list = client.getInstances(service);
////	    if (list != null && list.size() > 0 ) {
////	      URI uri = list.get(0).getUri();
////	  if (uri !=null ) {
////	    return (new RestTemplate()).getForObject(uri,String.class);
////	  }
////	    }
////	    return null;
////	}
//		return restTemplate.getForObject("http://" + service, String.class);
//	}
}