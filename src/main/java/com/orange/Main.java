package com.orange;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        testTextFile("Text with duplicates", "src/main/resources/textWithDuplicates.txt");
        testTextFile("Text without duplicates", "src/main/resources/textWithoutDuplicates.txt");
    }

    private static void testTextFile( String description, String filePath){
        System.out.println(description + ". Result:");
        try{
            String text = DuplicateWordsChecker.readFile(filePath);
            DuplicateWordsChecker.findDuplicates(text);
        }catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
        }catch (NoRepeatedWordsException e){
            System.out.println(e.getMessage());
        }
    }
}