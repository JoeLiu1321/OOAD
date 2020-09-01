package model.geometric;

import model.diagrams.ClassFormatType;
import visitor.Visitor;

public class ConcreteFormat extends ClassFormat {
	private final ClassFormatType type = ClassFormatType.CONCRETE;

	public ConcreteFormat(String className, int x, int y, int width, int height) {
		super(className, x, y, width, height);
	}

	public ConcreteFormat() {
		super();
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public ClassFormatType getType() {
		return type;
	}
}
