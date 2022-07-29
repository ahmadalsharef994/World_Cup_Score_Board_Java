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

    }
}