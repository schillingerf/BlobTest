package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.io.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;

@RestController
public class GreetingController {

	private  String template = "";
	private  AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		try {
			if (template.length() == 0) {
			File file = new File("/tmp/fixed_1000.json");
			template = FileUtils.readFileToString(file);
			System.out.println("Read in " + template.length());
			return template;
			} else {
			return template;
			}
			} catch (Exception e) {
			return "";
			}
	}
}
