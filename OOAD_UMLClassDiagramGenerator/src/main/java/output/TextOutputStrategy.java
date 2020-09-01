package output;

import java.util.Iterator;

import adapter.ClassFormatOutputDTO;
import adapter.RelationOutputDTO;
import model.diagrams.UMLClassDiagram;
import model.geometric.ClassFormat;
import model.geometric.Relation;

public class TextOutputStrategy implements OutputStrategy {
    private UMLClassDiagram diagram;

    public TextOutputStrategy(UMLClassDiagram diagram) {
        this.diagram = diagram;
    }

    @Override
    public String output() {
        StringBuilder outputBuilder = new StringBuilder();
        Iterator<ClassFormat> classFormatIterator = diagram.createClassFormatIterator();
        Iterator<Relation> relationIterator = diagram.createRelationIterator();
        while (classFormatIterator.hasNext()) {
            ClassFormat classFormat = classFormatIterator.next();
            ClassFormatOutputDTO classFormatOutputDTO = new ClassFormatOutputDTO(classFormat);
            outputBuilder.append(classFormatOutputDTO.getOutput());
            outputBuilder.append("\r\n");
        }
        while (relationIterator.hasNext()) {
            Relation relation = relationIterator.next();
            RelationOutputDTO relationOutputDTO = new RelationOutputDTO(relation);
            outputBuilder.append(relationOutputDTO.getOutput());
            outputBuilder.append("\r\n");
        }
        return outputBuilder.toString();
    }
}