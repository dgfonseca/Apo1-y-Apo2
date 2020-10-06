/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_FabricaDeUniformes
 * Autor: Equipo Cupi2 2018-1
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.fabricaDeUniformes.mundo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



/**
 * Clase que representa un uniforme.
 */
public class Uniforme
{
	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * Archivo donde se est� guardando actualmente el uniforme.
	 */
	private String archivo;

	/**
	 * Lista con las partes que hay en el uniforme, ordenadas en el orden en el que fueron agregados. <br>
	 * Las partes se pintan en el mismo orden en que aparecen aqu�.
	 */
	private List partes;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Construye un nuevo uniforme sin partes <br>
	 * <b>post: </b>Se inicializ� la lista de partes. El archivo fue inicializado en null. <br>
	 */
	public Uniforme( )
	{
		archivo=null;
		partes=new ArrayList();
		verificarInvariante();
		// TODO HECHO Parte8 PuntoA. Completar el m�todo seg�n la documentaci�n dada.
	}

	// -------------------------------------------------------------
	// M�todos
	// -------------------------------------------------------------

	/**
	 * Retorna la lista de los posibles tipos de partes.
	 * @return lista con los tipos de las partes.
	 */
	public List<String> darTipos( )
	{
		ArrayList<String> tipos = new ArrayList<String>( );
		tipos.add( Pantaloneta.TIPO );
		tipos.add( CamisetaFranjas.TIPO );
		tipos.add( CamisetaCuadros.TIPO );
		tipos.add( CamisetaConRaya.TIPO );
		tipos.add( Reebok.TIPO );
		tipos.add( Adidas.TIPO );
		tipos.add( Umbro.TIPO );

		return tipos;
	}

	/**
	 * Retorna la lista de partes del uniforme.
	 * @return Lista con las partes que tiene actualmente el uniforme.
	 */
	public List darPartes( )
	{
		return partes;
	}

	/**
	 * Retorna el nombre del archivo donde se est� guardando la informaci�n de este Uniforme.
	 * @return Ruta del archivo. Si no se ha establecido todav�a el nombre del archivo, retorna null.
	 */
	public String darNombreArchivo( )
	{
		return archivo;
	}

	/**
	 * Carga una Uniforme a partir de un archivo <br>
	 * <b>post: </b> Se elimin� el uniforme anterior y se carga el nuevo.
	 * @param pNombreArchivo Nombre del archivo del cual se lee la informaci�n. pNombreArchivo !=null && pNombreArchivo !=""
	 * @throws Exception Se lanza esta excepci�n si hay problemas leyendo el archivo o si el formato del archivo no es el esperado.
	 */
	public void abrir( String pNombreArchivo ) throws Exception
	{
		List partesAnteriores = new ArrayList( );


		BufferedReader br = new BufferedReader( new FileReader( pNombreArchivo ) );
		String linea = br.readLine( );
		try
		{
			partesAnteriores.addAll( partes );

			partes.clear( );

			int cuantasPartes = Integer.parseInt( linea );
			for( int i = 0; i < cuantasPartes; i++ )
			{
				System.out.println("entro");
				linea = br.readLine( );
				crearParte(linea, br);
			}

			br.close( );
		}
		catch( Exception nfe )
		{
			System.out.println(nfe.getMessage());
			br.close( );
			partes.clear( );
			partes.addAll( partesAnteriores );
			throw new Exception( linea );
		}

		archivo = pNombreArchivo;

		verificarInvariante( );
		// HECHO TODO Parte8 PuntoB. Completar el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Crea una parte con los datos contenidos en un archivo y la adiciona a la lista respectiva.<br>
	 * <b>post: </b> Se cre� la parte y se agreg� al uniforme.
	 * @param pTipoParte El tipo de la parte a crear. pTipoParte !=null.
	 * @param pLector Es el stream de donde se pueden leer los datos para crear la construcci�n. pLector !=null.
	 * @throws Exception Se lanza esta excepci�n si hay problemas leyendo el archivo o si el formato del archivo no es el esperado.
	 */
	private void crearParte( String pTipoParte, BufferedReader pLector ) throws Exception
	{

		IParte f = null;
		if( pTipoParte.equals( CamisetaConRaya.TIPO ) )
		{
			f = new CamisetaConRaya( pLector );
		}
		else if(pTipoParte.equals(CamisetaCuadros.TIPO))
		{
			f = new CamisetaCuadros(pLector);
		}
		else if(pTipoParte.equals(CamisetaFranjas.TIPO))
		{
			f = new CamisetaFranjas(pLector);
		}
		else if(pTipoParte.equals(Pantaloneta.TIPO))
		{
			f =new Pantaloneta(pLector);
		}
		else if( pTipoParte.equals(Reebok.TIPO))
		{
			f = new Reebok(pLector);
		}
		else if(pTipoParte.equals(Umbro.TIPO))
		{
			f = new Umbro(pLector);
		}
		else if(pTipoParte.equals(Adidas.TIPO))
		{
			f=new Adidas(pLector);
		}
		// TODO HECHO Parte8 PuntoC. Completar el m�todo a�adiendo los tipos faltantes.
		else
		{
			throw new Exception( "Error en el formato del archivo. El tipo " + pTipoParte + " no existe" );
		}

		partes.add( f );
		verificarInvariante( );

	}

	/**
	 * Crea y retorna una parte con las especificaciones dadas por par�metro.
	 * @param pTipoParte Tipo de la parte a crear. pTipoParte != null && pTipoParte != "".
	 * @param pX Coordenada x de la parte. pX >= 0.
	 * @param pY Coordenada y de la parte. pY >= 0.
	 * @param pColorParte Color de la parte. pColorParte != null.
	 * @return Parte con las especificaciones dadas.
	 */
	public Parte crearParte( String pTipoParte, int pX, int pY, Color pColorParte )
	{
		Parte f = null;
		if( pTipoParte.equals( CamisetaFranjas.TIPO ) )
		{
			f = new CamisetaFranjas( pX, pY, pColorParte );
		}
		else if(pTipoParte.equals(CamisetaCuadros.TIPO))
		{
			f = new CamisetaCuadros(pX, pY, pColorParte);
		}
		else if(pTipoParte.equals(CamisetaConRaya.TIPO))
		{
			f = new CamisetaConRaya(pX, pY, pColorParte);
		}
		else if(pTipoParte.equals(Pantaloneta.TIPO))
		{
			f = new Pantaloneta(pX, pY, pColorParte, pTipoParte);
		}
		else if( pTipoParte.equals(Adidas.TIPO))
		{
			f= new Adidas(pX,pY, pColorParte, pTipoParte);
		}
		else if( pTipoParte.equals(Reebok.TIPO))
		{
			f= new Reebok(pX,pY, pColorParte, pTipoParte);
		}
		else if( pTipoParte.equals(Umbro.TIPO))
		{
			f= new Umbro(pX,pY, pColorParte, pTipoParte);
		}

		// TODO HECHO Parte8 PuntoD. Completar el m�todo a�adiendo los tipos faltantes
		return f;



	}

	/**
	 * Agrega la parte dada por par�metro al uniforme. <br>
	 * <b>post: </b> La parte fue agregada al uniforme.
	 * @param pParte Parte a agregar pF != null.
	 */
	public void agregarParte( IParte pParte )
	{
		partes.add( pParte );
		verificarInvariante( );
	}

	/**
	 * Pinta las partes sobre la superficie recibida. <br>
	 * <b>post: </b> Se pintan todas las partes en el lienzo.
	 * @param pGraphics Es la superficie sobre la cual se debe pintar las partes. pGraphics != null y pGraphics es una superficie limpia (no se va a borrar antes de pintar).
	 */
	public void pintarPartes( Graphics2D pGraphics )
	{
		Iterator iter = partes.iterator( );
		while( iter.hasNext( ) )
		{
			IParte f = ( IParte )iter.next( );
			f.pintar( pGraphics);
		}
		verificarInvariante();
		// TODO HECHO Parte8 PuntoE. Completar el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Elimina la parte con el tipo dado por par�metro que contiene los puntos especificados. <br>
	 * Si no se encuentra ninguna parte con estas caracter�sticas, no se elimina nada. <br>
	 * <b>post: </b> La parte con las caracter�sticas especificadas no se encuentra en la lista de partes.
	 * @param pX Coordenada en x de la parte a eliminar pX >= 0.
	 * @param pY Coordenada en y de la parte a eliminar pY >= 0.
	 * @param pTipo Tipo de la parte a eliminar. pTipo != null && pTipo != "".
	 */
	public void eliminarParte( int pX, int pY, String pTipo )
	{
		boolean eliminado = false;

		// Eliminar la construcci�n
		Iterator iter = partes.iterator( );

		while( iter.hasNext( ) && !eliminado )
		{
			IParte c = ( IParte )iter.next( );
			if( c.estaDentro( pX, pY ) && c.darTipo()==pTipo )
			{
				iter.remove( );
				eliminado = true;
			}
		}

		verificarInvariante( );
		// TODO HECHONOSE Parte8 PuntoF. Completar el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Cambia la posici�n de la parte con las caracter�sticas dadas al nuevo punto de coordenadas dadas.<br>
	 * <b>post: </b> La parte con las caracter�sticas tiene las nuevas coordenadas.
	 * @param pX Coordenada en x donde se encuentra la parte a cambiar de posici�n. pX >= 0.
	 * @param pY Coordenada en y donde se encuentra la parte a cambiar de posici�n. pY >= 0.
	 * @param pTipo Tipo de la parte a cambiar de posici�n. pTipo != null && pTipo != "".
	 * @param pNuevoX Nueva coordenada en x donde se desea posicionar la parte. pNuevoX >= 0
	 * @param pNuevoY Nueva coordenada en y donde se desea posicionar la parte. pNuevoY >= 0
	 */
	public void cambiarPosicionParte( int pX, int pY, String pTipo, int pNuevoX, int pNuevoY )
	{
		boolean encontrado = false;

		Iterator<IParte> iter = partes.iterator( );

		while( iter.hasNext( ) && !encontrado )
		{
			IParte p = ( IParte )iter.next( );
			if( p.estaDentro( pX, pY ) && p.darTipo( ).equals( pTipo ) )
			{
				p.cambiarX( pNuevoX );
				p.cambiarY( pNuevoY );
				encontrado = true;
			}
		}
		verificarInvariante( );
	}

	/**
	 * Retorna la �ltima parte que se encuentre en la lista que contiene los puntos especificados.
	 * @param pX Coordenada en x. pX >= 0.
	 * @param pY Coordenada en y. pY >= 0.
	 * @return f Parte que contiene los puntos especificados, null si no existe ninguna.
	 */
	public IParte buscarParte( int pX, int pY )
	{
		IParte c = null;

		boolean encontrado = false;

		// Buscar la construcci�n
		Iterator iter = partes.iterator( );

		while( iter.hasNext( ) && !encontrado )
		{
			IParte aux = ( IParte )iter.next( );
			if( aux.estaDentro( pX, pY ) )
			{
				c = aux;
				encontrado = true;
			}
		}

		return c;
		// TODO HECHO Parte8 PuntoG. Completar el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Reinicia el uniforme, eliminando todas las partes actuales. <br>
	 * <b>post: </b> La lista de partes se encuentra vac�a y la ruta de archivo es nula.
	 */
	public void reiniciar( )
	{
		partes.clear( );
		archivo = null;
		verificarInvariante( );
	}

	/**
	 * Salva el uniforme actual en el archivo que se ven�a usando. <br>
	 * <b>pre: </b> Hay un archivo para salvar ya establecido. <br>
	 * <b>post: </b> Se salv� el uniforme en un archivo.
	 * @throws IOException Se lanza esta excepci�n si hay problemas salvando el uniforme.
	 */
	public void salvar( ) throws IOException
	{
		PrintWriter out = new PrintWriter( archivo );

		out.println( partes.size( ) );
		Iterator iter = partes.iterator( );
		while( iter.hasNext( ) )
		{
			IParte f = ( IParte)iter.next( );



			f.guardar( out );
		}
		out.close( );


		// TODO HECHO Parte8 PuntoH. Completar el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Salva el uniforme actual en el archivo dado por par�metro <br>
	 * <b>post: </b> Se salv� el uniforme en un archivo.
	 * @param pNombreArchivo Nombre del archivo en donde se guardar� el uniforme. pNombreArchivo != null && pNombreArchivo != "".
	 * @throws IOException Se lanza esta excepci�n si hay problemas salvando el uniforme.
	 */
	public void salvar( String pNombreArchivo ) throws IOException
	{
		archivo = pNombreArchivo;
		salvar( );
	}

	// -----------------------------------------------------------------
	// Invariantes
	// -----------------------------------------------------------------

	/**
	 * Verifica el invariante de la clase. <br>
	 * <b>inv: </b> partes != null.
	 */
	private void verificarInvariante( )
	{
		assert ( partes != null ) : "La lista de partes debe estar inicializada.";

	}

	// -----------------------------------------------------------------
	// M�todos de Extensi�n
	// -----------------------------------------------------------------

	/**
	 * M�todo para la Extensi�n 1.
	 * @return Respuesta 1.
	 */
	public String metodo1( )
	{
		return "Respuesta 1";
	}

	/**
	 * M�todo para la Extensi�n 2.
	 * @return Respuesta 2.
	 */
	public String metodo2( )
	{
		return "Respuesta 2";
	}
}