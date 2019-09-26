package util;

import java.sql.*;

/**
 * Project FirstHibernate
 * Created by End on сент., 2019
 */
public class JDBCUtil {

    String url = "jdbc:mysql://localhost:3306/skill";
    String user = "root";
    String pass = "parolmysql159";
    String sql = "alter table purchaselist add id int(10) not null primary key auto_increment first;";

        Connection connection;

    {
        try {
            connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
