package ua.pasha.WebScraper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import ua.pasha.WebScraper.scraper.Results;
import ua.pasha.WebScraper.scraper.Scraper;
import ua.pasha.WebScraper.scraper.SearchSettings;

public class test {

	public static void main(String[] args) throws MalformedURLException {
		
		SearchSettings expected = new SearchSettings();

			expected.setCharFlag(true);
			expected.setSentenceFlag(true);
			expected.setTimerFlag(false);
			expected.setWordFlag(true);
			try {
				expected.getUrlList().add(new URL("http://www.bbc.com/"));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			expected.getWordList().add("Canada");
			expected.getWordList().add("law");
			
			Scraper sc = new Scraper();
			List<Results> list = null;
			try {
				list = sc.scrape(expected);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for( Results r : list){
				r.printResults();
			}
			
		
		
	}
	
	
}
