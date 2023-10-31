package com.linkedin.javacodechallenges;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class App {
    public static void redactTextFile(String fileName,
            String[] redactedWordsArray) {
        try {
            if (!fileName.endsWith(".txt")) {
                System.out.println("This is not a text file.");
                return;
            }
            File originalFile = new File(fileName);
            if (!originalFile.isFile()) {
                System.out.println("That file doesn't exist or isn't valid.");
                return;
            }
            File redactedFile = new File("Redacted_" + fileName);
            if (redactedFile.isFile()) {
                System.out.println("A redacted version of that file already exists.");
                return;
            }
            if (!redactedFile.createNewFile()) {
                System.out.println("The redacted file couldn't be created.");
                return;
            }
            BufferedReader reader = new BufferedReader(new FileReader(originalFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(redactedFile));
            String line = reader.readLine();
            while (line != null) {
                for (String redactedWord : redactedWordsArray) {
                    String replacement = "REDACTED";
                    line = StringUtils.replaceIgnoreCase(line, redactedWord, replacement);
                }
                writer.write(line);
                writer.newLine();
                line = reader.readLine();
            }
            reader.close();
            writer.close();
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What file would you like to " +
                "redact information from?");
        String fileName = scanner.nextLine();

        System.out.println("What words would you like to redact? " +
                "Separate each word or phrase with a comma. " +
                "If your phrase includes punctuation, include " +
                "that in your input.");
        String redactedWords = scanner.nextLine();
        String[] redactedWordsList = redactedWords.split(",");

        redactTextFile(fileName, redactedWordsList);

        scanner.close();
    }
}
