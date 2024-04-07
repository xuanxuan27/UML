package Mode;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Shape.ClassShape;
import Shape.UsecaseShape;
import UML.DrawPanel;
import UML.UML;

public class UsecaseObject extends BasicObject implements ActionListener {
	private UsecaseShape usecaseShape;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Mode.setMode(Mode.ModeType.USECASE);
	}
	
	@Override
	public void drawObject(int x, int y) {
		usecaseShape = new UsecaseShape(x, y);
		usecaseShape.setPreferredSize(new Dimension(200, 200));
		UML.drawPanel.add(usecaseShape);
        UML.drawPanel.revalidate(); // 重新布局
        UML.drawPanel.repaint(); // 刷新绘图
	}

	@Override
	public boolean isHead(int x, int y) {
		if(usecaseShape.isHead(x, y)) {
			setHead();	
			return true;
		}
		else
			return false;
	}
	
	@Override
	public boolean isTail(int x, int y) {
		if(usecaseShape.isTail(x, y)) {
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
