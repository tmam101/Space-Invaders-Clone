package application.Enemy.Column;

import java.util.Timer;
import java.util.TimerTask;

import application.Model;
import application.Enemy.Enemy;
import javafx.application.Platform;

public class ColumnManager extends Timer {
	private int delay = 0;
	private int rate = 15;

	public ColumnManager() {
	}

	public void start() {
		schedule(moveEnemies, delay, rate);
	}

	/*
	 * 
	 * 
	 * TASK
	 * 
	 * 
	 * 
	 */

	private TimerTask moveEnemies = new TimerTask() {
		double enemyMovementIndex = 0;
		double start = 0;
		double end = 1200;
		double rateX = 0.5;
		double rateY = 0.25;

		public void run() {
			Platform.runLater(new Runnable() {
				public void run() {

					if (enemyMovementIndex < ((end / 3))) {
						for (Enemy e : Model.enemyList) {
							e.setLayoutX(e.getLayoutX() + rateX);
						}
						enemyMovementIndex++;

					} else if (enemyMovementIndex < ((end / 3) * 2)) {
						for (Enemy e : Model.enemyList) {
							e.setLayoutY(e.getLayoutY() + rateY);
						}
						enemyMovementIndex++;

					} else if (enemyMovementIndex < ((end / 3) * 3)) {
						for (Enemy e : Model.enemyList) {
							e.setLayoutX(e.getLayoutX() - rateX);
						}
						enemyMovementIndex++;
						if (enemyMovementIndex == end) {
							enemyMovementIndex = start;
						}

					}

				}
			});
		}
	};

}
