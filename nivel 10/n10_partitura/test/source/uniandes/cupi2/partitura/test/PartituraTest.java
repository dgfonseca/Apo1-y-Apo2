/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: PartituraTest.java 600 2006-11-06 06:16:53Z da-romer $ 
 * Universidad de los Andes (Bogotá - Colombia) 
 * Departamento de Ingeniería de Sistemas y Computación 
 * Todos los derechos reservados 2005 
 * 
 * Proyecto Cupi2 
 * Ejercicio: n10_partitura
 * Autor: Diana Puentes - Jul 29, 2005
 * Modifcado por: Daniel Francisco Romero Acero - 21-marzo-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.partitura.test;

import java.awt.Color;
import java.io.IOException;

import junit.framework.TestCase;
import uniandes.cupi2.partitura.mundo.Blanca;
import uniandes.cupi2.partitura.mundo.Corchea;
import uniandes.cupi2.partitura.mundo.FormatoInvalidoExcepcion;
import uniandes.cupi2.partitura.mundo.INota;
import uniandes.cupi2.partitura.mundo.Negra;
import uniandes.cupi2.partitura.mundo.Nota;
import uniandes.cupi2.partitura.mundo.Partitura;
import uniandes.cupi2.partitura.mundo.Redonda;
import uniandes.cupi2.partitura.mundo.Semicorchea;

/**
 * Prueba el funcionamiento de la clase partitura
 */
public class PartituraTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * partitura para realizar pruebas
     */
    private Partitura partitura;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Crea un escenario con una partitura inicializada a partir del archivo de notas
     */
    public void setupEscenario1( )
    {
        partitura = new Partitura( );
        try
        {
            partitura.abrir( "./data/cumpleanhos.dat" );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }

    /**
     * Verifica que las notas de la partitura sean borradas correctamente. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarNotas, adicionarNota. <br>
     * <b> Objetivo: </b> probar que el método eliminarNotas() sea capaz de eliminar las notas correctamente. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al eliminar las notas de una partitura esta debe quedar sin notas.
     */
    public void testEliminarNotasPartitura( )
    {
        setupEscenario1( );

        partitura.eliminarNotas( );
        partitura.adicionarNota( new Corchea( Nota.MI, Nota.SOSTENIDO, Color.RED ) );
        partitura.eliminarNotas( );

        INota n = partitura.darNota( 0 );

        assertNull( "No se limpió correctamente el mapa", n );

        partitura.eliminarNotas( );
        partitura.adicionarNota( new Corchea( Nota.MI, Nota.SOSTENIDO, Color.RED ) );

        n = partitura.darNota( 0 );

        assertNotNull( "No se agrego correctamente la construcción", n );
    }

    /**
     * Verifica que una redonda se agregue correctamente. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarNotas, adicionarNota. <br>
     * <b> Objetivo: </b> probar que el método adicionarNota() sea capaz de adicionar una redonda correctamente. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se adiciona una redonda. Al pedir la redonda está debe ser retornada correctamente.
     */
    public void testAdicionarRedonda( )
    {
        setupEscenario1( );
        partitura.eliminarNotas( );

        partitura.adicionarNota( new Redonda( Nota.SI, Nota.NORMAL, Color.CYAN ) );

        Redonda redonda = ( Redonda )partitura.darNota( 0 );
        assertNotNull( "No se agregó correctamente la redonda", redonda );
    }

    /**
     * Verifica que una blanca se agregue correctamente. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarNotas, adicionarNota. <br>
     * <b> Objetivo: </b> probar que el método adicionarNotas() sea capaz de adicionar una blanca correctamente. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se adiciona una blanca. Al pedir la blanca está debe ser retornada correctamente.
     */
    public void testAdicionarBlanca( )
    {
        setupEscenario1( );
        partitura.eliminarNotas( );

        partitura.adicionarNota( new Blanca( Nota.LA, Nota.NORMAL, Color.DARK_GRAY ) );

        Blanca blanca = ( Blanca )partitura.darNota( 0 );
        assertNotNull( "No se agregó correctamente la blanca", blanca );
    }

    /**
     * Verifica que una negra se agregue correctamente. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarNotas, adicionarNota. <br>
     * <b> Objetivo: </b> probar que el método adicionarNota() sea capaz de adicionar una negra correctamente. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se adiciona una negra. Al pedir la negra está debe ser retornada correctamente.
     */
    public void testAdicionarNegra( )
    {
        setupEscenario1( );
        partitura.eliminarNotas( );

        partitura.adicionarNota( new Negra( Nota.SI, Nota.NORMAL, Color.GREEN ) );

        Negra negra = ( Negra )partitura.darNota( 0 );
        assertNotNull( "No se agregó correctamente la negra", negra );
    }

    /**
     * Verifica que una corchea se agregue correctamente. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarNotas, adicionarNota. <br>
     * <b> Objetivo: </b> probar que el método adicionarNota() sea capaz de adicionar una corchea correctamente. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se adiciona una corchea. Al pedir la corchea está debe ser retornada correctamente.
     */
    public void testAdicionarCorchea( )
    {
        setupEscenario1( );
        partitura.eliminarNotas( );

        partitura.adicionarNota( new Corchea( Nota.SI, Nota.NORMAL, Color.GREEN ) );

        Corchea corchea = ( Corchea )partitura.darNota( 0 );
        assertNotNull( "No se agregó correctamente la corchea", corchea );
    }

    /**
     * Verifica que una semicorchea se agregue correctamente. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarNotas, adicionarNota. <br>
     * <b> Objetivo: </b> probar que el método adicionarNota() sea capaz de adicionar una semicorchea correctamente. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se adiciona una semicorchea. Al pedir la semicorchea está debe ser retornada correctamente.
     */
    public void testAdicionarSemicorchea( )
    {
        setupEscenario1( );
        partitura.eliminarNotas( );

        partitura.adicionarNota( new Semicorchea( Nota.SI, Nota.NORMAL, Color.GREEN ) );

        Semicorchea semicorchea = ( Semicorchea )partitura.darNota( 0 );
        assertNotNull( "No se agregó correctamente la semicorchea", semicorchea );
    }

    /**
     * Verifica que un mapa sea cargado correctamente
     */
    public void testAbrir( )
    {
        setupEscenario1( );

        try
        {
            partitura.abrir( "./test/data/cumpleanhos.dat" );

            INota n = partitura.darNota( 5 );

            assertNotNull( "Archivo cargado incorrectamente", n );

            partitura.eliminarNota( 24 );

            partitura.salvar( "./test/data/test2.dat" );
            partitura.abrir( "./test/data/test2.dat" );

            n = partitura.darNota( 24 );

            assertNull( "Archivo cargado incorrectamente", n );

        }
        catch( IOException e1 )
        {
            fail( "No debería generarse el error" );
        }
        catch( FormatoInvalidoExcepcion e )
        {

            fail( "No debería generarse el error" );
        }

    }

    /**
     * Verifica que un mapa sea guardado correctamente
     */
    public void testGuardar( )
    {
        setupEscenario1( );

        try
        {
            partitura.eliminarNota( 24 );

            partitura.salvar( "./test/data/test2.dat" );
            partitura.abrir( "./test/data/test2.dat" );

            INota n = partitura.darNota( 24 );

            assertNull( "Archivo guardado incorrectamente", n );

            partitura.adicionarNota( new Semicorchea( Nota.SOL, Nota.SOSTENIDO, Color.BLACK ) );

            partitura.salvar( "./test/data/test2.dat" );
            partitura.abrir( "./test/data/test2.dat" );

            n = partitura.darNota( 24 );

            assertNotNull( "Archivo guardado incorrectamente", n );
        }
        catch( IOException e1 )
        {
            fail( "No debería generarse el error" );
        }
        catch( FormatoInvalidoExcepcion e )
        {
            fail( "No debería generarse el error" );
        }

    }

}
