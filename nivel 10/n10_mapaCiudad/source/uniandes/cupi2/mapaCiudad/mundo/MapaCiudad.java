/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: MapaCiudad.java,v 1.3 2007/04/12 14:10:28 carl-veg Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_mapaCiudad
 * Autor: Daniel Francisco Romero Acero - 25-ene-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.mapaCiudad.mundo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Esta es una clase que representa el mapa de una ciudad <br>
 * <b>inv: </b> construcciones != null <br>
 */
public class MapaCiudad
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante para calcular la ubicación de los elementos gráficos.
     */
    public static final int DIFERENCIA = 10;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es el archivo donde se está salvando actualmente el mapa
     */
    private String archivo;

    /**
     * Es una lista con las construcciones que componen el mapa, ordenadas en el orden en el que fueron agregadas. <br>
     * Las construcciones se pintan en el mismo orden que aparecen aquí.
     */
    private List construcciones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo mapa sin construcciones
     */
    public MapaCiudad( )
    {
        archivo = null;
        construcciones = new ArrayList( );

        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Carga un mapa a partir de un archivo <br>
     * <b>post: </b> Se eliminó el mapa anterior y se cargó el nuevo
     * @param nombreArchivo El archivo de donde se va a cargar el mapa - archivo != null
     * @throws FormatoInvalidoExcepcion Se lanza esta excepción si el archivo tiene un formato incorrecto
     * @throws IOException Se lanza esta excepción si hay problemas leyendo del archivo
     */
    public void abrir( String nombreArchivo ) throws FormatoInvalidoExcepcion, IOException
    {
        List construccionesAnteriores = new ArrayList( );

        // Cargar las construcciones
        BufferedReader br = new BufferedReader( new FileReader( nombreArchivo ) );
        String linea = br.readLine( );
        try
        {
            // Salvar las construcciones anteriores por si se presenta algun error
            construccionesAnteriores.addAll( construcciones );

            // Eliminar las construcciones anteriores
            construcciones.clear( );

            // Crear las construcciones
            int cuantasConstrucciones = Integer.parseInt( linea );
            for( int i = 0; i < cuantasConstrucciones; i++ )
            {
                linea = br.readLine( );
                crearConstruccion( linea, br );
            }

            br.close( );
        }
        catch( NumberFormatException nfe )
        {
            br.close( );
            construcciones.clear( );
            construcciones.addAll( construccionesAnteriores );
            throw new FormatoInvalidoExcepcion( linea );
        }

        // Reemplazar el nombre de archivo viejo
        archivo = nombreArchivo;

        verificarInvariante( );
    }

    /**
     * Crea una construcción con los datos contenidos en un archivo y la adiciona a la lista respectiva
     * @param tipoConstruccion Es la cadena que identifica el tipo de construcción que se debe construir
     * @param br Es el stream de donde se pueden leer los datos para crear la construcción - br!=null
     * @throws FormatoInvalidoExcepcion Se lanza esta excepción si el archivo tiene un formato incorrecto
     * @throws IOException Se lanza esta excepción si hay problemas leyendo del archivo
     */
    private void crearConstruccion( String tipoConstruccion, BufferedReader br ) throws FormatoInvalidoExcepcion, IOException
    {
        IConstruccion nueva;

        if( "CASA".equals( tipoConstruccion ) )
        {
            nueva = new Casa( br );
        }
        else if( "EDIFICIO".equals( tipoConstruccion ) )
        {
            nueva = new Edificio( br );
        }
        else if( "ESTACION_BOMBEROS".equals( tipoConstruccion ) )
        {
            nueva = new EstacionBomberos( br );
        }
        else if( "ESTACION_POLICIA".equals( tipoConstruccion ) )
        {
            nueva = new EstacionPolicia( br );
        }
        else if( "HOSPITAL".equals( tipoConstruccion ) )
        {
            nueva = new Hospital( br );
        }
        else if( "CALLE".equals( tipoConstruccion ) )
        {
            nueva = new Calle( br );
        }
        else if( "CARRERA".equals( tipoConstruccion ) )
        {
            nueva = new Carrera( br );
        }
        else if( "GLORIETA".equals( tipoConstruccion ) )
        {
            nueva = new Glorieta( br );
        }
        else if( "ESQUINA1".equals( tipoConstruccion ) )
        {
            nueva = new Esquina1( br );
        }
        else if( "ESQUINA2".equals( tipoConstruccion ) )
        {
            nueva = new Esquina2( br );
        }
        else if( "ESQUINA3".equals( tipoConstruccion ) )
        {
            nueva = new Esquina3( br );
        }
        else if( "ESQUINA4".equals( tipoConstruccion ) )
        {
            nueva = new Esquina4( br );
        }
        else
        {
            br.close( );
            throw new FormatoInvalidoExcepcion( tipoConstruccion );
        }

        construcciones.add( nueva );
    }
    /**
     * Crea una edificación al mapa <br>
     * <b>post: </b> Se agregó la edificación al mapa
     * @param opcion Opción el tipo de construcción que se quiere agregar.
     * @param x La posición X en la que se quiere agregar.
     * @param y La posición Y en la que se quiere agregar.
     * @param colorFondo Color de fondo que se le quiere poner a la figura de la cosntrucción.
     * @return Retorna la construcción creada
     */
    public Construccion crearConstruccion(String opcion, int x,int y, Color colorFondo){
        Construccion c = null;
        if( Calle.TIPO.equals(opcion) )
        {
            c = new Calle( x, y, colorFondo );
        }
        else if( Carrera.TIPO.equals(opcion) )
        {
            c = new Carrera( x, y, colorFondo );
        }
        else if( Glorieta.TIPO.equals(opcion) )
        {
            c = new Glorieta( x, y, colorFondo );
        }
        else if( Esquina1.TIPO.equals(opcion))
        {
            c = new Esquina1( x, y, colorFondo );
        }
        else if( Esquina2.TIPO.equals(opcion) )
        {
            c = new Esquina2( x, y, colorFondo );
        }
        else if( Esquina3.TIPO.equals(opcion))
        {
            c = new Esquina3( x, y, colorFondo );
        }
        else if( Esquina4.TIPO.equals(opcion))
        {
            c = new Esquina4( x, y, colorFondo );
        }
        if( Casa.TIPO.equals(opcion) )
        {
            c = new Casa( x, y, colorFondo );
        }
        else if( Edificio.TIPO.equals(opcion) )
        {
            c = new Edificio( x, y, colorFondo );
        }
        else if( Hospital.TIPO.equals(opcion) )
        {
            c = new Hospital( x, y, colorFondo );
        }
        else if( EstacionBomberos.TIPO.equals(opcion) )
        {
            c = new EstacionBomberos( x, y, colorFondo );
        }
        else if( EstacionPolicia.TIPO.equals(opcion) )
        {
            c = new EstacionPolicia( x, y, colorFondo );
        }
        return c;
    }
    /**
     * Agrega una edificación al mapa <br>
     * <b>post: </b> Se agregó la edificación al mapa
     * @param c Construcción que se va agregar.
     */
    public void agregarConstruccion( IConstruccion c )
    {
        construcciones.add( c );
        verificarInvariante( );
    }

    /**
     * Reinicia el mapa, eliminando todas las construcciones
     */
    public void reiniciar( )
    {
        construcciones.clear( );
        archivo = null;
        verificarInvariante( );
    }

    /**
     * Retorna el nombre del archivo donde se está guardando la información de este mapa
     * @return archivo. Si no se ha establecido todavía el nombre del archivo, retorna null.
     */
    public String darNombreArchivo( )
    {
        return archivo;
    }

    /**
     * Salva el mapa actual en el archivo que se venía usando. <br>
     * <b>pre: </b> Hay un archivo para salvar ya establecido. <br>
     * <b>post: </b> Se salvó el mapa en un archivo.
     * @throws IOException Se lanza esta excepción si hay problemas salvando el mapa
     */
    public void salvar( ) throws IOException
    {
        PrintWriter out = new PrintWriter( archivo );
        out.println( construcciones.size( ) );

        // Guardar las construcciones
        Iterator iter = construcciones.iterator( );
        while( iter.hasNext( ) )
        {
            IConstruccion c = ( IConstruccion )iter.next( );
            c.guardar( out );
        }

        out.close( );
    }

    /**
     * Salva el mapa actual en el archivo especificado. <br>
     * <b>post: </b> Se salvó el mapa en un archivo.
     * @param nombreArchivo Es el nombre del archivo donde se va a salvar el mapa
     * @throws IOException Se lanza esta excepción si hay problemas salvando el mapa
     */
    public void salvar( String nombreArchivo ) throws IOException
    {
        archivo = nombreArchivo;
        salvar( );
    }

    /**
     * Pinta el mapa sobre la superficie proporcionada
     * @param g Es la superficie sobre la que deben quedar las construcciones - g != null y g es una superficie limpia (no se va a borrar antes de pintar)
     */
    public void pintarConstrucciones( Graphics2D g )
    {
        // Pintar las construcciones
        Iterator iter = construcciones.iterator( );
        while( iter.hasNext( ) )
        {
            IConstruccion c = ( IConstruccion )iter.next( );
            c.pintar( g );

        }

    }
    
    /**
     * Elimina la construcción que contiene los puntos especificados. Si ninguna construcción contiene los puntos no se elimina nada
     * @param x Punto x de que contiene la construcción a ser eliminada
     * @param y Punto y que contiene la construcción a ser eliminada
     */
    public void eliminarConstruccion( int x, int y )
    {
        boolean eliminado = false;

        // Eliminar la construcción
        Iterator iter = construcciones.iterator( );

        while( iter.hasNext( ) && !eliminado )
        {
            IConstruccion c = ( IConstruccion )iter.next( );
            if( c.estaDentro( x, y ) )
            {
                iter.remove( );
                eliminado = true;
            }
        }

        verificarInvariante( );
    }

    /**
     * Retorna la construcción que contiene los puntos especificados
     * @param x Punto x que debe contener la construcción
     * @param y Punto y que debe contener la construcción
     * @return Construcción que contiene los dos puntos especificados. Si ninguna construcción contiene los puntos especificados se retorna null.
     *  
     */
    public IConstruccion buscarConstruccion( int x, int y )
    {
        IConstruccion c = null;

        boolean encontrado = false;

        // Buscar la construcción
        Iterator iter = construcciones.iterator( );

        while( iter.hasNext( ) && !encontrado )
        {
            IConstruccion aux = ( IConstruccion )iter.next( );
            if( aux.estaDentro( x, y ) )
            {
                c = aux;
                encontrado = true;
            }
        }

        return c;
    }

    /**
     * Indica si la construcción especificada de acuerdo a sus coordenadas se sobrepone a otra construcción existente.
     * @param c Construcción de la que se desea saber si se sobrepone o no- c!=null
     * @return true si la construcción se sobrepone o false de lo contrario
     */
    public boolean sobreponeConstruccion( IConstruccion c )
    {
        boolean sobrepone = false;
        boolean estaAdentroConstrucion = false;
        boolean tocaConstrucionActual = false;
        // Buscar la construcción
        Iterator iter = construcciones.iterator( );

        while( iter.hasNext( ) && !sobrepone )
        {
            IConstruccion aux = ( IConstruccion  )iter.next( );
            estaAdentroConstrucion = c.estaDentro( aux.darX(), aux.darY() ) || c.estaDentro( aux.darX() + aux.darAncho() - DIFERENCIA, aux.darY() + aux.darAlto() - DIFERENCIA) || c.estaDentro( aux.darX() + aux.darAncho()- DIFERENCIA, aux.darY() ) || c.estaDentro( aux.darX(), aux.darY() + aux.darAlto() - DIFERENCIA);
            
            tocaConstrucionActual = aux.estaDentro( c.darX(), c.darY() ) || aux.estaDentro( c.darX() + c.darAncho() - DIFERENCIA, c.darY() ) || aux.estaDentro( c.darX(), c.darY() + c.darAlto() - DIFERENCIA ) || aux.estaDentro( c.darX() + c.darAncho() - DIFERENCIA, c.darY() + c.darAlto() - DIFERENCIA );
            
                 
            if( estaAdentroConstrucion || tocaConstrucionActual)
            {

                sobrepone = true;
            }
        }

        return sobrepone;
    }

    /**
     * Verifica el invariante de la clase <br>
     * <b>inv: </b> construcciones != null
     */
    public void verificarInvariante( )
    {
        assert ( construcciones != null ) : "La lista de construcciones no puede ser null";
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}