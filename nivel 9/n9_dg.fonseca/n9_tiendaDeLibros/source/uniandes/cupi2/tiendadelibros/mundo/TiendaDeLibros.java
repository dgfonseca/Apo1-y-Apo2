package uniandes.cupi2.tiendadelibros.mundo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import sun.net.www.content.text.plain;

public class TiendaDeLibros 
{
	/**
	 * Lista de categorias de los libros.
	 */
	public static final String [] CATEGORIAS = new String [] {"Cuento Infantil","Romance","Novela Historica","Terror","Biografia","Ciencia Ficcion"};
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Lista de libros registrados en la tienda.
	 */
	private Libro primerLibro;

	/**
	 * Cantidad actual en la caja de la tienda de libros.
	 */
	private double caja;

	private LibroEliminado primerEliminado;



	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------

	/**
	 * Crea una nueva tienda de libros. <br>
	 * <b>post:</b> El primer libro del catálogo fue inicializado en null. <br>
	 * La caja fue inicializada en 1000000.
	 */
	public TiendaDeLibros( )
	{
		primerLibro=null;
		caja = 1000000;
		primerEliminado=null;

	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Retorna el primer libro de la lista.
	 * @return El primer libro de la lista.
	 */
	public Libro darPrimerLibro( )
	{
		return primerLibro;
	}
	/**
	 * Retorna el catálogo de libros.
	 * @return El catálogo de libros.
	 */
	public ArrayList<Libro> darCatalogo( )
	{
		ArrayList<Libro> libro = new ArrayList<Libro>( );

		Libro actual = primerLibro;
		while( actual != null )
		{
			libro.add(actual);
			actual = actual.darSiguiente();
		}
		return libro;
	}

	/**
	 * Retorna el catálogo de libros.
	 * @return El catálogo de libros.
	 */
	public ArrayList<LibroEliminado> darCatalogoEliminados( )
	{
		ArrayList<LibroEliminado> libro = new ArrayList<LibroEliminado>( );

		LibroEliminado actual = primerEliminado;
		while( actual != null )
		{
			libro.add(actual);
			actual = actual.darSiguiente();
		}
		return libro;
	}

	/**
	 * Retorna el valor actual en la caja.
	 * @return El valor actual en caja.
	 */
	public double darCaja( )
	{
		return caja;
	}

	/**
	 * Modifica el valor actual de la caja.
	 * @param pCaja El nuevo valor de la caja.
	 */
	public void cambiarCaja( double pCaja )
	{
		caja = pCaja;
	}

	/**
	 * Busca un libro por el título dado por parámetro.
	 * @param pTitulo El titulo del libro que se quiere buscar. pTitulo != null && pTitulo != "".
	 * @return Si existe un libro con ese título, lo retorna. En caso contrario, retorna null.
	 */
	public Libro buscarLibroPorTitulo( String pTitulo )
	{
		Libro actual = primerLibro;
		Libro buscado=null;
		if(primerLibro != null && primerLibro.darTitulo().equalsIgnoreCase(pTitulo))
		{
			buscado=primerLibro;
		}
		while( actual!=null && actual.darSiguiente()!=null )
		{
			actual=actual.darSiguiente();

			if( actual.darTitulo( ).equals( pTitulo ) )
			{
				buscado = actual;
			}

		}

		return buscado;
	}

	/**
	 * Busca un libro por el código ISBN dado por parámetro.
	 * @param pIsbn El código ISBN del libro que se quiere buscar. pIsbn != null && pIsbn != "".
	 * @return Si existe un libro con ese ISBN, lo retorna. En caso contrario, retorna null.
	 */
	public Libro buscarLibroPorISBN( String pIsbn )
	{

		Libro buscado=null;

		for( int i=0; i<darCatalogo().size() && buscado == null;i++){
			Libro actual =darCatalogo().get(i);
			if(actual.darIsbn().equals(pIsbn))
			{
				buscado=actual;
			}

		}
		return buscado;

	}

	/**
	 * Registra un libro en la tienda de libros. <br>
	 * <b>post: </b> El libro fue creado y agregado al catálogo alfabéticamente.
	 * @param pTitulo El título del libro que se quiere agregar. pTitulo != null && pTitulo != "".
	 * @param pIsbn El código ISBN del libro que se quiere agregar. pIsbn != null && pIsbn != "".
	 * @param pPrecioVenta El precio de venta del libro que se quiere agregar. pPrecioVenta > 0.
	 * @param pPrecioCompra El precio de compra del libro que se quiere agregar. pPrecioCompra > 0.
	 * @param pCategoria Categoría a la que pertenece el libro. pCategoria != null && pCategoria != "". pCategoria pertenece a CATEGORIAS.
	 * @param pRutaImagen La ruta de la imagen del libro. pRutaImagen != null && pRutaImagen != "".
	 * @return El nuevo libro registrado en caso de que si se haya podido realizar la operación, null en caso de que el libro ya exista.
	 */
	public Libro registrarLibro( String pTitulo, String pIsbn, double pPrecioVenta, double pPrecioCompra, String pCategoria, String pRutaImagen )
	{
		/**
		 *  buscado = buscarLibroPorISBN(pIsbn);
		 */
		
		Libro nuevo = new Libro( pTitulo, pIsbn, pPrecioVenta, pPrecioCompra, pCategoria, pRutaImagen );
		//agregarLibro(nuevo);
		darCatalogo().add(nuevo);
		

		/**if( buscado == null )
		{
			nuevo = new Libro( pTitulo, pIsbn, pPrecioVenta, pPrecioCompra, pCategoria, pRutaImagen );
			if(primerLibro==null)
			{
				primerLibro=nuevo;	
			}
			else
			{
				
				Libro actual = primerLibro;
				Libro anterior=null;
				while(actual!=null )
				{
					anterior = actual;
					actual = actual.darSiguiente();
				}
				anterior.cambiarSiguiente(nuevo);
			}
			darCatalogo().add(nuevo);

		}

		**/return nuevo;
	}
	
	
	
	private void agregarLibro(Libro pLibro)
	{
		
		Libro nuevo=pLibro;
		Libro actual=primerLibro;
		
		if(primerLibro==null)
		{
			primerLibro=nuevo;
		}
		else
		{
			if(primerLibro.compararPorTitulo(nuevo)==1)
			{
				nuevo.cambiarSiguiente(primerLibro);
				primerLibro.cambiarAnterior(nuevo);
			    primerLibro=nuevo;
			}
			else
			{
				Libro anterior=actual;
				while(actual!=null && actual.compararPorTitulo(pLibro)==-1)
				{
					anterior=actual;
					actual=actual.darSiguiente();
				}
				anterior.cambiarSiguiente(nuevo);
				nuevo.cambiarAnterior(anterior);
				nuevo.cambiarSiguiente(actual);
				if(actual!=null)
				{
					actual.cambiarAnterior(nuevo);
				}
			}
		}
		
		
		
		
		
		
	}




	/**
	 * 
	 *  sdfwagukgjkhofajhlsa
	 * @param pLibro
	 * @return
	 */



	public LibroEliminado agregarEliminado(Libro pLibro)
	{
		Libro buscado = buscarLibroPorTitulo(pLibro.darTitulo());
		LibroEliminado agregar=new LibroEliminado(pLibro.darTitulo());
		if(buscado==null)
		{
			if(primerEliminado==null)
			{
				primerEliminado=agregar;
			}
			else
			{
				LibroEliminado actual = primerEliminado;
				LibroEliminado anterior=null;
				while(actual!=null)
				{
					anterior=actual;
					actual=actual.darSiguiente();
				}
				anterior.cambiarSiguiente(agregar);
			}
			darCatalogoEliminados().add(agregar);
		}
		return agregar;
	}


	/**
	 * Elimina un libro con el ISBN dado por parámetro. Si la cantidad actual de ejemplares es mayor a cero, no se eliminará el libro. <br>
	 * <b>post: </b> El libro fue eliminado del catálogo.
	 * @param pIsbn El ISBN del libro que se quiere eliminar. pIsbn != null && pIsbn != "".
	 * @return Retorna true si se pudo eliminar, false si el libro no existe o si la cantidad actual de ejemplares es mayor a cero.
	 */
	public boolean eliminarLibro( String pIsbn )
	{
		boolean eliminado = false;

		if(pIsbn==primerLibro.darIsbn())
		{
			primerLibro=primerLibro.darSiguiente();
		}
		else
		{
			Libro anteriors = anterior(pIsbn);	
			if(anteriors!=null)
			{
				agregarEliminado(anteriors.darSiguiente());
				anteriors.desconectarSiguiente();
				eliminado=true;
			}
		}
		return eliminado;
	}

	private Libro anterior( String pIsbn )
	{
		Libro anterior = primerLibro;
		Libro actual = primerLibro.darSiguiente( );
		while( actual != null && !actual.darIsbn( ).equalsIgnoreCase( pIsbn ) )
		{
			anterior = actual;
			actual = actual.darSiguiente( );
		}
		return actual != null ? anterior : null;
	}

	/**
	 * Abastece un libro con la cantidad de ejemplares dada por parámetro. <br>
	 * <b>post: </b> Se abasteció el libro con el ISBN dado y se disminuyó la cantidad en caja con el precio final del abastecimiento.
	 * @param pIsbn El Código ISBN del libro que se quiere abastecer. pIsbn!= null && pISBN != "".
	 * @param pFecha La fecha en la que se realizó la transacción. pFecha != "" && pFecha != null.
	 * @param pCantidad La cantidad de ejemplares que se van a abastecer. pCantidad >= 0.
	 * @return Retorna true si se pudo abastecer el libro, false en caso contrario.
	 */
	public boolean abastecer( String pIsbn, int pCantidad, String pFecha )
	{
		Libro buscado = buscarLibroPorISBN( pIsbn );
		boolean seAbastecio = false;
		Date fechas=new Date();
		SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


		try {
			fechas=formato.parse(pFecha);

		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		if( buscado != null && caja >= pCantidad * buscado.darPrecioCompra( ) )
		{
			buscado.abastecer( pCantidad, fechas );
			// Disminuye la caja con el valor total de los ejemplares abastecidos
			caja -= pCantidad * buscado.darPrecioCompra( );
			seAbastecio = true;
		}
		return seAbastecio;
	}

	/**
	 * Vende la cantidad de ejemplares del libro con el ISBN dado por parámetro. <br>
	 * <b>post: </b> Se vendió el libro con el ISBN dado y se aumentó la cantidad en caja con el precio final de la venta.
	 * @param pIsbn El Código ISBN del libro que se quiere vender. pIsbn != null && pIsbn != "".
	 * @param pCantidad La cantidad de ejemplares que se van a vender.
	 * @param pFecha La fecha en la que se realizó la transacción. pFecha != "" && pFecha != null.
	 * @return Retorna true en caso de que se pueda vender la cantidad de ejemplares dada por parámetro. False en caso contrario.
	 */
	public boolean vender( String pIsbn, int pCantidad, String pFecha )
	{
		boolean vendido = false;
		Libro buscado = buscarLibroPorISBN( pIsbn );
		Date actual = new Date();

		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			actual = formato.parse(pFecha);

		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if( buscado != null )
		{
			vendido = buscado.vender( pCantidad, actual );
			caja += pCantidad * buscado.darPrecioVenta( );
		}
		return vendido;
	}

	/**
	 * Busca el libro más costoso, es decir el libro con el mayor precio de venta en el catálogo.
	 * @return El libro más costoso. En caso de que el catalogo esté vacío, retorna null
	 */
	public Libro darLibroMasCostoso( )
	{
		Libro masCostoso = null;
		double precioMasCostoso = 0.0;
		Libro actual =primerLibro;

		while( actual!=null )
		{

			if( actual.darPrecioVenta( ) > precioMasCostoso )
			{
				masCostoso = actual;
				precioMasCostoso = actual.darPrecioVenta( );
			}
			actual=actual.darSiguiente();
		}

		return masCostoso;
	}

	/**
	 * Busca el libro más económico en el catálogo de libros. El libros más económico es el libro con el menor precio de venta.
	 * @return El libro menos costoso. En caso de que el catálogo esté vacío, retorna null.
	 */
	public Libro darLibroMasEconomico( )
	{
		Libro menosCostoso = null;
		double precioMenosCostoso = 1111111110.0;
		Libro actual=primerLibro;

		while( actual!=null )
		{

			if( actual.darPrecioVenta( ) < precioMenosCostoso )
			{
				menosCostoso = actual;
				precioMenosCostoso = actual.darPrecioVenta( );
			}
			actual=actual.darSiguiente();
		}

		return menosCostoso;

	}

	/**
	 * Busca el libro más vendido, es decir el libro con más transacciones de tipo VENTA.
	 * @return El libro más vendido. En caso de que el catálogo esté vacío, retorna null.
	 */
	public Libro darLibroMasVendido( )
	{
		Libro masVendido=null;
		int ventas=0;
		for(Libro libroActual : darCatalogo())
		{
			int ventasActual=0;
			for(Transaccion transaccionActual : libroActual.darTransacciones())
			{
				if(transaccionActual.darTipo().equals(Transaccion.Tipo.VENTA)){
					ventasActual++;
				}
			}
			if(ventasActual>ventas)
			{
				masVendido=libroActual;
				ventas=ventasActual;
			}
		}

		return masVendido;
	}

	/**
	 * Calcula la cantidad de transacciones de abastecimiento del libro con el ISBN dado por parámetro.
	 * @param pIsbn El código ISBN del libro que se quiere buscar. pIsbn != null && pIsbn != "".
	 * @return La cantidad de transacciones de abastecimiento. En caso de que no encuentre el libro o no tenga transacciones, retorna cero.
	 */
	public int darCantidadTransaccionesAbastecimiento( String pIsbn )
	{
		// Busca el libro con el ISBN dado por parámetro
		Libro buscado = buscarLibroPorISBN( pIsbn );
		int cantidadTransacciones = 0;
		// Verifica que si exista el libro
		if( buscado != null )
		{
			// Guarda las transacciones del libro buscado
			ArrayList<Transaccion> transacciones = buscado.darTransacciones( );
			for( int i = 0; i < transacciones.size( ); i++ )
			{
				Transaccion actual = transacciones.get( i );
				// Verifica y cuenta las transacciones de tipo ABASTECIMIENTO
				if( actual.darTipo( ).equals( Transaccion.Tipo.ABASTECIMIENTO ) )
				{
					cantidadTransacciones++;
				}
			}
		}
		return cantidadTransacciones;
	}

	// -----------------------------------------------------------------
	// Puntos de Extensión
	// -----------------------------------------------------------------

	/**
	 * Método para la extensión 1.
	 * @return Respuesta 1.
	 */
	public String metodo1( )
	{
		return "Respuesta 1";
	}

	/**
	 * Método para la extensión 2.
	 * @return Respuesta 2.
	 */
	public String metodo2( )
	{
		return "Respuesta 2";
	}

}
