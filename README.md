# 🚗 Sistema de Gestión de Flota Vehicular - AutoFlota S.A.S.

## 📋 Descripción

Este proyecto corresponde al **Taller 1 de Algoritmo y Programación 2**, cuyo objetivo es desarrollar un prototipo en consola para la gestión de una flota vehicular utilizando conceptos fundamentales de Programación Orientada a Objetos (POO) en Java.

El sistema permite administrar vehículos, controlar cambios de velocidad, generar estadísticas de la flota, registrar eventos mediante bitácoras y aplicar técnicas avanzadas de POO como:

- Encapsulamiento.
- Sobrecarga de métodos.
- Sobrecarga de constructores.
- Clases internas.
- Enumeraciones (Enums).
- Miembros estáticos.
- Arreglos y estructuras dinámicas (`Vector`).

---

## 👨‍💻 Información Académica

**Asignatura:** Algoritmia y Programación 2

**Taller:** Sistema de Gestión de Flota Vehicular

**Modalidad:** Individual

**Lenguaje:** Java

**IDE utilizado:** Visual Studio Code

---

# 📂 Estructura del Proyecto

```text
Proyecto
│
├── App.java
├── Vehiculos.java
│
└── README.md
```

---

# 🏗️ Características Implementadas

## Modelo de Datos

La clase `Vehiculos` contiene información relacionada con:

- Marca
- Modelo
- Motor
- Año
- Color
- Tipo de vehículo
- Tipo de combustible
- Tipo de transmisión
- Número de puertas
- Número de asientos
- Velocidad máxima
- Velocidad actual

---

## Encapsulamiento

Todos los atributos fueron implementados como privados para garantizar la protección del estado del objeto.

Ejemplo:

```java
private String marca;
private String modelo;
private int velocidadMaxima;
```

---

## Constructores Sobrecargados

### Constructor Completo

Permite crear un vehículo con toda la información disponible.

```java
Vehiculos v1 = new Vehiculos(...);
```

### Constructor Reducido

Permite crear objetos utilizando únicamente:

```java
marca
modelo
velocidadMaxima
```

Los demás valores se asignan por defecto.

### Constructor Copia

Permite crear un vehículo a partir de otro objeto existente.

```java
Vehiculos copia = new Vehiculos(v1);
```

---

# ⚡ Gestión de Velocidad

El sistema permite:

### Acelerar

```java
acelerar()
acelerar(double)
acelerar(double, int)
```

### Desacelerar

```java
desacelerar(int)
```

### Frenar

```java
frenar()
```

---

# ⏱️ Tiempo Estimado de Llegada

Se implementaron tres versiones sobrecargadas:

```java
tiempoEstimadoLlegada(double distancia)
```

```java
tiempoEstimadoLlegada(double distancia,
                      double velocidadCrucero)
```

```java
tiempoEstimadoLlegada(double distancia,
                      int paradas,
                      int minutosPorParada)
```

Estas permiten realizar cálculos de viaje con diferentes niveles de detalle.

---

# 📊 Estadísticas de Flota

El sistema incorpora métodos estáticos para:

### Contar vehículos por tipo

```java
contarPorTipo()
```

### Obtener el vehículo más rápido

```java
masRapido()
```

### Calcular velocidad promedio

```java
promedioVelocidad()
```

### Identificar infracciones por exceso de velocidad

```java
infraccionesPorExcesoDeVelocidad()
```

---

# 🔍 Filtros de Búsqueda

Se implementó sobrecarga del método:

```java
filtrar(...)
```

permitiendo filtrar por:

## Tipo de Vehículo

```java
Vehiculos.filtrar(flota,
                  TipoVehiculo.SUV);
```

## Tipo de Combustible

```java
Vehiculos.filtrar(flota,
                  TipoCombustible.GASOLINA);
```

## Color

```java
Vehiculos.filtrar(flota,
                  Color.ROJO);
```

---

# 📝 Sistema de Bitácora

Cada vehículo mantiene una bitácora interna utilizando:

```java
Vector<RegistroViaje>
```

Cada vez que la velocidad cambia se registra automáticamente un evento.

Ejemplo:

```text
Marca: Toyota
Modelo: Corolla
Velocidad Registrada: 100

Marca: Toyota
Modelo: Corolla
Velocidad Registrada: 120

Marca: Toyota
Modelo: Corolla
Velocidad Registrada: 70
```

---

# 🧩 Enumeraciones Utilizadas

## TipoVehiculo

```java
CARRO_CIUDAD
SUBCOMPACTO
COMPACTO
FAMILIAR
EJECUTIVO
SUV
```

## TipoCombustible

```java
GASOLINA
BIOETANOL
DIESEL
BIODIESEL
GAS_NATURAL
```

## Color

```java
BLANCO
NEGRO
ROJO
NARANJA
AMARILLO
VERDE
AZUL
VIOLETA
```

---

# 🧪 Casos de Prueba Realizados

✅ Constructor completo

✅ Constructor reducido

✅ Constructor copia

✅ Aceleración simple

✅ Aceleración con incremento personalizado

✅ Aceleración repetida

✅ Desaceleración

✅ Frenado

✅ Tiempo estimado de llegada

✅ Mostrar información básica

✅ Mostrar información detallada

✅ Filtrado por color

✅ Filtrado por tipo de vehículo

✅ Filtrado por combustible

✅ Vehículo más rápido

✅ Promedio de velocidad

✅ Detección de infracciones

✅ Registro de bitácora

✅ Manejo de excepciones

---

# ▶️ Ejecución

Compilar:

```bash
javac *.java
```

Ejecutar:

```bash
java App
```

---

# 📚 Conceptos Aplicados

- Programación Orientada a Objetos.
- Encapsulamiento.
- Sobrecarga de métodos.
- Sobrecarga de constructores.
- Clases internas.
- Enumeraciones.
- Miembros estáticos.
- Arreglos.
- Vector.
- Manejo de excepciones.
- Validaciones de negocio.

---

# ✅ Autor

**Juan José Álvarez Castillo**

Taller 1 - Sistema de Gestión de Flota Vehicular

Algoritmia y Programación 2
