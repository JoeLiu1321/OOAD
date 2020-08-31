package output;

import org.junit.Before;
import org.junit.Test;

import base.BaseDiagramTest;
import model.diagrams.UMLClassDiagram;
import model.geometric.ClassFormat;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.junit.After;

public class JsonOutputStrategyTest extends BaseDiagramTest {
    @Before
    public void setUp() {
        super.setUp();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testOutput() {
        OutputStrategy strategy = new JsonOutputStrategy(diagram);
        String jsonOutput = strategy.output();
        JsonParser parser = new JsonParser();
        JsonObject json = (JsonObject) parser.parse(jsonOutput);
        assertOutputContainClassFormat(json, diagram);

    }

    public void assertOutputContainClassFormat(JsonObject diagramJson, UMLClassDiagram diagram) {
        JsonObject classFormats = diagramJson.get("classFormatCollection").getAsJsonObject();
        Iterator<ClassFormat> expectIt = diagram.createClassFormatIterator();
        while (expectIt.hasNext()) {
            ClassFormat expect = expectIt.next();
            JsonElement actual = classFormats.get(expect.getClassName()).getAsJsonObject();
            assertClassFormatAttrEqual(expect, actual);
        }

    }

    public void assertClassFormatAttrEqual(ClassFormat expect, JsonElement actual) {
        JsonObject actualObj = (JsonObject) actual;
        String className = actualObj.get("className").getAsString();
        int x = actualObj.get("x").getAsInt();
        int y = actualObj.get("y").getAsInt();
        assertEquals(expect.getClassName(), className);
        assertEquals(expect.x, x);
        assertEquals(expect.y, y);
    }
}