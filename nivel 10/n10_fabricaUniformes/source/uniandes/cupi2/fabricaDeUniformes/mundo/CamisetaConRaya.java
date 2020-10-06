/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
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
import java.awt.Polygon;
import java.io.BufferedReader;
import java.io.PrintWriter;

import uniandes.cupi2.fabricaDeUniformes.mundo.Camiseta.Manga;

/**
 * Clase que representa una camiseta con una raya.
 */
public class CamisetaConRaya extends Camiseta
{

	// -----------------------------------------------------------------
	// Enumeraciones
	// -----------------------------------------------------------------

	/**
	 * Enumeración que contiene las posibles direcciones de la raya de la camiseta.
	 */
	public enum DireccionRaya
	{
		/**
		 * Raya en la dirección diagonal derecha.
		 */
		DIAGONAL_DERECHA,

		/**
		 * Raya en la dirección diagonal izquierda.
		 */
		DIAGONAL_IZQUIERDA,

		/**
		 * Raya en la dirección vertical.
		 */
		VERTICAL,

		/**
		 * Raya en la dirección horizontal.
		 */
		HORIZONTAL
	}

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Constante que representa el tipo camiseta con raya.
	 */
	public final static String TIPO = "CamisetaConRaya";

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Dirección de la raya de la camiseta.
	 */
	private DireccionRaya direccion;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Crea una nueva camiseta con raya con la información recibida por parámetro.<br>
	 * <b>post: </b>Se inicializaron los atributos x, y y color del padre con los parámetros dados. El atributo tipo de la clase padre se inicializó con el tipo que representa
	 * esta camiseta. El atributo dirección se inicializó con su valor por defecto.
	 * @param pX Coordinada en x de la camiseta con raya. pX >= 0.
	 * @param pY Coordinada en y de la camiseta con raya. pY >= 0.
	 * @param pColor Color de la camiseta con raya. pColor != null.
	 */
	public CamisetaConRaya( int pX, int pY, Color pColor )
	{
		super( pX, pY, TIPO, pColor );
		direccion = DireccionRaya.DIAGONAL_DERECHA;

	}

	/**
	 * Crea una nueva camiseta con raya a partir de la información de los datos contenidos en el archivo.<br>
	 * @param pLector Stream que sirve para leer el archivo. pLector != null.
	 * @throws Exception Se lanza una excepción si hay problemas leyendo el archivo o si el formato del archivo no es el esperado.
	 */
	public CamisetaConRaya( BufferedReader pLector ) throws Exception
	{
		super( pLector, TIPO );
		String dirString = pLector.readLine( );
		switch( dirString )
		{
		case "DIAGONAL_DERECHA":
			direccion = DireccionRaya.DIAGONAL_DERECHA;
			break;
		case "DIAGONAL_IZQUIERDA":
			direccion = DireccionRaya.DIAGONAL_IZQUIERDA;
			break;
		case "VERTICAL":
			direccion = DireccionRaya.VERTICAL;
			break;
		case "HORIZONTAL":
			direccion = DireccionRaya.HORIZONTAL;
			break;

		default:
			throw new Exception( "La dirección " + dirString + " no es válida." );
		}
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Retorna la dirección de la raya de la camiseta.
	 * @return Dirección de la raya de la camiseta.
	 */
	public DireccionRaya darDireccion( )
	{
		return direccion;
	}

	/**
	 * Cambia la dirección de la raya de la camiseta por el valor dado por parámetro.<br>
	 * <b>post: </b>Se cambió la dirección de la raya por el nuevo valor.
	 * @param pDireccion Dirección nueva de la raya de la camiseta. pDireccion != null && pDireccion = {DIAGONAL_DERECHA, DIAGONAL_IZQUIERDA, VERTICAL, HORIZONTAL}.
	 */
	public void cambiarDireccion( DireccionRaya pDireccion )
	{
		direccion = pDireccion;
	}

	@Override
	public void pintarDetalles( Graphics2D pGraphics )
	{


		int angulo = 30;
		int largoManga = ( int ) ( alto * ( manga == Manga.CORTA ? 0.4 : 0.85 ) );
		int altoManga = ( int ) ( ancho * 0.45 );
		Graphics2D g2d = ( Graphics2D )pGraphics.create( );
		g2d.setColor(color);
		g2d.rotate( Math.toRadians( -angulo ), x, y );
		g2d.fillRect( x - largoManga, y, largoManga, altoManga);
		g2d.dispose( );





		g2d = ( Graphics2D )pGraphics.create( );
		g2d.setColor(color);
		g2d.rotate( Math.toRadians( angulo ), x + ancho, y );
		g2d.fillRect( x + ancho, y, largoManga, altoManga );
		g2d.dispose( );

		pGraphics.setColor( colorSecundario );

		int px[] = new int[6];
		int py[] = new int[6];
		int nPuntos = 6;
		Polygon p;

		if( direccion == DireccionRaya.DIAGONAL_DERECHA )
		{
			px[ 0 ] = ( int ) ( x + ancho * 0.68 );
			py[ 0 ] = y;

			px[ 1 ] = x + ancho;
			py[ 1 ] = y;

			px[ 2 ] = x + ancho;
			py[ 2 ] = ( int ) ( y + alto * 0.32 );

			px[ 3 ] = ( int ) ( x + ancho * 0.32 );
			py[ 3 ] = y + alto;

			px[ 4 ] = x;
			py[ 4 ] = y + alto;

			px[ 5 ] = x;
			py[ 5 ] = ( int ) ( y + alto * ( 1 - 0.32 ) );

			p = new Polygon( px, py, nPuntos );
			pGraphics.fillPolygon( p );
		}
		else if( direccion == DireccionRaya.DIAGONAL_IZQUIERDA )
		{
			px[ 0 ] = x;
			py[ 0 ] = y;

			px[ 1 ] = ( int ) ( x + ancho * 0.32 );
			py[ 1 ] = y;

			px[ 2 ] = x + ancho;
			py[ 2 ] = ( int ) ( y + alto * ( 1 - 0.32 ) );

			px[ 3 ] = x + ancho;
			py[ 3 ] = y + alto;

			px[ 4 ] = ( int ) ( x + ancho * ( 1 - 0.32 ) );
			py[ 4 ] = y + alto;

			px[ 5 ] = x;
			py[ 5 ] = ( int ) ( y + alto * 0.32 );

			p = new Polygon( px, py, nPuntos );
			pGraphics.fillPolygon( p );
		}
		else if( direccion == DireccionRaya.VERTICAL )
		{
			pGraphics.fillRect( ( int ) ( x + ancho * 0.28 ), y, ( int ) ( ancho * 0.44 ), alto );
		}
		else
		{
			pGraphics.fillRect( x, ( int ) ( y + alto * 0.36 ), ancho, ( int ) ( alto * 0.29 ) );
		}
	}

	@Override
	public void guardar( PrintWriter pEscritor )
	{
		super.guardar( pEscritor );
		pEscritor.println( direccion.toString( ) );

	}
}
