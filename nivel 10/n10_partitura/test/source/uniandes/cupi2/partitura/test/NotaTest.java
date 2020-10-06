/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: NotaTest.java 604 2006-11-07 04:47:33Z da-romer $ 
 * Universidad de los Andes (Bogot� - Colombia) 
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Todos los derechos reservados 2005 
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_partitura
 * Autor: Diana Puentes - Jul 29, 2005
 * Modificado por: Daniel Francisco Romero Acero - 21-marzo-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.partitura.test;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import junit.framework.TestCase;
import uniandes.cupi2.partitura.mundo.Blanca;
import uniandes.cupi2.partitura.mundo.FormatoInvalidoExcepcion;
import uniandes.cupi2.partitura.mundo.INota;
import uniandes.cupi2.partitura.mundo.Nota;
import uniandes.cupi2.partitura.mundo.Redonda;

/**
 * Prueba el funcionamiento de la clase Nota
 */
public class NotaTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * nota1 para realizar pruebas
     */
    private INota nota1;

    /**
     * nota2 para realizar pruebas
     */
    private INota nota2;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Crea una redonda
     */
    public void setupEscenario1( )
    {
        nota1 = new Redonda( Nota.DO, Nota.NORMAL, Color.blue );

    }

    /**
     * Crea una blanca
     */
    public void setupEscenario2( )
    {

        nota2 = new Blanca( Nota.LA, Nota.SOSTENIDO, Color.blue );

    }

    /**
     * Prueba que la creaci�n de las notas y la devoluci�n de sus atributos se haga correctamente. <br>
     * <b> M�todos a probar: </b> <br>
     * darNombre, darTipo, darClase, darColor. <br>
     * <b> Objetivo: </b> probar que los m�todos que retornan los atributos devuelvan los valores correctos. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se crea una nota con nombre X. El pedir el nombre de la nota se debe obtener X. <br>
     * 2. Se crea una nota con tipo X. El pedir el tipo de la nota se debe obtener X. <br>
     * 3. Se crea una nota con clase X. El pedir la clase de la nota se debe obtener X. <br>
     * 4. Se crea una nota con color X. El pedir el color de la nota se debe obtener X. <br>
     */
    public void testDarAtributos( )
    {
        setupEscenario1( );

        assertEquals( "La nota no se creo correctamente", Nota.DO, nota1.darNombre( ) );
        assertEquals( "La nota no se creo correctamente", Nota.NORMAL, nota1.darTipo( ) );
        assertEquals( "La nota no se creo correctamente", "Redonda", nota1.darClase( ) );
        assertEquals( "La nota no se creo correctamente", Color.BLUE, nota1.darColor( ) );

    }

    /**
     * Verifica que el punto esta dentro de la nota. <br>
     * <b> M�todos a probar: </b> <br>
     * estaDentro. <br>
     * <b> Objetivo: </b> probar que el m�todo estaDentro sea capaz de indicar correctamente cuando un punto est� dentro de la nota. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al verificar si un punto est� que se sabe est� fuera de la nota . <br>
     * 2. Se crea una nota con tipo X. El pedir el tipo de la nota se debe obtener X. <br>
     * 3. Se crea una nota con clase X. El pedir la clase de la nota se debe obtener X. <br>
     * 4. Se crea una nota con color X. El pedir el color de la nota se debe obtener X. <br>
     */
    public void testEstaDentro( )
    {
        setupEscenario1( );

        boolean dentro = nota1.estaDentro( 20, 20, 30 ); // Fuera

        assertEquals( "La verificaci�n del punto se realiz� incorrectamente", false, dentro );

        dentro = nota1.estaDentro( 70, 154, 0 ); // dentro

        assertEquals( "La verificaci�n del punto se realiz� incorrectamente", true, dentro );
    }

    /**
     * Verifica que una nota se guarde correctamente
     */
    public void testGuardar( )
    {
        setupEscenario1( );

        PrintWriter out;
        try
        {
            out = new PrintWriter( "./test/data/testPartitura.dat" );
            nota1.guardar( out );

            out.close( );

            BufferedReader br = new BufferedReader( new FileReader( "./test/data/testPartitura.dat" ) );

            String linea = br.readLine( ); // Clase

            INota n = new Redonda( br );

            assertEquals( "La nota se guard� incorrectamente", nota1.darTipo( ), n.darTipo( ) );
            assertEquals( "La nota se guard� incorrectamente", nota1.darDuracion( ), n.darDuracion( ) );
            assertEquals( "La nota se guard� incorrectamente", nota1.darClase( ), n.darClase( ) );
            assertEquals( "La nota se guard� incorrectamente", nota1.darColor( ), n.darColor( ) );
            assertEquals( "La nota se guard� incorrectamente", nota1.darNombre( ), n.darNombre( ) );

            br.close( );

        }
        catch( FileNotFoundException e )
        {
            e.printStackTrace( );
        }
        catch( IOException e )
        {
            e.printStackTrace( );
        }
        catch( FormatoInvalidoExcepcion e )
        {
            e.printStackTrace( );
        }

        setupEscenario2( );

        try
        {
            out = new PrintWriter( "./test/data/testPartitura.dat" );
            nota2.guardar( out );

            out.close( );

            BufferedReader br = new BufferedReader( new FileReader( "./test/data/testPartitura.dat" ) );

            String clase = br.readLine( ); // Clase

            INota n = new Blanca( br );

            assertEquals( "La nota se guard� incorrectamente", nota2.darTipo( ), n.darTipo( ) );
            assertEquals( "La nota se guard� incorrectamente", nota2.darDuracion( ), n.darDuracion( ) );
            assertEquals( "La nota se guard� incorrectamente", nota2.darClase( ), n.darClase( ) );
            assertEquals( "La nota se guard� incorrectamente", nota2.darColor( ), n.darColor( ) );
            assertEquals( "La nota se guard� incorrectamente", nota2.darNombre( ), n.darNombre( ) );

            br.close( );

        }
        catch( FileNotFoundException e )
        {
            e.printStackTrace( );
        }
        catch( IOException e )
        {
            e.printStackTrace( );
        }
        catch( FormatoInvalidoExcepcion e )
        {
            e.printStackTrace( );
        }
    }
}
