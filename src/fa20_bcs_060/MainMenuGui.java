package fa20_bcs_060;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuGui {

    private JFrame frame;
    private JPanel panel;
    private JLabel mainMenu;

    private JButton search;
    private JButton place;
    private JButton add;
    private JButton view;
    private JButton back;
    private JButton order;
    private JButton delete;


    public MainMenuGui(){

        panel=new JPanel(null);

        frame=new JFrame("Main Menu");
        panel.setBackground(Color.CYAN);

        mainMenu = new JLabel("Main Menu");
        view = new JButton("View Medicine");
        order = new JButton("View Orders");
        add = new JButton("Add Medicine");
        search = new JButton("Search Medicine");
        place = new JButton("Place Order");
        back=new JButton("Back");
        delete=new JButton("Delete Medicine");


        mainMenu.setFont(new Font("Sanserif",Font.BOLD,30));
        view.setFont(new Font("Sanserif",Font.BOLD,20));
        order.setFont(new Font("Sanserif",Font.BOLD,20));
        add.setFont(new Font("Sanserif",Font.BOLD,20));
        search.setFont(new Font("Sanserif",Font.BOLD,20));
        place.setFont(new Font("Sanserif",Font.BOLD,20));
        back.setFont(new Font("Sanserif",Font.BOLD,20));
        delete.setFont(new Font("Sanserif",Font.BOLD,20));


        mainMenu.setForeground(Color.BLACK);
        view.setForeground(Color.BLACK);
        order.setForeground(Color.BLACK);
        add.setForeground(Color.BLACK);
        search.setForeground(Color.BLACK);
        place.setForeground(Color.BLACK);
        back.setForeground(Color.BLACK);
        delete.setForeground(Color.BLACK);


        mainMenu.setBackground(Color.green);
        view.setBackground(Color.green);
        order.setBackground(Color.green);
        add.setBackground(Color.green);
        search.setBackground(Color.green);
        place.setBackground(Color.green);
        back.setBackground(Color.white);
        delete.setBackground(Color.green);
        
        mainMenu.setBounds(225,50,350,50);
        view.setBounds(125,140,350,50);
        order.setBounds(125,220,350,50);
        add.setBounds(125,300,350,50);
        search.setBounds(125,380,350,50);
        place.setBounds(125,460,350,50);
        delete.setBounds(125,540,350,50);
        back.setBounds(225,670,150,30);

        view.setFocusable(false);
        order.setFocusable(false);
        add.setFocusable(false);
        search.setFocusable(false);
        place.setFocusable(false);
        delete.setFocusable(false);
        back.setFocusable(false);

        panel.add(mainMenu);
        panel.add(view);
        panel.add(order);
        panel.add(add);
        panel.add(search);
        panel.add(place);
        panel.add(back);
        panel.add(delete);

        frame.add(panel);
        frame.setTitle("Main Menu");
        frame.setVisible(true);
        frame.setSize(600,800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        view.addActionListener(new menuHandler());
        add.addActionListener(new menuHandler());
        search.addActionListener(new menuHandler());
        back.addActionListener(new menuHandler());
        place.addActionListener(new menuHandler());
        order.addActionListener(new menuHandler());
        delete.addActionListener(new menuHandler());

    }
    class menuHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == view){
                ShowMedStock showMedStock = new ShowMedStock();
                showMedStock.show();
                frame.dispose();
            }
            if (e.getSource() == add){
                AddMedicineGui  addMedicineGui = new AddMedicineGui();
                frame.dispose();
            }
            if(e.getSource() == search){
                SearchMedicineGui searchMedicineGui = new SearchMedicineGui();
                frame.dispose();
            }
            if(e.getSource() == place){
                PlaceOrderGui placeOrderGui = new PlaceOrderGui();
                frame.dispose();
            }
            if(e.getSource() == delete){
                DeleteMedicineGui deleteMedicineGui = new DeleteMedicineGui();
                frame.dispose();
            }
            if(e.getSource() == back){
                LoginGui loginGui = new LoginGui();
                frame.dispose();
            }
            if(e.getSource() == order){
                ShowMedOrders showMedOrders = new ShowMedOrders();
                showMedOrders.show();
                frame.dispose();
            }
        }
    }
}
