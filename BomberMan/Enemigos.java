package BomberMan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemigos extends Rectangle {
	Color color;
	public static int tamañoEnemigos = 30;
	public Enemigos(int posX, int posY, Color color) {
		// super(20, 20, 20, 20);
		super(posX, posY, 30, 30);
		this.color = color;

	}

	public void actualizar() {
		direccionEnemigo();
	}

	public void direccionEnemigo() {
		// implementar que cuando llegue al centro del cuadrante se va a chocar en la
		// direccion que esta yendo
	}

	public void chocarBloqueMapa() {

	}

	public void chocarLadrillos() {

	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

}