/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: MapaCiudadTest.java,v 1.2 2007/04/12 14:10:28 carl-veg Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_mapaCiudad
 * Autor: Daniel Francisco Romero Acero - 25-ene-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.mapaCiudad.test;

import java.awt.Color;
import java.io.IOException;

import junit.framework.TestCase;
import uniandes.cupi2.mapaCiudad.mundo.Calle;
import uniandes.cupi2.mapaCiudad.mundo.Carrera;
import uniandes.cupi2.mapaCiudad.mundo.Carretera;
import uniandes.cupi2.mapaCiudad.mundo.Casa;
import uniandes.cupi2.mapaCiudad.mundo.Construccion;
import uniandes.cupi2.mapaCiudad.mundo.Edificacion;
import uniandes.cupi2.mapaCiudad.mundo.Edificio;
import uniandes.cupi2.mapaCiudad.mundo.Esquina1;
import uniandes.cupi2.mapaCiudad.mundo.Esquina2;
import uniandes.cupi2.mapaCiudad.mundo.Esquina3;
import uniandes.cupi2.mapaCiudad.mundo.Esquina4;
import uniandes.cupi2.mapaCiudad.mundo.EstacionBomberos;
import uniandes.cupi2.mapaCiudad.mundo.EstacionPolicia;
import uniandes.cupi2.mapaCiudad.mundo.FormatoInvalidoExcepcion;
import uniandes.cupi2.mapaCiudad.mundo.Glorieta;
import uniandes.cupi2.mapaCiudad.mundo.Hospital;
import uniandes.cupi2.mapaCiudad.mundo.IConstruccion;
import uniandes.cupi2.mapaCiudad.mundo.MapaCiudad;

/**
 * Esta es la clase usada para verificar que los métodos de la clase MapaCiudad estén correctamente implementados
 */
public class MapaCiudadTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la clase donde se harán las pruebas
     */
    private MapaCiudad mapa;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo MapaCiudad con la información contenida en archivo
     *  
     */
    private void setupEscenario1( )
    {
        mapa = new MapaCiudad( );

        try
        {
            mapa.abrir( "./test/data/test.dat" );
        }
        catch( Exception e )
        {
            fail( "No se pudo cargar el archivo: " + e.getMessage( ) );
        }
    }

    /**
     * Construye un nuevo MapaCiudad vacío
     *  
     */
    private void setupEscenario2( )
    {
        mapa = new MapaCiudad( );
    }

    /**
     * Verifica que el mapa sea reiniciado correctamente.<br>
     * Resultados esperados:<br>
     * <li>Al reiniciar el mapa debe quedar en blanco por ende se debe devolver null en caso de buscar una construcción.</li>
     * <li>Se agregó una construcción por ende debe devolver la construcción.</li>
     */
    public void testReiniciarMapa( )
    {
        setupEscenario1( );

        mapa.reiniciar( );
        Construccion c2 = mapa.crearConstruccion( Calle.TIPO,0,0,Color.RED );
        mapa.agregarConstruccion( c2 );
        mapa.reiniciar( );

        IConstruccion c = mapa.buscarConstruccion( 0, 0 );
        assertNull( "No se limpió correctamente el mapa", c );

        mapa.reiniciar( );
        Construccion c3 = mapa.crearConstruccion( Calle.TIPO,0,0,Color.RED );
        mapa.agregarConstruccion( c3 );
        c = mapa.buscarConstruccion( 0, 0 );

        assertNotNull( "No se agrego correctamente la construcción", c );
    }

    /**
     * Verifica que una esquina se agregue correctamente.<br>
     * Resultados esperados:<br>
     * <li>La esquina se agrega y se busca, por ende debe estar y no devolver null.</li>
     */
    public void testAgregarEsquina1( )
    {
        setupEscenario1( );

        Construccion c2 = mapa.crearConstruccion( Esquina1.TIPO,10,10,Color.RED );
        mapa.agregarConstruccion( c2 );

        Esquina1 e2 = ( Esquina1 )mapa.buscarConstruccion( 10, 10 );
        assertNotNull( "No se agregó correctamente la esquina1", e2 );
    }

    /**
     * Verifica que una esquina se agregue correctamente.<br>
     * Resultados esperados:<br>
     * <li>La esquina se agrega y se busca, por ende debe estar y no devolver null.</li>
     */
    public void testAgregarEsquina2( )
    {
        setupEscenario1( );
    
        Construccion c2 = mapa.crearConstruccion( Esquina2.TIPO,10,10,Color.RED );
        mapa.agregarConstruccion( c2 );
        
        Esquina2 e2 = ( Esquina2 )mapa.buscarConstruccion( 10, 10 );
        assertNotNull( "No se agregó correctamente la esquina2", e2 );
    }

    /**
     * Verifica que una esquina se agregue correctamente.<br>
     * Resultados esperados:<br>
     * <li>La esquina se agrega y se busca, por ende debe estar y no devolver null.</li>
     */
    public void testAgregarEsquina3( )
    {
        setupEscenario1( );

        Construccion c2 = mapa.crearConstruccion( Esquina3.TIPO,10,10,Color.RED );
        mapa.agregarConstruccion( c2 );

        Esquina3 e2 = ( Esquina3 )mapa.buscarConstruccion( 10, 10 );
        assertNotNull( "No se agregó correctamente la esquina3", e2 );
    }

    /**
     * Verifica que una esquina se agregue correctamente.<br>
     * Resultados esperados:<br>
     * <li>La esquina se agrega y se busca, por ende debe estar y no devolver null.</li>
     */
    public void testAgregarEsquina4( )
    {
        setupEscenario1( );

        Construccion c2 = mapa.crearConstruccion( Esquina4.TIPO,10,10,Color.RED );
        mapa.agregarConstruccion( c2 );;

        Esquina4 e2 = ( Esquina4 )mapa.buscarConstruccion( 10, 10 );
        assertNotNull( "No se agregó correctamente la esquina4", e2 );
    }

    /**
     * Verifica que una calle se agregue correctamente.<br>
     * Resultados esperados:<br>
     * <li>La calle se agrega y se busca, por ende debe estar y no devolver null.</li>
     */
    public void testAgregarCalle( )
    {
        setupEscenario1( );

        
        Construccion c3 = mapa.crearConstruccion( Calle.TIPO,10,10,Color.RED );
        mapa.agregarConstruccion( c3 );

        Calle c2 = ( Calle )mapa.buscarConstruccion( 10, 10 );
        assertNotNull( "No se agregó correctamente la calle", c2 );
    }

    /**
     * Verifica que una carrera se agregue correctamente.<br>
     * Resultados esperados:<br>
     * <li>La carrera se agrega y se busca, por ende debe estar y no devolver null.</li>
     */
    public void testAgregarCarrera( )
    {
        setupEscenario1( );

        
        Construccion c3 = mapa.crearConstruccion( Carrera.TIPO,10,10,Color.RED );
        mapa.agregarConstruccion( c3 );

        Carrera c2 = ( Carrera )mapa.buscarConstruccion( 10, 10 );
        assertNotNull( "No se agregó correctamente la carrera", c2 );
    }

    /**
     * Verifica que un cruce se agregue correctamente.<br>
     * Resultados esperados:<br>
     * <li>El cruce se agrega y se busca, por ende debe estar y no devolver null.</li>
     */
    public void testAgregarCruce( )
    {
        setupEscenario1( );

        
        Construccion c3 = mapa.crearConstruccion( Glorieta.TIPO,10,10,Color.RED );
        mapa.agregarConstruccion( c3 );

        Glorieta c2 = ( Glorieta )mapa.buscarConstruccion( 10, 10 );
        assertNotNull( "No se agregó correctamente el cruce", c2 );
    }

    /**
     * Verifica que una casa se agregue correctamente.<br>
     * Resultados esperados:<br>
     * <li>La casa se agrega y se busca, por ende debe estar y no devolver null.</li>
     */
    public void testAgregarCasa( )
    {
        setupEscenario1( );

        Construccion c3 = mapa.crearConstruccion( Casa.TIPO,20,100,Color.RED );
        mapa.agregarConstruccion( c3 );

        Casa c2 = ( Casa )mapa.buscarConstruccion( 20, 100 );
        assertNotNull( "No se agregó correctamente la casa", c2 );
    }

    /**
     * Verifica que un edificio se agregue correctamente.<br>
     * Resultados esperados:<br>
     * <li>El edificio se agrega y se busca, por ende debe estar y no devolver null.</li>
     */
    public void testAgregarEdificio( )
    {
        setupEscenario1( );

        Construccion c3 = mapa.crearConstruccion( Edificio.TIPO,20,100,Color.RED );
        mapa.agregarConstruccion( c3 );

        Edificio e2 = ( Edificio )mapa.buscarConstruccion( 20, 100 );
        assertNotNull( "No se agregó correctamente el edificio", e2 );
    }

    /**
     * Verifica que un hospital se agregue correctamente.<br>
     * Resultados esperados:<br>
     * <li>El hospital se agrega y se busca, por ende debe estar y no devolver null.</li>
     */
    public void testAgregarHospital( )
    {
        setupEscenario1( );
        
        Construccion c3 = mapa.crearConstruccion( Hospital.TIPO,20,100,Color.RED );
        mapa.agregarConstruccion( c3 );

        Hospital h2 = ( Hospital )mapa.buscarConstruccion( 20, 100 );
        assertNotNull( "No se agregó correctamente el hospital", h2 );

    }

    /**
     * Verifica que una estación se agregue correctamente.<br>
     * Resultados esperados:<br>
     * <li>La estación de bomberos se agrega y se busca, por ende debe estar y no devolver null.</li>
     */
    public void testAgregarEstacionBomberos( )
    {
        setupEscenario1( );

        Construccion c3 = mapa.crearConstruccion( EstacionBomberos.TIPO,20,100,Color.RED );
        mapa.agregarConstruccion( c3 );

        EstacionBomberos e2 = ( EstacionBomberos )mapa.buscarConstruccion( 20, 100 );
        assertNotNull( "No se agregó correctamente la estación de bomberos", e2 );
    }

    /**
     * Verifica que una estación se agregue correctamente.<br>
     * Resultados esperados:<br>
     * <li>La estación de policía se agrega y se busca, por ende debe estar y no devolver null.</li>
     */
    public void testAgregarEstacionPolicia( )
    {
        setupEscenario1( );

        Construccion c3 = mapa.crearConstruccion( EstacionPolicia.TIPO,20,100,Color.RED );
        mapa.agregarConstruccion( c3 );

        EstacionPolicia e2 = ( EstacionPolicia )mapa.buscarConstruccion( 20, 100 );
        assertNotNull( "No se agregó correctamente la estación de policías", e2 );
    }

    /**
     * Verifica el método darNombreArchivo.<br>
     * Resultados esperados:<br>
     * <li>El nombre del archivo de prueba debe ser test.dat.</li>
     */
    public void testDarNombreArchivo( )
    {
        setupEscenario1( );

        assertTrue( "El nombre del archivo es incorrecto", mapa.darNombreArchivo( ).endsWith( "test.dat" ) );
    }

    /**
     * Verifica de la búsqueda de las construcciones.<br>
     * Resultados esperados:<br>
     * <li>La carretera debe existir, por ende la búsqueda debe ser diferente de null.</li>
     * <li>La edificación debe existir, por ende la búsqueda debe ser diferente de null.</li>
     * <li>La construcción debe existir, por ende la búsqueda debe ser diferente de null.</li>
     */
    public void testBuscarConstruccion( )
    {
        setupEscenario1( );

        Carretera c = ( Carretera )mapa.buscarConstruccion( 160, 550 );
        assertNotNull( "La búsqueda no se realizó correctamente", c );

        Edificacion e = ( Edificacion )mapa.buscarConstruccion( 40, 50 );
        assertNotNull( "La búsqueda no se realizó correctamente", e );

        IConstruccion co = ( IConstruccion )mapa.buscarConstruccion( 1000, 1000 );
        assertNull( "La búsqueda no se realizó correctamente", co );

    }

    /**
     * Verifica la eliminación de las carreteras.<br>
     * Resultados esperados:<br>
     * <li>La carretera debe existir, por ende la búsqueda debe ser diferente de null.</li>
     * <li>Después de la eliminación la carretera no debe existir, por ende la búsqueda debe ser null.</li>
     */
    public void testEliminarCarretera( )
    {
        setupEscenario1( );

        Carretera c = ( Carretera )mapa.buscarConstruccion( 160, 550 );
        assertNotNull( "No existe la carretera", c );

        mapa.eliminarConstruccion( 160, 550 );

        Carretera c2 = ( Carretera )mapa.buscarConstruccion( 160, 550 );
        assertNull( "La carretera no se elimino correctamente", c2 );

    }

    /**
     * Verifica la eliminación de las edificaciones.<br>
     * Resultados esperados:<br>
     * <li>La edificación debe existir, por ende la búsqueda debe ser diferente de null.</li>
     * <li>Después de la eliminación la edificación no debe existir, por ende la búsqueda debe ser null.</li>
     */
    public void testEliminarEdificacion( )
    {
        setupEscenario1( );

        Edificacion e = ( Edificacion )mapa.buscarConstruccion( 280, 400 );
        assertNotNull( "No existe la edificación", e );

        mapa.eliminarConstruccion( 280, 400 );

        Edificacion e2 = ( Edificacion )mapa.buscarConstruccion( 280, 400 );
        assertNull( "La edificación no se elimino correctamente", e2 );

    }

    /**
     * Verifica que un mapa sea cargado correctamente.<br>
     * Resultados esperados:<br>
     * <li>La construcción debe existir, por ende la búsqueda debe ser diferente de null.</li>
     * <li>Al abrir el archivo no se debe encontrar ninguna carretera dado que se eliminó previamente.</li>
     */
    public void testAbrir( )
    {
        setupEscenario2( );

        try
        {
            mapa.abrir( "./test/data/test.dat" );

            IConstruccion c = mapa.buscarConstruccion( 160, 520 );

            assertNotNull( "Archivo cargado incorrectamente", c );

            mapa.eliminarConstruccion( 160, 520 );

            mapa.salvar( "./test/data/test2.dat" );
            mapa.abrir( "./test/data/test2.dat" );

            c = mapa.buscarConstruccion( 160, 520 );

            assertNull( "Archivo cargado incorrectamente", c );

        }
        catch( FormatoInvalidoExcepcion e1 )
        {
            fail( "No debería generarse el error" );
        }
        catch( IOException e1 )
        {
            fail( "No debería generarse el error" );
        }

    }

    /**
     * Verifica que un mapa sea guardado correctamente.<br>
     * Resultados esperados:<br>
     * <li>La construcción no debe existir dado que no estaba en el archivo, por ende la búsqueda debe retornar null.</li>
     * <li>Dado que se guardo con la nueva construcción, al cargarla debe existir la construcción.</li>
     */
    public void testGuardar( )
    {
        setupEscenario1( );

        try
        {
            mapa.eliminarConstruccion( 160, 520 );

            mapa.salvar( "./test/data/test2.dat" );
            mapa.abrir( "./test/data/test2.dat" );

            IConstruccion c = mapa.buscarConstruccion( 160, 520 );

            assertNull( "Archivo guardado incorrectamente", c );

            Construccion c3 = mapa.crearConstruccion( Carrera.TIPO,10000,10000,Color.BLACK );
            mapa.agregarConstruccion( c3 );

            mapa.salvar( "./test/data/test2.dat" );
            mapa.abrir( "./test/data/test2.dat" );

            c = mapa.buscarConstruccion( 10000, 10000 );

            assertNotNull( "Archivo guardado incorrectamente", c );
        }
        catch( FormatoInvalidoExcepcion e1 )
        {
            fail( "No debería generarse el error" );
        }
        catch( IOException e1 )
        {
            fail( "No debería generarse el error" );
        }

    }

}