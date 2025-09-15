package game;

import java.util.ArrayList;
import java.util.Collections;

public class PuzzleBoard extends GameBoard {
    private int[][] grid;
    private int emptyRow, emptyCol;

    public PuzzleBoard() {
        super(4); 
        grid = new int[size][size];
        initializeGrid();
        shuffleGrid();
    }

    private void initializeGrid() {
        int num = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (num < size * size) {
                    grid[i][j] = num++;
                } else {
                    grid[i][j] = 0;
                    emptyRow = i;
                    emptyCol = j;
                }
            }
        }
    }

    private void shuffleGrid() {
        ArrayList<Integer> tiles = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tiles.add(grid[i][j]);
            }
        }
        Collections.shuffle(tiles);

        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = tiles.get(index++);
                if (grid[i][j] == 0) {
                    emptyRow = i;
                    emptyCol = j;
                }
            }
        }
    }

    public int[][] getGrid() {
        return grid;
    }

    @Override
    public void displayBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print((grid[i][j] == 0 ? "  " : grid[i][j]) + "\t");
            }
            System.out.println();
        }
    }

    @Override
    public boolean moveTile(char direction) {
        int newRow = emptyRow, newCol = emptyCol;

        switch (direction) {
            case 'W': newRow--; break; // Move up
            case 'A': newCol--; break; // Move left
            case 'S': newRow++; break; // Move down
            case 'D': newCol++; break; // Move right
            default: return false;
        }

        if (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size) {
            grid[emptyRow][emptyCol] = grid[newRow][newCol];
            grid[newRow][newCol] = 0;
            emptyRow = newRow;
            emptyCol = newCol;
            return true;
        }
        return false;
    }

    @Override
    public boolean isSolved() {
        int num = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == size - 1 && j == size - 1) {
                    return grid[i][j] == 0;
                }
                if (grid[i][j] != num++) {
                    return false;
                }
            }
        }
        return true;
    }
}

