package listeners;

import model.diagrams.RelationType;
import model.diagrams.UMLClassDiagram;
import generator.ArrangeCalculator;
import output.DiagramReader;
import output.DiagramWriter;
import output.ConvertStrategy;
import output.OutputStrategy;
import output.TextConvertStrategy;
import output.TextOutputStrategy;

import java.awt.*;
import java.io.IOException;

public class ListenerHandler {
    private UMLClassDiagram diagram;
    private String autoSavePath;
    private ArrangeCalculator arrangeCalculator;

    public ListenerHandler(UMLClassDiagram diagram) {
        this.autoSavePath = System.getProperty("user.dir") + "/Untitled_diagram.diagram";
        this.diagram = diagram;
        arrangeCalculator = new ArrangeCalculator(diagram);
    }

    public void executeAddRelation(Point start, Point end, RelationType relationType) {
        arrangeCalculator.bindRelation(start, end, relationType);
        executeSaveDiagram(autoSavePath);
    }

    public void executeMoveUnit(Point start, Point end) {
        arrangeCalculator.moveUnit(start, end);
        executeSaveDiagram(autoSavePath);
    }

    public void executeRemoveUnit(Point location) {
        arrangeCalculator.removeUnit(location);
        executeSaveDiagram(autoSavePath);
    }

    public void executeRemoveRelation(Point location) {
        arrangeCalculator.removeRelation(location);
        executeSaveDiagram(autoSavePath);
    }

    public void executeSaveDiagram(String path) {
        autoSavePath = path;
        OutputStrategy strategy = new TextOutputStrategy(diagram);
        DiagramWriter diagramWriter = new DiagramWriter(strategy);
        try {
            diagramWriter.write(path);
        } catch (IOException ioe) {
            throw new RuntimeException("File didn't close");
        }
    }

    public void executeOpenDiagram(String path) {
        try {
            ConvertStrategy strategy = new TextConvertStrategy();
            DiagramReader diagramReader = new DiagramReader(strategy);
            UMLClassDiagram diagram = diagramReader.read(path);
            this.diagram.setDiagram(diagram);
        } catch (Exception e) {
            throw new RuntimeException("File not found");
        }

    }
}
