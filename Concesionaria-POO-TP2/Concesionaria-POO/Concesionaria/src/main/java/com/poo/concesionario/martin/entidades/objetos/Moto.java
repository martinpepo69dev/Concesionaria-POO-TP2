package com.poo.concesionario.martin.entidades.objetos;

import java.util.Locale;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Moto extends Vehiculo {
    private String cilindrada;

    public Moto(String marca, String modelo, String cilindrada, double precio) {
        super(marca, modelo, precio);
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        String precioFormateado = String.format(new Locale("es", "AR"), "%,.2f", this.precio);
        return "Marca: " + marca + " // Modelo: " + modelo + " // Cilindrada: " + cilindrada + " // Precio: $" + precioFormateado;
    }
}