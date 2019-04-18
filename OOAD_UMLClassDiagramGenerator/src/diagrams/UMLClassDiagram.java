package diagrams;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import shapes.ClassFormat;

public class UMLClassDiagram{
	Map<String,ClassFormat> classFormatCollection;
	public UMLClassDiagram() {
		classFormatCollection=new TreeMap<>();
	}
	
	public void addToDiagram(ClassFormat format){
		classFormatCollection.put(format.getClassName(), format);
	}
	
	public Iterator<Map.Entry<String,ClassFormat>> createIterator(){
		return classFormatCollection.entrySet().iterator();
	}
	
	public void deleteClassFormat(String className){
		classFormatCollection.remove(className);
	}
	
	

}
