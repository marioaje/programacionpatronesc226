package models;

public class habitacion {

    private int numeroHabitacion;
    private String nombreHabitacion;
    private double precioBase;
    private String estado;
    private String tipoHabitacion;

    public habitacion(int numeroHabitacion, String nombreHabitacion, double precioBase, String estado, String tipoHabitacion){
        this.numeroHabitacion = numeroHabitacion;
        this.nombreHabitacion = nombreHabitacion;
        this.precioBase = precioBase;
        this.estado = estado;
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getNombreHabitacion() {
        return nombreHabitacion;
    }

    public void setNombreHabitacion(String nombreHabitacion) {
        this.nombreHabitacion = nombreHabitacion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }


    //una funcion que muestre toda la informacion
//Número de habitación.
//Tipo de habitación.
//Precio por noche.
//Estado (Disponible u Ocupada).

}
