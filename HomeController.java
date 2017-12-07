package application;

import java.net.URL;
import java.util.ResourceBundle;

import application.Avatar.Avatar;
import application.Bullet.Bullet;
import application.Cover.Cover;
import application.Cover.CoverChunk;
import application.Enemy.Enemy;
import application.Enemy.Column.Column;
import application.Enemy.Column.ColumnManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class HomeController implements Initializable {
	@FXML
	private AnchorPane pane;
	@FXML
	private Label scoreLabel;
	@FXML
	private Label timeLabel;
	@FXML
	private ImageView backgroundImageView;
	private Image backgroundImage = new Image("space-0.gif");

	// private List<Enemy> enemyList = new ArrayList<Enemy>();
	private Avatar avatar;

	private int defeatedEnemies = 0;
	private String scoreLabelText = "Score: 0";

	/*
	 * 
	 * 
	 * INITIALIZE
	 * 
	 * 
	 * 
	 */

	public void initialize(URL location, ResourceBundle resources) {
		Platform.runLater(new Runnable() {
			public void run() {
				// Set User Interface
				scoreLabel.setText(scoreLabelText);
				// Create Pieces
				createAvatar();
				createColumns(8);
				// Create Background
				BackgroundTimer backgroundTimer = new BackgroundTimer();
				backgroundTimer.start();
				// Add cover
				Cover a = new Cover(25, Model.homeScene.getHeight() - 200);
				Cover b = new Cover(275, Model.homeScene.getHeight() - 200);
				Cover c = new Cover(525, Model.homeScene.getHeight() - 200);
				ColumnManager m = new ColumnManager();
				m.start();

				// Image earth = new Image("Sprites/earth.png");
				// ImageView earthView = new ImageView(earth);
				// pane.getChildren().add(earthView);
				// earthView.setLayoutY(0);
				// earthView.setLayoutX(0);
			}
		});
	}

	public void createAvatar() {
		avatar = new Avatar();
		pane.getChildren().add(avatar);
	}

	public void addCoverChunk(double x, double y) {
		CoverChunk chunk = new CoverChunk(x, y);
		pane.getChildren().add(chunk);
		Model.coverChunkList.add(chunk);
	}

	/*
	 * 
	 * 
	 * ENEMIES
	 * 
	 * 
	 * 
	 */

	public void createEnemies(int num) {
		for (int i = 0; i < num; i++) {
			Enemy enemy = new Enemy();
			pane.getChildren().add(enemy);
			Model.enemyList.add(enemy);
		}
	}

	public void addEnemy(Enemy e) {
		if (!pane.getChildren().contains(e)) {
			pane.getChildren().add(e);
		}
		if (!Model.enemyList.contains(e)) {
			Model.enemyList.add(e);
		}
	}

	public void createColumns(int num) {
		int width = 50;
		int buffer = 10;
		int y = 50;
		for (int i = 0; i < num; i++) {
			Column column = new Column((i * width) + i * buffer, y);
		}
	}

	public void deleteEnemy(Enemy enemy) {
		defeatedEnemies++;
		if (Model.enemyList.contains(enemy)) {
			Model.enemyList.remove(enemy);
		}
		if (pane.getChildren().contains(enemy)) {
			pane.getChildren().remove(enemy);
		}
		scoreLabelText = "Score: " + defeatedEnemies;
		scoreLabel.setText(scoreLabelText);
	}

	/*
	 * 
	 * 
	 * 
	 * GETTERS/SETTERS
	 * 
	 * 
	 * 
	 */

	public Avatar getAvatar() {
		return avatar;
	}

	// public List<Enemy> getEnemyList() {
	// return enemyList;
	// }

	public void deleteBullet(Bullet bullet) {
		if (pane.getChildren().contains(bullet)) {
			pane.getChildren().remove(bullet);
		}
	}

	public AnchorPane getPane() {
		return pane;
	}

	public ImageView getBackgroundImageView() {
		return this.backgroundImageView;
	}

}
