package visitor;

import model.classDetail.*;

public interface Visitor {
    public abstract void visit(ConcreteFormat concreteClass);

    public abstract void visit(InterfaceFormat interfaceClass);

    public abstract void visit(Relation relation);
}