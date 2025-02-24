package hotel.reservation.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelReservationSystem extends JFrame implements ActionListener {
    HotelReservationSystem() {
        setBounds(50, 60, 1200, 565);
        setLayout(null);

        // Load and scale the image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1300, 565, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1300, 565);
        add(image);

        JLabel text = new JLabel("HOTEL RESERVATION SYSTEM");
        text.setBounds(20, 430, 1000, 90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);

        JButton next = new JButton("Next");
        next.setBounds(1015, 450, 150, 50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.MAGENTA);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.PLAIN, 24));
        image.add(next);

        setVisible(true);

        // Make the text blink
        Timer timer = new Timer(500, e -> text.setVisible(!text.isVisible()));
        timer.start();
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new HotelReservationSystem();
    }
}
