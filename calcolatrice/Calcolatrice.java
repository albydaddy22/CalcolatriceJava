import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Calcolatrice{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    final int ris_h = (int) screenSize.getHeight();
    final int ris_w = (int) screenSize.getWidth();
    final int width = 450;
    final int height = 750;
    public Calcolatrice(){
        Finestra f = new Finestra(ris_w/2-width/2,ris_h/2-height/2,width,height);
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(5,4,10,10));
        String[] pulsanti ={"C", "%", "√", "⌫","7", "8", "9", "/", "4", "5", "6", "*","1", "2", "3", "-", ".", "0", "=", "+"};

        for(String elemento : pulsanti){
            JButton button = new JButton(elemento);
            button.setFont(new Font("DejaVu Sans", Font.BOLD, 30));
            p.add(button);
        }
        
        f.add(p);
    }
    
}