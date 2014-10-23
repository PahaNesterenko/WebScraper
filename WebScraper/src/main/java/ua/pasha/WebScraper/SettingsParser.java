package ua.pasha.WebScraper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class SettingsParser {
	
	public SettingsParser(){
	}
	
	public SearchSettings parse(Map<String, String[]> parameters){
		SearchSettings settings = new SearchSettings();
		
		try {
			settings = parseUrl(parameters.get("site")[0], settings);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		settings = parseWords(parameters.get("word"), settings);
		settings = parseKeys(parameters, settings);
		
		return settings;
	}
	
	public SearchSettings parse( String[] args ) throws IOException{
		SearchSettings settings = new SearchSettings();
		
		if (args.length < 2 || args.length > 6) {
			//TODO
		}
		settings = parseUrl(args[0], settings);
		settings = parseWords(args[1].split(","), settings);
		settings = parseKeys(args, settings);
		
		return settings;
	}
	
	private SearchSettings parseUrl(String arg, SearchSettings settings) throws IOException {

		File file = new File(arg);
		if (file.isFile()) {
			BufferedReader rdr = new BufferedReader(new FileReader(file));
			try {
				while (true) {
					String name = rdr.readLine();
					if (name == null) {
						break;
					}
					URL url = new URL(name);
					settings.getUrlList().add(url);
				}
			} catch (IOException e) {
				e.printStackTrace();
				throw new IOException();
			} finally {
				rdr.close();
			}

		} else {
			URL url = new URL(arg);
			settings.getUrlList().add(url);
		}
		return settings;

	}
	
	private SearchSettings parseWords(String[] wordsArr, SearchSettings settings){
		for( String s : wordsArr){
			settings.getWordList().add(s);
		}
		return settings;
	}
	
	private SearchSettings parseKeys( String[] args, SearchSettings settings){
		
		for( int i = 2 ; i < args.length ; ++i){
			String arg = args[i];
			if( arg.equals("-v") ){
				settings.setTimerFlag(true);
			}
			else if( arg.equals("-w")){
				settings.setWordFlag(true);
			}
			else if ( arg.equals("-c" )){
				settings.setCharFlag(true);
			}
			else if (arg.equals( "-e" )){
				settings.setSentenceFlag(true);
			}
			else{
				//TODO
			}
		}
		return settings;
	}
	
	private SearchSettings parseKeys( Map<String, String[]> parameters, SearchSettings settings){
		
			if( parameters.containsKey("time") ){
				settings.setTimerFlag(true);
			}
			if( parameters.containsKey("countWords") ){
				settings.setWordFlag(true);
			}
			if ( parameters.containsKey("countChars") ){
				settings.setCharFlag(true);
			}
			if ( parameters.containsKey("sentences") ){
				settings.setSentenceFlag(true);
			}
		return settings;
	}
	
}
