package main.generator;
import main.diagrams.UMLClassDiagram;
import main.shapes.ClassFormat;

import java.awt.*;
import java.util.*;
import java.util.List;

public class ArrangeCalculator {
    private UMLClassDiagram diagram;
    public ArrangeCalculator(UMLClassDiagram diagram) {
        this.diagram = diagram;
    }

    public void arrange(){
        int width=diagram.getWidth(),startX=50,offsetX=300,offsetY=300;
        int x=startX,y=50;
        Iterator<Map.Entry<String,ClassFormat>> classFormatIterator=diagram.createClassFormatIterator();
        while(classFormatIterator.hasNext()){
            if(x+offsetX>=width) {
                y += offsetY;
                x=startX;
            }
            ClassFormat format=classFormatIterator.next().getValue();
            format.setLocation(x,y);
            x+=offsetX;
        }
    }

    public void calculateArrange(Point start,Point end){
        ClassFormat startClass=null,endClass=null;
        Iterator<Map.Entry<String,ClassFormat>> classFormatIterator=diagram.createClassFormatIterator();
        while (classFormatIterator.hasNext()){
            ClassFormat classFormat=classFormatIterator.next().getValue();
            if(classFormat.contains(start)){
                startClass=classFormat;
                System.out.println("start:"+startClass.getClassName());
                if(endClass!=null)
                    break;
            }
            else if(classFormat.contains(end)) {
                endClass = classFormat;
                System.out.println("end:"+endClass.getClassName());
                if(startClass!=null)
                    break;
            }
        }

        if(startClass !=null && endClass!=null){
            ClassRelationGenerator relationGenerator=new ClassRelationGenerator();
//            Relation relation=relationGenerator.generateRelation(startClass,endClass, RelationType.Association);
//            relation.setStartX(startClass.x+startClass.width/2);
//            relation.setStartY(startClass.y);
//            relation.setEndX(endClass.x+endClass.width/2);
//            relation.setEndY(endClass.y+endClass.height);
//            diagram.addToDiagram(relation);
        }
    }

    public void moveUnit(Point start , Point end){
        ClassFormat startClass=null;
        Iterator<Map.Entry<String,ClassFormat>> classFormatIterator=diagram.createClassFormatIterator();
        while (classFormatIterator.hasNext()){
            ClassFormat classFormat=classFormatIterator.next().getValue();
            if(classFormat.contains(start)) {
                startClass = classFormat;
                System.out.println("start:" + startClass.getClassName());
            }
        }
        if(startClass!=null) {
            int offsetX = end.x - start.x, offsetY = end.y - start.y;
            int newX=startClass.x+offsetX,newY=startClass.y+offsetY;
            try {
                diagram.setClassFormatLocation(startClass.getClassName(), newX, newY);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public Point solveEquation(Point start,Point end){
        double a=(start.getY()-end.getY())/(start.getX()-end.getX()),b=(end.getY()*start.getX()-start.getY()*end.getX())/(start.getX()-end.getX());
        Point p=new Point();
        p.setLocation(a,b);
        return p;
    }

    public List<Point> getRecContainsPoint(Point equation,ClassFormat classFormat){
        String axis="xyxy";
        int a=equation.x,b=equation.y;
        int[]value={classFormat.x,classFormat.y,classFormat.x+classFormat.width,classFormat.y+classFormat.height};
        List<Point> pointResults=new ArrayList<>();
        for(int i=0;i<axis.length();i++){
            int x=0,y=0;
            if(axis.charAt(i)=='x'){
                x=value[i];
                y=a*x+b;
            }
            else if(axis.charAt(i)=='y'){
                y=value[i];
                x=(y-b)/a;
            }
            pointResults.add(new Point(x,y));
        }
        List<Point> result=new ArrayList<>();
        for(Point p:pointResults) {
            if (classFormat.contains(p))
                result.add(p);
        }
        return pointResults;
    }
}
