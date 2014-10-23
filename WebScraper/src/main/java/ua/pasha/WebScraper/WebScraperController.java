package ua.pasha.WebScraper;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebScraperController {
	
	public WebScraperController(){
		
	}
	
	@RequestMapping (value = "/search", method = RequestMethod.POST)
	public ModelAndView method(HttpServletRequest request){
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("View");
		mv.addObject("parameter1", "this is first parameter");
		mv.addObject("parameter2", "this is second parameter");
		Enumeration<String> words = request.getParameterNames();

		request.get
		String temp;
		String boxes = "";
		while(words.hasMoreElements()){
			temp = words.nextElement() ;
			boxes += temp;
			boxes += "-";
			boxes += request.getParameter(temp);
			boxes += " ";
		}
		
		mv.addObject("checkboxes", boxes);
		
		
				
		return mv;
		
	}

}
