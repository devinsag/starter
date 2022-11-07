package com.architect.starter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ContentController {

	@GetMapping("/")
	public String getIndex() {
		return "index";
	}

}
