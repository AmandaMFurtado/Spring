package com.helloword.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hallo")

public class HalloController {
	
	public String Hallo() {
		return "Hallo Word";
	}

}
