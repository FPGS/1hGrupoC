package BomberMan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class Enemigos extends Rectangle {
	Color color;
	public static Color colorEnemigos = Color.red;
	public static int tamañoEnemigos = 30;
	static List<Enemigos> enemigos;
	public Enemigos(int posX, int posY, Color color) {
		// super(20, 20, 20, 20);
		super(posX, posY, 30, 30);
		this.color = color;

	}

	public void actualizar() {

	}

	public static void crearEnemigos(int i, int j) {
		if (Math.random() < 0.07)
			enemigos.add(new Enemigos(
					(Jugando.dimensionBloques * j + ((Jugando.dimensionBloques - Enemigos.tamañoEnemigos) / 2)),
					(Jugando.dimensionBloques * i + ((Jugando.dimensionBloques - Enemigos.tamañoEnemigos) / 2)),
					colorEnemigos));
	}

	public static void dibujarEnemigos() {
		for (int i = 0; i < enemigos.size(); i++) {
			enemigos.get(i).dibujar(Jugando.noseve);
		}
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

}