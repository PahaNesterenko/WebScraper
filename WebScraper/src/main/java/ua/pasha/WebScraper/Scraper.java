package ua.pasha.WebScraper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.HTMLEditorKit.Parser;

public class Scraper {

	List<Results> resList = new ArrayList<Results>();
	Parser parser = new ScannerHTMLEditorKit().getParser();

	public Scraper(){
	}

	public List<Results> scrape(SearchSettings properties) throws IOException {
		
		for (URL url : properties.getUrlList()) {
			Results results = scrapeUrl(url, properties);
			resList.add(results);
		}

		if (resList.size() > 1) {
			int chars = 0;
			int words = 0;
			long time  = 0;
			List<String> sentenceList = new ArrayList<String>();
			
			Results total = new Results("TOTAL");
			
			for (Results res : resList) {
				chars += res.getChars();
				words += res.getWords();
				time += res.getTime();
				sentenceList.addAll(res.getSentenceList());
			}
			total.setChars(chars);
			total.setWords(words);
			total.setTime(time);
			total.setSentenceList(sentenceList);
		
			resList.add(total);
		}
		return resList;
	}

	public Results scrapeUrl(URL url, SearchSettings properties) throws IOException {
		long start = System.currentTimeMillis();
		Results results = new Results(url.getHost());
		BufferedReader rdr = new BufferedReader(new InputStreamReader(
				url.openStream()));
		HTMLEditorKit.ParserCallback callback = new ScannerParserCallback(
				results, properties);
		parser.parse(rdr, callback, true);
		long finish = System.currentTimeMillis();
		results.setTime( finish - start );

		return results;
	}

	private static class ScannerParserCallback extends
			HTMLEditorKit.ParserCallback {
		Results results;
		SearchSettings properties;

		public ScannerParserCallback(Results results, SearchSettings properties) {
			this.results = results;
			this.properties = properties;
		}

		public void handleText(char[] data, int pos) {

			results.setChars( results.getChars() + data.length ); 

			if (properties.isWordFlag()) {
				String s = String.valueOf(data);
				String[] arr = s.split(" ");
				for (String word : arr) {
					if (properties.getWordList().contains(word)) {
						results.setWords( results.getWords() + 1 );
						if (properties.isSentenceFlag()) {
							results.getSentenceList().add(s);
						}
					}
				}
			}

		}

	}

	// we need this class only to get the default html parser
	// the returned parser creates a new parser on every parse call
	// so one parser is enough
	private static class ScannerHTMLEditorKit extends HTMLEditorKit {
		/**
			 * 
			 */
		private static final long serialVersionUID = 1L;

		@Override
		public Parser getParser() {
			return super.getParser();
		}
	}
}
