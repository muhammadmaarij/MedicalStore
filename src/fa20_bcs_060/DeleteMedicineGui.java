package fa20_bcs_060;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteMedicineGui {
    private JFrame frame;
    private JPanel panel;

    private JLabel deleteMed;
    private JLabel deletename;

    private JTextField t_delMed;


    private JButton clear;

    private JButton delete;
    private JButton back;

    public DeleteMedicineGui(){

        panel=new JPanel(null);

        frame=new JFrame("Delete Medicine");
        panel.setBackground(Color.CYAN);

        deleteMed =new JLabel("Delete Medicine");
        deletename =new JLabel("Medicine Name:");

        t_delMed =new JTextField();

        deleteMed.setFont(new Font("Sanserif",Font.BOLD,30));
        deletename.setFont(new Font("Sanserif",Font.BOLD,20));

        deleteMed.setForeground(Color.BLACK);    //Text color
        deletename.setForeground(Color.BLACK);

        deleteMed.setBounds(190,70,350,60);
        deletename.setBounds(120,150,250,30);


        t_delMed.setBounds(330,150,130,30);

        t_delMed.setBackground(Color.white);

        delete =new JButton("Delete");

        back=new JButton("Back");

        clear=new JButton("Clear");

        delete.setFont(new Font("Sanserif",Font.BOLD,20));
        back.setFont(new Font("Sanserif",Font.BOLD,20));
        clear.setFont(new Font("Sanserif",Font.BOLD,20));

        delete.setForeground(Color.BLACK);

        back.setForeground(Color.BLACK);

        clear.setForeground(Color.BLACK);
        delete.setBackground(Color.green);
        clear.setBackground(Color.green);
        back.setBackground(Color.green);

        delete.setBounds(50,400,150,50);
        back.setBounds(215,400,150,50);
        clear.setBounds(380,400,150,50);

        panel.add(deleteMed);
        panel.add(deletename);
        panel.add(clear);
        panel.add(back);
        panel.add(t_delMed);
        panel.add(delete);

        frame.add(panel);
        frame.setTitle("Login");
        frame.setVisible(true);
        frame.setSize(600,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        clear.addActionListener(new DeleteMedicineGui.DeleteMedHandler());
        delete.addActionListener(new DeleteMedicineGui.DeleteMedHandler());
        back.addActionListener(new DeleteMedicineGui.DeleteMedHandler());

    }

    class DeleteMedHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==clear){
                t_delMed.setText("");
            }

            if(e.getSource()== delete){

                if(t_delMed.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter name of medicine available in stock to delete");
                }
                else {
                    String medName = t_delMed.getText();
                    MedicineWriter medicineWriter = new MedicineWriter();
                    SearchMedicine searchMedicine = new SearchMedicine();
                    boolean b1;
                    b1 = searchMedicine.searchM(medName);

                    if (b1 == true) {
                        medicineWriter.deleteMedi(medName);
                        t_delMed.setText("");
                        JOptionPane.showMessageDialog(null,"Medicine deleted successfully");
                        MainMenuGui mainMenuGui = new MainMenuGui();
                        frame.dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Medicine not found");
                        t_delMed.setText("");
                    }

                }
            }


            if(e.getSource() == back){
                MainMenuGui mainMenuGui = new MainMenuGui();
                frame.dispose();
            }
        }
    }
}