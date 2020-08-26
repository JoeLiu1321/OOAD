package model.shapes;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public abstract class ClassFormat extends Rectangle implements Drawable {
	private String className;
	private List<Relation> relations;
	private List<String> methods;
	private List<String> variables;

	public ClassFormat(String className, int x, int y, int width, int height) {
		super(x, y, width, height);
		setClassName(className);
		relations = new ArrayList<>();
	}

	@Override
	public boolean contains(Point2D p) {
		if (width <= 0 || height <= 0)
			return false;
		else {
			if ((p.getX() >= x && p.getX() <= x + width) && (p.getY() >= y && p.getY() <= y + height))
				return true;
		}

		return false;
	}

	@Override
	public void setLocation(int x, int y) {
		int offsetX = x - this.x, offsetY = y - this.y;
		Point offset = new Point(offsetX, offsetY);
		super.setLocation(x, y);
		notifyRelations(offset, this);

	}

	public void notifyRelations(Point offset, ClassFormat classFormat) {
		for (Relation relation : relations)
			relation.update(offset.clone(), classFormat);
	}

	public void regisiterRelation(Relation relation) {
		relations.add(relation);
	}

	public void unregisiterRelation(Relation relation) {
		relations.remove(relation);
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<String> getMethods() {
		return methods;
	}

	public void setMethods(List<String> methods) {
		this.methods = methods;
	}

	public List<String> getVariables() {
		return variables;
	}

	public void setVariables(List<String> variables) {
		this.variables = variables;
	}

}
