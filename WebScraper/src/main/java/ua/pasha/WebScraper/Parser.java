package ua.pasha.WebScraper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class Parser {
	
	private String[] args;
	private SearchSettings properties;
	
	public Parser(String[] args, SearchSettings properties){
		this.args = args;
		this.properties = properties;
		logger = new Logger(this);
	}
	
	public boolean parseArgs(){
		
		if (args.length < 2 || args.length > 6) {
			logger.logWarning("Wrong parameters");
			return false;
		}

		try {
			parseUrl(args[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parseWords(args[1]);
		
		if( parseKeys(args) == false){
			logger.logWarning("Wrong command");
			return false;
		}
		logger.logInfo("Parameters parsed");
		return true;
	}
	
	private void parseUrl(String arg) throws IOException {

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
					properties.urlList.add(url);
				}
			} catch (IOException e) {
				e.printStackTrace();
				logger.logWarning("Can not read file" + file.getName() );
				throw new IOException();
			} finally {
				rdr.close();
			}

		} else {
			URL url = new URL(arg);
			properties.urlList.add(url);
		}

	}
	
	private void parseWords(String arg){
		String[] arr = arg.split(",");
		for( String s : arr){
			properties.wordList.add(s);
		}
	}
	
	private boolean parseKeys( String[] args){
		
		for( int i = 2 ; i < args.length ; ++i){
			String arg = args[i];
			if( arg.equals("-v") ){
				properties.setTimerFlag(true);
			}
			else if( arg.equals("-w")){
				properties.setWordFlag(true);
			}
			else if ( arg.equals("-c" )){
				properties.setCharFlag(true);
			}
			else if (arg.equals( "-e" )){
				properties.setSentenceFlag(true);
			}
			else{
				return false;
			}
		}
		return true;
		
	}
	
	public SearchSettings getProperties() {
		return properties;
	}

	public void setProperties(SearchSettings properties) {
		this.properties = properties;
	}


}
