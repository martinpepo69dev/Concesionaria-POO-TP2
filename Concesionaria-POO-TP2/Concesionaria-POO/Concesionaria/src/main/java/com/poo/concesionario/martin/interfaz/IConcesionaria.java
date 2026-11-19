package com.poo.concesionario.martin.interfaz;

import com.poo.concesionario.martin.entidades.objetos.Vehiculo;

public interface IConcesionaria {
    
    // Los metodos son void por que la unica mision que tienen es mostrar información en la consola, no guardan ningun resultado ni modifican.

    void agregarVehiculo(Vehiculo vehiculo); 

    void reporteConcesionaria(String letra);

    void buscarPorLetra(String letra);

    void mostrarVehiculoMasCaro();

    void mostrarVehiculoMasBarato();

    void mostrarLista();

    void mostrarListaNatural();

    void ordenadosPorPrecio();

}