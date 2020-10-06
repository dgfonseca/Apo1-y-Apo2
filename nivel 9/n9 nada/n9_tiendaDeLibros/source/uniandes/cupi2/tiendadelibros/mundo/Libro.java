package uniandes.cupi2.tiendadelibros.mundo;

import java.util.ArrayList;
import java.util.Date;

public class Libro 
{
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * El c�digo ISBN del libro.
	 */
	private String isbn;

	/**
	 * El t�tulo del libro.
	 */
	private String titulo;

	/**
	 * El precio de venta del libro.
	 */
	private double precioVenta;

	/**
	 * El precio de compra del libro.
	 */
	private double precioCompra;

	/**
	 * Cantidad actual de ejemplares del libro.
	 */
	private int cantidadActual;

	/**
	 * Ruta de la imagen del libro.
	 */
	private String rutaImagen;

	/**
	 * Categoria del libro.	
	 */
	private String categoria;

	/**
	 * Anterior libro en la lista.
	 */
	private Libro anterior;

	/**
	 * Siguiente libro en la lista.
	 */
	private Libro siguiente;

	/**
	 * Colecci�n de transacciones realizadas.
	 */
	private Transaccion primeraTransaccion;

	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------

	/**
	 * Crea un libro con su t�tulo, isbn, autor y precioVenta. <br>
	 * <b>post: </b>El t�tulo, el isbn, el precio de venta, el precio de compra, la categor�a y la ruta de la imagen se inicializaron con los valores dados. <br>
	 * La cantidad actual se inicializ� en cero y la primera transacci�n se inicializ� en null. El libro anterior y siguiente se inicializaron en null.
	 * @param pTitulo T�tulo del libro. pTitulo != null && pTitulo != "".
	 * @param pIsbn C�digo ISBN del libro. pIsbn != null && pIsbn != "".
	 * @param pPrecioVenta precioVenta del libro. pPrecioVenta > 0.
	 * @param pPrecioCompra precioVenta del libro. pPrecioCompra > 0.
	 * @param pCategoria Categor�a a la que pertenece el libro. pCategoria != null && pCategoria != "". pCategoria pertenece a CATEGORIAS.
	 * @param pRutaImagen Ruta de la imagen del libro. pRutaImagen != null && pRutaImagen != "".
	 */
	public Libro( String pTitulo, String pIsbn, double pPrecioVenta, double pPrecioCompra, String pCategoria, String pRutaImagen )
	{
		titulo = pTitulo;
		isbn = pIsbn;
		precioVenta = pPrecioVenta;
		precioCompra = pPrecioCompra;
		rutaImagen = pRutaImagen;
		cantidadActual = 0;
		primeraTransaccion=null;
		anterior=null;
		siguiente=null;
	}

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------
	/**
	 * Retorna la categor�a del libro.
	 * @return La categor�a del libro.
	 */
	public String darCategoria( )
	{
		return categoria;	
	}

	/**
	 * Retorna el anterior libro de la lista.
	 * @return Anterior libro.
	 */
	public Libro darAnterior()
	{
		return anterior;
	}


	/**
	 * Retorna el siguiente libro de la lista.
	 * @return Siguiente libro.
	 */
	public Libro darSiguiente()
	{
		return siguiente;
	}


	/**
	 * Retorna la primera transacci�n del libro.
	 * @return primera transacci�n del libro.
	 */
	public Transaccion darPrimeraTransaccion()
	{
		return primeraTransaccion;
	}

	/**
	 * Retorna el c�digo IBSN del libro.
	 * @return El c�digo ISBN del libro.
	 */
	public String darIsbn( )
	{
		return isbn;
	}

	/**
	 * Retorna el t�tulo del libro.
	 * @return El t�tulo del libro.
	 */
	public String darTitulo( )
	{
		return titulo;
	}

	/**
	 * Retorna el precio de venta del libro.
	 * @return El precio de venta del libro.
	 */
	public double darPrecioVenta( )
	{
		return precioVenta;
	}

	/**
	 * Retorna el precio de compra del libro.
	 * @return El precio de compra del libro.
	 */
	public double darPrecioCompra( )
	{
		return precioCompra;
	}

	/**
	 * Retorna la cantidad actual de ejemplares del libro.
	 * @return La cantidad actual de ejemplares del libro.
	 */
	public int darCantidadActual( )
	{
		return cantidadActual;
	}

	/**
	 * Retorna la ruta de la imagen del libro.
	 * @return La ruta de la imagen del libro.
	 */
	public String darRutaImagen( )
	{
		return rutaImagen;
	}

	/**
	 * Cambia el anterior libro de la lista.
	 * @param pLibro Libro a asignar como anterior.
	 */
	public void cambiarAnterior(Libro pLibro)
	{
		anterior=pLibro;
	}

	/**
	 * Cambia el siguiente libro de la lista.
	 * @param pLibro Libro a asignar como siguiente.
	 */
	public void cambiarSiguiente(Libro pLibro)
	{
		siguiente=pLibro;
	}
	/**
	 * Vende la cantidad de ejemplares que entra por par�metro.
	 * @param pCantidad La cantidad de ejemplares que se van a vender.
	 * @param pFecha La fecha en la que se realiz� la transacci�n. pFecha != "" && pFecha != null.
	 * @return Retorna true en caso de que se pueda vender la cantidad que entra por par�metro. Retorna false en caso de que la cantidad sea mayor a la actual.
	 */
	public boolean vender( int pCantidad, Date pFecha )
	{
		boolean vendido = false;
		if( pCantidad <= cantidadActual )
		{
			cantidadActual -= pCantidad;
			Transaccion nueva = new Transaccion( Transaccion.Tipo.VENTA, pCantidad, pFecha );

			vendido = true;
			agregarTransaccion(nueva);
		}
		return vendido;
	}

	/**
	 * Abastece la cantidad de ejemplares que entra por par�metro.
	 * @param pCantidad La cantidad de ejemplares que se van a agregar a la cantidad actual.
	 * @param pFecha La fecha en la que se realiz� la transacci�n. pFecha != "" && pFecha != null.
	 */
	public void abastecer( int pCantidad, Date pFecha )
	{
		cantidadActual += pCantidad;
		Transaccion nueva = new Transaccion( Transaccion.Tipo.ABASTECIMIENTO, pCantidad, pFecha );
		agregarTransaccion(nueva);
	}

	/**
	 * Agrega una transacci�n al final de la lista de transacciones.
	 * @param pTransaccion transaccion a agregar.
	 */
	private void agregarTransaccion( Transaccion pTransaccion )
	{
		if(primeraTransaccion==null)
		{
			primeraTransaccion=pTransaccion;
		}
		else
		{
			Transaccion t =localizarUltimo();
			t.insertarDespues(pTransaccion);
		}
	}
	/**
	 * Retorna la colecci�n de transacciones.
	 * @return La colecci�n de transacciones.
	 */
	public ArrayList<Transaccion> darTransacciones( )
	{

		ArrayList<Transaccion> transaccion = new ArrayList<Transaccion>( );
		for( Transaccion p = primeraTransaccion; p != null; p = p.darSiguiente() ){
			transaccion.add( p );
		}
		return transaccion;
	}


	/**
	 * Desconecta el siguiente libro en la lista.
	 */
	public void desconectarSiguiente()
	{
		siguiente=siguiente.siguiente;	
	}


	/**
	 * Retorna la representaci�n en cadena de caracteres un objeto Libro.
	 * @return La representaci�n en cadena de caracteres del objeto Libro.
	 */
	public String toString( )
	{
		String representacion = titulo + " (" + isbn + ")" + "-" + "categoria";
		return representacion;
	}
	/**
	 * Compara dos libros por su t�tulo. Si los t�tulos son iguales los compara por isbn.
	 * @param pLibro Libro con el cual se desea comparar. pLibro != null.
	 * @return 0 si los dos libros son iguales, 1 si el libro actual es mayor, -1 si es menor.
	 */
	public int compararPorTitulo( Libro pLibro )
	{
		int comparacion = titulo.compareTo( pLibro.darTitulo( ) );
		if( comparacion == 0 )
		{
			comparacion = isbn.compareTo( pLibro.darIsbn( ) );
		}
		else if( comparacion > 0 )
		{
			comparacion = 1;
		}
		else
		{
			comparacion = -1;
		}
		return comparacion;
	}

	/**
	 * Localiza la ultima transaccion en la lista
	 * @return la ultima transaccion
	 */
	public Transaccion localizarUltimo()
	{
		Transaccion actual=primeraTransaccion;
		if(actual!=null)
		{
			while(actual.darSiguiente()!=null){
				actual=actual.darSiguiente();
			}

		}
		return actual;
	}


}
