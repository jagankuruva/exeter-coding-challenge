package com.words.traslate;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* 	Programmed By
*
*	Jagan Kuruva
*/
public class WordsTranslateToFrench {

	public static void main(String[] args) {
		Long startSec = Instant.now().getEpochSecond();
		String wordsFile = "C:\\JavaWorkspace\\find_words.txt";
		String dictionaryWordsFile = "C:\\JavaWorkspace\\french_dictionary.csv";
        BufferedReader wordsFileReader = null; 
        BufferedReader dictionaryWordsFileReader = null;
	        try
	        {
            	String dictionaryLine = "";
            	wordsFileReader = new BufferedReader(new FileReader(wordsFile));
            	String[] splitDist = null;
            	dictionaryWordsFileReader = new BufferedReader(new FileReader(dictionaryWordsFile));
            	 while ((dictionaryLine = dictionaryWordsFileReader.readLine()) != null) {
            		 splitDist = dictionaryLine.split(",");
            		 Path path = Paths.get("C:\\JavaWorkspace\\t8.shakespeare.txt");
            		 Stream <String> lines = Files.lines(path);
            		 String englishText = splitDist[0];
            		 String frenchReplaceText = splitDist[1];
            		 List <String> replaced = lines.map(line -> line.replaceAll(englishText, frenchReplaceText)).collect(Collectors.toList());
            		 Files.write(path, replaced);
            		 lines.close();
            	}
            }
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally
        {
            try {
            	wordsFileReader.close();
            	dictionaryWordsFileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        Long endTimeInSec = Instant.now().getEpochSecond();
        Long totalTime = endTimeInSec - startSec;
        System.out.println("Total Execution in Seconds: "+totalTime);
    }
}
