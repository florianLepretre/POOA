package drawing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Listener pour g�rer la souris dans la zone de dessin
 */
public class DrawingMouseListener implements MouseMotionListener, MouseListener {

	Drawing drawing;
	Shape currentShape = null;
	
	public DrawingMouseListener(Drawing d){
		drawing = d;
	}
	
	/**
	 * Bouge la forme s�lectionn�e (si une forme est s�lectionn�e)
	 */
	public void mouseDragged(MouseEvent e) {
		if(currentShape != null){
			currentShape.setOrigin(e.getPoint());
			drawing.repaint();
		}
		if(drawing.getSelectedShapeSize() != 0){
			for(Shape s: drawing.getSelectedShapes()){
				s.setOrigin(e.getPoint());
				drawing.repaint();
			}
		}
	}
	
	/**
	 * S�lectionne la forme sur laquelle l'utilisateur a cliqu�
	 */
	public void mousePressed(MouseEvent e) {
		for(Shape s : drawing){
			if(s.isOn(e.getPoint())){
				currentShape = s;
				break;
			}
		}
	}

	/**
	 * D�s�lectionne la forme lorsqu'on lache le clic gauche
	 */
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == 1) {
			currentShape = null;
			if (drawing.getSelectedShapeSize() != 0) {
				drawing.clearSelectedShapes();
				drawing.updateStatus("Objects unselected");
			}
		}
	}

	public void mouseMoved(MouseEvent e) {
	}

	/**
	 * Selectionne des formes par un clic droit
	 */
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 3){
			for(Shape s : drawing){
				if(s.isOn(e.getPoint())){
					drawing.addSelectedShape(s);
					drawing.updateStatus("Selected objects : " + drawing.getSelectedShapeSize());
				}
			}
		}
	}

	public void mouseEntered(MouseEvent e) {		
	}

	public void mouseExited(MouseEvent e) {
	}
}
