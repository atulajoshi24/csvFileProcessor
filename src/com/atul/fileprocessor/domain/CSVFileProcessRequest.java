package com.atul.fileprocessor.domain;

public class CSVFileProcessRequest {

	private String firstFilePath;
	private String secondFilePath;	
	private String joinColumn;
	private String outputFilePath;

	 
	
	public String getFirstFilePath() {
		return firstFilePath;
	}
	public void setFirstFilePath(String firstFilePath) {
		this.firstFilePath = firstFilePath;
	}
	public String getSecondFilePath() {
		return secondFilePath;
	}
	public void setSecondFilePath(String secondFilePath) {
		this.secondFilePath = secondFilePath;
	}
	public String getJoinColumn() {
		return joinColumn;
	}
	public void setJoinColumn(String joinColumn) {
		this.joinColumn = joinColumn;
	}
	public String getOutputFilePath() {
		return outputFilePath;
	}
	public void setOutputFilePath(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}
	
	
	
	
}
