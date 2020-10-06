/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: FormatoInvalidoExcepcion.java,v 1.1 2007/03/22 16:12:59 p-marque Exp $ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Todos los derechos reservados 2005 
 *
 * Proyecto Cupi2 
 * Ejercicio: n10_mapaCiudad 
 * Autor: Mario S�nchez - 27/09/2005 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.mapaCiudad.mundo;

/**
 * Esta Excepci�n se lanza si hay un problema con el formato del archivo le�do
 */
public class FormatoInvalidoExcepcion extends Exception
{
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la excepci�n
     * @param linea La l�nea que tiene un formato inv�lido
     */
    public FormatoInvalidoExcepcion( String linea )
    {
        super( "El formato de la l�nea es inv�lido:" + linea );
    }
}
