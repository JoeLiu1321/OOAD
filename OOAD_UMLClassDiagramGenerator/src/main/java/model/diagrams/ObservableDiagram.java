package model.diagrams;

import java.util.ArrayList;
import java.util.List;

import model.geometric.ClassFormat;
import model.geometric.Relation;
import observer.Observable;
import observer.Observer;

public class ObservableDiagram extends UMLClassDiagram implements Observable {
    private transient List<Observer> observers;

    public ObservableDiagram() {
        super();
        observers = new ArrayList<>();
    }

    public ObservableDiagram(int width, int height) {
        super(width, height);
        observers = new ArrayList<>();
    }

    @Override
    public void addToDiagram(ClassFormat format) {
        super.addToDiagram(format);
        notifyObservers();
    }

    @Override
    public void addToDiagram(Relation relation) {
        super.addToDiagram(relation);
        notifyObservers();
    }

    @Override
    public void setClassFormatLocation(String className, int x, int y) throws Exception {
        super.setClassFormatLocation(className, x, y);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers)
            observer.update(this);
    }

    @Override
    public void removeClassFormat(ClassFormat classFormat) {
        super.removeClassFormat(classFormat);
        notifyObservers();
    }

    @Override
    public void removeRelation(Relation relation) {
        super.removeRelation(relation);
        notifyObservers();
    }

    @Override
    public void setDiagram(UMLClassDiagram diagram) {
        super.setDiagram(diagram);
        notifyObservers();
    }
}