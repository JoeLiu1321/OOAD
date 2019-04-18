package diagrams;

import shapes.ClassFormat;
import shapes.Relation;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

public class UMLClassDiagramDrawer extends JPanel{
	List<Drawable>taskList;
	public UMLClassDiagramDrawer(UMLClassDiagram diagram) {
		taskList=new ArrayList<>();
		Iterator<Map.Entry<String,ClassFormat>> classFormats=diagram.createClassFormatIterator();
		while (classFormats.hasNext()){
			Map.Entry<String,ClassFormat>entry=classFormats.next();
			addTask(entry.getValue());
		}
		Iterator<Relation> relations=diagram.createRelationIterator();
		while (relations.hasNext()){
			addTask(relations.next());
		}
	}
	public void addTask(Drawable drawable) {
		taskList.add(drawable);
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Drawable drawable:taskList)
        	drawable.draw(g);
    }
}
