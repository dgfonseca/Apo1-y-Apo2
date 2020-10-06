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
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import uniandes.cupi2.lineasTelefonicas.mundo.Empresa;

/**
 * Clase usada para verificar que los métodos de la clase Empresa estén correctamente implementados.
 */
public class EmpresaTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Empresa empresa;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo objeto de la clase empresa vacía.
     */
    private void setupEscenario1( )
    {
        empresa = new Empresa( );
    }

    /**
     * Escenario 2: Construye un nuevo objeto de la clase empresa con llamadas.
     */
    private void setupEscenario2( )
    {
        empresa = new Empresa( );

        empresa.agregarLlamadaLocalLinea1( 1 );
        empresa.agregarLlamadaLargaDistanciaLinea1( 2 );
        empresa.agregarLlamadaCelularLinea1( 3 );

        empresa.agregarLlamadaLocalLinea2( 10 );
        empresa.agregarLlamadaLargaDistanciaLinea2( 20 );
        empresa.agregarLlamadaCelularLinea2( 30 );

        empresa.agregarLlamadaLocalLinea2( 100 );
        empresa.agregarLlamadaLargaDistanciaLinea2( 200 );
        empresa.agregarLlamadaCelularLinea2( 300 );
    }

    /**
     * Prueba 1: Método que se encarga de verificar el método inicializar.<br>
     * <b> Métodos a probar: </b> <br>
     * Empresa<br>
     * darLinea1<br>
     * darLinea2<br>
     * darLinea3<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa no tiene llamadas en ninguna línea.
     */
    @Test
    public void testInicializacion( )
    {
        setupEscenario1( );
        assertNotNull( "La línea telefónica 1 debe estar inicializada", empresa.darLinea1( ) );
        assertNotNull( "La línea telefónica 2 debe estar inicializada", empresa.darLinea2( ) );
        assertNotNull( "La línea telefónica 3 debe estar inicializada", empresa.darLinea3( ) );
    }

    /**
     * Prueba 2: Método que se encarga de verificar el método agregarLlamadaLocalLinea1.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarLlamadaLocalLinea1<br>
     * darLinea1<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa no tiene llamadas en ninguna línea.
     */
    @Test
    public void testAgregarLlamadaLocalLinea1( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaLocalLinea1( 10 );
        assertEquals( "La llamada no quedó registrada", 1, empresa.darLinea1( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 3: Método que se encarga de verificar el método agregarLlamadaLocalLinea2.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarLlamadaLocalLinea2<br>
     * darLinea2<br>
     * <b> Casos de prueba: </b> <br>
     * Se agrega una llamada local a la línea 2 de la empresa.
     */
    @Test
    public void testAgregarLlamadaLocalLinea2( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaLocalLinea2( 10 );
        assertEquals( "La llamada no quedó registrada", 1, empresa.darLinea2( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 4: Método que se encarga de verificar el método agregarLlamadaLocalLinea3.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarLlamadaLocalLinea3<br>
     * darLinea3<br>
     * <b> Casos de prueba: </b> <br>
     * Se agrega una llamada local a la línea 3 de la empresa.
     */
    @Test
    public void testAgregarLlamadaLocalLinea3( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaLocalLinea3( 10 );
        assertEquals( "La llamada no quedó registrada", 1, empresa.darLinea3( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 5: Método que se encarga de verificar el método agregarLlamadaLargaDistanciaLinea1.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarLlamadaLargaDistanciaLinea1<br>
     * darLinea1<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa no tiene llamadas en ninguna línea.
     */
    @Test
    public void testAgregarLlamadaLargaDistanciaLinea1( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaLargaDistanciaLinea1( 10 );
        assertEquals( "La llamada no quedó registrada", 1, empresa.darLinea1( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 6: Método que se encarga de verificar el método agregarLlamadaLargaDistanciaLinea2.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarLlamadaLargaDistanciaLinea2<br>
     * darLinea2<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa no tiene llamadas en ninguna línea.
     */
    @Test
    public void testAgregarLlamadaLargaDistanciaLinea2( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaLargaDistanciaLinea2( 10 );
        assertEquals( "La llamada no quedó registrada", 1, empresa.darLinea2( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 7: Método que se encarga de verificar el método agregarLlamadaLargaDistanciaLinea3.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarLlamadaLargaDistanciaLinea3<br>
     * darLinea3<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa no tiene llamadas en ninguna línea.
     */
    @Test
    public void testAgregarLlamadaLargaDistanciaLinea3( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaLargaDistanciaLinea3( 10 );
        assertEquals( "La llamada no quedó registrada", 1, empresa.darLinea3( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 8: Método que se encarga de verificar el método agregarLlamadaCelularLinea1.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarLlamadaCelularLinea1<br>
     * darLinea1<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa no tiene llamadas en ninguna línea.
     */
    @Test
    public void testAgregarCelularDistanciaLinea1( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaCelularLinea1( 10 );
        assertEquals( "La llamada no quedó registrada", 1, empresa.darLinea1( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 9: Método que se encarga de verificar el método agregarLlamadaCelularLinea2.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarLlamadaCelularLinea2<br>
     * darLinea2<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa no tiene llamadas en ninguna línea.
     */
    @Test
    public void testAgregarCelularDistanciaLinea2( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaCelularLinea2( 10 );
        assertEquals( "La llamada no quedó registrada", 1, empresa.darLinea2( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 10: Método que se encarga de verificar el método agregarLlamadaCelularLinea3.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarLlamadaCelularLinea3<br>
     * darLinea3<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa no tiene llamadas en ninguna línea.
     */
    @Test
    public void testAgregarCelularDistanciaLinea3( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaCelularLinea3( 10 );
        assertEquals( "La llamada no quedó registrada", 1, empresa.darLinea3( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 11: Método que se encarga de verificar el método darTotalNumeroLlamadas.<br>
     * <b> Métodos a probar: </b> <br>
     * darTotalNumeroLlamadas<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa tiene llamadas en las 3 líneas telefónicas.
     */
    @Test
    public void testDarTotalLlamadas( )
    {
        setupEscenario2( );
        assertEquals( "El numero de llamadas debe ser 9", 9, empresa.darTotalNumeroLlamadas( ) );
    }

    /**
     * Prueba 12: Método que se encarga de verificar el método darTotalMinutos.<br>
     * <b> Métodos a probar: </b> <br>
     * darTotalMinutos<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa tiene llamadas en las 3 líneas telefónicas.
     */
    @Test
    public void testDarTotalMinutos( )
    {
        setupEscenario2( );
        assertEquals( "El total de minutos debe ser 666", 666, empresa.darTotalMinutos( ) );
    }

    /**
     * Prueba 13: Método que se encarga de verificar el método darTotalCostoLlamadas.<br>
     * <b> Métodos a probar: </b> <br>
     * darTotalCostoLlamadas<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa tiene llamadas en las 3 líneas telefónicas.
     */
    public void testDarTotalCosto( )
    {
        setupEscenario2( );
        assertEquals( "El costo es inválido. Debe ser $ 420.912", 420912, empresa.darTotalCostoLlamadas( ), 0.001 );
    }

    /**
     * Prueba 14: Método que se encarga de verificar el método darCostoPromedioMinuto.<br>
     * <b> Métodos a probar: </b> <br>
     * darCostoPromedioMinuto<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa tiene llamadas en las 3 líneas telefónicas.
     */
    @Test
    public void testDarCostoPromedio( )
    {
        setupEscenario2( );
        assertEquals( "El costo promedio es inválido. Debe ser $632", 632, empresa.darCostoPromedioMinuto( ), 0.001 );
    }

    /**
     * Prueba 14: Método que se encarga de verificar el método reiniciar.<br>
     * <b> Métodos a probar: </b> <br>
     * reiniciar<br>
     * darTotalNumeroLlamadas<br>
     * darTotalMinutos<br>
     * darTotalCostoLlamadas<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa tiene llamadas en las 3 líneas telefónicas.
     */
    @Test
    public void testReiniciar( )
    {
        setupEscenario2( );
        empresa.reiniciar( );
        assertEquals( "El total de llamadas debe ser cero", 0, empresa.darTotalNumeroLlamadas( ) );
        assertEquals( "El total de minutos debe ser cero", 0, empresa.darTotalMinutos( ) );
        assertEquals( "El costo total de llamadas debe ser cero", 0, empresa.darTotalCostoLlamadas( ), 0.01 );
    }

}