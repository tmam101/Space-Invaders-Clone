package application;

import java.util.ArrayList;
import java.util.List;

import application.Avatar.Avatar;
import application.Avatar.Bullet.AvatarBullet;
import application.Bullet.Bullet;
import application.Cover.CoverChunk;
import application.Enemy.Enemy;
import application.Enemy.Bullet.EnemyBullet;
import javafx.scene.Scene;

public class Model {
	public static HomeController homeController;
	public static Scene homeScene;
	public static Avatar avatar;
	public static List<Enemy> enemyList = new ArrayList<Enemy>();
	public static List<CoverChunk> coverChunkList = new ArrayList<CoverChunk>();
	public static List<EnemyBullet> enemyBulletList = new ArrayList<EnemyBullet>();
	public static List<String> soundList = new ArrayList<String>();
	public static String documentBase;

	public static void setHomeController(HomeController h) {
		homeController = h;
	}

	public static void setHomeScene(Scene s) {
		homeScene = s;
	}

	public static void setAvatar(Avatar a) {
		avatar = a;
	}

	public static void deleteCoverChunk(CoverChunk c) {
		Model.homeController.getPane().getChildren().remove(c);
		coverChunkList.remove(c);
	}

	// public static void deleteEnemyBullet(EnemyBullet b) {
	// Model.homeController.getPane().getChildren().remove(b);
	// b.stop();
	// }
	//
	// public static void deleteAvatarBullet(AvatarBullet b) {
	// Model.homeController.getPane().getChildren().remove(b);
	// b.stop();
	// }

	public static void deleteBullet(Bullet b) {
		Model.homeController.getPane().getChildren().remove(b);
		b.stopCollisionTimer();
		if (b instanceof AvatarBullet) {
			AvatarBullet a = (AvatarBullet) b;
			a.stopMovementTimer();
		} else if (b instanceof EnemyBullet) {
			EnemyBullet e = (EnemyBullet) b;
			enemyBulletList.remove(e);
			e.stopMovementTimer();
		}
	}

	public static void setDocumentBase(String d) {
		documentBase = d;
	}

}
