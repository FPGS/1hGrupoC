package BomberMan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class Explosion extends Rectangle {
	Color color;
	static List<Explosion> explosion;
	static int tiempoExplosion = 4000;
	static int contadorExplosion = 0;

	public Explosion(int posX, int posY, Color color) {
		// super(20, 20, 20, 20);
		super(posX, posY, Jugando.dimensionBloques, Jugando.dimensionBloques);
		this.color = color;

	}

	public void actualizar() {

	}

	public static void dibujarExplosion() {
		for (int i = 0; i < explosion.size(); i++) {
			explosion.get(i).dibujar(Jugando.noseve);
		}
	}

	public static void explotarBomba() {
		if (contadorExplosion == tiempoExplosion) {
			for (int i = 0; i < Bomba.bomba.size(); i++) {
				explosion.add(new Explosion(Bomba.bomba.get(i).x, Bomba.bomba.get(i).y, Color.red));
				Bomba.bomba.remove(i);
			}
			contadorExplosion = 0;
		}
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}
}
