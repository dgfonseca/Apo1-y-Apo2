/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Glorieta.java,v 1.1 2007/03/22 16:12:59 p-marque Exp $
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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Esta es una clase que representa una glorieta
 */

public class Glorieta extends Carretera
{
    
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante para definir el tipo glorieta.
     */
    public final static String TIPO = "GLORIETA";
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el cruce con los valores especificados
     * @param x Coordenada x del cruce
     * @param y Coordenada y del cruce
     * @param colorFondo color de fondo de la cruce
     */
    public Glorieta( int x, int y, Color colorFondo )
    {
        super( x, y, colorFondo );
    }

    /**
     * Construye un cruce a partir de los datos contenidos en un archivo
     * @param br Es el stream que sirve para leer el archivo
     * @throws IOException Se lanza esta excepción si hay problemas leyendo el archivo
     * @throws FormatoInvalidoExcepcion Se lanza esta excepción si el formato del archivo no es el esperado
     */
    public Glorieta( BufferedReader br ) throws IOException, FormatoInvalidoExcepcion
    {
        super( br );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Retorna el tipo de la glorieta
     * @return El tipo de la glorieta
     */
    public String darTipo()
    {
        return TIPO; 
    }

    /**
     * Sirve para pintar el cruce
     * @param g La superficie donde se debe pintar
     */
    public void pintar( Graphics2D g )
    {
        // Pintar el fondo
        g.setColor( colorFondo );
        g.fillRect( x, y, ancho, alto );

        // Pintar las uniones grises de la glorieta
        g.setColor( Color.GRAY );
        g.fillRect( x + MARGEN_CONSTRUCCION / 2, y, ancho - MARGEN_CONSTRUCCION, alto );
        g.setColor( Color.GRAY );
        g.fillRect( x, y + MARGEN_CONSTRUCCION / 2, ancho, alto - MARGEN_CONSTRUCCION );

        // Pintar la parte verde de la glorieta
        g.setColor( Color.GREEN );
        g.fillOval( x + 15, y + 15, ancho / 4, alto / 4 );

        // Pintar el borde la parte verde de la glorieta
        g.setColor( Color.BLACK );
        BasicStroke tipoLinea = new BasicStroke( 3 );
        g.setStroke( tipoLinea );
        g.drawOval( x + 15, y + 15, ancho / 4, alto / 4 );

        // Lineas de la glorieta sur-norte
        g.drawLine( x + MARGEN_CONSTRUCCION / 2, y + 1, x + MARGEN_CONSTRUCCION / 2, y + MARGEN_CONSTRUCCION / 2 );
        g.drawLine( x + MARGEN_CONSTRUCCION / 2, y + alto - MARGEN_CONSTRUCCION / 2, x + MARGEN_CONSTRUCCION / 2, y + alto - 2 );
        g.drawLine( x - MARGEN_CONSTRUCCION / 2 + ancho - 2, y + alto - MARGEN_CONSTRUCCION / 2 - 2, x - MARGEN_CONSTRUCCION / 2 + ancho - 2, y + alto - 2 );
        g.drawLine( x - MARGEN_CONSTRUCCION / 2 + ancho - 2, y + 1, x - MARGEN_CONSTRUCCION / 2 + ancho - 2, y + MARGEN_CONSTRUCCION / 2 );
        // Lineas de la glorieta oeste-este
        g.drawLine( x + 1, y + MARGEN_CONSTRUCCION / 2, x + MARGEN_CONSTRUCCION / 2, y + MARGEN_CONSTRUCCION / 2 );
        g.drawLine( x + 1, y - MARGEN_CONSTRUCCION / 2 + alto - 2, x + MARGEN_CONSTRUCCION / 2, y - MARGEN_CONSTRUCCION / 2 + alto - 2 );
        g.drawLine( x + ancho - MARGEN_CONSTRUCCION / 2, y - MARGEN_CONSTRUCCION / 2 + alto - 2, x + ancho - 2, y - MARGEN_CONSTRUCCION / 2 + alto - 2 );
        g.drawLine( x + ancho - MARGEN_CONSTRUCCION / 2, y + MARGEN_CONSTRUCCION / 2, x + ancho - 2, y + MARGEN_CONSTRUCCION / 2 );

        // Dibujar las lineas blancas de la glorieta
        float[] dash = { 10, 10, 10, 10 };
        g.setStroke( new BasicStroke( 3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, dash, 0 ) );
        g.setColor( Color.WHITE );
        g.drawOval( x + 7, y + 7, ancho - 14, alto - 14 );
        g.setStroke( new BasicStroke( 1 ) );
        //Pintar el texto
        pintarTexto( g );
    }
}
