package com.exercicio.exer.barbie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GuardaRoupaTest {
    private GuardaRoupa guardaRoupa;

    @BeforeEach
    void iniciar(){
        guardaRoupa = new GuardaRoupa(500.00);
    }

    @Test
    public void ehGalaAcima200(){
        assertTrue(guardaRoupa.ehDeGala(300.00));
    }

    @Test
    public  void ehGalaAbaixo200(){
        Assertions.assertFalse(guardaRoupa.ehDeGala(100.00));
    }

    @Test
    public  void ehGalaIgual200(){
        Assertions.assertFalse(guardaRoupa.ehDeGala(200.00));
    }

    @Test
    public void deveCaberOrcamento(){
        assertTrue(guardaRoupa.cabeNoOrcamento(300.00));
    }


    @Test
    public void valorIgualAoOrcamento(){
        assertTrue(guardaRoupa.cabeNoOrcamento(500.00));
    }

    @Test
    public void deveAplicarDesconto(){
        assertEquals(guardaRoupa.precoComDesconto(200,10), 180);
    }

    @Test
    public void deveLancarException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> guardaRoupa.precoComDesconto(-200,100));
    }
}
