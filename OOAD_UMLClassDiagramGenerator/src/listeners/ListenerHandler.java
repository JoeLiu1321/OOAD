package listeners;

import generator.ArrangeCalculator;
import java.awt.*;

public class ListenerHandler {
    Point start,end;
    ArrangeCalculator arrangeCalculator;
    public ListenerHandler(ArrangeCalculator arrangeCalculator){
        this.arrangeCalculator=arrangeCalculator;
    }
    public void notify(Point start, Point end){
        this.start=start;
        this.end=end;
        arrangeCalculator.calculateArrange(start,end);
    }

}
