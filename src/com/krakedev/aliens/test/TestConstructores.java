package com.krakedev.aliens.test;

import com.krakedev.aliens.Alien;

public class TestConstructores {
    public static void main(String[] args) {
        // Caso 1: Tamanio muy pequeno, debe ajustarse a 5
        Alien alien1 = new Alien(2, "Verde");
        alien1.imprimir();

        // Caso 2: Tamanio muy grande, debe ajustarse a 30
        Alien alien2 = new Alien(50, "Morado");
        alien2.imprimir();

        // Caso 3: Tamanio normal
        Alien alien3 = new Alien(20, "Azul");
        alien3.agregarBrazos(2);
        alien3.agregarPiernas(2);
        alien3.agregarOjos(3);
        alien3.imprimir();
        // Precio Total debe ser: 4.0 + (4*2.0) + (3*1.0) = 15.0

        // Caso 4: Intentar pasar el limite de extremidades
        System.out.println("Intento agregar 10 brazos mas: " + alien3.agregarBrazos(10)); // debe dar false

        // Caso 5: Intentar pasar el limite de ojos
        System.out.println("Intento agregar 10 ojos mas: " + alien3.agregarOjos(10)); // debe dar false
        alien3.imprimir();
    }
}