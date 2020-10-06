/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Casa.java,v 1.1 2007/03/22 16:12:59 p-marque Exp $
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
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Esta es una clase que representa a una casa
 */
public class Casa extends Edificacion
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante para la casa figura.
     */
    public final static String FIGURA_CASA = "casa.gif";
    /**
     * Constante para definir el alto de la casa.
     */
    public final static int ALTO_CASA = 120;
    /**
     * Constante para definir el ancho de la casa.
     */
    public final static int ANCHO_CASA = 160;
    /**
     * Constante para definir el tipo Casa.
     */
    public final static String TIPO = "CASA";

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la casa con los valores especificados
     * @param x Coordenada x de la casa
     * @param y Coordenada y de la casa
     * @param colorFondo color de fondo de la casa
     */
    public Casa( int x, int y, Color colorFondo )
    {
        super( x, y, ALTO_CASA, ANCHO_CASA, colorFondo, FIGURA_CASA );

    }

    /**
     * Construye una casa a partir de los datos contenidos en un archivo
     * @param br Es el stream que sirve para leer el archivo
     * @throws IOException Se lanza esta excepción si hay problemas leyendo el archivo
     * @throws FormatoInvalidoExcepcion Se lanza esta excepción si el formato del archivo no es el esperado
     */
    public Casa( BufferedReader br ) throws IOException, FormatoInvalidoExcepcion
    {
        super( br, FIGURA_CASA );
        alto = ALTO_CASA;
        ancho = ANCHO_CASA;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------    
    /**
     * Retorna el tipo de la casa
     * @return El tipo de la casa
     */
    public String darTipo()
    {
        return TIPO; 
    }
}
