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
 * Clase que representa el logo de Adidas.
 */
public class Adidas extends Logo
{

	// -------------------------------------------------------------
	// Constantes
	// -------------------------------------------------------------

	/**
	 * Constante que representa el tipo Adidas.
	 */
	public final static String TIPO = "Adidas";

	// -------------------------------------------------------------
	// Constructores
	// -------------------------------------------------------------

	/**
	 * Crea una nuevo logo de Adidas con la información recibida por parámetro.<br>
	 * @param pX Coordinada en x del logo de Adidas. pX >= 0.
	 * @param pY Coordinada en y del logo de Adidas. pY >= 0.
	 * @param pColor Color del logo de Adidas. pColor != null.
	 * @param pTexto Texto del logo de Adidas. pTexto != null.
	 */
	public Adidas( int pX, int pY, Color pColor, String pTexto )
	{
		super( pX, pY, TIPO, pColor, pTexto );
	}

	/**
	 * Crea un nuevo logo de Adidas a partir de la información de los datos contenidos en el archivo.<br>
	 * @param pLector Stream que sirve para leer el archivo. pLector != null.
	 * @throws Exception Se lanza una excepción si hay problemas leyendo el archivo o si el formato del archivo no es el esperado.
	 */
	public Adidas( BufferedReader pLector ) throws Exception
	{
		super( pLector, TIPO );
	}

	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------

	@Override
	public void pintarDetalles( Graphics2D pGraphics )
	{
		pGraphics.setColor( colorTexto );
		int px[] = new int[3];
		int py[] = new int[3];

		px[ 0 ] = ( int ) ( x + ancho * 0.05 );
		py[ 0 ] = ( int ) ( y + alto * 0.6 );
		//
		px[ 1 ] = ( int ) ( x + ancho * 0.6 );
		py[ 1 ] = ( int ) ( y + alto * 0.1 );

		px[ 2 ] = ( int ) ( x + ancho * 0.95 );
		py[ 2 ] = ( int ) ( y + alto * 0.6 );

		Polygon p = new Polygon( px, py, 3 );
		pGraphics.fillPolygon( p );
		pGraphics.setColor( color );
		pGraphics.setStroke( new BasicStroke( 3 ) );

		double p1[] = new double[2];
		double p2[] = new double[2];

		p1[ 0 ] = .44;
		p1[ 1 ] = .20;

		p2[ 0 ] = .73;
		p2[ 1 ] = .60;

		pGraphics.drawLine( ( int ) ( x + ancho * p1[ 0 ] ), ( int ) ( y + alto * p1[ 1 ] ), ( int ) ( x + ancho * p2[ 0 ] ), ( int ) ( y + alto * p2[ 1 ] ) );

		p1[ 0 ] = .27;
		p1[ 1 ] = .28;

		p2[ 0 ] = .51;
		p2[ 1 ] = .60;

		pGraphics.drawLine( ( int ) ( x + ancho * p1[ 0 ] ), ( int ) ( y + alto * p1[ 1 ] ), ( int ) ( x + ancho * p2[ 0 ] ), ( int ) ( y + alto * p2[ 1 ] ) );

		px[ 1 ] = ( int ) ( x + ancho * 0.10 );
		py[ 1 ] = ( int ) ( y + alto * 0.34 );

		px[ 2 ] = ( int ) ( x + ancho * 0.31 );
		py[ 2 ] = ( int ) ( y + alto * 0.60 );

		p = new Polygon( px, py, 3 );
		pGraphics.fillPolygon( p );

	}

}
