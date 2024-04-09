package Mode;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import Shape.ClassShape;
import UML.DrawPanel;
import UML.UML;

public class ClassObject extends BasicObject implements ActionListener  {
	private boolean isHead = false, isTail = false;
	// private int x, y;
	private Select select;
	// public boolean isSelect = false;

	public ClassObject() {
		
	}
	
	public ClassObject(int x, int y){
		
		this.x = x;
		this.y = y;
		shape = new ClassShape(x, y);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Mode.setMode(Mode.ModeType.CLASS);
	}
	
	@Override
	public void drawObject() {
	    UML.drawPanel.add(shape);
	    UML.drawPanel.revalidate(); // 重新布局
	    UML.drawPanel.repaint(); // 刷新绘图
	}
	
	@Override
	public boolean isHead(int x, int y) {
		if(shape.isHead(x, y)) {
			setHead();	
			return true;
		}
		else
			return false;
	}
	
	@Override
	public boolean isTail(int x, int y) {
		if(shape.isTail(x, y)) {
			setTail();
			return true;
		}
		else
			return false;
	}
	
	public void setHead() {
		isHead = true;
		DrawPanel.Head = this;
		
	}
	
	public void setTail() {
		isTail = true;
		DrawPanel.Tail = this;

	}
	
	@Override
	public void setSelected() {
		isSelect = true;
		shape.setSelect();
	}
	
	public void unSelected() {
		isSelect = false;
		shape.setUnselect();
	}
	
	@Override
	public void updatePosition(int x, int y) {
		
		this.x = x + shape.getX();
		this.y = y + shape.getY();
		shape.updatePosition(this.x, this.y);
	}
	
}
