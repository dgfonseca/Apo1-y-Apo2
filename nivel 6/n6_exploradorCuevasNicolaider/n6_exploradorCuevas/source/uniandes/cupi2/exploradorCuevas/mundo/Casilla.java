package uniandes.cupi2.exploradorCuevas.mundo;

/**
 * Es la clase que representa a una casilla
 */
public class Casilla {
	
	//-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

	public static final String NADA  = "N";
	public static final String JUGADOR = "J";
	public static final String OBSTACULO   = "O";
	public static final String TESORO = "T";
	public static final String BOMBA = "B";

	
	 //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Es el estado del momento de la casilla
     */
	private String estadoActual;
	
	//-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Construye una nueva instancia de una casilla
     * @param estadoInicial es el estado inicial con el que se iniciará la casilla. estadoInicial!= null
     */
	public Casilla (String estadoInicial)
	{
		estadoActual= estadoInicial;
	}
	
	//-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Retorna el estado actual de la casilla
     * @return estadoActual
     */
	public String darEstado()
	{
		return estadoActual;
	}
	/**
     * Actualiza el estado de la casilla con el que se ingresa como parámetro
     * @param nuevoEstado es el nuevo estado de la casilla. nuevoEstado!= null
     */
	public void actualizarEstado(String nuevoEstado)
	{
		estadoActual= nuevoEstado;
	}
}
