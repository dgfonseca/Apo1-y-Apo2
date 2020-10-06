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
import java.io.BufferedReader;

/**
 * Clase que representa una camiseta con rayas de igual tamaño.
 */
public class CamisetaFranjas extends Camiseta
{

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Constante que representa el tipo camiseta con franjas.
	 */
	public final static String TIPO = "CamisetaFranjas";

	/**
	 * Constante que representa el tamaño de cada raya de la camiseta.
	 */
	private final static int TAMANIO_FRANJAS = 26;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Crea una nueva camiseta rayada con la información recibida por parámetro.<br>
	 * <b>post: </b>Los atributos x, y y color del padre se inicializaron con los valores dados por parámetro. El atributo tipo de la clase padre se inicializó con el tipo que
	 * representa esta camiseta rayada.
	 * @param pX Coordinada en x de la camiseta rayada. pX >= 0.
	 * @param pY Coordinada en y de la camiseta rayada. pY >= 0.
	 * @param pColor Color de la camiseta. pColor != null.
	 */
	public CamisetaFranjas( int pX, int pY, Color pColor )
	{
		super( pX, pY, TIPO, pColor );

	}

	/**
	 * Crea una nueva camiseta rayada a partir de la información de los datos contenidos en el archivo.<br>
	 * @param pLector Stream que sirve para leer el archivo. pLector != null.
	 * @throws Exception Se lanza una excepción si hay problemas leyendo el archivo o si el formato del archivo no es el esperado.
	 */
	public CamisetaFranjas( BufferedReader pLector ) throws Exception
	{
		super( pLector, TIPO );
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	@Override
	public void pintarDetalles( Graphics2D pGraphics )
	{
		pGraphics.setColor( colorSecundario );

		int angulo = 30;
		int largoManga = ( int ) ( alto * ( manga == Manga.CORTA ? 0.4 : 0.85 ) );
		int altoManga = ( int ) ( ancho * 0.45 );
		Graphics2D g2d = ( Graphics2D )pGraphics.create( );
		g2d.rotate( Math.toRadians( -angulo ), x, y );
		g2d.fillRect( x - largoManga, y, largoManga, altoManga / 2 );
		g2d.dispose( );

		g2d = ( Graphics2D )pGraphics.create( );
		g2d.rotate( Math.toRadians( -angulo ), x, y );
		g2d.setColor(color);
		g2d.fillRect( x - largoManga, y+altoManga/2, largoManga, altoManga / 2 );
		g2d.dispose( );



		g2d = ( Graphics2D )pGraphics.create( );
		g2d.setColor(colorSecundario);
		g2d.rotate( Math.toRadians( angulo ), x + ancho, y );
		g2d.fillRect( x + ancho, y, largoManga, altoManga / 2 );
		g2d.dispose( );

		g2d = ( Graphics2D )pGraphics.create( );
		g2d.setColor(color);
		g2d.rotate( Math.toRadians( angulo ), x + ancho, y );
		g2d.fillRect( x + ancho, y+altoManga/2, largoManga, altoManga / 2 );
		g2d.dispose( );

		for( int i = x; i < x + ancho - ( TAMANIO_FRANJAS ); i += TAMANIO_FRANJAS * 2 )
		{
			pGraphics.fillRect( i, y, ( int ) ( TAMANIO_FRANJAS ), alto );
		}



	}  

}
