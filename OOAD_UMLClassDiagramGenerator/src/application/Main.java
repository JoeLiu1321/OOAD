package application;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Arrays;

import javax.swing.JFrame;
import diagrams.UMLClassDiagram;
import diagrams.UMLClassDiagramDrawer;
import diagrams.Drawable;
import shapes.ClassFormat;
import shapes.ConcreteFormat;
public class Main{
	public static void main(String[] args) {
		String[]methods= {"public void get()","public void set()"};
		String[]variables= {"int i","int j"};
		Toolkit tk = Toolkit.getDefaultToolkit();
	    Dimension d = tk.getScreenSize();
	    int width=(int)d.getWidth(),height=(int)d.getHeight();
	    UMLClassDiagram diagram=new UMLClassDiagram();
	    ClassFormat c=new ConcreteFormat("Main");
	    c.setMethods(Arrays.asList(methods));
	    c.setVariables(Arrays.asList(variables));
	    diagram.addToDiagram(c);
	    UMLClassDiagramDrawer drawer=new UMLClassDiagramDrawer(c);
				    
	    JFrame frame=new JFrame("test Panel");
	    frame.setSize(width,height);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(drawer);
	   
	    frame.setVisible(true);
	}
}
