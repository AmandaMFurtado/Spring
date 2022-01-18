package com.segundaaplicacao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequestMapping("/aprendizagem")
public class ObjetivosAprendizagem {
	
	public String Objetivos(){
		
		return "Conhecer as ferramentas de utilização do Spring ";
	}
}
