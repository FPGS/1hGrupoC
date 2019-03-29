package primero;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

//sacar imagenes de forma consecutiva y cuando hagas click en una desaparezca.



public class Caminar extends Applet implements Runnable {

	Image imagenes[][];
	String directorios[] = {"Sprites/Guerrillero/g", "Sprites/Hampon/h", "Sprites/Vaquero/v"} ;
	Image imagen;
	Graphics noseve;
	Thread animacion;
	DibujoAnimado dibujo;
	List<DibujoAnimado> dibujos;
	public static final int VARIOS = 5; 
	

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void init() {
		resize(500, 450);
		imagen = createImage(600, 600);
		noseve = imagen.getGraphics();
		imagenes = new Image[3][4];
//		
		dibujos = new ArrayList<DibujoAnimado>();	
		for (int i = 0; i < imagenes.length; i++)// son tres filas
			for(int j = 0; j< imagenes[i].length; j++) //cuatro columnas
				imagenes[i][j] = getImage(getCodeBase(), directorios[i] + (j + 1) + ".gif");// getImage devuelve una
		
		int posX =0;
		for(int x = 0; x < VARIOS; x++) { 
			dibujos.add(new DibujoAnimado(imagenes[0], posX));//tenemos que pasarle tres del meodo constructruc
			posX+= 90;
		}
		
//		dibujo = new DibujoAnimado(imagenes[0], posX);//espera recibir un vector 
	}

	public void paint(Graphics siqueseve) {
		noseve.setColor(Color.white);
		noseve.fillRect(0, 0, 600, 600);
		//noseve.drawImage(imagenes[0], 0, 0, null, null);
		for(int x = 0; x < dibujos.size(); x++) 
			dibujos.get(x).dibujar(noseve, this);
			
		
		siqueseve.drawImage(imagen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void run() {
		do {
			for(int x = 0; x < dibujos.size(); x++)//
				dibujos.get(x).actualizar();
			repaint();
			slepp(100);
		} while (true);
	}
	
	public boolean keyDown(Event ev, int tecla) { //son varias preguntas  switch
		switch (tecla) {
		
		case 71://g
		case 103:
			for(int i = 0; i < dibujos.size(); i++) //hacemos este bucle para rrecorrer las imagenes yque las muestre
				dibujos.get(i).setImagenes(imagenes[0]);//dibujo es único objeto si pongo dibujos no se puede llamar a varios
			break;
		
		case 104://h
		case 72:
			for(int i = 0; i < dibujos.size(); i++) 
				dibujos.get(i).setImagenes(imagenes[1]);
			break;
			
		case 86://v
		case 118:
			for(int i = 0; i < dibujos.size(); i++) 
			dibujos.get(i).setImagenes(imagenes[2]);
			break;
		}
		return true;
		
	}
	
	public boolean mouseDown(Event ev, int x, int y ) {
		
		for(int i = 0; i<dibujos.size(); i++)	
			if(dibujos.get(i).contains(x,  y))
			
				dibujos.remove(i);
			
		return true;
	}
	
	private void slepp(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {}
	}

}
