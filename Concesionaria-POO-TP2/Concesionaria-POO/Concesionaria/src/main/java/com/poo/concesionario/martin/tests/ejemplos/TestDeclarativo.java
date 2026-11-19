package com.poo.concesionario.martin.tests.ejemplos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.poo.concesionario.martin.entidades.objetos.Auto;
import com.poo.concesionario.martin.entidades.objetos.Moto;
import com.poo.concesionario.martin.entidades.objetos.Vehiculo;

public class TestDeclarativo {
        public static void main(String[] args) {

                List<Vehiculo> listaVehiculos = new ArrayList<>();
                listaVehiculos.add(new Auto("Peugeot", "206", 4, 200000.00));
                listaVehiculos.add(new Moto("Honda", "Titan", "125c", 60000.00));
                listaVehiculos.add(new Auto("Peugeot", "208", 5, 250000.00));
                listaVehiculos.add(new Moto("Yamaha", "YBR", "160c", 80500.50));

                System.out.println(" ");
                listaVehiculos.forEach(System.out::println);

                System.out.println(" ");
                System.out.println(
                                "=============================");
                System.out.println(" ");
                // min y max pertenecen a la clase Collections y se pueden usar para encontrar
                // el vehículo más caro y el más barato en la lista de vehículos.
                Vehiculo vehiculoMasCaro = listaVehiculos.stream()
                                .max(Comparator.comparingDouble(Vehiculo::getPrecio))
                                .orElse(null);

                System.out.println(
                                "Vehículo más caro: " + vehiculoMasCaro.getMarca() + " " + vehiculoMasCaro.getModelo());

                Vehiculo vehiculoMasBarato = listaVehiculos.stream()
                                .min(Comparator.comparingDouble(Vehiculo::getPrecio))
                                .orElse(null);

                System.out.println("Vehículo más barato: " + vehiculoMasBarato.getMarca() + " "
                                + vehiculoMasBarato.getModelo());

                for (Vehiculo v : listaVehiculos) {
                        if (v.getModelo().toUpperCase().contains("Y")) {
                                System.out.println("Vehículo que contiene en el modelo la letra 'Y': " + v.getMarca()
                                                + " " + v.getModelo() + " $" + v.getPrecio());
                        }
                }

                System.out.println(" ");
                System.out.println(
                                "=============================");
                System.out.println(" ");
                System.out.println("Vehículos ordenados por precio de mayor a menor:");
                listaVehiculos.stream() // recorra la lista de vehículos
                                .sorted((v1, v2) -> Double.compare(v2.getPrecio(), v1.getPrecio())) // ordena de mayor amenor según el precio es decir recibe argumentos
                                                                                                    // v1 y v2 y compara sus precios
                                .map(v -> v.getMarca() + " " + v.getModelo()) // mapea
                                .forEach(System.out::println);

                System.out.println(" ");
                System.out.println(
                                "=============================");
                System.out.println(" ");

                System.out.println("Vehículos ordenados por orden natural (marca, modelo, precio):");
                listaVehiculos.stream()
                                .sorted()
                                .forEach(System.out::println);
             
                                
        }
}
