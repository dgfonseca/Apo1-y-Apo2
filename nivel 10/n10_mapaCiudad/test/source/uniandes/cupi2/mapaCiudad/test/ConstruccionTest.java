/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: ConstruccionTest.java,v 1.1 2007/03/22 16:13:00 p-marque Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_mapaCiudad
 * Autor: Daniel Francisco Romero Acero - 25-ene-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.mapaCiudad.test;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import junit.framework.TestCase;
import uniandes.cupi2.mapaCiudad.mundo.Calle;
import uniandes.cupi2.mapaCiudad.mundo.Carrera;
import uniandes.cupi2.mapaCiudad.mundo.Casa;
import uniandes.cupi2.mapaCiudad.mundo.Construccion;
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

/**
 * Esta es la clase usada para verificar que los m�todos de la clase Construccion est�n correctamente implementados
 */
public class ConstruccionTest extends TestCase
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la clase donde se har�n las pruebas
     */
    private IConstruccion construccion;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo construcci�n de tipo Edificaci�n 
     *  
     */
    private void setupEscenario1( )
    {
        construccion = new Casa(100, 100, Color.WHITE);
    }
    
    /**
     * Construye un nuevo construcci�n de tipo Carrera 
     *  
     */
    private void setupEscenario2( )
    {
        construccion = new Glorieta(50, 500, Color.WHITE);
    }
       
    /**
     * Verifica que el alto se cambie correctamente.<br>
     * Resultados esperados:<br>
     * <li>El nuevo alto de la construcci�n debe ser igual al que se quizo poner.</li>
     */
    public void testCambiarAlto( )
    {
        setupEscenario1( );

        construccion.cambiarAlto(200); 
        int alto= construccion.darAlto(); 

        assertEquals("El cambio del alto no se realiz� correctamente", 200, alto);
    }
    
    /**
     * Verifica que el ancho se cambie correctamente
     * <br>
     * Resultados esperados:<br>
     * <li>El nuevo ancho de la construcci�n debe ser igual al que se quizo poner.</li>
     */
    public void testCambiarAncho( )
    {
        setupEscenario2( );

        construccion.cambiarAncho(200); 
        int ancho= construccion.darAncho(); 

        assertEquals("El cambio del ancho no se realiz� correctamente", 200, ancho);
    }
    
    /**
     * Verifica que el punto x se cambie correctamente.<br>
     * Resultados esperados:<br>
     * <li>La nueva posici�n X de la construcci�n debe ser igual al que se quizo poner.</li>
     */
    public void testCambiarX( )
    {
        setupEscenario2( );

        construccion.cambiarX(20); 
        int x= construccion.darX(); 

        assertEquals("El cambio del punto x no se realiz� correctamente", 20, x);
    }
    
    
    /**
     * Verifica que el punto y se cambie correctamente.<br>
     * Resultados esperados:<br>
     * <li>La nueva posici�n Y de la construcci�n debe ser igual al que se quizo poner.</li>
     */
    public void testCambiarY( )
    {
        setupEscenario1( );

        construccion.cambiarY(20); 
        int y= construccion.darY(); 

        assertEquals("El cambio del punto y no se realiz� correctamente", 20, y);
    }
    
    /**
     * Verifica que el punto esta dentro de la construcci�n.<br>
     * Resultados esperados:<br>
     * <li>El primer punto que se pone debe estar adentro.</li>
     * <li>El segundo punto que se pone debe estar afuera.</li>
     * <li>El tercer punto que se pone debe estar en el borde.</li>
     * <li>El cuarto punto que se pone debe estar en el borde.</li>
     */
    public void testEstaDentro( )
    {
        setupEscenario1( );

        boolean dentro= construccion.estaDentro(150, 150); //Dentro 
        
        assertEquals("La verificaci�n del punto se realiz� incorrectamente", true, dentro );
        
        dentro= construccion.estaDentro(15000, 15000); //Fuera
        
        assertEquals("La verificaci�n del punto se realiz� incorrectamente", false, dentro );
        
        dentro= construccion.estaDentro(100, 100); //Borde 
        
        assertEquals("La verificaci�n del punto se realiz� incorrectamente", true, dentro );
        
        dentro= construccion.estaDentro(260-1, 220-1); //Borde 
        
        assertEquals("La verificaci�n del punto se realiz� incorrectamente", true, dentro );
    }
    
    
    /**
     * Verifica que una construcci�n se guarde correctamente.<br>
     * Resultados esperados:<br>
     * <li>El tipo de la construccion que se est� guardando debe ser igual al que se carga del archivo que se guard�.</li>
     * <li>El punto x de la construccion que se est� guardando debe ser igual al que se carga del archivo que se guard�.</li>
     * <li>El punto y de la construccion que se est� guardando debe ser igual al que se carga del archivo que se guard�.</li>
     * <li>La fuente de la construccion que se est� guardando debe ser igual al que se carga del archivo que se guard�.</li>
     * <li>El tipo de la construccion que se est� guardando debe ser igual al que se carga del archivo que se guard�.</li>
     * <li>El punto x de la construccion que se est� guardando debe ser igual al que se carga del archivo que se guard�.</li>
     * <li>El punto y de la construccion que se est� guardando debe ser igual al que se carga del archivo que se guard�.</li>
     * <li>La fuente de la construccion que se est� guardando debe ser igual al que se carga del archivo que se guard�.</li>
     */
    public void testGuardar( )
    {
        setupEscenario1( );

        PrintWriter out;
        try
        {
            out = new PrintWriter( "./test/data/testConstruccion.dat" );
            construccion.guardar(out);
            
            out.close( );
            
            BufferedReader br = new BufferedReader( new FileReader(  "./test/data/testConstruccion.dat" ) );
            
            String tipo= br.readLine(); //Tipo
            
            Construccion c= new Casa(br);
                               
            assertEquals("La construcci�n se guard� incorrectamente", construccion.darTipo(), tipo );
            assertEquals("La construcci�n se guard� incorrectamente", construccion.darX(), c.darX() ); 
            assertEquals("La construcci�n se guard� incorrectamente", construccion.darY(), c.darY() );
            assertEquals("La construcci�n se guard� incorrectamente", construccion.darFuente(), c.darFuente() );        
            
            br.close();           
        }
        catch( FileNotFoundException e )
        {            
            fail();
        }
        catch( IOException e )
        {            
            fail();
        }
        catch( FormatoInvalidoExcepcion e )
        {         
            fail();
        }
        
        setupEscenario2( );
        try
        {
            out = new PrintWriter( "./test/data/testConstruccion.dat" );
            construccion.guardar(out);
            
            out.close( );
            
            BufferedReader br = new BufferedReader( new FileReader(  "./test/data/testConstruccion.dat" ) );
            
            String tipo2= br.readLine(); //Tipo
            
            Construccion c= new Glorieta(br);
            
            assertEquals("La construcci�n se guard� incorrectamente", construccion.darTipo(), tipo2 );
            assertEquals("La construcci�n se guard� incorrectamente", construccion.darX(), c.darX() ); 
            assertEquals("La construcci�n se guard� incorrectamente", construccion.darY(), c.darY() );
            assertEquals("La construcci�n se guard� incorrectamente", construccion.darFuente(), c.darFuente() );        
            
            br.close();
            
        }
        catch( FileNotFoundException e )
        {            
            fail();
        }
        catch( IOException e )
        {            
            fail();
        }
        catch( FormatoInvalidoExcepcion e )
        {         
            fail();
        }
    }
    /**
     * Prueba que se cargue y guarde correctamente una casa.</br>
     * Los resultados esperados son:</br>
     * 1. El tipo que se tiene despu�s de cargar debe ser igual al tipo con el que se guardo.</br>
     * 2. La posici�n X que se tiene despu�s de cargar debe ser igual a la posici�n X con el que se guardo.</br>
     * 3. La posici�n Y que se tiene despu�s de cargar debe ser igual a la posici�n Y con el que se guardo.</br>
     * 4. La fuente que se tiene despu�s de cargar debe ser igual a la fuente con el que se guardo.</br>
     */
    public void testConstruccionCasa(){
        setupEscenario1( );

        PrintWriter out;
        try
        {
            out = new PrintWriter( "./test/data/testConstruccion.dat" );
            construccion.guardar(out);
            
            out.close( );
            
            BufferedReader br = new BufferedReader( new FileReader(  "./test/data/testConstruccion.dat" ) );
            
            String tipo= br.readLine(); //Tipo
            
            Construccion c= new Casa(br);
                               
            assertEquals("La construcci�n se guard� incorrectamente", construccion.darTipo(), tipo );
            assertEquals("La construcci�n se guard� incorrectamente", construccion.darX(), c.darX() ); 
            assertEquals("La construcci�n se guard� incorrectamente", construccion.darY(), c.darY() );
            assertEquals("La construcci�n se guard� incorrectamente", construccion.darFuente(), c.darFuente() );        
            
            br.close();
            
        }
        catch( FileNotFoundException e )
        {            
            fail();
        }
        catch( IOException e )
        {            
            fail();
        }
        catch( FormatoInvalidoExcepcion e )
        {         
            fail();
        }       
    }
    /**
     * Prueba que se cargue y guarde correctamente una edificio.</br>
     * Los resultados esperados son:</br>
     * 1. El tipo que se tiene despu�s de cargar debe ser igual al tipo con el que se guardo.</br>
     * 2. La posici�n X que se tiene despu�s de cargar debe ser igual a la posici�n X con el que se guardo.</br>
     * 3. La posici�n Y que se tiene despu�s de cargar debe ser igual a la posici�n Y con el que se guardo.</br>
     */
    public void testConstruccionEdificio(){
        setupEscenario1( );
        try
        {          
            BufferedReader br = new BufferedReader( new FileReader(  "./test/data/testConstruccionEdificio.dat" ) );
            
            String tipo= br.readLine(); //Tipo
            Construccion c= new Edificio(br);
            
            assertEquals("La construcci�n se guard� incorrectamente", tipo, Edificio.TIPO);
            assertEquals("La construcci�n se guard� incorrectamente", c.darX(), 40 ); 
            assertEquals("La construcci�n se guard� incorrectamente", c.darY(), 200 );     
            
            br.close();            
        }
        catch( FileNotFoundException e )
        {            
            fail();
        }
        catch( IOException e )
        {            
            fail();
        }
        catch( FormatoInvalidoExcepcion e )
        {         
            e.printStackTrace( );
            fail();            
        }        
    }
    
    /**
     * Prueba que se cargue y guarde correctamente una calle.</br>
     * Los resultados esperados son:</br>
     * 1. El tipo que se tiene despu�s de cargar debe ser igual al tipo con el que se guardo.</br>
     * 2. La posici�n X que se tiene despu�s de cargar debe ser igual a la posici�n X con el que se guardo.</br>
     * 3. La posici�n Y que se tiene despu�s de cargar debe ser igual a la posici�n Y con el que se guardo.</br>
     */
    public void testConstruccionCalle(){
        setupEscenario1( );
        try
        {            
            BufferedReader br = new BufferedReader( new FileReader(  "./test/data/testConstruccionCalle.dat" ) );
            
            String tipo= br.readLine(); //Tipo
            Construccion c= new Calle(br);
            
            assertEquals("La construcci�n se guard� incorrectamente", tipo, Calle.TIPO);
            assertEquals("La construcci�n se guard� incorrectamente", c.darX(), 40 ); 
            assertEquals("La construcci�n se guard� incorrectamente", c.darY(), 200 );     
            
            br.close();
            
        }
        catch( FileNotFoundException e )
        {            
            fail();
        }
        catch( IOException e )
        {            
            fail();
        }
        catch( FormatoInvalidoExcepcion e )
        {         
            e.printStackTrace( );
            fail();            
        }
    }
    /**
     * Prueba que se cargue y guarde correctamente una carrera.</br>
     * Los resultados esperados son:</br>
     * 1. El tipo que se tiene despu�s de cargar debe ser igual al tipo con el que se guardo.</br>
     * 2. La posici�n X que se tiene despu�s de cargar debe ser igual a la posici�n X con el que se guardo.</br>
     * 3. La posici�n Y que se tiene despu�s de cargar debe ser igual a la posici�n Y con el que se guardo.</br>
     */
    public void testConstruccionCarrera(){
        setupEscenario1( );
        try
        {            
            BufferedReader br = new BufferedReader( new FileReader(  "./test/data/testConstruccionCarrera.dat" ) );
            
            String tipo= br.readLine(); //Tipo
            Construccion c= new Calle(br);
            
            assertEquals("La construcci�n se guard� incorrectamente", tipo, Carrera.TIPO);
            assertEquals("La construcci�n se guard� incorrectamente", c.darX(), 40 ); 
            assertEquals("La construcci�n se guard� incorrectamente", c.darY(), 200 );     
            
            br.close();           
        }
        catch( FileNotFoundException e )
        {            
            fail();
        }
        catch( IOException e )
        {            
            fail();
        }
        catch( FormatoInvalidoExcepcion e )
        {         
            e.printStackTrace( );
            fail();            
        }
    }
    
    /**
     * Prueba que se cargue y guarde correctamente una esquina1.</br>
     * Los resultados esperados son:</br>
     * 1. El tipo que se tiene despu�s de cargar debe ser igual al tipo con el que se guardo.</br>
     * 2. La posici�n X que se tiene despu�s de cargar debe ser igual a la posici�n X con el que se guardo.</br>
     * 3. La posici�n Y que se tiene despu�s de cargar debe ser igual a la posici�n Y con el que se guardo.</br>
     */
    public void testConstruccionEsquina1(){
        setupEscenario1( );
        try
        {            
            BufferedReader br = new BufferedReader( new FileReader(  "./test/data/testConstruccionEsquina1.dat" ) );
            
            String tipo= br.readLine(); //Tipo
            Construccion c= new Calle(br);
            
            assertEquals("La construcci�n se guard� incorrectamente", tipo, Esquina1.TIPO);
            assertEquals("La construcci�n se guard� incorrectamente", c.darX(), 40 ); 
            assertEquals("La construcci�n se guard� incorrectamente", c.darY(), 200 );     
            
            br.close();            
        }
        catch( FileNotFoundException e )
        {            
            fail();
        }
        catch( IOException e )
        {            
            fail();
        }
        catch( FormatoInvalidoExcepcion e )
        {         
            e.printStackTrace( );
            fail();            
        }
    }
    
    /**
     * Prueba que se cargue y guarde correctamente una esquina2.</br>
     * Los resultados esperados son:</br>
     * 1. El tipo que se tiene despu�s de cargar debe ser igual al tipo con el que se guardo.</br>
     * 2. La posici�n X que se tiene despu�s de cargar debe ser igual a la posici�n X con el que se guardo.</br>
     * 3. La posici�n Y que se tiene despu�s de cargar debe ser igual a la posici�n Y con el que se guardo.</br>
     */
    public void testConstruccionEsquina2(){
        setupEscenario1( );
        try
        {            
            BufferedReader br = new BufferedReader( new FileReader(  "./test/data/testConstruccionEsquina2.dat" ) );
            
            String tipo= br.readLine(); //Tipo
            Construccion c= new Calle(br);
            
            assertEquals("La construcci�n se guard� incorrectamente", tipo, Esquina2.TIPO);
            assertEquals("La construcci�n se guard� incorrectamente", c.darX(), 40 ); 
            assertEquals("La construcci�n se guard� incorrectamente", c.darY(), 200 );     
            
            br.close();            
        }
        catch( FileNotFoundException e )
        {            
            fail();
        }
        catch( IOException e )
        {            
            fail();
        }
        catch( FormatoInvalidoExcepcion e )
        {         
            e.printStackTrace( );
            fail();            
        }
    }
    
    /**
     * Prueba que se cargue y guarde correctamente una esquina3.</br>
     * Los resultados esperados son:</br>
     * 1. El tipo que se tiene despu�s de cargar debe ser igual al tipo con el que se guardo.</br>
     * 2. La posici�n X que se tiene despu�s de cargar debe ser igual a la posici�n X con el que se guardo.</br>
     * 3. La posici�n Y que se tiene despu�s de cargar debe ser igual a la posici�n Y con el que se guardo.</br>
     */
    public void testConstruccionEsquina3(){
        setupEscenario1( );
        try
        {
            BufferedReader br = new BufferedReader( new FileReader(  "./test/data/testConstruccionEsquina3.dat" ) );
            
            String tipo= br.readLine(); //Tipo
            Construccion c= new Calle(br);
            
            assertEquals("La construcci�n se guard� incorrectamente", tipo, Esquina3.TIPO);
            assertEquals("La construcci�n se guard� incorrectamente", c.darX(), 40 ); 
            assertEquals("La construcci�n se guard� incorrectamente", c.darY(), 200 );     
            
            br.close();            
        }
        catch( FileNotFoundException e )
        {            
            fail();
        }
        catch( IOException e )
        {            
            fail();
        }
        catch( FormatoInvalidoExcepcion e )
        {         
            e.printStackTrace( );
            fail();            
        }
    }
    
    /**
     * Prueba que se cargue y guarde correctamente una esquina4.</br>
     * Los resultados esperados son:</br>
     * 1. El tipo que se tiene despu�s de cargar debe ser igual al tipo con el que se guardo.</br>
     * 2. La posici�n X que se tiene despu�s de cargar debe ser igual a la posici�n X con el que se guardo.</br>
     * 3. La posici�n Y que se tiene despu�s de cargar debe ser igual a la posici�n Y con el que se guardo.</br>
     */
    public void testConstruccionEsquina4(){
        setupEscenario1( );
        try
        {            
            BufferedReader br = new BufferedReader( new FileReader(  "./test/data/testConstruccionEsquina4.dat" ) );
            
            String tipo= br.readLine(); //Tipo
            Construccion c= new Calle(br);
            
            assertEquals("La construcci�n se guard� incorrectamente", tipo, Esquina4.TIPO);
            assertEquals("La construcci�n se guard� incorrectamente", c.darX(), 40 ); 
            assertEquals("La construcci�n se guard� incorrectamente", c.darY(), 200 );     
            
            br.close();            
        }
        catch( FileNotFoundException e )
        {            
            fail();
        }
        catch( IOException e )
        {            
            fail();
        }
        catch( FormatoInvalidoExcepcion e )
        {         
            e.printStackTrace( );
            fail();            
        }
    }
    
    /**
     * Prueba que se cargue y guarde correctamente una Estaci�n Bomberos.</br>
     * Los resultados esperados son:</br>
     * 1. El tipo que se tiene despu�s de cargar debe ser igual al tipo con el que se guardo.</br>
     * 2. La posici�n X que se tiene despu�s de cargar debe ser igual a la posici�n X con el que se guardo.</br>
     * 3. La posici�n Y que se tiene despu�s de cargar debe ser igual a la posici�n Y con el que se guardo.</br>
     */
    public void testConstruccionEstacionBomberos(){
        setupEscenario1( );
        try
        {            
            BufferedReader br = new BufferedReader( new FileReader(  "./test/data/testConstruccionEstacionBomberos.dat" ) );
            
            String tipo= br.readLine(); //Tipo
            Construccion c= new EstacionBomberos(br);
            
            assertEquals("La construcci�n se guard� incorrectamente", tipo, EstacionBomberos.TIPO);
            assertEquals("La construcci�n se guard� incorrectamente", c.darX(), 40 ); 
            assertEquals("La construcci�n se guard� incorrectamente", c.darY(), 200 );     
            
            br.close();            
        }
        catch( FileNotFoundException e )
        {            
            fail();
        }
        catch( IOException e )
        {            
            fail();
        }
        catch( FormatoInvalidoExcepcion e )
        {         
            e.printStackTrace( );
            fail();            
        }
    }
    
    /**
     * Prueba que se cargue y guarde correctamente una Estaci�n Policia.</br>
     * Los resultados esperados son:</br>
     * 1. El tipo que se tiene despu�s de cargar debe ser igual al tipo con el que se guardo.</br>
     * 2. La posici�n X que se tiene despu�s de cargar debe ser igual a la posici�n X con el que se guardo.</br>
     * 3. La posici�n Y que se tiene despu�s de cargar debe ser igual a la posici�n Y con el que se guardo.</br>
     */
    public void testConstruccionEstacionPolicia(){
        setupEscenario1( );
        try
        {            
            BufferedReader br = new BufferedReader( new FileReader(  "./test/data/testConstruccionEstacionPolicia.dat" ) );
            
            String tipo= br.readLine(); //Tipo
            Construccion c= new EstacionPolicia(br);
            
            assertEquals("La construcci�n se guard� incorrectamente", tipo, EstacionPolicia.TIPO);
            assertEquals("La construcci�n se guard� incorrectamente", c.darX(), 40 ); 
            assertEquals("La construcci�n se guard� incorrectamente", c.darY(), 200 );     
            
            br.close();            
        }
        catch( FileNotFoundException e )
        {            
            fail();
        }
        catch( IOException e )
        {            
            fail();
        }
        catch( FormatoInvalidoExcepcion e )
        {         
            e.printStackTrace( );
            fail();            
        }
    }
    
    /**
     * Prueba que se cargue y guarde correctamente una Glorieta.</br>
     * Los resultados esperados son:</br>
     * 1. El tipo que se tiene despu�s de cargar debe ser igual al tipo con el que se guardo.</br>
     * 2. La posici�n X que se tiene despu�s de cargar debe ser igual a la posici�n X con el que se guardo.</br>
     * 3. La posici�n Y que se tiene despu�s de cargar debe ser igual a la posici�n Y con el que se guardo.</br>
     */
    public void testConstruccionGlorieta(){
        setupEscenario1( );
        try
        {            
            BufferedReader br = new BufferedReader( new FileReader(  "./test/data/testConstruccionGlorieta.dat" ) );
            
            String tipo= br.readLine(); //Tipo
            Construccion c= new Glorieta(br);
            
            assertEquals("La construcci�n se guard� incorrectamente", tipo, Glorieta.TIPO);
            assertEquals("La construcci�n se guard� incorrectamente", c.darX(), 40 ); 
            assertEquals("La construcci�n se guard� incorrectamente", c.darY(), 200 );     
            
            br.close();            
        }
        catch( FileNotFoundException e )
        {            
            fail();
        }
        catch( IOException e )
        {            
            fail();
        }
        catch( FormatoInvalidoExcepcion e )
        {         
            e.printStackTrace( );
            fail();            
        }
    }
    
    /**
     * Prueba que se cargue y guarde correctamente una Hospital.</br>
     * Los resultados esperados son:</br>
     * 1. El tipo que se tiene despu�s de cargar debe ser igual al tipo con el que se guardo.</br>
     * 2. La posici�n X que se tiene despu�s de cargar debe ser igual a la posici�n X con el que se guardo.</br>
     * 3. La posici�n Y que se tiene despu�s de cargar debe ser igual a la posici�n Y con el que se guardo.</br>
     */
    public void testConstruccionHospital(){
        setupEscenario1( );
        try
        {            
            BufferedReader br = new BufferedReader( new FileReader(  "./test/data/testConstruccionHospital.dat" ) );
            
            String tipo= br.readLine(); //Tipo
            Construccion c= new Hospital(br);
            
            assertEquals("La construcci�n se guard� incorrectamente", tipo, Hospital.TIPO);
            assertEquals("La construcci�n se guard� incorrectamente", c.darX(), 40 ); 
            assertEquals("La construcci�n se guard� incorrectamente", c.darY(), 200 );     
            
            br.close();            
        }
        catch( FileNotFoundException e )
        {            
            fail();
        }
        catch( IOException e )
        {            
            fail();
        }
        catch( FormatoInvalidoExcepcion e )
        {         
            e.printStackTrace( );
            fail();            
        }
    }
}
