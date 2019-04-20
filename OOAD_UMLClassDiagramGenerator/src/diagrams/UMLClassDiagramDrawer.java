package diagrams;

import shapes.ClassFormat;
import shapes.Relation;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;

public class UMLClassDiagramDrawer extends JPanel{
	List<Drawable>taskList;
	Point start,end;
	public UMLClassDiagramDrawer(UMLClassDiagram diagram) {
		setStart(new Point(0,0));
		setEnd(new Point(0,0));
		taskList=new ArrayList<>();

		setSize(diagram.getWidth(),diagram.getHeight());
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

	public void drawTask(Drawable drawable){
		taskList.add(drawable);
		drawable.draw(getGraphics());
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Drawable drawable:taskList)
        	drawable.draw(g);
    }

}
