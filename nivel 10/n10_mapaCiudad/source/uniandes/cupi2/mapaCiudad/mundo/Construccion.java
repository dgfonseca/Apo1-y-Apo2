/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Construccion.java,v 1.1 2007/03/22 16:12:59 p-marque Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_mapaCiudad
 * Autor: Daniel Francisco Romero Acero - 25-ene-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.mapaCiudad.mundo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Esta es una clase abstracta que representa a una construcci�n <br>
 * <b>inv: </v> x >=0 y y>=0 y ancho>=0 y alto >=0 <br>
 */
public abstract class Construccion implements IConstruccion
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante para definir el Margen de la Construcci�n.
     */
    public static final int MARGEN_CONSTRUCCION = 10;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ancho de la construcci�n
     */
    protected int ancho;

    /**
     * Alto de la construcci�n
     */
    protected int alto;

    /**
     * Coordenada x de la construcci�n
     */
    protected int x;

    /**
     * Coordenada y de la construcci�n
     */
    protected int y;

    /**
     * Color de fondo de la construcci�n
     */
    protected Color colorFondo;

    /**
     * La fuente del texto mostrado
     */
    protected Font fuente;

    /**
     * El texto a ser mostrado
     */
    protected String texto;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la construcci�n con los valores especificados
     * @param px Coordenada x de la construcci�n
     * @param py Coordenada y de la construcci�n
     * @param elAlto Alto de la construcci�n
     * @param elAncho Ancho de la construcci�n
     * @param elColorFondo color de fondo de la construcci�n
     */
    public Construccion( int px, int py, int elAlto, int elAncho, Color elColorFondo )
    {
        x = px;
        y = py;
        colorFondo = elColorFondo;
        texto = "";
        fuente = new Font( "Arial", Font.PLAIN, 10 );
        alto = elAlto;
        ancho = elAncho;
        verificarInvariante( );
    }

    /**
     * Crea una construcci�n a partir de los datos contenidos en un archivo
     * @param br Es el stream que sirve para leer el archivo
     * @throws IOException Se lanza esta excepci�n si hay problemas leyendo el archivo
     * @throws FormatoInvalidoExcepcion Se lanza esta excepci�n si el formato del archivo no es el esperado
     */
    public Construccion( BufferedReader br ) throws IOException, FormatoInvalidoExcepcion
    {
        String lineaPuntos = br.readLine( );
        String lineaFondo = br.readLine( );
        String lineaFuente = br.readLine( );
        texto = br.readLine( );

        try
        {
            inicializarPuntos( lineaPuntos );
            inicializarColorFondo( lineaFondo );
            inicializarFuente( lineaFuente );
        }
        catch( FormatoInvalidoExcepcion fie )
        {
            br.close( );
            throw fie;
        }
        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Inicializa los puntos de la construcci�n a partir de la l�nea que estaba en el archivo <br>
     * <b>post: </b> x,y tienen nuevos valores
     * @param lineaPuntos La l�nea con la informaci�n de los dos puntos
     * @throws FormatoInvalidoExcepcion Se lanza esta excepci�n si el formato de la l�nea no es el esperado
     */
    private void inicializarPuntos( String lineaPuntos ) throws FormatoInvalidoExcepcion
    {
        String[] strValores = lineaPuntos.split( ";" );
        if( strValores.length != 2 )
            throw new FormatoInvalidoExcepcion( lineaPuntos );

        try
        {
            x = Integer.parseInt( strValores[ 0 ] );
            y = Integer.parseInt( strValores[ 1 ] );
        }
        catch( NumberFormatException nfe )
        {
            throw new FormatoInvalidoExcepcion( lineaPuntos );
        }
    }

    /**
     * Inicializa el color del fondo a partir de la informaci�n que estaba contenida en el archivo <br>
     * <b>post: </b> colorFondo tiene nuevo color
     * @param lineaFondo La l�nea de texto que indica el color del fondo de la construcci�n
     * @throws FormatoInvalidoExcepcion Se lanza esta excepci�n si el formato de la l�nea no es el esperado
     */
    private void inicializarColorFondo( String lineaFondo ) throws FormatoInvalidoExcepcion
    {

        String[] strValoresFondo = lineaFondo.split( ";" );

        if( strValoresFondo.length != 3 )
            throw new FormatoInvalidoExcepcion( lineaFondo );

        try
        {
            int r1 = Integer.parseInt( strValoresFondo[ 0 ] );
            int g1 = Integer.parseInt( strValoresFondo[ 1 ] );
            int b1 = Integer.parseInt( strValoresFondo[ 2 ] );

            colorFondo = new Color( r1, g1, b1 );
        }
        catch( NumberFormatException nfe )
        {
            throw new FormatoInvalidoExcepcion( lineaFondo );
        }
    }

    /**
     * Inicializa la fuente usada para mostrar el texto de la construcci�n <br>
     * <b>post: </b> fuente tiene una nueva fuente de texto
     * @param lineaFuente La l�nea de texto que describe la fuente usada en el texto de la construcci�n
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

            fuente = new Font( nomFuente, estilo, tam );
        }
        catch( NumberFormatException nfe )
        {
            throw new FormatoInvalidoExcepcion( lineaFuente );
        }
    }

    /**
     * Sirve para pintar el texto de la construcci�n
     * @param g La superficie donde se debe pintar
     */
    protected void pintarTexto( Graphics2D g )
    {
        int centroX = Math.abs( x + ( x + ancho ) ) / 2;
        int centroY = Math.abs( y + ( alto - ( MARGEN_CONSTRUCCION ) ) );

        g.setFont( fuente );
        g.setColor( Color.BLACK );

        FontMetrics metrics = g.getFontMetrics( );
        int ancho = metrics.stringWidth( texto );

        g.drawString( texto, centroX - ancho / 2, centroY );
    }

    /**
     * Cambia el texto de la construcci�n
     * @param txt El nuevo texto
     */
    public void cambiarTexto( String txt )
    {
        texto = txt;
    }

    /**
     * Retorna el texto de la construcci�n
     * @return Texto de la construcci�n
     */
    public String darTexto( )
    {
        return texto;
    }

    /**
     * Sirve para saber si un punto est� dentro de una construcci�n o no.
     * @param px Es la coordenada x del punto
     * @param py Es la coordenada y del punto
     * @return Retorna true si el punto est� dentro de la construcci�n. Retorna false en caso contrario.
     */
    public boolean estaDentro( int px, int py )
    {
        
        Rectangle2D rectangulo = new Rectangle2D.Double( x, y, ancho, alto );

        return rectangulo.contains( px  , py   );
    }

    /**
     * Este m�todo sirve para guardar una construcci�n en un archivo
     * @param out Es el stream donde se va a guardar la construcci�n
     */
    public void guardar( PrintWriter out )
    {
        out.println( darTipo( ) );
        out.println( "" + x + ";" + y );
        out.println( "" + colorFondo.getRed( ) + ";" + colorFondo.getGreen( ) + ";" + colorFondo.getBlue( ) );
        out.println( "" + fuente.getFamily( ) + ";" + fuente.getStyle( ) + ";" + fuente.getSize( ) );
        out.println( texto );
    }

    /**
     * Sirve para pintar la construcci�n de forma normal
     * @param g La superficie donde se debe pintar
     */
    public abstract void pintar( Graphics2D g );

    /**
     * Sirve para retornar el tipo de la construcci�n
     * @return El tipo de la construcci�n
     */
    public abstract String darTipo( );

    /**
     * Sirve para pintar la figura como figura seleccionada
     * @param g La superficie donde se debe pintar
     */
    public void pintarSombreada( Graphics2D g )
    {
        g.setStroke( new BasicStroke( 1 ) );
        g.setPaint( Color.DARK_GRAY );

        Rectangle2D rectangulo = new Rectangle2D.Double( x, y, ancho, alto );
        g.fill( rectangulo );

        g.setPaint( Color.BLACK );
        g.draw( rectangulo );
        g.setStroke( new BasicStroke( 1 ) );
    }

    /**
     * Pinta la construcci�n como seleccionada.
     * @param g Es la superficie donde se pinta el �valo
     */
    public void pintarSeleccionada( Graphics2D g )
    {
        float[] dash = { 30, 10, 10, 10 };
        BasicStroke stroke = new BasicStroke( 5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, dash, 0 );
        g.setStroke( stroke );
        if( Color.CYAN != colorFondo )
        {
            g.setColor( Color.CYAN );
        }
        else
        {
            g.setColor( Color.BLACK );
        }
        g.drawRect( x, y, ancho, alto );
        g.setStroke( new BasicStroke( 1 ) );
    }

    /**
     * Cambia la coordenada x de la construcci�n
     * @param px Nueva coordenada x de la construcci�n
     */
    public void cambiarX( int px )
    {
        x = px;
        verificarInvariante( );
    }

    /**
     * Cambia la coordenada y de la construcci�n
     * @param py Nueva coordenada y de la construcci�n
     */
    public void cambiarY( int py )
    {
        y = py;
        verificarInvariante( );
    }

    /**
     * Cambia el ancho de la construcci�n
     * @param elAncho Nuevo ancho de la construcci�n
     */
    public void cambiarAncho( int elAncho )
    {
        ancho = elAncho;
        verificarInvariante( );
    }

    /**
     * Retorna el ancho de la construcci�n
     * @return ancho de la construcci�n
     */
    public int darAncho( )
    {
        return ancho;
    }

    /**
     * Retorna el alto de la construcci�n
     * @return alto de la construcci�n
     */
    public int darAlto( )
    {
        return alto;
    }

    /**
     * Cambia el alto de la construcci�n
     * @param elAlto Nuevo alto de la construcci�n
     */
    public void cambiarAlto( int elAlto )
    {
        alto = elAlto;
        verificarInvariante( );
    }

    /**
     * Retorna la fuente de la construcci�n
     * @return Fuente de la construcci�n
     */
    public Font darFuente( )
    {
        return fuente;
    }

    /**
     * Cambia la fuente de la construcci�n
     * @param laFuente Nueva fuente de la construcci�n
     */
    public void cambiarFuente( Font laFuente )
    {
        fuente = laFuente;
    }

    /**
     * Retorna la coordenada x de la construcci�n
     * @return Coordenada x de la construcci�n
     */
    public int darX( )
    {
        return x;
    }

    /**
     * Retorna la coordenada y de la construcci�n
     * @return Coordenada y de la construcci�n
     */
    public int darY( )
    {
        return y;
    }

    /**
     * Verifica el invariante de la clase <br>
     * <b>inv: </v> x >=0 y y>=0 y ancho>=0 y alto >=0 <br>
     * 
     */
    public void verificarInvariante( )
    {
        assert ( x >= 0 ) : "La coordenada x es inv�lida";
        assert ( y >= 0 ) : "La coordenada y es inv�lida";
        assert ( ancho >= 0 ) : "El ancho es inv�lido";
        assert ( alto >= 0 ) : "El alto es inv�lido";
    }
}
