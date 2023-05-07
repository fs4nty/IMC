package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/imc_definitivo?autoReconnect=true&useSSL=false";
    private Connection con;
    
    
    public Conexion() {
        con = null;
    }

    public Connection getConnection() {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
//            JOptionPane.showMessageDialog(null, "Conexion exitosa. ");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexion. " + e);
            System.exit(0);
        }
        return con;
    }
    
    public void close(){
        try {
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexion con la DB. " + e);
        }
    }
}
