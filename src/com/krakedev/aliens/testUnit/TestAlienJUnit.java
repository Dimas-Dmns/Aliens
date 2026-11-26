package com.krakedev.aliens.testUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.krakedev.aliens.Alien;

public class TestAlienJUnit {

    @Test
    public void testTamanioMinimo() {
        Alien a = new Alien(2, "Verde");
        assertEquals(5, a.getTamanio());
    }

    @Test
    public void testTamanioMaximo() {
        Alien a = new Alien(50, "Rojo");
        assertEquals(30, a.getTamanio());
    }

    @Test
    public void testPrecios() {
        Alien a = new Alien(20, "Azul");
        assertEquals(4.0, a.getPrecioCuerpo(), 0.0001);
        assertEquals(2.0, a.getPrecioExtremidad(), 0.0001);
        assertEquals(1.0, a.getPrecioOjo(), 0.0001);
    }

    @Test
    public void testAgregarBrazosValido() {
        Alien a = new Alien(20, "Verde");
        assertTrue(a.agregarBrazos(4));
        assertEquals(4, a.getNumeroBrazos());
    }

    @Test
    public void testLimiteExtremidades() {
        Alien a = new Alien(20, "Verde");
        a.agregarBrazos(6);
        a.agregarPiernas(4);
        // Ya tiene 10, este debe fallar
        assertFalse(a.agregarBrazos(1));
        assertEquals(10, a.getNumeroBrazos() + a.getNumeroPies());
    }

    @Test
    public void testOjosSegunTamanio() {
        Alien pequeno = new Alien(8, "Verde");
        assertTrue(pequeno.agregarOjos(3));
        assertFalse(pequeno.agregarOjos(1)); // Max 3

        Alien grande = new Alien(25, "Rojo");
        assertTrue(grande.agregarOjos(7));
        assertFalse(grande.agregarOjos(1)); // Max 7
    }

    @Test
    public void testPrecioTotal() {
        Alien a = new Alien(20, "Azul");
        a.agregarBrazos(2);
        a.agregarPiernas(2);
        a.agregarOjos(3);
        // 4.0 + 4*2.0 + 3*1.0 = 15.0
        assertEquals(15.0, a.getPrecioTotal(), 0.0001);
    }

    @Test
    public void testPrecioTotalInicial() {
        Alien a = new Alien(20, "Azul");
        // Sin agregar nada, debe ser solo el cuerpo = 4.0
        assertEquals(4.0, a.getPrecioTotal(), 0.0001);
    }

    @Test
    public void testOjosMediano() {
        Alien mediano = new Alien(15, "Verde");
        assertTrue(mediano.agregarOjos(5));
        assertFalse(mediano.agregarOjos(1)); // Max 5
    }
}