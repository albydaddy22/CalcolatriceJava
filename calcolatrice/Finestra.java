import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Finestra extends JFrame{
    public Finestra(int x, int y, int width, int height){
        setLocation(x, y);             
        setSize(width, height);    
        setVisible(true); 
    }
}