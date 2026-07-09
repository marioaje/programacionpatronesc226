package dao;

import configuracion.Conexion;
import interfaces.CursoRepository;
import models.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO implements CursoRepository {

    private Connection conexion;

    public CursoDAO() {
        conexion = Conexion.getInstancia().getConnection();
    }

    // INSERTAR
    @Override
    public boolean insertar(Curso curso) {

        String sql = "INSERT INTO curso(nombre, descripcion, estado, usuario) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, curso.getNombre());
            ps.setString(2, curso.getDescripcion());
            ps.setString(3, curso.getEstado());
            ps.setString(4, curso.getUsuario());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println("Error al insertar: " + e.getMessage());
            return false;
        }
    }

    // ACTUALIZAR
    @Override
    public boolean actualizar(Curso curso) {

        String sql = "UPDATE curso SET nombre=?, descripcion=?, estado=?, usuario=? WHERE id=?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, curso.getNombre());
            ps.setString(2, curso.getDescripcion());
            ps.setString(3, curso.getEstado());
            ps.setString(4, curso.getUsuario());
            ps.setInt(5, curso.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    // ELIMINAR
    @Override
    public boolean eliminar(int id) {

        String sql = "DELETE FROM curso WHERE id=?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }

    // BUSCAR POR ID
    @Override
    public Curso buscarPorId(int id) {

        String sql = "SELECT * FROM curso WHERE id=?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new Curso(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("descripcion"),
                            rs.getString("estado"),
                            rs.getString("usuario")
                    );
                }
            }

        } catch (SQLException e) {

            System.out.println("Error al buscar: " + e.getMessage());
        }

        return null;
    }

    // LISTAR TODOS
    @Override
    public List<Curso> listar() {

        List<Curso> lista = new ArrayList<>();

        String sql = "SELECT * FROM curso ORDER BY id";

        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Curso curso = new Curso(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("estado"),
                        rs.getString("usuario")
                );

                lista.add(curso);
            }

        } catch (SQLException e) {

            System.out.println("Error al listar: " + e.getMessage());
        }

        return lista;
    }

    // CERRAR CONEXIÓN
    public void cerrarConexion() {
        Conexion.getInstancia().cerrarConexion();
    }
}