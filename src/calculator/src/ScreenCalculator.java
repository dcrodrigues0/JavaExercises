package calculator.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;

public class ScreenCalculator {

    public static JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bSUM, bSUB, bDIV, bMUL, bPOW, bEQUAL, bDEL;
    public static String inputString = "";
    public static TextField input;


    @SuppressWarnings("SameParameterValue")
    private static TextField createTextField(int columns, Boolean isEditable){
        TextField l = new TextField(columns);
        l.setEditable(isEditable);
        l.setSize(500,100);
        l.setBackground(Color.white);

        return l;
    }

    private static List<JButton> createListOfButtons(){
        b0 = new PersonalizedButton("0").getButton();
        b1 = new PersonalizedButton("1").getButton();
        b2 = new PersonalizedButton("2").getButton();
        b3 = new PersonalizedButton("3").getButton();
        b4 = new PersonalizedButton("4").getButton();
        b5 = new PersonalizedButton("5").getButton();
        b6 = new PersonalizedButton("6").getButton();
        b7 = new PersonalizedButton("7").getButton();
        b8 = new PersonalizedButton("8").getButton();
        b9 = new PersonalizedButton("9").getButton();
        //Opertors
        bSUM = new PersonalizedButton("+").getButton();
        bSUB = new PersonalizedButton("-").getButton();
        bDIV = new PersonalizedButton("/").getButton();
        bMUL = new PersonalizedButton("*").getButton();
        bPOW = new PersonalizedButton("^").getButton();
        bEQUAL = new PersonalizedButton("=").getButton();
        bDEL = new PersonalizedButton("DEL").getButton();

        return Arrays.asList(b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bSUM,bSUB,bDIV,bMUL,bPOW,bEQUAL,bDEL);
    }

    public static double calculateResult(String mathOperation){
        Calculator calculator = new Calculator();
        return calculator.getResult(mathOperation);
    }

    public static void clearInput(){
        inputString = "";
        input.setText("");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("calculator");
            f.setSize(250,220);
            f.setResizable(false);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setBackground(new Color(43, 43, 42));

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }

            f.add(panel);
            f.setVisible(true);

            List<JButton> buttons = createListOfButtons();
            input = createTextField(25, false);

            input.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    Character character = e.getKeyChar();
                    if(character.equals('=')){
                        double value = calculateResult(inputString);
                        clearInput();
                        input.setText(""+value);
                    }else{
                        inputString += character;
                    }

                    if(character == KeyEvent.VK_BACK_SPACE){
                        clearInput();
                    }
                }
            });

            panel.add(input);

            buttons.forEach(button -> {

                button.addActionListener(e -> {
                    if(button.getText().equals("=")){
                        double value = calculateResult(inputString);
                        clearInput();
                        input.setText(""+value);
                    }else{
                        inputString += button.getText();
                        input.setText(inputString);
                    }

                    if(button.getText().equals("DEL")){
                        clearInput();
                    }
                });

                button.addMouseListener(new MouseAdapter() {
                    public void mouseEntered(MouseEvent evt) {
                        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    }

                    public void mouseExited(MouseEvent evt) {
                        panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }
                });

                panel.add(button);
            });

        });


    }
}
