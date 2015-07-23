
import java.sql.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by cassandra on 15/7/21.
 */
public class m {
    public static void main(String[] args) {
        System.out.println(new Date());

        //config
        String connstr = "jdbc:mysql://127.0.0.1/mysql";
        String driver = "org.mariadb.jdbc.Driver";
        String user = "root";
        String password = "123456";
        Connection connection = null;

        //init jar driver
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(connstr, user, password);
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

