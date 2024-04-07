package UML;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import Mode.*;
import Shape.Port;

public class DrawPanel extends JPanel {
	private BasicObject basicObj;
	private ConnectionLine line;
    private int clickX, clickY;
    public static int startX, startY, endX, endY;
    public static BasicObject Head = null, Tail = null;
    
    private List<BasicObject> basicObjects;
    
	DrawPanel(){
		basicObjects = new ArrayList<BasicObject>();
		setBackground(Color.black);
		
		addMouseListener(new MouseAdapter() {
		   		    
            @Override
            public void mouseClicked(MouseEvent e) {
            	clickX = e.getX();
            	clickY = e.getY();
            	if (Mode.getMode() == Mode.ModeType.CLASS) {
            		//if(basicObj == null)
            		basicObj = new ClassObject();
            		basicObj.drawObject(clickX, clickY);
            		basicObjects.add(basicObj);
            	}
            	else if (Mode.getMode() == Mode.ModeType.USECASE) {
            		basicObj = new UsecaseObject();
            		basicObj.drawObject(clickX, clickY);
            		basicObjects.add(basicObj);
            	}
            }
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();

                findHead();
                if(Head != null) {
                    System.out.println("pressed x: " + startX + ", y: " + startY);

                	if (Mode.getMode() == Mode.ModeType.ASSOCIATION) {
                		line = new AssociationLine();
                		//line.drawLine(startX, startY, endX, endY);
                	}
                    else if (Mode.getMode() == Mode.ModeType.GENERALIZATION) {
                		line = new GeneralizationLine();
                		//line.drawLine(startX, startY, endX, endY);
                	}
                    else if (Mode.getMode() == Mode.ModeType.COMPOSITION) {
                		line = new CompositionLine();
                		//line.drawLine(startX, startY, endX, endY);
                	}
                	line.setStartPoint(startX, startY);
                }
                
            }
            
            @Override
            public void mouseDragged(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                System.out.println("dragged x: " + endX + ", y: " + endY);
                line.setEndPoint(endX, endY); // Update end point for the line
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                findTail();
                if(Tail != null) {
                	line.setEndPoint(endX, endY); // Update end point for the line
                    repaint();
                }
                Head = null;
            	Tail = null;
            }
            
        });
    	
	}
	
	public void findHead() {
		for(BasicObject basicObj : basicObjects) {
			if(basicObj.isHead(startX, startY))
				break;
		}
	}
	
	public void findTail() {
		for(BasicObject basicObj : basicObjects) {
			if(basicObj.isTail(endX, endY))
				break;
		}
	}
}
