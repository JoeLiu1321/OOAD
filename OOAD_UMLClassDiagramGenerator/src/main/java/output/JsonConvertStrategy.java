package output;

import java.util.Iterator;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import generator.ClassRelationGenerator;
import model.diagrams.ClassFormatType;
import model.diagrams.RelationType;
import model.diagrams.UMLClassDiagram;
import model.geometric.ClassFormat;
import model.geometric.ConcreteFormat;
import model.geometric.InterfaceFormat;
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
            Relation relation = buildRelation(relationJson);
            diagram.addToDiagram(relation);
        }
        return diagram;
    }

    private ClassFormat buildClassFormat(JsonObject classFormatJson) {
        Gson g = new Gson();
        String type = classFormatJson.get("type").getAsString();
        ClassFormatType clsType = ClassFormatType.valueOf(type);
        if (clsType == ClassFormatType.CONCRETE)
            return g.fromJson(classFormatJson, ConcreteFormat.class);
        return g.fromJson(classFormatJson, InterfaceFormat.class);
    }

    private Relation buildRelation(ClassFormat startClass, ClassFormat endClass, String relationType) {
        RelationType type = RelationType.valueOf(relationType);
        ClassRelationGenerator generator = new ClassRelationGenerator();
        return generator.generateRelation(startClass, endClass, type);
    }

    private Relation buildRelation(JsonObject relationJson) {
        JsonObject startClassJson = relationJson.get("startClass").getAsJsonObject();
        JsonObject endClassJson = relationJson.get("endClass").getAsJsonObject();
        ClassFormat startClass = buildClassFormat(startClassJson), endClass = buildClassFormat(endClassJson);
        String relationType = relationJson.get("relationType").getAsString();
        Relation relation = buildRelation(startClass, endClass, relationType);
        int startX = relationJson.get("startX").getAsInt();
        int startY = relationJson.get("startY").getAsInt();
        int endX = relationJson.get("endX").getAsInt();
        int endY = relationJson.get("endY").getAsInt();
        relation.setStartX(startX);
        relation.setStartY(startY);
        relation.setEndX(endX);
        relation.setEndY(endY);
        return relation;
    }

}