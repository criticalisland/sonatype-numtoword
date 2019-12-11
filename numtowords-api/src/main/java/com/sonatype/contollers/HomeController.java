package com.sonatype.contollers;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sonatype.Constants;
import com.sonatype.domain.Word;
import com.sonatype.service.WordService;

@RestController
public class HomeController {

	@Autowired
	private WordService wordService;

	@GetMapping("/numtoword/{wordNum}")
	Word findOne(@PathVariable String wordNum) {

		if (wordNum.length() > 14 || (Pattern.compile("[^0-9,-]").matcher(wordNum).find())) {
			wordNum = Constants.badRequest;
			/*
			 * it is 14 because the max integer in negative with commas has 14 characters,
			 * example: -1,234,567,890. It is still processed because other possible cases
			 * are handled in the service, thus, reducing the code for additional exception
			 * handling.
			 */
		}
		return wordService.getWordJSON(wordNum);

	}

}
