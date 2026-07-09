package configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Instancia única (Singleton)
    private static Conexion instancia;

    // Objeto Connection
    private Connection conexion;

    // Datos de conexión
    private static final String URL =
            "jdbc:mysql://srv1165.hstgr.io:3306/u484426513_patronesc226";

    private static final String USER =
            "u484426513_patronesc226";

    private static final String PASSWORD =
            "gM$QEi04";

    // Constructor privado
    private Conexion() {
        conectar();
    }

    // Crear conexión
    private void conectar() {

        try {

            // Cargar el Driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("Conexión establecida correctamente.");

        } catch (ClassNotFoundException e) {

            System.out.println("No se encontró el Driver MySQL.");

        } catch (SQLException e) {

            System.out.println("Error de conexión: " + e.getMessage());
        }
    }

    // Obtener la única instancia (Singleton)
    public static Conexion getInstancia() {

        if (instancia == null) {
            instancia = new Conexion();
        }

        return instancia;
    }

    // Obtener la conexión
    public Connection getConnection() {

        try {

            // Si la conexión se perdió, volver a conectarse
            if (conexion == null || conexion.isClosed()) {

                System.out.println("Reconectando a la base de datos...");

                conectar();
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

        return conexion;
    }

    // Verificar si existe conexión
    public boolean estaConectado() {

        try {

            return conexion != null &&
                    !conexion.isClosed();

        } catch (SQLException e) {

            return false;
        }
    }

    // Cerrar conexión
    public void cerrarConexion() {

        try {

            if (conexion != null &&
                    !conexion.isClosed()) {

                conexion.close();

                System.out.println("Conexión cerrada correctamente.");
            }

        } catch (SQLException e) {

            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

}