/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogotá - Colombia)
 * Departamento de  Ingeniería  de  Sistemas    y   Computación
 * Licenciado   bajo    el  esquema Academic Free License versión 2.1
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
 * Representa una categoría del almacén.
 */
public class Categoria extends NodoAlmacen
{

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Representa el tipo del nodo categoría.
	 */
	public final static String TIPO = "Categoria";

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Lista con los nodos hijos de la categoría.
	 */
	private List<NodoAlmacen> nodosHijos;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Construye una nueva categoría sin nodosHijos.<br>
	 * <b>post: </b> Se inicializaron los atributos de la clase padre con los valores dados por parámetro y el tipo respectivo. Se inicializó la lista de nodosHijos como una
	 * lista vacía.
	 * @param pIdentificador Identificador único de la marca. pIdentificador != null && pIdentificador != "".
	 * @param pNombre Nombre de la categoría. pNombre != null && pNombre != "".
	 */
	public Categoria( String pIdentificador, String pNombre )
	{
		super( TIPO, pIdentificador, pNombre );
		nodosHijos = new ArrayList<>( );
	}

	/**
	 * Construye una nueva categoría a partir de la línea con la información general y el lector para la información adicional.<br>
	 * <b>post:</b> Se inicializaron los atributos de la clase padre con el identificador que viene en la línea y el tipo respectivo. Se cargaron los nodosHijos de la
	 * categoría de la información contenida en el lector.
	 * @param pLinea Línea que contiene la información general de la marca. pLinea != null && pLinea != "" && pLinea.startsWith(TIPO).
	 * @param pLector Lector para acceder a la información de los productos.
	 * @throws AlmacenException Si ocurren errores al leer la información de los productos.
	 */
	public Categoria( String pLinea, BufferedReader pLector ) throws AlmacenException
	{
		super( TIPO, pLinea.split( ";;;" )[ 1 ], pLinea.split( ";;;" )[ 2 ] );
		nodosHijos = new ArrayList<>( );
		try
		{
			String datos[] = pLinea.split( ";;;" );
			int numHijos = Integer.parseInt( datos[ 3 ] );
			while( numHijos-- > 0 )
			{
				agregarNodo( identificador, crearNodo( pLector ) );
			}
		}
		catch( Exception e )
		{
			throw new AlmacenException( "Error al leer la marca:\n" + e.getMessage( ) );
		}

	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Retorna la lista de los nodosHijos hijos.
	 * @return Lista de nodosHijos.
	 */
	public List<NodoAlmacen> darNodos( )
	{
		return nodosHijos;
	}

	/**
	 * Indica si esta categoría tiene como hijo el nodo con el identificador dado.<br>
	 * <b>pre: </b> La lista de nodosHijos está inicializada.<br>
	 * @param pIdNodo Identificador del nodo. pIdNodo != null && pIdNodo != "".
	 * @return True si esta categoría tiene un hijo con el identificador dado, False en caso contrario.
	 */
	private boolean tieneHijo( String pIdNodo )
	{
		boolean respuesta = false;
		for( int i = 0; i < nodosHijos.size( ) && !respuesta; i++ )
		{
			NodoAlmacen nodo = nodosHijos.get( i );
			respuesta = nodo.darIdentificador( ).equals( pIdNodo );
		}
		return respuesta;
	}

	/**
	 * Retorna la categoría padre del nodo con identificador dado.<br>
	 * <b>pre: </b> La lista de nodosHijos está inicializada y existe un nodo con el identificador dado.<br>
	 * @param pIdNodo Identificador del nodo. pIdNodo != null && pIdNodo != "".
	 * @return Padre del nodo dado.
	 */
	public Categoria buscarPadre( String pIdNodo )
	{
		Categoria respuesta = tieneHijo( pIdNodo ) ? this : null;
		for( int i = 0; i < nodosHijos.size( ) && respuesta == null; i++ )
		{
			NodoAlmacen actual = nodosHijos.get( i );
			if( actual.darTipo( ).equals( Categoria.TIPO ) )
			{
				respuesta = ( ( Categoria )actual ).buscarPadre( pIdNodo );
			}

		}
		return respuesta;
	}

	/**
	 * Busca el nodo con el identificador dado.
	 * @param pIdentificador Identificador del nodo. pIdentificador != null && pIdentificador != "".
	 * @return NodoAlmacen con el identificador dado o null si no se encontró el nodo.
	 */
	@Override
	public NodoAlmacen buscarNodo( String pIdentificador )
	{
		if(identificador.equalsIgnoreCase(pIdentificador))
		{

			return this ;
		}

		else{

			for(int i=0;i<nodosHijos.size();i++)
			{
				NodoAlmacen hijo=(NodoAlmacen)nodosHijos.get(i);
				NodoAlmacen temp=hijo.buscarNodo(pIdentificador);
				if(temp != null)
				{
					return temp;
				}
			}
			return null;
		}
		// TODO HECHO Parte3 PuntoA Complete el método según la documentación dada.
	}

	/**
	 * Agrega un nuevo nodo del tipo dado a la lista.<br>
	 * <b>pre: </b> La lista de nodosHijos está inicializada.<br>
	 * <b>post: </b> Se agregó un nuevo nodo a la lista con los valores dados.
	 * @param pIdPadre Identificador único del padre del nodo. pIdPadre != null && pIdPadre != "".
	 * @param pTipo Tipo del nodo. pTipo != null && pTipo != "".
	 * @param pIdentificador Identificador del nodo. pIdentificador != null && pIdentificador != "".
	 * @param pNombre Nombre del nodo. pNombre != null && pNombre != "".
	 * @throws AlmacenException Si ya existe un nodo en el subárbol con ese identificador.
	 */
	public void agregarNodo( String pIdPadre, String pTipo, String pIdentificador, String pNombre ) throws AlmacenException
	{
		NodoAlmacen nuevo = pTipo.equals( Categoria.TIPO ) ? new Categoria( pIdentificador, pNombre ) : new Marca( pIdentificador, pNombre );
		agregarNodo( pIdPadre, nuevo );
	}

	/**
	 * Agrega un nuevo nodo a la lista.<br>
	 * <b>pre: </b> La lista de nodosHijos está inicializada.<br>
	 * <b>post: </b> Se agregó el nuevo nodo a la lista.
	 * @param pIdPadre Identificador único del padre del nodo. pIdPadre != null && pIdPadre != "".
	 * @param pNodo NodoAlmacen que se va a agregar. pNodo != null.
	 * @return True si agregó el nodo, False en caso contrario.
	 * @throws AlmacenException Si ya existe un nodo en el subárbol con ese identificador.
	 */
	public boolean agregarNodo( String pIdPadre, NodoAlmacen pNodo ) throws AlmacenException
	{
		boolean encontro=false;
		if(buscarNodo(pNodo.darIdentificador())==null)
		{
			if(buscarNodo(pIdPadre)!=null);
			{
				Categoria p=(Categoria)buscarNodo(pIdPadre);
				p.darNodos().add(pNodo);
				encontro=true;
			}


		}
		else
		{
			throw new AlmacenException("Ya existe un Nodo en el subarbol  con este id");
		}


		return encontro;
		// TODO HECHO Parte3 PuntoB Complete el método según la documentación dada.
	}

	/**
	 * Elimina el nodo con el identificador dado.<br>
	 * <b>pre: </b>La lista de nodosHijos está inicializada. Existe un nodo con el identificador dado en el subárbol.<br>
	 * <b>post: </b> Se eliminó el nodo con toda su información y su subárbol asociado.
	 * @param pIdentificador Identificador del nodo. pIdentificador != null && pIdentificador != "".
	 * @return NodoAlmacen eliminado.
	 */
	public NodoAlmacen eliminarNodo( String pIdentificador )
	{
		NodoAlmacen eliminar= buscarNodo(pIdentificador);
		Categoria Padre= buscarPadre(pIdentificador);
		Padre.darNodos().remove(eliminar);
		return eliminar;
		// TODO HECHO Parte3 PuntoC Complete el método según la documentación dada.
	}

	/**
	 * Busca el producto con el código dado.
	 * @param pCodigo Código del producto. pCodigo != null && pCodigo != "".
	 * @return El producto buscado o null si no existe.
	 */
	public Producto buscarProducto( String pCodigo )
	{
		Producto p = null;
		if(nodosHijos==null)
		{
			
			return null;
		}
		else{
			for(int i=0; i<nodosHijos.size() && p == null;i++)
			{
				NodoAlmacen hijo=(NodoAlmacen)nodosHijos.get(i);
				
				if(hijo.darTipo().equals("Marca"))
				{

					Marca actual= ((Marca) hijo);
					p = actual.buscarProducto(pCodigo);

				}
				if(hijo.darTipo().equals("Categoria"))
				{
					Categoria otro=((Categoria)hijo);
					p =	otro.buscarProducto(pCodigo);

				}
				
			}
			
			return p;
		}
	}



	// TODO HECHO Parte3 PuntoD Complete el método según la documentación dada.


	/**
	 * Agrega a la lista acumulada todos los productos del nodo.<br>
	 * <b>pre:</b> La lista de nodosHijos está inicializada.
	 * @param pProductos Lista acumulada con los productos. pProductos != null.
	 */
	@Override
	public void darProductos( List<Producto> pProductos )
	{
		for (int i=0; i< nodosHijos.size();i++)
		{
			NodoAlmacen hijo=(NodoAlmacen)nodosHijos.get(i);
			hijo.darProductos(pProductos);
			
		}

		// TODO HECHO Parte3 PuntoE Complete el método según la documentación dada.
	}

	/**
	 * Retorna una lista con todas las marcas que tiene la categoría y su subárbol.<br>
	 * <b>pre:</b> La lista de nodosHijos está inicializada.<br>
	 * @return Lista con todas las marcas de la categoría y su subárbol.
	 * 
	 */
	public List<Marca> darMarcas( )
	{
		ArrayList<Marca> list = new ArrayList<Marca>();
		
		for(int i=0; i<nodosHijos.size();i++)
		{
			NodoAlmacen hijo=(NodoAlmacen)nodosHijos.get(i);
			if(hijo.darTipo().equals("Marca"))
			{
				Marca actual= ((Marca) hijo);
				list.add(actual);
			}
			if(hijo.darTipo().equals("Categoria"))
			{
				Categoria dos = ((Categoria) hijo);
				list.addAll(dos.darMarcas());
				
				
			}
			
			
			
		}
		return list;
		}
		// TODO HECHO Parte3 PuntoF Complete el método según la documentación dada.

	

	/**
	 * Retorna todos los nodosHijos del árbol que tiene como raíz este nodo. Los nodosHijos se agregan en preorden.<br>
	 * <b>pre:</b> La lista de nodosHijos está inicializada.
	 * @return Lista con todos los nodosHijos del árbol.
	 */
	public List<NodoAlmacen> darPreorden( )
	{
		
		List<NodoAlmacen> lista = new ArrayList<NodoAlmacen>();
		lista.add(this);
		for(int i=0; i<nodosHijos.size();i++)
		{
			NodoAlmacen hijo=(NodoAlmacen)nodosHijos.get(i);
			        
					if(hijo.darTipo().equals("Marca"))
					{
						Marca actual=((Marca)hijo);
						lista.add(actual);
					}
					if(hijo.darTipo().equals("Categoria"))
					{
						Categoria actual = ((Categoria)hijo);
						lista.addAll(actual.darPreorden());
						
					}
					
					
					
		}
		return lista;
		
		
		
		
		
		
		

		// TODO HECHO Parte3 PuntoG Complete el método según la documentación dada.
	}

	/**
	 * Retorna todos los nodosHijos del árbol que tiene como raíz este nodo. Los nodosHijos se agregan en posorden.<br>
	 * <b>pre:</b> La lista de nodosHijos está inicializada.
	 * @return Lista con todos los nodosHijos del árbol.
	 */
	public List<NodoAlmacen> darPosorden( )
	{
		List<NodoAlmacen> lista = new ArrayList<NodoAlmacen>();
		
		for(int i=0; i<nodosHijos.size();i++)
		{
			NodoAlmacen hijo=(NodoAlmacen)nodosHijos.get(i);
			
			if(hijo.darTipo().equals("Categoria"))
			{
				Categoria actual = ((Categoria)hijo);
				lista.addAll(actual.darPosorden());
			}
					if(hijo.darTipo().equals("Marca"))
					{
						Marca actual=((Marca)hijo);
						lista.add(actual);
					}
					
					
					
					
		}
		lista.add(this);
		return lista;
		// TODO HECHO Parte3 PuntoH Complete el método según la documentación dada.
	}

	/**
	 * Retorna el valor total de las ventas de la categoría.
	 * @return Valor de las ventas de la categoría.
	 */
	public double darValorVentas( )
	{
		double ventas=0;
		for( int i=0; i< nodosHijos.size();i++)
		{
			NodoAlmacen hijo=(NodoAlmacen)nodosHijos.get(i);
			ventas += hijo.darValorVentas();
		}
		return ventas;

		// TODO HECHO Parte3 PuntoI Complete el método según la documentación dada.
	}
	public boolean esHoja( )
    {
        return nodosHijos.size( ) == 0;
    }

}
