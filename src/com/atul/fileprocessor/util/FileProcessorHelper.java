package com.atul.fileprocessor.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.atul.fileprocessor.domain.CSVFileProcessEquiJoinRequest;

public class FileProcessorHelper {

	
	public static String readALineFromFile(String filePath) throws IOException{
		
		File file = new File(filePath);
		String line = "";
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			line = br.readLine();
			return line;         

        } catch (IOException e) {
            throw e;
        }
		
	}
	
	
	public static void writeALineToFile(String filePath,String line) throws IOException{
				
		try (FileWriter writer = new FileWriter(filePath);
	         BufferedWriter bw = new BufferedWriter(writer)) {

	          bw.write(line);  
	          bw.newLine();

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
		
	}
	
	
	public static String readAllLinesExceptFirst(String filePath) throws IOException{
		
		 String line = "";
		 StringBuilder fileData = new StringBuilder();
		
		 try (BufferedReader secondFileReader = new BufferedReader(new FileReader(filePath))) {

			 	line = secondFileReader.readLine();
										
				 while ((line = secondFileReader.readLine()) != null){
					 
					 fileData.append(line).append("\n");
					
				 }
				

	        } catch (IOException e) {
	            throw e;
	        }
		 
		 
		 return fileData.toString();
		
	}
	
	
	public static int getMatchingIndex(String[] source,String inputToMatch){
		
		for(int index= 0 ; index < source.length ; index ++){
			
			if(source[index].equalsIgnoreCase(inputToMatch)){
				
				return index;
			}
		}
		
		return -1;
		
	}
	
	
	/*public static StringBuilder getEquiJoinFileData(String firstFilePath,String secondFilePath,int matchingColumnIndexFirst,int matchingColumnIndexSecond) 
			throws IOException{
		
		StringBuilder fileData = new StringBuilder();
		String firstFileLine = "";
		String secondFileLine = "";
		
		try (BufferedReader firstFileReader = new BufferedReader(new FileReader(firstFilePath))) {

			firstFileLine = firstFileReader.readLine();
			
			
			 while ((firstFileLine = firstFileReader.readLine()) != null) {
	              
				 String[] firstFileData = firstFileLine.split(",");
				 
				 
				 try (BufferedReader secondFileReader = new BufferedReader(new FileReader(secondFilePath))) {

						secondFileLine = secondFileReader.readLine();
												
						 while ((secondFileLine = secondFileReader.readLine()) != null){
							 
							 String[] secondFileData = secondFileLine.split(",");
							 
							 if(firstFileData[matchingColumnIndexFirst].equalsIgnoreCase(secondFileData[matchingColumnIndexSecond])){
									
									fileData.append(firstFileLine).append(",").append(secondFileLine);
									fileData.append("\n");
									
							 }
							 
						 }
						

			        } catch (IOException e) {
			            throw e;
			        }
			 
			 }
			
	        } catch (IOException e) {
	            throw e;
	        }
		
			return fileData;
	}*/
	
	
	public static StringBuilder getEquiJoinFileData(CSVFileProcessEquiJoinRequest request) 
			throws IOException{
		
		StringBuilder fileData = new StringBuilder();
		
		String[] firstFileLines  = request.getFirstFileData().split("\\n");
		String[] secondFilLines  = request.getSecondFileData().split("\\n");
		
		for(String firstFileLine : firstFileLines){
		
			String[] firstFileRow = firstFileLine.split(",");
			
			for(String secondFileLine : secondFilLines){
			
				String[] secondFileRow = secondFileLine.split(",");
				
				if(firstFileRow[request.getMatchingColumnIndexFirst()].equalsIgnoreCase(secondFileRow[request.getMatchingColumnIndexSecond()])){
					
					fileData.append(firstFileLine).append(",").append(secondFileLine);
					fileData.append("\n");
					
				}
								
			}
							
		}
		
		return fileData;
	}
	
	
	
	public static void writeDataToFile(String filePath,String data){
		
		 try (FileWriter writer = new FileWriter(filePath);
	             BufferedWriter bw = new BufferedWriter(writer)) {

	            bw.write(data);

	        } catch (IOException e) {
	            System.err.format("IOException: %s%n", e);
	        }
		
	}
	
	
	
}
