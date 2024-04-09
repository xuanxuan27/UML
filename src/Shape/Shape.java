package Shape;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public abstract class Shape extends JPanel {
	
	public ArrayList<Port> ports;
	public abstract boolean isHead(int x, int y);
	public abstract boolean isTail(int x, int y);
	public abstract void setSelect();
	public abstract void setUnselect();
	public abstract void setText(String text);
    public abstract String getText() ;
	public void updatePosition(int x, int y) {
        setLocation(x, y); // 更新物件位置
    }
	public void portVisible(ArrayList<Port> ports) {
		for(Port port: ports) {
			port.setVisible();
		}
	}
	
	public void portInvisible(ArrayList<Port> ports) {
		for(Port port: ports) {
			port.setInvisible();
		}
	}
}
