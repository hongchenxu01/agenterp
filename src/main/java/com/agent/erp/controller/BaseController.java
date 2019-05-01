package com.agent.erp.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class BaseController {
	
	@InitBinder
	protected void init(WebDataBinder webDataBinder) {
		
	}

}
