package application.Bullet;

import java.util.Timer;
import java.util.TimerTask;

import application.Model;
import application.Cover.CoverChunk;
import javafx.application.Platform;

public class CollisionTimer extends Timer {
	private Bullet bullet;
	private int delay = 0;
	private int rate = 15;

	public CollisionTimer(Bullet b) {
		bullet = b;
	}

	public void start() {
		this.schedule(task, delay, rate);
	}

	/*
	 * 
	 * 
	 * TASK
	 * 
	 * 
	 * 
	 */

	TimerTask task = new TimerTask() {
		public void run() {
			Platform.runLater(new Runnable() {
				public void run() {
					if (!bullet.getIsWithinBounds()) {
						bullet.delete();
						Model.homeController.deleteBullet(bullet);
					}
					// If bullet hits a cover chunk
					CoverChunk chunk = null;
					for (CoverChunk c : Model.coverChunkList) {
						if (bullet.getBoundsInParent().intersects(c.getBoundsInParent())) {
							chunk = c;
							Model.deleteBullet(bullet);
						}
					}
					if (chunk != null) {
						Model.deleteCoverChunk(chunk);
					}
				}
			});

		}
	};

}
