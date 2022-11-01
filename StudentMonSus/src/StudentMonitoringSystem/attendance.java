package StudentMonitoringSystem;

import com.mysql.cj.xdevapi.DbDoc;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class attendance extends JFrame implements ActionListener {
    JButton add, defaulters, refresh, home;
    JTable t1;
    JScrollPane sp1;

    JLabel i41, i43;

    attendance(){
        setSize(1000,500);

        sp1 = new JScrollPane();
        sp1.setBounds(550,80,400,300);
        this.add(sp1);

        t1 = new JTable();
        sp1.setViewportView(t1);
        displayOriginal();

        add = new JButton("Add/Update");
        add.setBounds(70,80,150,50);
        add.addActionListener(this);
        this.add(add);

        defaulters = new JButton("Defaulters");
        defaulters.setBounds(70,280,150,50);
        defaulters.addActionListener(this);
        this.add(defaulters);

        ImageIcon i41 = new ImageIcon(ClassLoader.getSystemResource("images/b233.jpg"));
        JLabel i43 = new JLabel(i41);
        i43.setBounds(0, 0, 1000, 500);
        add(i43);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/sync.jpg"));
        Image i2 = i1.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);

        refresh = new JButton(i3);
        refresh.setBounds(700,390,40,40);
        refresh.addActionListener(this);
        add(refresh);


        ImageIcon i21 = new ImageIcon(ClassLoader.getSystemResource("images/home.jpg"));
        Image i22 = i21.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
        ImageIcon i23 = new ImageIcon(i22);
        home = new JButton(i23);
        home.addActionListener(this);
        home.setBounds(920,0,50,50);
        add(home);

        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
    void displayOriginal(){
        try{
            conn c = new conn();
            String str = "select gr, name, attendance from studdata;";
            ResultSet rs = c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==defaulters){
            conn c = new conn();
            try {
                String str = "select gr, name, attendance from studdata where attendance < 50;";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource()==add) {
            new addAttendance();
            this.setVisible(false);
        }
        if (ae.getSource()==refresh){
            displayOriginal();
        } else if (ae.getSource()==home) {
            new Main();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new attendance();
    }
}
