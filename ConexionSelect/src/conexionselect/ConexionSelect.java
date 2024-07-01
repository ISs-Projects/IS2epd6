/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionselect;

/*
Esta es una pequeña aplicación que muestra cómo obtener los
datos de una tabla usando una consulta SELECT. Se ejecuta
desde la línea de comandos del sistema operativo y los datos
obtenidos son mostrados en la consola.
 */
import java.sql.*;

public class ConexionSelect {

    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost:3306/miniagenda?serverTimezone=UTC";

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM usuarios");
                System.out.println("Conexion a DB establecida\nLogin    Password\n");
                while (res.next()) {
                    String login = res.getString("login");
                    String password = res.getString("password");
                    System.out.println(login + " \t " + password + " \t ");
                }
                res.close();
                stmt.close();
                conn.close();
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
}
