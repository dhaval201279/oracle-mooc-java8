/**
 * Lesson 2 homework
 */
package com.its;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Simon Ritter
 */
public class Lesson2 {
  private static final String WORD_REGEXP = "[- .:,]+";

  /**
   * Run the exercises to ensure we got the right answers
   *
   * @throws java.io.IOException
   */
  public void runExercises() throws IOException {
    System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 2");
    System.out.println("Running exercise 1 solution...");
    exercise1();
    System.out.println("Running exercise 2 solution...");
    exercise2();
    System.out.println("Running exercise 3 solution...");
    exercise3();
    System.out.println("Running exercise 4 solution...");
    exercise4();
    System.out.println("Running exercise 5 solution...");
    exercise5();
    System.out.println("Running exercise 6 solution...");
    exercise6();
    System.out.println("Running exercise 7 solution...");
    exercise7();
  }

  /**
   * Exercise 1
   *
   * Create a new list with all the strings from original list converted to 
   * lower case and print them out.
   */
  private void exercise1() {
    List<String> list = Arrays.asList(
        "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

    System.out.println("------------ Exercise 1 - First Way-------------");
    list.stream()
    	.forEach((name) -> System.out.print(name.toLowerCase()));
    
    List<String> list2 = list.stream()
    						.map(String :: toLowerCase)
    						.collect(Collectors.toList());
    
    System.out.println("------------ Exercise 1 - Second Way-------------");
    list2.forEach(System.out :: println);
    System.out.println("Exercise 1 completed");
  }

  /**
   * Exercise 2
   *
   * Modify exercise 1 so that the new list only contains strings that have an
   * odd length
   */
  private void exercise2() {
    List<String> list = Arrays.asList(
        "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

    /* YOUR CODE HERE */
    System.out.println("------------ Exercise 2 - First Way-------------");
    list.stream()
    	.filter((name) -> name.length() % 2 != 0)
    	.forEach((name) -> System.out.print(name.toLowerCase()));
    
    System.out.println("------------ Exercise 2 - Second Way-------------");
    
    List<String> list2 = list.stream()
    						.filter((name) -> name.length() % 2 != 0)
    						.map(String :: toLowerCase)
    						.collect(Collectors.toList());
    
    list2.forEach(System.out :: println);
    System.out.println("Exercise 2 completed");
  }

  /**
   * Exercise 3
   *
   * Join the second, third and forth strings of the list into a single string,
   * where each word is separated by a hyphen (-). Print the resulting string.
   */
  private void exercise3() {
    List<String> list = Arrays.asList(
        "The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

    /* YOUR CODE HERE */
    System.out.println("------------ Exercise 3 - First Way-------------");
    list.stream()
    	.skip(1)
    	.limit(3)
    	.forEach((name) -> System.out.print(name + "-"));
    
    System.out.println("********** Exercise 3 - Second Way-------------");
    String result = list.stream()
				    	.skip(1)
				    	.limit(3)
				    	.collect(Collectors.joining("-"));
    
    System.out.println(result);
    System.out.println("Exercise 3 completed");
    	
  }

  /**
   * Count the number of lines in the file using the BufferedReader provided
   */
  private void exercise4() throws IOException {
    /*try (BufferedReader reader = Files.newBufferedReader(
        Paths.get("SonnetI.txt"), StandardCharsets.UTF_8))*/ 
	  try (BufferedReader reader = new BufferedReader(new FileReader("H:/Dhaval/Tech/STS_Workspace/Java_8_Oracle_MOOC_ws/Lesson-2/src/com/its/SonnetI.txt"))){
      /* YOUR CODE HERE */
    	System.out.println(reader.lines().count());
    }
	  System.out.println("Exercise 4 completed");
  }
  
  /**
   * Using the BufferedReader to access the file, create a list of words with
   * no duplicates contained in the file.  Print the words.
   * 
   * HINT: A regular expression, WORD_REGEXP, is already defined for your use.
   */
  private void exercise5() throws IOException {
    
    try (BufferedReader reader = Files.newBufferedReader( 
    Paths.get("src/com/its","SonnetI.txt"), StandardCharsets.UTF_8)) {
      /* YOUR CODE HERE */
    	System.out.println("********** Exercise 5 - First Way-------------");
    	Stream <String> lines = reader.lines()
    								.map(line -> line.split("[\\s]+"))
    								.flatMap(Arrays :: stream)
    								.distinct();
    	lines.forEach(System.out :: println);
    	lines.close();
    }
    try (BufferedReader reader = Files.newBufferedReader( 
    	    Paths.get("src/com/its","SonnetI.txt"), StandardCharsets.UTF_8)) {
    	System.out.println("********** Exercise 5 - Second Way-------------");
    	List<String> list = reader.lines()
    		.flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
    		.distinct()
    		.collect(Collectors.toList());
    	
    	list.forEach(System.out :: println);
    	System.out.println("Exercise 5 completed");
    }
  }
  
  /**
   * Using the BufferedReader to access the file create a list of words from 
   * the file, converted to lower-case and with duplicates removed, which is
   * sorted by natural order.  Print the contents of the list.
   */
  private void exercise6() throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(
    		Paths.get("src/com/its","SonnetI.txt"), StandardCharsets.UTF_8)) {
    		
    	List<String> list = reader.lines()
    							.flatMap((line) -> Stream.of(line.split(WORD_REGEXP)))
    							.distinct()
    							.map(String :: toLowerCase)
    							.sorted()
    							.collect(Collectors.toList());
    	
    	list.forEach(System.out :: println);
    	System.out.println("Exercise 6 completed");
    }
  }
  
  /**
   * Modify exercise6 so that the words are sorted by length
   */
  private void exercise7() throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(
    		Paths.get("src/com/its","SonnetI.txt"), StandardCharsets.UTF_8)) {
      /* YOUR CODE HERE */
    	List<String> list = reader.lines()
    							.flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
    							.distinct()
    							.map(String :: toLowerCase)
    							.sorted((word1, word2) -> word1.length() - word2.length())
    							.collect(Collectors.toList());
    	list.forEach(System.out :: println);
    	System.out.println("Exercise 7 completed");
    }
  }

  /**
   * Main entry point for application
   *
   * @param args the command line arguments
   * @throws IOException If file access does not work
   */
  public static void main(String[] args) throws IOException {
    Lesson2 lesson = new Lesson2();
    lesson.runExercises();
  }
}

