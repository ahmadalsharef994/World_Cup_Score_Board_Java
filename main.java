import static org.junit.Assert.assertEquals;

public class main {
    public static void main(String[] args) {
        // testing class Game
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
    }
}