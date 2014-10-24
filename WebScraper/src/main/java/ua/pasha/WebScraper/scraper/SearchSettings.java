package ua.pasha.WebScraper.scraper;

import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class SearchSettings {

	private boolean wordFlag = false;
	private boolean charFlag = false;
	private boolean sentenceFlag = false;
	private boolean timerFlag = false;

	private List<URL> urlList = new ArrayList<URL>();
	private List<String> wordList = new ArrayList<String>();

	public List<URL> getUrlList() {
		return urlList;
	}

	public void setUrlList(List<URL> urlList) {
		this.urlList = urlList;
	}

	public List<String> getWordList() {
		return wordList;
	}

	public void setWordList(List<String> wordList) {
		this.wordList = wordList;
	}

	public SearchSettings() {
	}

	public boolean isWordFlag() {
		return wordFlag;
	}

	public void setWordFlag(boolean wordFlag) {
		this.wordFlag = wordFlag;
	}

	public boolean isCharFlag() {
		return charFlag;
	}

	public void setCharFlag(boolean charFlag) {
		this.charFlag = charFlag;
	}

	public boolean isSentenceFlag() {
		return sentenceFlag;
	}

	public void setSentenceFlag(boolean sentenceFlag) {
		this.sentenceFlag = sentenceFlag;
	}

	public boolean isTimerFlag() {
		return timerFlag;
	}

	public void setTimerFlag(boolean timerFlag) {
		this.timerFlag = timerFlag;
	}

	@Override
	public String toString() {
		String s = "site: " + urlList.toString() + "\n";
		s = s + "words: " + wordList.toString() + "\n";
		s = s + "time elapsed : " + timerFlag + ", count words: " + wordFlag + ", count chars: " + charFlag
				+ ", sentences: " + sentenceFlag + "\n";
		return s;
	}

}
