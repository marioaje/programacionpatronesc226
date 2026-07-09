package controllers;

import interfaces.CursoRepository;
import models.Curso;

import java.util.List;

public class CursoController {

    private final CursoRepository cursoRepository;

    // Inyección de dependencias
    public CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    // INSERTAR
    public boolean insertarCurso(Curso curso) {

        if (curso == null) {
            System.out.println("El curso no puede ser nulo.");
            return false;
        }

        if (curso.getNombre() == null || curso.getNombre().trim().isEmpty()) {
            System.out.println("El nombre es obligatorio.");
            return false;
        }

        if (curso.getDescripcion() == null || curso.getDescripcion().trim().isEmpty()) {
            System.out.println("La descripción es obligatoria.");
            return false;
        }

        if (curso.getEstado() == null || curso.getEstado().trim().isEmpty()) {
            System.out.println("El estado es obligatorio.");
            return false;
        }

        if (curso.getUsuario() == null || curso.getUsuario().trim().isEmpty()) {
            System.out.println("El usuario es obligatorio.");
            return false;
        }

        return cursoRepository.insertar(curso);
    }

    // ACTUALIZAR
    public boolean actualizarCurso(Curso curso) {

        if (curso == null) {
            return false;
        }

        if (curso.getId() <= 0) {
            System.out.println("El ID debe ser mayor que cero.");
            return false;
        }

        return cursoRepository.actualizar(curso);
    }

    // ELIMINAR
    public boolean eliminarCurso(int id) {

        if (id <= 0) {
            System.out.println("ID inválido.");
            return false;
        }

        return cursoRepository.eliminar(id);
    }

    // BUSCAR
    public Curso buscarCurso(int id) {

        if (id <= 0) {
            System.out.println("ID inválido.");
            return null;
        }

        return cursoRepository.buscarPorId(id);
    }

    // LISTAR
    public List<Curso> listarCursos() {
        return cursoRepository.listar();
    }

}