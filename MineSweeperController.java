import java.awt.Color;
import java.util.Set;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MineSweeperController {

    int numRows;
    int numCols;
    int numBombs;
    Grid grid;
    int cellsLeft;
    MineSweeperPanel panel;

    public MineSweeperController(int numRows, int numCols, int numBombs) {
        this.numCols = numCols;
        this.numRows = numRows;
        this.numBombs = numBombs;
        panel = new MineSweeperPanel(this.numRows, this.numCols);
        setActionListeners();
        this.newGame();
    }

    public void newGame() {
        grid = new Grid(this.numRows, this.numCols, this.numBombs);
        panel.resetButtons();
        this.cellsLeft = (this.numCols * this.numRows) - this.numBombs;

        // THIS DISPLAY IN CONSOLE 
        displayGrid(grid.getBombGrid(), grid.getCountGrid());
    }

    public void setActionListeners() {
        // Add clickEvents/actionListeners to grid buttons
        JButton[][] buttons = panel.getBtnGrid();
        for (int i = 0; i < buttons.length; i++) { // row
            for (int j = 0; j < buttons[i].length; j++) { // col
                int x = i; // x = COLUMN
                int y = j; // y = ROW
                JButton btn = buttons[i][j];
                btn.addActionListener((e) -> onCellClick(btn, x, y));
            }
        }

        panel.refreshBtn.addActionListener((e) -> this.newGame());
    }

    public Grid getGrid() {
        return grid;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public MineSweeperPanel getPanel() {
        return panel;
    }

    public void revealAllBtns() {
        JButton[][] buttons = panel.getBtnGrid();
        for (int x = 0; x < buttons.length; x++) {
            for (int y = 0; y < buttons[x].length; y++) {
                JButton btn = buttons[x][y];
                btn.setEnabled(false);

                // btn.setForeground(Color.BLACK);
                // btn.setForeground(Color.getColor("202,198,202"));
                if (grid.isBombAtLocation(x, y)) {
                    displayBomb(btn);
                } else {
                    displayCount(btn, x, y);
                }

            }
        }
    }

    public void onCellClick(JButton btn, int x, int y) {
        // System.out.println(x + "," + y + " was clicked");
        if (grid.isBombAtLocation(x, y)) {
            displayBomb(btn);
            revealAllBtns();
            JOptionPane.showMessageDialog(null, "You lose! ");
            playAgain();
        } else { 
            if (grid.getCountAtLocation(x, y) == 0) {
                Set<String> set = new HashSet<String>();
                revealAround(x, y, set, x, y);
            } else {
                displayCount(btn, x, y);
            }

            if (this.cellsLeft == 0) {
                System.out.println("You won!");
                JOptionPane.showMessageDialog(null, "You win!");
                playAgain();
            }
        }
    }

    public void revealAround(int x, int y, Set<String> visited, int prevX, int prevY) {
        JButton[][] buttons = panel.getBtnGrid();
        if (!grid.isWithinBounds(x, y)) {// is in bounds
            return;
        }
        if (grid.isBombAtLocation(x, y)) {
            return;
        }
        if (visited.contains(x + "," + y)) { // already visited there
            return;
        }
        if (grid.getCountAtLocation(prevX, prevY) == 0 && grid.getCountAtLocation(x, y) != 0) {
            visited.add(x + "," + y); // Remember that we visited here
            displayCount(buttons[x][y], x, y);
            return;
        }
        if (grid.getCountAtLocation(x, y) != 0) {
            // if not 0 values, return
            return;
        }
        

        visited.add(x + "," + y); // Remember that we visited here
        displayCount(buttons[x][y], x, y);
        revealAround(x + 1, y, visited, x, y); // right
        revealAround(x - 1, y, visited, x, y); // left
        revealAround(x, y + 1, visited, x, y); // down
        revealAround(x, y - 1, visited, x, y); // up
        revealAround(x + 1, y + 1, visited, x, y); // BR
        revealAround(x + 1, y - 1, visited, x, y); // TR
        revealAround(x - 1, y + 1, visited, x, y); // BL
        revealAround(x - 1, y - 1, visited, x, y); // TL
    }

    public void playAgain() {
        int a = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
        if (a == JOptionPane.YES_OPTION) {
            newGame();
        } else {
            System.out.println("Alright, thanks for playing!");
        }
    }

    public void displayBomb(JButton btn) {
        btn.setBackground(new Color(90, 147, 122));
        btn.setText("X");
    }

    public void displayCount(JButton btn, int x, int y) {
        System.out.println("Revealing - [" + x + ", " + y + "]");
        int count = grid.getCountAtLocation(x, y);
        btn.setBackground(new Color(220, 220, 220));
        btn.setText(count + "");
        // btn.setFont(new Font("Courier New", Font.PLAIN, 14));
        // btn.setForeground(new Color(count * 25, count * 15, count * 24));
        this.cellsLeft--;
    }

    public static void displayGrid(boolean grid[][], int counts[][]) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                String sym;
                if (grid[i][j]) {
                    sym = ">" + String.valueOf(counts[i][j]);
                } else {
                    sym = " " + String.valueOf(counts[i][j]);
                }
                System.out.print(sym);

                if (grid[i][j] == true) {
                    count++;
                }
                if (j != grid[i].length - 1)
                    System.out.print(" |");
            }

            if (i != grid.length - 1)
                System.out.print("\n" + "---------------------------------------");
            System.out.println();
        }

        System.out.println("There are " + count + " bombs");
    }
}