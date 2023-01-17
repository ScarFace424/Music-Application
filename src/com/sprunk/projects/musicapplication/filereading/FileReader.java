package com.sprunk.projects.musicapplication.filereading;

import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import com.sprunk.projects.musicapplication.exception.AudioReadException;

public class FileReader {
    static final int BIT_RATE = 16;

    public AudioInputStream readFile(String fileName, String filePath) throws AudioReadException {
        String pathWithFile = filePath + fileName;
        InputStream fileStream = null;
        try {
            fileStream = getFileAsStream(pathWithFile);
        } catch(AudioReadException are) {
            System.out.println(are.getMessage());
        }
        
        AudioInputStream in = null;
        AudioInputStream out = null;
        try {
            in = AudioSystem.getAudioInputStream(fileStream);
            AudioFormat baseFormat = in.getFormat();
            AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 
                                                    baseFormat.getSampleRate(),
                                                    BIT_RATE,
                                                    baseFormat.getChannels(),
                                                    baseFormat.getFrameSize(),
                                                    baseFormat.getFrameRate(),
                                                    false);

            out = AudioSystem.getAudioInputStream(decodedFormat, in);
        } catch (Exception e) {
            throw new AudioReadException("Failed to interpret AudioFile!");
        } finally {
            if (in != null) { 
            in = null;
            out = null;
            }
        }

        return out;
    }

    private InputStream getFileAsStream(String pathWithFile) throws AudioReadException {
        InputStream stream = null;
        try {
            stream = getClass().getResourceAsStream(pathWithFile);
            return stream;
        } catch(Exception e) {
            throw new AudioReadException("Failed to read AudioFile!");
        } finally {
            try {
                if(stream != null)
                stream.close();
            } catch(IOException io) {
                throw new AudioReadException("Failed to close InputStream!");
            }
        }
    }
}