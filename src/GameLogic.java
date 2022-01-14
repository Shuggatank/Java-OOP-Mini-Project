import java.util.HashMap;
import java.util.Map;

public class GameLogic {
    static int p1Score = 1;
    static int p2Score = 1;


    public static String rpsCombos(String p1, String p2, String p2Name) {
        Player1 player1 = new Player1(p1Score);
        Player2 player2 = new Player2(p2Score);

        if (p1.equals(p2)) {
            History.storeHistory("DRAW:", p1, p2Name, p2);
            return "Draw!\n";
        }
        Map<String, String> rpsCombos = new HashMap<>();
        rpsCombos.put("rock", "scissors");
        rpsCombos.put("scissors", "paper");
        rpsCombos.put("paper", "rock");

        String result = rpsCombos.get(p1);
        // Compares the value of the p1 choice(the key)
        if (result.equals(p2)) {
            History.storeHistory("Player 1 WINS:",p1, p2Name, p2);
            p1Score++;
            System.out.printf("Player 1 Score: %d%n",player1.playerScore());
            return "Player 1 won!\n";
        }
        else { // Game logic for both human player 2 and computer player 2
            History.storeHistory(p2Name+" WINS:",p1, p2Name, p2);
            p2Score++;
            System.out.printf("%s Score: %d%n",p2Name, player2.playerScore());
            return (p2Name + " won!\n");
        }
    }
}
