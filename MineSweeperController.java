import java.awt.Color;

import javax.swing.JButton;

public class MineSweeperController {

    int numRows;
    int numCols;
    Grid grid;
    MineSweeperPanel panel;

    public MineSweeperController(int numRows, int numCols) {
        this.numCols = numCols;
        this.numRows = numRows;
        grid = new Grid(numRows, numCols);
        panel = new MineSweeperPanel(numRows, numCols);
        setActionListeners();

    }

    public void setActionListeners() {
        // Add clickEvents/actionListeners to grid buttons
        JButton[][] buttons = panel.getBtnGrid();
        for (int i = 0; i < buttons.length; i++) { // Rows
            for (int j = 0; j < buttons[i].length; j++) { // Columns
                JButton btn = buttons[i][j];
                int x = j; // Columns
                int y = i; // Rows
                btn.addActionListener((e) -> onCellClick(btn, x, y));
            }
        }
    }

    public void revealAllBtns() {
        JButton[][] buttons = panel.getBtnGrid();
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                JButton btn = buttons[i][j];
                if (grid.isBombAtLocation(i, j)) {
                    displayBomb(btn);
                } else {
                    displayCount(btn, i, j);
                }

            }
        }
    }

    public MineSweeperPanel getPanel() {
        return panel;
    }

    public void onCellClick(JButton btn, int x, int y) {
        System.out.println(x + "," + y + " was clicked");
        if (grid.isBombAtLocation(x, y)) {
            // btn.setBackground(Color.red);
            // btn.setText("X");
            displayBomb(btn);
            revealAllBtns();
        } else {
            // int count = grid.getCountAtLocation(x, y);
            // btn.setBackground(Color.GRAY);
            // btn.setText(count+"");
            displayCount(btn, x, y);
        }
    }

    public void displayBomb(JButton btn) {
        btn.setBackground(Color.red);
        btn.setText("X");
    }

    public void displayCount(JButton btn, int x, int y) {
        int count = grid.getCountAtLocation(x, y);
        btn.setBackground(Color.GRAY);
        btn.setText(count + "");
    }

    /*
     * If there is a bomb the game is over and the entire content of the grid is
     * revealed to the player so that cells containing bombs display a bomb, and
     * cells without bombs show their count.
     * 
     * if bomb is found - set gameOver to true - reveal grid -> each cell should
     * contain a boolean variable that if switched to true, toggles all cells at
     * once
     * 
     * need a variable to hold the number of non-bomb cells left -> make a var
     */

    public Grid getGrid() {
        return grid;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

}