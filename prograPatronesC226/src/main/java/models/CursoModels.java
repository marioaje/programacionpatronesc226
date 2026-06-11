package models;

import interfaces.CursoOperaciones;

public class CursoModels implements CursoOperaciones {

    private int id;
    private String nombre;
    private String estado;

    public CursoModels(int id, String nombre, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public void matricularEstudiante(String nombre){
        System.out.println("El estudiante: "+ nombre + " fue matriculado");
    }
    @Override
    public void cancelarCurso(){
        System.out.println("El Curso fue cancelado  ");
    }
    @Override
    public void mostrarInformacion(){
        System.out.println( getNombre() );
        System.out.println(getEstado());

    }

    //    void matricularEstudiante(String nombre);
//
//    void cancelarCurso();
//
//    void mostrarInformacion();
}
