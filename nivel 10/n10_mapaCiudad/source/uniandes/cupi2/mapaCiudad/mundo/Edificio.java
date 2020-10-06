/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Edificio.java,v 1.1 2007/03/22 16:12:59 p-marque Exp $
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
 * Esta es una clase que representa a un edificio
 */
public class Edificio extends Edificacion
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante para definir la figura del edificio.
     */
    public final static String FIGURA_EDIFICIO = "edificio.gif";
    /**
     * Constante para definir el alto del edificio.
     */
    public final static int ALTO_EDIFICIO = 160;
    /**
     * Constante para definir el ancho del edificio.
     */
    public final static int ANCHO_EDIFICIO = 200;
    /**
     * Constante para definir el tipo Edificio.
     */
    public final static String TIPO = "EDIFICIO";

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el edificio con los valores especificados
     * @param x Coordenada x del edificio
     * @param y Coordenada y del edificio
     * @param colorFondo color de fondo del edificio
     */
    public Edificio( int x, int y, Color colorFondo )
    {
        super( x, y, ALTO_EDIFICIO, ANCHO_EDIFICIO, colorFondo, FIGURA_EDIFICIO );
    }

    /**
     * Construye un edificio a partir de los datos contenidos en un archivo
     * @param br Es el stream que sirve para leer el archivo
     * @throws IOException Se lanza esta excepción si hay problemas leyendo el archivo
     * @throws FormatoInvalidoExcepcion Se lanza esta excepción si el formato del archivo no es el esperado
     */
    public Edificio( BufferedReader br ) throws IOException, FormatoInvalidoExcepcion
    {
        super( br, FIGURA_EDIFICIO );
        alto = ALTO_EDIFICIO;
        ancho = ANCHO_EDIFICIO;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------       
    /**
     * Retorna el tipo del edificio
     * @return El tipo del edificio
     */
    public String darTipo()
    {
        return TIPO; 
    }
}
