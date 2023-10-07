package com.banco.bancoJava2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/bancoricardo")
public class TestController {
	
	@GetMapping("/teste")
	public String teste() {
		return "<h1 style='color:blue;'>Teste</h1>";
	}

}
