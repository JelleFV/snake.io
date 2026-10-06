import javax.swing.JButton;
import javax.swing.JFrame;

// Main class
class GFG {

    // Main driver method
    public static void main(String[] args)
    {
        // Creating start menu
        JFrame frame = new JFrame();
        JButton button = new JButton(" Start snake.io");
        button.setBounds(640, 360, 200, 50);
        frame.add(button);
        frame.setSize(GamePanel.Width, GamePanel.Height);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        
    }
}