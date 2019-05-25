package listeners;

import com.sun.javafx.iio.ImageStorage;
import diagrams.UMLClassDiagramDrawer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

    public ActionListener saveListener=new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };

    public ActionListener outputListener =new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            BufferedImage bufferedImage=new BufferedImage(drawer.getWidth(),drawer.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
            Graphics2D g=bufferedImage.createGraphics();
            drawer.print(g);
            try{
                ImageIO.write(bufferedImage,"png",new File(System.getProperty("user.dir")+"/testPng.png"));
            }catch (IOException exception){
                exception.printStackTrace();}
        }
    };

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

    public ItemListener removeUnit=new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange()==1)
                drawer.addMouseListener(removeUnitAdapter);
            else if(e.getStateChange()==2)
                drawer.removeMouseListener(removeUnitAdapter);
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
            listenerHandler.executeAddRelation((Point)start.clone(),(Point)end.clone());
        }
    };

    private MouseAdapter removeRelationAdapter=new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            listenerHandler.executeRemoveRelation(e.getPoint());
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
            start=e.getPoint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            end=e.getPoint();
            listenerHandler.executeMoveUnit((Point)start.clone(),(Point)end.clone());
        }
    };

    private MouseAdapter removeUnitAdapter=new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            listenerHandler.executeRemoveUnit(e.getPoint());
        }
    };
}
