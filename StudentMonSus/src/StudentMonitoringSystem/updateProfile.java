package StudentMonitoringSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateProfile extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4;

    JTextField gr, data;

    JButton display, submit, home, back, update;

    JComboBox fields;

    JTable t1;

    JLabel i1, i3;

    JScrollPane sp1;

    String[] list = {"name", "address", "aadhar", "contact", "gender"};

    updateProfile() {
        setSize(900, 600);

        l1 = new JLabel("G.R no.");
        l1.setBounds(80, 40, 150, 50);
        add(l1);

        l2 = new JLabel("Choose Field");
        l2.setBounds(80, 300, 150, 50);
        add(l2);

//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/b22.jpg"));
//        JLabel i3 = new JLabel(i1);
//        i3.setBounds(0, 0, 900, 600);
//        add(i3);

        fields = new JComboBox(list);
        fields.setBounds(300, 300, 150, 40);
        add(fields);

        l3 = new JLabel("Updated Value");
        l3.setBounds(80, 380, 150, 50);
        add(l3);

        data = new JTextField();
        data.setBounds(300, 380, 150, 40);
        add(data);

        submit = new JButton("Update Data");
        submit.setBounds(360, 450, 180, 50);
        submit.addActionListener(this);
        add(submit);

        gr = new JTextField();
        gr.setBounds(250, 40, 150, 40);
        add(gr);

        display = new JButton("Display");
        display.setBounds(450, 40, 100, 40);
        display.addActionListener(this);
        add(display);

        sp1 = new JScrollPane();
        sp1.setBounds(50, 160, 700, 60);
        add(sp1);

        t1 = new JTable();
        sp1.setViewportView(t1);




        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("images/back.png"));
        Image i12 = i11.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon i13 = new ImageIcon(i12);
        back = new JButton(i13);
        back.addActionListener(this);
        back.setBounds(0, 0, 50, 50);
        add(back);


        ImageIcon i21 = new ImageIcon(ClassLoader.getSystemResource("images/home.jpg"));
        Image i22 = i21.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon i23 = new ImageIcon(i22);
        home = new JButton(i23);
        home.addActionListener(this);
        home.setBounds(820, 0, 50, 50);
        add(home);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == display) {
            String gr = this.gr.getText();
            conn c = new conn();
            try {
                String str = "select name, age, address, dob, aadhar, contact, gender from studdata where gr = '" + gr + "';";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (ae.getSource() == submit) {
            String gr = this.gr.getText();
            String value = this.data.getText();
            String choice = fields.getSelectedItem().toString();
//            System.out.println(gr);
//            System.out.println(data);
//            System.out.println(choice);
            conn c = new conn();
            try {
                String str = "update studdata set " + choice + "= '" + value + "'where gr = '" + gr + "';";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (ae.getSource() == back) {
            new showDetails();
            this.setVisible(false);
        } else if (ae.getSource() == home) {
            new Main();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new updateProfile();
    }
}