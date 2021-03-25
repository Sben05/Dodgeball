import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Ball extends JComponent {
	
	private Ellipse2D.Double circle; 
	private int dx;
	private int dy;
	private char type;
	
	public Ball(int x, int y, char type){
		circle = new Ellipse2D.Double(0,0,15,15);
		this.setSize(new Dimension(16,16));
		this.setLocation(x,y);
		
		dx = 7;
		dy = 0;
		this.type = type;
	}
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		if (type == 'A') {
			g2.setColor(Color.black);
		}
		else {
			g2.setColor(Color.white);
		}
		g2.fill(circle);
		if (type == 'A') {
			g2.setColor(Color.white);
		}
		else {
			g2.setColor(Color.black);
		}
		g2.draw(circle);
	}
	public void setDx(int x) {
		dx = 0;
		dx = x*5;
	}
	public void setDy(int y) {
		dx = 0;
		dy = y*5;
	}
	public char getType() {
		return type;
	}
	public void update () {
		setLocation(getX()+dx, getY()+dy);
	}
}
