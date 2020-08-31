package base;

import model.diagrams.RelationType;
import model.diagrams.UMLClassDiagram;
import model.geometric.ClassFormat;
import model.geometric.Relation;
import generator.ClassRelationGenerator;
import generator.ClassUnitGenerator;
import org.junit.Before;

import java.util.Arrays;

public class BaseDiagramTest {
    protected UMLClassDiagram diagram;
    protected final String[] methods = { "testMethod()", "main()" }, variables = { "int tag", "String name" };
    protected final String startClassName = "main", endClassName = "UMLClassDiagram";
    protected ClassFormat startClass, endClass;
    protected Relation relation;
    protected final int width = 500, height = 500;

    @Before
    public void setUp() {
        diagram = new UMLClassDiagram(width, height);
        ClassUnitGenerator classUnitGenerator = new ClassUnitGenerator();
        ClassRelationGenerator classRelationGenerator = new ClassRelationGenerator();
        classUnitGenerator.setClassAttributes(startClassName, Arrays.asList(methods), Arrays.asList(variables));
        startClass = classUnitGenerator.generateConcreteClassFormat();
        classUnitGenerator.setClassAttributes(endClassName, Arrays.asList(methods), Arrays.asList(variables));
        endClass = classUnitGenerator.generateConcreteClassFormat();
        relation = classRelationGenerator.generateRelation(startClass, endClass, RelationType.Association);
        diagram.addToDiagram(startClass);
        diagram.addToDiagram(endClass);
        diagram.addToDiagram(relation);
    }
}