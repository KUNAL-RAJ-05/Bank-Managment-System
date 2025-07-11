package bankmanagmentsystem;

import java.sql.*;

public class Conn {

    Connection c;
    String url = "jdbc:mysql:///bankmanagementsystem";
    String username = "root";
    String password = "Kunal@123";
    Statement s;

    public Conn()
    {
        try{
           
            c=DriverManager.getConnection(url, username, password);
            s=c.createStatement();

        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
