package application.Enemy.Bullet;

import application.Model;
import application.Bullet.Bullet;
import application.Enemy.Enemy;

public class EnemyBullet extends Bullet {
	private EnemyBulletTimer timer;
	private Enemy enemy;
	// private Image image = new Image("red missle.png");
	// private ImageView imageView = new ImageView(image);
	private double width = 10;
	private double height = 30;

	public EnemyBullet(Enemy e) {
		this.startCollisionTimer();
		enemy = e;
		format();
		// this.getChildren().add(imageView);
		timer = new EnemyBulletTimer(enemy, this);
		timer.start();
		Model.enemyBulletList.add(this);
	}

	public void format() {
		this.setStyle("-fx-background-color: red;");
		this.setOpacity(0.7);

		this.setPrefWidth(width);
		this.setPrefHeight(height);
		// imageView.setFitWidth(height);
		// imageView.setFitHeight(width);
		// imageView.setRotate(90);
		this.setLayoutX(enemy.getLayoutX() + (enemy.getFitWidth() / 2) - (width / 2));
		this.setLayoutY(enemy.getLayoutY());
	}

	public void stopMovementTimer() {
		timer.cancel();
	}

}
