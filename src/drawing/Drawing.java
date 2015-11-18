package drawing;

import javax.swing.*;
import java.awt.*;
import java.util.*;
/**
 * JPanel pouvant afficher des objets de type Shape
 */
public class Drawing extends JPanel implements Iterable<Shape> {

	private static final long serialVersionUID = 1L;

	private Observer observer;
	
	ArrayList<Shape> shapes;
	
	public Drawing(Observer observer){
		super();
		shapes = new ArrayList<Shape>();
		this.observer = observer;
	}
	
	/**
	 * Impl�mentation de l'interface Iterable<Shape>
	 */
	public Iterator<Shape> iterator(){
		return shapes.iterator();
	}
	
	/**
	 * Ajoute une forme au dessin et redessine
	 */
	public void addShape(Shape s){
		shapes.add(s);
		observer.update("Object(s) drawn : " + shapes.size());
		this.repaint();
	}
	
	/** 
	 * Red�finition de la m�thode paintComponent() de JComponent
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Shape s : shapes){
			s.paint(g);
		}
	}
	
	/**
	 * Enl�ve toutes les formes et redessine
	 */
	public void clear(){
		shapes.clear();
		observer.update("Object(s) drawn : " + shapes.size());
		this.repaint();
	}
	
	public void updateStatus(String message){
		observer.update(message);
	}
	
	public int getShapeSize(){
		return shapes.size();
	}
}
