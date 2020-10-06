/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_fabricaDeUniformes
 * Autor: Equipo Cupi2 2018-1
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.fabricaDeUniformes.test;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import uniandes.cupi2.fabricaDeUniformes.mundo.Adidas;
import uniandes.cupi2.fabricaDeUniformes.mundo.Camiseta;
import uniandes.cupi2.fabricaDeUniformes.mundo.CamisetaConRaya;
import uniandes.cupi2.fabricaDeUniformes.mundo.CamisetaConRaya.DireccionRaya;
import uniandes.cupi2.fabricaDeUniformes.mundo.CamisetaFranjas;
import uniandes.cupi2.fabricaDeUniformes.mundo.IParte;
import uniandes.cupi2.fabricaDeUniformes.mundo.Logo;
import uniandes.cupi2.fabricaDeUniformes.mundo.Pantaloneta;
import uniandes.cupi2.fabricaDeUniformes.mundo.Parte;
import uniandes.cupi2.fabricaDeUniformes.mundo.Camiseta.Manga;

/**
 * Clase de prueba para IParte
 */
public class ParteTest
{

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------
    /**
     * La parte donde se har�n las pruebas.
     */
    private IParte parte;

    // -------------------------------------------------------------
    // Escenarios
    // -------------------------------------------------------------

    /**
     * Construye una nueva camiseta de tipo camiseta con raya.
     */
    @Before
    public void setupEscenario1( )
    {
        parte = new CamisetaConRaya( 120, 120, Color.WHITE );
    }
    
    /**
     * Construye un nuevo logo de tipo adidas.
     */
    public void setupEscenario2( )
    {
        parte = new Adidas( 30, 30, Color.BLUE, "Prueba" );
    }

    /**
     * Construye una nueva pantaloneta.
     */
    public void setupEscenario3( )
    {
        parte = new Pantaloneta( 350, 221,Color.ORANGE);

    }



    // -------------------------------------------------------------
    // M�todos de prueba
    // -------------------------------------------------------------

    /**
     * Prueba 1 - Prueba los m�todos constructores de la clase Camiseta con raya.<br>
     * M�todos a probar: <br>
     * CamisetaConRaya<br>
     * darTipo<br>
     * darX<br>
     * darY<br>
     * darColor<br>
     * darColor2<br>
     * darAlto<br>
     * darAncho<br>
     * darManga<br>
     * darDireccion<br>
     */
    @Test
    public void testCamisetaConRaya( )
    {
        assertEquals( "La parte se cre� incorrectamente", "CamisetaConRaya", CamisetaConRaya.TIPO );
        assertEquals( "La parte se cre� incorrectamente", CamisetaConRaya.TIPO, parte.darTipo( ) );
        assertEquals( "La parte se cre� incorrectamente", 120, parte.darX( ) );
        assertEquals( "La parte se cre� incorrectamente", 120, parte.darY( ) );
        assertEquals( "La parte se cre� incorrectamente", Color.WHITE, parte.darColor( ) );
        assertEquals( "La parte se cre� incorrectamente", Camiseta.ALTO, parte.darAlto( ) );
        assertEquals( "La parte se cre� incorrectamente", Camiseta.ANCHO, parte.darAncho( ) );

        CamisetaConRaya camiseta = ( CamisetaConRaya )parte;
        assertEquals( "La camiseta se cre� incorrectamente", Manga.CORTA, camiseta.darManga( ) );
        assertEquals( "La camiseta se cre� incorrectamente", DireccionRaya.DIAGONAL_DERECHA, camiseta.darDireccion( ));
        // Prueba a partir de la lectura de un archivo
        try
        {
            BufferedReader br = new BufferedReader( new FileReader( "./test/data/testCamisetaConRaya.dat" ) );

            String tipo = br.readLine( ); // Tipo

            parte = new CamisetaConRaya( br );
          
            camiseta = ( CamisetaConRaya )parte;
            assertEquals( "La parte se carg� incorrectamente", CamisetaConRaya.TIPO, parte.darTipo( ) );
            assertEquals( "La parte se carg� incorrectamente", 299, parte.darX( ) );
            assertEquals( "La parte se carg� incorrectamente", 180, parte.darY( ) );
            assertEquals( "La parte se carg� incorrectamente", new Color( -3355648 ), parte.darColor( ) );
            assertEquals( "La parte se cre� incorrectamente", 200, parte.darAlto( ) );
            assertEquals( "La parte se cre� incorrectamente", 132, parte.darAncho( ) );
            assertEquals("La parte de cre� incorrectamente", new Color(-3354648), camiseta.darColorSecundario( ));
            
            assertEquals( "La camiseta se cre� incorrectamente", Manga.LARGA, camiseta.darManga( ) );
            assertEquals( "La camiseta se cre� incorrectamente", DireccionRaya.VERTICAL, camiseta.darDireccion( ));

            br.close( );
        }
        catch( FileNotFoundException e )
        {
            fail( "No se debe generar el error: " + e.getMessage( ) );
        }
        catch( Exception e1 )
        {
            fail( "No se debe generar el error: " + e1.getMessage( ) );
        }
    }

    /**
     * Prueba 2 - Prueba los m�todos constructores de la clase Logo.<br>
     * M�todos a probar: <br>
     * GloboPensamiento<br>
     * darTipo<br>
     * darX<br>
     * darY<br>
     * darColor<br>
     * darAlto<br>
     * darAncho<br>
     */
    @Test
    public void testLogo( )
    {
        setupEscenario2( );
        assertEquals( "La parte se cre� incorrectamente", "Adidas", Adidas.TIPO );
        assertEquals( "La parte se cre� incorrectamente", Adidas.TIPO, parte.darTipo( ) );
        assertEquals( "La parte se cre� incorrectamente", 30, parte.darX( ) );
        assertEquals( "La parte se cre� incorrectamente", 30, parte.darY( ) );
        assertEquals( "La parte se cre� incorrectamente", Color.BLUE, parte.darColor( ) );
        assertEquals( "La parte se cre� incorrectamente", 80, parte.darAlto( ) );
        assertEquals( "La parte se cre� incorrectamente", 80, parte.darAncho( ) );
        Adidas adidas = (Adidas) parte; 
        assertEquals( "La parte se cre� incorrectamente", "Prueba", adidas.darTexto( ) );


        // Prueba a partir de la lectura de un archivo
        try
        {
            BufferedReader br = new BufferedReader( new FileReader( "./test/data/testAdidas.dat" ) );

            String tipo = br.readLine( ); // Tipo

            parte = new Adidas( br );
            adidas = (Adidas) parte; 
            assertEquals( "La parte se carg� incorrectamente", Adidas.TIPO, parte.darTipo( ) );
            assertEquals( "La parte se carg� incorrectamente", 57, parte.darX( ) );
            assertEquals( "La parte se carg� incorrectamente", 30, parte.darY( ) );
            assertEquals( "La parte se carg� incorrectamente", new Color( -16724788 ), parte.darColor( ) );
            assertEquals( "La parte se cre� incorrectamente", 80, parte.darAlto( ) );
            assertEquals( "La parte se cre� incorrectamente", 80, parte.darAncho( ) );
            assertEquals( "La parte se cre� incorrectamente", "Prueba", adidas.darTexto( ) );


            br.close( );
        }
        catch( FileNotFoundException e )
        {
            fail( "No se debe generar el error: " + e.getMessage( ) );
        }
        catch( Exception e1 )
        {
            fail( "No se debe generar el error: " + e1.getMessage( ) );
        }
    }
    
    /**
     * Prueba 3 - Prueba los m�todos constructores de la clase Pantaloneta.<br>
     * M�todos a probar: <br>
     * Pantaloneta<br>
     * darTipo<br>
     * darX<br>
     * darY<br>
     * darColor<br>
     * darAlto<br>
     * darAncho<br>
     */
    @Test
    public void testPantaloneta( )
    {
        setupEscenario3( );
        assertEquals( "La parte se cre� incorrectamente", "Pantaloneta", Pantaloneta.TIPO );
        assertEquals( "La parte se cre� incorrectamente", Pantaloneta.TIPO, parte.darTipo( ) );
        assertEquals( "La parte se cre� incorrectamente", 350, parte.darX( ) );
        assertEquals( "La parte se cre� incorrectamente", 221, parte.darY( ) );
        assertEquals( "La parte se cre� incorrectamente", Color.ORANGE, parte.darColor( ) );
        assertEquals( "La parte se cre� incorrectamente", 120, parte.darAlto( ) );
        assertEquals( "La parte se cre� incorrectamente", 132, parte.darAncho( ) );

        // Prueba a partir de la lectura de un archivo
        try
        {
            BufferedReader br = new BufferedReader( new FileReader( "./test/data/testPantaloneta.dat" ) );

            String tipo = br.readLine( ); // Tipo

            parte = new Pantaloneta( br );
            
            assertEquals( "La parte se carg� incorrectamente", Pantaloneta.TIPO, parte.darTipo( ) );
            assertEquals( "La parte se carg� incorrectamente", 5, parte.darX( ) );
            assertEquals( "La parte se carg� incorrectamente", 10, parte.darY( ) );
            assertEquals( "La parte se carg� incorrectamente", new Color( -2336190 ), parte.darColor( ) );
            assertEquals( "La parte se cre� incorrectamente", 120, parte.darAlto( ) );
            assertEquals( "La parte se cre� incorrectamente", 132, parte.darAncho( ) );


            br.close( );
        }
        catch( FileNotFoundException e )
        {
            fail( "No se debe generar el error: " + e.getMessage( ) );
        }
        catch( Exception e1 )
        {
            fail( "No se debe generar el error: " + e1.getMessage( ) );
        }
    }
    
    
    /**
     * Prueba 4 - Prueba el m�todo estaDentro <br>
     * M�todos a probar: <br>
     * estaDentro<br>
     * Casos de prueba:<br>
     * 1. Los puntos no est�n adentro de la parte. <br>
     * 2. Los puntos est�n adentro de la parte.
     */
    @Test
    public void testEstaDentro( )
    {
        // Caso de prueba 1
        assertFalse( "El punto no est� adentro de la imagen", parte.estaDentro( 2, 2 ) );
        assertFalse( "El punto no est� adentro de la imagen", parte.estaDentro( 600, 600 ) );

        // Caso de prueba 2
        assertTrue( "El punto est� adentro de la imagen", parte.estaDentro( 130, 130 ) );
        assertTrue( "El punto est� adentro de la imagen", parte.estaDentro( 125, 135 ) );
    }

    /**
     * Prueba 5 - Prueba el m�todo cambiarX <br>
     * M�todos a probar: <br>
     * cambiarX<br>
     * darX
     */
    @Test
    public void testCambiarX( )
    {
        parte.cambiarX( 400 );
        assertEquals( "No hizo el cambio correctamente", 400, parte.darX( ) );

        parte.cambiarX( 50 );
        assertEquals( "No hizo el cambio correctamente", 50, parte.darX( ) );
    }

    /**
     * Prueba 6 - Prueba el m�todo cambiarY <br>
     * M�todos a probar: <br>
     * cambiarY<br>
     * darY
     */
    @Test
    public void testCambiarY( )
    {
        parte.cambiarY( 400 );
        assertEquals( "No hizo el cambio correctamente", 400, parte.darY( ) );

        parte.cambiarY( 50 );
        assertEquals( "No hizo el cambio correctamente", 50, parte.darY( ) );
    }

    /**
     * Prueba 7 - Prueba el m�todo guardar para Oso<br>
     * M�todos a probar: <br>
     * guardar<br>
     * Camiseta<br>
     * CamisetaConRaya<br>
     * darTipo<br>
     * darX<br>
     * darY<br>
     * darColor<br>
     * darColor2<br>
     * cambiarManga<br>
     * cambiarDireccion<br>
     */
    @Test
    public void testGuardarCamiseta( )
    {
        PrintWriter out;
        try
        {
            out = new PrintWriter( "./test/data/testGuardarCamisetaConRaya.dat" );
            CamisetaConRaya camiseta = ( CamisetaConRaya )parte;
            camiseta.cambiarManga( Manga.LARGA );
            camiseta.cambiarDireccion( DireccionRaya.VERTICAL );
            parte.guardar( out );
            out.close( );
            BufferedReader br = new BufferedReader( new FileReader( "./test/data/testGuardarCamisetaConRaya.dat" ) );
            String tipo = br.readLine( ); // Tipo
            camiseta = new CamisetaConRaya( br );
            assertEquals( "La parte se guard� incorrectamente", parte.darTipo( ), tipo );
            assertEquals( "La parte se guard� incorrectamente", parte.darX( ), camiseta.darX( ) );
            assertEquals( "La parte se guard� incorrectamente", parte.darY( ), camiseta.darY( ) );
            assertEquals( "La parte se guard� incorrectamente", parte.darColor( ), camiseta.darColor( ) );
            assertEquals( "La parte se guard� incorrectamente", ((Camiseta)parte).darColorSecundario( ), camiseta.darColorSecundario( ) );
            assertEquals( "La parte se guard� incorrectamente", ((Camiseta)parte).darManga( ), camiseta.darManga( ) );
            assertEquals( "La parte se guard� incorrectamente", ((CamisetaConRaya)parte).darDireccion( ), camiseta.darDireccion( ) );
            
            br.close( );
        }
        catch( Exception e )
        {
            fail( "No deber�a generar error: " + e.getMessage( ) );
        }
    }

    /**
     * Prueba 8 - Prueba el m�todo guardar para GloboPensamiento<br>
     * M�todos a probar: <br>
     * guardar<br>
     * GloboPensamiento<br>
     * darTipo<br>
     * darX<br>
     * darY<br>
     * darColor
     */
    @Test
    public void testGuardarLogo( )
    {
        setupEscenario2( );
        PrintWriter out;
        try
        {
            out = new PrintWriter( "./test/data/testGuardarLogo.dat" );
            parte.guardar( out );
            out.close( );
            BufferedReader br = new BufferedReader( new FileReader( "./test/data/testGuardarLogo.dat" ) );
            String tipo = br.readLine( ); // Tipo
            Logo p = new Adidas( br );
            assertEquals( "La parte se guard� incorrectamente", parte.darTipo( ), tipo );
            assertEquals( "La parte se guard� incorrectamente", parte.darX( ), p.darX( ) );
            assertEquals( "La parte se guard� incorrectamente", parte.darY( ), p.darY( ) );
            assertEquals( "La parte se guard� incorrectamente", parte.darColor( ), p.darColor( ) );
            
            assertEquals( "La parte se guard� incorrectamente", "Prueba", p.darTexto( ) );
            
            br.close( );
        }
        catch( Exception e )
        {
            fail( "No deber�a generar error: " + e.getMessage( ) );
        }
    }

    /**
     * Prueba 9 - Prueba el m�todo guardar para Pantaloneta<br>
     * M�todos a probar: <br>
     * guardar<br>
     * Pantaloneta<br>
     * darTipo<br>
     * darX<br>
     * darY<br>
     * darColor
     */
    @Test
    public void testGuardarPantaloneta( )
    {
        setupEscenario3( );

        PrintWriter out;
        try
        {
            out = new PrintWriter( "./test/data/testGuardarPantaloneta.dat" );
            parte.guardar( out );
            out.close( );
            BufferedReader br = new BufferedReader( new FileReader( "./test/data/testGuardarPantaloneta.dat" ) );
            String tipo = br.readLine( ); // Tipo
            Pantaloneta p = new Pantaloneta( br );
            assertEquals( "La parte se guard� incorrectamente", parte.darTipo( ), tipo );
            assertEquals( "La parte se guard� incorrectamente", parte.darX( ), p.darX( ) );
            assertEquals( "La parte se guard� incorrectamente", parte.darY( ), p.darY( ) );
            assertEquals( "La parte se guard� incorrectamente", parte.darColor( ), p.darColor( ) );
            
        }
        catch( Exception e )
        {
            fail( "No deber�a generar error: " + e.getMessage( ) );
        }
    }
}