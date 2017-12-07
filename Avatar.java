package application.Avatar;

import application.Model;
import application.Avatar.Bullet.AvatarBullet;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;

public class Avatar extends AnchorPane {
	// EVENT HANDLERS
	private EventHandler<KeyEvent> pressHandler;
	private EventHandler<KeyEvent> releaseHandler;
	// BOOLEANS
	private boolean leftPressed;
	private boolean rightPressed;
	private boolean wPressed;
	private boolean aPressed;
	private boolean sPressed;
	private boolean dPressed;
	// ROTATION
	private Rotate rotate = new Rotate();
	private double angle;
	private boolean isRotating;
	// IMAGES
	private Image image = new Image("spaceship.png");
	private ImageView imageView = new ImageView(image);
	// NUMBERS
	private double width = 75;
	private double height = 75;
	// TIMER
	AvatarTimer timer = new AvatarTimer();

	/*
	 * 
	 * 
	 * CREATION/FORMAT
	 * 
	 * 
	 * 
	 */

	public Avatar() {
		createHandlers();
		assignHandlers();
		Model.setAvatar(this);
		format();
		this.getChildren().add(imageView);
		formatImage();
		angle = 0;
		this.setFocusTraversable(true);
		timer.start();
	}

	public void stop() {
		timer.cancel();
	}

	public void createHandlers() {
		pressHandler = new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				onKeyPressed(event);
			}
		};
		releaseHandler = new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				onKeyReleased(event);
			}
		};
	}

	public void assignHandlers() {
		this.setOnKeyPressed(pressHandler);
		this.setOnKeyReleased(releaseHandler);
	}

	public void format() {
		this.setPrefHeight(height);
		this.setPrefWidth(width);
		this.setLayoutX(Model.homeScene.getWidth() / 2);
		this.setLayoutY(Model.homeScene.getHeight() - (this.getPrefHeight() + 20));
	}

	public void formatImage() {
		imageView.setFitWidth(height);
		imageView.setFitHeight(width);
		imageView.setRotate(180);
	}

	/*
	 * 
	 * 
	 * KEY ACTIONS
	 * 
	 * 
	 * 
	 */

	public void onKeyPressed(KeyEvent event) {
		System.out.println("key pressed");

		if (event.getCode() == KeyCode.LEFT) {
			leftPressed = true;
		} else if (event.getCode() == KeyCode.RIGHT) {
			rightPressed = true;

		}
		if (event.getCode() == KeyCode.W) {
			wPressed = true;
		}
		if (event.getCode() == KeyCode.A) {
			aPressed = true;
		}
		if (event.getCode() == KeyCode.S) {
			sPressed = true;
		}
		if (event.getCode() == KeyCode.D) {
			dPressed = true;
		}
		if (event.getCode() == KeyCode.SPACE) {
			AvatarBullet b = new AvatarBullet();
			Model.homeController.getPane().getChildren().add(b);

		}
		if (event.getCode() == KeyCode.E) {
			Model.homeController.createEnemies(1);
		}
	}

	public void onKeyReleased(KeyEvent event) {
		System.out.println("key released");
		if (event.getCode() == KeyCode.LEFT) {
			leftPressed = false;
		} else if (event.getCode() == KeyCode.RIGHT) {
			rightPressed = false;
		}
		if (event.getCode() == KeyCode.W) {
			wPressed = false;
		}
		if (event.getCode() == KeyCode.A) {
			aPressed = false;
		}
		if (event.getCode() == KeyCode.S) {
			sPressed = false;
		}
		if (event.getCode() == KeyCode.D) {
			dPressed = false;
		}
	}

	/*
	 * 
	 * 
	 * MOVEMENT
	 * 
	 * 
	 * 
	 */

	public void rotateLeft() {
		rotate.setAngle(angle);
		rotate.setPivotX(this.getWidth() / 2);
		rotate.setPivotY(this.getHeight() / 2);
		this.getTransforms().clear();
		this.getTransforms().add(rotate);
		angle -= 2;
	}

	public void rotateRight() {
		rotate.setAngle(angle);
		rotate.setPivotX(this.getWidth() / 2);
		rotate.setPivotY(this.getHeight() / 2);
		this.getTransforms().clear();
		this.getTransforms().add(rotate);
		angle += 2;
	}

	public void moveForward(double pace) {
		double ang = -angle + 90;
		double speed = pace;

		this.setLayoutX(this.getLayoutX() + speed * (Math.cos(Math.toRadians(ang))));
		this.setLayoutY(this.getLayoutY() - speed * (Math.sin(Math.toRadians(ang))));
	}

	public void moveUp(double pace) {
		this.setLayoutY(this.getLayoutY() - pace);
	}

	public void moveDown(double pace) {
		this.setLayoutY(this.getLayoutY() + pace);
	}

	public void moveLeft(double pace) {
		this.setLayoutX(this.getLayoutX() - pace);
	}

	public void moveRight(double pace) {
		this.setLayoutX(this.getLayoutX() + pace);
	}

	/*
	 * 
	 * 
	 * GETTERS/SETTERS
	 * 
	 * 
	 * 
	 */

	public boolean isRotating() {
		return isRotating;
	}

	public void setRotating(boolean isRotating) {
		this.isRotating = isRotating;
	}

	public boolean iswPressed() {
		return wPressed;
	}

	public boolean isaPressed() {
		return aPressed;
	}

	public boolean issPressed() {
		return sPressed;
	}

	public boolean isdPressed() {
		return dPressed;
	}

	public boolean isLeftPressed() {
		return leftPressed;
	}

	public boolean isRightPressed() {
		return rightPressed;
	}

	public double getAngle() {
		System.out.println(angle);
		return angle;
	}

}
