import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RoundedButton extends JButton {
    private int radius;
    private Color hoverColor;
    private Color originalBackground;

    public RoundedButton(String text, int radius){
        super(text);
        this.radius = radius;

        setContentAreaFilled(false);
        setBorderPainted(false);

        this.originalBackground = getBackground(); 

        setRolloverEnabled(true);
    }

    public void setHoverColor(Color hoverColor) {
        this.hoverColor = hoverColor;
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e){
                setBackground(originalBackground);
            }
        });
    }
    
    public void setOriginalBackground(Color originalBackground) {
        this.originalBackground = originalBackground;
        setBackground(originalBackground);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        g2.dispose();
        super.paintComponent(g);
    }
}
