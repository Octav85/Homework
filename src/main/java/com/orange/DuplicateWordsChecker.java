package com.orange;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DuplicateWordsChecker {

    public static void findDuplicates(String text) throws NoRepeatedWordsException {
        String[] sentences = text.split("\\.");

        Map<String, Integer> wordCount = new HashMap<>();

        for (int i = 1; i < sentences.length; i++) {
            String[] words = sentences[i].split("\\s+");

            for (String word : words) {
                word = word.replaceAll("[^a-zA-Z0-9]", "");
                word = word.toLowerCase();

                if (!word.isEmpty()) {
                    int count = wordCount.getOrDefault(word, 0);
                    wordCount.put(word, count + 1);

                }
            }
        }

        boolean hasDuplicates = false;

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
                hasDuplicates = true;
            }
        }

        if (!hasDuplicates) {
            throw new NoRepeatedWordsException("No repeated words");

        }

    }

    public static String readFile(String filePath) throws IOException{
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) !=null){
                content.append(line).append("\n");

            }
        }
        return content.toString();
    }
}









