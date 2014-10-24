package ua.pasha.WebScraper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import ua.pasha.WebScraper.scraper.SearchSettings;
import ua.pasha.WebScraper.scraper.SettingsParser;
import junit.framework.TestCase;

public class SettingsParserTest extends TestCase {
	
	SearchSettings expected = new SearchSettings();

	@Before
	public void init(){
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
		
	}

	@Test
	public void testParseMapOfStringString() {
		init();
		SettingsParser parser = new SettingsParser();	
		
		Map<String, String[]> parameters = new HashMap<String, String[]>();
		parameters.put( "site", new String[]{"http://www.bbc.com/"});
		parameters.put( "word", new String[]{"Canada", "law"});
		//parameters.put( "time", new String[]{"true"});
		parameters.put( "countWords", new String[]{"true"});
		parameters.put( "countChars", new String[]{"true"});
		parameters.put( "sentences", new String[]{"true"});
		
		SearchSettings actual = parser.parse(parameters);
		
		assertTrue( expected.getUrlList().equals(actual.getUrlList()) );
		assertTrue( expected.getWordList().equals(actual.getWordList()) );
		
		assertEquals(expected.isCharFlag(), actual.isCharFlag());
		assertEquals(expected.isSentenceFlag(), actual.isSentenceFlag());
		assertEquals(expected.isTimerFlag(), actual.isTimerFlag());
		assertEquals(expected.isWordFlag(), actual.isWordFlag());
		
		System.out.println("-----Test1-----");
		System.out.println(expected);
		System.out.println(actual);
	}

	@Test
	public void testParseStringArray() {
		init();
		String args = "http://www.bbc.com/ Canada,law -w -c -e";
		String[] arr = args.split(" ");
		
		SettingsParser parser = new SettingsParser();
		SearchSettings actual = null;
		try {
			actual = parser.parse(arr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertTrue( expected.getUrlList().equals(actual.getUrlList()) );
		assertTrue( expected.getWordList().equals(actual.getWordList()) );
		
		assertEquals(expected.isCharFlag(), actual.isCharFlag());
		assertEquals(expected.isSentenceFlag(), actual.isSentenceFlag());
		assertEquals(expected.isTimerFlag(), actual.isTimerFlag());
		assertEquals(expected.isWordFlag(), actual.isWordFlag());
		
		System.out.println("-----Test2-----");
		System.out.println(expected);
		System.out.println(actual);

	}

}
