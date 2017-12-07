package application.Enemy.Column;

import java.util.ArrayList;
import java.util.List;

import application.Model;
import application.Enemy.Enemy;

public class Column {
	private Enemy enemy1;
	private Enemy enemy2;
	private Enemy enemy3;
	private List<Enemy> enemies = new ArrayList<Enemy>();
	private double startingX;
	private double startingY;

	public Column(double x, double y) {
		startingX = x;
		startingY = y;
		enemy1 = new Enemy();
		enemy2 = new Enemy();
		enemy3 = new Enemy();
		enemies.add(enemy1);
		enemies.add(enemy2);
		enemies.add(enemy3);
		formatEnemies();
	}

	public void formatEnemies() {
		int bufferHeight = 0;
		for (Enemy e : enemies) {
			// e = new Enemy(startingX, startingY + bufferHeight);
			e.setLayoutX(startingX);
			e.setLayoutY(startingY + bufferHeight);
			e.setColumn(this);
			bufferHeight += 60;
			Model.homeController.addEnemy(e);
		}
		decideWhichEnemyShoots();
	}

	public void removeEnemy(Enemy e) {
		this.enemies.remove(e);
		decideWhichEnemyShoots();
	}

	public void decideWhichEnemyShoots() {
		for (Enemy e : enemies) {
			if (enemies.indexOf(e) != enemies.size() - 1) {
				if (e.getIsShooting()) {
					e.stopShooting();
				}
			} else {
				if (!e.getIsShooting()) {
					e.startShooting();
				}
			}
		}
	}

}
