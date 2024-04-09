package Mode;

import Shape.Line;
import Shape.Shape;
import UML.UML;

public abstract class ConnectionLine {
	public Line line = null;
	public int startX, startY, endX, endY;

	public abstract void drawLine();

	public abstract void setStartPoint(int startX, int startY);
	public abstract void setDragPoint(int startX, int startY);
	public abstract void setEndPoint(int startX, int startY);
	
	public abstract void moveLineHead(int x, int y);
	
	public abstract void moveLineTail(int x, int y);
}
