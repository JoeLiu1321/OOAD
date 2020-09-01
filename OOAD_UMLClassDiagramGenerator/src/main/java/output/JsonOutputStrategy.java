package output;

import com.google.gson.Gson;

import model.diagrams.UMLClassDiagram;

public class JsonOutputStrategy implements OutputStrategy {
    private UMLClassDiagram diagram;

    public JsonOutputStrategy(UMLClassDiagram diagram) {
        this.diagram = diagram;
    }

    @Override
    public String output() {
        Gson g = new Gson();
        return g.toJson(diagram);
    }

}