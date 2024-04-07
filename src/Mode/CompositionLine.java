package Mode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import Shape.CompositionShape;
import UML.UML;

public class CompositionLine extends ConnectionLine implements ActionListener {
	@Override
	public void drawLine(int startX, int startY, int endX, int endY) {
		JPanel compositionShape = new CompositionShape(startX, startY, endX, endY);
		UML.drawPanel.add(compositionShape);
	    UML.drawPanel.revalidate(); // 重新布局
	    UML.drawPanel.repaint(); // 刷新绘图
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Mode.setMode(Mode.ModeType.COMPOSITION);
	}
	
	public void setStartPoint(int x, int y) {
		
	}
	
	public void setEndPoint(int x, int y) {
		
	}
}
