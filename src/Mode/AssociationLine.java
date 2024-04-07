package Mode;

import java.awt.event.*;

import javax.swing.JPanel;

import Shape.AssociationShape;
import UML.UML;

public class AssociationLine extends ConnectionLine implements ActionListener {
	private AssociationShape associationShape = null;
	int startX, startY, endX, endY;

	@Override
	public void actionPerformed(ActionEvent e) {
		Mode.setMode(Mode.ModeType.ASSOCIATION);
	}
	@Override
	public void drawLine(int startX, int startY, int endX, int endY) {
		JPanel associationShape = new AssociationShape(startX, startY, endX, endY);
		UML.drawPanel.add(associationShape);
	    UML.drawPanel.revalidate(); // 重新布局
	    UML.drawPanel.repaint(); // 刷新绘图
	}
	
	public void setStartPoint(int x, int y) {
		this.startX = x;
		this.startY = y;
	}
	
	public void setEndPoint(int x, int y) {
		this.endX = x;
		this.endY = y;
		if(associationShape == null) {
			associationShape = new AssociationShape(startX, startY, endX, endY);
			associationShape.setEndPoint(endX, endY);
			UML.drawPanel.add(associationShape);
		}
		else {
			associationShape.setEndPoint(endX, endY);
		}
		
	    UML.drawPanel.revalidate(); // 重新布局
	    UML.drawPanel.repaint(); // 刷新绘图
	}
}


