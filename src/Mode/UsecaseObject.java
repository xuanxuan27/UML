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
	// private int x, y;
	private boolean isHead = false, isTail = false;
	// private Select select = null;

	public UsecaseObject() {
		
	}
	
	public UsecaseObject(int x, int y){
		this.x = x;
		this.y = y;
		shape = new UsecaseShape(x, y);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Mode.setMode(Mode.ModeType.USECASE);
	}
	
	@Override
	public void drawObject() {
		shape = new UsecaseShape(x, y);
		shape.setPreferredSize(new Dimension(200, 200));
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
		//select = new Select(this.x, this.y);
		isSelect = true;
		shape.setSelect();
		//DrawPanel.selectedObjs.add(this);
	}
	
	public void unSelected() {
		isSelect = false;
		shape.setUnselect();
		//select.unSelected();
		//select = null;
	}
	
	@Override
	public void updatePosition(int x, int y) {
//		this.x = x;
//		this.y = y;
//		shape.updatePosition(x, y);
		//select.updatePosition(x, y);
		
		this.x = x + shape.getX();
		this.y = y + shape.getY();
		shape.updatePosition(this.x, this.y);
	}
}
