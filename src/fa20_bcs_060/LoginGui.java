package fa20_bcs_060;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGui{

    private JFrame frame;
    private JPanel panel;

    private JLabel signin;
    private JLabel name;
    private JLabel pass;

    private JTextField t_name;
    private JTextField t_pass;

    private JButton clear;
    private JButton submit;
    private JButton exit;

    public LoginGui(){

        panel=new JPanel(null);

        frame=new JFrame("Login");
        panel.setBackground(Color.CYAN);

        signin=new JLabel("Login");
        name=new JLabel("Name:");
        pass=new JLabel("Password:");

        t_name=new JTextField();
        t_pass=new JTextField();

        signin.setFont(new Font("Sanserif",Font.BOLD,30));
        name.setFont(new Font("Sanserif",Font.BOLD,20));
        pass.setFont(new Font("Sanserif",Font.BOLD,20));

        signin.setForeground(Color.BLACK);//Text color
        name.setForeground(Color.BLACK);
        pass.setForeground(Color.BLACK);

        signin.setBounds(230,70,100,60);
        name.setBounds(120,150,100,30);
        pass.setBounds(120,200,100,30);

        t_name.setBounds(230,150,130,30);
        t_pass.setBounds(230,200,130,30);
        t_pass.setBackground(Color.white);
        t_name.setBackground(Color.white);

        submit=new JButton("Submit");

        exit =new JButton("Exit");

        clear=new JButton("Clear");

        submit.setFont(new Font("Sanserif",Font.BOLD,20));
        exit.setFont(new Font("Sanserif",Font.BOLD,20));

        clear.setFont(new Font("Sanserif",Font.BOLD,20));

        submit.setForeground(Color.BLACK);
        exit.setForeground(Color.BLACK);
        clear.setForeground(Color.BLACK);
        submit.setBackground(Color.green);
        clear.setBackground(Color.green);
        exit.setBackground(Color.green);

        submit.setBounds(50,300,150,50);
        exit.setBounds(215,300,150,50);
        clear.setBounds(380,300,150,50);

        panel.add(signin);
        panel.add(name);
        panel.add(pass);
        panel.add(submit);
        panel.add(clear);
        panel.add(exit);
        panel.add(t_name);
        panel.add(t_pass);

        frame.add(panel);
        frame.setTitle("Login");
        frame.setVisible(true);
        frame.setSize(600,400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        clear.addActionListener(new LoginHandler());
        submit.addActionListener(new LoginHandler());
        exit.addActionListener(new LoginHandler());


    }

    class LoginHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==clear){
                t_name.setText("");
                t_pass.setText("");
            }

            if(e.getSource()==submit){
                String userName = t_name.getText();
                String password = t_pass.getText();
                Login login = new Login(userName,password);
                if(login.checkUserNamePass() == true){
                    JOptionPane.showMessageDialog(null,"Login Successful");
                    MainMenuGui mainMenuGui = new MainMenuGui();
                    frame.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Incorrect Username or Password\nEnter credentials again");
                    t_name.setText("");
                    t_pass.setText("");
                }
            }
            if(e.getSource() == exit){
                frame.dispose();
            }
        }
    }
}
