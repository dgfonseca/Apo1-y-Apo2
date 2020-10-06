/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_lineasTelefonicas
 * Autor: Equipo Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.lineasTelefonicas.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uniandes.cupi2.lineasTelefonicas.mundo.LineaTelefonica;

/**
 * Clase usada para verificar que los métodos de la clase LineaTelefonica estén correctamente implementados.
 */
public class LineaTelefonicaTest 
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private LineaTelefonica linea;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye una nueva línea telefónica vacía.
     */
    private void setupEscenario1( )
    {
        linea = new LineaTelefonica( );
    }

    /**
     * Prueba 1: Método que se encarga de verificar el método agregarLlamadaCelular. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarLlamadaCelular<br>
     * darNumeroLlamadas<br>
     * darNumeroMinutos<br>
     * darCostoLlamadas<br>
     * <b> Casos de prueba: </b> <br>
     * 1. No hay llamadas el la línea.
     */
    @Test
    public void testAgregarLlamadaCelular( )
    {
        setupEscenario1( );
        linea.agregarLlamadaCelular( 10 );
        assertEquals( "El número de llamadas debe ser 1", 1, linea.darNumeroLlamadas( ) );
        assertEquals( "El número de minutos debe ser 10", 10, linea.darNumeroMinutos( ) );
        assertEquals( "El costo debe ser $9.990", 9990, linea.darCostoLlamadas( ), 0.001 );
    }

    /**
     * Prueba 2: Método que se encarga de verificar el método agregarLlamadaLocal. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarLlamadaLocal<br>
     * darNumeroLlamadas<br>
     * darNumeroMinutos<br>
     * darCostoLlamadas<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Hay una llamada en la línea.
     */
    @Test
    public void testAgregarLlamadaLocal( )
    {
        setupEscenario1( );
        linea.agregarLlamadaLocal( 5 );
        assertEquals( "El número de llamadas debe ser 1", 1, linea.darNumeroLlamadas( ) );
        assertEquals( "El número de minutos debe ser 5", 5, linea.darNumeroMinutos( ) );
        assertEquals( "El costo debe ser $175", 175, linea.darCostoLlamadas( ), 0.001 );
    }

    /**
     * Prueba 3: Método que se encarga de verificar el método agregarLlamadaLargaDistancia.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarLlamadaLargaDistancia<br>
     * darNumeroLlamadas<br>
     * darNumeroMinutos<br>
     * darCostoLlamadas<br>
     * <b> Casos de prueba: </b> <br>
     * 1. No hay llamadas el la línea.
     */
    @Test
    public void testAgregarLlamadaLargaDistancia( )
    {
        setupEscenario1( );
        linea.agregarLlamadaLargaDistancia( 7 );
        assertEquals( "El número de llamadas debe ser 1", 1, linea.darNumeroLlamadas( ) );
        assertEquals( "El número de minutos debe ser 5", 7, linea.darNumeroMinutos( ) );
        assertEquals( "El costo debe ser $2.660", 2660, linea.darCostoLlamadas( ), 0.001 );
    }

    /**
     * Prueba 4: Método que se encarga de verificar el método reiniciar. <br>
     * <b> Métodos a probar: </b> <br>
     * reiniciar<br>
     * agregarLlamadaLargaDistancia<br>
     * darNumeroLlamadas<br>
     * darNumeroMinutos<br>
     * darCostoLlamadas<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Hay una llamada en la línea.
     */
    @Test
    public void testReiniciar( )
    {
        setupEscenario1( );
        linea.agregarLlamadaLargaDistancia( 7 );
        linea.reiniciar( );
        assertEquals( "El número de llamadas debe ser 0", 0, linea.darNumeroLlamadas( ) );
        assertEquals( "El número de minutos debe ser 0", 0, linea.darNumeroMinutos( ) );
        assertEquals( "El costo debe ser $0.0", 0, linea.darCostoLlamadas( ), 0.001 );
    }

}
