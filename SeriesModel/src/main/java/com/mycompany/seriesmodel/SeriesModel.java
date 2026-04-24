/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.seriesmodel;

/**
 * SeriesModel.java
 * Represents a TV series with id, name, age restriction, and number of episodes.
 * During the planning and coding phases of this assignment, Claude AI (Anthropic, 2026) was used for initial code generation suggestions, debugging assistance, and structuring of unit tests. All AI-generated code was thoroughly reviewed, modified where necessary, and tested to ensure correctness and understanding.
 * Claude AI (2026) Claude 3.5 Sonnet. Anthropic. Available at: https://claude.ai/ .
 */
public class SeriesModel {
    public String SeriesId;
    public String SeriesName;
    public String SeriesAge;
    public String SeriesNumberOfEpisodes;

    /**
     * This Constructor is to create a new SeriesModel object.
     * @param id        The series ID
     * @param name      The series name
     * @param age       The age restriction (as string, validated elsewhere)
     * @param episodes  The number of episodes
     */
    public SeriesModel(String id, String name, String age, String episodes) {
        this.SeriesId = id;
        this.SeriesName = name;
        this.SeriesAge = age;
        this.SeriesNumberOfEpisodes = episodes;
    }
}
