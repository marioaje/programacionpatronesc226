package models;

public class habitacionEstandar extends habitacion {

    //Habitación Estándar
//
//Cobra únicamente el precio base por noche.
//

    public habitacionEstandar(int numeroHabitacion, String nombreHabitacion, double precioBase, String estado) {
        super(numeroHabitacion, nombreHabitacion, precioBase, estado, "Habitacion Estandar");
    }


    //@Override
    //POdrian crear la funcion de calculo de la habitacion calculoHospedaje()
}
