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
 * Representa una categor�a del almac�n.
 */
public class Categoria extends NodoAlmacen
{

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Representa el tipo del nodo categor�a.
	 */
	public final static String TIPO = "Categoria";

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Lista con los nodos hijos de la categor�a.
	 */
	private List<NodoAlmacen> nodosHijos;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Construye una nueva categor�a sin nodosHijos.<br>
	 * <b>post: </b> Se inicializaron los atributos de la clase padre con los valores dados por par�metro y el tipo respectivo. Se inicializ� la lista de nodosHijos como una
	 * lista vac�a.
	 * @param pIdentificador Identificador �nico de la marca. pIdentificador != null && pIdentificador != "".
	 * @param pNombre Nombre de la categor�a. pNombre != null && pNombre != "".
	 */
	public Categoria( String pIdentificador, String pNombre )
	{
		super( TIPO, pIdentificador, pNombre );
		nodosHijos = new ArrayList<>( );
	}

	/**
	 * Construye una nueva categor�a a partir de la l�nea con la informaci�n general y el lector para la informaci�n adicional.<br>
	 * <b>post:</b> Se inicializaron los atributos de la clase padre con el identificador que viene en la l�nea y el tipo respectivo. Se cargaron los nodosHijos de la
	 * categor�a de la informaci�n contenida en el lector.
	 * @param pLinea L�nea que contiene la informaci�n general de la marca. pLinea != null && pLinea != "" && pLinea.startsWith(TIPO).
	 * @param pLector Lector para acceder a la informaci�n de los productos.
	 * @throws AlmacenException Si ocurren errores al leer la informaci�n de los productos.
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
	// M�todos
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
	 * Indica si esta categor�a tiene como hijo el nodo con el identificador dado.<br>
	 * <b>pre: </b> La lista de nodosHijos est� inicializada.<br>
	 * @param pIdNodo Identificador del nodo. pIdNodo != null && pIdNodo != "".
	 * @return True si esta categor�a tiene un hijo con el identificador dado, False en caso contrario.
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
	 * Retorna la categor�a padre del nodo con identificador dado.<br>
	 * <b>pre: </b> La lista de nodosHijos est� inicializada y existe un nodo con el identificador dado.<br>
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
	 * @return NodoAlmacen con el identificador dado o null si no se encontr� el nodo.
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
		// TODO HECHO Parte3 PuntoA Complete el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Agrega un nuevo nodo del tipo dado a la lista.<br>
	 * <b>pre: </b> La lista de nodosHijos est� inicializada.<br>
	 * <b>post: </b> Se agreg� un nuevo nodo a la lista con los valores dados.
	 * @param pIdPadre Identificador �nico del padre del nodo. pIdPadre != null && pIdPadre != "".
	 * @param pTipo Tipo del nodo. pTipo != null && pTipo != "".
	 * @param pIdentificador Identificador del nodo. pIdentificador != null && pIdentificador != "".
	 * @param pNombre Nombre del nodo. pNombre != null && pNombre != "".
	 * @throws AlmacenException Si ya existe un nodo en el sub�rbol con ese identificador.
	 */
	public void agregarNodo( String pIdPadre, String pTipo, String pIdentificador, String pNombre ) throws AlmacenException
	{
		NodoAlmacen nuevo = pTipo.equals( Categoria.TIPO ) ? new Categoria( pIdentificador, pNombre ) : new Marca( pIdentificador, pNombre );
		agregarNodo( pIdPadre, nuevo );
	}

	/**
	 * Agrega un nuevo nodo a la lista.<br>
	 * <b>pre: </b> La lista de nodosHijos est� inicializada.<br>
	 * <b>post: </b> Se agreg� el nuevo nodo a la lista.
	 * @param pIdPadre Identificador �nico del padre del nodo. pIdPadre != null && pIdPadre != "".
	 * @param pNodo NodoAlmacen que se va a agregar. pNodo != null.
	 * @return True si agreg� el nodo, False en caso contrario.
	 * @throws AlmacenException Si ya existe un nodo en el sub�rbol con ese identificador.
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
		// TODO HECHO Parte3 PuntoB Complete el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Elimina el nodo con el identificador dado.<br>
	 * <b>pre: </b>La lista de nodosHijos est� inicializada. Existe un nodo con el identificador dado en el sub�rbol.<br>
	 * <b>post: </b> Se elimin� el nodo con toda su informaci�n y su sub�rbol asociado.
	 * @param pIdentificador Identificador del nodo. pIdentificador != null && pIdentificador != "".
	 * @return NodoAlmacen eliminado.
	 */
	public NodoAlmacen eliminarNodo( String pIdentificador )
	{
		NodoAlmacen eliminar= buscarNodo(pIdentificador);
		Categoria Padre= buscarPadre(pIdentificador);
		Padre.darNodos().remove(eliminar);
		return eliminar;
		// TODO HECHO Parte3 PuntoC Complete el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Busca el producto con el c�digo dado.
	 * @param pCodigo C�digo del producto. pCodigo != null && pCodigo != "".
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



	// TODO HECHO Parte3 PuntoD Complete el m�todo seg�n la documentaci�n dada.


	/**
	 * Agrega a la lista acumulada todos los productos del nodo.<br>
	 * <b>pre:</b> La lista de nodosHijos est� inicializada.
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

		// TODO HECHO Parte3 PuntoE Complete el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Retorna una lista con todas las marcas que tiene la categor�a y su sub�rbol.<br>
	 * <b>pre:</b> La lista de nodosHijos est� inicializada.<br>
	 * @return Lista con todas las marcas de la categor�a y su sub�rbol.
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
		// TODO HECHO Parte3 PuntoF Complete el m�todo seg�n la documentaci�n dada.

	

	/**
	 * Retorna todos los nodosHijos del �rbol que tiene como ra�z este nodo. Los nodosHijos se agregan en preorden.<br>
	 * <b>pre:</b> La lista de nodosHijos est� inicializada.
	 * @return Lista con todos los nodosHijos del �rbol.
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
		
		
		
		
		
		
		

		// TODO HECHO Parte3 PuntoG Complete el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Retorna todos los nodosHijos del �rbol que tiene como ra�z este nodo. Los nodosHijos se agregan en posorden.<br>
	 * <b>pre:</b> La lista de nodosHijos est� inicializada.
	 * @return Lista con todos los nodosHijos del �rbol.
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
		// TODO HECHO Parte3 PuntoH Complete el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Retorna el valor total de las ventas de la categor�a.
	 * @return Valor de las ventas de la categor�a.
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

		// TODO HECHO Parte3 PuntoI Complete el m�todo seg�n la documentaci�n dada.
	}
	public boolean esHoja( )
    {
        return nodosHijos.size( ) == 0;
    }

}
