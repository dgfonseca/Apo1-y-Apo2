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
 * Efecto reproducible del sintetizador.
 */
public class Efecto
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del efecto.
     */
    private String nombre;

    /**
     * Descripción del efecto.
     */
    private String descripcion;

    /**
     * Calificación del efecto.
     */
    private double calificacion;

    /**
     * Índice donde se encuentra el efecto en la librería.
     */
    private int indiceEfecto;
    
    /**
     * Ruta de la imagen que representa el efecto en el banner.
     */
    private String rutaImagen;

    /**
     * Si el efecto ha sido marcado como parte del grupo Favoritos.
     */
    private boolean favorito;

    /**
     * Si el efecto ha sido marcado como parte del grupo Fantasía.
     */
    private boolean fantasia;

    /**
     * Si el efecto ha sido marcado como parte del grupo Divertidos.
     */
    private boolean divertido;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el efecto con su nombre, descripción, calificación y ruta.<br>
     * <b> post: </b> Se inicializaron los atributos del efecto con la información recibida.<br> 
     *                Se inicializaron todos los grupos en false. <br>
     * @param pNombre nombre del efecto.
     * @param pDescripcion Descripción del efecto.
     * @param pCalificacion Calificación del efecto.
     * @param pIndice Índice del efecto.
     * @param pRuta Ruta de la imagen.
     */
    public Efecto( String pNombre, String pDescripcion, double pCalificacion, int pIndice, String pRuta )
    {
        nombre = pNombre;
        descripcion = pDescripcion;
        calificacion = pCalificacion;
        indiceEfecto = pIndice;
        rutaImagen = pRuta;

        favorito = false;
        fantasia = false;
        divertido = false;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del efecto.
     * @return Nombre del efecto.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la descripción del efecto.
     * @return Descripción del efecto.
     */
    public String darDescripcion( )
    {
        return descripcion;
    }

    /**
     * Retorna la calificación del efecto.
     * @return La calificación del efecto.
     */
    public double darCalificacion( )
    {
        return calificacion;
    }

    /**
     * Retorna el índice del efecto.
     * @return El índice del efecto.
     */
    public int darIndice( )
    {
        return indiceEfecto;
    }
    
    /**
     * Retorna la ruta de la imagen del efecto.
     * @return La ruta de la imagen del efecto.
     */
    public String darRutaImagen( )
    {
        return rutaImagen;
    }

    /**
     * Indica si el efecto ha sido marcado como parte del grupo Favoritos.
     * @return Si el efecto es un favorito.
     */
    public boolean esFavorito( )
    {
        return favorito;
    }

    /**
     * Indica si el efecto ha sido marcado como parte del grupo Fantasía.
     * @return Si el efecto es de fantasía.
     */
    public boolean esFantasia( )
    {
        return fantasia;
    }

    /**
     * Indica si el efecto ha sido marcado como parte del grupo Divertidos.
     * @return Si el efecto es divertido.
     */
    public boolean esDivertido( )
    {
        return divertido;
    }

    /**
     * Guarda los grupos a los que pertenece el efecto.
     * @param pFavoritos Indica si favoritos fue seleccionado.
     * @param pFantasia Indica si fantasía fue seleccionado.
     * @param pDivertidos Indica si divertidos fue seleccionado.
     */
    public void guardar( boolean pFavoritos, boolean pFantasia, boolean pDivertidos )
    {
        favorito = pFavoritos;
        fantasia = pFantasia;
        divertido = pDivertidos;
    }
}
