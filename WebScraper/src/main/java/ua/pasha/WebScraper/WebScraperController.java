package ua.pasha.WebScraper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebScraperController {
	
	public WebScraperController(){
		
	}
	
	@RequestMapping (value = "/search", method = RequestMethod.POST)
	public ModelAndView method(){
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("View");
		mv.addObject("parameter1", "this is first parameter");
		mv.addObject("parameter2", "this is second parameter");
		
		return mv;
		
	}

}
