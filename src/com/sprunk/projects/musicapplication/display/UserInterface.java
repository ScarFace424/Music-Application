package com.sprunk.projects.musicapplication.display;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class UserInterface {
    //write config to store the settings
    static final int WINDOW_WIDTH = 450;
    static final int WINDOW_LENGTH = 450;
    
    public static void Frame(String name, String title) {
        JFrame frame = new JFrame(name);
        JPanel panel = new JPanel(new FlowLayout());
        JLabel label = new JLabel(title);
        JButton playButton = new JButton("PLAY");
        panel.add(label);
        panel.add(playButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Implement image that is displayed as icon
        //create custom buttons
        frame.setVisible(true);
        frame.setSize(WINDOW_WIDTH, WINDOW_LENGTH);
        frame.setLocation(500, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.show();
        frame.toFront();
        frame.repaint();
    }
}