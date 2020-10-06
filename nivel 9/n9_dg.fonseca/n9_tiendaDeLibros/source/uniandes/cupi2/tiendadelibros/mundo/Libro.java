package uniandes.cupi2.tiendadelibros.mundo;

import java.util.ArrayList;
import java.util.Date;

public class Libro 
{
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * El código ISBN del libro.
	 */
	private String isbn;

	/**
	 * El título del libro.
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
	 * Colección de transacciones realizadas.
	 */
	private Transaccion primeraTransaccion;

	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------

	/**
	 * Crea un libro con su título, isbn, autor y precioVenta. <br>
	 * <b>post: </b>El título, el isbn, el precio de venta, el precio de compra, la categoría y la ruta de la imagen se inicializaron con los valores dados. <br>
	 * La cantidad actual se inicializó en cero y la primera transacción se inicializó en null. El libro anterior y siguiente se inicializaron en null.
	 * @param pTitulo Título del libro. pTitulo != null && pTitulo != "".
	 * @param pIsbn Código ISBN del libro. pIsbn != null && pIsbn != "".
	 * @param pPrecioVenta precioVenta del libro. pPrecioVenta > 0.
	 * @param pPrecioCompra precioVenta del libro. pPrecioCompra > 0.
	 * @param pCategoria Categoría a la que pertenece el libro. pCategoria != null && pCategoria != "". pCategoria pertenece a CATEGORIAS.
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
	// Métodos
	// -----------------------------------------------------------------
	/**
	 * Retorna la categoría del libro.
	 * @return La categoría del libro.
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
	 * Retorna la primera transacción del libro.
	 * @return primera transacción del libro.
	 */
	public Transaccion darPrimeraTransaccion()
	{
		return primeraTransaccion;
	}

	/**
	 * Retorna el código IBSN del libro.
	 * @return El código ISBN del libro.
	 */
	public String darIsbn( )
	{
		return isbn;
	}

	/**
	 * Retorna el título del libro.
	 * @return El título del libro.
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
	 * Vende la cantidad de ejemplares que entra por parámetro.
	 * @param pCantidad La cantidad de ejemplares que se van a vender.
	 * @param pFecha La fecha en la que se realizó la transacción. pFecha != "" && pFecha != null.
	 * @return Retorna true en caso de que se pueda vender la cantidad que entra por parámetro. Retorna false en caso de que la cantidad sea mayor a la actual.
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
	 * Abastece la cantidad de ejemplares que entra por parámetro.
	 * @param pCantidad La cantidad de ejemplares que se van a agregar a la cantidad actual.
	 * @param pFecha La fecha en la que se realizó la transacción. pFecha != "" && pFecha != null.
	 */
	public void abastecer( int pCantidad, Date pFecha )
	{
		cantidadActual += pCantidad;
		Transaccion nueva = new Transaccion( Transaccion.Tipo.ABASTECIMIENTO, pCantidad, pFecha );
		agregarTransaccion(nueva);
	}

	/**
	 * Agrega una transacción al final de la lista de transacciones.
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
	 * Retorna la colección de transacciones.
	 * @return La colección de transacciones.
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
	 * Retorna la representación en cadena de caracteres un objeto Libro.
	 * @return La representación en cadena de caracteres del objeto Libro.
	 */
	public String toString( )
	{
		String representacion = titulo + " (" + isbn + ")" + "-" + "categoria";
		return representacion;
	}
	/**
	 * Compara dos libros por su título. Si los títulos son iguales los compara por isbn.
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
