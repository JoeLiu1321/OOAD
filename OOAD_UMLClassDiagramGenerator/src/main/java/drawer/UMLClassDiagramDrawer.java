package drawer;

import visitor.DrawVisitor;
import visitor.Visitor;
import model.diagrams.UMLClassDiagram;
import model.geometric.ClassFormat;
import model.geometric.Relation;

import java.awt.*;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import canvas.Canvas;
import canvas.SwingCanvas;

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
		Canvas canvas = new SwingCanvas(g);
		Visitor drawVisitor = new DrawVisitor(canvas);
		Iterator<ClassFormat> classFormats = diagram.createClassFormatIterator();
		while (classFormats.hasNext()) {
			ClassFormat classFormat = classFormats.next();
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
