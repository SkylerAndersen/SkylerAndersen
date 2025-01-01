import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

abstract class BevelPanel extends JPanel {
    private Color color;
    private int padding;
    private int rounding;
    private boolean topEnabled;
    private boolean bottomEnabled;
    private boolean hasBorder;
    private int borderPadding;
    private Color borderColor;
    abstract public void setDecorativeBorder (DecorativeBorder border);
    abstract public void setBackground (Color color);
    abstract public Color getColor ();
    abstract public void setRounding (int rounding);
    abstract public void setRoundTop (boolean flag);
    abstract public void setRoundBottom (boolean flag);
    abstract protected void paintComponent (Graphics g);
}