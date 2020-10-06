/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: EstacionPolicia.java,v 1.1 2007/03/22 16:12:59 p-marque Exp $
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

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Esta es una clase que representa una estaci�n de polic�a
 */
public class EstacionPolicia extends Edificacion
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante para definir la imagen de la estaci�n de polic�a.
     */
    public final static String FIGURA_ESTACION_POLICIA = "estacionPolicia.gif";
    /**
     * Constante para definir el alto de la estaci�n de polic�a.
     */
    public final static int ALTO_ESTACION_POLICIA = 160;
    /**
     * Constante para definir el ancho de la estaci�n de polic�a.
     */
    public final static int ANCHO_ESTACION_POLICIA = 200;
    /**
     * Constante para definir el tipo estaci�n de polic�a.
     */
    public final static String TIPO = "ESTACION_POLICIA";


    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la estaci�n de polic�a con los valores especificados
     * @param x Coordenada x de la estaci�n
     * @param y Coordenada y de la estaci�n
     * @param colorFondo color de fondo de la estaci�n
     */
    public EstacionPolicia( int x, int y, Color colorFondo )
    {
        super( x, y, ALTO_ESTACION_POLICIA, ANCHO_ESTACION_POLICIA, colorFondo, FIGURA_ESTACION_POLICIA );
    }

    /**
     * Construye una estaci�n a partir de los datos contenidos en un archivo
     * @param br Es el stream que sirve para leer el archivo
     * @throws IOException Se lanza esta excepci�n si hay problemas leyendo el archivo
     * @throws FormatoInvalidoExcepcion Se lanza esta excepci�n si el formato del archivo no es el esperado
     */
    public EstacionPolicia( BufferedReader br ) throws IOException, FormatoInvalidoExcepcion
    {
        super( br, FIGURA_ESTACION_POLICIA );
        alto = ALTO_ESTACION_POLICIA;
        ancho = ANCHO_ESTACION_POLICIA;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el tipo de la estaci�n
     * @return El tipo de la estaci�n
     */
    public String darTipo()
    {
        return TIPO; 
    }
}
