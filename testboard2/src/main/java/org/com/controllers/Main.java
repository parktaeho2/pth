package org.com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Main {
	
	
	@RequestMapping("/main")
	public ModelAndView mainView(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("NewFile");
		return mv;
	}

}
