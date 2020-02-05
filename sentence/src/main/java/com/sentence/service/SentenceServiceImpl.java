package com.sentence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sentence.dao.AdjectiveClient;
import com.sentence.dao.ArticleClient;
import com.sentence.dao.NounClient;
import com.sentence.dao.SubjectClient;
import com.sentence.dao.VerbClient;

/**
 * Build a sentence by assembling randomly generated subjects, verbs, 
 * articles, adjectives, and nouns.  The individual parts of speech will 
 * be obtained by calling the various DAOs.
 */
@Service
public class SentenceServiceImpl implements SentenceService {

	@Autowired WordService wordService;
	

	/**
	 * Assemble a sentence by gathering random words of each part of speech:
	 */
	public String buildSentence() {
		return  
				String.format("%s %s %s %s %s.",
					wordService.getSubject(),
					wordService.getVerb(),
					wordService.getArticle(),
					wordService.getAdjective(),
					wordService.getNoun() )
				;
	}

	
}
