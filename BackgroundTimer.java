package application;

import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.image.Image;

public class BackgroundTimer extends Timer {
	private int index = 0;
	private double opacity = 0.7;
	private int delay = 0;
	private int rate = 45;
	private int numberOfFrames = 180;
	// private String soundSourceFolder = "Sounds";

	// private String soundFile = getClass().getResource("/Sounds/8 bit
	// music.wav");
	// private Media sound = new Media(new File(soundFile).toURI().toString());
	// private MediaPlayer mediaPlayer = new MediaPlayer(sound);

	private Runnable timerRunnable = new Runnable() {
		public void run() {
			System.out.println("runnable...");
			// mediaPlayer = new MediaPlayer(sound);
			// mediaPlayer.play();
		}
	};

	public BackgroundTimer() {
		Model.homeController.getBackgroundImageView().setOpacity(opacity);
		Thread thread = new Thread(timerRunnable);
		thread.start();
		// mediaPlayer.setOnEndOfMedia(timerRunnable);

		//

	}

	public void start() {
		this.schedule(updateBackground, delay, rate);
	}

	/*
	 * 
	 * 
	 * TASK
	 * 
	 * 
	 * 
	 */

	TimerTask updateBackground = new TimerTask() {
		public void run() {

			if (index <= numberOfFrames) {
				Model.homeController.getBackgroundImageView().setImage(new Image("space-" + index + ".gif"));
				index++;
			} else {
				index = 0;
			}

		}
	};

}
