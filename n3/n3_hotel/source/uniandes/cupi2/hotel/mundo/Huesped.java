/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogotá - Colombia)
 * Departamento de  Ingeniería  de  Sistemas    y   Computación
 * Licenciado   bajo    el  esquema Academic Free License versión 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_hotel
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.hotel.mundo;

/**
 * Representa el huésped principal dentro de una habitación.
 */
public class Huesped
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del huésped.
     */
    // TODO HECHO Parte 1 Punto A: Declarar el atributo nombre según el modelo del mundo.
private String nombre;
    /**
     * Cédula del huésped
     */
    // TODO hecho Parte 1 Punto B: Declarar el atributo cedula según el modelo del mundo.
private String cedula;
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
/**
 * Edad del Huesped
 */
private int edad;

    /**
     * Crea un huésped, usando la información recibida por parámetro.<br>
     * <b>post: </b> Se inicializaron los atributos pNombre y pCedula con los valores recibidos por parámetro.<br>
     * @param pNombre Nombre del huésped. pNombre != null.
     * @param pCedula Cédula del huésped. pCedula != null.
     * @param pEdad Edad del huesped. pEdad!=null.
     */
    public Huesped( String pNombre, String pCedula, int pEdad )
    {
    	cedula=pCedula;
    	nombre=pNombre;
    	edad=pEdad;
        // TODO HECHO Parte 1 Punto C: Completar el método constructor de la clase.
        // Inicializar los nuevos atributos con la información recibida por parámetro.
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del huésped.
     * @return Nombre del huésped.
     */
    public String darNombre( )
    {
    	return nombre;
        // TODO HECHO Parte 1 Punto D: Completar el método según la documentación dada.
    }

    /**
     * Retorna la cédula del huésped.
     * @return Cédula del huésped.
     */
    public String darCedula( )
    {
    	return cedula;
        // TODO HECHO Parte 1 Punto E: Completar el método según la documentación dada.
    }
    /**
     * Retorna edad del Huésped.
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
