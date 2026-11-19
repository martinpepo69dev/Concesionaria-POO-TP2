package com.poo.concesionario.martin.tests.ejemplos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.poo.concesionario.martin.entidades.objetos.Auto;
import com.poo.concesionario.martin.entidades.objetos.Moto;
import com.poo.concesionario.martin.entidades.objetos.Vehiculo;

public class TestCollections {
    public static void main(String[] args) {

        List<Vehiculo> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(new Auto("Peugeot", "206", 4, 200000.00));
        listaVehiculos.add(new Moto("Honda", "Titan", "125c", 60000.00));
        listaVehiculos.add(new Auto("Peugeot", "208", 5, 250000.00));
        listaVehiculos.add(new Moto("Yamaha", "YBR", "160c", 80500.50));

        listaVehiculos.forEach(System.out::println);

        Collections.sort(listaVehiculos);
        listaVehiculos.forEach(System.out::println);

        Vehiculo masCaro = Collections.max(listaVehiculos);
        Vehiculo masBarato = Collections.min(listaVehiculos);

        System.out.println("Vehículo más caro: " + masCaro.getMarca() + " " + masCaro.getModelo());
        System.out.println("Vehículo más barato: " + masBarato.getMarca() + " " + masBarato.getModelo());

        Collections.reverse(listaVehiculos);
        listaVehiculos.forEach(System.out::println);

    }
}
