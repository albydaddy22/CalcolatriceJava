import javax.swing.*;
import java.awt.*;

public class Calcolatrice {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    final int ris_h = (int) screenSize.getHeight();
    final int ris_w = (int) screenSize.getWidth();
    final int width = 350;
    final int height = 580;

    public Calcolatrice() {
        Finestra f = new Finestra(ris_w / 2 - width / 2, ris_h / 2 - height / 2, width, height);
        
        JPanel all = new JPanel();
        all.setLayout(new BorderLayout());
        
        
        JPanel display = new JPanel();
        JLabel displayLabel = new JLabel("0");
        displayLabel.setFont(new Font("DejaVu Sans", Font.BOLD, 40));
        displayLabel.setForeground(Color.WHITE);
        displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setBackground(new Color(26, 27, 30));
        display.setLayout(new BorderLayout());
        display.add(displayLabel, BorderLayout.CENTER);

        display.setPreferredSize(new Dimension(width, height / 5));

        JPanel calc = new JPanel();
        calc.setBackground(new Color(26, 27, 30));
        calc.setLayout(new GridLayout(5, 4, 10, 10));
        String[] pulsanti = {"C", "%", "√", "⌫", "7", "8", "9", "/", "4", "5", "6", "x", "1", "2", "3", "-", ".", "0", "=", "+"};

        for(String elemento : pulsanti){
            RoundedButton button = new RoundedButton(elemento, 30);
            button.setFont(new Font("DejaVu Sans", Font.BOLD, 30));
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            Color hoverColor;
            Color bg;
            
            if(elemento.equals("=")){
                bg = new Color(232, 23, 23);
                button.setBackground(bg);
                button.setForeground(new Color(0, 0, 0));
                hoverColor = new Color(191, 19, 19);
            }else if(elemento.equals("C") || elemento.equals("%") || elemento.equals("√") || elemento.equals("⌫") || elemento.equals("/") || elemento.equals("x") || elemento.equals("-") || elemento.equals("+")){
                bg = new Color(40, 40, 40);
                button.setBackground(bg);
                button.setForeground(new Color(232, 23, 23));
                hoverColor = new Color(48, 48, 48);
            }
            else{
                bg = new Color(50, 50, 50);
                button.setBackground(bg);
                button.setForeground(new Color(229, 229, 229));
                hoverColor = new Color(40, 40, 40);
            }
            
            button.setOriginalBackground(bg);
            button.setHoverColor(hoverColor);
            calc.add(button);
        }

        calc.setPreferredSize(new Dimension(width, (int) (height * 0.8)));

        all.add(display, BorderLayout.NORTH);
        all.add(calc, BorderLayout.CENTER);

        f.add(all);
    }
}
