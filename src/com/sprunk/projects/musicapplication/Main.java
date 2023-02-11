package com.sprunk.projects.musicapplication;

import java.io.File;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import com.sprunk.projects.musicapplication.display.UserInterface;
import com.sprunk.projects.musicapplication.playmusic.MusicPlayer;
import com.sprunk.projects.musicapplication.filereading.Filter;
import com.sprunk.projects.musicapplication.filereading.FileReader;

public class Main {
    static final String TITLE = "Music Application";
	static final String MUSIC_FILE = "Nightcore - Floating In Love";
	static final String FILE_PATH = "/musicFiles/";
	/*
	public static void main(String[] args) {
		File file = new File("");
		String absolutePath = file.getAbsolutePath();
		Filter filter = new Filter(MUSIC_FILE);
		UserInterface.Frame(TITLE, MUSIC_FILE);
		FileReader fileReader = new FileReader();
		AudioInputStream audio = fileReader.readFile(MUSIC_FILE, absolutePath + FILE_PATH);
	}
	*/

	public static void main(String[] args) {
        try {
            String filePath = FILE_PATH + MUSIC_FILE;
            MusicPlayer player = new MusicPlayer();
            audioPlayer.play();
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("1. pause");
                System.out.println("2. resume");
                System.out.println("3. restart");
                System.out.println("4. stop");
                System.out.println("5. Jump to specific time");
                int c = sc.nextInt();
                audioPlayer.Choice.gotoChoice(c);
                if (c == 4)
                break;
            }

            sc.close();
        } 
          
        catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
}