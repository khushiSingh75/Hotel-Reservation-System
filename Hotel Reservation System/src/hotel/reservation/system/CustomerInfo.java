
package hotel.reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class CustomerInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    CustomerInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1 = new JLabel("ID");
        l1.setBounds(20, 10, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Number");
        l2.setBounds(130, 10, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(250, 10, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(360, 10, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel("Country");
        l5.setBounds(470, 10, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Room No.");
        l6.setBounds(580, 10, 100, 20);
        add(l6);
        
        JLabel l7 = new JLabel("Checkin Time");
        l7.setBounds(690, 10, 100, 20);
        add(l7);
        
        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(810, 10, 100, 20);
        add(l8);
        
        
        table = new JTable();
        table.setBounds(10, 40, 900, 300);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
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
        new CustomerInfo();
    }
}
