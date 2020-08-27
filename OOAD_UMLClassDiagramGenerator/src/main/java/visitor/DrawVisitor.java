package visitor;

import java.awt.Graphics;

import drawer.ClassFormatDrawer;
import drawer.InterfaceFormatDrawer;
import drawer.RelationDrawer;
import model.geometric.ConcreteFormat;
import model.geometric.InterfaceFormat;
import model.geometric.Relation;

public class DrawVisitor implements Visitor {
    private Graphics graph;

    public DrawVisitor(Graphics graph) {
        this.graph = graph;
    }

    public void setGraph(Graphics graph) {
        this.graph = graph;
    }

    @Override
    public void visit(ConcreteFormat concreteClass) {
        new ClassFormatDrawer(concreteClass).draw(this.graph);
    }

    @Override
    public void visit(InterfaceFormat interfaceClass) {
        new InterfaceFormatDrawer(interfaceClass).draw(this.graph);
    }

    @Override
    public void visit(Relation relation) {
        new RelationDrawer(relation).draw(this.graph);
    }

}