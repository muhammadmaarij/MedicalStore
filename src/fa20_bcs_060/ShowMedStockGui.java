package fa20_bcs_060;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowMedStockGui {
    private JFrame frame;
    private JPanel panel;
    private JTextArea area;
    private JButton back;

    public JTextArea getArea(){
        return area;
    }

    public ShowMedStockGui(){

        frame = new JFrame();
        panel = new JPanel(null);
        panel.setBackground(Color.CYAN);

        area = new JTextArea();
        area.setBounds(0, 0, 600, 480);
        area.setBackground(Color.cyan);
        area.setForeground(Color.black);

        back = new JButton("Back");
        back.setBounds(220, 495, 150, 50);
        back.setFont(new Font("Sanserif",Font.BOLD,30));

        panel.add(area);
        panel.add(back);

        frame.add(panel);
        frame.setResizable(false);
        frame.setTitle("View Medicine");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        back.addActionListener(new ShowHandler());

    }
    class ShowHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == back) {
                MainMenuGui mainMenuGui = new MainMenuGui();
                frame.dispose();
            }
        }
    }
}
