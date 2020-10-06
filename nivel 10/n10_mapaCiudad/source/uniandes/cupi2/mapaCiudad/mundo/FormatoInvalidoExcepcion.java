/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: FormatoInvalidoExcepcion.java,v 1.1 2007/03/22 16:12:59 p-marque Exp $ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Todos los derechos reservados 2005 
 *
 * Proyecto Cupi2 
 * Ejercicio: n10_mapaCiudad 
 * Autor: Mario Sánchez - 27/09/2005 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.mapaCiudad.mundo;

/**
 * Esta Excepción se lanza si hay un problema con el formato del archivo leído
 */
public class FormatoInvalidoExcepcion extends Exception
{
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la excepción
     * @param linea La línea que tiene un formato inválido
     */
    public FormatoInvalidoExcepcion( String linea )
    {
        super( "El formato de la línea es inválido:" + linea );
    }
}
