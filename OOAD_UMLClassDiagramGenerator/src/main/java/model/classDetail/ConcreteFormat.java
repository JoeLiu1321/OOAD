package model.classDetail;

public class ConcreteFormat extends ClassFormat {
	public ConcreteFormat(String className, int x, int y, int width, int height) {
		super(className, x, y, width, height);
	}

	@Override
	public void draw(Drawer drawer) {
		drawer.draw(this);
	}
}
