package Mode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Shape.GeneralizationShape;
import UML.UML;

public class GeneralizationLine extends ConnectionLine implements ActionListener {
	int startX, startY, endX, endY;
	@Override
	public void drawLine(int startX, int startY, int endX, int endY) {
		JPanel generalizationShape = new GeneralizationShape(startX, startY, endX, endY);
		UML.drawPanel.add(generalizationShape);
	    UML.drawPanel.revalidate();
	    UML.drawPanel.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Mode.setMode(Mode.ModeType.GENERALIZATION);
	}
	
	public void setStartPoint(int x, int y) {
		this.startX = x;
		this.startY = y;
	}
	
	public void setEndPoint(int x, int y) {
		this.endX = x;
		this.endY = y;
		JPanel generalizationShape = new GeneralizationShape(startX, startY, endX, endY);
		UML.drawPanel.add(generalizationShape);
	    UML.drawPanel.revalidate();
	    UML.drawPanel.repaint();
	}
}
