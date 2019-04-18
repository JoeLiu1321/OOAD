package diagrams;
import java.util.*;

import shapes.ClassFormat;
import shapes.Relation;

public class UMLClassDiagram{
	private Map<String,ClassFormat> classFormatCollection;
	private List<Relation> relations;
	public UMLClassDiagram() {
		classFormatCollection=new TreeMap<>();
		relations=new ArrayList<>();
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
	
	public void deleteClassFormat(String className){
		classFormatCollection.remove(className);
	}

}
