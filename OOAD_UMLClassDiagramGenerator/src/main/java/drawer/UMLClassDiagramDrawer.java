package drawer;

import model.classDetail.ClassFormat;
import model.classDetail.ConcreteFormat;
import visitor.DrawVisitor;
import visitor.Visitor;
import model.classDetail.InterfaceFormat;
import model.classDetail.Relation;
import model.diagrams.UMLClassDiagram;
import java.awt.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class UMLClassDiagramDrawer extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	private UMLClassDiagram diagram;

	public UMLClassDiagramDrawer(UMLClassDiagram diagram) {
		super();
		this.diagram = diagram;
		this.diagram.addObserver(this);
		setSize(diagram.getWidth(), diagram.getHeight());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Visitor drawVisitor = new DrawVisitor(g);
		Iterator<Map.Entry<String, ClassFormat>> classFormats = diagram.createClassFormatIterator();
		while (classFormats.hasNext()) {
			Map.Entry<String, ClassFormat> entry = classFormats.next();
			ClassFormat classFormat = entry.getValue();
			classFormat.accept(drawVisitor);
		}
		Iterator<Relation> relations = diagram.createRelationIterator();
		while (relations.hasNext()) {
			Relation relation = relations.next();
			relation.accept(drawVisitor);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

}
