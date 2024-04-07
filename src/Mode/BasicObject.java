package Mode;

public abstract class BasicObject{
	private int depth;
	
	int getDepth() {
		return depth;
	}
	
	public abstract void drawObject(int x, int y);
	public abstract boolean isHead(int x, int y);
	public abstract boolean isTail(int x, int y);
}
