package com.springmvc.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/hi")
	public String hello() {
		return "hello";
	}
}
