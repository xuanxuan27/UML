package Shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class UsecaseShape extends Shape {
	private int width = 80; // 设置类图形的默认大小
    private int height = 60;
    // private List<Port> ports; // 端口列表
    private JLabel label; // 用于显示文本的标签组件
    private String text = "Basic Object"; // 文本内容

    public UsecaseShape(int x, int y) {
        setPreferredSize(new Dimension(width, height)); // 设置组件大小
        setOpaque(false);
        setBounds(x, y, width, height);
        ports = new ArrayList<Port>(4);
        addPorts(); // 添加端口
        
        this.text = text;
        label = new JLabel(text); // 创建一个显示文本的标签
        label.setBounds(10, 10, 100, 20); // 设置标签的位置和大小
        label.setForeground(Color.white); // 设置字体颜色，默认为黑色
        add(label); // 将标签添加到面板中
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.gray);
        g2d.setStroke(new BasicStroke(2));
        
        int x = (getWidth() - width) / 2; // 根据组件大小计算出 x 坐标
        int y = (getHeight() - height) / 2; // 根据组件大小计算出 y 坐标
        g2d.drawOval(x, y, width, height); // 使用 fillOval 方法填充圆形
        
        // 繪製端口
        for (Port port : ports) {
            port.paint(g2d);
        }
    }
    
    // 添加端口
    private void addPorts() {
        int centerX = (width-2) / 2;
        int centerY = (height-2) / 2;

        ports.add(new Port(centerX, 0, this)); // top
        ports.add(new Port(centerX, height-2, this)); // bottom
        ports.add(new Port(0, centerY, this)); // left
        ports.add(new Port(width-2, centerY, this)); // right
    }
    public void setText(String text) {
        this.text = text;
        label.setText(text); // 更新标签的文本内容
    }

    public String getText() {
        return text;
    }
    
    public boolean isHead(int x, int y) {
        return getBounds().contains(x, y);
    }
    
    public boolean isTail(int x, int y) {
        return getBounds().contains(x, y);
    }
    
    @Override
    public void setSelect() {
    	portVisible(ports);
    }
    
    public void setUnselect() {
    	portInvisible(ports);
    }
    
	
}
