/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: FormatoInvalidoExcepcion.java 514 2006-10-23 04:50:08Z da-romer $ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Todos los derechos reservados 2005 
 *
 * Proyecto Cupi2 
 * Ejercicio: n10_partitura 
 * Autor: Mario S�nchez - 27/09/2005 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.partitura.mundo;

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
