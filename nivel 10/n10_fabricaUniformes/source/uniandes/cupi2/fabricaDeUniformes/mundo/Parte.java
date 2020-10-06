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
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.sun.prism.Graphics;

import uniandes.cupi2.fabricaDeUniformes.mundo.Camiseta.Manga;

/**
 * Clase abstracta que representa una parte del uniforme.
 */
public abstract class Parte implements IParte
{

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * El ancho de la parte.
	 */
	protected int ancho;

	/**
	 * El alto de la parte.
	 */
	protected int alto;

	/**
	 * La coordenada x de la parte.
	 */
	protected int x;

	/**
	 * La coordenada y de la parte.
	 */
	protected int y;

	/**
	 * El tipo de la parte.
	 */
	protected String tipo;

	/**
	 * El color base del de la parte.
	 */
	protected Color color;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * Crea la parte con los valores especificados.
	 * @param pX Coordenada x de la parte - pX >= 0.
	 * @param pY Coordenada y de la parte - pY >= 0.
	 * @param pAlto Alto de la parte - pAlto >= 0.
	 * @param pAncho Ancho de la parte - pAncho >= 0.
	 * @param pTipo Tipo de la parte. pTipo != null && pTipo != "".
	 * @param pColor - Color de la parte - pColor != null.
	 */
	public Parte( int pX, int pY, int pAlto, int pAncho, String pTipo, Color pColor )
	{
		x = pX;
		y = pY;
		alto = pAlto;
		ancho = pAncho;
		color = pColor;
		tipo = pTipo;
		verificarInvariante( );
	}

	/**
	 * Crea la parte a partir de los datos contenidos en el archivo.
	 * @param pStream - Stream que sirve para leer el archivo - pStream != null
	 * @param pAlto - Altura de la parte - pAlto >= 0
	 * @param pAncho - Ancho de la parte - pAncho >= 0
	 * @param pTipo Tipo de la parte. pTipo != null && pTipo != "".
	 * @throws Exception - Se lanza una excepción si hay problemas leyendo el archivo o si el formato del archivo no es el esperado.
	 */
	public Parte( BufferedReader pStream, int pAlto, int pAncho, String pTipo ) throws Exception
	{
		String lineaPuntos = pStream.readLine( );
		String strColor;
		try
		{
			inicializarPuntos( lineaPuntos );
			strColor = pStream.readLine( );
		}
		catch( IOException fie )
		{
			throw new Exception( "Error al leer el archivo" );
		}
		alto = pAlto;
		ancho = pAncho;
		color = new Color( Integer.parseInt( strColor ) );
		tipo = pTipo;
		verificarInvariante( );
	}

	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------

	/**
	 * Inicializa los puntos del dibujo a partir de la línea que estaba en el archivo. <br>
	 * <b>post: </b> Las coordenadas x, y tienen nuevos valores.
	 * @param pLineaPuntos Línea del archivo donde se encuentran los puntos. pLineaPuntos != null y pLineaPuntos != "".
	 * @throws Exception Se lanza una excepción si hay problemas leyendo el archivo o si el formato del archivo no es el esperado.
	 */
	private void inicializarPuntos( String pLineaPuntos ) throws Exception
	{
		String[] strValores = pLineaPuntos.split( ";" );
		if( strValores.length != 2 )
		{
			throw new Exception( "Error al leer la línea " + pLineaPuntos );
		}
		try
		{
			x = Integer.parseInt( strValores[ 0 ] );
			y = Integer.parseInt( strValores[ 1 ] );
		}
		catch( NumberFormatException nfe )
		{
			throw new Exception( "Error al leer la línea " + pLineaPuntos );
		}
	}

	/**
	 * Retorna la coordenada en x de la parte.
	 * @return Coordenada en x de la parte.
	 */
	public int darX( )
	{
		return x;
	}

	/**
	 * Retorna la coordenada en y de la parte.
	 * @return Coordenada en y de la parte.
	 */
	public int darY( )
	{
		return y;
	}

	/**
	 * Retorna el ancho de la parte.
	 * @return Ancho de la parte.
	 */
	public int darAncho( )
	{
		return ancho;
	}

	/**
	 * Retorna el alto de la parte.
	 * @return Alto de la parte.
	 */
	public int darAlto( )
	{
		return alto;
	}

	/**
	 * Retorna el tipo de la parte.
	 * @return El tipo de la parte.
	 */
	public String darTipo( )
	{
		return tipo;
	}

	/**
	 * Retorna el color de la parte.
	 * @return Color de la parte.
	 */
	public Color darColor( )
	{
		return color;
	}

	/**
	 * Indica si un punto está dentro de un dibujo.
	 * @param pX Es la coordenada pX del punto buscado.
	 * @param pY Es la coordenada pY del punto buscado.
	 * @return Retorna true si el punto está dentro de la parte, false en caso contrario.
	 */
	public boolean estaDentro( int pX, int pY )
	{
		Rectangle2D rectangulo = new Rectangle2D.Double( x, y, ancho, alto );
		return rectangulo.contains( pX, pY );
	}

	/**
	 * Cambia la coordenada x de la figura.
	 * @param pX - Nueva coordenada x de la figura - pX >= 0.
	 */
	public void cambiarX( int pX )
	{
		x = pX;
		verificarInvariante();
	}

	/**
	 * Cambia la coordenada y de la parte.
	 * @param pY Nueva coordenada y de la parte. pY >= 0.
	 */
	public void cambiarY( int pY )
	{
		y = pY;
		verificarInvariante();
	}

	/**
	 * Pinta la parte.<br>
	 * <b>post: </b> Se dibujó la parte en el lienzo.
	 * @param pGraphics La superficie donde se debe pintar la parte. pGraphics != null
	 */
	// TODO HECHO Parte2 PuntoA. Declare método abstracto pintar.
	public abstract void pintar(Graphics2D pGraphics);

	/**
	 * Pinta la parte sombreada.<br>
	 * <b>post: </b> Se pintó la parte sombreada en el lienzo.
	 * @param pGraphics Superficie donde se debe pintar. pGraphics != null.
	 */
	public void pintarSombreado( Graphics2D pGraphics )
	{
		pintar( pGraphics );
		verificarInvariante();
	}

	/**
	 * Pinta la parte como seleccionada. <br>
	 * <b>post: </b> Se pintó el contorno de la parte seleccionada en el lienzo.
	 * @param pGraphics Superficie donde se pinta el rectángulo. pGraphics != null.
	 */
	public void pintarSeleccionada( Graphics2D pGraphics )
	{
		float[] dash = { 30, 10, 10, 10 };
		pGraphics.setColor( Color.black );
		BasicStroke stroke = new BasicStroke( 5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, dash, 0 );
		pGraphics.setStroke( stroke );
		pGraphics.drawRect( x, y, ancho, alto );
		pGraphics.setStroke( new BasicStroke( 1 ) );
		verificarInvariante();
	}

	/**
	 * Calcula el color monocromático según el porcentaje dado.<br>
	 * <b>Nota: </br>
	 * Para calcular un color similar se requiere multiplicar cada componente por el factor dado.
	 * @param pColor Color base. pColor != null.
	 * @param pFactor Factor con el cual se calculará el color.
	 * @return Color nuevo de acuerdo al factor dado.
	 */
	protected Color calcularColorMonocromatico( Color pColor, double pFactor )
	{
		return new Color( ( int ) ( pFactor * pColor.getRed( ) ), ( int ) ( pFactor * pColor.getGreen( ) ), ( int ) ( pFactor * pColor.getBlue( ) ) );
	}

	/**
	 * Guarda la parte en un archivo.<br>
	 * <b>post: </b> Se guardó la parte en el archivo.
	 * @param pEscritor Stream donde se va a guardar la parte. pEscritor != null.
	 */
	public void guardar( PrintWriter out )
	{

		out.println( darTipo() );
		out.println( x +";"+ y );
		out.println( color.getRGB() );


		// TODO PENDIENTE Parte2 PuntoB. Complete el método guardar según la documentación dada.
	}

	/**
	 * Verifica el invariante de la clase <br>
	 * <b>inv: </b><br>
	 * x >=0 <br>
	 * y>=0<br>
	 * ancho>0<br>
	 * alto >0 <br>
	 */
	public void verificarInvariante( )
	{
		assert ( x >= 0 ) : "La coordenada x es invÃ¡lida";
		assert ( y >= 0 ) : "La coordenada y es invÃ¡lida";
		assert ( ancho > 0 ) : "El ancho es invÃ¡lido";
		assert ( alto > 0 ) : "El alto es invÃ¡lido";
	}
}
