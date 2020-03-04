package BomberMan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Mapa extends Rectangle {
	Color color;
	static List<Mapa> BloquesMapa;
	static List<Mapa> LadrillosMapa;
	public static Color colorBloqueMapa = Color.darkGray;
	public static Color colorLadrilloMapa = Color.GRAY;


	public Mapa(int posX, int posY, Color color) {
		// super(20, 20, 20, 20);
		super(posX + 1, posY + 1, Jugando.dimensionBloques - 2, Jugando.dimensionBloques - 2);
		this.color = color;

	}

	public void actualizar() {

	}

	public static void dibujarMapa() {
		for (int i = 0; i < Mejoras.mejoras.size(); i++)
			Mejoras.mejoras.get(i).dibujar(Jugando.noseve);
		for (int i = 0; i < BloquesMapa.size(); i++)
			BloquesMapa.get(i).dibujar(Jugando.noseve);
		for (int i = 0; i < LadrillosMapa.size(); i++)
			LadrillosMapa.get(i).dibujar(Jugando.noseve);

	}

	public static void crearMapa() {
		for (int i = 0; i < Jugando.longitudImagenY / Jugando.dimensionBloques; i++) {
			for (int j = 0; j < Jugando.longitudImagenX / Jugando.dimensionBloques; j++) {
				if (i == 0 || i == Jugando.longitudImagenY / Jugando.dimensionBloques - 1)
					BloquesMapa
							.add(new Mapa(Jugando.dimensionBloques * j, Jugando.dimensionBloques * i, colorBloqueMapa));
				BloquesMapa.add(new Mapa(0, Jugando.dimensionBloques * i, colorBloqueMapa));
				BloquesMapa.add(new Mapa(Jugando.longitudImagenX - Jugando.dimensionBloques,
						Jugando.dimensionBloques * i, Mapa.colorBloqueMapa));
				if (i % 2 == 0 && j % 2 == 0) {


					BloquesMapa
							.add(new Mapa(Jugando.dimensionBloques * j, Jugando.dimensionBloques * i, colorBloqueMapa));

				}
			}
		}
	}

	public static void crearLadrillosMapa() {

		for (int i = 1; i < Jugando.longitudImagenY / Jugando.dimensionBloques - 1; i++) {
			for (int j = 1; j < Jugando.longitudImagenX / Jugando.dimensionBloques - 1; j++) {

				if (i % 2 != 0 && j % 2 != 0 || i % 2 == 0 && j % 2 != 0 || i % 2 != 0 && j % 2 == 0) {
					if (Math.random() > 0.65) {
						LadrillosMapa.add(new Mapa(Jugando.dimensionBloques * j, Jugando.dimensionBloques * i,
								colorLadrilloMapa));
						if (Math.random() > 0.75)
							Mejoras.mejoras.add(new Mejoras(Jugando.dimensionBloques * j, Jugando.dimensionBloques * i,
									Color.orange));
					} else {
						Enemigos.crearEnemigos(i, j);
					}
				}
			}
		}
		for (int i = 0; i < 4; i++) { // para dejar el spawn vacio
			LadrillosMapa.remove(0);
			Enemigos.enemigos.remove(0);
			Mejoras.mejoras.remove(0);
		}
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

}