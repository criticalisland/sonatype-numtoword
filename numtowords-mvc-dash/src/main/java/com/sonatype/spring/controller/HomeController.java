package com.sonatype.spring.controller;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amazonaws.util.EC2MetadataUtils;
import com.sonatype.spring.Constants;
import com.sonatype.spring.model.Numbers;

@Controller
@RequestMapping(value = "/")
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getForm(Model model) {
		model.addAttribute("numbers", new Numbers());
		return "numberConsole";
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String validateForm(@Valid Numbers numbers, BindingResult result) {
		if (result.hasErrors() || (Pattern.compile("[^0-9,-]").matcher(numbers.getNumberStr()).find())) {
			// the string only contains numbers and commas

			return "numberConsole";
		}

		String inline = "";
		String words = "";
		int responsecode = 0;
		try {
			String confFile = "applicationContext.xml";
			ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);
			HostNameAPI hostConfig = (HostNameAPI) context.getBean("hostURLapi");
			context.close();
			URL url = new URL(hostConfig.hostName + numbers.getNumberStr());

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod(Constants.requestGET);

			conn.connect();

			responsecode = conn.getResponseCode();

			if (responsecode != Constants.connStatusOK) {
				words = Constants.errServiceConnection;
			} else {
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();

				}

				sc.close();
			}

			conn.disconnect();
		} catch (Exception e) {
			return "numberConsole";
		}

		JSONObject obj = new JSONObject(inline);

		words = obj.getString("words");

		numbers.setNumberWords(words);
		numbers.setIntancesName(
				"Console Instance ID:" + EC2MetadataUtils.getInstanceId() + " API: " + obj.getString("instanceName"));

		return "wordConsole";
	}

}
