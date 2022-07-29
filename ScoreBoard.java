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

    void startGame(String homeTeam, String awayTeam) {
        Game game = new Game(homeTeam, awayTeam);
        games.add(game);
    }

    ArrayList<Game> getGames() {
        return games;
    }

    void updateScores(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getHomeTeam().equals(homeTeam) && games.get(i).getAwayTeam().equals(awayTeam)) {
                games.get(i).setHomeScore(homeScore);
                games.get(i).setAwayScore(awayScore);
            }
        }
    }

    void finishGame(String homeTeam, String awayTeam) {
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getHomeTeam().equals(homeTeam) && games.get(i).getAwayTeam().equals(awayTeam)) {
                games.remove(i);
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

    String getSummary() {
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