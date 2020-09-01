package model.diagrams;

import java.util.*;
import java.util.List;

import model.geometric.ClassFormat;
import model.geometric.Relation;

public class UMLClassDiagram {
	private Map<String, ClassFormat> classFormatCollection;
	private List<Relation> relations;
	private int width, height;

	public UMLClassDiagram(int width, int height) {
		classFormatCollection = new TreeMap<>();
		relations = new ArrayList<>();
		setWidth(width);
		setHeight(height);
	}

	public UMLClassDiagram() {
		setWidth(0);
		setHeight(0);
		classFormatCollection = new TreeMap<>();
		relations = new ArrayList<>();
	}

	public void setDiagram(UMLClassDiagram diagram) {
		classFormatCollection.clear();
		relations.clear();
		Iterator<ClassFormat> classFormatIterator = diagram.createClassFormatIterator();
		while (classFormatIterator.hasNext()) {
			ClassFormat classFormat = classFormatIterator.next();
			classFormatCollection.put(classFormat.getClassName(), classFormat);
		}
		Iterator<Relation> relationIterator = diagram.createRelationIterator();
		while (relationIterator.hasNext()) {
			Relation relation = relationIterator.next();
			relations.add(relation);
		}
		setHeight(diagram.getHeight());
		setWidth(diagram.getWidth());
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void addToDiagram(ClassFormat format) {
		classFormatCollection.put(format.getClassName(), format);
	}

	public void addToDiagram(Relation relation) {
		relations.add(relation);

	}

	public void setClassFormatLocation(String className, int x, int y) throws Exception {
		getClassFormat(className).setLocation(x, y);
	}

	public Iterator<ClassFormat> createClassFormatIterator() {
		return classFormatCollection.values().iterator();
	}

	public Iterator<Relation> createRelationIterator() {
		return relations.iterator();
	}

	public ClassFormat getClassFormat(String className) throws Exception {
		if (!classFormatCollection.containsKey(className))
			throw new Exception("The class '" + className + "' is not in the diagram");
		else
			return classFormatCollection.get(className);
	}

	public void removeClassFormat(ClassFormat classFormat) {
		if (classFormat != null && classFormatCollection.containsKey(classFormat.getClassName())) {
			classFormatCollection.remove(classFormat.getClassName());
		}
	}

	public void removeRelation(Relation relation) {
		if (relation != null && relations.contains(relation)) {
			relations.remove(relation);
		}
	}

}
