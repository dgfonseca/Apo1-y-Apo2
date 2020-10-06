/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_fabricaDeUniformes
 * Autor: Equipo Cupi2 2018-1
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.fabricaDeUniformes.test;

import java.awt.Color;
import java.util.Collection;
import static org.junit.Assert.*;
import java.io.File;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import uniandes.cupi2.fabricaDeUniformes.mundo.Adidas;
import uniandes.cupi2.fabricaDeUniformes.mundo.CamisetaConRaya;
import uniandes.cupi2.fabricaDeUniformes.mundo.CamisetaCuadros;
import uniandes.cupi2.fabricaDeUniformes.mundo.CamisetaFranjas;
import uniandes.cupi2.fabricaDeUniformes.mundo.IParte;
import uniandes.cupi2.fabricaDeUniformes.mundo.Pantaloneta;
import uniandes.cupi2.fabricaDeUniformes.mundo.Parte;
import uniandes.cupi2.fabricaDeUniformes.mundo.Reebok;
import uniandes.cupi2.fabricaDeUniformes.mundo.Umbro;
import uniandes.cupi2.fabricaDeUniformes.mundo.Uniforme;

/**
 * Clase de prueba para Uniforme
 */
public class UniformeTest
{

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * El uniforme sobre la que se realizarán las pruebas
     */
    private Uniforme uniforme;

    // -------------------------------------------------------------
    // Escenarios
    // -------------------------------------------------------------

    /**
     * Crea un nuevo uniforme vacía
     */
    @Before
    public void setupEscenario1( )
    {
        uniforme = new Uniforme( );

    }

    /**
     * Crea un nuevo uniforme a partir de un archivo
     */
    public void setupEscenario2( )
    {

        uniforme = new Uniforme( );

        try
        {
            uniforme.abrir( "./test/data/testUniforme.dat" );

        }
        catch( Exception e )
        {
            fail( "No se pudo cargar el archivo: " + e.getMessage( ) );
        }

    }

    // -------------------------------------------------------------
    // Métodos de prueba
    // -------------------------------------------------------------
    /**
     * Prueba 1 - Prueba el método constructor <br>
     * Métodos a probar: <br>
     * Uniforme, darDibujos
     */
    @Test
    public void testUniforme( )
    {
        assertNull( "Debería inicializar el nombre del archivo con null", uniforme.darNombreArchivo( ) );
        Collection listaPartes = uniforme.darPartes( );
        assertNotNull( "No inicializó la lista de partes", listaPartes );
        assertTrue( "Debería inicializar una lista vacia", listaPartes.isEmpty( ) );
    }

    /**
     * Prueba 2 - Prueba el método crearParte para las camisetas.<br>
     * Métodos a probar<br>
     * crearParte
     */
    @Test
    public void testCrearCamiseta( )
    {
        int x = 255;
        int y = 300;
        Color colorDibujo = Color.GREEN;
        IParte dibujo = uniforme.crearParte( CamisetaConRaya.TIPO, x, y, colorDibujo );
        assertNotNull( "No se creó la casmiseta con raya.", dibujo );
        assertEquals( "Error al inicializar tipo", CamisetaConRaya.TIPO, dibujo.darTipo( ) );
        assertEquals( "Error al inicializar coordenada x", x, dibujo.darX( ) );
        assertEquals( "Error al inicializar coordenada y", y, dibujo.darY( ) );
        assertEquals( "Error al inicializar color", colorDibujo, dibujo.darColor( ) );

        x = 100;
        y = 400;
        colorDibujo = Color.YELLOW;
        dibujo = uniforme.crearParte( CamisetaFranjas.TIPO, x, y, colorDibujo );
        assertNotNull( "No se creó la camiseta rayada.", dibujo );
        assertEquals( "Error al inicializar tipo", CamisetaFranjas.TIPO, dibujo.darTipo( ) );
        assertEquals( "Error al inicializar coordenada x", x, dibujo.darX( ) );
        assertEquals( "Error al inicializar coordenada y", y, dibujo.darY( ) );
        assertEquals( "Error al inicializar color", colorDibujo, dibujo.darColor( ) );

        x = 100;
        y = 400;
        colorDibujo = Color.ORANGE;
        dibujo = uniforme.crearParte( CamisetaCuadros.TIPO, x, y, colorDibujo );
        assertNotNull( "No se creó el cerdo", dibujo );
        assertEquals( "Error al inicializar tipo", CamisetaCuadros.TIPO, dibujo.darTipo( ) );
        assertEquals( "Error al inicializar coordenada x", x, dibujo.darX( ) );
        assertEquals( "Error al inicializar coordenada y", y, dibujo.darY( ) );
        assertEquals( "Error al inicializar color", colorDibujo, dibujo.darColor( ) );

    }

    /**
     * Prueba 2 - Prueba el método crearParte para los logos.<br>
     * Métodos a probar<br>
     * crearParte
     */
    @Test
    public void testCrearLogo( )
    {
        int x = 255;
        int y = 300;
        Color colorDibujo = Color.GREEN;
        IParte dibujo = uniforme.crearParte( Adidas.TIPO, x, y, colorDibujo );
        Adidas adidas = ( Adidas )dibujo;
        assertNotNull( "No se creó el logo adidas.", dibujo );
        assertEquals( "Error al inicializar tipo", Adidas.TIPO, dibujo.darTipo( ) );
        assertEquals( "Error al inicializar coordenada x", x, dibujo.darX( ) );
        assertEquals( "Error al inicializar coordenada y", y, dibujo.darY( ) );
        assertEquals( "Error al inicializar color", colorDibujo, dibujo.darColor( ) );
        assertEquals( "Error al inicializar el texto", "Adidas", adidas.darTexto( ) );

        x = 100;
        y = 400;
        colorDibujo = Color.YELLOW;
        dibujo = uniforme.crearParte( Reebok.TIPO, x, y, colorDibujo );
        Reebok reebok = ( Reebok )dibujo;
        assertNotNull( "No se creó el logo reebok.", dibujo );
        assertEquals( "Error al inicializar tipo", Reebok.TIPO, dibujo.darTipo( ) );
        assertEquals( "Error al inicializar coordenada x", x, dibujo.darX( ) );
        assertEquals( "Error al inicializar coordenada y", y, dibujo.darY( ) );
        assertEquals( "Error al inicializar color", colorDibujo, dibujo.darColor( ) );
        assertEquals( "Error al inicializar el texto", "Reebok", reebok.darTexto( ) );

        x = 100;
        y = 400;
        colorDibujo = Color.ORANGE;
        dibujo = uniforme.crearParte( Umbro.TIPO, x, y, colorDibujo );
        Umbro umbro = ( Umbro )dibujo;
        assertNotNull( "No se creó el logo umbro", dibujo );
        assertEquals( "Error al inicializar tipo", Umbro.TIPO, dibujo.darTipo( ) );
        assertEquals( "Error al inicializar coordenada x", x, dibujo.darX( ) );
        assertEquals( "Error al inicializar coordenada y", y, dibujo.darY( ) );
        assertEquals( "Error al inicializar color", colorDibujo, dibujo.darColor( ) );
        assertEquals( "Error al inicializar el texto", "Umbro", umbro.darTexto( ) );

    }

    /**
     * Prueba 3 - Prueba el método crearParte para la pantaloneta<br>
     * Métodos a probar<br>
     * crearParte
     */
    @Test
    public void testCrearPantaloneta( )
    {
        int x = 255;
        int y = 300;
        Color colorDibujo = Color.GREEN;
        IParte dibujo = uniforme.crearParte( Pantaloneta.TIPO, x, y, colorDibujo );
        Pantaloneta pantaloneta = ( Pantaloneta )dibujo;
        assertNotNull( "No se creó la pantaloneta", dibujo );
        assertEquals( "Error al inicializar tipo", Pantaloneta.TIPO, dibujo.darTipo( ) );
        assertEquals( "Error al inicializar coordenada x", x, dibujo.darX( ) );
        assertEquals( "Error al inicializar coordenada y", y, dibujo.darY( ) );
        assertEquals( "Error al inicializar color", colorDibujo, dibujo.darColor( ) );

    }

    /**
     * Prueba 4 - Prueba el método agregarParte para las diferentes camisetas. <br>
     * Métodos a probar: <br>
     * agregarParte, crearParte, buscarParte
     */
    @Test
    public void testAgregarCamiseta( )
    {
        Parte d1 = uniforme.crearParte( CamisetaCuadros.TIPO, 30, 30, Color.BLUE );
        uniforme.agregarParte( d1 );
        CamisetaCuadros camisetaCuadros = ( CamisetaCuadros )uniforme.buscarParte( 38, 38 );
        assertNotNull( "No se agregó correctamente la camiseta con cuadros.", camisetaCuadros );

        d1 = uniforme.crearParte( CamisetaConRaya.TIPO, 30, 30, Color.BLUE );
        uniforme.agregarParte( d1 );
        CamisetaConRaya camisetaConRaya = ( CamisetaConRaya )uniforme.buscarParte( 38, 38 );
        assertNotNull( "No se agregó correctamente la camiseta con raya.", camisetaConRaya );

        d1 = uniforme.crearParte( CamisetaFranjas.TIPO, 50, 80, Color.BLUE );
        uniforme.agregarParte( d1 );
        CamisetaFranjas camisetaFranjas = ( CamisetaFranjas )uniforme.buscarParte( 60, 90 );
        assertNotNull( "No se agregó correctamente la camiseta rayada.", camisetaFranjas );
    }

    /**
     * Prueba 5 - Prueba el método agregarParte para los diferentes logos. <br>
     * Métodos a probar: <br>
     * agregarParte, crearParte, buscarParte
     */
    @Test
    public void testAgregarLogo( )
    {
        Parte d1 = uniforme.crearParte( Adidas.TIPO, 30, 30, Color.BLUE );
        uniforme.agregarParte( d1 );
        Adidas adidas = ( Adidas )uniforme.buscarParte( 38, 38 );
        assertNotNull( "No se agregó correctamente el logo adidas.", adidas );

        d1 = uniforme.crearParte( Reebok.TIPO, 30, 30, Color.BLUE );
        uniforme.agregarParte( d1 );
        Reebok reebok = ( Reebok )uniforme.buscarParte( 38, 38 );
        assertNotNull( "No se agregó correctamente el logo reebok.", reebok );

        d1 = uniforme.crearParte( Umbro.TIPO, 50, 80, Color.BLUE );
        uniforme.agregarParte( d1 );
        Umbro umbro = ( Umbro )uniforme.buscarParte( 60, 90 );
        assertNotNull( "No se agregó correctamente el logo umbro", umbro );
    }

    /**
     * Prueba 6 - Prueba el método agregarParte para la pantaloneta. <br>
     * Métodos a probar: <br>
     * agregarParte, crearParte, buscarParte
     */
    @Test
    public void testAgregarPantaloneta( )
    {
        Parte d1 = uniforme.crearParte( Pantaloneta.TIPO, 30, 30, Color.BLUE );
        uniforme.agregarParte( d1 );
        Pantaloneta pantaloneta = ( Pantaloneta )uniforme.buscarParte( 38, 38 );
        assertNotNull( "No se agregó correctamente la pantaloneta.", pantaloneta );

    }

    /**
     * Prueba 7 - Prueba el método reiniciar <br>
     * Métodos a probar: <br>
     * reiniciar, crearParte, agregarParte, buscarParte
     */
    @Test
    public void testReiniciar( )
    {
        uniforme.reiniciar( );
        Parte d1 = uniforme.crearParte( Pantaloneta.TIPO, 30, 30, Color.BLUE );
        uniforme.agregarParte( d1 );
        uniforme.reiniciar( );

        IParte p = uniforme.buscarParte( 35, 35 );
        assertNull( "No se limpió correctamente el uniforme", p );

        uniforme.reiniciar( );
        Parte d2 = uniforme.crearParte( Adidas.TIPO, 50, 60, Color.BLUE );
        uniforme.agregarParte( d2 );
        p = uniforme.buscarParte( 55, 65 );
        assertNotNull( "No se agregó correctamente la parte", p );
    }

    /**
     * Prueba 8 - Prueba el método abrir <br>
     * Métodos a probar: <br>
     * abrir, buscarParte, eliminarParte, salvar
     */
    @Test
    public void testAbrir( )
    {
        try
        {
            uniforme.abrir( "./test/data/testUniforme.dat" );
            IParte p = uniforme.buscarParte( 256, 135 );
            assertNotNull( "Archivo cargado incorrectamente", p );
            uniforme.eliminarParte( 256, 135, CamisetaFranjas.TIPO );
            uniforme.salvar( "./test/data/test2.dat" );
            uniforme.abrir( "./test/data/test2.dat" );
            p = uniforme.buscarParte( 256, 135 );
            assertNull( "Archivo cargado incorrectamente", p );

        }
        catch( Exception e1 )
        {
            fail( "No debería generarse el error: " + e1.getMessage( ) );
        }

    }

    /**
     * Prueba 9 - Prueba el método salvar <br>
     * Métodos a probar: <br>
     * salvar, eliminarParte, abrir, buscarParte, crearParte, agregarParte
     */
    @Test
    public void testSalvar( )
    {
        setupEscenario2( );

        try
        {
            uniforme.eliminarParte( 475, 298, Adidas.TIPO );
            uniforme.salvar( "./test/data/testSalvar.dat" );
            uniforme.abrir( "./test/data/testSalvar.dat" );
            IParte p = uniforme.buscarParte( 475, 298 );
            assertNull( "Archivo guardado incorrectamente", p );
            Parte p3 = uniforme.crearParte( Reebok.TIPO, 455, 985, Color.GRAY );
            uniforme.agregarParte( p3 );
            uniforme.salvar( "./test/data/testSalvar.dat" );
            uniforme.abrir( "./test/data/testSalvar.dat" );
            p = uniforme.buscarParte( 460, 989 );
            assertNotNull( "Archivo guardado incorrectamente", p );
        }
        catch( Exception e1 )
        {
            fail( "No debería generarse el error: " + e1.getMessage( ) );
        }
    }

    /**
     * Prueba 10 - Prueba el método eliminarParte para las diferentes camisetas. <br>
     * Métodos a probar: <br>
     * eliminarParte, crearParte, agregarParte, buscarParte, eliminarParte
     */
    @Test
    public void testEliminarCamiseta( )
    {
        Parte d1 = uniforme.crearParte( CamisetaFranjas.TIPO, 30, 30, Color.CYAN );
        uniforme.agregarParte( d1 );
        CamisetaFranjas camisetaFranjas = ( CamisetaFranjas )uniforme.buscarParte( 38, 38 );
        assertNotNull( "No se agregó correctamente la camiseta rayada", camisetaFranjas );
        uniforme.eliminarParte( 38, 38, CamisetaFranjas.TIPO );
        camisetaFranjas = ( CamisetaFranjas )uniforme.buscarParte( 38, 38 );
        assertNull( "No se eliminó correctamente la camiseta rayada", camisetaFranjas );

        d1 = uniforme.crearParte( CamisetaConRaya.TIPO, 30, 30, Color.BLUE );
        uniforme.agregarParte( d1 );
        CamisetaConRaya camisetaConRaya = ( CamisetaConRaya )uniforme.buscarParte( 38, 38 );
        assertNotNull( "No se agregó correctamente la camiseta con raya", camisetaConRaya );
        uniforme.eliminarParte( 38, 38, CamisetaConRaya.TIPO );
        camisetaConRaya = ( CamisetaConRaya )uniforme.buscarParte( 38, 38 );
        assertNull( "No se eliminó correctamente la camiseta con raya", camisetaConRaya );

        d1 = uniforme.crearParte( CamisetaCuadros.TIPO, 50, 80, Color.BLUE );
        uniforme.agregarParte( d1 );
        CamisetaCuadros camisetaCuadros = ( CamisetaCuadros )uniforme.buscarParte( 60, 90 );
        assertNotNull( "No se agregó correctamente la camiseta con cuadros", camisetaCuadros );
        uniforme.eliminarParte( 38, 38, CamisetaCuadros.TIPO );
        camisetaCuadros = ( CamisetaCuadros )uniforme.buscarParte( 38, 38 );
        assertNull( "No se eliminó correctamente la camiseta con cuadros", camisetaCuadros );
    }

    /**
     * Prueba 11 - Prueba el método eliminarParte para los diferentes logos. <br>
     * Métodos a probar: <br>
     * eliminarParte, crearParte, agregarParte, buscarParte, eliminarParte
     */
    @Test
    public void testEliminarLogo( )
    {
        Parte d1 = uniforme.crearParte( Adidas.TIPO, 30, 30, Color.BLUE );
        uniforme.agregarParte( d1 );
        Adidas adidas = ( Adidas )uniforme.buscarParte( 38, 38 );
        assertNotNull( "No se agregó correctamente el logo adidas", adidas );
        uniforme.eliminarParte( 38, 38, Adidas.TIPO );
        adidas = ( Adidas )uniforme.buscarParte( 38, 38 );
        assertNull( "No se eliminó correctamente el logo", adidas );

        d1 = uniforme.crearParte( Reebok.TIPO, 30, 30, Color.BLUE );
        uniforme.agregarParte( d1 );
        Reebok reebok = ( Reebok )uniforme.buscarParte( 38, 38 );
        assertNotNull( "No se agregó correctamente el logo reebok", reebok );
        uniforme.eliminarParte( 38, 38, Reebok.TIPO );
        reebok = ( Reebok )uniforme.buscarParte( 38, 38 );
        assertNull( "No se eliminó correctamente el logo", reebok );

        d1 = uniforme.crearParte( Umbro.TIPO, 50, 80, Color.BLUE );
        uniforme.agregarParte( d1 );
        Umbro umbro = ( Umbro )uniforme.buscarParte( 60, 90 );
        assertNotNull( "No se agregó correctamente el logo umbro", umbro );
        uniforme.eliminarParte( 38, 38, Umbro.TIPO );
        umbro = ( Umbro )uniforme.buscarParte( 38, 38 );
        assertNull( "No se eliminó correctamente el logo", umbro );
    }

    /**
     * Prueba 12 - Prueba el método eliminarParte para la pantaloneta. <br>
     * Métodos a probar: <br>
     * eliminarParte, crearParte, agregarParte, buscarParte, eliminarParte
     */
    @Test
    public void testEliminarPantaloneta( )
    {
        Parte d1 = uniforme.crearParte( Pantaloneta.TIPO, 30, 30, Color.BLUE );
        uniforme.agregarParte( d1 );
        Pantaloneta pantaloneta = ( Pantaloneta )uniforme.buscarParte( 38, 38 );
        assertNotNull( "No se agregó correctamente la pantaloneta.", pantaloneta );
        uniforme.eliminarParte( 38, 38, Pantaloneta.TIPO );
        pantaloneta = ( Pantaloneta )uniforme.buscarParte( 38, 38 );
        assertNull( "No se eliminó correctamente la pantaloneta.", pantaloneta );

    }

    /**
     * Prueba 13 - Prueba el método cambiarPosicionDibujo <br>
     * Métodos a probar: <br>
     * cambiarPosicionDibujo, buscarParte
     */
    @Test
    public void testCambiarPosicionDibujo( )
    {
        try
        {
            IParte dibujo = uniforme.crearParte( CamisetaConRaya.TIPO, 900, 900, Color.GREEN );
            uniforme.agregarParte( dibujo );
            uniforme.cambiarPosicionParte( 910, 910, CamisetaConRaya.TIPO, 300, 300 );
            IParte p = uniforme.buscarParte( 910, 910 );
            assertNull( "No cambio la posición de la parte correctamente", p );
            CamisetaConRaya cc = ( CamisetaConRaya )uniforme.buscarParte( 320, 320 );
            assertNotNull( "No cambio la posición de la parte correctamente", cc );
        }
        catch( Exception e )
        {
            fail( "No debería fallar" );
        }
    }

    /**
     * Prueba 14 - Prueba el método buscarParte <br>
     * Métodos a probar: <br>
     * buscarParte <br>
     * Caso de prueba: <br>
     * Hay dibujos en las coordenadas buscadas
     */
    @Test
    public void testbuscarParte1( )
    {
        try
        {
            IParte dibujo = null;

            dibujo = uniforme.crearParte( Adidas.TIPO, 100, 100, Color.WHITE );
            uniforme.agregarParte( dibujo );
            Adidas p = ( Adidas )uniforme.buscarParte( 120, 130 );
            assertNotNull( "Debería encontrar la parte", p );

            dibujo = uniforme.crearParte( Adidas.TIPO, 100, 100, Color.BLUE );
            uniforme.agregarParte( dibujo );
            p = ( Adidas )uniforme.buscarParte( 110, 110 );
            assertNotNull( "Debería encontrar la parte", p );

            dibujo = uniforme.crearParte( Pantaloneta.TIPO, 120, 120, Color.BLUE );
            uniforme.agregarParte( dibujo );
            Pantaloneta gp = ( Pantaloneta )uniforme.buscarParte( 135, 135 );
            assertNotNull( "Debería encontrar la parte", gp );

            dibujo = uniforme.crearParte( Pantaloneta.TIPO, 60, 290, Color.BLUE );
            uniforme.agregarParte( dibujo );
            gp = ( Pantaloneta )uniforme.buscarParte( 65, 292 );
            assertNotNull( "Debería encontrar la parte", gp );

            dibujo = uniforme.crearParte( CamisetaFranjas.TIPO, 25, 280, Color.BLUE );
            uniforme.agregarParte( dibujo );
            CamisetaFranjas m = ( CamisetaFranjas )uniforme.buscarParte( 30, 290 );
            assertNotNull( "Debería encontrar la parte", m );

            dibujo = uniforme.crearParte( CamisetaFranjas.TIPO, 30, 290, Color.BLUE );
            uniforme.agregarParte( dibujo );
            m = ( CamisetaFranjas )uniforme.buscarParte( 35, 300 );
            assertNotNull( "Debería encontrar la parte", m );

        }
        catch( Exception e )
        {
            fail( "No debería fallar (" + e.getMessage( ) + ")" );
        }
    }

    /**
     * Prueba 15 - Prueba el método buscarParte <br>
     * Métodos a probar: <br>
     * buscarParte <br>
     * Caso de prueba: <br>
     * No hay dibujos en las coordenadas buscadas
     */
    @Test
    public void testbuscarParte2( )
    {
        try
        {
            Adidas mo = ( Adidas )uniforme.buscarParte( 0, 100 );
            assertNull( "No debería encontrar la parte", mo );

            CamisetaConRaya dr = ( CamisetaConRaya )uniforme.buscarParte( 200, 555 );
            assertNull( "No debería encontrar la parte", dr );

            Pantaloneta ct = ( Pantaloneta )uniforme.buscarParte( 430, 2 );
            assertNull( "No debería encontrar la parte", ct );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
            fail( "No debería fallar (" + e.getMessage( ) + ")" );
        }
    }

}