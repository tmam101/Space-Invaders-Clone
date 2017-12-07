package application.Enemy.Bullet;

import java.util.Timer;

import application.Enemy.Enemy;

public class EnemyBulletTimer extends Timer {
	private EnemyBulletTimerTask task;
	private Enemy enemy;
	private EnemyBullet bullet;

	public EnemyBulletTimer(Enemy e, EnemyBullet b) {
		enemy = e;
		bullet = b;
		task = new EnemyBulletTimerTask(e, b);
	}

	public void start() {
		this.schedule(task, 0, 15);
	}

	/*
	 * 
	 * 
	 * TASK
	 * 
	 * 
	 * 
	 */

	// private TimerTask task = new TimerTask() {
	// private double angle = getAngleBetweenAvatar();
	// private double speed = 6;
	//
	// public void run() {
	// Platform.runLater(new Runnable() {
	// public void run() {
	// bullet.setLayoutY(bullet.getLayoutY() + speed);
	// // If bullet hits the bottom
	// if (bullet.getLayoutY() > Model.homeScene.getHeight()) {
	// bullet.stop();
	// Model.homeController.getPane().getChildren().remove(bullet);
	// }
	// // If bullet hits avatar
	// if
	// (bullet.getBoundsInParent().intersects(Model.avatar.getBoundsInParent()))
	// {
	// Model.homeController.getPane().getChildren().remove(Model.avatar);
	// Model.avatar.stop();
	// }
	// }
	// });
	// }
	//
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
	// };

}
