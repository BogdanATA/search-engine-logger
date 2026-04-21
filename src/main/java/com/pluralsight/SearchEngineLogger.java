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

        logAction("Application Launch");
    }

    public static void logAction(String text) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("logs.txt", true));

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            writer.write(now.format(dateTimeFormatter) + " " + text + "\n");

            writer.close();
        } catch (IOException e) {
            System.err.println("Error");
        }
    }
}
