package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) throws Exception
    {
        dropUserTable();

        createUserTable();
        int j =0;
        int k;
        int student_id;
        String temp_password = "";
        for (k = 0; k < 100; k++){
            student_id = 20000000+j;
            temp_password = "halilaltayguvenir";
            insertUser(student_id, temp_password);
            j++;
        }
    }



    public static void dropUserTable()
            throws Exception
    {
        try
        {
            Connection con = getConnection();
            PreparedStatement posted = con.prepareStatement("DROP TABLE User");
            posted.executeUpdate();
        }
        catch (Exception e) {System.out.println(e);}
        finally
        {
            System.out.println("Drop complete");
        }
    }

    public static void insertUser(int sid, String password)
            throws Exception
    {
        try
        {
            Connection con = getConnection();
            PreparedStatement posted = con.prepareStatement("INSERT INTO User"
                    + "(sid, password)"
                    + "VALUES ('" + sid + "', '" + password + "' )");
            posted.executeUpdate();
        }
        catch (Exception e) {System.out.println(e);}
        finally
        {
            System.out.println("Insert complete");
        }
    }

    public static void createUserTable()
    {
        try
        {
            Connection connection = getConnection();
            PreparedStatement userT = connection.prepareStatement("CREATE TABLE IF NOT EXISTS User( "
                    + "sid INT(8), password VARCHAR(64),"
                    + "PRIMARY KEY (sid) )"
                    + "Engine=InnoDB");
            userT.executeUpdate();
        }
        catch (Exception e) {System.out.print(e);}
        finally{System.out.println("Table created");}
    }

    public static Connection getConnection() throws Exception
    {
        try
        {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://dijkstra.ug.bcc.bilkent.edu.tr/begum_tascioglu";
            String username = "begum.tascioglu";
            String password = "3Y2HxbNq";

            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");

            return con;

        }catch(Exception e) {System.out.print(e);}

        return null;
    }

}
