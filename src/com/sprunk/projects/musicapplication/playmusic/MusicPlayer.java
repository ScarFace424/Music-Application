package com.sprunk.projects.musicapplication.playmusic;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.IOException;

public class MusicPlayer {
    public static void play(AudioInputStream musicStream) {
        Clip clip;
        try {
            try {
                clip = AudioSystem.getClip();
                clip.open(musicStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY); 
            } catch(LineUnavailableException e) {
                System.out.println("LineUnavailableException");
            }
        } catch (IOException io) {
            System.out.println("IOException");
        }
        //https://www.geeksforgeeks.org/play-audio-file-using-java/
        //https://stackoverflow.com/questions/2158/creating-a-custom-jbutton-in-java
    }   
}