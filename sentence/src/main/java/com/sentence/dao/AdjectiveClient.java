package com.sentence.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.sentence.domain.Word;

@FeignClient("APPLICATION-ADJECTIVE")
public interface AdjectiveClient {

	@GetMapping("/")
	public String getWord();
	
	

}
