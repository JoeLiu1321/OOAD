package model.shapes;

public class InterfaceFormat extends ClassFormat {
	public InterfaceFormat(String className, int x, int y, int width, int height) {
		super(className, x, y, width, height);
	}

	@Override
	public void draw(Drawer drawer) {
		drawer.draw(this);
	}
}
