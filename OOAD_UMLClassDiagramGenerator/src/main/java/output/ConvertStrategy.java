package output;

import model.diagrams.UMLClassDiagram;

public interface ConvertStrategy {
    UMLClassDiagram convert(String[] input);
}