package com.sprunk.projects.musicapplication.filereading;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;

public class FileReader {
    public AudioInputStream readFile(String fileName, String filePath) {
        File file = new File(filePath + fileName);
        AudioInputStream in = null;
        AudioInputStream din = null;
        try {
            in = AudioSystem.getAudioInputStream(file);
            AudioFormat baseFormat = in.getFormat();
            AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 
                                                    baseFormat.getSampleRate(),
                                                    16,
                                                    baseFormat.getChannels(),
                                                    baseFormat.getChannels() * 2,
                                                    baseFormat.getSampleRate(),
                                                    false);

            din = AudioSystem.getAudioInputStream(decodedFormat, in);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (in != null) { 
            in = null;
            din = null;
            }
        }

        return din;
    }
}