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

import database.Conn;

public class Fastcash extends JFrame implements ActionListener{

    String pinnumber,cardnumber;
    JButton deposit,withdrwal,fastcash,ministatement,pinchange,balancecheck,exit;
    Fastcash(String pin,String card) {

        pinnumber = pin;
        cardnumber = card;

        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel textJLabel = new JLabel("Select the Amount to withdraw");
        textJLabel.setBounds(215,300,700,35);
        textJLabel.setFont(new Font("Sysrem",Font.BOLD,16));
        textJLabel.setForeground(Color.WHITE);
        image.add(textJLabel);

        deposit = new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrwal = new JButton("Rs 500");
        withdrwal.setBounds(355,415,150,30);
        withdrwal.addActionListener(this);
        image.add(withdrwal);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Rs 2500");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balancecheck = new JButton("Rs 10000");
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
        new Fastcash("","");
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
       
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber, cardnumber);
        }
        else{
            int amount = Integer.parseInt(((JButton)ae.getSource()).getText().substring(3));

            Conn connection  = new Conn();
            int balance = connection.getBalance(cardnumber);

            if(balance >= amount){
                connection.transact(cardnumber, pinnumber, amount, "withdraw");
                connection.updateBalance(cardnumber, amount, "withdraw");

                JOptionPane.showMessageDialog(null, "Debited Amount : Rs"+amount);

                setVisible(false);
                new Transactions(pinnumber, cardnumber);   
            }else{

                JOptionPane.showMessageDialog(null, "Insufficent Amount: "+balance);

                setVisible(false);
                new Transactions(pinnumber, cardnumber);
            }


            

        }
        
    }
}

