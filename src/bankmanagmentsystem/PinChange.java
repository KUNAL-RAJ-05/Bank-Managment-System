package bankmanagmentsystem;

import database.Conn;

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
import javax.swing.JPasswordField;


public class PinChange extends JFrame implements ActionListener{

    JPasswordField npin,rpin;
    JButton change,back;
    String pinnumber,cardnumber;

    PinChange(String pin,String card){
        pinnumber = pin;
        cardnumber = card;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);

        JLabel pintext = new JLabel("New PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);

        npin = new JPasswordField();
        npin.setFont(new Font("Raleway",Font.BOLD,25));
        npin.setBounds(330,320,180,25);
        image.add(npin);

        JLabel repintext = new JLabel("Re-Enter New PIN");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(165,360,180,25);
        image.add(repintext);

        rpin = new JPasswordField();
        rpin.setFont(new Font("Raleway",Font.BOLD,25));
        rpin.setBounds(330,360,180,25);
        image.add(rpin);

        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == change){
            
            String newpin = new String(npin.getPassword());
            String repin = new String(rpin.getPassword());

            if(pinnumber.equals(newpin)){
                JOptionPane.showMessageDialog(null, "NEW PIN SHOULD BE DIFFERENET FOMR OLD PIN");
            }else if(newpin.equals("")){
                JOptionPane.showMessageDialog(null, "Enter the NEW PIN");
            }else if(repin.equals("")){
                JOptionPane.showMessageDialog(null, "Enter the PIN AGAIN ");
            }else if(!newpin.equals(repin)){
                JOptionPane.showMessageDialog(null, "NEW PIN AND RE PIN DOES NOT MATCH");
            }else if(newpin.equals(repin)){
                Conn connection = new Conn();
                connection.updatePin(cardnumber,newpin);

                JOptionPane.showMessageDialog(null, "PIN CHANGED SCCESSFULLY");
                setVisible(false);
                new Transactions(newpin, cardnumber).setVisible(true);

            }
        }else if(ae.getSource() == back){

            setVisible(false);

            new Transactions(pinnumber, cardnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new PinChange("","");
    }
}
