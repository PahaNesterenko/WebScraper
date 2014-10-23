package ua.pasha.WebScraper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		Map<String, String[]> parameters = request.getParameterMap();
		if( parameters.containsKey("site")){
		Scraper scraper = new Scraper();
		SettingsParser parser = new SettingsParser();
		List<Results> resList = null;
		try {
			resList = scraper.scrape( parser.parse(parameters) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<List<String>> list = new ArrayList<List<String>>();
		List<String> temp = null;
		for( Results r : resList){
			temp = r.getResults();
			list.add(temp);
		}
		mv.addObject("results", list);
		}
				
		return mv;
		
	}

}
