import java.util.Random;
import java.util.*;

public class Grid {
    private boolean bombGrid[][];
    private int[][] countGrid;
    private int numRows;
    private int numColumns;
    private int numBombs;

    public Grid() {
        // 10 rows, 10 columns, (10 x 10 Grid), 25 bombs
        this.numRows = 10;
        this.numColumns = 10;
        this.numBombs = 25;
        createBombGrid();
        createCountGrid();
    }

    public Grid(int rows, int columns) {
        this.numRows = rows;
        this.numColumns = columns;
        this.numBombs = 25;
        createBombGrid();
        createCountGrid();
    }

    // (rows x columns Grid), default value of 25 bombs
    public Grid(int rows, int columns, int numBombs) {
        this.numRows = rows;
        this.numColumns = columns;
        this.numBombs = numBombs;
        createBombGrid();
        createCountGrid();
    } // (rows x columns Grid), numBombs as specified

    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public int getNumbBombs() {
        return numBombs;
    }

    public boolean[][] getBombGrid() {
        return bombGrid;
    }

    public int[][] getCountGrid() {
        return countGrid;
    }

    public boolean isBombAtLocation(int row, int column) {
        // returns false if no bomb at location
        return bombGrid[row][column];
    }

    public int getCountAtLocation(int row, int column) {
        return countGrid[row][column];
    }

    private void createBombGrid() {
        // called by constructors to create and populate the bombGrid
        bombGrid = new boolean[numRows][numColumns];
        Set<String> set = new HashSet<>();
        String key = "";

        Random rand = new Random();
        for (int i = 0; i < numBombs; i++) {
            int x = rand.nextInt(numRows); // some x
            int y = rand.nextInt(numColumns); // some y

            // make sure we have 25 bombs
            key = x + "," + y; // Example: 0,0 or 12,1

            if (set.contains(key)) // have we seen position before?
                i--; // Yes, we already put a bomb there. Repeat iteration.
            else
                set.add(key); // No, first time placing bomb here, add key.

            bombGrid[x][y] = true;
        }
    }

    private void createCountGrid() {
        // traverse 2d arr & set number of surronding bombs in current slot
        // Also becareful with out of bounds
        // Also include current slot in count
        // if ( current slot is a bomb ) -> do the surrounding bomb count anyways

        // x y
        // current slot = 1,1;
        // left = [x-1], [y]
        // right = [x+1], [y]
        // diagonalBR = [x+1], [y+1]
        // diagonalBL = [x-1], [y+1]
        // up = [y+1]
        // down = [y-1]
        // topLeft = [y - 1], [x - 1]
        // topRight = [y - 1], [x + 1]

        countGrid = new int[numRows][numColumns];
        for (int x = 0; x < countGrid.length; x++) {
            for (int y = 0; y < countGrid[x].length; y++) { // bug
                int count = 0;

                // WARNING: Have check on the left, b/c doing running rightside
                // first could throw IndexOutOfBoundsException

                boolean down = isWithinBounds(x, y + 1) && bombGrid[x][y + 1];
                boolean up = isWithinBounds(x, y - 1) && bombGrid[x][y - 1];
                boolean left = isWithinBounds(x - 1, y) && bombGrid[x - 1][y];
                boolean right = isWithinBounds(x + 1, y) && bombGrid[x + 1][y];
                boolean diagBotLeft = isWithinBounds(x - 1, y + 1) && bombGrid[x - 1][y + 1];
                boolean diagBotRight = isWithinBounds(x + 1, y + 1) && bombGrid[x + 1][y + 1];
                boolean diagTopLeft = isWithinBounds(x - 1, y - 1) && bombGrid[x - 1][y - 1];
                boolean diagTopRight = isWithinBounds(x + 1, y - 1) && bombGrid[x + 1][y - 1];

                // Tally counts of bombs around our current slot.
                if (up) {
                    count++;
                }
                if (down) {
                    count++;
                }
                if (left) {
                    count++;
                }
                if (right) {
                    count++;
                }
                if (diagBotLeft) {
                    count++;
                }
                if (diagBotRight) {
                    count++;
                }
                if (diagTopLeft) {
                    count++;
                }
                if (diagTopRight) {
                    count++;
                }

                // set total num of bombs counted around this position to count
                countGrid[x][y] = count;
            }
        }

        // 0 | 0 | 1 | X
        // -------------------
        // 1 | 1 | 2 | 2
        // -------------------
        // X | 1 | 1 | X
        // -------------------
        // 1 | 1 | 1 | 1
        // call

    }

    public boolean isWithinBounds(int x, int y) {
        boolean returnValue = false;
        if (x >= 0 && x < numRows && y >= 0 && y < numColumns)
            returnValue = true;

        return returnValue;
    }

}
