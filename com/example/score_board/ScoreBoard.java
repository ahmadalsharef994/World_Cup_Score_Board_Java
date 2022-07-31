package com.example.score_board;

import java.util.ArrayList;

public class ScoreBoard {
    private ArrayList<Game> games;

    public ScoreBoard() {
        this.games = new ArrayList<Game>();
    }

    // Another constructor following Dependency Inversion principe
    public ScoreBoard(ArrayList<Game> games) {
        this.games = games;
    }

    public void startGame(String homeTeam, String awayTeam) {
        Game game = new Game(homeTeam, awayTeam);
        games.add(game);
    }

    ArrayList<Game> getGames() {
        return games;
    }

    public void finishGame(String homeTeam, String awayTeam) {
        if (homeTeam == null || awayTeam == null) {
            throw new IllegalArgumentException("teams can't be null.");
        }
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getHomeTeam().equals(homeTeam) && games.get(i).getAwayTeam().equals(awayTeam)) {
                games.remove(i);
            }
        }
    }

    public void updateScores(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getHomeTeam().equals(homeTeam) && games.get(i).getAwayTeam().equals(awayTeam)) {
                games.get(i).setHomeScore(homeScore);
                games.get(i).setAwayScore(awayScore);
            }
        }
    }

    void orderGames() {
        for (int i = 0; i < games.size(); i++) {
            for (int j = i + 1; j < games.size(); j++) {
                if (games.get(i).getHomeScore() + games.get(i).getAwayScore() < games.get(j).getHomeScore()
                        + games.get(j).getAwayScore()) {
                    Game temp = games.get(i);
                    games.set(i, games.get(j));
                    games.set(j, temp);
                } else if (games.get(i).getHomeScore() + games.get(i).getAwayScore() == games.get(j).getHomeScore()
                        + games.get(j).getAwayScore()) {
                    if (games.get(i).getStartingTime() < games.get(j).getStartingTime()) {
                        Game temp = games.get(i);
                        games.set(i, games.get(j));
                        games.set(j, temp);
                    }
                }

            }
        }
    }

    public String getSummary() {
        orderGames();
        String summary = "";
        for (int i = 0; i < games.size(); i++) {
            summary += games.get(i).getHomeTeam() + " " + games.get(i).getHomeScore() + " - "
                    + games.get(i).getAwayTeam()
                    + " " + games.get(i).getAwayScore() + "\n";
        }
        return summary;
    }

}