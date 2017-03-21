package org.com.controllers;

import javax.inject.Inject;

import org.com.service.BoardService;
import org.com.vo.PageMaker;
import org.com.vo.SearchCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {
	
	private static final Logger logger=LoggerFactory.getLogger(SearchBoardController.class);
	
	@Inject
	private BoardService service;
	
	ModelAndView modelAndView = new ModelAndView();
	
	
	@RequestMapping(value ="/list", method = RequestMethod.GET)
	public ModelAndView listPage(@ModelAttribute("cri") SearchCriteria cri) throws Exception{
		
		logger.info(cri.toString());
		modelAndView.addObject("list",service.listCriteria(cri));
		
		PageMaker pageMaker =new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		modelAndView.addObject("pageMaker",pageMaker);
		modelAndView.setViewName("/sboard/list");
		

	    
		return modelAndView;
	}

}
