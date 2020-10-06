package uniandes.cupi2.explorador.mundo;

/**
 * Esta clase representa una casilla del explorador de cuevas.
 */
public class Casilla {


	/**
	 * Enumeradores para el estado y el valor de la casilla.
	 */
	

	// 
	// Constantes
	// 


    public static final String NADA = "N";
    
    public static final String OBSTACULO = "O";
    
    public static final String JUGADOR = "J";
    
    public static final String BOMBA = "B";
    
    public static final String TESORO = "T";

    
	// 
	// Atributos
	// 

private String estados;
private String ruta;

	// 
	// Constructores
	// 


	
	public Casilla( String estadoInicial )
	{
		estados=estadoInicial;
		
		
	}
	//
	// Métodos
	// 

	/**
	 * Retorna el valor de la casilla.
	 * @return El valor de la casilla.
	 */
	public String darEstado(){
		
		return estados;
		
	}	
	public void actualizarEstado(String nuevoEstado){
		
		estados=nuevoEstado;
		

	
	
	
	
	
	}
}