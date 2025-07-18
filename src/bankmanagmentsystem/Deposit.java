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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import database.Conn;

public class Deposit extends JFrame implements ActionListener {
    
    String pinnumber,cardnumber;
    JButton deposit,back;
    JTextField amount;

    Deposit(String pin,String card){
    
        pinnumber = pin;
        cardnumber = card;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =  new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    public static void main(String[] args) {
            new Deposit("","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

       if(e.getSource() == deposit){
        String type = "deposit";
        int number = Integer.parseInt(amount.getText());
        
        Conn connection = new Conn();
        connection.transact(cardnumber,pinnumber,number,type);
        connection.updateBalance(cardnumber, number, type);

        JOptionPane.showMessageDialog(null,"Sccussfully Deposited: Rs"+ number );
        setVisible(false);
        new Transactions(pinnumber , cardnumber).setVisible(true);

       }else if(e.getSource() == back){
        
        setVisible(false);
        new Transactions(pinnumber, cardnumber).setVisible(true);
       }
    }
}
