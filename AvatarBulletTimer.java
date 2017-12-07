package application.Avatar.Bullet;

import java.util.Timer;
import java.util.TimerTask;

import application.Model;
import application.Enemy.Enemy;
import application.Enemy.Bullet.EnemyBullet;
import javafx.application.Platform;

public class AvatarBulletTimer extends Timer {
	private AvatarBullet bullet;
	private int delay = 0;
	private int rate = 15;

	public AvatarBulletTimer(AvatarBullet b) {
		bullet = b;
	}

	public void start() {
		schedule(task, delay, rate);
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
		double speed = 12;
		double angle = -Model.avatar.getAngle() + 90;

		public void run() {
			Platform.runLater(new Runnable() {
				public void run() {

					bullet.setLayoutX(bullet.getLayoutX() + speed * (Math.cos(Math.toRadians(angle))));
					bullet.setLayoutY(bullet.getLayoutY() - speed * (Math.sin(Math.toRadians(angle))));

					// Determine if the bullet hits an enemy, and if so, delete
					// enemy
					Enemy enemy = null;
					for (Enemy e : Model.enemyList) {
						if (bullet.getBoundsInParent().intersects(e.getBoundsInParent())) {
							System.out.println("INTERSECTION");
							enemy = e;
						}
					}
					if (enemy != null) {
						enemy.die();
						bullet.delete();
					}

					// Determine if the bullet hits an enemy bullet, and if so,
					// delete both bullets
					EnemyBullet enemyBullet = null;
					for (EnemyBullet b : Model.enemyBulletList) {
						if (bullet.getBoundsInParent().intersects(b.getBoundsInParent())) {
							System.out.println("bullet intersection");
							enemyBullet = b;
						}
					}
					if (enemyBullet != null) {
						Model.deleteBullet(enemyBullet);
						Model.deleteBullet(bullet);
					}
				}
			});
		}
	};

}
