package application.Bullet;

import application.Model;
import javafx.scene.layout.AnchorPane;

public abstract class Bullet extends AnchorPane {
	CollisionTimer collisionTimer;

	public Bullet() {

	}

	/*
	 * 
	 * 
	 * METHODS
	 * 
	 * 
	 * 
	 */

	public void startCollisionTimer() {
		collisionTimer = new CollisionTimer(this);
		collisionTimer.start();
	}

	public void delete() {
		Model.deleteBullet(this);
	}

	public void stopCollisionTimer() {
		collisionTimer.cancel();
	}

	public boolean getIsWithinBounds() {
		// greater than or greater or equal than?
		if (this.getLayoutX() > 0 && this.getLayoutY() > 0 && this.getLayoutX() < Model.homeScene.getWidth()
				&& this.getLayoutY() < Model.homeScene.getHeight()) {
			return true;
		} else {
			return false;
		}
	}

}
