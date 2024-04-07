package Shape;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import Mode.AssociationLine;
import Mode.ClassObject;
import Mode.CompositionLine;
import Mode.GeneralizationLine;
import Mode.Mode;
import Mode.UsecaseObject;
import UML.DrawPanel;

import java.util.ArrayList;
import java.util.List;

public class ClassShape extends JPanel{
	private int x, y;
	private int width = 80; // 長方形寬度
    private int height = 90; // 長方形高度
    private int lineSpacing = 30; // 槓之間的間距
    private List<Port> ports; // 端口列表

    public ClassShape(int x, int y) {
        setPreferredSize(new Dimension(width, height)); // 设置组件大小
        setOpaque(false);
        setBounds(x, y, width, height);
        ports = new ArrayList<Port>(4);
        addPorts(); // 添加端口
    }

    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.gray);
        g2d.setStroke(new BasicStroke(2));
        
        this.x = (getWidth() - width) / 2; // 計算出長方形左上角 x 坐標
        this.y = (getHeight() - height) / 2; // 計算出長方形左上角 y 坐標
        
        // 繪製長方形
        g2d.drawRect(x, y, width-2, height-2);
        
        // 計算槓的個數
        int numLines = (height - lineSpacing) / lineSpacing;
        
        // 計算第一條槓的位置
        int startX = x;
        int startY = y + lineSpacing;
        
        // 繪製槓
        for (int i = 0; i < numLines; i++) {
            g2d.drawLine(startX, startY + i * lineSpacing, startX + width-2, startY + i * lineSpacing);
        }
        
        // 繪製端口
        for (Port port : ports) {
            port.paint(g2d);
        }
        
        
    }
    
    // 添加端口
    private void addPorts() {
        int centerX = (width-2) / 2;
        int centerY = (height-2) / 2;

        ports.add(new Port(centerX, 0)); // top
        ports.add(new Port(centerX, height-2)); // bottom
        ports.add(new Port(0, centerY)); // left
        ports.add(new Port(width-2, centerY)); // right
    }
    
    public boolean isHead(int x, int y) {
        return getBounds().contains(x, y);
    }
    
    public boolean isTail(int x, int y) {
        return getBounds().contains(x, y);
    }
    
}
