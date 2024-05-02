import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

public class Calculadora implements ActionListener{

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] funcoesButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton, negButton; 
    JPanel panel;

    Font fonte = new Font("Verdana", Font.BOLD,30);
    double num1 = 0, num2 = 0, resultado = 0;
    char operador;

    Calculadora(){
        frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.gray);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(fonte);
        textField.setEditable(false);
        textField.setBackground(new Color (211,211,211));
        textField.setForeground(new Color(172,0,191));

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        funcoesButtons[0] = addButton;
        funcoesButtons[1] = subButton;
        funcoesButtons[2] = mulButton;
        funcoesButtons[3] = divButton;
        funcoesButtons[4] = decButton;
        funcoesButtons[5] = equButton;
        funcoesButtons[6] = delButton;
        funcoesButtons[7] = clrButton;
        funcoesButtons[8] = negButton;

        for(int i = 0; i < 9; i++){
            funcoesButtons[i].addActionListener(this);
            funcoesButtons[i].setFont(fonte);
            funcoesButtons[i].setFocusable(false);
            funcoesButtons[i].setBackground(Color.black);
            funcoesButtons[i].setForeground(new Color(172,0,191));
        }

        for(int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(fonte);
            numberButtons[i].setFocusable(false);
            numberButtons[i].addActionListener(this);
            numberButtons[i].setBackground(Color.black);
            numberButtons[i].setForeground(new Color(172,0,191));


        }

        negButton.setBounds(40,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(260,430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        panel.setBackground(Color.gray);
   
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);
        frame.add(textField);
        frame.setVisible(true);
   
    }




    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
    }

    public void actionPerformed(ActionEvent e){
        for(int i = 0; i < 10; i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operador = '+';
            textField.setText("");
        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operador = '-';
            textField.setText("");
        }
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operador = '*';
            textField.setText("");
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operador = '/';
            textField.setText("");
        }
        if(e.getSource() == equButton){
        num2 = Double.parseDouble(textField.getText());
        switch(operador){
        case '+':
            resultado = num1 + num2;
            break;
        case '-':
            resultado = num1 - num2;
            break;  
        case '*':
            resultado = num1 * num2;
            break;       
        case '/':
            resultado = num1 / num2;
            break;       
        }
        textField.setText(String.valueOf(resultado));
        num1 = resultado;
    }
    if(e.getSource() == clrButton){
        textField.setText("");
    }
    if(e.getSource() == delButton){
        String string = textField.getText();
        textField.setText("");
        for(int i = 0; i<string.length()-1; i++){
            textField.setText(textField.getText()+string.charAt(i));
        }
    }
    if(e.getSource() == negButton){
        double aux = Double.parseDouble(textField.getText());
        aux *= -1;
        textField.setText(String.valueOf(aux));
    }


}
}