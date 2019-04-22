package listeners;

import generator.ArrangeCalculator;
import shapes.ClassFormat;

import java.awt.*;

public class ListenerHandler {
    Point start,end;
    ArrangeCalculator arrangeCalculator;
    public ListenerHandler(ArrangeCalculator arrangeCalculator){
        this.arrangeCalculator=arrangeCalculator;
    }

    public void executeAddRelation(Point start, Point end){
        this.start=start;
        this.end=end;
        arrangeCalculator.calculateArrange(start,end);
    }

    public void executeMoveUnit(Point start , Point end){
        this.start=start;
        this.end=end;
        arrangeCalculator.moveUnit(start,end);
    }

    public void executeRemoveUnit(Point start){
        ClassFormat classFormat=arrangeCalculator.checkPointContains(start);
        arrangeCalculator.removeUnit(classFormat);
    }

}
