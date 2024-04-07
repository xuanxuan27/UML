package UML;
import java.awt.*;
import javax.swing.*;

import Mode.AssociationLine;
import Shape.ClassShape;

public class UML {
    public static JPanel drawPanel; // 声明为类变量以便在各个方法中都能访问
	
	public static void main(String[] args) { 
        JFrame window = new JFrame("My UML Editor");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel basePanel = new JPanel();
        basePanel.setBackground(Color.black);
        JPanel buttonPanel = new JPanel();
        drawPanel = new DrawPanel();
        drawPanel.setLayout(null);
        window.add(basePanel);
        
        basePanel.setLayout(new BoxLayout(basePanel, BoxLayout.X_AXIS));
        basePanel.add(buttonPanel);
        basePanel.add(drawPanel);
         
        ModeButton selectBtn = new ModeButton("select", "SelectIcon.png");
        selectBtn.addActionListener(new Mode.Select());
        
        ModeButton associationLineBtn = new ModeButton("association", "AssociationLineIcon.png");
        associationLineBtn.addActionListener(new Mode.AssociationLine());
        
        ModeButton generalizationLineBtn = new ModeButton("generalization", "GenerationLineIcon.png");
        generalizationLineBtn.addActionListener(new Mode.GeneralizationLine());
        
        ModeButton compositionLineBtn = new ModeButton("composition", "CompositionLineIcon.png");
        compositionLineBtn.addActionListener(new Mode.CompositionLine());
        
        ModeButton classBtn = new ModeButton("class", "ClassIcon.png");
        classBtn.addActionListener(new Mode.ClassObject());

        ModeButton usecaseBtn = new ModeButton("usecase", "UseCaseIcon.png");
        usecaseBtn.addActionListener(new Mode.UsecaseObject());
        
        // Add buttons to basePanel
        buttonPanel.setBackground(Color.black);

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(selectBtn);
        buttonPanel.add(associationLineBtn);
        buttonPanel.add(generalizationLineBtn);
        buttonPanel.add(compositionLineBtn);
        buttonPanel.add(classBtn);
        buttonPanel.add(usecaseBtn);
        
//        JPanel circlePanel = new ClassShape(); // 使用自定义的 CirclePanel
//        circlePanel.setPreferredSize(new Dimension(200, 200)); // 设置面板大小
//        drawPanel.add(circlePanel);
//        
         
        window.setVisible(true);
    }

}
