package StudentMonitoringSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class showDetails extends JFrame implements ActionListener {
    JTable t1;
    JScrollPane sp1;

    JButton home, back, update;
    showDetails(){
        setSize(1000,800);

        sp1 = new JScrollPane();
        sp1.setBounds(100,50,800,300);
        add(sp1);

        t1 = new JTable();
        sp1.setViewportView(t1);

        update = new JButton("Update Profile");
        update.setBounds(460,550,200,80);
        update.addActionListener(this);
        add(update);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bgw2.jpg"));
        JLabel i3 = new JLabel(i1);
        i3.setBounds(0, 0, 1000, 800);
        add(i3);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("images/back.png"));
        Image i12 = i11.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
        ImageIcon i13 = new ImageIcon(i12);
        back = new JButton(i13);
        back.addActionListener(this);
        back.setBounds(0,0,50,50);
        add(back);

        ImageIcon i21 = new ImageIcon(ClassLoader.getSystemResource("images/home.jpg"));
        Image i22 = i21.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
        ImageIcon i23 = new ImageIcon(i22);
        home = new JButton(i23);
        home.addActionListener(this);
        home.setBounds(920,0,50,50);
        add(home);

        conn c = new conn();
        try{
            String str = "select * from studdata;";
            ResultSet rs = c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));


        }catch (Exception e){
            System.out.println(e);
        }

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==update){
            new updateProfile();
            this.setVisible(false);
        }
        if(ae.getSource()==home){
            new Main();
            this.setVisible(false);
        }
        else if(ae.getSource()==back){
            new addDetails();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new showDetails();
    }
}
