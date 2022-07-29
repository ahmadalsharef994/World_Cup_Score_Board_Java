# World_Cup_Score_Board_Java

## Classes

I am creating 2 classes: Game and ScoreBoard.
Game having homeTeam, awayTeam, homeScore, awayScore, and startingTime ( to sort matches by time added to the system). Game also have constructor, getters, and setters.
ScoreBoard having games as an ArrayList insead of Array for dynamic allocation. It will also have methods for startGame, updateScores, finsihGame, orderGames, and getSummary.

I am also creating a main class to run the application.

I am following TDD approach, writing the tests first. Giving an Input, expecting an output, modifying the code until getting the desired results.


ScoreBoard is public class (outer)
Game is no-keyword class (package-private)