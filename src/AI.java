import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AI {
    public static String aiPlayer() {
        List<String> playChoices = new ArrayList<>();
        playChoices.add("rock");
        playChoices.add("paper");
        playChoices.add("scissors");

        Random random = new Random();
        int pcChoice = random.nextInt(playChoices.size());
        return playChoices.get(pcChoice);
    }
}
