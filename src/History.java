import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class History {
    private static List<String> playHistory = new ArrayList<>();


    public static void storeHistory(String winner, String p1Choice, String opponent, String opponentChoice) throws IOException {
        LocalDate date = LocalDate.now();
        String writeHistory = "";
        playHistory.add(String.format("%s %-15s Player 1 picked %s, %s picked %s%n", date, winner, p1Choice, opponent, opponentChoice));
        List<String> playHistory = History.playHistory;
        for (int i = 0; i < playHistory.size(); i++) {
            writeHistory += playHistory.get(i);
        }
        writeToFile(writeHistory);
    }

    public static void readHistory() throws IOException {
        for (int i = 0; i < playHistory.size(); i++) {
            System.out.println(playHistory.get(i));
        }
    }

    public static void writeToFile(String printHistory) throws IOException {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("./history.txt",true));
//            writer.write(printHistory); //Overwrites all history
            writer.append(printHistory);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void loadHistory() throws IOException {
//       TESTING. Throwing exception error when new items are added to the array from the game.
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./history.txt"));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            reader.close();
            List<String> lines = List.of(sb.toString().split("\n"));
            playHistory = List.of(sb.toString().split("\n"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
