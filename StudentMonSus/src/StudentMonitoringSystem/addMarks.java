//package StudentMonitoringSystem;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class addMarks extends JFrame implements ActionListener {
//JLabel l1 , l2 ,name , gr;
//JTextField BEE , MECHANICS , MATHS1 , TOTAL1;
//JButton display , update;
//    int lh = 50;
//    int lw = 50;
//    int tw = 150;
//    int th = 50;
//    String total1;
//    String BEE, MECHANICS, MATHS1;
//    addMarks(){
////        setSize(500,800);
//        setBounds(150,10,500,700);
//
//        l1 = new JLabel("Name :");
//        l1.setBounds(60,80,150,50);
//        add(l1);
//
//        l2 = new JLabel(" GR :");
//        l2.setBounds(60,140,150,50);
//        add(l2);
//
//        name = new JLabel(marks.name);
//        name.setBounds(300,80,250,50);
//        add(name);
//
//        gr = new JLabel(marks.gr);
//        gr.setBounds(300,140,50,50);
//        add(gr);
//
//        BEE = new JTextField();
//        BEE.setBounds(150,240,tw,th);
//        add(BEE);
//
//        MECHANICS = new JTextField();
//        MECHANICS.setBounds(150,300,tw,th);
//        add(MECHANICS);
//
//        MATHS1 = new JTextField();
//        MATHS1.setBounds(150,380,tw,th);
//        add(MATHS1);
//
//        TOTAL1 = new JTextField();
//        TOTAL1.setBounds(150,450,tw,th);
//        add(TOTAL1);
//
//
//        display = new JButton("Calculate");
//        display.setBounds(300,450,100,40);
//        display.addActionListener(this);
//        add(display);
//
//        update = new JButton("Update");
//        update.setBounds(150,550,100,40);
//        update.addActionListener(this);
//        add(update);
//
//
//
//        setLayout(null);
//        setVisible(true);
//
//    }
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==display){
//            total1 = String.valueOf(Integer.parseInt(BEE.getText())+Integer.parseInt(MECHANICS.getText())+Integer.parseInt(MATHS1.getText()));
//            TOTAL1.setText(total1);
//        }
//
//        if(ae.getSource()==update){
//            BEE = this.BEE.getText();
//            MECHANICS = this.MECHANICS.getText();
//            MATHS1 = this.MATHS1.getText();
//
//            conn c = new conn();
//            try{
//                String str1 = "update stud_details set BEE = '"+BEE+"', MECHANICS = '"+MECHANICS+"', MATHS1 = '"+MATHS1+"', tot1 = '"+TOTAL1+"' where  gr = '"+marks.gr+"' ; ";
//                c.s.executeUpdate(str1);
//                JOptionPane.showMessageDialog(null,"MArks added Successfully!");
//            }catch(Exception e){
//                System.out.println(e);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        new addMarks();
//    }
//}


//package StudentMonitoringSystem;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class addMarks extends JFrame implements ActionListener {
//    JLabel l1 , l2 ,name , gr;
//    JTextField eng , maths , science , total;
//    JButton display , update;
//
//    Font f1 = new Font("Tahoma",Font.PLAIN,19);
////    int lh = 50;
////    int lw = 50;
////    int tw = 150;
////    int th = 50;
//
//    int labX = 60;
//    int labH = 50;
//    int labW = 100;
//    int txtX = 200;
//    int txth = 40;
//    int txtW = 150;
//    String total1;
//    String english, math, sci;
//    addMarks(){
//        setSize(500,800);
//        setBounds(800,800,labW,labH);
//
//        l1 = new JLabel("Name :");
//        l1.setBounds(labX,40,labW,labH);
//        add(l1);
//
//        l2 = new JLabel(" GR :");
//        l2.setBounds(labX,100,labW,labH);
//        add(l2);
//
//        name = new JLabel(marks.name);
//        name.setBounds(labX,160,labW,labH);
//        name.setFont(f1);
//        add(name);
//
//        gr = new JLabel(marks.gr);
//        gr.setBounds(labX,220,labW,labH);
//        add(gr);
//
//        eng = new JTextField();
//        eng.setBounds(labX,320,labW,labH);
//        eng.setFont(f1);
//        eng.setForeground(Color.black);
//        add(eng);
//
//        maths = new JTextField();
//        maths.setBounds(labX,380,labW,labH);
//        add(maths);
//
//        science = new JTextField();
//        science.setBounds(labX,420,labW,labH);
//        add(science);
//
//        total = new JTextField();
//        total.setBounds(labX,480,labW,labH);
//        add(total);
//
//
//        display = new JButton("Calculate");
//        display.setBounds(300,450,100,40);
//        display.addActionListener(this);
//        add(display);
//
//        update = new JButton("Update");
//        update.setBounds(150,550,100,40);
//        update.addActionListener(this);
//        add(update);
//
//
//        setLayout(null);
//        setVisible(true);
//        setLocationRelativeTo(null);
//
//    }
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==display){
//            total1 = String.valueOf(Integer.parseInt(eng.getText())+Integer.parseInt(maths.getText())+Integer.parseInt(science.getText()));
//            total.setText(total1);
//        }
//
//        if(ae.getSource()==update){
//            english = this.eng.getText();
//            math = this.maths.getText();
//            sci = this.science.getText();
//
//            conn c = new conn();
//            try{
//                String str1 = "update studdata set english = '"+english+"', maths = '"+math+"', science = '"+sci+"', tot1 = '"+total1+"' where  gr = '"+marks.gr+"' ; ";
//                c.s.executeUpdate(str1);
//                JOptionPane.showMessageDialog(null,"MArks added Successfully!");
//            }catch(Exception e){
//                System.out.println(e);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        new addMarks();
//    }
//}

//working
//
//package StudentMonitoringSystem;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class addMarks extends JFrame implements ActionListener {
//    JLabel l1 , l2 ,l3 ,name , gr;
//    JTextField eng , maths , science , total;
//    JButton display , update;
//    int lh = 50;
//    int lw = 50;
//    int tw = 150;
//    int th = 50;
//    String total1;
//    String english, math, sci;
//    addMarks(){
//        setSize(500,800);
////        setBounds(150,10,500,800);
//
//        l1 = new JLabel("Name :");
//        l1.setBounds(60,40,100,50);
//        add(l1);
//
//        l2 = new JLabel(" GR :");
//        l2.setBounds(60,140,100,50);
//        add(l2);
//
//        l3 = new JLabel("BEE");
//        l3.setBounds(60,240,100,50);
//        add(l3);
//
////        name = new JLabel(marks.name);
////        name.setBounds(300,80,250,50);
////        add(name);
////
////        gr = new JLabel(marks.gr);
////        gr.setBounds(300,140,50,50);
////        add(gr);
//
//        eng = new JTextField();
//        eng.setBounds(150,240,tw,th);
//        add(eng);
//
//        maths = new JTextField();
//        maths.setBounds(150,300,tw,th);
//        add(maths);
//
//        science = new JTextField();
//        science.setBounds(150,380,tw,th);
//        add(science);
//
//        total = new JTextField();
//        total.setBounds(150,450,tw,th);
//        add(total);
//
//
//        display = new JButton("Calculate");
//        display.setBounds(300,450,100,40);
//        display.addActionListener(this);
//        add(display);
//
//        update = new JButton("Update");
//        update.setBounds(150,550,100,40);
//        update.addActionListener(this);
//        add(update);
//
//
//
//        setLayout(null);
//        setVisible(true);
//
//    }
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==display){
//            total1 = String.valueOf(Integer.parseInt(eng.getText())+Integer.parseInt(maths.getText())+Integer.parseInt(science.getText()));
//            total.setText(total1);
//        }
//
//        if(ae.getSource()==update){
//            english = this.eng.getText();
//            math = this.maths.getText();
//            sci = this.science.getText();
//
//            conn c = new conn();
//            try{
//                String str1 = "update studdata set english = '"+english+"', maths = '"+math+"', science = '"+sci+"', tot1 = '"+total1+"' where  gr = '"+marks.gr+"' ; ";
//                c.s.executeUpdate(str1);
//                JOptionPane.showMessageDialog(null,"MArks added Successfully!");
//            }catch(Exception e){
//                System.out.println(e);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        new addMarks();
//    }
//}
