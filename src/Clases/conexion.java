/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.*;
import javax.swing.JComboBox;

/**
 *
 * @author Vanessa
 */
public class conexion {

    public static final String URL = "jdbc:mysql://localhost:3307/bdestacionamiento";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    PreparedStatement ps;
    ResultSet rs;

    public static Connection getConection() {
        Connection con = null;

        try {
            ///Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexion correcta");

        } catch (Exception e) {
            System.out.print(e);

        }
        return con;
    }

    public static void main(String[] args) {
        Connection con = getConection();
        if (con != null) {
            System.out.println("Conexión exitosa");
        } else {
            System.out.println("Error al conectar");
        }
    }

    public void RellenarComboBox(String tabla, String valor, JComboBox<String> combo) {
        String sql = "SELECT " + valor + " FROM " + tabla; // Selecciona solo la columna requerida
        Connection conexion = getConection();

        try (Statement st = conexion.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            // Limpia el ComboBox antes de llenarlo (opcional)
            combo.removeAllItems();

            // Rellena el ComboBox con los valores de la consulta
            while (rs.next()) {
                combo.addItem(rs.getString(valor));
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.out.println("ERROR al cerrar conexión: " + ex.getMessage());
            }
        }
    }

}

