/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Carrera.java,v 1.1 2007/03/22 16:12:59 p-marque Exp $
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
 * Esta es una clase que representa a una carrera
 */
public class Carrera extends Carretera
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------    
    /**
     * Constante para definir el tipo Carrera.
     */
    public final static String TIPO = "CARRERA";
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la carrera con los valores especificados
     * @param x Coordenada x de la carrera
     * @param y Coordenada y de la carrera
     * @param colorFondo color de fondo de la carrera
     */
    public Carrera( int x, int y, Color colorFondo )
    {
        super( x, y, colorFondo );
    }

    /**
     * Construye una carrera a partir de los datos contenidos en un archivo
     * @param br Es el stream que sirve para leer el archivo
     * @throws IOException Se lanza esta excepción si hay problemas leyendo el archivo
     * @throws FormatoInvalidoExcepcion Se lanza esta excepción si el formato del archivo no es el esperado
     */
    public Carrera( BufferedReader br ) throws IOException, FormatoInvalidoExcepcion
    {
        super( br );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Sirve para pintar la carrera
     * @param g La superficie donde se debe pintar
     */
    public void pintar( Graphics2D g )
    {
        // Pintar el fondo
        g.setColor( colorFondo );
        g.fillRect( x, y, ancho, alto );

        // Pintar la parte gris de la carrera
        g.setColor( Color.GRAY );
        g.fillRect( x + MARGEN_CONSTRUCCION / 2, y, ancho - MARGEN_CONSTRUCCION, alto );

        // Pintar los bordes de la carrera
        // 1.0;1;1;1.0;10.0 0.0;0.0
        g.setColor( Color.BLACK );
        BasicStroke tipoLinea = new BasicStroke( 3 );
        g.setStroke( tipoLinea );
        g.drawLine( x + MARGEN_CONSTRUCCION / 2, y + 1, x + MARGEN_CONSTRUCCION / 2, y + alto - 2 );
        g.drawLine( x - MARGEN_CONSTRUCCION / 2 + ancho - 2, y + 1, x - MARGEN_CONSTRUCCION / 2 + ancho - 2, y + alto - 2 );

        // Pintar las lineas blancas
        g.setColor( Color.WHITE );
        g.setStroke( tipoLinea );
        g.drawLine( x + ( ancho / 2 ) - 1, y + 3, x + ( ancho / 2 ) - 1, y + 14 );
        g.drawLine( x + ( ancho / 2 ) - 1, y + 23, x + ( ancho / 2 ) - 1, y + 34 );

        // Pintar el texto
        pintarTexto( g );
    }
    
    /**
     * Retorna el tipo de la carrera
     * @return El tipo de la carrera
     */
    public String darTipo()
    {
        return TIPO; 
    }
}
