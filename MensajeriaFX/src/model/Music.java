package model;

import java.nio.file.Paths;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music {
	MediaPlayer mediaPlayer;
	String music;
	public void music(String music) {
		this.music=music;
		Media h = new Media(Paths.get(music).toUri().toString());
		mediaPlayer = new MediaPlayer(h);
		mediaPlayer.play();
	}
	
	public String getMusic() {
		return music;
	}
	public void setMusic(String music) {
		this.music = music;
	}

}