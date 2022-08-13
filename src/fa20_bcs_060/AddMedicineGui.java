package fa20_bcs_060;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMedicineGui extends MedicineWriter {
    private JFrame frame;
    private JPanel panel;

    private JLabel addMed;
    private JLabel medName;
    private JLabel medQuan;
    private JLabel medPri;

    private JTextField t_medName;
    private JTextField t_medQuan;
    private JTextField t_medPri;

    private JButton clear;
    private JButton add;
    private JButton back;

    public AddMedicineGui(){

        panel=new JPanel(null);

        frame=new JFrame("Add Medicine");
        panel.setBackground(Color.CYAN);

        addMed=new JLabel("Add Medicine");
        medName=new JLabel("Medicine Name:");
        medQuan=new JLabel("Medicine Quantity:");
        medPri=new JLabel("Medicine Price:");

        t_medName=new JTextField();
        t_medQuan=new JTextField();
        t_medPri=new JTextField();

        addMed.setFont(new Font("Sanserif",Font.BOLD,30));
        medName.setFont(new Font("Sanserif",Font.BOLD,20));
        medQuan.setFont(new Font("Sanserif",Font.BOLD,20));
        medPri.setFont(new Font("Sanserif",Font.BOLD,20));

        addMed.setForeground(Color.BLACK);//Text color
        medName.setForeground(Color.BLACK);
        medQuan.setForeground(Color.BLACK);
        medPri.setForeground(Color.BLACK);

        addMed.setBounds(190,70,200,60);
        medName.setBounds(120,150,250,30);
        medQuan.setBounds(120,200,250,30);
        medPri.setBounds(120,250,250,30);

        t_medName.setBounds(330,150,130,30);
        t_medQuan.setBounds(330,200,130,30);
        t_medPri.setBounds(330,250,130,30);

        t_medName.setBackground(Color.white);
        t_medQuan.setBackground(Color.white);
        t_medPri.setBackground(Color.white);

        add=new JButton("Add");

        back=new JButton("Back");

        clear=new JButton("Clear");

        add.setFont(new Font("Sanserif",Font.BOLD,20));
        back.setFont(new Font("Sanserif",Font.BOLD,20));
        clear.setFont(new Font("Sanserif",Font.BOLD,20));

        add.setForeground(Color.BLACK);
        back.setForeground(Color.BLACK);
        clear.setForeground(Color.BLACK);
        add.setBackground(Color.green);
        clear.setBackground(Color.green);
        back.setBackground(Color.green);

        add.setBounds(50,400,150,50);
        back.setBounds(215,400,150,50);
        clear.setBounds(380,400,150,50);

        panel.add(addMed);
        panel.add(medName);
        panel.add(medQuan);
        panel.add(medPri);
        panel.add(clear);
        panel.add(back);
        panel.add(t_medName);
        panel.add(t_medPri);
        panel.add(t_medQuan);
        panel.add(add);

        frame.add(panel);
        frame.setTitle("Add Medicine");
        frame.setVisible(true);
        frame.setSize(600,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        clear.addActionListener(new AddMedicineGui.AddMedHandler());
        add.addActionListener(new AddMedicineGui.AddMedHandler());
        back.addActionListener(new AddMedicineGui.AddMedHandler());

    }
    class AddMedHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==clear){
                t_medName.setText("");
                t_medQuan.setText("");
                t_medPri.setText("");
            }

            if(e.getSource()==add){
                if (t_medName.getText().equals("") || t_medQuan.getText().equals("") || t_medPri.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter all details");
                    t_medName.setText("");
                    t_medQuan.setText("");
                    t_medPri.setText("");
                }
                else{
                    addMed(t_medName.getText(), t_medQuan.getText(), t_medPri.getText());
                    JOptionPane.showMessageDialog(null,"Medicine added Successful");
                    t_medName.setText("");
                    t_medQuan.setText("");
                    t_medPri.setText("");
                    frame.dispose();

                    MainMenuGui mainMenuGui = new MainMenuGui();
                }
            }
            if(e.getSource() == back){
                MainMenuGui mainMenuGui = new MainMenuGui();
                frame.dispose();
            }
        }
    }
}
