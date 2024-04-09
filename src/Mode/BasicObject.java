package Mode;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import Shape.Line;
import Shape.Port;
import Shape.Shape;
import UML.DrawPanel;
import UML.UML;

public abstract class BasicObject{
	private int depth;
	public int x, y;
	public Shape shape;
	public ArrayList<ConnectionLine> HeadLines = new ArrayList<ConnectionLine>();
	public ArrayList<ConnectionLine> TailLines = new ArrayList<ConnectionLine>();;
	public boolean isSelect = false;
	
	int getDepth() {
		return depth;
	}
	
	public abstract void drawObject();
	public abstract boolean isHead(int x, int y);
	public abstract boolean isTail(int x, int y);
	public abstract void updatePosition(int x, int y);
	public abstract void setSelected();
	public abstract void unSelected();

	public Port findNearestPort(int mouseX, int mouseY, ArrayList<Port> ports) {
	    Port nearestPort = null;
	    double minDistance = Double.MAX_VALUE;
	    
	    for (Port port : ports) {
	        int portCenterX = port.getX() + port.getSize() / 2;
	        int portCenterY = port.getY() + port.getSize() / 2;
	        
	        //  轉換座標系
	        Point point = port.transform();
	        
	        // 計算鼠標點擊位置與端口中心的距離
	        double distance = Math.sqrt(Math.pow(point.x - mouseX, 2) + Math.pow(point.y - mouseY, 2));

	        // 更新最近端口
	        if (distance < minDistance) {
	            minDistance = distance;
	            nearestPort = port;
	        }
	    }

	    return nearestPort;
	}
	
	public void updateConnections(int dx, int dy) {
		for(ConnectionLine line : HeadLines) {
			if (line != null) {
		        line.moveLineHead(line.startX + dx, line.startY + dy);
		    }
		}
		for(ConnectionLine line : TailLines) {
			if (line != null) {
		        line.moveLineTail(line.endX + dx, line.endY + dy);
		    }		
		}
	}
	
}
