package Mode;

public abstract class ConnectionLine {
	public abstract void drawLine(int startX, int startY, int endX, int endY);

	public abstract void setStartPoint(int startX, int startY);
	public abstract void setEndPoint(int startX, int startY);
}
