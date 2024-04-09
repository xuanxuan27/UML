package Shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class CompositionShape extends Line{
	private int startX, startY, endX, endY;
	private int width, height;
	
	public CompositionShape(int startX, int startY, int endX, int endY) {
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.width = Math.abs(endX-startX);
		this.height = Math.abs(endY-startY);
		
        setPreferredSize(new Dimension(width, height));
        setOpaque(false);
        setBounds(Math.min(startX, endX), Math.min(startY, endY), width, height);
    }
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        g2d.setStroke(new BasicStroke(2));
        
        int x = (getWidth() - width) / 2;
        int y = (getHeight() - height) / 2;
        
        if(startX > endX && startY < endY) {
        	g2d.drawLine(x + width, y, x , y + height);
        }
        else if (startX < endX && startY > endY) {
        	g2d.drawLine(x, y+height, x+width, y);
        }
        else {
        	g2d.drawLine(x, y, x+width, y+height);
        }
    }
	
	public void setStartPoint(int x, int y) {
		this.startX = x;
		this.startY = y;
		revalidate();
		repaint();
	}
	
	public void setEndPoint(int x, int y) {
		this.endX = x;
		this.endY = y;
		this.width = Math.abs(endX-startX);
		this.height = Math.abs(endY-startY);
		revalidate();
		repaint();
	}
}
