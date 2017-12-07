package application.Avatar;

import java.util.Timer;
import java.util.TimerTask;

import application.Model;
import javafx.application.Platform;

public class AvatarTimer extends Timer {
	private int delay = 0;
	private int rate = 15;

	public AvatarTimer() {

	}

	public void start() {
		this.schedule(task, delay, rate);
	}

	// public void stop() {
	// cancel();
	// }

	/*
	 * 
	 * 
	 * TASK
	 * 
	 * 
	 * 
	 */

	private TimerTask task = new TimerTask() {
		private final double ORIGINALPACE = 5;
		private double pace = ORIGINALPACE;

		public void run() {
			Platform.runLater(new Runnable() {
				public void run() {
					int booleans = 0;
					int arrows = 0;
					pace = ORIGINALPACE;
					if (Model.avatar.iswPressed()) {
						booleans++;
					}
					if (Model.avatar.isaPressed()) {
						booleans++;
					}
					if (Model.avatar.issPressed()) {
						booleans++;
					}
					if (Model.avatar.isdPressed()) {
						booleans++;
					}
					if (Model.avatar.isRotating()) {
						pace = pace / 2;
					}
					if (booleans > 1) {
						pace = pace / 2;
					}

					if (Model.avatar.iswPressed()) {
						System.out.println("w Pressed");
						if (Model.avatar.getLayoutY() >= Model.homeScene.getHeight() - 300) {
							Model.avatar.moveUp(pace);
						}
					}
					if (Model.avatar.isaPressed()) {
						System.out.println("a Pressed");
						if (Model.avatar.getLayoutX() > 0) {
							Model.avatar.moveLeft(pace);
						}
					}
					if (Model.avatar.issPressed()) {
						System.out.println("s Pressed");
						if (Model.avatar.getLayoutY() < Model.homeScene.getHeight() - Model.avatar.getPrefHeight()) {
							Model.avatar.moveDown(pace);
						}
					}
					if (Model.avatar.isdPressed()) {
						System.out.println("d Pressed");
						if (Model.avatar.getLayoutX() < Model.homeScene.getWidth() - Model.avatar.getPrefWidth()) {
							Model.avatar.moveRight(pace);
						}
					}

				}
			});
		}

	};

}
