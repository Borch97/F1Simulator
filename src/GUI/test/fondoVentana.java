package GUI.test;


import java.awt.*;
import javax.swing.*;

public class fondoVentana extends  JPanel{

    protected Color color;

    public fondoVentana(Color color) {
        this.color = color;

    }
    public void paint (Graphics g) {
        super.paint(g);
        g.setColor(color);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
    public fondoVentana(){}


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
