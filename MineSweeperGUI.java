import javax.swing.JFrame;
import javax.swing.JPanel;

public class MineSweeper_GUI {

    public static void main(String[] args) {
        System.out.println("Hello World");
        JFrame appFrame = new JFrame();

        // Set the frame's width (400) and height (250) in pixels
        appFrame.setSize(400, 250);

        // Set the frame's title
        appFrame.setTitle("An Empty Frame");

        // Set the program to exit when the user
        // closes the frame
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the frame visible to the user
        appFrame.setVisible(true);

    }
}
