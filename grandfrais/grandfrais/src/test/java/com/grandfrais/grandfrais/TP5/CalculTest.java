package com.grandfrais.grandfrais.TP5;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tag("CalculTest")
@DisplayName("Testing Calcul class ")
class CalculTest {
    private float a = 3;
    private float b= 2;
    Calcul calcul = new Calcul(a,b);

    @Order(value = 1)
    @DisplayName("Addition Method")
    @Test
    public void calculAdditionTest() throws Exception {
        Assertions.assertEquals(this.calcul.additionner(a,b), 5.0);
    }

    @Order(value = 2)
    @DisplayName("Soustraire Method")
    @Test
    public void calculSoustraireTest() throws Exception {
        Assertions.assertEquals(this.calcul.soustraire(a,b), 1.0);
    }

    @Order(value = 3)
    @DisplayName("Multiplier Method")
    @Test
    public void calculMultiplierTest() throws Exception {
        Assertions.assertEquals(this.calcul.multiplier(a,b), 6.0);
    }

    @Order(value = 4)
    @DisplayName("Diviser Method")
    @Test
    public void calculDiviserTest() throws Exception {
        Assertions.assertEquals(this.calcul.diviser(a,b), 5.0);
    }

    @Order(value = 5)
    @DisplayName("Carre Method")
    @Test
    public void calculCarreTest() throws Exception {
        Assertions.assertEquals(this.calcul.carre(a), 9.0);
    }

    @Order(value = 6)
    @DisplayName("IdentiteRemarquable Method")
    @Test
    public void CalculIdentiteRemarquableTest() throws Exception {
        Assertions.assertEquals(this.calcul.identiteRemarquable(a,b), 25.0);
    }
}