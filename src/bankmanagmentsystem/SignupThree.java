package bankmanagmentsystem;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class SignupThree extends JFrame {

        JCheckBox c1,c2,c3,c4,c5,c6,c7;
        JButton submit,cancel;
    SignupThree() {
        
        setLayout(null);

        JLabel additionalDetails = new JLabel("Page 3: Account Details - Form No.");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(280,40,400,40);
        add(additionalDetails);

        JLabel accountJLabel = new JLabel("Account Type:");
        accountJLabel.setFont(new Font("Raleway",Font.BOLD,18));
        accountJLabel.setBounds(100,140,200,30);
        add(accountJLabel);

        JRadioButton savingRadioButton = new JRadioButton("Saving Account");
        savingRadioButton.setFont(new Font("Raleway", Font.BOLD, 16));
        savingRadioButton.setBackground(Color.WHITE);
        savingRadioButton.setBounds(100,180,150,30);
        add(savingRadioButton);

        JRadioButton fixedRadioButton = new JRadioButton("Fixed Deposit Account");
        fixedRadioButton.setFont(new Font("Raleway", Font.BOLD, 16));
        fixedRadioButton.setBackground(Color.WHITE);
        fixedRadioButton.setBounds(350,180,250,30);
        add(fixedRadioButton);

        JRadioButton curreRadioButton = new JRadioButton("Current Account");
        curreRadioButton.setFont(new Font("Raleway", Font.BOLD, 16));
        curreRadioButton.setBackground(Color.WHITE);
        curreRadioButton.setBounds(100,220,150,30);
        add(curreRadioButton);

        JRadioButton recurringRadioButton = new JRadioButton("Recurring Deposit Account");
        recurringRadioButton.setFont(new Font("Raleway", Font.BOLD, 16));
        recurringRadioButton.setBackground(Color.WHITE);
        recurringRadioButton.setBounds(350,220,250,30);
        add(recurringRadioButton);

        ButtonGroup acc = new ButtonGroup();
        acc.add(recurringRadioButton);
        acc.add(curreRadioButton);
        acc.add(savingRadioButton);
        acc.add(fixedRadioButton);

        JLabel cardJLabel = new JLabel("Card Number:");
        cardJLabel.setFont(new Font("Raleway",Font.BOLD,18));
        cardJLabel.setBounds(100,300,200,30);
        add(cardJLabel);

        JLabel cardnoJLabel = new JLabel("XXXX-XXXX-XXXX-4184");
        cardnoJLabel.setFont(new Font("Raleway",Font.BOLD,18));
        cardnoJLabel.setBounds(330,300,250,30);
        add(cardnoJLabel);

        JLabel pinJLabel = new JLabel("PIN:");
        pinJLabel.setFont(new Font("Raleway",Font.BOLD,18));
        pinJLabel.setBounds(100,370,200,30);
        add(pinJLabel);

        JLabel xJLabel = new JLabel("XXXX");
        xJLabel.setFont(new Font("Raleway",Font.BOLD,18));
        xJLabel.setBounds(400,370,200,30);
        add(xJLabel);

        JLabel l5 = new JLabel("(Your 16-digit Card number)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));
        l5.setBounds(100,330,200,20);
        add(l5);
        
        JLabel l6 = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        l6.setFont(new Font("Raleway", Font.BOLD, 12));
        l6.setBounds(330,330,500,20);
        add(l6);

        JLabel servicesJLabel = new JLabel("Services Required:");
        servicesJLabel.setFont(new Font("Raleway",Font.BOLD,18));
        servicesJLabel.setBounds(100,450,200,30);
        add(servicesJLabel);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));

        c1.setBounds(100,500,200,30);
        add(c1);
        
        c2.setBounds(350,500,200,30);
        add(c2);
        
        c3.setBounds(100,550,200,30);
        add(c3);
        
        c4.setBounds(350,550,200,30);
        add(c4);
        
        c5.setBounds(100,600,200,30);
        add(c5);
        
        c6.setBounds(350,600,200,30);
        add(c6);
        
        c7.setBounds(100,680,600,20);
        add(c7);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250,720,100,30);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(420,720,100,30);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(500,0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new SignupThree();
       
    }
    // Override or add methods specific to SignupThree if needed

}
