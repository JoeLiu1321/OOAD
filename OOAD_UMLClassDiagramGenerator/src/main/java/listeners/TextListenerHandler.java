package listeners;

import model.diagrams.UMLClassDiagram;
import output.ConvertStrategy;
import output.OutputStrategy;
import output.TextConvertStrategy;
import output.TextOutputStrategy;

public class TextListenerHandler extends ListenerHandler {
    public TextListenerHandler(UMLClassDiagram diagram) {
        super(diagram, ".diagram");
    }

    @Override
    protected OutputStrategy outputStrategyFactoryMethod(UMLClassDiagram diagram) {
        return new TextOutputStrategy(diagram);
    }

    @Override
    protected ConvertStrategy convertStrategyFactoryMethod() {
        return new TextConvertStrategy();
    }
}