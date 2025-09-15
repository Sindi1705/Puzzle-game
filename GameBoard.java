package game;

public abstract class GameBoard {
    protected int size;

    public GameBoard(int size) {
        this.size = size;
    }

    public abstract void displayBoard();
    public abstract boolean moveTile(char direction);
    public abstract boolean isSolved();
}
