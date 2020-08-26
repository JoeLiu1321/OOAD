package drawer;

import java.awt.Graphics;

import model.classDetail.ClassFormat;

public class InterfaceFormatDrawer extends ClassFormatDrawer {
    public InterfaceFormatDrawer(ClassFormat classFormat) {
        super(classFormat);
    }

    @Override
    protected int drawClassName(Graphics g, int x, int y) {
        int lineHeight = g.getFontMetrics().getHeight();
        g.drawString("<<interface>>", x, y);
        y += lineHeight;
        y = super.drawClassName(g, x, y);
        return y;
    }

    @Override
    protected int drawVariable(Graphics g, int x, int y) {
        y += 2 * g.getFontMetrics().getHeight();
        return y;
    }
}