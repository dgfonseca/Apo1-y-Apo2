/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Rectangulo.java,v 1.9 2007/04/13 04:29:55 carl-veg Exp $ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_paint
 * Autor: Mario S�nchez - 27/09/2005 
 * Autor: Jorge Villalobos - 26/09/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.paint.mundo;

import java.awt.*;
import java.awt.geom.*;
import java.io.*;

/**
 * Esta clase representa un rect�ngulo que hace parte de una composici�n. <br>
 * <b>inv:</b> <br>
 * rectangulo!=null
 */
public class Rectangulo extends FiguraRellena
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Representa el tipo de la figura
     */
    public final static String TIPO = "RECTANGULO";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Representaci�n gr�fica del rect�ngulo
     */
    private Rectangle2D rectangulo;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un rect�ngulo
     * @param x1f La coordenada x del primer punto - x1f>=0
     * @param y1f La coordenada y del primer punto - y1f>=0
     * @param x2f La coordenada x del segundo punto - x2f>=0
     * @param y2f La coordenada y del segundo punto - y2f>=0
     * @param colorLineaF El color de la l�nea de la figura - colorLineaF != null
     * @param colorFondoF El color del fondo de la figura - colorFondoF != null
     * @param tipoLineaF El tipo de l�nea usado para pintar la figura - tipoLineaF != null
     */
    public Rectangulo( int x1f, int y1f, int x2f, int y2f, Color colorLineaF, Color colorFondoF, BasicStroke tipoLineaF )
    {
        super( Math.min( x1f, x2f ), Math.min( y1f, y2f ), Math.max( x1f, x2f ), Math.max( y1f, y2f ), colorLineaF, colorFondoF, tipoLineaF );
        int ancho = Math.abs( x1 - x2 );
        int alto = Math.abs( y1 - y2 );
        rectangulo = new Rectangle2D.Double( x1, y1, ancho, alto );
    }

    /**
     * Construye un rect�ngulo a partir de los datos contenidos en un archivo
     * @param br Es el flujo que sirve para leer el archivo
     * @throws IOException Se lanza esta excepci�n si hay problemas leyendo el archivo
     * @throws FormatoInvalidoException Se lanza esta excepci�n si el formato del archivo no es el esperado
     */
    public Rectangulo( BufferedReader br ) throws IOException, FormatoInvalidoException
    {
        super( br );
        int ancho = Math.abs( x1 - x2 );
        int alto = Math.abs( y1 - y2 );
        rectangulo = new Rectangle2D.Double( x1, y1, ancho, alto );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna la cadena de caracteres que va a identificar este tipo de figuras en la persistencia
     * @return Retorna la cadena con el tipo de la figura
     */
    public String darTipoFigura( )
    {
        return TIPO;
    }

    /**
     * Pinta la figura, incluyendo su texto.
     * @param g Objeto utilizado para pintar
     * @param seleccionada Indica si la figura que se va a dibujar es la seleccionada
     */
    public void dibujar( Graphics2D g, boolean seleccionada )
    {
        // Pintar la l�nea
        dibujarRectangulo( g );
        // Pintar el texto
        dibujarTexto( g );
        // Dibujar la marca de seleccionada
        if( seleccionada )
        {
            BasicStroke continuo = new BasicStroke( 5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1, new float[]{ 10f, 0f }, 0 );
            g.setStroke( continuo );
            g.setColor( Color.GREEN );
            g.drawOval( x1 - 3, y1 - 3, 7, 7 );
            g.drawOval( x1 - 3, y2 - 3, 7, 7 );
            g.drawOval( x2 - 3, y2 - 3, 7, 7 );
            g.drawOval( x2 - 3, y1 - 3, 7, 7 );
        }
    }

    /**
     * Pinta el rect�ngulo
     * @param g Es la superficie sobre la que se va a pintar
     */
    private void dibujarRectangulo( Graphics2D g )
    {
        g.setPaint( colorFondo );
        g.setStroke( tipoLinea );
        g.fill( rectangulo );
        g.setPaint( colorLinea );
        g.draw( rectangulo );
    }

    /**
     * Sirve para saber si un punto est� dentro de una figura o no.
     * @param x Es la coordenada x del punto
     * @param y Es la coordenada y del punto
     * @return Retorna true si el punto est� dentro de la figura. Retorna false en caso contrario.
     */
    public boolean estaDentro( int x, int y )
    {
        return rectangulo.contains( x, y );
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase. <br>
     * <b>inv:</b> <br>
     * rectangulo!=null
     */
    protected void verificarInvariante( )
    {
        super.verificarInvariante( );

        assert rectangulo != null : "La representaci�n gr�fica del rect�ngulo no deber�a ser null";
    }
}