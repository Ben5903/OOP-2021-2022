package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {
	
	LifeBoard board;

	public void mouseDragged()
	{
		//int col = (int) (mouseX / (board.cellSize));

		int col = (int) map(mouseX, 0, width, 0, board.size);
		int row = (int) map(mouseY, 0, width, 0, board.size);

		board.setAlive(row, col, true);
	}


	LifeBoard board;


	public void settings() {
<<<<<<< HEAD
		size(500, 500);
		board = new LifeBoard(100, this);
		board.randomise();
=======
		size(1000, 1000);
		board = new LifeBoard(200, this);
		//board.randomise();
>>>>>>> 3ef720c84a8ca57e8e4d6a63c7fed11137fe099e
		println(board.countCellsAround(1, 1));
	}

	public void setup() {
<<<<<<< HEAD
		colorMode(HSB);
	}


=======
		colorMode(RGB);

	}
	
>>>>>>> 3ef720c84a8ca57e8e4d6a63c7fed11137fe099e
	public void draw() {
		board.render();
		board.update();
	}
}
