package Shape;

import java.awt.*;

public class Port {
	private int x;
    private int y;
    private int size = 4;
    private boolean isConnected = false;

    // 在指定位置创建端口
    public Port(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 繪製端口
    public void paint(Graphics2D g2d) {
//        g2d.setColor(Color.white);
//        g2d.fillOval(x - size / 2, y - size / 2, size, size);
    	
    	g2d.setColor(Color.white);
        g2d.fillRect(x, y, size, size);
        g2d.setColor(Color.white);
        g2d.drawRect(x, y, size, size);
        // g2d.drawString(position, x, y - 5);
    }
}
