
import java.io.*;
import java.sql.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by cassandra on 15/7/21.
 */
public class m {
    public static void main(String[] args) throws IOException {

        System.out.println(new Date());
        //read config file
        String file  = System.getProperty("user.dir")+"/config.ini";
        String line = null;
        //String.valueOf(m.class.getResource(""));
        System.out.println(file);
        try {
            BufferedReader readerconfig = new BufferedReader(new FileReader(file));
            line  = readerconfig.readLine();
            System.out.println(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //read user input
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Username:");
        String username="";
        try {
            username = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("Password:");
        String password="";
        try {
            password = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //config
        //String connstr = "jdbc:mysql://127.0.0.1/mysql";
        String driver = "org.mariadb.jdbc.Driver";
        Connection connection = null;

        //init jar driver
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(line, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //sps insert
        try {
            String sql = "insert into USER SET USER =?,HOST=?";
            PreparedStatement preparedStatement =  connection.prepareStatement(sql);
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2,"TEST");
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // data reader
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select host,user,password from user;");
            while (rs.next()) {
                System.out.println(
                        String.format("%-15s", rs.getString(1)) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
            }
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //close

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

