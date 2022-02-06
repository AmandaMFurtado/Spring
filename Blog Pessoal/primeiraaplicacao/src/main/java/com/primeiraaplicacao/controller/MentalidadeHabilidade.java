package com.primeiraaplicacao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequestMapping("/mentalidade")
public class MentalidadeHabilidade {
	
	public String Mentalidade() {
		return "Atenção aos Detalhes";
	}
	
	@RequestMapping("/habilidade")
	public String Habilidade() {
		return "Persistencia";
	}

}
