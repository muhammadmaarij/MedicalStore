package fa20_bcs_060;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlaceOrderGui {
    private JFrame frame;
    private JPanel panel;

    private JLabel orderMed;
    private JLabel medName;
    private JLabel medQuan;

    private JTextField t_medName;
    private JComboBox c_medQuan;

    private JButton clear;
    private JButton place;
    private JButton back;

    public PlaceOrderGui(){

        panel=new JPanel(null);

        frame=new JFrame("Order Medicine");
        panel.setBackground(Color.CYAN);

        orderMed =new JLabel("Order Medicine");
        medName=new JLabel("Medicine Name:");
        medQuan=new JLabel("Medicine Quantity:");

        t_medName=new JTextField();
        String [] s = {"1","2","3","4","5"};

        c_medQuan = new JComboBox(s);
        orderMed.setFont(new Font("Sanserif",Font.BOLD,30));
        medName.setFont(new Font("Sanserif",Font.BOLD,20));
        medQuan.setFont(new Font("Sanserif",Font.BOLD,20));

        orderMed.setForeground(Color.BLACK);//Text color
        medName.setForeground(Color.BLACK);
        medQuan.setForeground(Color.BLACK);

        orderMed.setBounds(190,70,300,60);
        medName.setBounds(120,150,250,30);
        medQuan.setBounds(120,200,250,30);

        t_medName.setBounds(330,150,130,30);
        c_medQuan.setBounds(330,200,130,30);

        t_medName.setBackground(Color.white);
        c_medQuan.setBackground(Color.white);

        place =new JButton("Place Order");

        back=new JButton("Back");

        clear=new JButton("Clear");

        place.setFont(new Font("Sanserif",Font.BOLD,20));
        back.setFont(new Font("Sanserif",Font.BOLD,20));
        clear.setFont(new Font("Sanserif",Font.BOLD,20));

        place.setForeground(Color.BLACK);
        back.setForeground(Color.BLACK);
        clear.setForeground(Color.BLACK);
        place.setBackground(Color.green);
        clear.setBackground(Color.green);
        back.setBackground(Color.green);

        place.setBounds(50,300,150,50);
        back.setBounds(215,300,150,50);
        clear.setBounds(380,300,150,50);

        panel.add(orderMed);
        panel.add(medName);
        panel.add(medQuan);
        panel.add(clear);
        panel.add(back);
        panel.add(t_medName);
        panel.add(place);
        panel.add(c_medQuan);

        frame.add(panel);
        frame.setTitle("Order Medicine");
        frame.setVisible(true);
        frame.setSize(600,450);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        clear.addActionListener(new PlaceOrderGui.OrderMedHandler());
        place.addActionListener(new PlaceOrderGui.OrderMedHandler());
        back.addActionListener(new PlaceOrderGui.OrderMedHandler());

    }
    class OrderMedHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clear) {
                t_medName.setText("");
            }

            if (e.getSource() == place) {
                MedicineOrder order = new PlaceOrder();
                if(((PlaceOrder) order).placeOrd(t_medName.getText(), c_medQuan.getSelectedItem().toString())){
                    JOptionPane.showMessageDialog(null, "Order Placed Successfully");
                    frame.dispose();
                    MainMenuGui mainMenuGui = new MainMenuGui();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Medicine not available");
                }
                t_medName.setText("");
            }
            if (e.getSource() == back) {
                MainMenuGui mainMenuGui = new MainMenuGui();
                frame.dispose();
            }
        }
    }
}
