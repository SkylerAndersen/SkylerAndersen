import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

abstract class ScreenPanel extends JPanel {
    int originX;
    int originY;
    public ScreenPanel () {}
    abstract public void setLayout (LayoutManager manager);
    abstract public Component add (Component component);
    abstract protected void paintComponent (Graphics g);
    abstract public void update ();
    abstract public int getScreenWidth ();
    abstract public int getScreenHeight ();
}