package listeners;

import diagrams.UMLClassDiagram;
import generator.ArrangeCalculator;
import java.awt.*;

public class ListenerHandler {
    private UMLClassDiagram diagram;
    private ArrangeCalculator arrangeCalculator;
    public ListenerHandler(UMLClassDiagram diagram){
        this.diagram=diagram;
        arrangeCalculator=new ArrangeCalculator(diagram);
    }

    public void executeAddRelation(Point start, Point end){
        arrangeCalculator.bindRelation(start,end);
    }

    public void executeMoveUnit(Point start , Point end){
        arrangeCalculator.moveUnit(start,end);
    }

    public void executeRemoveUnit(Point location){
        arrangeCalculator.removeUnit(location);
    }

    public void executeRemoveRelation(Point location){
        arrangeCalculator.removeRelation(location);
    }

    public void executeSaveDiagram(){

    }
}
