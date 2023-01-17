package com.sprunk.projects.musicapplication;

import javax.sound.sampled.AudioInputStream;
import com.sprunk.projects.musicapplication.display.UserInterface;
import com.sprunk.projects.musicapplication.playmusic.MusicPlayer;
import com.sprunk.projects.musicapplication.filereading.Filter;
import com.sprunk.projects.musicapplication.filereading.AudioFileReader;
import com.sprunk.projects.musicapplication.exception.AudioReadException;

public class Main {
    static final String TITLE = "Music Application";
	static final String MUSIC_FILE = "  WAV-File ";

	public static void main(String[] args) {
		Filter filter = new Filter(MUSIC_FILE);
		UserInterface.Frame(TITLE, MUSIC_FILE);
		AudioFileReader audioFileReader = new AudioFileReader();
		AudioInputStream audio = null;
		try {
			audio = audioFileReader.readFile(MUSIC_FILE);
		} catch(AudioReadException are) {
			System.out.println(are.getMessage());
		}

		MusicPlayer.play(audio);		
	}
}