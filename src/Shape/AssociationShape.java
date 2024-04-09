package Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;


public class AssociationShape extends Line{
	private int startX, startY, endX, endY;
	private int width, height;
	public AssociationShape(int startX, int startY, int endX, int endY) {
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
	
	@Override
	protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        g2d.setStroke(new BasicStroke(2));
        
        int x = (getWidth() - width) / 2;
        int y = (getHeight() - height) / 2;
        
        if (startX > endX && startY < endY) {
            g2d.drawLine(x + width, y, x, y + height);
            drawArrow(g2d, x + width, y, x, y + height);
        } else if (startX < endX && startY > endY) {
            g2d.drawLine(x, y + height, x + width, y);
            drawArrow(g2d, x, y + height, x + width, y);
        } else {
            g2d.drawLine(x, y, x + width, y + height);
            drawArrow(g2d, x, y, x + width, y + height);
        }
        
    }
	
	private void drawArrow(Graphics2D g2d, int x1, int y1, int x2, int y2) {
	    int dx = x2 - x1;
	    int dy = y2 - y1;
	    double angle = Math.atan2(dy, dx);
	    int len = (int) Math.sqrt(dx * dx + dy * dy);

	    AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
	    at.concatenate(AffineTransform.getRotateInstance(angle));
	    g2d.transform(at);

	    // 绘制箭头线段
	    g2d.drawLine(0, 0, len, 0);
	    // 绘制箭头头部
	    int arrowSize = 10;
	    Polygon arrow = new Polygon();
	    arrow.addPoint(len, 0);
	    arrow.addPoint(len - arrowSize, arrowSize / 2);
	    arrow.addPoint(len - arrowSize, -arrowSize / 2);
	    g2d.fill(arrow);
	}
}