package hotel.reservation.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements  ActionListener {
    
    JTextField tfname, tfage, tfsalary, tfphone;
    JRadioButton rbmale, rbfemale;
    JButton submit;
    JComboBox cbjob;
   
    AddEmployee() {
        setLayout(null);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblname.setBounds(50, 30, 100, 30);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(150, 30, 200, 30);
        add(tfname);
        
        JLabel lblage = new JLabel("AGE");
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblage.setBounds(50, 80, 100, 30);
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(150, 80, 200, 30);
        add(tfage);
        
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblgender.setBounds(50, 130, 100, 30);
        add(lblgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(150, 130, 70, 30);
        rbmale.setFont(new Font("TOHOMA", Font.PLAIN, 14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(230, 130, 80, 30);
        rbfemale.setFont(new Font("TOHOMA", Font.PLAIN, 14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);   
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lbljob = new JLabel("Job");
        lbljob.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbljob.setBounds(50, 180, 100, 30);
        add(lbljob);
        
        String str[] = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs", "Waiter/Waitress", "Manager", "Accontant"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(150, 180, 200, 30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);

        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(50, 230, 100, 30);
        lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(lblsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(150, 230, 200, 30);
        add(tfsalary);
        

        JLabel lblphone = new JLabel("PHONE NO.");
        lblphone.setBounds(50, 280, 100, 30);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(150, 280, 200, 30);
        add(tfphone);
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(150, 350, 150, 30);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/stafff.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 70, 200, 200);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(200, 100, 650, 450);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        
        String gender = null;
        if (rbmale.isSelected()){
            gender = "Male";
        }else if(rbfemale.isSelected()){
        gender = "Female";
        }
        
        String job = (String) cbjob.getSelectedItem();
        
        try{
            Conn conn = new Conn();
            
            String query = "insert into employee values('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+phone+"')";
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Employee added successfully");
            setVisible(false);
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
