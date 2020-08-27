package visitor;

import canvas.Canvas;
import drawer.ClassFormatDrawer;
import drawer.InterfaceFormatDrawer;
import drawer.RelationDrawer;
import model.geometric.ConcreteFormat;
import model.geometric.InterfaceFormat;
import model.geometric.Relation;

public class DrawVisitor implements Visitor {
    private Canvas canvas;

    public DrawVisitor(Canvas canvas) {
        setCanvas(canvas);
    }

    @Override
    public void visit(ConcreteFormat concreteClass) {
        new ClassFormatDrawer(concreteClass).draw(canvas);
    }

    @Override
    public void visit(InterfaceFormat interfaceClass) {
        new InterfaceFormatDrawer(interfaceClass).draw(canvas);
    }

    @Override
    public void visit(Relation relation) {
        new RelationDrawer(relation).draw(canvas);
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

}