package BomberMan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class Jugador extends Rectangle {
	Color color;
	public static int VEL = 25;
	public static final int ARRIBA = 1004;
	public static final int ABAJO = 1005;
	public static final int IZQUIERDA = 1006;
	public static final int DERECHA = 1007;

	static Jugador jugador;

	public Jugador() {
		super(Jugando.dimensionBloques, Jugando.dimensionBloques, Jugando.dimensionBloques, Jugando.dimensionBloques);
		color = Color.blue;
	}

	public void actualizar(int direccion) {
		direccionJugador(direccion);
	}

	public void direccionJugador(int direccion) {
		if (direccion == IZQUIERDA)
			x -= VEL;

		if (direccion == DERECHA)
			x += VEL;

		if (direccion == ARRIBA)
			y -= VEL;

		if (direccion == ABAJO)
			y += VEL;

	}


	public void chocarConBloquesMapa(List<Mapa> BloquesMapa, List<Mapa> LadrillosMapa, int direccion,
			List<Bomba> bombas) {

		for (int i = 0; i < BloquesMapa.size(); i++) {
			if (this.intersects(BloquesMapa.get(i))) {
				direccionChocarBloques(direccion);
			}
		}

		for (int i = 0; i < LadrillosMapa.size(); i++) {
			if (this.intersects(LadrillosMapa.get(i))) {
				direccionChocarBloques(direccion);
			}
		}

		for (int i = 0; i < bombas.size(); i++) {

			if (this.intersects(bombas.get(i))) {
				direccionChocarBloques(direccion);
			}
		}
	}

	public void direccionChocarBloques(int direccion) {
		switch (direccion) {
		case ARRIBA:
			y += VEL;
			break;
		case ABAJO:
			y -= VEL;
			break;
		case IZQUIERDA:
			x += VEL;
			break;
		case DERECHA:
			x -= VEL;
		}
	}


	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}
}
