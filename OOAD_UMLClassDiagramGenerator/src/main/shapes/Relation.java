package main.shapes;

import main.diagrams.Drawable;
import main.diagrams.RelationType;

import java.awt.*;

public class Relation implements Drawable {
    private ClassFormat startClass,endClass;
    private RelationType relationType;
    private int startX,endX,startY,endY;
    public Relation(ClassFormat startClass , ClassFormat endClass , RelationType relationType){
        setStartClass(startClass);
        setEndClass(endClass);
        setRelationType(relationType);
        setStartX(startClass.x);
        setStartY(startClass.y);
        setEndX(endClass.x);
        setEndY(endClass.y);
    }

    public ClassFormat getStartClass() {
        return startClass;
    }

    public ClassFormat getEndClass() {
        return endClass;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public void setStartClass(ClassFormat startClass) {
        this.startClass = startClass;
    }

    public void setEndClass(ClassFormat endClass) {
        this.endClass = endClass;
    }

    public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }

    @Override
    public void draw(Graphics g) {
        g.drawString(relationType.toString(),(startX+endX)/2,startY);
        g.drawLine(startX,startY,endX,endY);
    }
}
