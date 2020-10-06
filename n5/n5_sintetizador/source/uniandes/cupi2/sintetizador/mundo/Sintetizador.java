/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_sintetizador
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.sintetizador.mundo;

import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.midi.*;

import java.util.Properties;

/**
 * Sintetizador compuesto por distintos efectos.
 */
public class Sintetizador
{
    // -----------------------------------------------------------------
    // Enumeradores
    // -----------------------------------------------------------------

    /**
     * Enumeradores para los grupos a los que puede pertenecer un efecto.
     */
    public enum Grupo
    {
        /**
         * Representa el grupo Favoritos
         */
        FAVORITOS,
        /**
         * Representa el grupo Fantasía
         */
        FANTASÍA,
        /**
         * Representa el grupo Divertidos
         */
        DIVERTIDOS
    }

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Ruta del archivo para cargar los efectos del sintetizador.
     */
    public final static String RUTA_ARCHIVO_EFECTOS = "./data/sintetizador.properties";

    /**
     * Ruta del archivo para cargar las notas del sintetizador.
     */
    public final static String RUTA_ARCHIVO_NOTAS = "./data/notas.properties";

    /**
     * Cantidad de notas del sitetizador.
     */
    public final static int CANT_NOTAS = 8;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Player de las notas.
     */
    private Synthesizer sintetizador;

    /**
     * Lista de efectos del sintetizador.
     */
    private Efecto[] efectos;

    /**
     * Lista de notas del sintetizador.
     */
    private Nota[] notas;

    /**
     * Índice para indicar la posición del efecto actual.
     */
    private int efectoActual;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el sintetizador con sus efectos. <br>
     * <b> post: </b> Se inicializó inicializó la lista de efectos con la información del archivo.<br>
     * Se inicializó el efecto actual en 0. <br>
     * Se inicializó el sintetizador.
     * @throws Exception Si hay problemas al crear el sintetizador.
     */
    public Sintetizador( ) throws Exception
    {
        try
        {
            sintetizador = MidiSystem.getSynthesizer( );
            sintetizador.open( );
        }
        catch( Exception e )
        {
            throw new Exception( "Error al cargar el sintetizador." );
        }

        sintetizador.loadAllInstruments( sintetizador.getDefaultSoundbank( ) );
        cargarEfectos( );
        cargarNotas( );
        efectoActual = 0;
    }

    /**
     * Carga la información del sintetizador a partir de un archivo de propiedades.<br>
     * <b>post: </b> Se inicializaron los efectos con la información del archivo.
     * @throws Exception Si el archivo no existe o si el formato del archivo no es válido.
     */
    private void cargarEfectos( ) throws Exception
    {
        Properties datos = new Properties( );
        FileInputStream in = new FileInputStream( RUTA_ARCHIVO_EFECTOS );
        try
        {
            datos.load( in );
            in.close( );
            int cantidad = Integer.parseInt( datos.getProperty( "sintetizador.efectos" ) );
            efectos = new Efecto[cantidad];
            for( int i = 0; i < efectos.length; i++ )
            {
                String ruta = "sintetizador.efecto" + i + ".";

                String nombre = datos.getProperty( ruta + "nombre" );
                String descripcion = datos.getProperty( ruta + "descripcion" );
                double calificacion = Double.parseDouble( datos.getProperty( ruta + "calificacion" ) );
                int indice = Integer.parseInt( datos.getProperty( ruta + "indiceEfecto" ) );
                String rutaImagen = datos.getProperty( ruta + "ruta" );
                efectos[ i ] = new Efecto( nombre, descripcion, calificacion, indice, rutaImagen );
            }
        }
        catch( IOException ioe )
        {
            throw new Exception( "Error al cargar el archivo." );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
            throw new Exception( "Error en el formato del archivo." );
        }
    }

    /**
     * Carga la información de las notas a partir de un archivo de propiedades.<br>
     * <b>post: </b> Se inicializaron los efectos con la información del archivo.
     * @throws Exception Si el archivo no existe o si el formato del archivo no es válido.
     */
    private void cargarNotas( ) throws Exception
    {
        Properties datos = new Properties( );
        FileInputStream in = new FileInputStream( RUTA_ARCHIVO_NOTAS );
        try
        {
            datos.load( in );
            in.close( );
            notas = new Nota[CANT_NOTAS];
            for( int i = 0; i < CANT_NOTAS; i++ )
            {
                String ruta = "nota" + ( i + 1 ) + ".";

                String nombre = datos.getProperty( ruta + "nombre" );
                int valor = Integer.parseInt( datos.getProperty( ruta + "valor" ) );
                String rutaImagen = datos.getProperty( ruta + "imagen" );

                notas[ i ] = new Nota( nombre, valor, rutaImagen );
            }
        }
        catch( IOException ioe )
        {
            throw new Exception( "Error al cargar el archivo." );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
            throw new Exception( "Error en el formato del archivo." );
        }
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el efecto actual del sintetizador.
     * @return El efecto actual.
     */
    public Efecto darEfectoActual( )
    {
        return efectos[ efectoActual ];
    }

    /**
     * Retorna la lista de notas que maneja el sintetizador.
     * @return Lista de notas del sintetizador.
     */
    public Nota[] darNotas( )
    {
        return notas;
    }

    /**
     * Retorna la lista de efectos que maneja el sintetizador.
     * @return Lista de efectos del sintetizador.
     */
    public Efecto[] darEfectos( )
    {
        return efectos;
    }

    /**
     * Retorna el siguiente efecto.<br>
     * <b> post: </b> Se actualizó el efecto actual.
     * @throws Exception Si ya se encuentra en el último efecto.
     */
    public void darSiguienteEfecto( ) throws Exception
    {
        if( efectoActual + 1 == efectos.length )
        {
            throw new Exception( "Ya se encuentra en el último efecto." );
        }
        else
        {
            efectoActual++;
        }
    }

    /**
     * Retorna el siguiente efecto. <br>
     * <b> post: </b> Se actualizó el efecto actual.
     * @throws Exception Si ya se encuentra en el primer efecto.
     */
    public void darAnteriorEfecto( ) throws Exception
    {
        if( efectoActual == 0 )
        {
            throw new Exception( "Ya se encuentra en el primer efecto." );
        }
        else
        {
            efectoActual--;
        }

    }

    /**
     * Guarda los grupos a los que pertenece el efecto actual.<br>
     * <b>post:</b> Se actualizaron los grupos del efecto actual.
     * @param pFavoritos Indica si favoritos fue seleccionado.
     * @param pFantasia Indica si fantasía fue seleccionado.
     * @param pDivertidos Indica si divertidos fue seleccionado.
     */
    public void guardarEfecto( boolean pFavoritos, boolean pFantasia, boolean pDivertidos )
    {
        efectos[ efectoActual ].guardar( pFavoritos, pFantasia, pDivertidos );

    }

    /**
     * Busca un efecto por su nombre y lo asigna como el efecto actual.
     * @param pNombre Nombre del efecto buscado.
     * @throws Exception Si no encuentra ningún efecto con el nombre especificado.
     */
    public void buscarPorNombre( String pNombre ) throws Exception
    {
        boolean encontrado = false;
        for( int i = 0; i < efectos.length && !encontrado; i++ )
        {
            if( efectos[ i ].darNombre( ).equalsIgnoreCase( pNombre ) )
            {
                encontrado = true;
                efectoActual = i;
            }
        }

        if( !encontrado )
        {
            throw new Exception( "No se encontró ningún efecto con este nombre." );
        }
    }

    /**
     * Retorna la nota con el nombre dado.
     * @param pNombre Nombre de la nota a buscar. pNombre != null && pNombre != "".
     * @return Nota buscada, null si no hay ninguna nota con ese nombre.
     */
    public Nota buscarNotaPorNombre( String pNombre )
    {
        Nota buscada = null;
        for( int i = 0; i < CANT_NOTAS && buscada == null; i++ )
        {
            if( notas[ i ].darNombre( ).equals( pNombre ) )
            {
                buscada = notas[ i ];
            }
        }
        return buscada;
    }

    /**
     * Busca el efecto con mejor calificación y lo asigna como el efecto actual.<br>
     * <b> post: </b> Se actualizó el efecto actual
     */
    public void buscarMejorCalificado( )
    {
        double calificacionMejor = 0;
        for( int i = 0; i < efectos.length; i++ )
        {
            if( efectos[ i ].darCalificacion( ) >= calificacionMejor )
            {
                calificacionMejor = efectos[ i ].darCalificacion( );
                efectoActual = i;
            }
        }
    }

    /**
     * Calcula la cantidad de efectos que pertenecen a un grupo especificado.
     * @param pGrupo Grupo del cual se desea consultar la cantidad de efectos.
     * @return La cantidad de efectos pertenecientes al grupo.
     * @throws Exception Si el grupo especificado no existe.
     */
    public int contarEfectosPorGrupo( String pGrupo ) throws Exception
    {
        int contador = 0;
        if( !pGrupo.equalsIgnoreCase( "Favoritos" ) && !pGrupo.equalsIgnoreCase( "Fantasía" ) && !pGrupo.equalsIgnoreCase( "Divertidos" ) )
        {
            throw new Exception( "No se encontró el grupo especificado." );
        }
        else
        {
            for( Efecto efecto : efectos )
            {
                if( pGrupo.equalsIgnoreCase( "Favoritos" ) && efecto.esFavorito( ) )
                {
                    contador++;
                }
                else if( pGrupo.equalsIgnoreCase( "Fantasía" ) && efecto.esFantasia( ) )
                {
                    contador++;
                }
                else if( pGrupo.equalsIgnoreCase( "Divertidos" ) && efecto.esDivertido( ) )
                {
                    contador++;
                }
            }
        }

        return contador;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Reproduce la nota especificada en el efecto actual.
     * @param pNombreNota Nombre de la nota a reproducir.
     */
    public void reproducir( String pNombreNota )
    {
        try
        {
            Nota nota = buscarNotaPorNombre( pNombreNota );

            Sequencer sequencer = MidiSystem.getSequencer( );
            sequencer.open( );
            sequencer.stop( );
            Sequence sequence = new Sequence( Sequence.PPQ, 4 );
            Track track = sequence.createTrack( );

            ShortMessage first = new ShortMessage( );
            first.setMessage( 192, 1, efectos[ efectoActual ].darIndice( ), 0 );

            MidiEvent changeInstrument = new MidiEvent( first, 1 );
            track.add( changeInstrument );

            ShortMessage a = new ShortMessage( );
            a.setMessage( 144, 1, nota.darValor( ), 100 );
            MidiEvent noteOn = new MidiEvent( a, 1 );
            track.add( noteOn );

            ShortMessage b = new ShortMessage( );
            b.setMessage( 128, 1, nota.darValor( ), 100 );
            MidiEvent noteOff = new MidiEvent( b, 16 );
            track.add( noteOff );

            sequencer.setSequence( sequence );
            sequencer.start( );

        }
        catch( Exception e )
        {
            // Esta excepción nunca sucede.
        }
    }

    /**
     * Método para la extensión 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}
