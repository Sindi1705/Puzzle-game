package game;

import java.util.Scanner;

public class PuzzleGame {
    public static void main(String[] args) {
        PuzzleBoard puzzleBoard = new PuzzleBoard();
        Scanner scanner = new Scanner(System.in);
        
        // Show the initial board
        puzzleBoard.displayBoard();

        // Loop for user input to move tiles
        while (!puzzleBoard.isSolved()) {
            System.out.println("Enter a move (W = up, A = left, S = down, D = right): ");
            char move = scanner.next().toUpperCase().charAt(0);

            if (puzzleBoard.moveTile(move)) {
                puzzleBoard.displayBoard();
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        System.out.println("Congratulations, you solved the puzzle!");
        scanner.close();
    }
}
