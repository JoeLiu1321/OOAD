package application;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Arrays;

import javax.swing.JFrame;

import diagrams.RelationType;
import diagrams.UMLClassDiagram;
import diagrams.UMLClassDiagramDrawer;
import diagrams.Drawable;
import generator.ClassRelationGenerator;
import generator.ClassUnitGenerator;
import shapes.ClassFormat;
import shapes.ConcreteFormat;
import shapes.Relation;

public class Main{
	public static void main(String[] args) {
		String[]methods= {"public void get()","public void set()"};
		String[]variables= {"int i","int j"};
		Toolkit tk = Toolkit.getDefaultToolkit();
	    Dimension d = tk.getScreenSize();
	    int width=(int)d.getWidth(),height=(int)d.getHeight();
	    UMLClassDiagram diagram=new UMLClassDiagram();
		ClassUnitGenerator unitGenerator=new ClassUnitGenerator();
		ClassRelationGenerator relationGenerator=new ClassRelationGenerator();

		ClassFormat startClass=unitGenerator.generateConcreteClassFormat("Derry",Arrays.asList(methods),Arrays.asList(variables));
		ClassFormat endClass=unitGenerator.generateInterfaceClassFormat("Joe",Arrays.asList(methods),Arrays.asList(variables));
		Relation relation=relationGenerator.generateRelation(startClass,endClass, RelationType.Association);
		diagram.addToDiagram(startClass);
	    diagram.addToDiagram(endClass);
		diagram.addToDiagram(relation);
	    UMLClassDiagramDrawer drawer=new UMLClassDiagramDrawer(diagram);
				    
	    JFrame frame=new JFrame("test Panel");
	    frame.setSize(width,height);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(drawer);
	   
	    frame.setVisible(true);
	}
}
