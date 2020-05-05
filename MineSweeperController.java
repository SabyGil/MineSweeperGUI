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
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                JButton btn = buttons[i][j];
                int x = j; int y = i;
                btn.addActionListener((e) -> onCellClick(btn, x, y));
            }
        }
    }
    
    public MineSweeperPanel getPanel(){
        return panel;
    } 

    public void onCellClick(JButton btn, int x, int y) {
        System.out.println(x + "," + y + " was clicked");
        if (grid.isBombAtLocation(x, y)) {
            btn.setBackground(Color.red);
            btn.setText("X");
        } else {
            int count = grid.getCountAtLocation(x, y);
            btn.setBackground(Color.GRAY);
            btn.setText(count+"");
        }
    }
  
    
    public Grid getGrid(){
        return grid;
    }

    public int getNumRows(){
        return numRows;
    }

    public int getNumCols(){
        return numCols;
    }
}