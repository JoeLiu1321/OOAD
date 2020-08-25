package drawer;

import model.diagrams.UMLClassDiagram;
import java.awt.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import model.shapes.ClassFormat;
import model.shapes.Relation;
import drawer.DrawableClassFormat;
import drawer.DrawableRelation;

public class UMLClassDiagramDrawer extends JPanel implements Observer {
	private UMLClassDiagram diagram;

	public UMLClassDiagramDrawer(UMLClassDiagram diagram) {
		this.diagram = diagram;
		this.diagram.addObserver(this);
		setSize(diagram.getWidth(), diagram.getHeight());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Iterator<Map.Entry<String, ClassFormat>> classFormats = diagram.createClassFormatIterator();
		while (classFormats.hasNext()) {
			Map.Entry<String, ClassFormat> entry = classFormats.next();
			DrawableClassFormat classFormat = new DrawableClassFormat(entry.getValue());
			classFormat.draw(g);
		}
		Iterator<Relation> relations = diagram.createRelationIterator();
		while (relations.hasNext()) {
			Relation relation = relations.next();
			DrawableRelation drawableRelation = new DrawableRelation(relation);
			drawableRelation.draw(g);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		Drawable drawable = (Drawable) arg;
		if (drawable != null)
			drawable.draw(getGraphics());
		else
			repaint();
	}
}
