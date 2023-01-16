package com.sprunk.projects.musicapplication;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import com.sprunk.projects.musicapplication.display.UserInterface;
import com.sprunk.projects.musicapplication.playmusic.MusicPlayer;
import com.sprunk.projects.musicapplication.filereading.Filter;
import com.sprunk.projects.musicapplication.filereading.FileReader;

public class Main {
    static final String TITLE = "Music Application";
	static final String MUSIC_FILE = "Nightcore - Floating In Love";
	static final String FILE_PATH = "/musicFiles/";

	public static void main(String[] args) {
		File file = new File("");
		String absolutePath = file.getAbsolutePath();
		Filter filter = new Filter(MUSIC_FILE);
		UserInterface.Frame(TITLE, MUSIC_FILE);
		FileReader fileReader = new FileReader();
		AudioInputStream audio = fileReader.readFile(MUSIC_FILE, absolutePath + FILE_PATH);
	}
}