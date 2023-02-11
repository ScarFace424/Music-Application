package com.sprunk.projects.musicapplication.playmusic;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.Clip;
import com.sprunk.projects.musicapplication.options.AudioOptions;

public class MusicPlayer {
      
    // to store current position
    Long currentFrame;
    Clip clip;
      
    // current status of clip
    //String status;
      
    AudioInputStream audioInputStream;
  
    // constructor to initialize streams and clip
    public MusicPlayer() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // create AudioInputStream object
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
          
        // create clip reference
        clip = AudioSystem.getClip();
          
        // open audioInputStream to the clip
        clip.open(audioInputStream);
          
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void gotoChoice(int c) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        switch (c) 
        {
            case 1:
                AudioOptions.pause();
                break;
            case 2:
                AudioOptions.resumeAudio();
                break;
            case 3:
                AudioOptions.restart();
                break;
            case 4:
                AudioOptions.stop();
                break;
            case 5:
                System.out.println("Enter time (" + 0 + 
                ", " + clip.getMicrosecondLength() + ")");
                Scanner sc = new Scanner(System.in);
                long c1 = sc.nextLong();
                AudioOptions.jump(c1);
                break;
      
        }
      
    }
}