package bankmanagmentsystem;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import database.Conn;

public class MiniStatement extends JFrame{

    String pinnumber,cardnumber;
    MiniStatement(String pin,String card)
    {
        setLayout(null);
        pinnumber = pin;
        cardnumber = card;

        JLabel bank = new JLabel("STATE BANK OF KUNAL");
        bank.setBounds(125, 20, 200, 20);
        add(bank);

        JLabel cardLabel = new JLabel("Card Number : "+cardnumber.substring(0, 4)+"XXXXXXXX"+cardnumber.substring(12));
        cardLabel.setBounds(20, 80, 300, 20);
        add(cardLabel);

        JLabel min = new JLabel();
        min.setBounds(20, 120, 400, 200);
        add(min);

        

        Conn connection = new Conn();
        int balance = connection.getBalance(cardnumber);

        JLabel balJLabel = new JLabel("Account Balance : "+balance);
        balJLabel.setBounds(20, 340, 300, 20);
        add(balJLabel);

        ResultSet rs = connection.getTransaction(cardnumber, pinnumber);
        int count = 1;
        try {
            
            while(rs.next() && count<=5){
                min.setText(min.getText()+ "<html>" + rs.getInt("amount")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getDate("date")+"<br><br><html>");
                count++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(20,20);
        setVisible(true);

    }

    public static void main(String[] args) {
        
    }
}
