package configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Conexion instancia;
    private Connection conexion;

    private final String URL = "jdbc:mysql://srv1165.hstgr.io:3306/u484426513_patronesc226";

    private final String USER = "u484426513_patronesc226";

    private final String PASSWORD = "gM$QEi04";

    //Constructor privado
    private Conexion() {
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }

    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }

        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void cerrarConexion() {
        try {
            if ( conexion != null  && !conexion.isClosed()) {
                conexion.close();

                System.out.println("Conexion cerrada");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }

    public boolean estaConectado() {
        try {
            return conexion != null && !conexion.isClosed();

        } catch (SQLException e) {
            return false;
        }
    }

    //De aca para abajo va el singleton

//    srv1165.hstgr.io
//            u484426513_patronesc226
//    gM$QEi04
}
