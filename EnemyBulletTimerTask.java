package application.Enemy.Bullet;

import java.util.TimerTask;

import application.Model;
import application.Enemy.Enemy;
import javafx.application.Platform;

public class EnemyBulletTimerTask extends TimerTask {
	// private double angle;
	private EnemyBullet bullet;
	private Enemy enemy;
	private double speed;

	public EnemyBulletTimerTask(Enemy e, EnemyBullet b) {
		enemy = e;
		bullet = b;
		// angle = getAngleBetweenAvatar();
		speed = 3;
	}

	public void run() {
		Platform.runLater(new Runnable() {
			public void run() {
				bullet.setLayoutY(bullet.getLayoutY() + speed);

				// If bullet hits avatar
				if (bullet.getBoundsInParent().intersects(Model.avatar.getBoundsInParent())) {
					Model.homeController.getPane().getChildren().remove(Model.avatar);
					Model.avatar.stop();
					Model.deleteBullet(bullet);
				}

			}
		});
	}

	// public double getAngleBetweenAvatar() {
	// double avatarX = Model.avatar.getLayoutX();
	// double avatarY = Model.avatar.getLayoutY();
	// avatarY = Model.homeScene.getHeight() - avatarY;
	// double thisX = enemy.getLayoutX();
	// double thisY = enemy.getLayoutY();
	// thisY = Model.homeScene.getHeight() - thisY;
	// double opposite = avatarY - thisY;
	// double adjacent = avatarX - thisX;
	// // double angle = Math.atan2(avatarY - thisY, avatarX - thisX);
	// // angle = angle * 100;
	// angle = adjacent * Math.tan(opposite);
	// // System.out.println("angle between " + angle);
	// // angle > 0 ? angle : (2*Math.PI + angle) * 360 / (2*Math.PI);
	// // if (angle > 0) {
	// // angle = (2 * Math.PI + angle) * 360 / (2 * Math.PI);
	// // }
	// // System.out.println("new angle between " + angle);
	// return angle;
	// }

}
