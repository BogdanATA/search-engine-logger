package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //prints Launch each time it is launched
        logAction("Launch");

        boolean isDone = false;
        while (!isDone) {
            System.out.println("Enter a search term (X to exit)");
            String searchTerm = scanner.nextLine();

            if (searchTerm.trim().equalsIgnoreCase("X")) { // press x to exit
                logAction("Exit"); // prints exit if user pressed x
                isDone = true; // closes loop if user pressed x
            } else {
                logAction("search : " + searchTerm); // prints search : followed by the user input
            }
        }
        scanner.close();
    }
    // creates buffered writer and writes date and time + all input onto the logs.txt
    public static void logAction(String text) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("logs.txt", true));

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            writer.write(now.format(dateTimeFormatter) + " " + text + "\n"); // prints date and time first followed by user input

            writer.close();
        } catch (IOException e) {
            System.err.println("Error");
        }
    }
}
