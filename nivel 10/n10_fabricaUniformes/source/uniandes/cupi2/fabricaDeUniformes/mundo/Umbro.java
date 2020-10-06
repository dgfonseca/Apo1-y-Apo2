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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.io.BufferedReader;

/**
 * Clase que representa el logo de Umbro.
 */
public class Umbro extends Logo
{

	// -------------------------------------------------------------
	// Constantes
	// -------------------------------------------------------------

	/**
	 * Constante que representa el tipo GloboLinea
	 */
	public final static String TIPO = "Umbro";

	// -------------------------------------------------------------
	// Constructores
	// -------------------------------------------------------------

	/**
	 * Crea una nuevo logo de Umbro con la información recibida por parámetro.<br>
	 * @param pX Coordinada en x del logo. pX >= 0.
	 * @param pY Coordinada en y del logo. pY >= 0.
	 * @param pColor Color del logo. pColor != null.
	 * @param pTexto Texto del logo. pTexto != null.
	 */
	public Umbro( int pX, int pY, Color pColor, String pTexto )
	{
		super( pX, pY, TIPO, pColor, pTexto );
	}

	/**
	 * Crea un nuevo logo de Umbro a partir de la información de los datos contenidos en el archivo.<br>
	 * @param pLector Stream que sirve para leer el archivo. pLector != null.
	 * @throws Exception Se lanza una excepción si hay problemas leyendo el archivo o si el formato del archivo no es el esperado.
	 */
	public Umbro( BufferedReader pLector ) throws Exception
	{
		super( pLector, TIPO );
	}

	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------

	@Override
	public void pintarDetalles( Graphics2D pGraphics )
	{
		pGraphics.setColor(colorTexto);
		int px[] = new int[4];
		int py[] = new int[4];
		Polygon p;

		px[ 0 ] = x + ( int ) ( ancho * 0.10 );
		py[ 0 ] = y + ( int ) ( alto * 0.35 );

		px[ 1 ] = x + ( int ) ( ancho * 0.50 );
		py[ 1 ] = y + ( int ) ( alto * 0.10 );

		px[ 2 ] = x + ( int ) ( ancho * 0.90 );
		py[ 2 ] = y + ( int ) ( alto * 0.35 );

		px[ 3 ] = x + ( int ) ( ancho * 0.50 );
		py[ 3 ] = y + ( int ) ( alto * 0.60 );


		pGraphics.setStroke( new BasicStroke( 5 ) );

		p = new Polygon( px, py, 4 );

		pGraphics.drawPolygon( p );

		int dx = ( int ) ( ancho * 0.25 );
		int dy = ( int ) ( alto * 0.175 );

		px[ 0 ] = x + ( int ) ( ancho * 0.05 ) + dx;
		py[ 0 ] = y + ( int ) ( alto * 0.175 ) + dy;

		px[ 1 ] = x + ( int ) ( ancho * 0.25 ) + dx;
		py[ 1 ] = y + ( int ) ( alto * 0.05 ) + dy;

		px[ 2 ] = x + ( int ) ( ancho * 0.45 ) + dx;
		py[ 2 ] = y + ( int ) ( alto * 0.175 ) + dy;

		px[ 3 ] = x + ( int ) ( ancho * 0.25 ) + dx;
		py[ 3 ] = y + ( int ) ( alto * 0.30 ) + dy;

		p = new Polygon( px, py, 4 );
		pGraphics.drawPolygon( p );

	}

}
