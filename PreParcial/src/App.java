public class App {

    public static void main(String[] args) {
        System.out.println("=== 1. CREACIÓN DE VEHÍCULOS ===");

        // Uso del constructor completo
        Vehiculos v1 = new Vehiculos(
                "Toyota", "Corolla", "2.0L", "2023", "ROJO",
                "COMPACTO", "GASOLINA", "AUTOMATICA", 4, 5, 180
        );

        // Uso del constructor simplificado
        Vehiculos v2 = new Vehiculos("Mazda", "3", 200);

        // Uso del constructor de copia
        Vehiculos v3 = new Vehiculos(v1);

        System.out.println("Total de vehículos creados hasta ahora: " + Vehiculos.getTotalAutomoviles());
        System.out.println();

        System.out.println("=== 2. MUESTRA DE DATOS ===");
        System.out.println("--- Vehículo 1 (Básico) ---");
        v1.mostrar();
        System.out.println("\n--- Vehículo 1 (Detallado) ---");
        v1.mostrar(true);
        System.out.println();

        System.out.println("=== 3. PRUEBAS DE ACELERACIÓN Y DESACELERACIÓN ===");
        System.out.println("Velocidad inicial v1: " + v1.getVelocidadActual() + " km/h");

        v1.acelerar(); // +1
        System.out.println("Después de acelerar(): " + v1.getVelocidadActual() + " km/h");

        v1.acelerar(49); // +49 -> 50 km/h
        System.out.println("Después de acelerar(49): " + v1.getVelocidadActual() + " km/h");

        v1.acelerar(20, 4); // +80 -> 130 km/h
        System.out.println("Después de acelerar(20, 4): " + v1.getVelocidadActual() + " km/h");

        v1.desacelerar(30); // -> 100 km/h
        System.out.println("Después de desacelerar(30): " + v1.getVelocidadActual() + " km/h");

        v1.frenar(); // -> 0 km/h
        System.out.println("Después de frenar(): " + v1.getVelocidadActual() + " km/h");
        System.out.println();

        System.out.println("=== 4. BITÁCORA DE VIAJE ===");
        System.out.println("Registros de velocidad guardados en la bitácora de v1:");
        v1.mostrarBitacora();
        System.out.println();

        System.out.println("=== 5. ESTIMACIÓN DE TIEMPO DE LLEGADA ===");
        v2.acelerar(100);
        System.out.println("Velocidad de v2: " + v2.getVelocidadActual() + " km/h");

        v2.tiempoEstimadoLlegada(200); // 200 km a velocidad actual
        v2.tiempoEstimadoLlegada(200, 120); // 200 km a 120 km/h
        v2.tiempoEstimadoLlegada(200, 2, 15); // 200 km, 2 paradas de 15 min cada una
        System.out.println();

        System.out.println("=== 6. MÉTODOS ESTÁTICOS DE ANÁLISIS ===");

        // Aceleramos v1 para que supere el límite legal de 120 km/h
        v1.acelerar(130);

        Vehiculos[] flota = {v1, v2, v3};

        // Vehículo más rápido
        Vehiculos masRapido = Vehiculos.masRapido(flota);
        if (masRapido != null) {
            System.out.println("El vehículo más rápido de la flota es: " + masRapido.getVelocidadActual() + " km/h");
        }

        // Promedio de velocidades máximas
        System.out.println("Promedio de velocidad máxima de la flota: " + Vehiculos.promedioVelocidad(flota) + " km/h");

        // Infracciones
        System.out.println("Infracciones por exceso de velocidad (>120 km/h): " + Vehiculos.infraccionesPorExcesoDeVelocidad(flota));
        System.out.println();

        System.out.println("=== 7. FILTRADO DE VEHÍCULOS ===");
        Vehiculos[] rojos = Vehiculos.filtrar(flota, Vehiculos.Color.ROJO);
        System.out.println("Vehículos de color ROJO encontrados: " + rojos.length);

        Vehiculos[] compactos = Vehiculos.filtrar(flota, Vehiculos.TipoVehiculo.COMPACTO);
        System.out.println("Vehículos de tipo COMPACTO encontrados: " + compactos.length);
        System.out.println();

        System.out.println("=== 8. VALIDACIÓN DE EXCEPCIONES ===");
        try {
            System.out.println("Intentando exceder la velocidad máxima (180 km/h)...");
            v1.acelerar(100); // Ya estaba a 130 km/h + 100 = 230 km/h (>180)
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }

        try {
            System.out.println("Intentando frenar por debajo de 0 km/h...");
            v2.desacelerar(150); // Estaba a 100 km/h - 150 = -50 km/h (<0)
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
    }
}