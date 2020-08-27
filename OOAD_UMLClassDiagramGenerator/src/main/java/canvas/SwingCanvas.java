package canvas;

import java.awt.FontMetrics;
import java.awt.Graphics;

public class SwingCanvas extends Canvas {
    private Graphics graph;

    public SwingCanvas(Graphics graph) {
        this.graph = graph;
    }

    @Override
    public void drawString(String string, int x, int y) {
        graph.drawString(string, x, y);

    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        graph.drawLine(x1, y1, x2, y2);

    }

    @Override
    public void drawRect(int x, int y, int width, int height) {
        graph.drawRect(x, y, width, height);
    }

    @Override
    public int getHeight() {
        FontMetrics m = graph.getFontMetrics();
        return m.getHeight();
    }

}