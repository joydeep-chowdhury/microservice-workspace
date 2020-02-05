package com.sentence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sentence.dao.AdjectiveClient;
import com.sentence.dao.ArticleClient;
import com.sentence.dao.NounClient;
import com.sentence.dao.SubjectClient;
import com.sentence.dao.VerbClient;
import com.sentence.domain.Word;

@Service
public class WordServiceImpl implements WordService {
	@Autowired
	VerbClient verbClient;
	@Autowired
	SubjectClient subjectClient;
	@Autowired
	ArticleClient articleClient;
	@Autowired
	AdjectiveClient adjectiveClient;
	@Autowired
	NounClient nounClient;

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackSubject")
	public String getSubject() {
		return subjectClient.getWord();
	}

	@Override
	public String getVerb() {
		return verbClient.getWord();
	}

	@Override
	public String getArticle() {
		return articleClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackAdjective")
	public String getAdjective() {
		return adjectiveClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackNoun")
	public String  getNoun() {
		return nounClient.getWord();
	}

	public String  getFallbackSubject() {
		return "Fallback subject";
	}

	public String getFallbackAdjective() {
		return "Fallback adjective";
	}

	public String getFallbackNoun() {
		return "Fallback noun";
	}
}
