/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_sintetizador
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.sintetizador.mundo;

/**
 * Representa una nota del sintetizador.
 */
public class Nota
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre de la nota
     */
    private String nombre;

    /**
     * Valor de la nota.
     */
    private int valor;

    /**
     * Ruta de la imagen del botón de la nota.
     */
    private String rutaImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Crea una nota con los valores dados.<br>
     * <b>post:</b> Se inicializaron los atributos con los valores recibidos.
     * @param pNombre Nombre de la nota. pNombre != null && pNombre != "".
     * @param pValor Valor de la nota.
     * @param pRutaImagen Ruta de la imagen del botón de la nota. pNombre != null && pNombre != "".
     */
    public Nota( String pNombre, int pValor, String pRutaImagen )
    {
        nombre = pNombre;
        valor = pValor;
        rutaImagen = pRutaImagen;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre de la nota.
     * @return Nombre de la nota.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna el valor de la nota.
     * @return Valor de la nota.
     */
    public int darValor( )
    {
        return valor;
    }

    /**
     * Retorna la ruta de la imagen
     * @return Ruta de la imagen.
     */
    public String darRutaImagen( )
    {
        return rutaImagen;
    }
}
