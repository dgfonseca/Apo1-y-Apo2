package uniandes.cupi2.fabricaDeUniformes.mundo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;

import uniandes.cupi2.fabricaDeUniformes.mundo.Camiseta.Manga;

public class CamisetaCuadros extends Camiseta
{

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Constante que representa el tipo camiseta con cuadros.
	 */
	public final static String TIPO = "CamisetaCuadros";

	/**
	 * Constante que representa el tamaño de cada raya de la camiseta.
	 */
	private final static int CANTIDAD_CUADROS = 10;

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
	public CamisetaCuadros( int pX, int pY, Color pColor )
	{
		super( pX, pY, TIPO, pColor );

	}

	/**
	 * Crea una nueva camiseta rayada a partir de la información de los datos contenidos en el archivo.<br>
	 * @param pLector Stream que sirve para leer el archivo. pLector != null.
	 * @throws Exception Se lanza una excepción si hay problemas leyendo el archivo o si el formato del archivo no es el esperado.
	 */
	public CamisetaCuadros( BufferedReader pLector ) throws Exception
	{
		super( pLector, TIPO );
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	@Override
	public void pintarDetalles( Graphics2D pGraphics )
	{
		int angulo = 30;
		int largoManga = ( int ) ( alto * ( manga == Manga.CORTA ? 0.4 : 0.85 ) );
		int altoManga = ( int ) ( ancho * 0.45 );
		Graphics2D g3d = ( Graphics2D )pGraphics.create( );
		g3d.setColor(color);
		g3d.rotate( Math.toRadians( -angulo ), x, y );
		g3d.fillRect( x - largoManga, y, largoManga, altoManga);
		g3d.dispose( );

		g3d = ( Graphics2D )pGraphics.create( );
		g3d.setColor(color);
		g3d.rotate( Math.toRadians( angulo ), x + ancho, y );
		g3d.fillRect( x + ancho, y, largoManga, altoManga );
		g3d.dispose( );

		//izquierda
		Graphics2D g2d = ( Graphics2D )pGraphics.create( );
		g2d.rotate( Math.toRadians( -angulo ), x, y );
		g2d.setColor(colorSecundario);
		for( int i = x; i < x + largoManga - 5; i += CANTIDAD_CUADROS*2 )
		{
			for( int j=y+CANTIDAD_CUADROS; j<y+altoManga; j += CANTIDAD_CUADROS*2)
			{
				g2d.fillRect( i - largoManga, j, CANTIDAD_CUADROS, CANTIDAD_CUADROS);
			}
		}
		for( int i = x+CANTIDAD_CUADROS; i < x + largoManga - 5; i += CANTIDAD_CUADROS*2 )
		{
			for( int j=y; j<y+altoManga; j += CANTIDAD_CUADROS*2)
			{
				g2d.fillRect( i - largoManga, j, CANTIDAD_CUADROS, CANTIDAD_CUADROS);
			}
		}
		g2d.dispose();

		//derecha
		g2d = ( Graphics2D )pGraphics.create( );
		g2d.rotate( Math.toRadians( angulo ), x + ancho, y);
		g2d.setColor(colorSecundario);
		for( int i = x; i < x + largoManga; i += CANTIDAD_CUADROS*2 )
		{
			for( int j=y+CANTIDAD_CUADROS; j<y+altoManga; j += CANTIDAD_CUADROS*2)
			{
				g2d.fillRect( i+ancho+CANTIDAD_CUADROS, j - CANTIDAD_CUADROS, CANTIDAD_CUADROS, CANTIDAD_CUADROS);
			}
		}
		for( int i = x-CANTIDAD_CUADROS; i < x + largoManga; i += CANTIDAD_CUADROS*2 )
		{
			for( int j=y; j<y+altoManga; j += CANTIDAD_CUADROS*2)
			{
				g2d.fillRect( i+ancho-CANTIDAD_CUADROS, j+CANTIDAD_CUADROS, CANTIDAD_CUADROS, CANTIDAD_CUADROS);
			}
		}
		g2d.dispose( );

		pGraphics.setColor(color);
		pGraphics.fillRect(darX(), darY(), ANCHO, ALTO);
		pGraphics.setColor( colorSecundario );
		for( int i = x; i < x + ancho-CANTIDAD_CUADROS; i += CANTIDAD_CUADROS*2 )
		{
			for( int j=y+CANTIDAD_CUADROS; j<y+alto; j += CANTIDAD_CUADROS *2)
			{
				pGraphics.fillRect( i, j, ( int ) ( CANTIDAD_CUADROS ), CANTIDAD_CUADROS );
			}
		}
		for( int i = x+CANTIDAD_CUADROS; i < x + ancho-CANTIDAD_CUADROS; i += CANTIDAD_CUADROS*2 )
		{
			for( int j=y; j<y+alto; j += CANTIDAD_CUADROS *2)
			{
				pGraphics.fillRect( i, j, ( int ) ( CANTIDAD_CUADROS ), CANTIDAD_CUADROS );
			}
		}
	}
}


