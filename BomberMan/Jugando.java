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
	
	Image imagen;

	static Graphics noseve;
	int direccion;

	public static int longitudImagenX = 1550;
	public static int longitudImagenY = 750;
	public static int dimensionBloques = 50;




	public void init() {
		this.setSize(longitudImagenX, longitudImagenY);
		imagen = createImage(longitudImagenX, longitudImagenY);
		noseve = imagen.getGraphics();

		Bomba.bomba = new ArrayList<Bomba>();
		Enemigos.enemigos = new ArrayList<Enemigos>();
		Explosion.explosion = new ArrayList<Explosion>();
		Explosion.contadorExplosion = new ArrayList<Integer>();
		Mejoras.mejoras = new ArrayList<Mejoras>();
		Mapa.BloquesMapa = new ArrayList<Mapa>();
		Mapa.LadrillosMapa = new ArrayList<Mapa>();
		Jugador.jugador = new Jugador();
		Mapa.crearMapa();
		Mapa.crearLadrillosMapa();
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
			Explosion.explotarBomba();
			Jugador.jugador.chocarConBloquesMapa(Mapa.BloquesMapa, Mapa.LadrillosMapa, direccion, Bomba.bomba);
			this.repaint();
			try {
				Thread.sleep(1);
				if(!Bomba.bomba.isEmpty())
					for (int i = 0; i < Explosion.contadorExplosion.size(); i++) {
						Explosion.contadorExplosion.set(i, Explosion.contadorExplosion.get(i)+1);
					}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
		} while (true);
	}

	public void paint(Graphics g) {
		noseve.setColor(Color.green);
		noseve.fillRect(0, 0, longitudImagenX, longitudImagenY);
		Bomba.dibujarBomba();
		Mapa.dibujarMapa();
		Enemigos.dibujarEnemigos();
		Explosion.dibujarExplosion();
		Jugador.jugador.dibujar(noseve);
		
//		Lo comentado aquí abajo es para imprimir el valor de variables y así hacer pruebas
//		if(!Bomba.bomba.isEmpty()) {
//			noseve.setColor(Color.black);
//			for (int i = 0; i < Bomba.bomba.size(); i++) 
//				noseve.drawString(""+Bomba.bomba.get(i).cuadranteDiferente, 100 + (i*50), 100);
//		}
		
		g.drawImage(imagen, 0, 0, this);
	}

	public boolean keyDown(Event ev, int tecla) {

		if (tecla == Jugador.IZQUIERDA) {
			direccion = Jugador.IZQUIERDA;
			Jugador.jugador.actualizar(direccion);
		}
		if (tecla == Jugador.DERECHA) {
			direccion = Jugador.DERECHA;
			Jugador.jugador.actualizar(direccion);
		}
		if (tecla == Jugador.ARRIBA) {
			direccion = Jugador.ARRIBA;
			Jugador.jugador.actualizar(direccion);
		}
		if (tecla == Jugador.ABAJO) {
			direccion = Jugador.ABAJO;
			Jugador.jugador.actualizar(direccion);
		}
		if (tecla == 32) {
			if(Bomba.bomba.size() < 2) {
				Bomba.bomba.add(new Bomba(100, 75));
				Explosion.contadorExplosion.add(0);
				Bomba.colocarBomba(Bomba.bomba.get(Bomba.bomba.size()-1));	//Así colocarBomba se ejecuta solo una vez por bomba creada, pasándole la bomba.
			}
		}
		return true;
	}




}
