/**
 * Copyright © 2014, Oracle and/or its affiliates. All rights reserved.
 * 
 * JDK 8 MOOC Lesson 3 homework
 */
package com.its;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Class to generate a list of random words
 *
 * @author Simon Ritter (@speakjava)
 */
public class RandomWords {
	private final List<String> sourceWords;

	/**
	 * Exercise 1 : In the constructor you need to read all the words (which are one per line) from the source file into a 
	 * list (remember to use a stream to do this)
	 * Constructor
	 * 
	 * @throws IOException
	 *             If the source words file cannot be read
	 */
	public RandomWords() throws IOException {
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("src/com/its", "words.txt"))) {
			sourceWords = reader.lines().collect(Collectors.toList());
			System.out.println("Loaded " + sourceWords.size() + " words");
		}
	}

	/**
	 * Exercise 2 : This generates a list of the size specified as a parameter selecting words at random from the list read 
	 * in the constructor. HINT: You can use the ints() method of the Random class, which returns a stream of random integers. 
	 * You can specify the size of the stream using a parameter.
	 * 
	 * Create a list of a given size containing random words
	 *
	 * @param listSize
	 *            The size of the list to create
	 * @return The created list
	 */
	public List<String> createList(int listSize) {
		Random random = new Random();
		List<String> wordList = random.ints(listSize, 0, sourceWords.size())
									.mapToObj(idx -> sourceWords.get(idx))
									.collect(Collectors.toList()); // YOUR CODE HERE

		return wordList;
	}

	/**
	 * 
	 * Return the list of all source words, which cannot be modified
	 *
	 * @return The unmodifiable list of all source words
	 */
	public List<String> allWords() {
		return Collections.unmodifiableList(sourceWords);
	}
}