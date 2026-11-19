# 🚗 Gestión de Concesionaria - Trabajo Práctico POO en Java

Este proyecto implementa un sistema de gestión y reporte de vehículos para una concesionaria utilizando **Java** y aplicando los principios fundamentales de la **Programación Orientada a Objetos (POO)** junto con herramientas modernas de **Programación Funcional (Java Streams)**.

---

## 🏗️ Arquitectura y Orientación a Objetos

El diseño del proyecto está dividido en paquetes según la responsabilidad de cada componente, garantizando bajo acoplamiento y alta cohesión:

* `entidades.objetos`: Contiene el modelo de dominio (`Vehiculo`, `Auto`, `Moto`).
* `interfaz`: Define el contrato de operaciones de negocio (`IConcesionaria`).
* `implementacion`: Contiene la lógica de negocio real (`Concesionaria`).
* `tests`: Contiene el punto de entrada y pruebas de ejecución (`TestIConcesionaria`).

### Pilares de POO aplicados

1. **Abstracción y Herencia:** `Vehiculo` actúa como clase padre que encapsula los atributos comunes (`marca`, `modelo`, `precio`). Las clases `Auto` y `Moto` heredan de ella y agregan sus atributos específicos (`puertas` y `cilindrada`, respectivamente).
2. **Polimorfismo:** La clase `Concesionaria` administra una única colección tipada como `List<Vehiculo>`. Esto permite almacenar y operar tanto sobre autos como sobre motos de manera uniforme, delegando a cada subclase su propia representación en texto mediante la sobrescritura de `@Override toString()`.
3. **Interfaces y Desacoplamiento:** Se utiliza la interfaz `IConcesionaria` para definir qué operaciones debe ofrecer el sistema sin exponer cómo están resueltas. En el test se instancia apuntando a la interfaz (`IConcesionaria concesionaria = new Concesionaria();`), facilitando el mantenimiento y futuras extensiones.
4. **Ordenamiento Natural (`Comparable`):** La clase `Vehiculo` implementa la interfaz `Comparable<Vehiculo>`, definiendo el criterio de ordenamiento por defecto del negocio (marca, modelo y precio) a través del método `compareTo()`.
5. **Inyección / Carga externa de datos:** El constructor de `Concesionaria` inicializa la lista vacía (`new ArrayList<>()`), delegando la carga de vehículos al método `agregarVehiculo()`. Esto desacopla los datos de prueba de la lógica de negocio y facilita la realización de tests unitarios.

---

## ⚙️ Lógica de los Métodos y Cláusulas Utilizadas

A continuación se detalla el funcionamiento interno de los métodos principales implementados en la clase `Concesionaria`:

### 1. `agregarVehiculo(Vehiculo vehiculo)`
* **Propósito:** Incorporar nuevos vehículos al inventario de la concesionaria.
* **Cláusula de guarda (`if (vehiculo != null)`):** Implementa programación defensiva verificando que la referencia recibida exista en memoria antes de añadirla al `ArrayList`. Esto previene futuros errores de tipo `NullPointerException` al recorrer la lista.

### 2. `mostrarLista()`
* **Propósito:** Listar todos los vehículos registrados con su formato completo.
* **Lógica aplicada:** Utiliza un bucle **`for-each`** (`for (Vehiculo vehiculo : vehiculos)`). Se eligió esta estructura sobre un `for` tradicional por índice ya que solo se requiere lectura secuencial de principio a fin, logrando un código más limpio y libre de errores de desbordamiento de índices.

### 3. `mostrarVehiculoMasCaro()` y `mostrarVehiculoMasBarato()`
* **Propósito:** Identificar e imprimir el vehículo de mayor y menor valor económico.
* **Lógica aplicada:** Se utiliza la API de **Streams** combinada con `Comparator.comparingDouble(Vehiculo::getPrecio)` junto a las operaciones terminales `.max()` y `.min()`.
* **Manejo de nulos:** Se emplea `.orElse(null)` seguido de una validación `if (masCaro != null)` para controlar de forma segura el escenario en que la concesionaria no tenga vehículos cargados.

### 4. `buscarPorLetra(String letra)`
* **Propósito:** Filtrar y mostrar los vehículos cuyo modelo contenga una letra o subcadena específica, sin distinguir entre mayúsculas y minúsculas.
* **Cláusula de guarda:** `if (letra == null || letra.isEmpty()) return;` detiene la ejecución inmediatamente si el parámetro ingresado es nulo o vacío.
* **Lógica aplicada:**
  1. Se transforma la lista en un flujo de datos (`.stream()`).
  2. Se aplica `.filter()` normalizando tanto el modelo del vehículo como la letra buscada con `.toLowerCase()` y evaluando coincidencia con `.contains()`.
  3. Se recolectan los resultados en una lista auxiliar (`.toList()`).
  4. Se evalúa `.isEmpty()` para informar al usuario en caso de que no existan coincidencias, o bien recorrer los resultados con `.forEach()` para imprimirlos.

### 5. `ordenadosPorPrecio()`
* **Propósito:** Mostrar el catálogo ordenado de mayor a menor precio.
* **Lógica aplicada:** Utiliza un Stream con `.sorted(Comparator.comparingDouble(Vehiculo::getPrecio).reversed())` para invertir el orden numérico ascendente por defecto, proyectando luego marca y modelo mediante una expresión lambda en `.forEach()`.

### 6. `mostrarListaNatural()`
* **Propósito:** Mostrar los vehículos respetando el orden natural definido en la entidad.
* **Lógica aplicada:** Invoca `.sorted()` sin argumentos sobre el Stream. Internamente, Java utiliza la implementación del método `compareTo()` definida en la clase `Vehiculo` gracias a la interfaz `Comparable`.

### 7. `reporteConcesionaria(String letraBuscada)`
* **Propósito:** Actuar como método orquestador (Patrón *Facade* simplificado), ejecutando en secuencia todos los reportes solicitados por la consigna con separadores visuales claros en consola.

---

## 🚀 Ejecución del Proyecto

1. Clonar el repositorio o descargar los archivos fuente.
2. Abrir el proyecto en su IDE de preferencia (IntelliJ IDEA, Eclipse, VS Code).
3. Asegurarse de contar con **JDK 16 o superior** (requerido por el método `.toList()` en Streams; para versiones anteriores como Java 8/11, reemplazar por `.collect(Collectors.toList())`).
4. Ejecutar el método `main` ubicado en la clase:
   ```text
   com.poo.concesionario.martin.tests.TestIConcesionaria
   ```


A. Dónde se usa el Collections Framework (java.util)

• List<Vehiculo> encontrados: List es una de las interfaces principales del framework de colecciones de Java.
• vehiculos: Es la colección de origen (probablemente una List o Set) sobre la cual se realiza la búsqueda.
• encontrados.isEmpty() y encontrados.forEach(...): Son métodos propios de las colecciones (List / Iterable) para verificar si tiene elementos y recorrerlos.

B. Dónde se usa la API Stream (java.util.stream)

• vehiculos.stream(): Convierte la colección en un flujo de datos (stream) para procesarlo de forma funcional.
• .filter(...): Es una operación intermedia de la API Stream que descarta los vehículos que no cumplen la condición.
• .toList(): Es una operación terminal (incorporada desde Java 16) que cierra el stream y junta los resultados nuevamente en una lista del Collections Framework.

C. Cómo se relacionan
El Collections Framework se encarga de guardar y estructurar los datos en memoria (vehiculos y encontrados),
 mientras que la API Stream se usa solo como una tubería temporal para filtrarlos y transformarlos sin modificar la lista original.

---

## 📋 Ejemplo de Salida por Consola

```text
Lista de vehiculos en la concesionaria:
Marca: Peugeot // Modelo: 206 // Puertas: 4 // Precio: \$200.000,00
Marca: Honda // Modelo: Titan // Cilindrada: 125c // Precio: \$60.000,00
Marca: Peugeot // Modelo: 208 // Puertas: 5 // Precio: \$250.000,00
Marca: Yamaha // Modelo: YBR // Cilindrada: 160c // Precio: \$80.500,50

=============================

Vehiculo mas caro: Peugeot 208
Vehiculo mas barato: Honda Titan
Vehiculo que contiene en el modelo la letra 'Y': Yamaha YBR

=============================

Vehiculos ordenados por precio de mayor a menor:
Peugeot 208
Peugeot 206
Yamaha YBR
Honda Titan

=============================

Vehiculos ordenados por orden natural (marca, modelo, precio):
Marca: Honda // Modelo: Titan // Cilindrada: 125c // Precio: \$60.000,00
Marca: Peugeot // Modelo: 206 // Puertas: 4 // Precio: \$200.000,00
Marca: Peugeot // Modelo: 208 // Puertas: 5 // Precio: \$250.000,00
Marca: Yamaha // Modelo: YBR // Cilindrada: 160c // Precio: \$80.500,50
