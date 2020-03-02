package BomberMan;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Jugando extends Applet implements Runnable {

	Thread animacion;
	List<Mapa> BloquesMapa;
	List<Mapa> LadrillosMapa;
	List<Bomba> bomba;
	List<Enemigos> enemigos;
	List<Mejoras> mejoras;
	List<Explosion> explosion;
	Image imagen;
	Jugador jugador;
	Graphics noseve;
	int direccion;
	int tiempoExplosion = 40;
	int contadorExplosion = 0;
	public static int longitudImagenX = 1550;
	public static int longitudImagenY = 750;
	public static int dimensionBloques = 50;

	public static Color colorBloqueMapa = Color.darkGray;
	public static Color colorLadrilloMapa = Color.GRAY;
	public static Color colorEnemigos = Color.red;

	public void init() {
		this.setSize(longitudImagenX, longitudImagenY);
		imagen = createImage(longitudImagenX, longitudImagenY);
		noseve = imagen.getGraphics();
		BloquesMapa = new ArrayList<Mapa>();
		LadrillosMapa = new ArrayList<Mapa>();
		bomba = new ArrayList<Bomba>();
		enemigos = new ArrayList<Enemigos>();
		explosion = new ArrayList<Explosion>();
		mejoras = new ArrayList<Mejoras>();
		jugador = new Jugador();
		crearMapa();
		crearLadrillosMapa();
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void run() {
		do {
			// for(int i=0;i<enemigos.size();i++)
			// enemigos.get(i).actualizar();
			explotarBomba();
			this.repaint();
			try {
				Thread.sleep(50);
				contadorExplosion++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
		} while (true);
	}

	public void paint(Graphics g) {
		noseve.setColor(Color.green);
		noseve.fillRect(0, 0, longitudImagenX, longitudImagenY);
		dibujarBomba();
		dibujarMapa();
		dibujarEnemigos();
		dibujarExplosion();
		jugador.dibujar(noseve);
		g.drawImage(imagen, 0, 0, this);
	}

	public boolean keyDown(Event ev, int tecla) {

		if (tecla == 1006) {
				direccion = 0;
			jugador.actualizar(direccion, BloquesMapa);
		}
		if (tecla == 1007) {
				direccion = 1;
			jugador.actualizar(direccion, BloquesMapa);
		}
		if (tecla == 1004) {
				direccion = 2;
			jugador.actualizar(direccion, BloquesMapa);
		}
		if (tecla == 1005) {
				direccion = 3;
			jugador.actualizar(direccion, BloquesMapa);
		}
		if (tecla == 32) {
			colocarBomba();
		}
		return true;
	}

	// enemigos
	public void crearEnemigos(int i, int j) {
		if (Math.random() < 0.07)
			enemigos.add(new Enemigos((dimensionBloques * j + ((dimensionBloques - Enemigos.tamañoEnemigos) / 2)),
					(dimensionBloques * i + ((dimensionBloques - Enemigos.tamañoEnemigos) / 2)),
					colorEnemigos));
	}

	public void dibujarEnemigos() {
		for (int i = 0; i < enemigos.size(); i++) {
			enemigos.get(i).dibujar(noseve);
		}
	}
	// bombas
	public void dibujarExplosion() {
		for (int i = 0; i < explosion.size(); i++) {
			explosion.get(i).dibujar(noseve);
		}
	}
	public void explotarBomba() {
		if (contadorExplosion == tiempoExplosion) {
			for (int i = 0; i < bomba.size(); i++) {
				explosion.add(new Explosion(bomba.get(i).x, bomba.get(i).y, Color.red));
				bomba.remove(i);
			}
			contadorExplosion = 0;
		}
	}
	public void dibujarBomba() {
		for (int i = 0; i < bomba.size(); i++) {
			bomba.get(i).dibujar(noseve);
		}
	}

	public void colocarBomba() {
		bomba.add(new Bomba(2000, 2000));
		if (jugador.x % dimensionBloques > dimensionBloques / 2) {
			if (jugador.y % dimensionBloques > dimensionBloques / 2) {
				bomba.get(0).y = ((jugador.y / dimensionBloques) - ((jugador.y % dimensionBloques)) / 100)
						* dimensionBloques + dimensionBloques;
				bomba.get(0).x = ((jugador.x / dimensionBloques) - ((jugador.x % dimensionBloques)) / 100)
						* dimensionBloques + dimensionBloques;
			} else {
				bomba.get(0).x = ((jugador.x / dimensionBloques) - ((jugador.x % dimensionBloques)) / 100)
						* dimensionBloques + dimensionBloques;
				bomba.get(0).y = ((jugador.y / dimensionBloques) - ((jugador.y % dimensionBloques)) / 100)
						* dimensionBloques;
			}
		} else {
			if (jugador.y % dimensionBloques > dimensionBloques / 2) {
				bomba.get(0).x = ((jugador.x / dimensionBloques) - ((jugador.x % dimensionBloques)) / 100)
						* dimensionBloques;
				bomba.get(0).y = ((jugador.y / dimensionBloques) - ((jugador.y % dimensionBloques)) / 100)
						* dimensionBloques + dimensionBloques;

			} else {
				bomba.get(0).x = ((jugador.x / dimensionBloques) - ((jugador.x % dimensionBloques)) / 100)
						* dimensionBloques;
				bomba.get(0).y = ((jugador.y / dimensionBloques) - ((jugador.y % dimensionBloques)) / 100)
						* dimensionBloques;
			}
		}
	}
	// generado del mapa

	public void dibujarMapa() {

		for (int i = 0; i < BloquesMapa.size(); i++)
			BloquesMapa.get(i).dibujar(noseve);
		for (int i = 0; i < LadrillosMapa.size(); i++)
			LadrillosMapa.get(i).dibujar(noseve);
		for (int i = 0; i < mejoras.size(); i++)
			mejoras.get(i).dibujar(noseve);

	}
	public void crearMapa() {
		for (int i = 0; i < longitudImagenY / dimensionBloques; i++) {
			for (int j = 0; j < longitudImagenX / dimensionBloques; j++) {
				if (i == 0 || i == longitudImagenY / dimensionBloques - 1)
					BloquesMapa.add(new Mapa(dimensionBloques * j, dimensionBloques * i, colorBloqueMapa));
				BloquesMapa.add(new Mapa(0, dimensionBloques * i, colorBloqueMapa));
				BloquesMapa.add(new Mapa(longitudImagenX - dimensionBloques, dimensionBloques * i, colorBloqueMapa));
				if (i % 2 == 0 && j % 2 == 0) {


					BloquesMapa.add(new Mapa(dimensionBloques * j, dimensionBloques * i, colorBloqueMapa));

				}
			}
		}
	}

	public void crearLadrillosMapa() {

		for (int i = 1; i < longitudImagenY / dimensionBloques - 1; i++) {
			for (int j = 1; j < longitudImagenX / dimensionBloques - 1; j++) {

				if (i % 2 != 0 && j % 2 != 0 || i % 2 == 0 && j % 2 != 0 || i % 2 != 0 && j % 2 == 0) {
					if (Math.random() > 0.65) {
						LadrillosMapa.add(new Mapa(dimensionBloques * j, dimensionBloques * i, colorLadrilloMapa));
						if (Math.random() > 0.75)
							mejoras.add(new Mejoras(dimensionBloques * j, dimensionBloques * i, Color.orange));
					}
					else {
						crearEnemigos(i, j);
					}
				}
			}
		}
		for (int i = 0; i < 4; i++) { // para dejar el spawn vacio
			LadrillosMapa.remove(0);
			enemigos.remove(0);
			mejoras.remove(0);
		}
	}
}
