package drawer;

import canvas.Canvas;
import model.geometric.ClassFormat;

public class ClassFormatDrawer implements Drawer {
    private ClassFormat classFormat;

    public ClassFormatDrawer(ClassFormat classFormat) {
        this.classFormat = classFormat;
    }

    protected int drawVariable(Canvas canvas, int x, int y) {
        int lineHeight = canvas.getHeight();
        for (String variable : classFormat.getVariables()) {
            y += lineHeight;
            canvas.drawString(variable, x, y);
        }
        return y;
    }

    protected int drawMethod(Canvas canvas, int x, int y) {
        int lineHeight = canvas.getHeight();
        for (String method : classFormat.getMethods()) {
            y += lineHeight;
            canvas.drawString(method, x, y);
        }
        return y;
    }

    protected int drawClassName(Canvas canvas, int x, int y) {
        canvas.drawString(classFormat.getClassName(), x, y);
        return y;
    }

    @Override
    public void draw(Canvas canvas) {
        int lineHeight = canvas.getHeight();
        int width = classFormat.width, height = classFormat.height;
        int x = classFormat.x, y = classFormat.y, padding = 5;

        canvas.drawRect(x, y, width, height);
        y = drawClassName(canvas, x + padding, y + lineHeight);
        y += lineHeight;
        canvas.drawLine(x, y, x + width, y);

        y = drawVariable(canvas, x + padding, y);

        y += lineHeight;
        canvas.drawLine(x, y, x + width, y);

        y = drawMethod(canvas, x + padding, y);
    }
}