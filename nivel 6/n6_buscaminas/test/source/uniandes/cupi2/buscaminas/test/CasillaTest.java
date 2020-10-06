/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n6_buscaminas
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.buscaminas.test;

import uniandes.cupi2.buscaminas.mundo.Casilla;
import uniandes.cupi2.buscaminas.mundo.Casilla.Tipo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Prueba la clase Casilla
 */
public class CasillaTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la casilla utilizada para las pruebas
     */
    private Casilla casilla;

    // -----------------------------------------------------------------
    // métodos
    // -----------------------------------------------------------------

    /**
     * Construye el escenario 1 donde hay una casilla marcada
     */
    private void setupEscenario1( )
    {
        casilla = new Casilla( Tipo.MINADA, Tipo.MARCADA, 1, 1 );
    }

    /**
     * Construye el escenario 2 donde hay una casilla marcada equivocada
     */
    private void setupEscenario2( )
    {
        casilla = new Casilla( Tipo.VACIA, Tipo.MARCADA_EQUIVOCADA, 6, 2 );
    }

    /**
     * Construye el escenario 3 donde hay una casilla sin destapar
     */
    private void setupEscenario3( )
    {
        casilla = new Casilla( Tipo.VACIA, Tipo.TAPADA, 5, 8 );
    }

    /**
     * Verificar el método darEstado
     */
    @Test
    public void testDarEstado( )
    {
        setupEscenario1( );
        assertEquals( "La casilla esta marcada", Tipo.MARCADA, casilla.darEstado( ) );
        setupEscenario2( );
        assertEquals( "La casilla esta marcada equivocada", Tipo.MARCADA_EQUIVOCADA, casilla.darEstado( ) );
        setupEscenario3( );
        assertEquals( "La casilla esta sin destapar", Tipo.TAPADA, casilla.darEstado( ) );
    }

    /**
     * Verificar el método darFila
     */
    @Test
    public void testDarFila( )
    {
        setupEscenario1( );
        assertEquals( "La fila esta equivocada", 1, casilla.darFila( ) );
        setupEscenario2( );
        assertEquals( "La fila esta equivocada", 6, casilla.darFila( ) );
        setupEscenario3( );
        assertEquals( "La fila esta equivocada", 5, casilla.darFila( ) );
    }

    /**
     * Verificar el método darColumna
     */
    @Test
    public void testDarColumna( )
    {
        setupEscenario1( );
        assertEquals( "La columna esta equivocada", 1, casilla.darColumna( ) );
        setupEscenario2( );
        assertEquals( "La columna esta equivocada", 2, casilla.darColumna( ) );
        setupEscenario3( );
        assertEquals( "La columna esta equivocada", 8, casilla.darColumna( ) );
    }

}
