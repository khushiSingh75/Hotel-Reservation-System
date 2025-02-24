package hotel.reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class EmployeeInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    EmployeeInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(20, 10, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(190, 10, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(350, 10, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Job");
        l4.setBounds(490, 10, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel("Salary");
        l5.setBounds(630, 10, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Phone No.");
        l6.setBounds(780, 10, 100, 20);
        add(l6);
        
        
        table = new JTable();
        table.setBounds(10, 40, 900, 300);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(350, 450, 120, 30);
        add(back);
        
        setBounds(200, 50, 900, 600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
    }

    public static void main(String arge[]){
        new EmployeeInfo();
    }
}
