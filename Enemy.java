package application.Enemy;

import java.math.BigDecimal;
import java.math.RoundingMode;

import application.Model;
import application.Enemy.Column.Column;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Enemy extends ImageView {
	// Layout
	private double layoutX;
	private double layoutY;
	private double sceneX = Model.homeScene.getWidth();
	private double sceneY = Model.homeScene.getHeight();
	// Image
	private Image image = new Image("space invader.png");
	// Timer
	private EnemyTimer timer;
	// Boolean
	private boolean isAlive = true;
	private double width = 50;
	private double height = 50;
	private boolean isShooting = false;
	private Column column;

	// create a list of bullets for use in

	/*
	 * 
	 * 
	 * CREATION/FORMAT
	 * 
	 * 
	 * 
	 */
	public Enemy() {
		createLook();
		setRandomCoordinates();
		// Ensure that the enemy spawns in the correct area
		while (layoutX < 0 || layoutX > sceneX - 100) {
			setRandomX();
		}
		while (layoutY < 0 || layoutY > sceneY - (sceneY / 3)) {
			setRandomY();
		}
		//
		startShooting();
		format();

		this.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				die();
			}
		});

	}

	public Enemy(double x, double y) {
		createLook();
		startShooting();
		format();
		this.setLayoutX(x);
		this.setLayoutY(y);
	}

	public void createLook() {
		this.setImage(image);
		this.setStyle("-fx-fill: cyan;");
	}

	public void format() {
		this.setLayoutX(layoutX);
		this.setLayoutY(layoutY);
		this.setFitWidth(width);
		this.setFitHeight(height);
	}

	/*
	 * 
	 * 
	 * ACTIONS
	 * 
	 * 
	 * 
	 */

	public void startShooting() {
		timer = new EnemyTimer(this);
		timer.start();
		isShooting = true;
	}

	public void stopShooting() {
		timer.cancel();
		isShooting = false;
	}

	public void die() {
		this.setIsAlive(false);
		this.stopShooting();
		column.removeEnemy(this);
		Model.homeController.deleteEnemy(this);
	}

	/*
	 * 
	 * 
	 * RANDOM COORDINATES
	 * 
	 * 
	 * 
	 */

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public void setRandomCoordinates() {
		layoutX = 1000 * round(Math.random(), 3);
		layoutY = 1000 * round(Math.random(), 3);
	}

	public void setRandomX() {
		layoutX = 1000 * round(Math.random(), 3);
	}

	public void setRandomY() {
		layoutY = 1000 * round(Math.random(), 3);
	}

	/*
	 * 
	 * 
	 * GETTERS AND SETTERS
	 * 
	 * 
	 * 
	 */

	public boolean getIsAlive() {
		return isAlive;
	}

	public void setIsAlive(boolean b) {
		isAlive = b;
	}

	public Column getColumn() {
		return column;
	}

	public void setColumn(Column c) {
		column = c;
	}

	public boolean getIsShooting() {
		return isShooting;
	}
}
