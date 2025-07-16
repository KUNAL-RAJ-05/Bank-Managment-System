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

public class Transactions extends JFrame implements ActionListener{

    String pinnumber,cardnumber;
    JButton deposit,withdrwal,fastcash,ministatement,pinchange,balancecheck,exit;
    Transactions(String pin,String card) {

        pinnumber = pin;
        cardnumber = card;

        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel textJLabel = new JLabel("Please select your Transaction");
        textJLabel.setBounds(215,300,700,35);
        textJLabel.setFont(new Font("Sysrem",Font.BOLD,16));
        textJLabel.setForeground(Color.WHITE);
        image.add(textJLabel);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrwal = new JButton("Cash Withdraw");
        withdrwal.setBounds(355,415,150,30);
        withdrwal.addActionListener(this);
        image.add(withdrwal);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balancecheck = new JButton("Check Balance");
        balancecheck.setBounds(355,485,150,30);
        balancecheck.addActionListener(this);
        image.add(balancecheck);

        exit = new JButton("EXIT");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);


        setSize(900,900);
        setLocation(300,0);

        setUndecorated(true);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Transactions("","");
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
       
        if(ae.getSource() == exit){
            System.exit(0);
        }
        if(ae.getSource() == deposit){
            setVisible(false);

            new Deposit(pinnumber, cardnumber).setVisible(true);
        }
        if(ae.getSource() == withdrwal)
        {
            setVisible(false);

            new Withdraw(pinnumber, cardnumber).setVisible(true);
        }
        if(ae.getSource() ==  fastcash){

            setVisible(false);

            new Fastcash(pinnumber, cardnumber);
        }
        if(ae.getSource() == pinchange){

            setVisible(false);

            new PinChange(pinnumber, cardnumber).setVisible(true);
        }
        if(ae.getSource() == balancecheck){

            setVisible(false);

            new CheckBalance(pinnumber, cardnumber);
        }
        if(ae.getSource() == ministatement){

            new MiniStatement(pinnumber, cardnumber).setVisible(true);
        }
    }
}
