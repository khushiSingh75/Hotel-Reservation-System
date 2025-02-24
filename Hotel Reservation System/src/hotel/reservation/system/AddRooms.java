package hotel.reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {
    
    JButton add, cancel;
    JTextField tfroom, tfprice;
    JComboBox typeCombo, availableCombo, cleanCombo;
    
    AddRooms() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("TOHOMA", Font.BOLD, 15));
        heading.setBounds(150, 20, 200, 20);
        add(heading);
        
        JLabel lblroomno = new JLabel("Room Number");
        lblroomno.setFont(new Font("TOHOMA", Font.PLAIN, 14));
        lblroomno.setBounds(60, 80, 120, 30);
        add(lblroomno);
        
        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 150, 30);
        add(tfroom);
        
        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("TOHOMA", Font.PLAIN, 14));
        lblavailable.setBounds(60, 130, 120, 30);
        add(lblavailable);
        
        String availableOptions[] = {"Available", "Occupied"};
        availableCombo = new JComboBox(availableOptions);
        availableCombo.setBounds(200, 130, 150, 30);
        availableCombo.setBackground(Color.WHITE); // Set background to white
        availableCombo.setForeground(Color.BLACK); // Set foreground to black
        add(availableCombo);
        
        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setFont(new Font("TOHOMA", Font.PLAIN, 14));
        lblclean.setBounds(60, 180, 120, 30);
        add(lblclean);
        
        String cleanOptions[] = {"Cleaned", "Dirty"};
        cleanCombo = new JComboBox(cleanOptions);
        cleanCombo.setBounds(200, 180, 150, 30);
        cleanCombo.setBackground(Color.WHITE); // Set background to white
        cleanCombo.setForeground(Color.BLACK); // Set foreground to black
        add(cleanCombo);
        
        JLabel lblprice = new JLabel("Price");
        lblprice.setFont(new Font("TOHOMA", Font.PLAIN, 14));
        lblprice.setBounds(60, 230, 120, 30);
        add(lblprice);
        
        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);
        
        JLabel lbltype = new JLabel("Bed Type");
        lbltype.setFont(new Font("TOHOMA", Font.PLAIN, 14));
        lbltype.setBounds(60, 280, 120, 30);
        add(lbltype);
        
        String typeOptions[] = {"Single Bed", "Double Bed"};
        typeCombo = new JComboBox(typeOptions);
        typeCombo.setBounds(200, 280, 150, 30);
        typeCombo.setBackground(Color.WHITE); // Set background to white
        typeCombo.setForeground(Color.BLACK); // Set foreground to black
        add(typeCombo);
        
        add = new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 350, 130, 30);
        add.addActionListener(this);
        add(add);
 
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 350, 130, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/rooms.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 90, 300, 200);
        add(image);

        setBounds(250, 100, 800, 470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String roomNumber = tfroom.getText();
            String availability = (String) availableCombo.getSelectedItem();
            String status = (String) cleanCombo.getSelectedItem();
            String price = tfprice.getText();
            String type = (String) typeCombo.getSelectedItem();
            
            try {
                Conn conn = new Conn();
                String str = "insert into room values('" + roomNumber + "', '" + availability + "', '" + status + "', '" + price + "', '" + type + "')";
                
                conn.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "New Room Added Successfully");
                
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String args[]) {
        new AddRooms();
    }
}
