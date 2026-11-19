
package com.poo.concesionario.martin.implementacion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.poo.concesionario.martin.entidades.objetos.Vehiculo;
import com.poo.concesionario.martin.interfaz.IConcesionaria;

// Creamos una clase que implemente la interfaz y ademas sera la que determinara la logica de cada firma de metodo. 

public class Concesionaria implements IConcesionaria {
    private List<Vehiculo> vehiculos; // Atributo : cada vez que se quiera crear un concesionario este debera incluir
                                      // una lista de objetos del tipo vehiculo

    public Concesionaria() { // Constructor : comienza una lista vacia nueva
        this.vehiculos = new ArrayList<>();
    }

    @Override // Metodo que obtiene todos los resultados de la consigna:
    public void reporteConcesionaria(String letraBuscada) {
        System.out.println(" ");
        System.out.println(" ");
        mostrarLista();
        System.out.println(" ");
        System.out.println("=============================");
        System.out.println(" ");
        mostrarVehiculoMasCaro();
        mostrarVehiculoMasBarato();
        buscarPorLetra(letraBuscada);
        System.out.println(" ");
        System.out.println("=============================");
        System.out.println(" ");
        ordenadosPorPrecio();
        System.out.println(" ");
        System.out.println("=============================");
        System.out.println(" ");
        mostrarListaNatural();
        System.out.println(" ");
        System.out.println(" ");
    }

    @Override // Metodo para agregar vehiculos
    public void agregarVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null) {
            this.vehiculos.add(vehiculo);
        }

    }

    @Override
    public void mostrarLista() {
        for (Vehiculo vehiculo : vehiculos) { // : (dos puntos): Se lee como "en" o "dentro de". Indica qué colección se
                                              // va a recorrer.
            System.out.println(vehiculo); // Ese código usa un bucle for-each para recorrer toda la lista vehiculos e
                                          // imprimir cada elemento por consola
        }
    }

    @Override // Muestra la lista usando el orden del compareTo
    public void mostrarListaNatural() {
        System.out.println("Vehiculos ordenados por orden natural (marca, modelo, precio):");
        vehiculos.stream() // Stream API
                .sorted() // Ordena los elementos según su orden natural a travez de comparable
                .forEach(System.out::println); // Operación terminal pase cada objeto directamente al println de la
                                               // consola.

    }

    // Creamos un metodo que busque por letra: por lo que al momento de querer usar
    // este metodo nos va a solicitar ingresar una letra y esta no puede ser nula, y
    // en caso de no encontrar la letra solicitada en los objetos responde con
    // mensaje.
    // Recorre la lista con un for-each
    @Override
    public void buscarPorLetra(String letra) {
        if (letra == null || letra.isEmpty())
            return;

        List<Vehiculo> encontrados = vehiculos.stream() // Tubería de datos
                .filter(v -> v.getModelo().toLowerCase().contains(letra.toLowerCase()))
                .toList(); // Enlista en "encontrados"

        if (encontrados.isEmpty()) { // Pregunta directamente si la caja quedó vacía.
            System.out.println("No se encontraron vehiculos con la letra '" + letra + "'.");
        } else { // Resultado si hay coincidencia
            // Definimos la configuración regional para Argentina
            java.util.Locale localeArg = java.util.Locale.of("es", "AR");

            encontrados.forEach(v -> {
                // Formateamos el precio con puntos para miles y coma para decimales
                // .2 (el punto y el número 2): Define la precisión. Le exige a Java que muestre
                // exactamente dos posiciones decimales.
                // f: Indica que el valor que va a recibir es un número
                String precioFormateado = String.format(localeArg, "$%,.2f", v.getPrecio());

                System.out.println("Vehiculo que contiene en el modelo la letra '"
                        + letra + "': " + v.getMarca() + " " + v.getModelo() + " " + precioFormateado);
            });
        }
    }

    @Override
    public void mostrarVehiculoMasCaro() {
        Vehiculo masCaro = vehiculos.stream()
                .max(Comparator.comparingDouble(Vehiculo::getPrecio))
                .orElse(null);

        if (masCaro != null) {
            System.out.println("Vehiculo más caro: " + masCaro.getMarca() + " " + masCaro.getModelo());
        } else {
            System.out.println("No hay vehiculos en la concesionaria.");
        }
    }

    @Override
    public void mostrarVehiculoMasBarato() {
        Vehiculo masBarato = vehiculos.stream()
                .min(Comparator.comparingDouble(Vehiculo::getPrecio)) // Busca el vehículo con el precio más bajo en el
                                                                      // Stream.
                .orElse(null); // Si encontró un vehículo, lo guarda en la variable masBarato. Si la lista
                               // estaba vacía, guarda el valor null.
        if (masBarato != null) { // Si es verdadero (hay vehículos): Entra al bloque if, ejecuta
                                 // masBarato.getMarca() y masBarato.getModelo().

            System.out.println("Vehiculo más barato: " + masBarato.getMarca() + " " + masBarato.getModelo());
        } else {
            System.out.println("No hay vehiculos en la concesionaria.");
        }
    }

    @Override
    public void ordenadosPorPrecio() {
        System.out.println("Vehiculos ordenados por precio de mayor a menor:");
        vehiculos.stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getPrecio).reversed()) // Crea una regla de comparación
                                                                                    // usando números decimales
                                                                                    // (double), ordenando por defecto
                                                                                    // de menor a mayor.
                .forEach(v -> System.out.println(v.getMarca() + " " + v.getModelo())); // Texto personalizado
                                                                                       // concatenando únicamente la
                                                                                       // marca y el modelo.

    }

}