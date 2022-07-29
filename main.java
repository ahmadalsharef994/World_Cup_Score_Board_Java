import static org.junit.Assert.assertEquals;

public class main {
    public static void main(String[] args) {
        // 1. TDD for class Game
        Game gameTest = new Game("home", "away");
        assertEquals("home", gameTest.getHomeTeam());
        assertEquals("away", gameTest.getAwayTeam());
        assertEquals(0, gameTest.getHomeScore());
        assertEquals(0, gameTest.getAwayScore());
        gameTest.setHomeScore(1);
        gameTest.setAwayScore(1);
        assertEquals("home", gameTest.getHomeTeam());
        assertEquals("away", gameTest.getAwayTeam());
        assertEquals(1, gameTest.getHomeScore());
        assertEquals(1, gameTest.getAwayScore());
        // test IllegalArgumentException when passing a score < 0.
        try {
            gameTest.setHomeScore(-1);
        } catch (IllegalArgumentException e) {
            assertEquals("homeScore can't be lower than zero.", e.getMessage());
        }

        // 2. TDD1 for class ScoreBoard class
        ScoreBoard scoreBoardTest = new ScoreBoard();
        scoreBoardTest.startGame("home", "away");
        assertEquals(1, scoreBoardTest.getGames().size()); // DEPRECATED
        scoreBoardTest.updateScores("home", "away", 1, 1);
        assertEquals(1, scoreBoardTest.getGames().get(0).getHomeScore());

        // 3. TDD for class ScoreBoard expecting given input
        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.startGame("Mexico", "Canada");
        scoreBoard.startGame("Spain", "Brazil");
        scoreBoard.startGame("Germany", "France");
        scoreBoard.startGame("Uruguay", "Italy");
        scoreBoard.startGame("Argentina", "Australia");
        scoreBoard.updateScores("Mexico", "Canada", 0, 5);
        scoreBoard.updateScores("Spain", "Brazil", 10, 2);
        scoreBoard.updateScores("Germany", "France", 2, 2);
        scoreBoard.updateScores("Uruguay", "Italy", 6, 6);
        scoreBoard.updateScores("Argentina", "Australia", 3, 1);
        assertEquals(
                "Uruguay 6 - Italy 6\nSpain 10 - Brazil 2\nMexico 0 - Canada 5\nArgentina 3 - Australia 1\nGermany 2 - France 2\n",
                scoreBoard.getSummary());
        scoreBoard.finishGame("Mexico", "Canada");
        assertEquals("Uruguay 6 - Italy 6\nSpain 10 - Brazil 2\nArgentina 3 - Australia 1\nGermany 2 - France 2\n",
                scoreBoard.getSummary());
        scoreBoard.finishGame("Uruguay", "Italy");
        assertEquals("Spain 10 - Brazil 2\nArgentina 3 - Australia 1\nGermany 2 - France 2\n", scoreBoard.getSummary());
    }
}