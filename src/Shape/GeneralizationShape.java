package Shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GeneralizationShape extends JPanel{
	private int startX, startY, endX, endY;
	private int width, height;
	
	public GeneralizationShape(int startX, int startY, int endX, int endY) {
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
        
        int x = (getWidth() - width) / 2; // �p��X����Υ��W�� x ����
        if(startX > endX) {
        	x = x + width;
        	width = -width;
        }
        
        int y = (getHeight() - height) / 2; // �p��X����Υ��W�� y ����
        if(startY > endY) {
        	y = y + height;
        	height = -height;
        }
        
        g2d.drawLine(x, y, x + width , y + height);
    }
}
