package ua.pasha.WebScraper.scraper;

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

		List<String> output = getResults(properties);

		for (String s : output) {
			System.out.println(s);
		}
	}
	
	public void printResults() {
		
		List<String> output = getResults();
		
		for (String s : output) {
			System.out.println(s);
		}
	}

	public List<String> getResults(SearchSettings properties) {
		List<String> output = new ArrayList<String>();

		output.add(name);

		if (properties.isWordFlag()) {
			output.add("\tKeywords occur " + words + " times");
			if (properties.isCharFlag()) {
				output.add("\tThere are " + chars + " characters on the page");
			}
			if (properties.isTimerFlag()) {
				output.add("\tTime spended to scpaping is " + time + " ms");
			}
			if (properties.isSentenceFlag()) {
				output.add("\tSentences contains keywords:");
				for (String s : sentenceList) {
					output.add("\t\t" + s);
				}
			}
			output.add("");
		}
		return output;
	}

	public List<String> getResults() {
		List<String> output = new ArrayList<String>();

		output.add(name);

		output.add("\tKeywords occur " + words + " times");
		output.add("\tThere are " + chars + " characters on the page");
		output.add("\tTime spended to scpaping is " + time + " ms");
		output.add("\tSentences contains keywords:");
		for (String s : sentenceList) {
			output.add("\t\t" + s);
		}
		output.add("");

		return output;

	}
}
