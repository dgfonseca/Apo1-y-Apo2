/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogot� - Colombia)
 * Departamento de  Ingenier�a  de  Sistemas    y   Computaci�n
 * Licenciado   bajo    el  esquema Academic Free License versi�n 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n11_almacen
 * Autor: Equipo Cupi2 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.almacen.mundo;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una Marca.
 */
public class Marca extends NodoAlmacen
{

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Constante que representa el tipo del nodo marca.
	 */
	public final static String TIPO = "Marca";

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Referencia al producto ra�z del �rbol binario que contiene los productos de la marca.
	 */
	private Producto productoRaiz;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Construye una nueva marca.<br>
	 * <b>post: </b> Se inicializaron los atributos de la clase padre con los valores dados por par�metro y el tipo respectivo. El producto ra�z se inicializ� en null.
	 * @param pIdentificador Identificador �nico de la marca. pIdentificador != null && pIdentificador != "".
	 * @param pNombre Nombre de la marca. pNombre != null && pNombre != "".
	 */
	public Marca( String pIdentificador, String pNombre )
	{
		super( TIPO, pIdentificador, pNombre );
		productoRaiz = null;
	}

	/**
	 * Construye una nueva marca a partir de la l�nea con la informaci�n general y el lector para la informaci�n adicional.<br>
	 * <b>post:</b> Se inicializaron los atributos de la clase padre con el nombre que viene en la l�nea y el tipo respectivo. Se cargaron los productos de la marca de la
	 * informaci�n contenida en el lector.
	 * @param pLinea L�nea que contiene la informaci�n general de la marca. pLinea != null && pLinea != "" && pLinea.startsWith(TIPO).
	 * @param pLector Lector para acceder a la informaci�n de los productos.
	 * @throws AlmacenException Si ocurren errores al leer la informaci�n de los productos.
	 */
	public Marca( String pLinea, BufferedReader pLector ) throws AlmacenException
	{
		super( TIPO, pLinea.split( ";;;" )[ 1 ], pLinea.split( ";;;" )[ 2 ] );
		try
		{
			String datos[] = pLinea.split( ";;;" );
			int numHijos = Integer.parseInt( datos[ 3 ] );
			while( numHijos-- > 0 )
			{
				Producto producto = new Producto( pLector );
				agregarProducto( producto );
			}
		}
		catch( Exception e )
		{
			throw new AlmacenException( "Error al leer la marca:\n" + e.getMessage( ) );
		}

	}

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------

	/**
	 * Retorna la cantidad de productos pertenecientes a la marca.
	 * @return Cantidad de productos de la marca.
	 */
	public int darCantidadProductos( )
	{
		if( productoRaiz == null )
			return 0;
		else
		{
			int resp = productoRaiz.darPeso();

			return resp;
		}
		// TODO HECHO Parte2 PuntoA Complete el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Agrega un nuevo producto con la informaci�n dada al �rbol de productos de la marca.<br>
	 * <b>post: </b>Se agreg� el producto al �rbol.
	 * @param pCodigo C�digo del producto. pCodigo != null && pCodigo != "".
	 * @param pNombre Nombre del producto. pNombre != null && pNombre != "".
	 * @param pDescripcion Descripci�n del producto. pDescripcion != null && pDescripcion != "".
	 * @param pPrecio Precio del producto. pPrecio > 0.
	 * @throws AlmacenException Si ya exist�a un producto con el c�digo dado.
	 */
	public void agregarProducto( String pCodigo, String pNombre, String pDescripcion, double pPrecio ) throws AlmacenException
	{
		Producto nuevo = new Producto( pCodigo, pNombre, pDescripcion, pPrecio );
		agregarProducto( nuevo );

	}

	/**
	 * Agrega un producto al �rbol de productos de la marca.<br>
	 * <b>post: </b>Se agreg� el producto al �rbol.
	 * @param pProducto Producto nuevo. pProducto != null.
	 * @throws AlmacenException Si ya exist�a un producto con el c�digo dado.
	 */
	private void agregarProducto( Producto pProducto ) throws AlmacenException
	{

		if(productoRaiz==null)
		{
			productoRaiz=pProducto;
		}

		else
		{
			productoRaiz.agregarProducto(pProducto);
		}
		// TODO HECHO Parte2 PuntoB Complete el m�todo seg�n la documentaci�n dada.
	}
	/**
	 * Busca un producto por c�digo en el �rbol de productos.
	 * @param pCodigo C�digo del producto que se esta buscando. pCodigo != null && pCodigo != "".
	 * @return Producto con el c�digo dado por par�metro o null si no existe.
	 */
	public Producto buscarProducto( String pCodigo )
	{
		return productoRaiz == null ? null : productoRaiz.buscarProducto(pCodigo);
		// TODO HECHO Parte2 PuntoC Complete el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Vende una cantidad dada del producto con el c�digo recibido por par�metro.<br>
	 * <b>pre: </b>Existe el producto con el c�digo dado. <br>
	 * <b>post: </b> Se vendieron las cantidades dadas del producto con c�digo dado.
	 * @param pCodigo C�digo del producto. pCodigo != null && pCodigo != "".
	 * @param pCantidad Cantidad de unidades vendidas. pCantidad > 0.
	 */
	public void venderProducto( String pCodigo, int pCantidad )
	{
		productoRaiz.buscarProducto(pCodigo).vender(pCantidad);
		// TODO HECHO Parte2 PuntoD Complete el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Retorna la venta total de los productos de la marca.
	 * @return Venta total de los productos de la marca.
	 */
	public double darValorVentas( )
	{
		int variable=0;
		for(int i=0; i<darProductos().size();i++)
		{
			Producto temp=darProductos().get(i);
			variable+=temp.darValorVentas();
		}
		return variable;


		// TODO HECHO Parte2 PuntoE Complete el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Agrega a la lista acumulada todos los productos del nodo.<br>
	 * <b>pre:</b> La lista de nodos est� inicializada.
	 * @param pProductos Lista acumulada con los productos. pProductos != null.
	 */
	@Override
	public void darProductos( List<Producto> pProductos )
	{
		if(productoRaiz!=null){
			productoRaiz.darInorden(pProductos);
		}
		// TODO HECHO Parte2 PuntoF Complete el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Busca el nodo con el identificador dado.
	 * @param pIdentificador Identificador del nodo. pIdentificador != null && pIdentificador != "".
	 * @return NodoAlmacen con el identificador dado o null si no se encontr� el nodo.
	 */
	@Override
	public NodoAlmacen buscarNodo( String pIdentificador )
	{
		if(identificador.equals(pIdentificador))
		{
			return this;
		}
		else{
			return null;
		}


		// TODO HECHO Parte2 PuntoG Complete el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Elimina el producto con el c�digo dado.<br>
	 * <b>post:</b> Se elimin� el producto.
	 * @param pCodigo C�digo del producto. pCodigo != null && pCodigo != "".
	 * @return True si elimin� el producto, false en caso contrario.
	 */
	public boolean eliminarProducto( String pCodigo )
	{
		boolean respuesta = false;
		if( productoRaiz != null )
		{
			if( productoRaiz.darCodigo( ).equals( pCodigo ) )
			{
				Producto raizAux = new Producto( "", "", "", -1 );
				raizAux.cambiarHijoIzquierda( productoRaiz );
				respuesta = productoRaiz.eliminarProducto( pCodigo, raizAux );
				productoRaiz = raizAux.darHijoIzquierda( );
			}
			else
			{
				respuesta = productoRaiz.eliminarProducto( pCodigo, null );
			}
		}
		return respuesta;
	}

}