package listeners;

import model.diagrams.UMLClassDiagram;
import output.ConvertStrategy;
import output.JsonConvertStrategy;
import output.JsonOutputStrategy;
import output.OutputStrategy;

public class JsonListenerHandler extends ListenerHandler {
    public JsonListenerHandler(UMLClassDiagram diagram) {
        super(diagram, ".json");
    }

    @Override
    protected OutputStrategy outputStrategyFactoryMethod(UMLClassDiagram diagram) {
        return new JsonOutputStrategy(diagram);
    }

    @Override
    protected ConvertStrategy convertStrategyFactoryMethod() {
        return new JsonConvertStrategy();
    }

}