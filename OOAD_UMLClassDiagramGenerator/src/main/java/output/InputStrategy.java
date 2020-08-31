package output;

import model.diagrams.UMLClassDiagram;

public interface InputStrategy {
    UMLClassDiagram input(String[] input);
}