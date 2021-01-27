package calculator.src;

import javax.swing.*;
import java.awt.*;

public class PersonalizedButton {

    private final JButton button;

    public PersonalizedButton(String placeholder) {
        this.button = new JButton(placeholder);
        this.button.setBorderPainted(true);
        this.button.setForeground(Color.white);
        this.button.setBackground(Color.white);
        this.button.setFocusPainted(false);
        this.button.setContentAreaFilled(false);
        this.button.setSize(100,100);

    }

    public JButton getButton(){
        return this.button;
    }


}
