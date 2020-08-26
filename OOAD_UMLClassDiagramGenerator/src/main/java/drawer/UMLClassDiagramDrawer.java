package drawer;

import model.diagrams.UMLClassDiagram;
import java.awt.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import model.shapes.ClassFormat;
import model.shapes.ConcreteFormat;
import model.shapes.Relation;
import model.shapes.Drawer;
import model.shapes.InterfaceFormat;

public class UMLClassDiagramDrawer extends JPanel implements Observer, Drawer {
	private static final long serialVersionUID = 1L;
	private UMLClassDiagram diagram;
	private Graphics graph;

	public UMLClassDiagramDrawer(UMLClassDiagram diagram) {
		super();
		this.graph = this.getGraphics();
		this.diagram = diagram;
		this.diagram.addObserver(this);
		setSize(diagram.getWidth(), diagram.getHeight());
	}

	@Override
	protected void paintComponent(Graphics g) {
		this.graph = g;
		super.paintComponent(this.graph);
		Iterator<Map.Entry<String, ClassFormat>> classFormats = diagram.createClassFormatIterator();
		while (classFormats.hasNext()) {
			Map.Entry<String, ClassFormat> entry = classFormats.next();
			ClassFormat classFormat = entry.getValue();
			classFormat.draw(this);
		}
		Iterator<Relation> relations = diagram.createRelationIterator();
		while (relations.hasNext()) {
			Relation relation = relations.next();
			relation.draw(this);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

	@Override
	public void draw(ConcreteFormat concreteClass) {
		new DrawableClassFormat(concreteClass).draw(this.graph);
	}

	@Override
	public void draw(InterfaceFormat interfaceClass) {
		new DrawableInterfaceFormat(interfaceClass).draw(this.graph);
	}

	@Override
	public void draw(Relation relation) {
		new DrawableRelation(relation).draw(this.graph);
	}
}
