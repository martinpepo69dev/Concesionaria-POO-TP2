package com.poo.concesionario.martin.entidades.objetos;

import java.util.Locale;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Auto extends Vehiculo {
    private int puertas;

    public Auto(String marca, String modelo, int puertas, double precio) {
        super(marca, modelo, precio);
        this.puertas = puertas;
    }

    @Override
    public String toString() {
        String precioFormateado = String.format(new Locale("es", "AR"), "%,.2f", this.precio);
        return "Marca: " + marca + " // Modelo: " + modelo + " // Puertas: " + puertas + " // Precio: $"
                + precioFormateado;
    }

}