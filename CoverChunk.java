package application.Cover;

import javafx.scene.layout.AnchorPane;

public class CoverChunk extends AnchorPane {
	private static double width = 10;
	private static double height = 10;
	private double layoutX;
	private double layoutY;

	public CoverChunk(double x, double y) {
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setStyle("-fx-background-color: orange;");
		layoutX = x;
		layoutY = y;
		this.setLayoutX(layoutX);
		this.setLayoutY(layoutY);
	}

	public static double returnWidth() {
		return width;
	}

	public static double returnHeight() {
		return height;
	}

}
