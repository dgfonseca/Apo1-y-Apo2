package uniandes.cupi2.tiendadelibros.mundo;

import java.util.Date;

public class Transaccion 
{
	// -----------------------------------------------------------------
	// Enumeraciones
	// -----------------------------------------------------------------

	/**
	 * Enumeradores para los tipos de transacciones posibles.
	 */
	public enum Tipo {
		/**
		 * Representa el tipo venta
		 */
		VENTA,
		/**
		 * Representa el tipo abastecimiento
		 */
		ABASTECIMIENTO
	}

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Tipo de la transacción.
	 */
	private Tipo tipo;

	/**
	 * Cantidad de ejemplares utilizados en la transacción.
	 */
	private int cantidad;

	/**
	 * Fecha en que se realizó la transacción.
	 */
	private Date fecha;

	/**
	 * El siguiente en la lista de transacciones
	 */
	private Transaccion siguiente;

	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------

	/**
	 * Crea una transacción con el tipo, cantidad de ejemplares y la fecha en que se realizó.
	 * @param pTipo Tipo de la transacción. pTipo != null.
	 * @param pCantidad Cantidad de ejemplares utilizados en la transacción. pCantidad > 0.
	 * @param pFecha Fecha en que se realizó la transacción. pFecha != null && pFecha != "".
	 */
	public Transaccion( Tipo pTipo, int pCantidad, Date pFecha )
	{
		tipo = pTipo;
		cantidad = pCantidad;
		fecha = pFecha;
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Retorna el tipo de la transacción.
	 * @return El tipo de la transacción.
	 */
	public Tipo darTipo( )
	{
		return tipo;
	}

	/**
	 * Retorna la cantidad de ejemplares utilizados en la transacción.
	 * @return La cantidad de ejemplares utilizados en la transacción.
	 */
	public int darCantidad( )
	{
		return cantidad;
	}

	/**
	 * Retorna la fecha de la transacción.
	 * @return La fecha de la transacción.
	 */
	public Date darFecha( )
	{
		return fecha;
	}
	/**
	 * Retorna la siguiente transacción de la lista.
	 * @return Siguiente transacción.
	 */
	public Transaccion darSiguiente()
	{
		return siguiente;

	}

	/**
	 * Cambia la siguiente transacción de la lista.
	 * @param pTransaccion Transacción a asignar como siguiente.
	 */
	public void cambiarSiguiente(Transaccion pTransaccion)
	{
		siguiente=pTransaccion;
	}

	public void insertarDespues( Transaccion t )
	{
		t.siguiente = siguiente;
		siguiente = t;
	}

	/**
	 * Retorna la representación en cadena de caracteres un objeto Transaccion.
	 * @return La representación en cadena de caracteres del objeto Transaccion.
	 */
	public String toString( )
	{
		String representacion = fecha + " - " + tipo + ": " + cantidad;
		return representacion;
	}

}
