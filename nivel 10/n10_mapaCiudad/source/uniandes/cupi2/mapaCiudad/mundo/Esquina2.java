/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Esquina2.java,v 1.1 2007/03/22 16:12:59 p-marque Exp $
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
 * Esta es una clase que representa una esquina
 */
public class Esquina2 extends Carretera
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------    
    /**
     * Constante para definir el tipo Esquina 2.
     */
    public final static String TIPO = "ESQUINA2";
    
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la esquina con los valores especificados
     * @param x Coordenada x de la esquina
     * @param y Coordenada y de la esquina
     * @param colorFondo color de fondo de la esquina
     */
    public Esquina2( int x, int y, Color colorFondo )
    {
        super( x, y, colorFondo );
    }

    /**
     * Construye una esquina a partir de los datos contenidos en un archivo
     * @param br Es el stream que sirve para leer el archivo
     * @throws IOException Se lanza esta excepción si hay problemas leyendo el archivo
     * @throws FormatoInvalidoExcepcion Se lanza esta excepción si el formato del archivo no es el esperado
     */
    public Esquina2( BufferedReader br ) throws IOException, FormatoInvalidoExcepcion
    {
        super( br );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Sirve para pintar la esquina
     * @param g La superficie donde se debe pintar
     */
    public void pintar( Graphics2D g )
    {
        // Pintar el fondo
        g.setColor( colorFondo );
        g.fillRect( x, y, ancho, alto );

        // Pintar la parte gris de la esquina- Parte sur-norte
        g.setColor( Color.GRAY );
        g.fillRect( x + MARGEN_CONSTRUCCION / 2, y + MARGEN_CONSTRUCCION / 2, ancho - MARGEN_CONSTRUCCION, alto - MARGEN_CONSTRUCCION / 2 );

        // Pintar la parte gris de la esquina- Parte oeste-este
        g.fillRect( x, y + MARGEN_CONSTRUCCION / 2, ancho - MARGEN_CONSTRUCCION / 2, alto - MARGEN_CONSTRUCCION );

        // Pintar los bordes de la esquina-Parte sur-norte
        // 1.0;1;1;1.0;10.0 0.0;0.0
        g.setColor( Color.BLACK );
        BasicStroke tipoLinea = new BasicStroke( 3 );
        g.setStroke( tipoLinea );
        g.drawLine( x + MARGEN_CONSTRUCCION / 2, y + alto - MARGEN_CONSTRUCCION / 2, x + MARGEN_CONSTRUCCION / 2, y + alto - 2 );
        g.drawLine( x - MARGEN_CONSTRUCCION / 2 + ancho - 2, y + 1 + MARGEN_CONSTRUCCION / 2, x - MARGEN_CONSTRUCCION / 2 + ancho - 2, y + alto - 2 );

        // Pintar los bordes de la esquina-Parte oeste-este
        g.drawLine( x + 1, y + MARGEN_CONSTRUCCION / 2, x + ancho - MARGEN_CONSTRUCCION / 2 - 2, y + MARGEN_CONSTRUCCION / 2 );
        g.drawLine( x + 1, y - MARGEN_CONSTRUCCION / 2 + alto - 2, x + MARGEN_CONSTRUCCION / 2, y - MARGEN_CONSTRUCCION / 2 + alto - 2 );

        // Pintar las lineas blancas
        g.setColor( Color.WHITE );
        g.setStroke( tipoLinea );
        g.drawLine( x + ( ancho / 2 ) - 1, y + 23, x + ( ancho / 2 ) - 1, y + 34 );
        g.drawLine( x + 3, y + ( alto / 2 ) - 1, x + 14, y + ( alto / 2 ) - 1 );
        // Pintar el texto
        pintarTexto( g );
    }
    
    /**
     * Retorna el tipo de la esquina
     * @return El tipo de la esquina
     */
    public String darTipo()
    {
        return TIPO; 
    }
}
