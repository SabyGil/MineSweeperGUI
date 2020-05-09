import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;

public class MineSweeperPanel extends JPanel {
    private JButton[][] btnGrid;

    public MineSweeperPanel(int rows, int columns) {
        // this.color = Color.BLUE;
        setBackground(Color.BLUE);
        JButton refreshBtn = new JButton("Refresh");

        add(refreshBtn);
        JPanel gridPanel = new JPanel(new GridLayout(rows, columns));
        btnGrid = new JButton[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                JButton btn = new JButton(" ");
                btn.setPreferredSize(new Dimension(50, 50));
                btn.setBackground(Color.ORANGE);
                btnGrid[i][j] = btn;
                gridPanel.add(btnGrid[i][j]);
            }
        }

        add(gridPanel);
    }

    public JButton[][] getBtnGrid() {
        return btnGrid;
    }
}

/*
 * (40 pts) Create a GUI using the java Swing package so that it behaves as
 * follows. (10 pts) Display the grid, matching the dimensions as specified in
 * the Grid class, hiding the content of all the cells. (10 pts) Each cell in
 * the GUI’s grid should be a JButton with its own ActionListener.
 * 
 */

// public BasicRectangle(Graphics g){
// x = 5;
// y = 5;
// width = 20;
// height = 50;
// color = Color.BLUE;
// paintComponent(g);
// }
// btn.
// public void paintComponent(Graphics g){
// g.setColor(this.color);
// if(fillShape){
// g.fillRect(x,y,width,height);
// }
// else{
// g.drawRect(x, y, width, height);
// }
// }