package StudentMonitoringSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField username ;

    JButton signin, cancel, home;
    JPasswordField password;

    Font f1 = new Font("Tahoma",Font.PLAIN,18);
    login(){
        setSize(600,400);

        l1 = new JLabel("Username");
        l1.setBounds(80,80,150,50);
        l1.setForeground(Color.WHITE);
        l1.setFont(f1);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(80,160,150,50);
        l2.setForeground(Color.WHITE);
        l2.setFont(f1);
        add(l2);

        username = new JTextField();
        username.setBounds(220, 80, 180, 50);
        username.setFont(f1);
        add(username);

        password = new JPasswordField();
        password.setBounds(220, 160, 180, 50);
        password.setFont(f1);
        add(password);

        signin = new JButton("Sign-in");
        signin.setBounds(100, 260, 120, 50);
        signin.setFont(f1);
        signin.addActionListener(this);
        add(signin);

        cancel = new JButton("Cancel");
        cancel.setBounds(280, 260, 120, 50);
        cancel.setFont(f1);
        add(cancel);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/b15.jpg"));
        JLabel i3 = new JLabel(i1);
        i3.setBounds(0, 0, 600, 400);
        add(i3);

        ImageIcon i21 = new ImageIcon(ClassLoader.getSystemResource("images/home.jpg"));
        Image i22 = i21.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
        ImageIcon i23 = new ImageIcon(i22);
        home = new JButton(i23);
        home.addActionListener(this);
        home.setBounds(520,0,50,50);
        add(home);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==signin){
            String username = this.username.getText();
            String password = String.valueOf((this.password.getPassword()));
            conn c = new conn();
            try {
                String str1 = "select * from login where username = '"+username+"'and password = '"+password+"';";
                ResultSet rs = c.s.executeQuery(str1);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null,"Login Successfull!");
                    new addDetails();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid Credentials");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
        if (ae.getSource()==home){
            new Main();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
