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
    }

    public Grid(int rows, int columns) {
        this.numRows = rows;
        this.numColumns = columns;
        this.numBombs = 25;

    }

    // (rows x columns Grid), default value of 25 bombs
    public Grid(int rows, int columns, int numBombs) {
        this.numRows = rows;
        this.numColumns = columns;
        this.numBombs = numBombs;

    } // (rows x columns Grid), numBombs as specified

    public int getNumRows() {

    }

    public int getNumColumns() {

    }

    public int getNumbBombs() {

    }

    public boolean getBombGrid() {

    }

    public int getCountGrid() {

    }

    public boolean isBombAtLocation(int row, int column) {

    }

    public int getCountAtLocation(int row, int column) {

    }

    public void createBombGrid() {
        // called by constructors to create and populate the bombGrid

    }

    public void createCountGrid() {

        // call
    }

}
