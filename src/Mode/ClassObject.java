package Mode;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Shape.ClassShape;
import UML.DrawPanel;
import UML.UML;

public class ClassObject extends BasicObject implements ActionListener  {
	private ClassShape classShape;
	@Override
	public void actionPerformed(ActionEvent e) {
		Mode.setMode(Mode.ModeType.CLASS);
	}
	
	@Override
	public void drawObject(int x, int y) {
	    classShape = new ClassShape(x, y);
	    UML.drawPanel.add(classShape);
	    UML.drawPanel.revalidate(); // 重新布局
	    UML.drawPanel.repaint(); // 刷新绘图
	}
	
	@Override
	public boolean isHead(int x, int y) {
		if(classShape.isHead(x, y)) {
			setHead();	
			return true;
		}
		else
			return false;
	}
	
	@Override
	public boolean isTail(int x, int y) {
		if(classShape.isTail(x, y)) {
			setTail();
			return true;
		}
		else
			return false;
	}
	
	public void setHead() {
		DrawPanel.Head = this;
	}
	
	public void setTail() {
		DrawPanel.Tail = this;
	}

}
