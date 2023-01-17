package com.sprunk.projects.musicapplication.playmusic;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlayer {
    public static void play(AudioInputStream musicStream) {
        Clip clip;
        clip = AudioSystem.getClip();
        clip.open(musicStream);
    }
    
}