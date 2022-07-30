package com.example.score_board;
public class Game {

    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    private long startingTime;

    Game(String homeTeam, String awayTeam) {
        // considering edge cases where either teams are null.
        if (homeTeam == null || awayTeam == null) {
            throw new IllegalArgumentException("teams can't be null.");
        }
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        // initiate game with 0 score.
        this.homeScore = 0;
        this.awayScore = 0;
        // initiate startingTime with current time.
        this.startingTime = System.nanoTime();
    }

    String getHomeTeam() {
        return homeTeam;
    }

    String getAwayTeam() {
        return awayTeam;
    }

    int getHomeScore() {
        return homeScore;
    }

    int getAwayScore() {
        return awayScore;
    }

    long getStartingTime() {
        return startingTime;
    }

    // no setter for homeTeam

    // no setter for awayTeam

    void setHomeScore(int homeScore) {
        if (awayScore < 0) {
            throw new IllegalArgumentException("homeScore can't be lower than zero.");
        }
        this.homeScore = homeScore;
    }

    void setAwayScore(int awayScore) {
        if (awayScore < 0) {
            throw new IllegalArgumentException("awayScore can't be lower than zero.");
        }
        this.awayScore = awayScore;
    }

    // no setter for startingTime
}