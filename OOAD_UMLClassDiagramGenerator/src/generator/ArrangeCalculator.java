package generator;
import diagrams.RelationType;
import diagrams.UMLClassDiagram;
import diagrams.UMLClassDiagramDrawer;
import shapes.ClassFormat;
import shapes.Relation;

import java.awt.*;
import java.util.*;

public class ArrangeCalculator {
    private UMLClassDiagram diagram;
    private UMLClassDiagramDrawer diagramDrawer;
    public ArrangeCalculator(UMLClassDiagram diagram,UMLClassDiagramDrawer diagramDrawer) {
        this.diagram = diagram;
        this.diagramDrawer=diagramDrawer;
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
            Relation relation=relationGenerator.generateRelation(startClass,endClass, RelationType.Association);
            relation.setStartX(startClass.x+startClass.width/2);
            relation.setStartY(startClass.y);
            relation.setEndX(endClass.x+endClass.width/2);
            relation.setEndY(endClass.y+endClass.height);
//            relation.setStartX(start.x);
//            relation.setStartY(start.y);
//            relation.setEndX(end.x);
//            relation.setEndY(end.y);
            diagram.addToDiagram(relation);
            diagramDrawer.drawTask(relation);
        }

    }
}
