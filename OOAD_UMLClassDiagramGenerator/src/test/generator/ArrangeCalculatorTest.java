package test.generator;

import main.diagrams.UMLClassDiagram;
import main.generator.ArrangeCalculator;
import main.shapes.ClassFormat;
import main.shapes.ConcreteFormat;
import org.junit.Test;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ArrangeCalculatorTest {

    @Test
    public void arrange() {
    }

    @Test
    public void calculateArrange() {
    }

    @Test
    public void moveUnit() {
    }

    @Test
    public void equation(){
        UMLClassDiagram classDiagram=new UMLClassDiagram(500,500);
        ClassFormat startClass=new ConcreteFormat("StartClass",10,10,100,100);
        ClassFormat  endClass=new ConcreteFormat("EndClass",190,430,100,100);
        classDiagram.addToDiagram(startClass);
        classDiagram.addToDiagram(endClass);
        ArrangeCalculator arrangeCalculator=new ArrangeCalculator(classDiagram);
        Point start=new Point(60,60),end=new Point(240,480);
        Point slopeAndOffset=arrangeCalculator.solveEquation(start,end);
        assertEquals(2,slopeAndOffset.x);
        assertEquals(-80,slopeAndOffset.y);
        List<Point>startClassResult=arrangeCalculator.getRecContainsPoint(slopeAndOffset,startClass);
        for(Point p:startClassResult)
            System.out.println(p);
        System.out.println(startClass.getX());
        System.out.println(startClass.getY());
        System.out.println(startClass.getHeight());
        System.out.println(startClass.getWidth());
        assertEquals(startClass.contains(startClassResult.get(0)),false);
        assertEquals(startClass.contains(startClassResult.get(1)),true);
        assertEquals(startClass.contains(startClassResult.get(2)),false);
        assertEquals(startClass.contains(startClassResult.get(3)),true);

//        assertEquals(startClassResult.get(2),new Point(110,110));
//        assertEquals(startClassResult.get(3),new Point(110,110));


    }
}