/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: Partitura.java 604 2006-11-07 04:47:33Z da-romer $ 
 * Universidad de los Andes (Bogot� - Colombia) 
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Todos los derechos reservados 2005 
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_partitura
 * Autor: Diana Puentes - Jul 29, 2005
 * Modificado por: Daniel Francisco Romero Acero- Marzo 23, 2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.partitura.mundo;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * Esta es una clase que representa una partitura musical. <br>
 * <b>inv: </b> <br>
 * notas != null <br>
 * notas.size <= NUM_MAX_NOTAS <br>
 */
public class Partitura
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    
    public static final int ESPACIO_LINEAS_PENTAGRAMA = 12;

    public static final int ANCHO_PARTITURA = 1010;

    public static final int ALTO_PARTITURA = 313;

    public static final int MARGEN_PARTITURA_INTERNA = 92;

    public static final int MARGEN_PARTITURA_EXTERNA = 12;

    public static final String ARCHIVO_IMAGEN_CLAVE_SOL = "claveSol.GIF";

    public static final int ALTO_IMAGEN_CLAVE_SOL = 79;

    public static final int ANCHO_IMAGEN_CLAVE_SOL = 47;

    public static final int NUM_MAX_NOTAS = 60;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Representa el conjunto de notas de la canci�n de la partitura
     */
    private ArrayList notas;

    /**
     * El t�tulo de la partitura
     */
    private String titulo;

    /**
     * El tipo de letra del t�tulo de la partitura
     */
    private Font fuenteTitulo;

    /**
     * El color del t�tulo de la partitura
     */
    private Color colorTitulo;

    /**
     * Posici�n de la nota marcada (que se est� tocando actualmente)
     */
    private int posicionNotaMarcada;

    /**
     * Es el archivo donde se est� salvando actualmente la partitura
     */
    private String archivo;

    /**
     * La figura de la clave de sol
     */
    private BufferedImage figuraClaveSol;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva partitura vac�a
     */
    public Partitura( )
    {
        notas = new ArrayList( );
        titulo = "";
        fuenteTitulo = new Font( "Arial", Font.PLAIN, 10 );
        colorTitulo = Color.BLACK;
        cargarImagen( ARCHIVO_IMAGEN_CLAVE_SOL );
        posicionNotaMarcada = -1;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------
    /**
     * Carga la imagen con el nombre especificado
     * @param imagen Nombre de la imagen a ser cargada
     */
    private void cargarImagen( String imagen )
    {
        try
        {
            figuraClaveSol = ImageIO.read( new File( "data\\" + imagen ) );
        }
        catch( IOException e )
        {
            figuraClaveSol = new BufferedImage( 1, 1, BufferedImage.TYPE_INT_RGB );
        }
    }

    /**
     * Carga la partitura que se encuentra en el archivo dado por la ruta <br>
     * <b>Pre: </b> La partitura puede tener m�ximo 40 notas <br>
     * <b>Post: </b> Almacena los datos de la partitura en el ArrayList notas <br>
     * @param nombreArchivo - La ruta del archivo que contiene la partitura
     * @return La lista de las notas cargadas en la partitura
     * @throws IOException Se lanza esta excepci�n si alguna de las l�neas es inv�lida o si no se encuentra el archivo a cargar
     */
    public void abrir( String nombreArchivo ) throws FormatoInvalidoExcepcion, IOException
    {
        ArrayList notasAnteriores = new ArrayList( );

        // Cargar las notas
        BufferedReader br = new BufferedReader( new FileReader( nombreArchivo ) );
        String linea = br.readLine( );
        try
        {
            titulo = linea;
            linea = br.readLine( );
            inicializarColorTitulo( linea );
            linea = br.readLine( );
            inicializarFuente( linea );

            // Salvar las notas anteriores por si se presenta algun error
            notasAnteriores.addAll( notas );

            // Eliminar las notas anteriores
            notas.clear( );

            // Crear las notas
            linea = br.readLine( );
            int cuantasNotas = Integer.parseInt( linea );
            for( int i = 0; i < cuantasNotas; i++ )
            {
                linea = br.readLine( );
                crearNota( linea, br );
            }

            br.close( );
        }
        catch( NumberFormatException nfe )
        {
            br.close( );
            notas.clear( );
            notas.addAll( notasAnteriores );
            throw new FormatoInvalidoExcepcion( linea );
        }

        // Reemplazar el nombre de archivo viejo
        archivo = nombreArchivo;

        verificarInvariante( );

    }

    /**
     * Salva la partitura actual en el archivo que se ven�a usando. <br>
     * <b>pre: </b> Hay un archivo para salvar ya establecido. <br>
     * <b>post: </b> Se salv� la partitura en un archivo.
     * @throws IOException Se lanza esta excepci�n si hay problemas salvando la partitura
     */
    public void salvar( ) throws IOException
    {
        PrintWriter out = new PrintWriter( archivo );
        out.println( titulo );
        out.println( "" + colorTitulo.getRed( ) + ";" + colorTitulo.getGreen( ) + ";" + colorTitulo.getBlue( ) );
        out.println( "" + fuenteTitulo.getFamily( ) + ";" + fuenteTitulo.getStyle( ) + ";" + fuenteTitulo.getSize( ) );
        out.println( notas.size( ) );

        // Guardar las notas de la partitura
        for( int cont = 0; cont < notas.size( ); cont++ )
        {
            INota n = ( Nota )notas.get( cont );
            n.guardar( out );
        }

        out.close( );
    }

    /**
     * Salva la partitura actual en el archivo especificado. <br>
     * <b>post: </b> Se salv� la partitura en un archivo.
     * @param nombreArchivo Es el nombre del archivo donde se va a salvar la partitura
     * @throws IOException Se lanza esta excepci�n si hay problemas salvando la partitura
     */
    public void salvar( String nombreArchivo ) throws IOException
    {
        archivo = nombreArchivo;
        salvar( );
    }

    /**
     * Inicializa el color del t�tulo a partir de la informaci�n que estaba contenida en el archivo <br>
     * <b>post: </b> colorTitulo tiene nuevo color
     * @param lineaColorTitulo La l�nea de texto que indica el color del titulo de la partitura
     * @throws FormatoInvalidoExcepcion Se lanza esta excepci�n si el formato de la l�nea no es el esperado
     */
    private void inicializarColorTitulo( String lineaColorTitulo ) throws FormatoInvalidoExcepcion
    {

        String[] strValoresFondo = lineaColorTitulo.split( ";" );

        if( strValoresFondo.length != 3 )
            throw new FormatoInvalidoExcepcion( lineaColorTitulo );

        try
        {
            int r1 = Integer.parseInt( strValoresFondo[ 0 ] );
            int g1 = Integer.parseInt( strValoresFondo[ 1 ] );
            int b1 = Integer.parseInt( strValoresFondo[ 2 ] );

            colorTitulo = new Color( r1, g1, b1 );
        }
        catch( NumberFormatException nfe )
        {
            throw new FormatoInvalidoExcepcion( lineaColorTitulo );
        }

    }

    /**
     * Inicializa la fuente usada para mostrar el t�tulo de la partitura <br>
     * <b>post: </b> fuenteTitulo tiene una nueva fuente de texto
     * @param lineaFuente La l�nea de texto que describe la fuente usada en el texto de la partitura
     * @throws FormatoInvalidoExcepcion Se lanza esta excepci�n si el formato de la l�nea no es el esperado
     */
    private void inicializarFuente( String lineaFuente ) throws FormatoInvalidoExcepcion
    {
        String[] strFuente = lineaFuente.split( ";" );

        if( strFuente.length != 3 )
            throw new FormatoInvalidoExcepcion( lineaFuente );

        try
        {
            String nomFuente = strFuente[ 0 ];
            int estilo = Integer.parseInt( strFuente[ 1 ] );
            int tam = Integer.parseInt( strFuente[ 2 ] );

            fuenteTitulo = new Font( nomFuente, estilo, tam );
        }
        catch( NumberFormatException nfe )
        {
            throw new FormatoInvalidoExcepcion( lineaFuente );
        }
    }

    /**
     * Crea una nota con los datos contenidos en un archivo y la adiciona a la lista respectiva
     * @param claseNota Es la cadena que identifica la clase de nota que se debe construir (redonda, blanca, negra, corchea o semicorchea)
     * @param br Es el stream de donde se pueden leer los datos para crear la nota - br!=null
     * @throws FormatoInvalidoExcepcion Se lanza esta excepci�n si el archivo tiene un formato incorrecto
     * @throws IOException Se lanza esta excepci�n si hay problemas leyendo del archivo
     */
    private void crearNota( String claseNota, BufferedReader br ) throws FormatoInvalidoExcepcion, IOException
    {
        INota nueva = null;

        if( "REDONDA".equalsIgnoreCase( claseNota ) )
        {
            nueva = new Redonda( br );
        }
        else if( "BLANCA".equalsIgnoreCase( claseNota ) )
        {
            nueva = new Blanca( br );
        }
        else if( "NEGRA".equalsIgnoreCase( claseNota ) )
        {
            nueva = new Negra( br );
        }
        else if( "CORCHEA".equalsIgnoreCase( claseNota ) )
        {
            nueva = new Corchea( br );
        }
        else if( "SEMICORCHEA".equalsIgnoreCase( claseNota ) )
        {
            nueva = new Semicorchea( br );
        }
        else
        {
            br.close( );
            throw new FormatoInvalidoExcepcion( claseNota );
        }

        notas.add( nueva );
    }

    /**
     * Crea una nota con los datos especificados
     * @param claseNota Es la cadena que identifica la clase de nota que se debe construir <br>
     *        (redonda, blanca, negra, corchea o semicorchea)
     * @param nombre Nombre de la nota (do, re, mi, fa, sol, la, si, do2)
     * @param tipo El tipo de la nota (normal o sostenido)
     * @param color El color de la nota
     * @return Nueva nota. En el caso de que claseNota no corresponda a ninguna clase de nota se retorna null
     */
    public INota crearNota( String claseNota, String nombre, String tipo, Color color )
    {
        INota nueva = null;

        if( "REDONDA".equalsIgnoreCase( claseNota ) )
        {
            nueva = new Redonda( nombre, tipo, color );
        }
        else if( "BLANCA".equalsIgnoreCase( claseNota ) )
        {
            nueva = new Blanca( nombre, tipo, color );
        }
        else if( "NEGRA".equalsIgnoreCase( claseNota ) )
        {
            nueva = new Negra( nombre, tipo, color );
        }
        else if( "CORCHEA".equalsIgnoreCase( claseNota ) )
        {
            nueva = new Corchea( nombre, tipo, color );
        }
        else if( "SEMICORCHEA".equalsIgnoreCase( claseNota ) )
        {
            nueva = new Semicorchea( nombre, tipo, color );
        }

        return nueva;
    }

    /**
     * Retorna el conjunto de notas de la partitura
     * @return Una lista con las notas que componen la canci�n escrita en la partitura
     */
    public ArrayList darNotas( )
    {
        return notas;
    }

    /**
     * Sirve para pintar la partitura con todas las notas que contiene
     * @param g La superficie donde se debe pintar
     */
    public void pintarPartitura( Graphics2D g )
    {
        INota nota;

        // Pintar el fondo blanco
        g.setColor( Color.WHITE );
        g.fillRect( MARGEN_PARTITURA_EXTERNA, MARGEN_PARTITURA_EXTERNA, ANCHO_PARTITURA, ALTO_PARTITURA );

        // Pintar el t�tulo de la partitura
        pintarTitulo( g );

        // Pintar las notas
        for( int cont = 0; cont < notas.size( ); cont++ )
        {
            nota = ( INota )notas.get( cont );

            if( posicionNotaMarcada != cont )
            {
                nota.pintarNota( g, cont );
            }
            else
            {
                nota.pintarNotaMarcada( g, cont );
            }

        }

        // Pintar las l�neas del pentagrama- parte superior
        pintarPentagrama( MARGEN_PARTITURA_INTERNA, g );

        // Pintar las l�neas del pentagrama- parte inferior
        pintarPentagrama( MARGEN_PARTITURA_INTERNA + MARGEN_PARTITURA_INTERNA / 2 + ESPACIO_LINEAS_PENTAGRAMA * 5, g );

    }

    /**
     * Pinta el t�tulo de la partitura
     * @param g La superficie donde se debe pintar
     */
    public void pintarTitulo( Graphics2D g )
    {
        int posX = ( ANCHO_PARTITURA + MARGEN_PARTITURA_EXTERNA * 2 ) / 2;
        int posY = MARGEN_PARTITURA_EXTERNA + MARGEN_PARTITURA_INTERNA / 3;

        g.setFont( fuenteTitulo );
        g.setColor( colorTitulo );

        FontMetrics metrics = g.getFontMetrics( );
        int ancho = metrics.stringWidth( titulo );

        g.drawString( titulo, posX - ancho / 2, posY );

    }

    /**
     * Pinta un pentagrama iniciando desde la posici�n en Y especificada
     * @param posY Posici�n en Y desde la que se va a empezar a pintar el pentagrama
     * @param g La superficie donde se debe pintar
     */
    public void pintarPentagrama( int posY, Graphics2D g )
    {
        g.setColor( Color.BLACK );

        int posYActual = posY;

        // Pintar las l�neas
        for( int cont = 0; cont < 5; cont++ )
        {
            g.drawLine( MARGEN_PARTITURA_EXTERNA, posYActual, ANCHO_PARTITURA, posYActual );

            posYActual += ESPACIO_LINEAS_PENTAGRAMA;
        }

        // Pintar la clave de sol
        pintarClaveSol( posY - ESPACIO_LINEAS_PENTAGRAMA, g );
    }

    /**
     * Carga de una imagen la clave de sol
     * @param posY Posici�n en y desde la que se va localizar la imagen de la clave de sol
     * @param g La superficie donde se debe pintar
     */
    public void pintarClaveSol( int posY, Graphics2D g )
    {
        g.drawImage( figuraClaveSol, MARGEN_PARTITURA_EXTERNA, posY, ANCHO_IMAGEN_CLAVE_SOL, ALTO_IMAGEN_CLAVE_SOL, Color.WHITE, null );
    }

    /**
     * Elimina las notas de la partitura
     * 
     */
    public void eliminarNotas( )
    {
        notas.clear( );
    }

    /**
     * Modifica el titulo de la partitura
     * @param nT Nuevo titulo de la partitura
     */
    public void cambiarTitulo( String nT )
    {
        titulo = nT;
    }

    /**
     * Retorna el nombre del archivo donde se est� guardando la informaci�n de este mapa
     * @return archivo. Si no se ha establecido todav�a el nombre del archivo, retorna null.
     */
    public String darNombreArchivo( )
    {
        return archivo;
    }

    /**
     * Retorna la fuente del titulo de la partitura
     * @return Fuente del titulo de la partitura
     */
    public Font darFuenteTitulo( )
    {
        return fuenteTitulo;
    }

    /**
     * Retorna el t�tulo de la partitura
     * @return T�tulo de la partitura
     */
    public String darTitulo( )
    {

        return titulo;
    }

    /**
     * Cambia la fuente del t�tulo
     * @param fuente Nueva fuente del t�tulo
     */
    public void cambiarFuenteTitulo( Font fuente )
    {
        fuenteTitulo = fuente;

    }

    /**
     * Cambia el color del t�tulo
     * @param color Nuevo color del t�tulo
     */
    public void cambiarColorTitulo( Color color )
    {
        colorTitulo = color;

    }

    /**
     * Retorna el color del t�tulo de la partitura
     * @return Retorna el color del t�tulo
     */
    public Color darColorTitulo( )
    {

        return colorTitulo;
    }

    /**
     * Retorna la posici�n de la nota que contiene los puntos especificados
     * @param x Punto x que debe contener la nota
     * @param y Punto y que debe contener la nota
     * @return Posici�n de la nota que contiene los dos puntos especificados. <br>
     *         Si ninguna nota contiene los puntos especificados se retorna -1.
     * 
     */
    public int buscarNota( int x, int y )
    {
        INota nota = null;
        int pos = -1;

        boolean encontrada = false;

        // Buscar la construcci�n
        for( int cont = 0; cont < notas.size( ) && !encontrada; cont++ )
        {
            nota = ( Nota )notas.get( cont );

            if( nota.estaDentro( x, y, cont ) )
            {
                encontrada = true;
                pos = cont;
            }

        }
        return pos;
    }

    /**
     * Elimina la nota en la posici�n especificada
     * @param posNota Posici�n de la nota a ser eliminada
     */
    public void eliminarNota( int posNota )
    {

        if( posNota >= 0 && posNota < notas.size( ) )
        {
            notas.remove( posNota );
            verificarInvariante( );
        }

    }

    /**
     * Cambia la informaci�n de la nota correspondiente a la posici�n especificada. <br>
     * En el caso de que la clase de la nota haya cambiado la elimina y la vuelve a crear
     * @param clase La clase de la nota (redonda, blanca, negra, corchea, semicorchea)
     * @param tipo El tipo de la nota (normal o sostenido)
     * @param color El color de la nota
     * @param posicion La posici�n de la nota a ser modificada
     * @param nombre El nombre de la nota (do, re mi, fa sol, la, si, do2)
     */
    public void cambiarInformacionNota( String clase, String tipo, Color color, int posicion, String nombre )
    {
        INota nota = ( INota )notas.get( posicion );

        if( clase.equalsIgnoreCase( nota.darClase( ) ) )
        {
            nota.cambiarColor( color );
            nota.cambiarTipo( tipo );
            nota.cambiarNombre( nombre );
        }
        else
        {
            nota = crearNota( clase, nombre, tipo, color );
            eliminarNota( posicion );
            notas.add( posicion, nota );
        }

    }

    /**
     * Retorna la nota en la posici�n especificada
     * @param pos Posici�n de la nota a ser retorna
     * @return Nota en la posici�n especificada. Se retorn� null si no existe una nota en la posici�n dada
     */
    public INota darNota( int pos )
    {
        INota n = null;

        if( pos >= 0 && pos < notas.size( ) )
        {
            n = ( INota )notas.get( pos );
        }

        return n;
    }

    /**
     * Modifica la nota marcada
     * @param pos Posici�n de la nota marcada
     */
    public void cambiarNotaMarcada( int pos )
    {
        posicionNotaMarcada = pos;

    }

    /**
     * Adiciona la nota especificada a la partitura si a�n no se ha excedido el n�mero m�ximo permitido
     * @param n Nueva nota a ser adicionada
     */
    public void adicionarNota( INota n )
    {
        if( notas.size( ) < NUM_MAX_NOTAS )
        {
            notas.add( n );
        }

    }

    /**
     * Verifica que la nota tocada es la correcta
     * @param nota Nota ser tocada
     * @param posicionActual Posici�n actual que se est� tocando
     * @return True si la nota es correcta, false de lo contrario
     */
    public boolean verificarNota( INota nota, int posicionActual )
    {
        boolean correcta = false;

        if( posicionActual >= 0 && posicionActual < notas.size( ) )
        {
            INota aux = ( INota )notas.get( posicionActual );

            if( aux.equals( nota ) )
                correcta = true;
        }

        return correcta;
    }

    /**
     * Retorna la posici�n de la nota que se encuentra marcada actualmente
     * @return Posici�n de la nota marcada
     */
    public int darPosicionNotaMarcada( )
    {
        return posicionNotaMarcada;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------
    /**
     * Verifica el invariante de la clase. <br>
     * <b>inv: </v> <br>
     * notas != null <br>
     * notas.size <= NUM_MAX_NOTAS <br>
     */
    public void verificarInvariante( )
    {
        assert ( notas != null ) : "La lista de notas no puede ser null";
        assert ( notas.size( ) <= NUM_MAX_NOTAS ) : "La cantidad de notas excede el n�mero m�ximo de notas permitido";
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * Ejecuta el punto de extensi�n 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "respuesta1";
    }

    /**
     * Ejecuta el punto de extensi�n 2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "respuesta2";
    }

}
