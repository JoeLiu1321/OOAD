package diagrams;
import java.util.*;

import shapes.ClassFormat;
import shapes.Relation;

public class UMLClassDiagram{
	private Map<String,ClassFormat> classFormatCollection;
	private List<Relation> relations;
	private int width,height;
	public UMLClassDiagram(int width,int height) {
		classFormatCollection=new TreeMap<>();
		relations=new ArrayList<>();
		setWidth(width);
		setHeight(height);
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

	public void addToDiagram(ClassFormat format){
		classFormatCollection.put(format.getClassName(), format);
	}

	public void addToDiagram(Relation relation){
		relations.add(relation);
	}

	public Iterator<Map.Entry<String,ClassFormat>> createClassFormatIterator(){
		return classFormatCollection.entrySet().iterator();
	}

	public Iterator<Relation> createRelationIterator(){
		return relations.iterator();
	}

	public ClassFormat getClassFormat(String className){
		return classFormatCollection.get(className);
	}
	public void deleteClassFormat(String className){
		classFormatCollection.remove(className);
	}

}
