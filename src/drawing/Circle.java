package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Circle extends Shape{
	private Color color;
	
	private double radius;
	
	public Circle(int id, Point origin, double radius, Color color){
		this.id = id;
		this.origin = origin;
		this.radius = radius;
		this.color = color;
	}
	
	public void paint(Graphics g){
		g.setColor(color);
		g.fillOval((int)(origin.getX()-radius), (int)(origin.getY()-radius), (int)(2*radius), (int)(2*radius));
		g.setColor(Color.BLACK);
		g.drawOval((int)(origin.getX()-radius), (int)(origin.getY()-radius), (int)(2*radius), (int)(2*radius));
	}
	
	public boolean isOn(Point p) {
		return distanceToCenter(p)<radius;		
	}
	
	private double distanceToCenter(Point p){
		return this.origin.distance(p);
	}
	
	public double getRadius(){
		return radius;
	}
	
	public Color getColor(){
		return color;
	}
}
