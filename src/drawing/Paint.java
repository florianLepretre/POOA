package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 * Classe Interface graphique pour l'application de dessin
 */
public class Paint {

	private JFrame frame;
	private JLabel status;
	private JButton clearButton;
	private JButton circleButton;
	private JButton rectangleButton;
	private JPanel statusPanel;
	private JPanel buttonPanel;
	private JPanel mainPanel;
	private JPanel bottomPanel;
	private Drawing drawing;
	
	private Observer observer;
	
	public void run(){
		observer = new Observer(this);
		
		frame = new JFrame("Paint");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new JPanel(new BorderLayout());
		bottomPanel = new JPanel(new BorderLayout());
		
		drawing = new Drawing(observer);
		drawing.setBackground(Color.WHITE);
		clearButton = new JButton("Clear");
		circleButton = new JButton("Circle");
		rectangleButton = new JButton("Rectangle");
		
		buttonPanel = new JPanel();
		buttonPanel.add(clearButton);
		buttonPanel.add(circleButton);
		buttonPanel.add(rectangleButton);
		
		status = new JLabel("Status Bar");
		status.setFont(new Font("Sans Serif", Font.ITALIC, 12));
		statusPanel = new JPanel();
		statusPanel.setBorder(new EtchedBorder (EtchedBorder.LOWERED));
		statusPanel.add(status);		
		
		bottomPanel.add(buttonPanel, BorderLayout.NORTH);
		bottomPanel.add(statusPanel, BorderLayout.SOUTH);		
		
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		mainPanel.add(drawing, BorderLayout.CENTER);
		
		//listeners pour les boutons
		clearButton.addActionListener(new ClearButtonListener(drawing));
		circleButton.addActionListener(new CircleButtonListener(drawing));
		rectangleButton.addActionListener(new RectangleButtonListener(drawing));
		
		//listeners pour la zone de dessin
		DrawingMouseListener l = new DrawingMouseListener(drawing);
		drawing.addMouseListener(l);
		drawing.addMouseMotionListener(l);

		frame.getContentPane().add(mainPanel);
		frame.setSize(640,480);
		frame.setVisible(true);
	}
	
	public void setStatus (String message){
		status.setText(message);
	}
	
	
	public static void main(String[] args){
		Paint app = new Paint();
		app.run();
	}
}
