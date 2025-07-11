package database;

import java.sql.*;

public class Conn {

    Connection c;
    String url = "jdbc:mysql:///bankmanagementsystem";
    String username = "root";
    String password = "Kunal@123";

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
    {  
        try{

            String sql = "SELECT MAX(formno) AS max_formno FROM signup";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
               return rs.getInt("max_formno") +1;
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
            }else{
                System.out.println("Failed to insert personal data");
            }
            
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }
    }
}
