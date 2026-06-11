package dao;

import configuracion.Conexion;

import java.sql.Connection;

public class clientesDAO {
    //Objeto acceso de datos con una tabla que se llame clientes

    private Connection conexion;

    public clientesDAO() {
        conexion = Conexion.getInstancia().getConexion();
    }
}
