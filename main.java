import java.io.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

// Main class
class GFG {

    // Main driver method
    public static void main(String[] args)
    {
        // Creating instance of JFrame
        JFrame frame = new JFrame();

        // Creating instance of JButton
        JButton button = new JButton(" Start snake.io");

        // x axis, y axis, width, height
        button.setBounds(150, 200, 220, 50);

        // adding button in JFrame
        frame.add(button);

        // 400 width and 500 height
        frame.setSize(500, 600);

        // using no layout managers
        frame.setLayout(null);

        // making the frame visible
        frame.setVisible(true);

        setLayout(new BorderLayout());
        //////CREATE SWING COMPONENTS////////////
        //OUTPUT TEXT AREA
        uneditTextArea.setEditable(false);

        //INPUT TEXT AREA
        editTextArea.setBackground(Color.BLUE);
        editTextArea.setForeground(Color.WHITE)

        //SET CONTENT PANE
        Container c = getContentPane();

        //ADD COMPONENTS TO CONTENT PANE        
        c.add(uneditTextArea, BorderLayout.CENTER);
        c.add(editTextArea, BorderLayout.SOUTH);
        c.add(inputButton, BorderLayout.WEST);

    }
}