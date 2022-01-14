import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class History {
    private static List<String> playHistory = new ArrayList<>();


    public static void storeHistory(String winner, String p1Choice, String opponent, String opponentChoice) {
        LocalDate date = LocalDate.now();
        // The string format here needs to have '%n' left off otherwise it will add an extra linebreak to the array.
        playHistory.add(String.format("%s %-15s Player 1 picked %s, %s picked %s", date, winner, p1Choice, opponent, opponentChoice));
        // This string format is for writing to the file. We need the '%n' here otherwise it would just write all entries in one line.
        String writeHistory = String.format("%s %-15s Player 1 picked %s, %s picked %s%n", date, winner, p1Choice, opponent, opponentChoice);
        writeToFile(writeHistory);
    }

    public static void readHistory() {
        for (int i = 0; i < playHistory.size(); i++) {
            System.out.println(playHistory.get(i));
        }
    }

    public static void writeToFile(String printHistory) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("./history.txt",true));
            writer.append(printHistory);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    // Loads in external play history
    public static void loadHistory() {
        try {
            // Reading file line by line and putting contents into a StringBuffer.
            BufferedReader reader = new BufferedReader(new FileReader("./history.txt"));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            reader.close();
            //Turned the StringBuffer into a List, so we can get the size of the List for the loop.
            for (int i = 0; i < List.of(sb.toString().split("\n")).size(); i++) {
                //StringBuffer is adding the history line by line to the playHistory array so proper formatting is kept, otherwise it would load at one long text.
                playHistory.add(sb.toString().split("\n")[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
