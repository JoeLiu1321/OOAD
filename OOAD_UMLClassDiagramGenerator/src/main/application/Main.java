package main.application;
import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
import main.diagrams.UMLClassDiagram;
import main.diagrams.UMLClassDiagramDrawer;
import main.generator.ArrangeCalculator;
import main.generator.ClassUnitGenerator;
import main.listeners.Listener;
import main.listeners.ListenerHandler;

public class Main{
	public static void main(String[] args) {
		String[]methods= {"public void get()","public void set()"};
		String[]variables= {"int i","int j"};
		String[]classNames={"FileOutputFormat","FileOutputFormatImpl","ClassDiagramGenerator","UmlClassDiagram","relation",
				"UserManager","User","ClassRelationGenerator","ClassUnitGenerator"};
		Toolkit tk = Toolkit.getDefaultToolkit();
	    Dimension d = tk.getScreenSize();
	    int width=(int)d.getWidth(),height=(int)d.getHeight();
	    UMLClassDiagram diagram=new UMLClassDiagram(width,height);
		ClassUnitGenerator unitGenerator=new ClassUnitGenerator();
		for(String className:classNames)
			diagram.addToDiagram(unitGenerator.generateConcreteClassFormat(className,Arrays.asList(methods),Arrays.asList(variables)));

		UMLClassDiagramDrawer drawer=new UMLClassDiagramDrawer(diagram);
		ArrangeCalculator arrangeCalculator =new ArrangeCalculator(diagram);
		arrangeCalculator.arrange();
		ListenerHandler listenerHandler=new ListenerHandler(arrangeCalculator);
		Listener listener=new Listener(drawer,listenerHandler);
		JPanel checkBoxGroup=getCheckBoxGroup(listener);
		JFrame frame=new JFrame("test Panel");
	    frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawer.add(checkBoxGroup);

		frame.add(drawer);
	    frame.setVisible(true);

	}
	public static JPanel getCheckBoxGroup(Listener listener){
		JPanel panel=new JPanel();
		ButtonGroup group=new ButtonGroup();
		JRadioButton moveUnit=new JRadioButton("Move Unit");
		JRadioButton addRelation=new JRadioButton("Add Relation");
		JRadioButton removeRelation=new JRadioButton("Remove Relation");
		moveUnit.addItemListener(listener.moveUnit);
		addRelation.addItemListener(listener.addRelation);
		removeRelation.addItemListener(v->{System.out.println("remove");});
		group.add(moveUnit);
		group.add(addRelation);
		group.add(removeRelation);

		panel.add(moveUnit);
		panel.add(addRelation);
		panel.add(removeRelation);
		return panel;
	}

}
