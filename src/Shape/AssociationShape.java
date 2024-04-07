package Shape;

import javax.swing.*;
import java.awt.*;


public class AssociationShape extends JPanel{
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
		repaint();
	}
	
	public void setEndPoint(int x, int y) {
		this.endX = x;
		this.endY = y;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        g2d.setStroke(new BasicStroke(2));
        
        int x = (getWidth() - width) / 2; // 計算出長方形左上角 x 坐標
        if(startX > endX) {
        	x = x + width;
        	width = -width;
        }
        
        int y = (getHeight() - height) / 2; // 計算出長方形左上角 y 坐標
        if(startY > endY) {
        	y = y + height;
        	height = -height;
        }
        
        g2d.drawLine(x, y, x + width , y + height);
    }
}

//會有問題：下往上畫好像每一次建立會互相影響，所以下一次新增下往上的時候，之前加入的所有下往上方向都會改變
