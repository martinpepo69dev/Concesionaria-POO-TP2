package com.poo.concesionario.martin.tests;

import com.poo.concesionario.martin.entidades.objetos.Auto;
import com.poo.concesionario.martin.entidades.objetos.Moto;
import com.poo.concesionario.martin.implementacion.Concesionaria;
import com.poo.concesionario.martin.interfaz.IConcesionaria;

public class TestIConcesionaria {
  public static void main(String[] args) {

    IConcesionaria concesionaria = new Concesionaria(); // Creamos un objeto de la clase concesionaria


    concesionaria.agregarVehiculo(new Auto("Peugeot", "206", 4, 200000.00)); 
    concesionaria.agregarVehiculo(new Moto("Honda", "Titan", "125c", 60000.00));
    concesionaria.agregarVehiculo(new Auto("Peugeot", "208", 5, 250000.00));
    concesionaria.agregarVehiculo(new Moto("Yamaha", "YBR", "160c", 80500.50));


    concesionaria.reporteConcesionaria("Y");
    
  }
}
