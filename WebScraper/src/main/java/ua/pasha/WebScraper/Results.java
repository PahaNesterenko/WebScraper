package ua.pasha.WebScraper;

import java.util.ArrayList;
import java.util.List;

public class Results {

	private String name;
	private int words;
	private int chars;
	private long time;
	private List<String> sentenceList;

	public Results(String name) {
		this.name = name;
		words = 0;
		chars = 0;
		time = 0;
		sentenceList = new ArrayList<String>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWords() {
		return words;
	}

	public void setWords(int words) {
		this.words = words;
	}

	public int getChars() {
		return chars;
	}

	public void setChars(int chars) {
		this.chars = chars;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public List<String> getSentenceList() {
		return sentenceList;
	}

	public void setSentenceList(List<String> sentenceList) {
		this.sentenceList = sentenceList;
	}

	public void printResults(SearchSettings properties) {

		System.out.println(name);

		if (properties.isWordFlag()) {
			System.out.println("\tKeywords occur " + words + " times");
			if (properties.isCharFlag()) {
				System.out.println("\tThere are " + chars + " characters on the page");
			}
			if (properties.isTimerFlag()) {
				System.out.println("\tTime spended to scpaping is " + time + " ms");
			}
			if (properties.isSentenceFlag()) {
				System.out.println("\tSentences contains keywords:");
				for (String s : sentenceList) {
					System.out.println("\t\t" + s);
				}
			}
			System.out.println("");
		}
	}
	
	public List<String> getResults(){
		
	}

}
