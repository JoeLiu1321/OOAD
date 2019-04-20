package listeners;

import diagrams.UMLClassDiagramDrawer;
import java.awt.*;
import java.awt.event.*;

public class Listener {
    UMLClassDiagramDrawer drawer;
    private ListenerHandler listenerHandler;
    Point start,end;
    public Listener(UMLClassDiagramDrawer drawer, ListenerHandler listenerHandler){
        this.listenerHandler=listenerHandler;
        this.drawer=drawer;
        start=new Point(0,0);
        end=new Point(0,0);
    }

    public ItemListener addRelation=new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange()==1)
                drawer.addMouseListener(addRelationAdapter);
            else if(e.getStateChange()==2)
                drawer.removeMouseListener(addRelationAdapter);
        }
    };

    public ItemListener removeRelation=new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange()==1)
                drawer.addMouseListener(removeRelationAdapter);
            else if(e.getStateChange()==2)
                drawer.removeMouseListener(removeRelationAdapter);
        }
    };

    public ItemListener moveUnit=new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange()==1)
                drawer.addMouseListener(moveUnitAdapter);
            else if(e.getStateChange()==2)
                drawer.removeMouseListener(moveUnitAdapter);
        }
    };

    private MouseAdapter addRelationAdapter=new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            start=e.getPoint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            end=e.getPoint();
            listenerHandler.notify((Point)start.clone(),(Point)end.clone());
        }
    };

    private MouseAdapter removeRelationAdapter=new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);

        }
    };

    private MouseAdapter moveUnitAdapter=new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);

        }
    };
}
