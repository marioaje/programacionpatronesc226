package org.example;

import controllers.CursoController;
import dao.CursoDAO;
import interfaces.CursoRepository;
import models.Curso;

public class Main {

    public static void main(String[] args) {

        CursoRepository repository = new CursoDAO();

        CursoController controller =
                new CursoController(repository);

        Curso curso = new Curso(
                0,
                "Programación en Java",
                "Curso de POO",
                "Activo",
                "Mario"
        );

        if (controller.insertarCurso(curso)) {

            System.out.println("Curso registrado.");

        } else {

            System.out.println("No fue posible registrar.");

        }

        controller.listarCursos()
                .forEach(System.out::println);

    }

}
//
//import configuracion.Conexion;
//import controllers.clientesController;
//import interfaces.CursoOperaciones;
//import models.CursoModels;
//
////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) {
//
//
//
//
//
////        CursoOperaciones objetoCurso = new CursoModels(1, "Patrones de Programacion","Activo");
////
////        objetoCurso.matricularEstudiante("Profe Mario");
////        objetoCurso.mostrarInformacion();
////        objetoCurso.cancelarCurso();
//
//        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
////        System.out.printf("Hello and welcome!");
////
////        for (int i = 1; i <= 5; i++) {
////            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
////            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
////            System.out.println("i = " + i);
////        }
//    }
//}
////Abstracion, Encapsulamiento, Herencia, Poliformismo
////Planteamiento del Problema
////
////Una cadena hotelera necesita desarrollar un sistema que permita administrar diferentes tipos de habitaciones.
////
////Todas las habitaciones comparten la siguiente información:
////
////Número de habitación.
////Tipo de habitación.
////Precio por noche.
////Estado (Disponible u Ocupada).
////
////        Sin embargo, cada tipo de habitación debe calcular su costo de hospedaje de forma diferente.
////
////El sistema debe manejar las siguientes categorías:
////Habitación Estándar
////
//Cobra únicamente el precio base por noche.
//
//Habitación Deluxe
//
//Cobra el precio base más un recargo del 15%.
//
//Suite Presidencial
//
//Cobra el precio base más un recargo del 30%.
