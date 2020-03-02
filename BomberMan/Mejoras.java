package BomberMan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Mejoras extends Rectangle {
	Color color;

	public Mejoras(int posX, int posY, Color color) {
		// super(20, 20, 20, 20);
		super(posX + 5, posY + 5, Jugando.dimensionBloques - 10, Jugando.dimensionBloques - 10);
		this.color = color;

	}

	public void actualizar() {

	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

}