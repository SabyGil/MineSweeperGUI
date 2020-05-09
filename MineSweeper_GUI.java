import javax.swing.JFrame;
import javax.swing.JPanel;

public class MineSweeper_GUI {
    public static void main(String[] args) {

        JFrame appFrame = new JFrame();

        MineSweeperController control = new MineSweeperController(10, 10, 25);

        // holds buttons & layouts
        appFrame.add(control.getPanel());

        // // Set the frame's width (400) and height (250) in pixels
        appFrame.setSize(800, 750);

        // // Set the frame's title
        appFrame.setTitle("MineSweeper");

        // // Set the program to exit when the user
        // // closes the frame
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // // Make the frame visible to the user
        appFrame.setVisible(true);

    }

}
