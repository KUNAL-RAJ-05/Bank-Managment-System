package database;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class Conn {

    Map<String, String> env = loadEnvFile("D:\\DSA\\Bank Managment System\\src\\database\\.env");
    Connection c;
    String url = env.get("DB_URL");
    String username = env.get("DB_USER");
    String password = env.get("DB_PASS");

    public Conn()
    {
        try{
           
            c=DriverManager.getConnection(url, username, password);

        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public int getFormno()
    {  ResultSet rs;
        try{
            
            String sql = "SELECT MAX(formno) AS max_formno FROM signup";
            PreparedStatement ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next())
            {
               return Math.max(rs.getInt("max_formno") +1,1000 );
            }

        }catch(SQLException s)
        {
            System.out.println(s.getMessage());
        }
        return 1000;
    }
    public void insertToSignup(int formno, String name, String fname, Date sqlDob, String gender, String email, String marital, String address, String city,String state, String pin) 
    {   
        try {
            c.setAutoCommit(false);
            String query = "INSERT INTO signup (formno, name, father_name, dob, gender, email, marital_status, address, city, state, pin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = c.prepareStatement(query);

            ps.setInt(1, formno);
            ps.setString(2, name);
            ps.setString(3, fname);
            ps.setDate(4, sqlDob);
            ps.setString(5, gender);
            ps.setString(6, email);
            ps.setString(7, marital);
            ps.setString(8, address);
            ps.setString(9, city);
            ps.setString(10, state);
            ps.setString(11, pin);

            int rowsaffected = ps.executeUpdate();
            
            if(rowsaffected > 0) {
                System.out.println("Sccuessfully inserted personal data");
                c.commit();
            }else{
                System.out.println("Failed to insert personal data");
            }
            
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }
    }
    public static Map<String, String> loadEnvFile(String filePath) {
        Map<String, String> envVars = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue; // skip empty and comment lines

                if (line.contains("=")) {
                    String[] parts = line.split("=", 2);
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    envVars.put(key, value);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading .env file: " + e.getMessage());
        }

        return envVars;
    }
    public void insertToSignupTwo(int formno, String religion, String category, String income, String education, String occupation, String pan, String aadhar, String seniorCitizen, String existingAccount) {
        try {
            c.setAutoCommit(false);
            String query = "INSERT INTO signuptwo (formno, religion, category, income, education, occupation, pan, aadhar, senior_citizen, existing_account) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = c.prepareStatement(query);

            ps.setInt(1, formno);
            ps.setString(2, religion);
            ps.setString(3, category);
            ps.setString(4, income);
            ps.setString(5, education);
            ps.setString(6, occupation);
            ps.setString(7, pan);
            ps.setString(8, aadhar);
            ps.setString(9, seniorCitizen);
            ps.setString(10, existingAccount);

            int rowsaffected = ps.executeUpdate();
            
            if(rowsaffected > 0) {
                System.out.println("Sccuessfully inserted additional data");
                c.commit();
            }else{
                System.out.println("Failed to insert additional data");
            }
            
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }
    }
    public void isnertToSignupThree(String card,String pin,String acc,int form){
        try {
            String query = "INSERT INTO signupthree (card_number,pin_number,account_type,formno) VALUES (? , ? ,? ,? )";
            c.setAutoCommit(false);
            PreparedStatement ps = c.prepareStatement(query);

            ps.setString(1, card);
            ps.setString(2, pin);
            ps.setString(3, acc);
            ps.setInt(4, form);

            int rows = ps.executeUpdate();
            if(rows > 0) {
                System.out.println("complete one");
                c.commit();
             } else System.out.println("failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void isnertToFacility(String card,boolean atm,boolean internet,boolean mobile,boolean email,boolean cheque,boolean estate){
        try {
            String query = "INSERT INTO facility (card_number,atm_card,internet_banking,mobile,email_alerts,cheque,E_statement) VALUES (? , ? ,? ,? ,? ,? ,?)";
            c.setAutoCommit(false);
            PreparedStatement ps = c.prepareStatement(query);

            ps.setString(1, card);
            ps.setBoolean(2, atm);
            ps.setBoolean(3, internet);
            ps.setBoolean(4, mobile);
            ps.setBoolean(5, email);
            ps.setBoolean(6, cheque);
            ps.setBoolean(7, estate);


            int rows = ps.executeUpdate();
            if(rows > 0) {
                System.out.println("complete two");
                c.commit();
             } else System.out.println("failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Conn();
    }
    public boolean checkDetails(String cardnumber, String pin) {
        try {
            
            String query = "Select card_number as card,pin_number as pins from signupthree where card_number = ? and pin_number = ?";
            PreparedStatement ps = c.prepareStatement(query);
    
            ps.setString(1, cardnumber);
            ps.setString(2, pin);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
               return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }
    public void transact(String cardnumber, String pinnumber, int number, String type) {
       try {
        c.setAutoCommit(false);
        String query = "Insert into Transaction(card_number,pin_number,amount,type) VALUES (?,?,?,?)";
        PreparedStatement ps = c.prepareStatement(query);

        ps.setString(1, cardnumber);
        ps.setString(2, pinnumber);
        ps.setInt(3, number);
        ps.setString(4, type);

        int rows = ps.executeUpdate();
            if(rows > 0) {
                System.out.println("Sccussfull Transaction");
                c.commit();
             } else System.out.println("failed");

       } catch (SQLException e) {

        System.out.println(e.getMessage());

       }
    }
    public void updateBalance(String card_number,int amount,String type){
        try{
            c.setAutoCommit(false);
            String dep = "UPDATE balance SET bal = bal + ? WHERE card_number = ?";
            String with = "UPDATE balance SET bal = bal - ? WHERE card_number = ?";
            PreparedStatement ps;

            if(type.equals("deposit")){
                ps = c.prepareStatement(dep);
            }else {
                ps = c.prepareStatement(with);
            }

            ps.setInt(1, amount);
            ps.setString(2, card_number);

            int rows = ps.executeUpdate();

            if(rows > 0){
                System.out.println("Sccessfull Updated Balance");
                c.commit();
            }else System.out.println("Failed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public int getBalance(String card_number){
        int bal = 0;
        try{
            
            c.setAutoCommit(false);
            String query = "SELECT bal AS amount FROM balance WHERE card_number = ?";
            PreparedStatement ps = c.prepareStatement(query);

            ps.setString(1, card_number);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                bal = rs.getInt("amount");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return bal;
    }
    public void insertAccount(String cardNumber) {
        try {

            c.setAutoCommit(false);
            String query= "INSERT INTO balance (card_number) VALUES (?)";
            PreparedStatement ps = c.prepareStatement(query);

            ps.setString(1, cardNumber);
            

            int rows = ps.executeUpdate();

            if(rows > 0){
                System.out.println("Sccessfull Added Acount to Database");
                c.commit();
            }else System.out.println("Failed to add to database");

        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }
    }
    public void updatePin(String cardnumber,String newpin){
        try {
            c.setAutoCommit(false);
            
            String q1 = "UPDATE signupthree SET pin_number = ? where card_number = ?";
            String q2 = "UPDATE Transaction SET pin_number = ? WHERE card_number = ?";

            PreparedStatement ps1 = c.prepareStatement(q1);
            PreparedStatement ps2 = c.prepareStatement(q2);

            ps1.setString(1, newpin);
            ps1.setString(2, cardnumber);

            ps2.setString(1, newpin);
            ps2.setString(2, cardnumber);

            int r1 = ps1.executeUpdate();
            int r2 = ps2.executeUpdate();

            if(r1 > 0 && r2 > 0){
                System.out.println("Sccessfully updates PIN");
                c.commit();
            }else{
                System.out.println("Failed to update pin");
            }
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
