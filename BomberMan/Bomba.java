package BomberMan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class Bomba extends Rectangle {
	Color color;
	static List<Bomba> bomba;
	boolean cuadranteDiferente;

	public Bomba(int posX, int posY) {
		super(posX, posY, 50, 50);
		color = Color.black;
		cuadranteDiferente = false;
	}

	public void actualizar() {
	}

	public static void dibujarBomba() {
		for (int i = 0; i < bomba.size(); i++) {
			bomba.get(i).dibujar(Jugando.noseve);
		}
	}

	public static void colocarBomba() {
		
		if (Jugador.jugador.x % Jugando.dimensionBloques > Jugando.dimensionBloques / 2) {
			if (Jugador.jugador.y % Jugando.dimensionBloques > Jugando.dimensionBloques / 2) {
				bomba.get(0).y = ((Jugador.jugador.y / Jugando.dimensionBloques)
						- ((Jugador.jugador.y % Jugando.dimensionBloques)) / 100) * Jugando.dimensionBloques
						+ Jugando.dimensionBloques;
				bomba.get(0).x = ((Jugador.jugador.x / Jugando.dimensionBloques)
						- ((Jugador.jugador.x % Jugando.dimensionBloques)) / 100) * Jugando.dimensionBloques
						+ Jugando.dimensionBloques;
			} else {
				bomba.get(0).x = ((Jugador.jugador.x / Jugando.dimensionBloques)
						- ((Jugador.jugador.x % Jugando.dimensionBloques)) / 100) * Jugando.dimensionBloques
						+ Jugando.dimensionBloques;
				bomba.get(0).y = ((Jugador.jugador.y / Jugando.dimensionBloques)
						- ((Jugador.jugador.y % Jugando.dimensionBloques)) / 100) * Jugando.dimensionBloques;
			}
		} else {
			if (Jugador.jugador.y % Jugando.dimensionBloques > Jugando.dimensionBloques / 2) {
				bomba.get(0).x = ((Jugador.jugador.x / Jugando.dimensionBloques)
						- ((Jugador.jugador.x % Jugando.dimensionBloques)) / 100) * Jugando.dimensionBloques;
				bomba.get(0).y = ((Jugador.jugador.y / Jugando.dimensionBloques)
						- ((Jugador.jugador.y % Jugando.dimensionBloques)) / 100) * Jugando.dimensionBloques
						+ Jugando.dimensionBloques;

			} else {
				bomba.get(0).x = ((Jugador.jugador.x / Jugando.dimensionBloques)
						- ((Jugador.jugador.x % Jugando.dimensionBloques)) / 100) * Jugando.dimensionBloques;
				bomba.get(0).y = ((Jugador.jugador.y / Jugando.dimensionBloques)
						- ((Jugador.jugador.y % Jugando.dimensionBloques)) / 100) * Jugando.dimensionBloques;
			}
		}
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}
}