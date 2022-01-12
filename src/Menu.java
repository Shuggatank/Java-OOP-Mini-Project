import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Menu {
    public static void Menu() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println();
        System.out.println("MAIN MENU\n=====");
        boolean mainMenu = true;
        while (mainMenu) {
            System.out.println("1. Type 'play' to play.\n2. Type 'history' to view your game history.\n3. Type 'quit' to stop playing.\n");
            String playChoice = reader.readLine().toLowerCase();
            switch (playChoice) {
                case "play" -> {
                    System.out.println("You chose play\n");
                    mainMenu = false;
                }
                case "history" -> {
                    System.out.println("You chose to view history\n");
                    mainMenu = false;
                }
                case "quit" -> {
                    System.out.println("You chose to quit\n");
                    mainMenu = false;
                }
                default -> System.out.println("Invalid choice");
            }
            switch (playChoice) {
                case "play":
                    boolean notOpponent = true;
                    while (notOpponent) {
                        GameLogic.p1Score = 1;
                        GameLogic.p2Score = 1;
                        System.out.println("Would you like to play again another player or the computer? (Choose player or computer)");
                        String playType = reader.readLine().toLowerCase();
                        switch (playType) {
                            case "player" -> {
                                pvpMatch();
                                notOpponent = false;
                            }
                            case "computer" -> {
                                pcMatch();
                                notOpponent = false;
                            }
                            default -> System.out.println("Invalid Choice");
                        }
                    }
                    break;
                case "history":
                    System.out.println("=== GAME HISTORY ===");
                    History.readHistory();
                    boolean historyOption = true;
                    while (historyOption) {
                        System.out.println("Type 'quit' to go back to the main menu.");
                        String historyChoice = reader.readLine().toLowerCase();
                        if (historyChoice.equals("quit")) {
                            Menu();
                            historyOption = false;
                        } else {
                            System.out.println("Invalid Choice");
                        }
                    }
                    break;
                case "quit":
                    System.out.println("Thank you for playing");
                    break;
                default:
                    Menu();
                    break;
            }
        }
    }
    public static void pvpMatch() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean p1Choice = true;
        boolean p2Choice = true;
        String choiceP1 = "";
        String choiceP2 = "";
        while (p1Choice) {
            System.out.println("Player 1: Type 'rock', 'paper', or 'scissors' to play.\nType 'quit' to go back to the main menu.");
            choiceP1 = reader.readLine().toLowerCase();
            switch (choiceP1) {
                case "rock" -> p1Choice = false;
                case "paper" -> p1Choice = false;
                case "scissors" -> p1Choice = false;
                case "quit" -> {
                    Menu();
                    p1Choice = false;
                    p2Choice = false;
                }
                default -> System.out.println("Invalid Choice");
            }
        }
        while (p2Choice) {
            System.out.println("Player 2: Type 'rock', 'paper', or 'scissors' to play.\nType 'quit' to go back to the main menu.");
            choiceP2 = reader.readLine().toLowerCase();
            switch (choiceP2) {
                case "rock" -> p2Choice = false;
                case "paper" -> p2Choice = false;
                case "scissors" -> p2Choice = false;
                case "quit" -> {
                    Menu();
                    p2Choice = false;
                }
                default -> System.out.println("Invalid Choice");
            }
        }
        if (!choiceP1.equals("quit") && !choiceP2.equals("quit")) {
            System.out.printf("Player 1 picks: %s%nPlayer 2 picks: %s%n", choiceP1, choiceP2);
            System.out.println(GameLogic.rpsCombos(choiceP1, choiceP2, "Player 2"));
            pvpMatch();
        }
    }
    public static void pcMatch() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean p1Choice = true;
        String choiceP1 = "";
        String computer = AI.aiPlayer();
        while (p1Choice) {
            System.out.println("Player 1: Type 'rock', 'paper', or 'scissors' to play.\nType 'quit' to go back to the main menu.");
            choiceP1 = reader.readLine().toLowerCase();
            switch (choiceP1) {
                case "rock" -> p1Choice = false;
                case "paper" -> p1Choice = false;
                case "scissors" -> p1Choice = false;
                case "quit" -> {
                    Menu();
                    p1Choice = false;
                }
                default -> System.out.println("Invalid Choice");
            }
        }
        if (!choiceP1.equals("quit")) {
            System.out.printf("Player 1 picks: %s%nComputer picks: %s%n", choiceP1, computer);
            System.out.println(GameLogic.rpsCombos(choiceP1, computer, "Computer"));
            pcMatch();
        }
    }
}
