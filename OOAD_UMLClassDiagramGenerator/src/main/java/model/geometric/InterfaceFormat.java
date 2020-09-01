package model.geometric;

import model.diagrams.ClassFormatType;
import visitor.Visitor;

public class InterfaceFormat extends ClassFormat {
	private final ClassFormatType type = ClassFormatType.INTERFACE;

	public InterfaceFormat(String className, int x, int y, int width, int height) {
		super(className, x, y, width, height);
	}

	public InterfaceFormat() {
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
