package BomberMan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bomba extends Rectangle {
	Color color;

	public Bomba(int posX, int posY) {
		super(posX, posY, 50, 50);
		color = Color.black;
	}

	public void actualizar() {
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}
}