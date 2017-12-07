package application.Enemy;

import java.util.Timer;
import java.util.TimerTask;

import application.Model;
import application.Enemy.Bullet.EnemyBullet;
import javafx.application.Platform;

public class EnemyTimer extends Timer {
	private Enemy enemy;
	private double delay = 0;
	private double rate = 0;
	private double minimumDelay = 2000;
	private double minimumRate = 2000;
	private double maximumDelay = 4000;
	private double maximumRate = 4000;
	long newDelay;
	long newRate;

	public EnemyTimer(Enemy e) {
		int index = 0;
		while (delay <= minimumDelay || delay >= maximumDelay) {
			System.out.println("index: " + index);
			delay = Math.random() * 10000;
			index++;
		}
		while (rate <= minimumRate || rate >= maximumRate) {
			rate = Math.random() * 10000;
		}
		newDelay = Math.round(delay);
		newRate = Math.round(rate);
		System.out.println("delay " + newDelay);
		System.out.println("rate " + newRate);
		enemy = e;
	}

	public void start() {
		schedule(task, newDelay, newRate);
	}

	/*
	 * 
	 * 
	 * TASK
	 * 
	 * 
	 * 
	 */

	private TimerTask task = new TimerTask() {
		public void run() {
			Platform.runLater(new Runnable() {
				public void run() {
					// if (bullets < limit) {
					EnemyBullet b = new EnemyBullet(enemy);
					Model.homeController.getPane().getChildren().add(b);
					// bullets++;
					// }
				}
			});
		}
	};

}
