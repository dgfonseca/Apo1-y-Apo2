/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogot� - Colombia)
 * Departamento de  Ingenier�a  de  Sistemas    y   Computaci�n
 * Licenciado   bajo    el  esquema Academic Free License versi�n 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_hotel
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.hotel.mundo;

/**
 * Representa el hu�sped principal dentro de una habitaci�n.
 */
public class Huesped
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del hu�sped.
     */
    // TODO HECHO Parte 1 Punto A: Declarar el atributo nombre seg�n el modelo del mundo.
private String nombre;
    /**
     * C�dula del hu�sped
     */
    // TODO hecho Parte 1 Punto B: Declarar el atributo cedula seg�n el modelo del mundo.
private String cedula;
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
/**
 * Edad del Huesped
 */
private int edad;

    /**
     * Crea un hu�sped, usando la informaci�n recibida por par�metro.<br>
     * <b>post: </b> Se inicializaron los atributos pNombre y pCedula con los valores recibidos por par�metro.<br>
     * @param pNombre Nombre del hu�sped. pNombre != null.
     * @param pCedula C�dula del hu�sped. pCedula != null.
     * @param pEdad Edad del huesped. pEdad!=null.
     */
    public Huesped( String pNombre, String pCedula, int pEdad )
    {
    	cedula=pCedula;
    	nombre=pNombre;
    	edad=pEdad;
        // TODO HECHO Parte 1 Punto C: Completar el m�todo constructor de la clase.
        // Inicializar los nuevos atributos con la informaci�n recibida por par�metro.
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del hu�sped.
     * @return Nombre del hu�sped.
     */
    public String darNombre( )
    {
    	return nombre;
        // TODO HECHO Parte 1 Punto D: Completar el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Retorna la c�dula del hu�sped.
     * @return C�dula del hu�sped.
     */
    public String darCedula( )
    {
    	return cedula;
        // TODO HECHO Parte 1 Punto E: Completar el m�todo seg�n la documentaci�n dada.
    }
    /**
     * Retorna edad del Hu�sped.
     * @return edad del huesped.
     */
    public int darEdad(){
    return edad;
    }
    /**
     * retorna el nombre del huesped
     * @return nombre del huesped
     */
    public String toString(){
    	return nombre;
    }

}
