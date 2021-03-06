package model.geometric;

import model.diagrams.RelationType;
import visitor.Visitor;

import java.awt.Point;

public class Relation implements Visitable {
    private ClassFormat startClass, endClass;
    private RelationType relationType;
    private int startX, endX, startY, endY;

    public Relation(ClassFormat startClass, ClassFormat endClass, RelationType relationType) {
        setStartClass(startClass);
        setEndClass(endClass);
        setRelationType(relationType);
        startClass.regisiterRelation(this);
        endClass.regisiterRelation(this);
    }

    public RelationType getRelationType() {
        return relationType;
    }

    public ClassFormat getStartClass() {
        return startClass;
    }

    public ClassFormat getEndClass() {
        return endClass;
    }

    public int getStartX() {
        return startX;
    }

    public int getEndX() {
        return endX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndY() {
        return endY;
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
        setStartX(startClass.x);
        setStartY(startClass.y);
    }

    public void setEndClass(ClassFormat endClass) {
        this.endClass = endClass;
        setEndX(endClass.x);
        setEndY(endClass.y);
    }

    public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }

    public void setRelationType(String relationType) {
        setRelationType(RelationType.valueOf(relationType));
    }

    public boolean contains(Point location) {
        boolean isXContain = (Integer.max(startX, endX) >= location.x && location.x >= Integer.min(startX, endX));
        boolean isYContain = (Integer.max(startY, endY) >= location.y && location.y >= Integer.min(startY, endY));
        return isXContain && isYContain;
    }

    public void update(Object location, ClassFormat classFormat) {
        Point point = (Point) location;
        if (point != null) {
            int offsetX = point.x, offsetY = point.y;
            if (classFormat == startClass) {
                startX += offsetX;
                startY += offsetY;
            } else {
                endX += offsetX;
                endY += offsetY;
            }
        }

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
