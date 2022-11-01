//package StudentMonitoringSystem;
//
//import net.proteanit.sql.DbUtils;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.sql.ResultSet;
//
//public class marks extends JFrame implements ActionListener {
//    JButton add, pass, sync;
//    JTable sem1, sem2;
//    JScrollPane sp1,sp2;
//    JTabbedPane tabs;
//   public static String name;
//   public static String gr;
//   public static String BEE;
//
//   public static String MECHANICS;
//   public static String MATHS1;
//   public static String MATHS2 , GRAPHICS , CPROGRAMMING;
//    int row;
//
//    marks(){
//        setSize(900,500);
//        //defining tables;
//        sem1 = new JTable();
//        sp1 = new JScrollPane();
//        sp1.setViewportView(sem1);
//
//        sem2 = new JTable();
//        sp2 = new JScrollPane();
//        sp2.setViewportView(sem2);
//
//        //fetching the data
//        //sem1
//        conn c = new conn();
//        try{
//            String str1 = "select name , gr , BEE , MECHANICS , MATHS1 , tot1 from studdata; ";
//            ResultSet rs1 = c.s.executeQuery(str1);
//            sem1.setModel(DbUtils.resultSetToTableModel(rs1));
//        }catch (Exception e){
//            System.out.println(e);
//        }
//
//        //sem2
//        try{
//            String str2 = "select name , gr ,MATHS2, GRAPHICS, CPROGRAMMING , tot2 from studdata ;";
//            ResultSet rs2 = c.s.executeQuery(str2);
//            sem2.setModel(DbUtils.resultSetToTableModel(rs2));
//
//        }catch(Exception e){
//            System.out.println(e);
//        }
//
//        tabs = new JTabbedPane();
//        tabs.setBounds(400,80,450,300);
//
//        //adding tabs
//        tabs.add("SEM 1", sp1);
//        tabs.add("SEM 2", sp2);
//        add(tabs);
//
//        //buttons
//        add = new JButton("Add / Update");
//        add.setBounds(80,80,150,50);
//        add.addActionListener(this);
//        add(add);
//
//        setLayout(null);
//        setLocationRelativeTo(null);
//        setVisible(true);
//    }
//    void sem1Select(){
//        sem1.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                row = sem1.getSelectedRow();
//                name = sem1.getModel().getValueAt(row, 0).toString();
//                gr = sem1.getModel().getValueAt(row,1).toString();
//                BEE = sem1.getModel().getValueAt(row , 2).toString();
//                MECHANICS = sem1.getModel().getValueAt(row , 3).toString();
//                MATHS1 = sem1.getModel().getValueAt(row , 4).toString();
//            }
//
//        });
//    }
//    void sem2Select(){
//        sem2.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                row = sem2.getSelectedRow();
//                name = sem2.getModel().getValueAt(row,0).toString();
//                gr = sem2.getModel().getValueAt(row, 1).toString();
//                MATHS2 = sem2.getModel().getValueAt(row , 2).toString();
//                GRAPHICS = sem2.getModel().getValueAt(row , 3).toString();
//                CPROGRAMMING = sem2.getModel().getValueAt(row , 4).toString();
//            }
//        });
//    }
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==add){
//            if(sem1.isShowing()){
//                sem1Select();
//                System.out.println(BEE);
//                System.out.println(MECHANICS);
//                System.out.println(MATHS1);
//            }
//            else if(sem2.isShowing()){
//                sem2Select();
//                System.out.println(MATHS2);
//                System.out.println(GRAPHICS);
//                System.out.println(CPROGRAMMING);
//            }
//
//
//            System.out.println(row);
//            System.out.println(name);
//            System.out.println(gr);
//
//
//            new addMarks();
//
//        }
//
//    }
//
//    public static void main(String[] args) {
//        new marks();
//    }
//}
