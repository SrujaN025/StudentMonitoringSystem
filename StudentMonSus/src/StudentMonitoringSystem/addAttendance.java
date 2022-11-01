package StudentMonitoringSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class addAttendance extends JFrame implements ActionListener {

    JLabel l1, l2;

    JTextField gr, att;

    JButton display, submit, view, back;

    JScrollPane sp1;

    JTable t1;

    JLabel i41, i43;

    addAttendance(){
        setSize(550,600);

        l1 = new JLabel("G.R No");
        l1.setForeground(Color.white);
        l1.setBounds(100,50,120,50);
        add(l1);

        gr = new JTextField();
        gr.setBounds(210,50,150,50);
        add(gr);

        display = new JButton("Display");
        display.setBounds(390,50,100,50);
//        display.setForeground(Color.white);
        display.addActionListener(this);
        add(display);

        sp1 = new JScrollPane();
        sp1.setBounds(30,180,480,50);
        add(sp1);

        t1 = new JTable();
        sp1.setViewportView(t1);

        l2 = new JLabel("Add / Update Record");
        l2.setForeground(Color.WHITE);
        l2.setBounds(60,300,130,50);
        add(l2);

        att = new JTextField();
        att.setBounds(250,300,130,50);
        add(att);

        submit = new JButton("Submit");
//        submit.setForeground(Color.white);
        submit.setBounds(100,450,150,50);
        submit.addActionListener(this);
        add(submit);

        view = new JButton("View Details");
        view.setBounds(300,450,150,50);
        view.addActionListener(this);
        add(view);

        ImageIcon i41 = new ImageIcon(ClassLoader.getSystemResource("images/b9.jpg"));
        JLabel i43 = new JLabel(i41);
        i43.setBounds(0, 0, 550, 600);
        add(i43);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("images/back.png"));
        Image i12 = i11.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
        ImageIcon i13 = new ImageIcon(i12);
        back = new JButton(i13);
        back.addActionListener(this);
        back.setBounds(0,0,50,50);
        add(back);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==display){
            String gr = this.gr.getText();
            conn c = new conn();
            try{
                String str = "select name, gr, attendance from studdata where gr = '"+gr+"';";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        if(ae.getSource()==submit){
            String gr = this.gr.getText();
            String attend = this.att.getText();
            conn c = new conn();
            try{
                String str1 = "update studdata set attendance = '"+attend+"'where gr = '"+gr+"';";
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null,"Attendance updated successfully");
            }
            catch (Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource()==view) {
            new showDetails();
        } else if (ae.getSource()==back) {
            new attendance();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new addAttendance();
    }
}
