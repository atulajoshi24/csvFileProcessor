# csvFileProcessor

Assumptions : 

The assumpations made during implementation : 
1)There will always be one column available on which two csv files can be joined 

2)The output file will contain all column headers combined from two files alongwith data (if match happens)

3)The command line arguments are given is below orders : 
    
   -- First Input File Path 
   -- Second Input File Path 
   -- Matching Column ID 
   -- Output File Path 

Steps To Compile and Run Program : 
1) clone the repository :  git clone https://github.com/atulajoshi24/csvFileProcessor.git

2)Enter the directory where repository is cloned : cd csvFileProcessor

3)Compile Java Programme :  

javac -d classes src\com\atul\fileprocessor\domain\*.java src\com\atul\fileprocessor\util\*.java src\com\atul\fileprocessor\*.java

4)Execute the java program by giving all required parameters : 

  java com.atul.fileprocessor.CSVFileProcessor {FilePathOne} {FilePathTwo} {MatchingColumnName} {OutputFilePath}
 
  for example : 
  java com.atul.fileprocessor.CSVFileProcessor D:\FireEye\FirstInput.csv D:\FireEye\SecondInput.csv ID D:\FireEye\SampleOutout.csv
   


Sample Output Files : 
1)FirstInput.csv

2)SecondInput.csv

3)OutPut.csv


