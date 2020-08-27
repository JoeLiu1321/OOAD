package drawer;

import canvas.Canvas;
import model.geometric.ClassFormat;

public class InterfaceFormatDrawer extends ClassFormatDrawer {
    public InterfaceFormatDrawer(ClassFormat classFormat) {
        super(classFormat);
    }

    @Override
    protected int drawClassName(Canvas canvas, int x, int y) {
        int lineHeight = canvas.getHeight();
        canvas.drawString("<<interface>>", x, y);
        y += lineHeight;
        y = super.drawClassName(canvas, x, y);
        return y;
    }

    @Override
    protected int drawVariable(Canvas canvas, int x, int y) {
        y += 2 * canvas.getHeight();
        return y;
    }
}