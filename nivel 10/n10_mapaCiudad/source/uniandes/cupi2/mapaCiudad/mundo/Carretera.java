/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Carretera.java,v 1.1 2007/03/22 16:12:59 p-marque Exp $
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
 * Esta es una clase abstracta que representa a una carretera
 */
public abstract class Carretera extends Construccion
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante para definir el alto de la carretera.
     */
    public static final int ALTO_CARRETERA = 40;
    /**
     * Constante para definir el ancho de la carretera.
     */
    public static final int ANCHO_CARRETERA = 40;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la carretera con los valores especificados
     * @param x Coordenada x de la carretera
     * @param y Coordenada y de la carretera
     * @param colorFondo color de fondo de la carretera
     */
    public Carretera( int x, int y, Color colorFondo )
    {
        super( x, y, ALTO_CARRETERA, ANCHO_CARRETERA, colorFondo );
    }

    /**
     * Construye una carretera a partir de los datos contenidos en un archivo
     * @param br Es el stream que sirve para leer el archivo
     * @throws IOException Se lanza esta excepción si hay problemas leyendo el archivo
     * @throws FormatoInvalidoExcepcion Se lanza esta excepción si el formato del archivo no es el esperado
     */
    public Carretera( BufferedReader br ) throws IOException, FormatoInvalidoExcepcion
    {
        super( br );
        alto = ALTO_CARRETERA;
        ancho = ANCHO_CARRETERA;
    }
}
