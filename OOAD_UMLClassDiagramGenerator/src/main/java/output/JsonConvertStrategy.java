package output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import generator.ClassRelationGenerator;
import generator.ClassUnitGenerator;
import model.diagrams.ClassFormatType;
import model.diagrams.RelationType;
import model.diagrams.UMLClassDiagram;
import model.geometric.ClassFormat;
import model.geometric.Relation;

public class JsonConvertStrategy implements ConvertStrategy {

    @Override
    public UMLClassDiagram convert(String[] input) throws Exception {
        StringBuilder builder = new StringBuilder();
        for (String str : input)
            builder.append(str);
        String jsonString = builder.toString();
        JsonParser parser = new JsonParser();
        JsonObject diagramJson = (JsonObject) parser.parse(jsonString);
        return buildDiagram(diagramJson);
    }

    public UMLClassDiagram buildDiagram(JsonObject diagramJson) throws Exception {
        int width = diagramJson.get("width").getAsInt();
        int height = diagramJson.get("height").getAsInt();
        UMLClassDiagram diagram = new UMLClassDiagram(width, height);
        JsonObject classFormats = diagramJson.get("classFormatCollection").getAsJsonObject();
        JsonArray relations = diagramJson.get("relations").getAsJsonArray();
        Iterator<Entry<String, JsonElement>> classFormatIt = classFormats.entrySet().iterator();
        while (classFormatIt.hasNext()) {
            Entry<String, JsonElement> classFormatJson = classFormatIt.next();
            ClassFormat classFormat = buildClassFormat(classFormatJson.getValue().getAsJsonObject());
            diagram.addToDiagram(classFormat);
        }
        Iterator<JsonElement> relationIt = relations.iterator();
        while (relationIt.hasNext()) {
            JsonObject relationJson = relationIt.next().getAsJsonObject();
            JsonObject startClass = relationJson.get("startClass").getAsJsonObject();
            JsonObject endClass = relationJson.get("endClass").getAsJsonObject();
            String startClassName = startClass.get("className").getAsString();
            String endClassName = endClass.get("className").getAsString();
            String relationType = relationJson.get("relationType").getAsString();
            Relation relation = buildRelation(diagram.getClassFormat(startClassName),
                    diagram.getClassFormat(endClassName), relationType);
            int startX = relationJson.get("startX").getAsInt();
            int startY = relationJson.get("startY").getAsInt();
            int endX = relationJson.get("endX").getAsInt();
            int endY = relationJson.get("endY").getAsInt();
            relation.setStartX(startX);
            relation.setStartY(startY);
            relation.setEndX(endX);
            relation.setEndY(endY);
            diagram.addToDiagram(relation);
        }
        return diagram;
    }

    private ClassFormat buildClassFormat(JsonObject classFormatJson) {
        String type = classFormatJson.get("type").getAsString();
        ClassFormatType clsType = ClassFormatType.valueOf(type);
        String className = classFormatJson.get("className").getAsString();
        List<String> methods = getAsList(classFormatJson.get("methods").getAsJsonArray());
        List<String> variables = getAsList(classFormatJson.get("variables").getAsJsonArray());

        ClassUnitGenerator generator = new ClassUnitGenerator(className, methods, variables);
        if (clsType == ClassFormatType.CONCRETE)
            return generator.generateConcreteClassFormat();
        return generator.generateInterfaceClassFormat();
    }

    private Relation buildRelation(ClassFormat startClass, ClassFormat endClass, String relationType) {
        RelationType type = RelationType.valueOf(relationType);
        ClassRelationGenerator generator = new ClassRelationGenerator();
        return generator.generateRelation(startClass, endClass, type);
    }

    private List<String> getAsList(JsonArray array) {
        List<String> listResult = new ArrayList<String>();
        Iterator<JsonElement> it = array.iterator();
        while (it.hasNext()) {
            String data = it.next().getAsString();
            listResult.add(data);
        }
        return listResult;

    }

}