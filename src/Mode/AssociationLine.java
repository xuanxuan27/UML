package Mode;

import java.awt.event.*;

import javax.swing.JPanel;

import Shape.AssociationShape;
import Shape.ClassShape;
import Shape.GeneralizationShape;
import Shape.Port;
import UML.DrawPanel;
import UML.UML;

public class AssociationLine extends ConnectionLine implements ActionListener {
	// private AssociationShape associationShape = null;
	private Port headPort, tailPort;
	
	public AssociationLine() {
		line = new AssociationShape(0,0,0,0);
	}
	
	public AssociationLine(int startX, int startY, int endX, int endY){
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		line = new AssociationShape(startX, startY, endX, endY);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Mode.setMode(Mode.ModeType.ASSOCIATION);
	}
	@Override
	public void drawLine() {
		line = new AssociationShape(startX, startY, endX, endY);
        UML.drawPanel.add(line);
        UML.drawPanel.revalidate();
        UML.drawPanel.repaint();
	}
	
	public void setStartPoint(int x, int y) {
		Port port = DrawPanel.Head.findNearestPort(x, y, DrawPanel.Head.shape.ports);
		this.headPort = port;
		this.startX = port.transform().x;
		this.startY = port.transform().y;
		
	}
	
	public void setDragPoint(int x, int y) {
		this.endX = x;
        this.endY = y;
        if (line != null) {
            UML.drawPanel.remove(line);
        }
        drawLine();
	}
	@Override
	public void setEndPoint(int x, int y) {
		Port port = DrawPanel.Tail.findNearestPort(x, y, DrawPanel.Tail.shape.ports);
		this.tailPort = port;
		this.endX = port.transform().x;
		this.endY = port.transform().y;
		if (line != null) {
            UML.drawPanel.remove(line);
        }
        drawLine();
	}
	
	public void moveLineHead(int x, int y) {
		this.startX = x;
        this.startY = y;
        if (line != null) {
            UML.drawPanel.remove(line);
        }
        drawLine();
	}
	
	public void moveLineTail(int x, int y) {
		this.endX = x;
        this.endY = y;
        if (line != null) {
            UML.drawPanel.remove(line);
        }
        drawLine();
	}
}


