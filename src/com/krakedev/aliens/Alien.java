package com.krakedev.aliens;

public class Alien {
    // PARTE 2: Atributos privados
    private int tamanio;
    private String color;
    private int numeroOjos;
    private int numeroBrazos;
    private int numeroPies;
    private double precioExtremidad;
    private double precioOjo;
    private double precioCuerpo;
    private double precioTotal;

    // PARTE 3: Constructor
    public Alien(int tamanio, String color) {
        if (tamanio < 5) {
            this.tamanio = 5;
        } else if (tamanio > 30) {
            this.tamanio = 30;
        } else {
            this.tamanio = tamanio;
        }
        this.color = color;

        this.numeroOjos = 0;
        this.numeroBrazos = 0;
        this.numeroPies = 0;

        // Calculo de precios
        this.precioCuerpo = this.tamanio * 0.20;
        this.precioExtremidad = this.tamanio * 0.10;
        this.precioOjo = this.tamanio * 0.05;

        // CORREGIDO: Ya nace con precio total = precio cuerpo
        calcularPrecioTotal();
    }

    // PARTE 4: Solo GET, NO hay SET
    public int getTamanio() { return tamanio; }
    public String getColor() { return color; }
    public int getNumeroOjos() { return numeroOjos; }
    public int getNumeroBrazos() { return numeroBrazos; }
    public int getNumeroPies() { return numeroPies; }
    public double getPrecioExtremidad() { return precioExtremidad; }
    public double getPrecioOjo() { return precioOjo; }
    public double getPrecioCuerpo() { return precioCuerpo; }
    public double getPrecioTotal() { return precioTotal; }

    public void imprimir() {
        System.out.println("--- ALIEN ---");
        System.out.println("Tamanio: " + tamanio + " cm");
        System.out.println("Color: " + color);
        System.out.println("Ojos: " + numeroOjos);
        System.out.println("Brazos: " + numeroBrazos);
        System.out.println("Piernas: " + numeroPies);
        System.out.println("Precio Cuerpo: " + precioCuerpo);
        System.out.println("Precio Extremidad: " + precioExtremidad);
        System.out.println("Precio Ojo: " + precioOjo);
        System.out.println("Precio Total: " + precioTotal);
    }

    // PARTE 7: Extremidades - Maximo 10 entre brazos + piernas
    public boolean agregarBrazos(int cantidad) {
        if (numeroBrazos + numeroPies + cantidad > 10) {
            return false;
        }
        numeroBrazos += cantidad;
        calcularPrecioTotal();
        return true;
    }

    public boolean agregarPiernas(int cantidad) {
        if (numeroBrazos + numeroPies + cantidad > 10) {
            return false;
        }
        numeroPies += cantidad;
        calcularPrecioTotal();
        return true;
    }

    // PARTE 8: Ojos segun tamanio
    public boolean agregarOjos(int cantidad) {
        int maximoOjos;
        if (tamanio <= 10) {
            maximoOjos = 3;
        } else if (tamanio <= 20) {
            maximoOjos = 5;
        } else {
            maximoOjos = 7;
        }

        if (numeroOjos + cantidad > maximoOjos) {
            return false;
        }
        numeroOjos += cantidad;
        calcularPrecioTotal();
        return true;
    }

    // PARTE 9: Precio Total
    public void calcularPrecioTotal() {
        double totalExtremidades = (numeroBrazos + numeroPies) * precioExtremidad;
        double totalOjos = numeroOjos * precioOjo;
        precioTotal = precioCuerpo + totalExtremidades + totalOjos;
    }
}