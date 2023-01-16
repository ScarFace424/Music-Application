pachage com.sprunk.projects.musicapplication.playMusic;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicPlayer {
    public static void play(String music, String filePath) {
        Media hit = new Media(new File(music).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }
}