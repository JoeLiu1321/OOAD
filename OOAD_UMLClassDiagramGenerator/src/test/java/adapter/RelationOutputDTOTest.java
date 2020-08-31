package adapter;

import model.diagrams.RelationType;
import model.geometric.ClassFormat;
import model.geometric.ConcreteFormat;
import model.geometric.Relation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RelationOutputDTOTest {
    private ClassFormat startClass, endClass;
    private String startClassName = "mainTest", endClassName = "main";
    private RelationType relationType = RelationType.Composition;
    Relation relation;
    private int width = 100;
    private int height = 100;

    @Before
    public void setUp() {
        int x = 0;
        int y = 0;
        startClass = new ConcreteFormat(startClassName, x, y, width, height);
        endClass = new ConcreteFormat(endClassName, x, y, width, height);
        relation = new Relation(startClass, endClass, relationType);
    }

    @Test
    public void getOutput() {
        RelationOutputDTO relationOutputDTO = new RelationOutputDTO(relation);
        assertEquals("StartClass:mainTest;EndClass:main;Type:Composition;StartPoint:0,0;EndPoint:0,0",
                relationOutputDTO.getOutput());
    }
}