package com.sprunk.projects.musicapplication.display;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class UserInterface {
    //write config to store the settings
    static final int WINDOW_WIDTH = 450;
    static final int WINDOW_LENGTH = 450;
    
    public static void Frame(String title) {
        JFrame frame = new JFrame(title);
        JPanel panel = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Music title");
        panel.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setTitle(TITLE);
        //Implement image that is displayed as icon
        frame.setVisible(true);
        frame.setSize(WINDOW_WIDTH, WINDOW_LENGTH);
        frame.setLocation(500, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.show();
    }
}