import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

abstract public class DynamicLookManager extends ComponentAdapter {
    private IDERequirements parent;
    private JFrame frame;
    private JPanel buttonPanel;
    private JPanel editorPanel;
    private JPanel terminalPanel;
    private JPanel stackPanel;
    private JPanel registerPanel;
    private JPanel screenPanel;
    private JPanel column1;
    private JPanel column2;
    private JPanel column3;
    private JPanel registerData;
    private boolean smallMode;
    private ScreenPanel screen;
    private boolean buttonsAvailable;
    private JTextArea codeArea;
    public DynamicLookManager(IDERequirements parent, JFrame frame) {}

    abstract public String getCodeText ();

    abstract public String getTerminalText ();

    abstract public String getStackText ();

    abstract public int getRegisterValue (int number);

    abstract void styleComponents();

    abstract public void drawOnScreen (BufferedImage bufferedImage);

    abstract public Dimension getScreenSize ();

    abstract public void changeRegisterValue (int number, int value);

    abstract public void changeStack (String text);

    abstract public void changeTerminal (String text);

    abstract void styleScreenPanel ();

    abstract void styleRegisterPanel ();

    abstract void styleStackPanel ();

    abstract void styleTerminalPanel ();

    abstract void styleEditorPanel ();

    abstract void styleButtonPanel ();

    abstract void buttonPressed (BevelPanel panel, JLabel label, String name);

    abstract void createComponents ();

    abstract void updateGraphics ();

    abstract void removeGraphicComponents ();

    abstract void placeGraphicalElements ();

    abstract public void componentResized(ComponentEvent e);
}