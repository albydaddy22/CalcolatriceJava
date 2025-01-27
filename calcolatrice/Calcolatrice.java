import javax.swing.*;
import java.awt.*;
import javax.swing.border.MatteBorder;

public class Calcolatrice{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    final int ris_h = (int) screenSize.getHeight();
    final int ris_w = (int) screenSize.getWidth();
    final int width = 350;
    final int height = 580;

    public Calcolatrice(){
        Finestra f = new Finestra(ris_w / 2 - width / 2, ris_h / 2 - height / 2, width, height);
        
        JPanel all = new JPanel();
        all.setLayout(new BorderLayout());
        all.setBorder(new MatteBorder(12, 12, 12, 12, new Color(26, 27, 30)));
        
        Color bg = new Color(26, 27, 30);
        
        JPanel tipo = new JPanel();
        Color tHover = new Color(55, 55, 60);
        RoundedButton normale = new RoundedButton("Basic", 25);
        normale.setBackground(bg);
        normale.setForeground(Color.WHITE);
        normale.setBorderPainted(false);
        normale.setFocusPainted(false);
        normale.setOriginalBackground(bg);
        normale.setHoverColor(tHover);
        normale.setFont(new Font("DejaVu Sans", Font.BOLD, 15));
        
        RoundedButton programmatore = new RoundedButton("Coder", 25);
        programmatore.setBackground(bg);
        programmatore.setForeground(Color.WHITE);
        programmatore.setBorderPainted(false);
        programmatore.setFocusPainted(false);
        programmatore.setOriginalBackground(bg);
        programmatore.setHoverColor(tHover);
        programmatore.setFont(new Font("DejaVu Sans", Font.BOLD, 15));
        tipo.setBackground(bg);
        tipo.setLayout(new BorderLayout());
        tipo.add(normale, BorderLayout.WEST);
        tipo.add(programmatore, BorderLayout.EAST);
        tipo.setPreferredSize(new Dimension(width, height / 20));
        
        JPanel display = new JPanel();
        JLabel displayLabel = new JLabel("0");
        displayLabel.setFont(new Font("DejaVu Sans", Font.BOLD, 40));
        displayLabel.setForeground(Color.WHITE);
        displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setBackground(bg);
        display.setLayout(new BorderLayout());
        display.add(displayLabel, BorderLayout.CENTER);
        display.setPreferredSize(new Dimension(width, height / 5));

        JPanel calc = new JPanel();
        calc.setBackground(bg);
        calc.setLayout(new GridLayout(5, 4, 10, 10));
        String[] pulsanti = {"C", "%", "√", "⌫", "7", "8", "9", "/", "4", "5", "6", "x", "1", "2", "3", "-", ".", "0", "=", "+"};
        
        
        for(String elemento : pulsanti){
            RoundedButton button = new RoundedButton(elemento, 30);
            button.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            Color hoverColor;
            Color cbg;
            
            if(elemento.equals("=")){
                cbg = new Color(232, 23, 23);
                button.setBackground(cbg);
                button.setForeground(new Color(0, 0, 0));
                hoverColor = new Color(191, 19, 19);
            }else if(elemento.equals("C") || elemento.equals("%") || elemento.equals("√") || elemento.equals("⌫") || elemento.equals("/") || elemento.equals("x") || elemento.equals("-") || elemento.equals("+")){
                cbg = new Color(40, 40, 40);
                button.setBackground(cbg);
                button.setForeground(new Color(232, 23, 23));
                hoverColor = new Color(48, 48, 48);
            }
            else{
                cbg = new Color(50, 50, 50);
                button.setBackground(cbg);
                button.setForeground(new Color(229, 229, 229));
                hoverColor = new Color(40, 40, 40);
            }
            
            button.setOriginalBackground(cbg);
            button.setHoverColor(hoverColor);
            calc.add(button);
        }

        calc.setPreferredSize(new Dimension(width, (int) (height * 0.65)));

        all.add(tipo, BorderLayout.NORTH);
        all.add(display, BorderLayout.CENTER);
        all.add(calc, BorderLayout.SOUTH);

        f.add(all);
        
    }
}
