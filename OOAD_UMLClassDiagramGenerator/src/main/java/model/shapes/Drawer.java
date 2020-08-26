package model.shapes;

public interface Drawer {
    public abstract void draw(ConcreteFormat concreteClass);

    public abstract void draw(InterfaceFormat interfaceClass);

    public abstract void draw(Relation relation);
}