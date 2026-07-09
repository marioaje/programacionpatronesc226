package interfaces;

import models.Curso;

import java.util.List;

public interface CursoRepository {

    // CRUD

    boolean insertar(Curso curso);

    boolean actualizar(Curso curso);

    boolean eliminar(int id);

    Curso buscarPorId(int id);

    List<Curso> listar();

}