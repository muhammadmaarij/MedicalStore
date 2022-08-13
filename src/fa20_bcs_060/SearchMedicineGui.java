package fa20_bcs_060;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchMedicineGui {
    private JFrame frame;
    private JPanel panel;

    private JLabel searchMed;
    private JLabel searchName;

    private JTextField t_searchName;

    private JButton clear;
    private JButton search;
    private JButton back;

    public SearchMedicineGui(){
        panel=new JPanel(null);

        frame=new JFrame("Search Medicine");
        panel.setBackground(Color.CYAN);

        searchMed=new JLabel("Search Medicine");
        searchName=new JLabel("Medicine Name:");

        t_searchName=new JTextField();

        searchMed.setFont(new Font("Sanserif",Font.BOLD,30));
        searchName.setFont(new Font("Sanserif",Font.BOLD,20));

        searchMed.setForeground(Color.BLACK);//Text color
        searchName.setForeground(Color.BLACK);

        searchMed.setBounds(190,70,400,60);
        searchName.setBounds(120,150,250,30);
        t_searchName.setBounds(330,150,130,30);

        t_searchName.setBackground(Color.white);

        search=new JButton("Search");
        back=new JButton("Back");
        clear=new JButton("Clear");

        search.setFont(new Font("Sanserif",Font.BOLD,20));
        back.setFont(new Font("Sanserif",Font.BOLD,20));
        clear.setFont(new Font("Sanserif",Font.BOLD,20));

        search.setForeground(Color.BLACK);
        back.setForeground(Color.BLACK);
        clear.setForeground(Color.BLACK);
        search.setBackground(Color.green);
        clear.setBackground(Color.green);
        back.setBackground(Color.green);

        search.setBounds(50,400,150,50);
        back.setBounds(215,400,150,50);
        clear.setBounds(380,400,150,50);

        panel.add(searchMed);
        panel.add(searchName);
        panel.add(clear);
        panel.add(back);
        panel.add(t_searchName);
        panel.add(search);

        frame.add(panel);
        frame.setTitle("Search Medicine");
        frame.setVisible(true);
        frame.setSize(600,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        clear.addActionListener(new SearchMedicineGui.SearchMedHandler());
        search.addActionListener(new SearchMedicineGui.SearchMedHandler());
        back.addActionListener(new SearchMedicineGui.SearchMedHandler());

    }

    class SearchMedHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clear) {
                t_searchName.setText("");
            }

            if (e.getSource() == search) {
                String medName = t_searchName.getText();
                boolean b1;
                SearchMedicine searchMedicine = new SearchMedicine();
                b1 = searchMedicine.searchM(medName);

                if (b1 == true) {
                    JOptionPane.showMessageDialog(null, "Medicine found");
                    frame.dispose();
                    MainMenuGui mainMenuGui = new MainMenuGui();
                } else {
                    JOptionPane.showMessageDialog(null, "Medicine not found");
                }
                t_searchName.setText("");
            }

            if (e.getSource() == back) {
                MainMenuGui mainMenuGui = new MainMenuGui();
                frame.dispose();
            }
        }
    }
}
