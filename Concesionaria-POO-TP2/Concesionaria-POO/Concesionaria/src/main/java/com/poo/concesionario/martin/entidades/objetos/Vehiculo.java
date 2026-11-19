package com.poo.concesionario.martin.entidades.objetos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public abstract class Vehiculo implements Comparable<Vehiculo> {
    public String marca;
    public String modelo;
    public double precio;

    // El método compareTo define el orden natural de la clase Vehiculo
    // Si arroja "0" son iguales

    @Override
    public int compareTo(Vehiculo otro) {
        // 1. Primer criterio: Marca (alfabético)
        int compMarca = this.marca.compareTo(otro.marca);
        if (compMarca != 0) { // if (compMarca != 0): Si el resultado no es cero, significa que las marcas son
                              // distintas (por ejemplo, "Ford" vs "Peugeot")
            return compMarca;
        }

        // 2. Segundo criterio: Modelo (alfabetico , desempata cuando la marca es igual,
        // ej. Peugeot 206 vs 208) ; El código solo llega hasta acá si compMarca fue 0-
        int compModelo = this.modelo.compareTo(otro.modelo);
        if (compModelo != 0) {
            return compModelo;
        }

        // 3. Tercer criterio: Precio (desempata si marca y modelo son idénticos)
        return Double.compare(this.precio, otro.precio);
    }
}