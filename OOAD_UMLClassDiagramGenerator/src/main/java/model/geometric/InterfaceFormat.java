package model.geometric;

import visitor.Visitor;

public class InterfaceFormat extends ClassFormat {
	public InterfaceFormat(String className, int x, int y, int width, int height) {
		super(className, x, y, width, height);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
