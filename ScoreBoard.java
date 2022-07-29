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

}