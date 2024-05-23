/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mostrarminiagenda;

/*
Esta es una pequeña aplicación que muestra cómo obtener los
datos de una tabla usando una consulta SELECT. Se ejecuta
desde la línea de comandos del sistema operativo y los datos
obtenidos son mostrados en la consola.
 */
import java.sql.*;

public class Mostrarminiagenda {

    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://192.168.1.140:3306/miniagenda?serverTimezone=UTC";

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM contactos");
                System.out.println("\nNOMBRE \t\t EMAIL \t\t\t TELEFONO \n");
                while (res.next()) {
                    String nombre = res.getString("nombre");
                    String email = res.getString("email");
                    String telefono = res.getString("telefono");
                    System.out.println(nombre + " \t " + email + " \t " + telefono);
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
