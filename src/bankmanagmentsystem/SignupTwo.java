package bankmanagmentsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import database.Conn;
public class SignupTwo extends JFrame implements ActionListener{

    
    JTextField panTextField,aadhTextField;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox<String> religiComboBox,categorComboBox,incomeComboBox,educationComboBox,occupationComboBox;
    int formno;

    SignupTwo(int formno){
        this.formno = formno; 

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");


        JLabel additionalDetails = new JLabel("Page 2: Additional Details - Form No."+this.formno);
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(200,80,600,30);
        add(additionalDetails);

        JLabel religionJLabel = new JLabel("Religion: " );
        religionJLabel.setFont(new Font("Raleway",Font.BOLD,20));
        religionJLabel.setBounds(100,140,100,30);
        add(religionJLabel);

        String valReligion[] = {"Hindu","Sikh","Christian","Muslim","Other"};
        religiComboBox = new JComboBox<>(valReligion);
        religiComboBox.setBounds(300,140,400,30);
        religiComboBox.setBackground(Color.WHITE);
        add(religiComboBox);

        JLabel categoryJLabel = new JLabel("Category: " );
        categoryJLabel.setFont(new Font("Raleway",Font.BOLD,20));
        categoryJLabel.setBounds(100,190,200,30);
        add(categoryJLabel);

        String valCategory[] = {"General","OBC","SC","ST","Other"};
        categorComboBox = new JComboBox<>(valCategory);
        categorComboBox.setBackground(Color.WHITE);
        categorComboBox.setBounds(300,190,400,30);
        add(categorComboBox);        

        JLabel incomeJLabel = new JLabel("Income: " );
        incomeJLabel.setFont(new Font("Raleway",Font.BOLD,20));
        incomeJLabel.setBounds(100,240,200,30);
        add(incomeJLabel);

        String valIncome[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        incomeComboBox = new JComboBox<>(valIncome);
        incomeComboBox.setBounds(300,240,400,30);
        incomeComboBox.setBackground(Color.WHITE);
        add(incomeComboBox);

        JLabel educationJLabel = new JLabel("Educational " );
        educationJLabel.setFont(new Font("Raleway",Font.BOLD,20));
        educationJLabel.setBounds(100,290,200,30);
        add(educationJLabel);

        JLabel qualification = new JLabel("Qualification: " );
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,315,200,30);
        add(qualification);

        String valEducation[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        educationComboBox = new JComboBox<>(valEducation);
        educationComboBox.setBounds(300,315,400,30);
        educationComboBox.setBackground(Color.WHITE);
        add(educationComboBox);

        JLabel occupationJLabel = new JLabel("Occupation: " );
        occupationJLabel.setFont(new Font("Raleway",Font.BOLD,20));
        occupationJLabel.setBounds(100,390,200,30);
        add(occupationJLabel);

        String valOccupation[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        occupationComboBox = new JComboBox<>(valOccupation);
        occupationComboBox.setBounds(300,390,400,30);
        occupationComboBox.setBackground(Color.WHITE);
        add(occupationComboBox);

        JLabel panJLabel = new JLabel("PAN Number: " );
        panJLabel.setFont(new Font("Raleway",Font.BOLD,20));
        panJLabel.setBounds(100,440,200,30);
        add(panJLabel);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,20));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);

        JLabel aadhJLabel = new JLabel("Aadhar Number: " );
        aadhJLabel.setFont(new Font("Raleway",Font.BOLD,20));
        aadhJLabel.setBounds(100,490,200,30);
        add(aadhJLabel);

        aadhTextField = new JTextField();
        aadhTextField.setFont(new Font("Raleway",Font.BOLD,20));
        aadhTextField.setBounds(300,490,400,30);
        add(aadhTextField);

        JLabel seniorJLabel = new JLabel("Senior Citizen: " );
        seniorJLabel.setFont(new Font("Raleway",Font.BOLD,20));
        seniorJLabel.setBounds(100,540,200,30);
        add(seniorJLabel);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,60,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(420,540,80,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniGroup = new ButtonGroup();
        seniGroup.add(syes);
        seniGroup.add(sno);

        JLabel exisitJLabel = new JLabel("Exisiting Account: " );
        exisitJLabel.setFont(new Font("Raleway",Font.BOLD,20));
        exisitJLabel.setBounds(100,590,200,30);
        add(exisitJLabel);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,60,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(420,590,80,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existGroup = new ButtonGroup();
        existGroup.add(eyes);
        existGroup.add(eno);



        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);



        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new SignupTwo(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      
        String religion = (String) religiComboBox.getSelectedItem();
        String category = (String) categorComboBox.getSelectedItem();
        String income = (String) incomeComboBox.getSelectedItem();
        String education = (String) educationComboBox.getSelectedItem();
        String occupation = (String) occupationComboBox.getSelectedItem();
        String pan = panTextField.getText();
        String aadhar = aadhTextField.getText();
        String seniorCitizen = syes.isSelected() ? "Yes" : "No";
        String existingAccount = eyes.isSelected() ? "Yes" : "No";

        if(religion.equals("")){
            JOptionPane.showMessageDialog(null, "Religion is Required");
        } 
        else if(category.equals("")){
            JOptionPane.showMessageDialog(null, "Category is Required");
        } 
        else if(income.equals("")){
            JOptionPane.showMessageDialog(null, "Income is Required");
        } 
        else if(education.equals("")){
            JOptionPane.showMessageDialog(null, "Education is Required");
        } 
        else if(occupation.equals("")){
            JOptionPane.showMessageDialog(null, "Occupation is Required");
        } 
        else if(seniorCitizen.equals("")){
            JOptionPane.showMessageDialog(null, "Senior Status is Required");
        } 
        else if(existingAccount.equals("")){
            JOptionPane.showMessageDialog(null, "Exisiting Status is Required");
        }
        else if(panTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "PAN Number is Required");
        } 
        else if(aadhTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Aadhar Number is Required");
        } 
        else if(!Utilityclass.isValidPan(pan)){
            JOptionPane.showMessageDialog(null, "Invalid PAN Number");
        } 
        else if (!Utilityclass.isValidAadhaar(aadhar)){
            JOptionPane.showMessageDialog(null, "Invalid Aadhar Number");
        } 
        else {
            Conn connection = new Conn();      
            pan = panTextField.getText();
            aadhar = aadhTextField.getText();
            connection.insertToSignupTwo(formno, religion, category, income, education, occupation, pan, aadhar,seniorCitizen,existingAccount);
            // setVisible(false);
            // new SignupThree().setVisible(true);

        }
        
    }
       
}
