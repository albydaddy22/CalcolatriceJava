import javax.swing.*;
import java.awt.*;
import javax.swing.border.MatteBorder;
import java.awt.event.*;
import java.util.ArrayList;

public class Calcolatrice extends JFrame implements ActionListener{
    Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
    final int ris_h=(int)screenSize.getHeight();
    final int ris_w=(int)screenSize.getWidth();
    final int width=350;
    final int height=580;

    private JLabel displayLabel;
    private ArrayList<String> lista=new ArrayList<>();
    private String numeroCorrente="";

    public Calcolatrice(){
        Finestra f=new Finestra(ris_w/2-width/2,ris_h/2-height/2,width,height);
        JPanel all=new JPanel();
        all.setLayout(new BorderLayout());
        all.setBorder(new MatteBorder(12,12,12,12,new Color(26,27,30)));
        Color bg=new Color(26,27,30);
        JPanel tipo=new JPanel();
        tipo.setBackground(bg);
        tipo.setPreferredSize(new Dimension(width,height/20));
        displayLabel=new JLabel("0");
        displayLabel.setFont(new Font("DejaVu Sans",Font.BOLD,40));
        displayLabel.setForeground(Color.WHITE);
        displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JPanel display=new JPanel();
        display.setBackground(bg);
        display.setLayout(new BorderLayout());
        display.add(displayLabel,BorderLayout.CENTER);
        display.setPreferredSize(new Dimension(width,height/5));
        JPanel calc=new JPanel();
        calc.setBackground(bg);
        calc.setLayout(new GridLayout(5,4,10,10));
        
        
        String[] pulsanti={"C","%","√","⌫","7","8","9","/","4","5","6","x","1","2","3","-",".","0","=","+"};
        
        
        for(String elemento:pulsanti){
            RoundedButton button=new RoundedButton(elemento,30);
            button.setFont(new Font("DejaVu Sans",Font.BOLD,25));
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.addActionListener(this);
            Color hoverColor;
            Color cbg;
            if(elemento.equals("=")){
                cbg=new Color(232,23,23);
                button.setBackground(cbg);
                button.setForeground(new Color(0,0,0));
                hoverColor=new Color(191,19,19);
            }else if(elemento.equals("C")||elemento.equals("%")||elemento.equals("√")||elemento.equals("⌫")||elemento.equals("/")||elemento.equals("x")||elemento.equals("-")||elemento.equals("+")){
                cbg=new Color(40,40,40);
                button.setBackground(cbg);
                button.setForeground(new Color(232,23,23));
                hoverColor=new Color(48,48,48);
            }else{
                cbg=new Color(50,50,50);
                button.setBackground(cbg);
                button.setForeground(new Color(229,229,229));
                hoverColor=new Color(40,40,40);
            }
            button.setOriginalBackground(cbg);
            button.setHoverColor(hoverColor);
            calc.add(button);
        }
        
        
        calc.setPreferredSize(new Dimension(width,(int)(height*0.65)));
        all.add(tipo,BorderLayout.NORTH);
        all.add(display,BorderLayout.CENTER);
        all.add(calc,BorderLayout.SOUTH);
        f.add(all);
    }

    public void actionPerformed(ActionEvent e){
        String comando=e.getActionCommand();
        switch(comando){
            case "C":
                lista.clear();
                numeroCorrente="";
                displayLabel.setText("0");
                break;
            case "=":
                if(!numeroCorrente.isEmpty()){
                    lista.add(numeroCorrente);
                }
                double risultato=calcolaRisultato();
                displayLabel.setText(String.valueOf(risultato));
                lista.clear();
                numeroCorrente=String.valueOf(risultato);
                break;
            case "+":
            case "-":
            case "/":
            case "x":
                if(!numeroCorrente.isEmpty()){
                    lista.add(numeroCorrente);
                }
                lista.add(comando.equals("x")?"*":comando);
                numeroCorrente="";
                displayLabel.setText(displayLabel.getText()+comando);
                break;
            case "⌫":
                if(!numeroCorrente.isEmpty()){
                    numeroCorrente=numeroCorrente.substring(0,numeroCorrente.length()-1);
                    displayLabel.setText(displayLabel.getText().substring(0,displayLabel.getText().length()-1));
                }
                break;
            case "%":
                if(!numeroCorrente.isEmpty()){
                    double numero=Double.parseDouble(numeroCorrente)/100;
                    numeroCorrente=String.valueOf(numero);
                    displayLabel.setText(numeroCorrente);
                }
                break;
            case "√":
                if(!numeroCorrente.isEmpty()){
                    double numero=Math.sqrt(Double.parseDouble(numeroCorrente));
                    numeroCorrente=String.valueOf(numero);
                    displayLabel.setText(numeroCorrente);
                }
                break;
            default:
                numeroCorrente+=comando;
                displayLabel.setText(numeroCorrente);
                break;
        }
    }

    private double calcolaRisultato(){
        ArrayList<String> temp=new ArrayList<>(lista);
        for(int i=0;i<temp.size();i++){
            if(temp.get(i).equals("*")||temp.get(i).equals("/")){
                double a=Double.parseDouble(temp.get(i-1));
                double b=Double.parseDouble(temp.get(i+1));
                double risultato=temp.get(i).equals("*")?a*b:a/b;
                temp.set(i-1,String.valueOf(risultato));
                temp.remove(i);
                temp.remove(i);
                i--;
            }
        }
        
        double risultato=Double.parseDouble(temp.get(0));
        for(int i=1;i<temp.size();i+=2){
            double numero=Double.parseDouble(temp.get(i+1));
            if(temp.get(i).equals("+")){
                risultato+=numero;
            }else if(temp.get(i).equals("-")){
                risultato-=numero;
            }
        }
        return risultato;
    }
}
