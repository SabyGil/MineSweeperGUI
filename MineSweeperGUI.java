import javax.swing.JFrame;
<<<<<<< HEAD
import javax.swing.JPanel;

public class MineSweeper_GUI {
=======
import javax.swing.JButton;
>>>>>>> 24d163f5fa2dfbec3d9390efe5c895b4bf64b377

    public static void main(String[] args) {
        System.out.println("Hello World");
        JFrame appFrame = new JFrame();

        JButton button = new JButton("Click Here");  
        int xPos = 50, yPos = 100, wid = 100, hgt = 40;
        button.setBounds(xPos,yPos,wid,hgt);  

        appFrame.setLayout(null);

        appFrame.add(button);  
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
