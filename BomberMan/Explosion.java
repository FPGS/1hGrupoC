package BomberMan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Explosion extends Rectangle {
	Color color;

	public Explosion(int posX, int posY, Color color) {
		// super(20, 20, 20, 20);
		super(posX, posY, Jugando.dimensionBloques, Jugando.dimensionBloques);
		this.color = color;

	}

	public void actualizar() {

	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}
}
