package output;

import model.diagrams.UMLClassDiagram;
import model.geometric.Relation;

import org.junit.Before;
import org.junit.Test;

import base.BaseDiagramTest;

import static org.junit.Assert.assertEquals;

public class DiagramWriterTest extends BaseDiagramTest {
    protected String userDir = System.getProperty("user.dir");

    @Before
    public void setUp() {
        super.setUp();
    }

    public void testWrite(OutputStrategy outputStrategy, ConvertStrategy convertStrategy, String path)
            throws Exception {
        DiagramWriter diagramWriter = new DiagramWriter(outputStrategy);
        diagramWriter.write(path);
        DiagramReader diagramReader = new DiagramReader(convertStrategy);
        UMLClassDiagram newDiagram = diagramReader.read(path);
        assertEquals(diagram.getClassFormat("main"), newDiagram.getClassFormat("main"));
        assertEquals(diagram.getClassFormat("main").getMethods(), newDiagram.getClassFormat("main").getMethods());
        Relation expect = diagram.createRelationIterator().next(), actual = newDiagram.createRelationIterator().next();
        assertEquals(expect.getStartX(), actual.getStartX());
    }

    @Test
    public void testWriteWithText() throws Exception {
        String path = userDir + "/tmp.diagram";
        OutputStrategy outputStrategy = new TextOutputStrategy(diagram);
        ConvertStrategy convertStrategy = new TextConvertStrategy();
        testWrite(outputStrategy, convertStrategy, path);
    }

    @Test
    public void testWriteWithJson() throws Exception {
        String path = userDir + "/tmp.json";
        OutputStrategy outputStrategy = new JsonOutputStrategy(diagram);
        ConvertStrategy convertStrategy = new JsonConvertStrategy();
        testWrite(outputStrategy, convertStrategy, path);

    }
}