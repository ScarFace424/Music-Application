package com.sprunk.projects.musicapplication;

import com.sprunk.projects.musicapplication.display.UserInterface;
import com.sprunk.projects.musicapplication.playMusic.MusicPlayer;

public class Main {
    static final String TITLE = "Music Application";
	static final String MUSIC_FILE = "Nightcore - Floating In Love";
	static final String FILE_PATH = "./musicFiles/";

	public static void main(String[] args) {
	UserInterface.Frame(TITLE);
	MusicPlayer.play(MUSIC_FILE, FILE_PATH);
	}
}