package com.atul.fileprocessor;


import com.atul.fileprocessor.domain.CSVFileProcessEquiJoinRequest;
import com.atul.fileprocessor.domain.CSVFileProcessRequest;
import com.atul.fileprocessor.util.FileProcessorHelper;

public class CSVFileProcessor {

	public static void main(String[] args) throws Exception{
		
		if(args.length != 4){
			throw new IllegalArgumentException("Wrong Input Parameters ");
		}
		
		String firstFilePath = args[0];
		String secondFilePath = args[1];
		
		String joinColumn = args[2];
		String outputFilePath = args[3];
		
		CSVFileProcessor processor = new CSVFileProcessor();
		CSVFileProcessRequest request = new CSVFileProcessRequest();
		
		request.setFirstFilePath(firstFilePath);
		request.setSecondFilePath(secondFilePath);
		request.setJoinColumn(joinColumn);
		request.setOutputFilePath(outputFilePath);
		
		processor.process(request);
		
		
	}
	
	public void process(CSVFileProcessRequest request) throws Exception{
		
		String firstFileHeader = FileProcessorHelper.readALineFromFile(request.getFirstFilePath());
		String[] firstFileColumns = firstFileHeader.split(",");
		int matchingColumnIndexFirst = FileProcessorHelper.getMatchingIndex(firstFileColumns, request.getJoinColumn());
		
		
		String secondFileHeader = FileProcessorHelper.readALineFromFile(request.getSecondFilePath());
		String[] secondFileColumns = secondFileHeader.split(",");
		int matchingColumnIndexSecond = FileProcessorHelper.getMatchingIndex(secondFileColumns, request.getJoinColumn());
		

		String firstFileData = FileProcessorHelper.readAllLinesExceptFirst(request.getFirstFilePath());
		String secondFileData = FileProcessorHelper.readAllLinesExceptFirst(request.getSecondFilePath());
		
		CSVFileProcessEquiJoinRequest cSVFileProcessEquiJoinRequest = new CSVFileProcessEquiJoinRequest();
		cSVFileProcessEquiJoinRequest.setFirstFileData(firstFileData);
		cSVFileProcessEquiJoinRequest.setSecondFileData(secondFileData);
		cSVFileProcessEquiJoinRequest.setMatchingColumnIndexFirst(matchingColumnIndexFirst);
		cSVFileProcessEquiJoinRequest.setMatchingColumnIndexSecond(matchingColumnIndexSecond);
		
		
		StringBuilder fileData = FileProcessorHelper.getEquiJoinFileData(cSVFileProcessEquiJoinRequest);
		
		StringBuilder fileHeader = new StringBuilder();
		fileHeader.append(firstFileHeader).append(",").append(secondFileHeader).append("\n");
		
		String completeFileData = fileHeader.append(fileData).toString();
		
		FileProcessorHelper.writeDataToFile(request.getOutputFilePath(),completeFileData);
		
	}
	
}
