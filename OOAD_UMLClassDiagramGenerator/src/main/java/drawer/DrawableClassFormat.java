package drawer;

import java.awt.FontMetrics;
import java.awt.Graphics;

import model.shapes.ClassFormat;

public class DrawableClassFormat implements Drawable {
    private ClassFormat classFormat;

    public DrawableClassFormat(ClassFormat classFormat) {
        this.classFormat = classFormat;
    }

    protected int drawVariable(Graphics g, int x, int y) {
        FontMetrics m = g.getFontMetrics();
        int lineHeight = m.getHeight();
        for (String variable : classFormat.getVariables()) {
            y += lineHeight;
            g.drawString(variable, x, y);
        }
        return y;
    }

    protected int drawMethod(Graphics g, int x, int y) {
        FontMetrics m = g.getFontMetrics();
        int lineHeight = m.getHeight();
        for (String method : classFormat.getMethods()) {
            y += lineHeight;
            g.drawString(method, x, y);
        }
        return y;
    }

    protected int drawClassName(Graphics g, int x, int y) {
        g.drawString(classFormat.getClassName(), x, y);
        return y;
    }

    @Override
    public void draw(Graphics g) {
        FontMetrics m = g.getFontMetrics();
        int lineHeight = m.getHeight();
        int width = classFormat.width, height = classFormat.height;
        int x = classFormat.x, y = classFormat.y, padding = 5;

        g.drawRect(x, y, width, height);
        y = drawClassName(g, x + padding, y + lineHeight);
        y += lineHeight;
        g.drawLine(x, y, x + width, y);

        y = drawVariable(g, x + padding, y);

        y += lineHeight;
        g.drawLine(x, y, x + width, y);

        y = drawMethod(g, x + padding, y);
    }
}