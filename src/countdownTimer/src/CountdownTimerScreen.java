package countdownTimer.src;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimerScreen {

    private static Duration duration;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("Timer");
            f.setSize(220,180);
            f.setResizable(false);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel(new GridLayout(3,2));
            panel.setBackground(new Color(230, 230, 230));

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }

            f.add(panel);
            f.setVisible(true);

            Countdown countdown = new Countdown();
            JTextField input  = new JTextField(10);
            JButton button    = new JButton("Start Countdown");
            JLabel timerLabel = new JLabel("0:00", SwingConstants.CENTER);

            button.addActionListener(e -> {
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        duration = countdown.getDurationTime(input.getText());
                        System.out.println(duration.getSeconds());
                        timerLabel.setText(String.valueOf(duration.toMinutes() / 60 + ":" + duration.toMinutes() % 60));
                    }
                },0,1000);
            });

            panel.add(input);
            panel.add(button);
            panel.add(timerLabel);
        });

    }
}
