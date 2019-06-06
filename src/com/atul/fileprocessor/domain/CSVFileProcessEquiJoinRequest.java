package com.atul.fileprocessor.domain;

public class CSVFileProcessEquiJoinRequest {

	private String firstFileData;
	private String secondFileData;	
	private int matchingColumnIndexFirst;
	private int matchingColumnIndexSecond;
	
	public String getFirstFileData() {
		return firstFileData;
	}
	public void setFirstFileData(String firstFileData) {
		this.firstFileData = firstFileData;
	}
	public String getSecondFileData() {
		return secondFileData;
	}
	public void setSecondFileData(String secondFileData) {
		this.secondFileData = secondFileData;
	}
	public int getMatchingColumnIndexFirst() {
		return matchingColumnIndexFirst;
	}
	public void setMatchingColumnIndexFirst(int matchingColumnIndexFirst) {
		this.matchingColumnIndexFirst = matchingColumnIndexFirst;
	}
	public int getMatchingColumnIndexSecond() {
		return matchingColumnIndexSecond;
	}
	public void setMatchingColumnIndexSecond(int matchingColumnIndexSecond) {
		this.matchingColumnIndexSecond = matchingColumnIndexSecond;
	}
	
	
	
}
