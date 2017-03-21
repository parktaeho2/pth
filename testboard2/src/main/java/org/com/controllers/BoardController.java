package org.com.controllers;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.com.service.BoardService;
import org.com.vo.BoardVO;
import org.com.vo.Criteria;
import org.com.vo.PageMaker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	Logger log = Logger.getLogger(this.getClass());
	@Inject
	private BoardService service;
	
	ModelAndView modelAndView = new ModelAndView();
	
	@RequestMapping(value = "/register" ,method = RequestMethod.GET)
	public void registerGET(BoardVO board,Model model) throws Exception{
		log.info("register get .....");
		System.out.println("테");
	}
	
	@RequestMapping(value = "/register" ,method = RequestMethod.POST)
	public String registPOST(BoardVO board,RedirectAttributes rttr) throws Exception{
		log.info("regist post.....");
		log.info(board.toString());
		
		service.regist(board);
		rttr.addFlashAttribute("result","success");
		return "redirect:/board/listAll";
	}
	
	/*@RequestMapping(value = "/listAll" ,method = RequestMethod.GET)
	public ModelAndView listAll() throws Exception{
		log.info("show all list..........");
		modelAndView.setViewName("/board/listAll");
		modelAndView.addObject("list",service.listAll());
		return modelAndView;
	}*/
	
	
	  @RequestMapping(value = "/listPage", method = RequestMethod.GET)
	  public ModelAndView listPage(@ModelAttribute("cri") Criteria cri) throws Exception {

		  log.info(cri.toString());

	    modelAndView.addObject("list", service.listCriteria(cri));
	    PageMaker pageMaker = new PageMaker();
	    pageMaker.setCri(cri);
	    pageMaker.setTotalCount(service.listCountCriteria(cri));
	    modelAndView.addObject("pageMaker", pageMaker);
	    modelAndView.setViewName("/board/listPage");
	    
	    return modelAndView; 
	  }
	@RequestMapping(value = "/listCri" ,method = RequestMethod.GET)
	public ModelAndView listAll(Criteria cri) throws Exception{
		log.info("show all list..........");
		modelAndView.setViewName("/board/listCri");
		modelAndView.addObject("list",service.listCriteria(cri));
		return modelAndView;
	}
	@RequestMapping(value = "/read" ,method = RequestMethod.GET)
	public ModelAndView read(@RequestParam("bno") int bno,@ModelAttribute("cri") Criteria cri) throws Exception
	{
		modelAndView.setViewName("/board/read");
		modelAndView.addObject(service.read(bno));
		return modelAndView;
	}
	@RequestMapping(value = "/remove" ,method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno,Criteria cri,RedirectAttributes rttr) throws Exception
	{
		service.remove(bno);	
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		rttr.addFlashAttribute("result","success");
		
		
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value = "/modify" ,method = RequestMethod.GET)
	public ModelAndView test(@RequestParam("bno") int bno,@ModelAttribute("cri") Criteria cri) throws Exception
	{
		modelAndView.addObject(service.read(bno));
		modelAndView.setViewName("/board/modify");
		return modelAndView;
	}
	
	@RequestMapping(value = "/modify" ,method = RequestMethod.POST)
	public String modifyPOST(BoardVO board,Criteria cri,RedirectAttributes rttr) throws Exception
	{
		log.info("mod post.....");
		service.modify(board);
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		rttr.addFlashAttribute("result","success");
		
		return "redirect:/board/listPage";
	}
	
	
/*	@RequestMapping(value = "/test" ,method = RequestMethod.POST)
	public String test(@RequestParam("bno") int bno,RedirectAttributes rttr) throws Exception
	{
		try {

			msg.setSendName("sadsadsad");
			msg.setType(12);
			pro.doWork(msg);

		} catch (Exception e) {
			e.printStackTrace();
		}
		rttr.addFlashAttribute("result","success");
		return "redirect:/board/listAll";
	}
	*/

	
	
}
