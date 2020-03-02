package BomberMan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Mapa extends Rectangle {
	Color color;


	public Mapa(int posX, int posY, Color color) {
		// super(20, 20, 20, 20);
		super(posX + 1, posY + 1, Jugando.dimensionBloques - 2, Jugando.dimensionBloques - 2);
		this.color = color;

	}

	public void actualizar() {

	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

}