import com.example.score_board.*;
import static org.junit.Assert.assertEquals;

public class main {
    public static void main(String[] args) {
        // TDD: class ScoreBoard expecting given output from giving input
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
        System.out.println("scoreBoard Summary:\n" + scoreBoard.getSummary());
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