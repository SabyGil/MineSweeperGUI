import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class MineSweeper_GUI {

    public static void main(String[] args) {
        System.out.println("Hello World");
        // Use this command
        // javac MineSweeper_GUI.java && java MineSweeper_GUI

        // 0 | 0 | 1 | 2 | T | 1 | 0 | 0 | 1 | T
        // ---------------------------------------
        // 1 | 1 | 3 | T | 3 | 1 | 1 | 1 | 3 | 2
        // ---------------------------------------
        // 2 | T | 3 | T | 2 | 0 | 1 | T | 3 | T
        // ---------------------------------------
        // T | 3 | 3 | 3 | 2 | 1 | 1 | 2 | T | 2
        // ---------------------------------------
        // 2 | 3 | T | 2 | T | 1 | 0 | 1 | 1 | 1
        // ---------------------------------------
        // T | 2 | 1 | 2 | 1 | 1 | 0 | 0 | 0 | 0
        // ---------------------------------------
        // 2 | 2 | 1 | 0 | 1 | 2 | 3 | 3 | 2 | 1
        // ---------------------------------------
        // 2 | T | 2 | 1 | 3 | T | T | T | T | 1
        // ---------------------------------------
        // T | 3 | 2 | T | 3 | T | 6 | T | 6 | 3
        // ---------------------------------------
        // T | 2 | 1 | 1 | 2 | 1 | 3 | T | T | T

        JFrame appFrame = new JFrame();
        JPanel panel = new JPanel();
        JButton refresh = new JButton("Refresh");

        panel.setLayout(new BorderLayout());
        panel.add(refresh, BorderLayout.NORTH);

        MineSweeperController control = new MineSweeperController(10, 10);
        boolean[][] bombLocation = control.getGrid().getBombGrid();
        int[][] counts = control.getGrid().getCountGrid();
        displayGrid(bombLocation, counts);

        appFrame.add(control.getPanel());

        // // Set the frame's width (400) and height (250) in pixels
        appFrame.setSize(600, 550);

        // // Set the frame's title
        appFrame.setTitle("An Empty Frame");

        // // Set the program to exit when the user
        // // closes the frame
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // // Make the frame visible to the user
        appFrame.setVisible(true);

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

        System.out.println("There are " + count + " many bombs");
    }

}
