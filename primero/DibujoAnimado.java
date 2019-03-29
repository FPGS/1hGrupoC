package primero;
import java.applet.Applet;
import java.awt.*;

public class DibujoAnimado extends Rectangle{// se 
	//int posX;
	
	private Image imagenes[];//array unidimensional, 
	int actual=0 ;
	
	public DibujoAnimado(Image ima[], int posX) {//recibe vector de imagenes y lo pasa al atributo imagenes
		super(posX, 0, 100, 120);
		imagenes = ima; 
		//this.posX = posX;
		x= posX;
	}
	
	public void dibujar(Graphics ggg, Applet aaa) { //decirle donde lo tiene que dibujar con el applet 
		
		ggg.drawImage(imagenes[actual], x, y, width, height, aaa);//6 maxmo x, 0, 100, 120, aaa
		//imagen que quiero dibujar, posición x e y y donde dibujarlo (applet)
		
	}
	
	public void actualizar() {
		actual = (actual+1)%imagenes.length;
//		vamos sumandole 1 a actial y dividiendolo por todas las imagenes para que nos se salga del vector y
//		se mete en actual
		
			
	}
	
	
	public void setImagenes(Image imgs[]) {//configurar 
		imagenes = imgs; //cargar imagenes con el img unidimensional 
	}

}
