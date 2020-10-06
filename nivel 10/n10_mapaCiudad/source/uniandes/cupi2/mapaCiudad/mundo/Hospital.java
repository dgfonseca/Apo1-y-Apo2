/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Hospital.java,v 1.1 2007/03/22 16:12:59 p-marque Exp $
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
 * Esta es una clase que representa un hospital
 */
public class Hospital extends Edificacion
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante para definir la imagen del hospital.
     */
    public final static String FIGURA_HOSPITAL = "hospital.gif";
    /**
     * Constante para definir el alto del hospital.
     */
    public final static int ALTO_HOSPITAL = 160;
    /**
     * Constante para definir el ancho del hospital.
     */
    public final static int ANCHO_HOSPITAL = 200;
    /**
     * Constante para definir el tipo hospital.
     */
    public final static String TIPO = "HOSPITAL";

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el hospital con los valores especificados
     * @param x Coordenada x del hospital
     * @param y Coordenada y del hospital
     * @param colorFondo color de fondo del hospital
     */
    public Hospital( int x, int y, Color colorFondo )
    {
        super( x, y, ALTO_HOSPITAL, ANCHO_HOSPITAL, colorFondo, FIGURA_HOSPITAL );
    }

    /**
     * Construye un hospital a partir de los datos contenidos en un archivo
     * @param br Es el stream que sirve para leer el archivo
     * @throws IOException Se lanza esta excepción si hay problemas leyendo el archivo
     * @throws FormatoInvalidoExcepcion Se lanza esta excepción si el formato del archivo no es el esperado
     */
    public Hospital( BufferedReader br ) throws IOException, FormatoInvalidoExcepcion
    {
        super( br, FIGURA_HOSPITAL );
        alto = ALTO_HOSPITAL;
        ancho = ANCHO_HOSPITAL;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el tipo del hospital
     * @return El tipo del hospital
     */
    public String darTipo()
    {
        return TIPO; 
    }
}
