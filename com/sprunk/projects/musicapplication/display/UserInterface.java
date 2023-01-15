package com.sprunk.projects.musicapplication.display;
import javax.swing.JFrame;

public class UserInterface {
    static final String TITLE = "Music Application";
    static final int WINDOW_WIDTH = 450;
    static final int WINDOW_LENGTH = 450;
    public static void Frame() {
        JFrame frame = new JFrame();
        frame.setDefaultOnCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(TITLE);
        //Implement image that is displayed as icon
        frame.setVisible(true);
        frame.setSize(WINDOW_WIDTH, WINDOW_LENGTH);
        frame.setLocation(500, 500);
        frame.setResizeable(false);
    }
}