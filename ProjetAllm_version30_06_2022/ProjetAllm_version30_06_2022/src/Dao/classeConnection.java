package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class classeConnection {

private static Connection connection;
static {
String url= "jdbc:mysql://localhost:3306/projet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

String user="root";
String password="zineb123";
try {
Class.forName("com.mysql.cj.jdbc.Driver");

connection=DriverManager.getConnection(url, user, password);
System.out.println("connexion établie avec BD !!! ");
} catch (ClassNotFoundException e) {
e.printStackTrace();
} catch (SQLException e) {
e.printStackTrace();
}
}

public static Connection getConnection() {
return connection;
}


}



