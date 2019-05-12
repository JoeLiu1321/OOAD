package listeners;

import generator.ArrangeCalculator;
import java.awt.*;

public class ListenerHandler {
    private ArrangeCalculator arrangeCalculator;
    public ListenerHandler(ArrangeCalculator arrangeCalculator){
        this.arrangeCalculator=arrangeCalculator;
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
}
