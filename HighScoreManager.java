package game;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HighScoreManager {
    private static final String FILE_PATH = "highscores.txt";

    // Save a high score to the file
    public static void saveHighScore(String playerName, int moves) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(playerName + " - " + moves + " moves\n");
        }
    }

    // Display all high scores in the console
    public static void displayHighScores() throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("No high scores yet!");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            System.out.println("High Scores:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    // Import all high scores from the file into a list of strings
    public static List<String> importHighScores() throws IOException {
        List<String> highScores = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return highScores; // Return an empty list if the file doesn't exist
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                highScores.add(line);
            }
        }

        return highScores;
    }

    // Optional: Display high scores from the list after importing
    public static void displayImportedHighScores(List<String> highScores) {
        if (highScores.isEmpty()) {
            System.out.println("No high scores imported!");
        } else {
            System.out.println("Imported High Scores:");
            for (String score : highScores) {
                System.out.println(score);
            }
        }
    }
}

