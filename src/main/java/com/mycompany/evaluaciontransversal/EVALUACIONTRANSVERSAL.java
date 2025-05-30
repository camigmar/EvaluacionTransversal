package com.mycompany.evaluaciontransversal;

import java.util.Scanner;
import java.util.ArrayList;

public class EVALUACIONTRANSVERSAL {

    final private static ArrayList<String> asientosDisponibles = new ArrayList<>();
    final private static ArrayList<String> descuentos = new ArrayList<>();
    final private static ArrayList<String> entrada1 = new ArrayList<>();
    final private static ArrayList<String> entrada2 = new ArrayList<>();

    static int vip = 15000;
    static int cancha = 12000;
    static int platea = 10000;
    static int cantidadEntradas = 0;
    static int valorEntradaUno;
    static int valorEntradaDos;
    static double valorFinal;
    static int otraEntrada;
    static int ubicacionSel;
    static int ubicacionSelDos;
    

    private static void completarasientos() {
        for (int i = 1; i < 21; i++) {
            asientosDisponibles.add("A" + i);
            asientosDisponibles.add("B" + i);
            asientosDisponibles.add("C" + i);
            asientosDisponibles.add("D" + i);
        }
    }

    private static void mostrarDisponibilidad() {

        System.out.println("... ASIENTOS DISPONIBLES ...");

        if (asientosDisponibles.isEmpty()) {
            System.out.println("No hay asiento disponibles");
        } else {
            for (int i = 1; i <= 20; i++) {
                String fila = "";

                for (char letra = 'A'; letra <= 'D'; letra++) {
                    String muestraAsiento = letra + String.valueOf(i);

                    if (asientosDisponibles.contains(muestraAsiento)) {
                        fila += muestraAsiento + " - ";
                    } else {
                        fila += "XX - ";
                    }
                }

                if (fila.endsWith(" - ")) {
                    fila = fila.substring(0, fila.length() - 3);
                }
                System.out.println(fila);

            }
        }
    }
    
    private static void comprarEntrada(Scanner sc){
        
        if (cantidadEntradas > 0) {
            System.out.println("USTED YA COMRPO ENTRADAS. SELECIONE OPCION 2 O 3");
            return;
        }
        
        entrada1.add(0, "ENTRADA N°1");
        while(true){
            
            System.out.println("1.- Vip");
            System.out.println("2.- Platea");
            System.out.println("3.- Cancha");

            System.out.println("Ingrese el numero del tipo de entrada que desea seleccionar:");
            ubicacionSel = sc.nextInt();
            sc.nextLine();

            if(ubicacionSel >= 1 && ubicacionSel <= 3){
                break;
            }else{
                System.out.println("ERROR. NUMERO INGRESADO NO VALIDO");
            }
        }
        
        switch (ubicacionSel) {
            case 1:
                entrada1.add(1,"Ubicacion: Vip");
                valorEntradaUno = vip;
                break;
            case 2:
                entrada1.add(1, "Ubicacion: Platea");
                valorEntradaUno = platea;
                break;
            case 3:
                entrada1.add(1, "Ubicacion: Cancha");
                valorEntradaUno = cancha;
                break;
        }
        
        mostrarDisponibilidad();
        
        String asientoSel;

        
        while(true){
            
            System.out.println("Ingrese el asiento que quiere seleccionar");
            asientoSel = sc.nextLine().toUpperCase();
            if (asientosDisponibles.contains(asientoSel)) {
                entrada1.add(2,"Asiento: " + asientoSel);
                asientosDisponibles.remove(asientoSel); 
                System.out.println("Asiento correctamente reservado: " + asientoSel);
                break;
            } else {
                System.out.println("Asiento no disponible o inexistente.");
                continue;
            }
        }
        
        System.out.println("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        
        entrada1.add(3, "Nombre: " + nombre);
        
        cantidadEntradas ++;
        
        while (true){
            System.out.println("¿Desea reservar otra entrada? (RECUERDA QUE SON UN MAXIMO DE 2 ENTRADAS POR COMPRA)");
            System.out.println("1. SI");
            System.out.println("2. NO");
            otraEntrada = sc.nextInt();
            sc.nextLine();
            
            if (otraEntrada == 1 || otraEntrada == 2){
                break;
            }else{
            System.out.println("Error. SELECCIÓN INCORRECTA. Intente de nuevo.");
            }
        }
        
        switch (otraEntrada) {
                case 1:
                    entrada2.add(0, "ENTRADA N°2");
                    
                    while(true){

                        System.out.println("1.- Vip");
                        System.out.println("2.- Platea");
                        System.out.println("3.- Cancha");

                        System.out.println("Ingrese el numero del tipo de entrada que desea seleccionar:");
                        ubicacionSelDos = sc.nextInt();
                        sc.nextLine();

                        if(ubicacionSelDos >= 1 && ubicacionSelDos <= 3){
                            break;
                        }else{
                            System.out.println("ERROR. NUMERO INGRESADO NO VALIDO");
                        }
                    }
                    
                    switch (ubicacionSelDos) {
                        case 1:
                            entrada2.add(1,"Ubicacion: Vip");
                            valorEntradaDos = vip;
                            break;
                        case 2:
                            entrada2.add(1, "Ubicacion: Platea");
                            valorEntradaDos = platea;
                            break;
                        case 3:
                            entrada2.add(1, "Ubicacion: Cancha");
                            valorEntradaDos = cancha;
                            break;
                    }
                    
                    mostrarDisponibilidad();
                    
                    String asientoSelDos;
                    
                    while (true){
                        System.out.println("Seleccione su asiento: ");
                        asientoSelDos = sc.nextLine().toUpperCase();
                        if (asientosDisponibles.contains(asientoSelDos)) {
                            entrada2.add(2, "Asiento: " + asientoSelDos);
                            asientosDisponibles.remove(asientoSelDos); 
                            System.out.println("Asiento correctamente reservado: " + asientoSelDos);
                            break;
                        } else {
                            System.out.println("Asiento no disponible o inexistente.");
                        }        
                    }


                    System.out.println("Ingrese su nombre: ");
                    String nombreDos = sc.nextLine();
                    
                    entrada2.add(3, "Nombre: " + nombreDos);
                    
                    cantidadEntradas++;

                    valorFinal = valorEntradaUno + valorEntradaDos;

                    System.out.println("Ingrese su edad");
                    int edad = sc.nextInt();
                    
                    if (edad > 60){
                        descuentos.add("Descuento tercera edad");
                        valorFinal = valorFinal * 0.75;
                    } else if (edad < 13){
                        descuentos.add("Descuento niño (Hasta 12 años)");
                        valorFinal = valorFinal * 0.9;
                    }
                    
                    while(true){
                        System.out.println("¿Es estudiante?");
                        System.out.println("1.- SI");
                        System.out.println("2.- NO");

                        int estudiante = sc.nextInt(); 
                        
                        if (estudiante == 1){
                            descuentos.add("Descuento estudiante");
                            valorFinal = valorFinal * 0.85;
                            break;
                        }else if (estudiante == 2){
                            break;
                        }else{
                            System.out.println("ERROR. Ingrese correctamente la opcion");
                        }
                    }
                    
                    while (true){
                        System.out.println("¿Es mujer?");
                        System.out.println("1.- Si");
                        System.out.println("2.- No");
                        
                        int genero = sc.nextInt();
                        
                        if (genero == 1){
                            descuentos.add("Descuento día de la mujer");
                            valorFinal = valorFinal * 0.8;
                            break;
                        }else if (genero == 2){
                            break;
                        }else{
                            System.out.println("ERROR. Ingrese correctamente la opcion");
                        }
                        
                    }
                    
                    
                    System.out.println("TOTAL PAGAR: " + valorFinal);

                    System.out.println("El cargo se ha hecho a su tarjeta con exito.");
                    System.out.println("¡MUCHAS GRACIAS POR TU COMPRA!");
                    break;
                   

                case 2:
                    valorFinal = valorEntradaUno;
                    System.out.println("Ingrese su edad");
                    
                    int edadCase2 = sc.nextInt();
                    
                    if (edadCase2 > 60){
                        descuentos.add("Descuento tercera edad");
                        valorFinal = valorFinal * 0.75;
                    } else if (edadCase2 < 13){
                        descuentos.add("Descuento niño (Hasta 12 años)");
                        valorFinal = valorFinal * 0.9;
                    }
                    
                    while(true){
                        System.out.println("¿Es estudiante?");
                        System.out.println("1.- SI");
                        System.out.println("2.- NO");

                        int estudianteCase2 = sc.nextInt(); 
                        
                        if (estudianteCase2 == 1){
                            descuentos.add("Descuento estudiante");
                            valorFinal = valorFinal * 0.85;
                            break;
                        }else if (estudianteCase2 == 2){
                            break;
                        }else{
                            System.out.println("ERROR. Ingrese correctamente la opcion");
                        }
                    }
                    
                    while (true){
                        System.out.println("¿Es mujer?");
                        System.out.println("1.- Si");
                        System.out.println("2.- No");
                        
                        int generoCase2 = sc.nextInt();
                        
                        if (generoCase2 == 1){
                            descuentos.add("Descuento día de la mujer");
                            valorFinal = valorFinal * 0.8;
                            break;
                        }else if (generoCase2 == 2){
                            break;
                        }else{
                            System.out.println("ERROR. Ingrese correctamente la opcion");
                        }
                        
                    }
                    
                    
                    System.out.println("TOTAL PAGAR: " + valorFinal);

                    System.out.println("El cargo se ha hecho a su tarjeta con exito.");
                    System.out.println("¡MUCHAS GRACIAS POR TU COMPRA!");

                    break;
        }
    }
    
    private static void generarBoleta(){
        System.out.println("----------------------");
        System.out.println("  BOLETA TEATRO MORO  ");
        System.out.println("----------------------");
        
        for (String boletoUno: entrada1){
            System.out.println(boletoUno);
        }
        
        if(cantidadEntradas == 2){
            for (String boletoDos: entrada2){
                System.out.println(boletoDos);
            }
        }
        
        System.out.println("...:: PAGO ::...");
        System.out.println("Descuentos aplicados: ");
        if (descuentos.isEmpty()){
            System.out.println("No se le aplicaron descuentos");
        }else{
            for (String bajaPrecio: descuentos){
                System.out.println(bajaPrecio);
            }
        }
        
        System.out.println("TOTAL PAGADO: " + valorFinal);
    }
        

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        completarasientos();
        
        int variable = -1;
        
        while (variable != 0){
            System.out.println("---------MENÚ---------");
            System.out.println("1.- Comprar entrada");
            System.out.println("2.- Generar boleta");
            System.out.println("3.- Salir");
            
            System.out.println("Ingresa el numero de una opcion");
            int opcion = sc.nextInt();
            sc.nextLine();

            if (opcion < 1 || opcion > 3){
                System.out.println("ERROR. INGRESE CORRECTAMENTE EL NUMERO");
                continue;
            }
            
            switch (opcion) {
                case 1:                   
                    comprarEntrada(sc);                  
                    break;
                case 2:
                    generarBoleta();
                    break;
                case 3: 
                    System.out.println("¡HASTA LUEGO!");
                    System.exit(0);                    
                    break;                   
              
            }
            
            
        }
    }
}





    

