package application.Avatar.Bullet;

import application.Model;
import application.Bullet.Bullet;

public class AvatarBullet extends Bullet {
	private AvatarBulletTimer timer;
	private double width = 10;
	private double height = 30;

	// Sound stuff
	// String soundFile = "Sounds/laser2.wav";
	// Media sound = new Media(new File(soundFile).toURI().toString());
	// MediaPlayer mediaPlayer = new MediaPlayer(sound);

	public AvatarBullet() {
		this.startCollisionTimer();
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setStyle("-fx-background-color: rgba(230,230,230,0.7);");
		this.setLayoutX(Model.avatar.getLayoutX() + (Model.avatar.getPrefWidth() / 2) - (width / 2));
		this.setLayoutY(Model.avatar.getLayoutY()
		// + (Model.avatar.getPrefHeight() / 2)
		);
		timer = new AvatarBulletTimer(this);
		timer.start();

		// mediaPlayer.play();
	}

	public void stopMovementTimer() {
		timer.cancel();
	}

}
