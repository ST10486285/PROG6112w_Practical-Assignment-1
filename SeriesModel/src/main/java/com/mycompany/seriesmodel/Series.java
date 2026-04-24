/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seriesmodel;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Series.java
 * Contains all working methods for managing the TV series collection.
 * During the planning and coding phases of this assignment, Claude AI (Anthropic, 2026) was used for initial code generation suggestions, debugging assistance, and structuring of unit tests. All AI-generated code was thoroughly reviewed, modified where necessary, and tested to ensure correctness and understanding.
 * Claude AI (2026) Claude 3.5 Sonnet. Anthropic. Available at: https://claude.ai/ .
 */
public class Series {
    // ArrayList to store series objects in memory
    private ArrayList<SeriesModel> seriesList;
    // Scanner for user input
    private Scanner scanner;

    /**
     * Constructor initializes the ArrayList and Scanner.
     */
    public Series() {
        seriesList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Helper method to validate age restriction.
     * Must be an integer between 2 and 18 inclusive.
     * @param ageStr The age string entered by the user
     * @return true if valid, false otherwise
     */
    private boolean isValidAgeRestriction(String ageStr) {
        try {
            int age = Integer.parseInt(ageStr);
            return age >= 2 && age <= 18;
        } catch (NumberFormatException e) {
            return false; // Not a valid number
        }
    }

    /**
     * Helper method to find a series by its ID.
     * @param id The series ID to search for
     * @return The SeriesModel object if found, otherwise null
     */
    private SeriesModel findSeriesById(String id) {
        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equals(id)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Captures a new TV series from user input.
     * Validates age restriction and stores the series in memory.
     */
    public void CaptureSeries() {
        System.out.println("\nCAPTURE A NEW SERIES");
        System.out.println("**************************");

        System.out.print("Enter the series id: ");
        String id = scanner.nextLine();

        System.out.print("Enter the series name: ");
        String name = scanner.nextLine();

        // Age validation loop
        String ageInput;
        while (true) {
            System.out.print("Enter the series age restriction: ");
            ageInput = scanner.nextLine();
            if (isValidAgeRestriction(ageInput)) {
                break;
            } else {
                System.out.println("You have entered a incorrect series age!!!");
                System.out.print("Please re-enter the series age >> ");
            }
        }

        System.out.print("Enter the number of episodes for " + name + ": ");
        String episodes = scanner.nextLine();

        // Create and store the new series
        SeriesModel newSeries = new SeriesModel(id, name, ageInput, episodes);
        seriesList.add(newSeries);

        System.out.println("Series processed successfully!!!");
    }

    /**
     * Searches for a series by its ID and displays the details.
     */
    public void SearchSeries() {
        System.out.print("\nEnter the series id to search: ");
        String id = scanner.nextLine();

        SeriesModel found = findSeriesById(id);

        if (found != null) {
            System.out.println("---");
            System.out.println("SERIES ID: " + found.SeriesId);
            System.out.println("SERIES NAME: " + found.SeriesName);
            System.out.println("SERIES AGE RESTRICTION: " + found.SeriesAge);
            System.out.println("SERIES NUMBER OF EPISODES: " + found.SeriesNumberOfEpisodes);
            System.out.println("---");
        } else {
            System.out.println("---");
            System.out.println("Series with Series Id: " + id + " was not found!");
            System.out.println("---");
        }
    }

    /**
     * Updates an existing series' details.
     * Allows editing of name, age restriction, and number of episodes.
     */
    public void UpdateSeries() {
        System.out.print("\nEnter the series id to update: ");
        String id = scanner.nextLine();

        SeriesModel toUpdate = findSeriesById(id);

        if (toUpdate != null) {
            System.out.print("Enter the series name: ");
            String newName = scanner.nextLine();
            toUpdate.SeriesName = newName;

            // Age validation for update
            String newAge;
            while (true) {
                System.out.print("Enter the age restriction: ");
                newAge = scanner.nextLine();
                if (isValidAgeRestriction(newAge)) {
                    break;
                } else {
                    System.out.println("You have entered a incorrect series age!!!");
                    System.out.print("Please re-enter the series age >> ");
                }
            }
            toUpdate.SeriesAge = newAge;

            System.out.print("Enter the number of episodes: ");
            String newEpisodes = scanner.nextLine();
            toUpdate.SeriesNumberOfEpisodes = newEpisodes;

            System.out.println("Series updated successfully.");
        } else {
            System.out.println("Series with Id: " + id + " not found.");
        }
    }

    /**
     * Deletes a series after user confirmation.
     */
    public void DeleteSeries() {
        System.out.print("\nEnter the series id to delete: ");
        String id = scanner.nextLine();

        SeriesModel toDelete = findSeriesById(id);

        if (toDelete != null) {
            System.out.print("Are you sure you want to delete series " + id + " from the system? Yes (y) to delete. ");
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("y")) {
                seriesList.remove(toDelete);
                System.out.println("---");
                System.out.println("Series with Series Id: " + id + " WAS deleted!");
                System.out.println("---");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Series with Id: " + id + " not found.");
        }
    }

    /**
     * Prints a report of all captured series in the required format.
     */
    public void SeriesReport() {
        System.out.println("\nSeries Report - 2025");
        if (seriesList.isEmpty()) {
            System.out.println("No series captured yet.");
            return;
        }

        for (int i = 0; i < seriesList.size(); i++) {
            SeriesModel s = seriesList.get(i);
            System.out.println("Series " + (i + 1));
            System.out.println("---");
            System.out.println("SERIES ID: " + s.SeriesId);
            System.out.println("SERIES NAME: " + s.SeriesName);
            System.out.println("SERIES AGE RESTRICTION: " + s.SeriesAge);
            System.out.println("NUMBER OF EPISODES: " + s.SeriesNumberOfEpisodes);
            System.out.println();
        }
    }

    /**
     * Displays an exit message.
     */
    public void ExitSeriesApplication() {
        System.out.println("Thank you for using the Series Management App. Goodbye.");
    }
}