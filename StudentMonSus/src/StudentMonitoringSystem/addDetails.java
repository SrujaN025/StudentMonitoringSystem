package StudentMonitoringSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.SimpleDateFormat;

public class addDetails extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4 ,l5 , l6, l7, l8;
    JTextField name, age, aadhar , gr , address , contact;
    JButton submit, back, home, view;
    JRadioButton male, female;
    JDateChooser dob;
    ButtonGroup gen;
    Font fLabel = new Font("Tahoma", Font.PLAIN,19);

    //size variables
    int labX = 60;
    int labH = 50;
    int labW = 100;
    int txtX = 200;
    int txth = 40;
    int txtW = 150;
    addDetails(){
        setSize(500,800);

        l1 = new JLabel("Name");
        l1.setBounds(labX,40,labW,labH);
        l1.setFont(fLabel);
        add(l1);

         l2 = new JLabel("DOB");
        l2.setBounds(labX,100,labW,labH);
        l2.setFont(fLabel);
        add(l2);

         l3 = new JLabel("Age");
        l3.setBounds(labX,160,labW,labH);
        l3.setFont(fLabel);
        add(l3);

         l4 = new JLabel("Gender");
        l4.setBounds(labX,220,labW,labH);
        l4.setFont(fLabel);
        add(l4);

         l5 = new JLabel("Address");
        l5.setBounds(labX,280,labW,labH);
        l5.setFont(fLabel);
        add(l5);

         l6 = new JLabel("Aadhar");
        l6.setBounds(labX,340,labW,labH);
        l6.setFont(fLabel);
        add(l6);

         l7 = new JLabel("Contact");
        l7.setBounds(labX,400,labW,labH);
        l7.setFont(fLabel);
        add(l7);

         l8 = new JLabel("GR NO");
        l8.setBounds(labX,460,labW,labH);
        l8.setFont(fLabel);
        add(l8);

        //textfields
        name = new JTextField();
        name.setBounds(txtX,40,txtW,txth);
        add(name);

        dob = new JDateChooser();
        dob.setBounds(txtX, 100, txtW, txth);
        add(dob);

        age = new JTextField();
        age.setBounds(txtX,160,txtW,txth);
        add(age);

        address = new JTextField();
        address.setBounds(txtX,280,txtW,txth);
        add(address);

        aadhar = new JTextField();
        aadhar.setBounds(txtX,340,txtW,txth);
        add(aadhar);

        contact = new JTextField();
        contact.setBounds(txtX,400,txtW,txth);
        add(contact);

        gr = new JTextField();
        gr.setBounds(txtX,460,txtW,txth);
        add(gr);

        //radiobuttons
         gen = new ButtonGroup();

        male = new JRadioButton("Male");
        male.setBounds(200,230,60, txth);
        gen.add(male);
        add(male);

        female = new JRadioButton("feMale");
        female.setBounds(290,230,70,txth);
        gen.add(female);
        add(female);

        //button
        submit = new JButton("Submit");
        submit.setBounds(300,550,150,60);
        submit.addActionListener(this);
        add(submit);

        view = new JButton("View Details");
        view.setBounds(100,550,150,60);
        view.addActionListener(this);
        add(view);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bgw1.jpg"));
        JLabel i3 = new JLabel(i1);
        i3.setBounds(0, 0, 500, 800);
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
        home.setBounds(420,0,50,50);
        add(home);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String name = this.name.getText();
            String age = this.age.getText();
            String address = this.address.getText();
            String contact = this.contact.getText();
            String gr = this.gr.getText();
            String aadhar = this.aadhar.getText();

            String gender = null;
            if(male.isSelected()){
                gender = "Male";
            }
            else if(female.isSelected()){
                gender = "Female";
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
            String dob = dateFormat.format(this.dob.getDate());

//            System.out.println(name);
//            System.out.println(age);
//            System.out.println(dob);
//            System.out.println(address);
//            System.out.println(gender);
//            System.out.println(aadhar);
//            System.out.println(gr);
//            System.out.println(contact);

            conn c = new conn();
            try {
                String str = "insert into studdata (name, dob,age,gender,address,aadhar,contact,gr) values ('"+name+"','"+dob+"','"+age+"','"+gender+"','"+address+"','"+aadhar+"','"+contact+"','"+gr+"');";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Data is Successfully entered!!");
                this.name.setText(null);
                this.age.setText(null);
                this.gr.setText(null);
                this.address.setText(null);
                this.aadhar.setText(null);
                this.contact.setText(null);
                this.male.setSelected(false);
                this.female.setSelected(false);
                new attendance();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        if(ae.getSource()==back){
            new login();
            this.setVisible(false);
        }
        else if (ae.getSource()==home){
            new Main();
            this.setVisible(false);
        } else if (ae.getSource()==view) {
            new showDetails();
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new addDetails();
    }
}
