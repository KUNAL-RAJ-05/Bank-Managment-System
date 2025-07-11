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
    public static void main(String[] args) {
        new Conn();
    }
}
