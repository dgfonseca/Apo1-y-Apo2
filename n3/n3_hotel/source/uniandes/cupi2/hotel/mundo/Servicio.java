package uniandes.cupi2.hotel.mundo;

/**
 * @author SAMSUNG
 * Declarar la clase
 */
public class Servicio {

	/**
	 * @author SAMSUNG
	 *Declarar las enumeraciones
	 */
	public enum Tipo{
		/**
		 * 
		 */
		MINI_BAR,
		
		/**
		 * 
		 */
		INTERNET,
		/**
		 * 
		 */
		SPA,
		/**
		 * 
		 */
		PELICULAS,
	}
	/** declarar atributos
	 * 
	 */
	private int identificador;
	/**
	 * 
	 */
	private Tipo tipo;
	/**
	 * 
	 */
	private double costo;
	/**
	 * 
	 */
	private boolean pagado;

	/**
	 * @param pIdentificador identificador
	 * @param pTipo tipo
	 * @param pCosto costo
	
	 * 
	 */
	public Servicio(int pIdentificador, Tipo pTipo, double pCosto){
		identificador=pIdentificador;
		tipo=pTipo;
		costo=pCosto;
		pagado=false;
		

	}
	/**
	 * @return identificador
	 */
	
	public int darIdentificador(){
		return identificador;
	}

	/**
	 * @return tipo
	 */
	public Tipo darTipo(){
		return tipo;
	}
	/**
	 * @return costo
	 */
	public double darCosto(){
		return costo;
	}
	/**
	 * @return ocupado
	 */
	public boolean estaPagado(){
		
		return pagado;
	}
	/**
	 * 
	 */
	public void pagarServicio(){
		pagado=true;
	}
}
