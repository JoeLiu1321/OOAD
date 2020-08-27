package canvas;

public abstract class Canvas {
    public abstract void drawString(String string, int x, int y);

    public abstract void drawLine(int x1, int y1, int x2, int y2);

    public abstract void drawRect(int x, int y, int width, int height);

    public abstract int getHeight();
}