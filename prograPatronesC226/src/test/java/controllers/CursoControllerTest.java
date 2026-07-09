package controllers;
import interfaces.CursoRepository;
import models.Curso;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith ;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class CursoControllerTest {

    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private CursoController cursoController;


//    List<Curso> listar();
// LISTAR
//public List<Curso> listarCursos() {
//    return cursoRepository.listar();
//}
    @Test
    void listarCursos(){
        List<Curso> listaCursos = new ArrayList<>();


//        Estos datos pasan a ser temporales en la base de datos, pero sin alterar la base de datos
        listaCursos.add(new Curso(
                1,
                "java Programacion Patrones",
                "Programacion avanzda",
                "activo",
                "Profe Mario"
        ));

        listaCursos.add(new Curso(
                2,
                "java Patrones",
                "avanzda",
                "disponible",
                "Profe Mario"
        ));

        when(cursoRepository.listar()).thenReturn(listaCursos);

        List<Curso> cursosResultado = cursoController.listarCursos();

        assertEquals(2, cursosResultado.size());

        verify(cursoRepository, times(1)).listar();

//
//    public Curso(int id, String nombre, String descripcion, String estado, String usuario) {
//            this.id = id;
//            this.nombre = nombre;
//            this.descripcion = descripcion;
//            this.estado = estado;
//            this.usuario = usuario;
//        }
    }
    @Test
    void buscarCurso(){
        Curso curso = new Curso(
                1,
                "java Programacion Patrones",
                "Programacion avanzda",
                "activo",
                "Profe Mario"
        );
//        Curso buscarPorId(int id)
        when(cursoRepository.buscarPorId(1)).thenReturn(curso);

        Curso resultado = cursoController.buscarCurso(1);

        assertNotNull(resultado);

        assertEquals(1, resultado.getId());
        assertEquals("java Programacion Patrones", resultado.getNombre());
        assertEquals("Programacion avanzda", resultado.getDescripcion());
        assertEquals("activo", resultado.getEstado());
        assertEquals("Profe Mario", resultado.getUsuario());

    }

//
//    // BUSCAR
//    public Curso buscarCurso(int id) {
//
//        if (id <= 0) {
//            System.out.println("ID inválido.");
//            return null;
//        }
//
//        return cursoRepository.buscarPorId(id);
//    }
}
