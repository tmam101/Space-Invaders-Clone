package application.Cover;

import application.Model;

public class Cover {
	private double layoutX;
	private double layoutY;
	private double numberOfChunksWide = 10;
	private double numberOfChunksHigh = 4;
	private double width = CoverChunk.returnWidth();
	private double height = CoverChunk.returnHeight();

	public Cover(double x, double y) {
		layoutX = x;
		layoutY = y;
		createCover();
	}

	public void createCover() {
		for (int y = 0; y < numberOfChunksHigh * height; y += height) {
			for (int x = 0; x < numberOfChunksWide * width; x += width) {
				Model.homeController.addCoverChunk(layoutX + x, layoutY + y);
			}
		}
	}

}
