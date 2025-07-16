package bankmanagmentsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import database.Conn;


public class CheckBalance extends JFrame implements ActionListener{

    String pinnumber,cardnumber;
    JButton back;

    CheckBalance(String pin,String card){
        pinnumber = pin;
        cardnumber = card;

        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        Conn connection = new Conn();
        int balance = connection.getBalance(cardnumber);

        JLabel textJLabel = new JLabel("Balance in your Account : "+balance);
        textJLabel.setBounds(215,300,700,35);
        textJLabel.setFont(new Font("Sysrem",Font.BOLD,16));
        textJLabel.setForeground(Color.WHITE);
        image.add(textJLabel);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);

        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);

        new Transactions(pinnumber, cardnumber);
    }
    public static void main(String[] args) {
        new CheckBalance("","");
    }
}
