import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RoundedButton extends JButton {
    private int radius;
    private Color hoverColor;
    private Color originalBackground; // Variabile per memorizzare il colore di sfondo originale

    // Aggiungi il parametro hoverColor al costruttore
    public RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;

        setFocusPainted(false);
        setContentAreaFilled(false); // Disabilita la colorazione predefinita
        setBorderPainted(false); // Disabilita il bordo predefinito

        // Salva il colore di sfondo originale
        this.originalBackground = getBackground(); 

        // Abilita l'evento rollover
        setRolloverEnabled(true);
    }

    // Metodo per impostare il colore di hover
    public void setHoverColor(Color hoverColor) {
        this.hoverColor = hoverColor;
        
        // Gestiamo l'evento mouse per cambiare il colore di sfondo quando il cursore è sopra
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverColor); // Colore quando il cursore entra
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(originalBackground); // Torna al colore originale
            }
        });
    }

    // Metodo per impostare il colore di sfondo originale
    public void setOriginalBackground(Color originalBackground) {
        this.originalBackground = originalBackground;
        setBackground(originalBackground); // Imposta il colore di sfondo originale inizialmente
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Impostiamo il colore di sfondo (senza il bordo)
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        g2.dispose();
        super.paintComponent(g); // Chiamata alla funzione della superclasse per disegnare il testo
    }
}
