public class Player2 extends Player {
    private int playerScore;
    private String playerName;

    public Player2(int playerScore) {
        this.playerScore = playerScore;
    }
    public Player2(int playerScore, String playerName) {
        this.playerScore = playerScore;
        this.playerName = playerName;
    }
    @Override
    public int playerScore() {
        return playerScore;
    }

    @Override
    public String playerName() {
        return playerName;
    }

//    public void setPlayerScore(int playerScore) {
//        this.playerScore = playerScore;
//    }
//
//    public int getPlayerScore() {
//        return playerScore;
//    }
}
