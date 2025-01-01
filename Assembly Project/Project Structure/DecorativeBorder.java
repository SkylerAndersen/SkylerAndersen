import java.awt.*;

abstract class DecorativeBorder {
    private Color color;
    private int width;
    public DecorativeBorder () {}
    public DecorativeBorder (Color color) {}

    public DecorativeBorder (Color color, int width) {}

    abstract public Color getColor ();

    abstract public int getWidth ();
}