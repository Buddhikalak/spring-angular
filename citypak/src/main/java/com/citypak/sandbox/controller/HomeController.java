/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.citypak.sandbox.controller;

import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Buddhika Lakshan
 */
@RestController
public class HomeController {
	@RequestMapping(value="/")
	public ModelAndView listContact(ModelAndView model) throws IOException{
		model.setViewName("index");
		return model;
	}
	
	
}

