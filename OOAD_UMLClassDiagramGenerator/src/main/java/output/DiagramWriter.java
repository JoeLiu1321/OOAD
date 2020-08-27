package output;

import adapter.ClassFormatOutputDTO;
import adapter.RelationOutputDTO;
import model.diagrams.UMLClassDiagram;
import model.geometric.ClassFormat;
import model.geometric.Relation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class DiagramWriter {
    private UMLClassDiagram diagram;

    public DiagramWriter(UMLClassDiagram diagram) {
        this.diagram = diagram;
    }

    public void save(String path) throws IOException {
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File(path));
            Iterator<ClassFormat> classFormatIterator = diagram.createClassFormatIterator();
            Iterator<Relation> relationIterator = diagram.createRelationIterator();
            while (classFormatIterator.hasNext()) {
                ClassFormat classFormat = classFormatIterator.next();
                ClassFormatOutputDTO classFormatOutputDTO = new ClassFormatOutputDTO(classFormat);
                fw.write(classFormatOutputDTO.getOutput());
                fw.write("\r\n");
            }
            while (relationIterator.hasNext()) {
                Relation relation = relationIterator.next();
                RelationOutputDTO relationOutputDTO = new RelationOutputDTO(relation);
                fw.write(relationOutputDTO.getOutput());
                fw.write("\r\n");
            }
        } catch (IOException exception) {
            System.out.println("Invalid path");
        } finally {
            fw.close();
        }
    }

}
