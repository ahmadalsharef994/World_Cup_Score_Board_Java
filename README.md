# World_Cup_Score_Board_Java

## Package
com.example.score_board
## Classes

Two classes: Game and ScoreBoard following (S: single responsibility) in SOLID principle.

1. Game having homeTeam, awayTeam, homeScore, awayScore, and startingTime ( to sort games by time added to the system). Game also have constructor, getters, and setters.
2. ScoreBoard having "games" as an ArrayList insead of Array for dynamic allocation. ScoreBoard will also have methods for startGame, updateScores, finsihGame, orderGames, and getSummary.

ScoreBoard is public class (outer).
Game is no-keyword class (package-private).
## Methodology

I am creating a main class to run the application and tests.

I am following TDD approach, writing the tests first. Giving an Input, expecting an output, modifying the code until getting the desired results.

