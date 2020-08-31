package output;

import model.diagrams.UMLClassDiagram;
import org.junit.Before;
import org.junit.Test;

import base.BaseDiagramTest;

import static org.junit.Assert.assertEquals;

public class DiagramWriterTest extends BaseDiagramTest {

    @Before
    public void setUp() {
        super.setUp();
    }

    public void testWrite(OutputStrategy outputStrategy, ConvertStrategy convertStrategy) throws Exception {
        String path = System.getProperty("user.dir") + "/tmp.diagram";
        DiagramWriter diagramWriter = new DiagramWriter(outputStrategy);
        diagramWriter.write(path);
        DiagramReader diagramReader = new DiagramReader(convertStrategy);
        UMLClassDiagram newDiagram = diagramReader.read(path);
        assertEquals(diagram.getClassFormat("main"), newDiagram.getClassFormat("main"));
        assertEquals(diagram.getClassFormat("main").getMethods(), newDiagram.getClassFormat("main").getMethods());
    }

    @Test
    public void testWriteWithText() throws Exception {
        OutputStrategy outputStrategy = new TextOutputStrategy(diagram);
        ConvertStrategy convertStrategy = new TextConvertStrategy();
        testWrite(outputStrategy, convertStrategy);
    }

    @Test
    public void testWriteWithJson() throws Exception {
        OutputStrategy outputStrategy = new JsonOutputStrategy(diagram);
        ConvertStrategy convertStrategy = new JsonConvertStrategy();
        testWrite(outputStrategy, convertStrategy);
    }
}