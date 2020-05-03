import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class MineSweeper_GUI {

    public static void main(String[] args) {
        System.out.println("Hello World");
        // Use this command
        //  javac MineSweeper_GUI.java && java MineSweeper_GUI


        Grid board = new Grid();
        boolean[][] bombLocation = board.getBombGrid();
        
        displayGrid(bombLocation);


        // JFrame appFrame = new JFrame();

        // JButton button = new JButton("Click Here");  
        // int xPos = 50, yPos = 100, wid = 100, hgt = 40;
        // button.setBounds(xPos,yPos,wid,hgt);  

        // appFrame.setLayout(null);

        // appFrame.add(button);  
        // // Set the frame's width (400) and height (250) in pixels
        // appFrame.setSize(400, 250);

        // // Set the frame's title
        // appFrame.setTitle("An Empty Frame");

        // // Set the program to exit when the user
        // // closes the frame
        // appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // // Make the frame visible to the user
        // appFrame.setVisible(true);

    }

    public static void displayGrid(boolean grid[][]) {
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
