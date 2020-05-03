import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class MineSweeper_GUI {

    public static void main(String[] args) {
        System.out.println("Hello World");
        // Use this command
        //  javac MineSweeper_GUI.java && java MineSweeper_GUI


        Grid board = new Grid(); //creates bombgrid and count grid
        boolean[][] bombLocation = board.getBombGrid();
        int[][] counts = board.getCountGrid();

        displayGrid(bombLocation, counts);

        //  0 | 0 | 1 | 2 | T | 1 | 0 | 0 | 1 | T 
        // ---------------------------------------
        //  1 | 1 | 3 | T | 3 | 1 | 1 | 1 | 3 | 2
        // ---------------------------------------
        //  2 | T | 3 | T | 2 | 0 | 1 | T | 3 | T
        // ---------------------------------------
        //  T | 3 | 3 | 3 | 2 | 1 | 1 | 2 | T | 2
        // ---------------------------------------
        //  2 | 3 | T | 2 | T | 1 | 0 | 1 | 1 | 1
        // ---------------------------------------
        //  T | 2 | 1 | 2 | 1 | 1 | 0 | 0 | 0 | 0
        // ---------------------------------------
        //  2 | 2 | 1 | 0 | 1 | 2 | 3 | 3 | 2 | 1
        // ---------------------------------------
        //  2 | T | 2 | 1 | 3 | T | T | T | T | 1
        // ---------------------------------------
        //  T | 3 | 2 | T | 3 | T | 6 | T | 6 | 3
        // ---------------------------------------
        //  T | 2 | 1 | 1 | 2 | 1 | 3 | T | T | T

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

    public static void displayGrid(boolean grid[][], int counts[][]) {
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                String sym; 
                if (grid[i][j]) {
                    sym = " X";
                 } else {
                    sym = " " + String.valueOf(counts[i][j]);
                 } 
                System.out.print(sym);

                if( grid[i][j] == true ) {
                    count++;
                }
                if(j != grid[i].length-1) 
                    System.out.print(" |");
            }
        
            if(i != grid.length-1)
                System.out.print("\n" + "---------------------------------------");
            System.out.println();
        }

        System.out.println("There are " + count + " many bombs");
    }
    
}
