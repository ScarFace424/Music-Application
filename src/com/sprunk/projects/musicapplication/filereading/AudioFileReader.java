package com.sprunk.projects.musicapplication.filereading;

import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.InputStream;
import java.io.IOException;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import com.sprunk.projects.musicapplication.exception.AudioReadException;

public class AudioFileReader {          //TODO MP3 Files cant be played, find a solution 
    static final int BIT_RATE = 16;     //WAV files are accepted, but bigger

    public AudioInputStream readFile(String fileName) throws AudioReadException {
        Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
        File file = new File(path + "/musicFiles/" + fileName + ".mp3");    //
        
        /*
        String pathWithFile = filePath + fileName;
        InputStream fileStream = null;
        try {
            fileStream = getFileAsStream(pathWithFile);
        } catch(AudioReadException are) {
            System.out.println(are.getMessage());
        }
        */

        AudioInputStream in = null;
        AudioInputStream out = null;
        try {
            in = AudioSystem.getAudioInputStream(file);
            AudioFormat baseFormat = in.getFormat();
            AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 
                                                    baseFormat.getSampleRate(),
                                                    BIT_RATE,
                                                    baseFormat.getChannels(),
                                                    baseFormat.getFrameSize(),
                                                    baseFormat.getFrameRate(),
                                                    false);

            out = AudioSystem.getAudioInputStream(decodedFormat, in);
        } catch (UnsupportedAudioFileException e) {
            throw new AudioReadException("AudioFile not supported!");
        } catch(IOException io) {
            throw new AudioReadException("Failed to interpret AudioFile!");
        } finally {
            if (in != null || out != null) { 
            in = null;
            out = null;
            }
        }

        return out;
    }
    /*
    private InputStream getFileAsStream(String pathWithFile) throws AudioReadException {
        //ClassLoader cl = this.getClass().getClassLoader();
        InputStream stream = null;
        try {
            stream = getClass().getResourceAsStream(pathWithFile);
            return stream;
        } catch(Exception e) {
            throw new AudioReadException("Failed to read AudioFile!");
        } finally {
            try {
                if(stream != null) {
                    stream.close();
                } else {
                    throw new AudioReadException("The FileStream is empty!");
                }
                
            } catch(IOException io) {
                throw new AudioReadException("Failed to close InputStream!");
            }
        }
    }
    */
}