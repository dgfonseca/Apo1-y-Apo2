/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n6_buscaminas
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.buscaminas.mundo;

/**
 * Esta clase representa una casilla del campo minado.
 */
public class Casilla
{

    // -----------------------------------------------------------------
    // Enumeraciones
    // -----------------------------------------------------------------
    
    /**
     * Enumeradores para los tipos de estado y valor de la casilla.
     */
    public enum Tipo
    {
        /**
         * Indica que la casilla está vacía.
         */
        VACIA,
        
        /**
         * Indica que la casilla tiene una bomba.
         */
        MINADA,
        
        /**
         * Indica que la casilla fue marcada por el usuario.
         */
        MARCADA,
        
        /**
         * Indica que la casilla no ha sido ni destapada ni marcada por el usuario.
         */
        TAPADA,
        
        /**
         * Indica que la casilla ya fue destapada por el usuario.
         */
        DESTAPADA,
        
        /**
         * Indica que la casilla tiene una bomba que fue encontrada por el usuario.
         */
        MARCADA_EQUIVOCADA,
        
        /**
         * Indica que la casilla tiene una bomba que no ha sido estallada.
         */
        BOMBA_SIN_ESTALLAR,
        
        /**
         * Indica que la casilla tiene una bomba que ha sido estallada.
         */
        BOMBA_ESTALLADA,
        
        /**
         * Indica que la casilla no tiene minas cerca.
         */
        CERCA_0,
        
        /**
         * Indica que la casilla tiene 1 mina cerca.
         */
        CERCA_1,
        
        /**
         * Indica que la casilla tiene 2 minas cerca.
         */
        CERCA_2,
        
        /**
         * Indica que la casilla tiene 3 minas cerca.
         */
        CERCA_3,
        
        /**
         * Indica que la casilla tiene 4 minas cerca.
         */
        CERCA_4,
        
        /**
         * Indica que la casilla tiene 5 minas cerca.
         */
        CERCA_5,
        
        /**
         * Indica que la casilla tiene 6 minas cerca.
         */
        CERCA_6,
        
        /**
         * Indica que la casilla tiene 7 minas cerca.
         */
        CERCA_7,
        
        /**
         * Indica que la casilla tiene 8 minas cerca.
         */
        CERCA_8
    }
    
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    
    /**
     * Imagen para mostrar las casillas tapadas.
     */
    private static final String TAPADA_IMAGEN = "./data/tapada.png";    

    /**
     * Imagen para mostrar en las casillas marcadas.
     */
    private static final String MARCADA_IMAGEN = "./data/marcada.png";    

    /**
     * Imagen para mostrar en las casillas marcadas equivocadas.
     */
    private static final String MARCADA_EQUIVOCADA_IMAGEN = "./data/marcadaEquivocada.png";
    
    /**
     * Imagen para mostrar en casillas con bombas no marcadas.
     */
    private static final String BOMBA_IMAGEN = "./data/bomba.png";    

    /**
     * Imagen para mostrar en casillas con bombas estalladas.
     */
    private static final String BOMBA_ESTALLADA_IMAGEN = "./data/bombaEstallada.png";    

    /**
     * Imagen que indica que no tiene minas cerca.
     */
    private static final String CERCA_0_IMAGEN = "./data/cerca-00.png";    

    /**
     * Imagen que indica que tiene 1 mina cerca.
     */
    private static final String CERCA_1_IMAGEN = "./data/cerca-01.png";

    /**
     * Imagen que indica que tiene 2 minas cerca.
     */
    private static final String CERCA_2_IMAGEN = "./data/cerca-02.png";    

    /**
     * Imagen que indica que tiene 3 minas cerca.
     */
    private static final String CERCA_3_IMAGEN = "./data/cerca-03.png";    

    /**
     * Imagen que indica que tiene 4 minas cerca.
     */
    private static final String CERCA_4_IMAGEN = "./data/cerca-04.png";

    /**
     * Imagen que indica que tiene5 minas cerca.
     */
    private static final String CERCA_5_IMAGEN = "./data/cerca-05.png";

    /**
     * Imagen que indica que tiene 6 minas cerca.
     */
    private static final String CERCA_6_IMAGEN = "./data/cerca-06.png";

    /**
     * Imagen que indica que tiene 7 minas cerca.
     */
    private static final String CERCA_7_IMAGEN = "./data/cerca-07.png";

    /**
     * Imagen que indica que tiene 8 minas cerca.
     */
    private static final String CERCA_8_IMAGEN = "./data/cerca-08.png";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es el valor de la casilla.
     */
    private Tipo valor;

    /**
     * Es el estado de la casilla.
     */
    private Tipo estado;

    /**
     * Posición horizontal de la casilla.
     */
    private int fila;

    /**
     * Posición vertical de la casilla.
     */
    private int columna;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva casilla con un estado y la posición horizontal y vertical en el campo minado.
     * @param pValor El valor almacenado en la casilla. Debe ser uno de los siguientes {VACIA, MINADA}
     * @param pEstado Es el estado de la casilla. Debe ser uno de los siguientes. {MARCADA, TAPADA, DESTAPADA, MARCADA_EQUIVOCADA, BOMBA_ESTALLADA} <br>
     *        Debe ser uno de los siguientes {CERCA_0, CERCA_1, CERCA_2, CERCA_3, CERCA_4, CERCA_5, CERCA_6, CERCA_7, CERCA_8} corresponde al numero <br>
     *        de minas alrededor de una casilla destapada.
     * @param pFila Número de fila de la casilla.
     * @param pColumna Número de columna de la casilla.
     * 
     */
    public Casilla( Tipo pValor, Tipo pEstado, int pFila, int pColumna )
    {
        valor = pValor;
        estado = pEstado;
        fila = pFila;
        columna = pColumna;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el estado de la casilla.
     * @return El estado de la casilla.
     */
    public Tipo darEstado( )
    {
        return estado;
    }

    /**
     * Retorna el valor de la casilla.
     * @return El valor de la casilla.
     */
    public Tipo darValor( )
    {
        return valor;
    }

    /**
     * Devuelve el número de fila de la casilla.
     * @return La fila de la casilla.
     */
    public int darFila( )
    {
        return fila;
    }

    /**
     * Devuelve el número de columna de la casilla.
     * @return La columna de la casilla.
     */
    public int darColumna( )
    {
        return columna;
    }

    /**
     * Modifica el estado de una casilla.
     * @param pEstado Estado de la casilla.
     */
    public void cambiarEstado( Tipo pEstado )
    {
        switch( pEstado )
        {
            case MARCADA:
                estado = Tipo.MARCADA;
                break;
            case DESTAPADA:
                estado = Tipo.DESTAPADA;
                break;
            case TAPADA:
                estado = Tipo.TAPADA;
                break;
        }
    }

    /**
     * Modifica el valor de una casilla.
     * @param pValor Valor de la casilla.
     */
    public void cambiarValor( Tipo pValor )
    {
        switch( pValor )
        {
            case VACIA:
                valor = Tipo.VACIA;
                break;
            case MINADA:
                valor = Tipo.MINADA;
                break;
        }
    }

    /**
     * Retorna la imagen que debe mostrarse en la casilla según el Tipo.
     * @return La ruta hasta la imagen que debe mostrarse. Si no se debe mostrar ninguna imagen entonces retorna null.
     */
    public String darImagen( )
    {
        String strimagen = null;

        switch( estado )
        {
            case TAPADA:
                strimagen = TAPADA_IMAGEN;
                break;
            case BOMBA_SIN_ESTALLAR:
                strimagen = BOMBA_IMAGEN;
                break;
            case BOMBA_ESTALLADA:
                strimagen = BOMBA_ESTALLADA_IMAGEN;
                break;
            case MARCADA:
                strimagen = MARCADA_IMAGEN;
                break;
            case MARCADA_EQUIVOCADA:
                strimagen = MARCADA_EQUIVOCADA_IMAGEN;
                break;
            case CERCA_0:
                strimagen = Casilla.CERCA_0_IMAGEN;
                break;
            case CERCA_1:
                strimagen = Casilla.CERCA_1_IMAGEN;
                break;
            case CERCA_2:
                strimagen = Casilla.CERCA_2_IMAGEN;
                break;
            case CERCA_3:
                strimagen = Casilla.CERCA_3_IMAGEN;
                break;
            case CERCA_4:
                strimagen = Casilla.CERCA_4_IMAGEN;
                break;
            case CERCA_5:
                strimagen = Casilla.CERCA_5_IMAGEN;
                break;
            case CERCA_6:
                strimagen = Casilla.CERCA_6_IMAGEN;
                break;
            case CERCA_7:
                strimagen = Casilla.CERCA_7_IMAGEN;
                break;
            case CERCA_8:
                strimagen = Casilla.CERCA_8_IMAGEN;
        }

        return strimagen;
    }
}
