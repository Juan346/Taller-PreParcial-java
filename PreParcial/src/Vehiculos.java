

import java.util.Vector;

public class Vehiculos {

    /* Atributos de la clase Vehiculos */
    private String marca;
    private String modelo;
    private String motor;
    private String año;
    private Color color;
    private TipoVehiculo tipoVehiculo;
    private TipoCombustible tipoCombustible;
    private String tipoTransmision;
    private int cantidadPuertas;
    private int cantidadAsientos;
    private int velocidadMaxima;
    private int velocidadActual;

    static int totalAutomoviles;
    static int contadorRegistros;
    static final int LIMITE_LEGAL = 120;
    static final int INCREMENTO_POR_CIUDAD = 1;

    private Vector<RegistroViaje> bitacora;

    public enum TipoVehiculo {

        CARRO_CIUDAD,
        SUBCOMPACTO,
        COMPACTO,
        FAMILIAR,
        EJECUTIVO,
        SUV
    }

    public enum TipoCombustible {
        GASOLINA,
        BIOETANOL,
        DIESEL,
        BIODIESEL,
        GAS_NATURAL
    }

    public enum Color {
        BLANCO,
        NEGRO,
        ROJO,
        NARANJA,
        AMARILLO,
        VERDE,
        AZUL,
        VIOLETA

    }

    public Vehiculos(String marca, String modelo, String motor, String año, String color, String tipoVehiculo, String tipoCombustible, String tipoTransmision, int cantidadPuertas, int cantidadAsientos, int velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.año = año;
        this.color = Color.valueOf(color);
        this.tipoVehiculo = TipoVehiculo.valueOf(tipoVehiculo); // Asignamos los enums a la variable
        this.tipoCombustible = TipoCombustible.valueOf(tipoCombustible);
        this.tipoTransmision = tipoTransmision;
        this.cantidadPuertas = cantidadPuertas;
        this.cantidadAsientos = cantidadAsientos;
        this.velocidadMaxima = velocidadMaxima;
        this.velocidadActual = 0;
        this.bitacora = new Vector<>();
        totalAutomoviles++;
    }

    public Vehiculos(String marca, String modelo, int VelocidadMaxima) {
        this(marca, modelo, "1.6", "2024", "BLANCO", "COMPACTO", "GASOLINA", "MANUAL", 4, 5, VelocidadMaxima);

    }

    public Vehiculos(Vehiculos otro) {
        this.marca = otro.marca;
        this.modelo = otro.modelo;
        this.motor = otro.motor;
        this.año = otro.año;
        this.color = otro.color;
        this.tipoVehiculo = otro.tipoVehiculo;
        this.cantidadPuertas = otro.cantidadPuertas;
        this.cantidadAsientos = otro.cantidadAsientos;
        this.velocidadMaxima = otro.velocidadMaxima;
        this.tipoCombustible = otro.tipoCombustible;
        this.tipoTransmision = otro.tipoTransmision;
        this.velocidadActual = otro.velocidadActual;
        this.bitacora = new Vector<>();
        totalAutomoviles++;
    }

    /// METODO SEETEAR VELOCIDAD

    public void setVelocidadActual(int velocidadActual) {
        if (velocidadActual > velocidadMaxima || velocidadActual < 0) {
            throw new IllegalArgumentException("La velocidad actual no puede ser mayor a la velocidad máxima o menor que cero");
        }

        this.velocidadActual = velocidadActual;
   
    }

    /// METODO ACELERAR

    public void acelerar() {
        if (velocidadActual + 1 > velocidadMaxima) {
            throw new IllegalArgumentException("La velocidad actual no puede ser mayor a la velocidad máxima");
        }

        this.velocidadActual += 1;
        bitacora.add(new RegistroViaje());
        contadorRegistros++;
       
    }

    public void acelerar(double acelerado) {
        if (velocidadActual + acelerado > velocidadMaxima) {
            throw new IllegalArgumentException("La velocidad actual no puede ser mayor a la velocidad máxima");
        }

        this.velocidadActual += acelerado;
        bitacora.add(new RegistroViaje());
        contadorRegistros++;
    }

    public void acelerar(double acelerar, int veces) {
        for (int i = 0; i < veces; i++) {
            if (velocidadActual + acelerar > velocidadMaxima) {
                throw new IllegalArgumentException("La velocidad actual no puede ser mayor a la velocidad máxima");
            }

            this.velocidadActual += acelerar;
            bitacora.add(new RegistroViaje());
            contadorRegistros++;
        }
    }

    public void desacelerar(int decremento) {
        if (velocidadActual - decremento < 0) {
            throw new IllegalArgumentException("La velocidad actual no puede ser menor a cero");
        }

        this.velocidadActual -= decremento;
        bitacora.add(new RegistroViaje());
        contadorRegistros++;
    }

    public void frenar() {

        this.velocidadActual = 0;
        bitacora.add(new RegistroViaje());
        contadorRegistros++;
    }

    public void mostrar() {
        mostrar(false);

    

    //// Lo hacemos para q llame la funcion -> mostrar pero pasandole el parametro false para que no sea detallado
    }

    public void mostrar(boolean detallado) {

        if (!detallado) {
            System.out.println("Marca: " + marca);
            System.out.println("Modelo: " + modelo);
            System.out.println("Motor: " + motor);
            System.out.println("Año: " + año);
            System.out.println("Color: " + color);
            System.out.println("Tipo de Vehiculo: " + tipoVehiculo);
            System.out.println("Velocidad Actual: " + velocidadActual);
            return;
        }

        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Motor: " + motor);
        System.out.println("Año: " + año);
        System.out.println("Color: " + color);
        System.out.println("Tipo de Vehiculo: " + tipoVehiculo);
        System.out.println("Tipo de Combustible: " + tipoCombustible);
        System.out.println("Tipo de Transmision: " + tipoTransmision);
        System.out.println("Cantidad de Puertas: " + cantidadPuertas);
        System.out.println("Cantidad de Asientos: " + cantidadAsientos);
        System.out.println("Velocidad Maxima: " + velocidadMaxima);
        System.out.println("Velocidad Actual: " + velocidadActual);
    }

    public void tiempoEstimadoLlegada(double distancia) {
        if (velocidadActual == 0) {
            throw new IllegalArgumentException("La velocidad actual no puede ser cero");
        }

        double tiempo = distancia / velocidadActual;
        System.out.println("Tiempo estimado de llegada: " + tiempo + " horas");
    }

    public void tiempoEstimadoLlegada(double distancia, double velocidad) {
        if (velocidad == 0) {
            throw new IllegalArgumentException("La velocidad no puede ser cero");
        }

        double tiempo = distancia / velocidad;
        System.out.println("Tiempo estimado de llegada: " + tiempo + " horas");
    }

    public void tiempoEstimadoLlegada(double distancias, int paradas, int minutosPorParada) {
        if (velocidadActual == 0) {
            throw new IllegalArgumentException("La velocidad actual no puede ser cero");
        }
        double tiempo = distancias / velocidadActual;
        tiempo += (paradas * minutosPorParada) / 60.0;
        System.out.println("Tiempo estimado de llegada: " + tiempo + " horas");
    }

    public static int[] contarPorTipo(Vehiculos[] vehiculos) {
        int[] conteo = new int[TipoVehiculo.values().length];
        for (Vehiculos vehiculo : vehiculos) {
            conteo[vehiculo.tipoVehiculo.ordinal()]++;
        }
        return conteo;
    }

    public static Vehiculos masRapido(Vehiculos[] vehiculos) {
        if (vehiculos.length == 0) {
            return null;
        }
        Vehiculos masRapido = vehiculos[0];
        for (Vehiculos vehiculo : vehiculos) {
            if (vehiculo.velocidadMaxima > masRapido.velocidadMaxima) {
                masRapido = vehiculo;
            }
        }
        return masRapido;
    }

    public static double promedioVelocidad(Vehiculos[] vehiculos) {
        if (vehiculos.length == 0) {
            return 0;
        }
        int sumaVelocidades = 0;
        for (Vehiculos vehiculo : vehiculos) {
            sumaVelocidades += vehiculo.velocidadMaxima;
        }
        return (double) sumaVelocidades / vehiculos.length;
    }

    public static int infraccionesPorExcesoDeVelocidad(Vehiculos[] vehiculos) {
        int infracciones = 0;
        for (Vehiculos vehiculo : vehiculos) {
            if (vehiculo.velocidadActual > LIMITE_LEGAL) {
                infracciones++;
            }
        }
        return infracciones;
    }

    public String tipoVehiculo() {
        return tipoVehiculo.toString();
    }

    public String tipoCombustible() {
        return tipoCombustible.toString();
    }

    public String color() {
        return color.toString();
    }

    public static int getTotalAutomoviles() {
        return totalAutomoviles;
    }

    public int getVelocidadActual() {
        return velocidadActual;
    }
    public void mostrarBitacora() {
        for (RegistroViaje registro : bitacora) {
            System.out.println(registro.describir());
        }
    }

    public static Vehiculos[] filtrar(Vehiculos[] vehiculos, TipoVehiculo tipoVehiculo) {
        Vehiculos[] filtrados = new Vehiculos[vehiculos.length];
        int index = 0;
        for (Vehiculos vehiculo : vehiculos) {
            if (vehiculo.tipoVehiculo == tipoVehiculo) {
                filtrados[index++] = vehiculo;
            }
        }
        return java.util.Arrays.copyOf(filtrados, index);
    }

    public static Vehiculos[] filtrar(Vehiculos[] vehiculos, TipoCombustible tipoCombustible) {
        Vehiculos[] filtrados = new Vehiculos[vehiculos.length];
        int index = 0;
        for (Vehiculos vehiculo : vehiculos) {
            if (vehiculo.tipoCombustible == tipoCombustible) {
                filtrados[index++] = vehiculo;
            }
        }
        return java.util.Arrays.copyOf(filtrados, index);
    }

    public static Vehiculos[] filtrar(Vehiculos[] vehiculos, Color color) {
        Vehiculos[] filtrados = new Vehiculos[vehiculos.length];
        int index = 0;
        for (Vehiculos vehiculo : vehiculos) {
            if (vehiculo.color == color) {
                filtrados[index++] = vehiculo;
            }
        }
        return java.util.Arrays.copyOf(filtrados, index);
    }

    public class RegistroViaje {

        private String marcaVehiculo;
        private String modeloVehiculo;
        private int velocidadRegistrada;

        public RegistroViaje() {
            this.marcaVehiculo = Vehiculos.this.marca;
            this.modeloVehiculo = Vehiculos.this.modelo;
            this.velocidadRegistrada = Vehiculos.this.velocidadActual;
        }

        public String describir() {

            return "Marca: " + marcaVehiculo + ", Modelo: " + modeloVehiculo + ", Velocidad Registrada: " + velocidadRegistrada;
        }

    }

}
