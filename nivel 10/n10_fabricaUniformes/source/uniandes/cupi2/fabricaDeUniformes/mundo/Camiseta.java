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

import uniandes.cupi2.fabricaDeUniformes.mundo.Camiseta.Manga;

/**
 * Clase abstracta que representa una camiseta.
 */
public abstract class Camiseta extends Parte
{

	// -----------------------------------------------------------------
	// Enumeraciones
	// -----------------------------------------------------------------

	/**
	 * Enumeración que define los posibles tipos de manga.
	 */
	public enum Manga
	{
		/**
		 * Manga CORTA.
		 */
		CORTA,

		/**
		 * Manga LARGA.
		 */
		LARGA
	}

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Constante para definir el ancho de la camiseta.
	 */
	public final static int ANCHO = 132;

	/**
	 * Constante para definir el alto de la camiseta.
	 */
	public final static int ALTO = 200;

	/**
	 * Color secundario de la camiseta.
	 */
	protected Color colorSecundario;

	/**
	 * Tipo de manga de la camiseta.
	 */
	protected Manga manga;

	// -------------------------------------------------------------
	// Constructores
	// -------------------------------------------------------------

	/**
	 * Crea un nuevo personaje con la información recibida por parámetro.<br>
	 * <b>post: </b> Se inicializaron los atributos x, y, tipo y color de la clase padre con los valores dados por parámetro.<br>
	 * Se inicializaron los atributos alto y ancho de la clase padre con los valores definidos para una camiseta.<br>
	 * El colorSecundario se inicializó con un color monocromático usando el factor 0.8. El tipo de manga se inicializó en CORTA.
	 * @param pX Coordinada en x del personaje. pX >= 0.
	 * @param pY Coordinada en y del personaje. pY >= 0.
	 * @param pTipo Tipo de la camiseta. pTipo == {CamisetaConRaya.TIPO, CamisetaCuadros.Tipo, CamisetaFranjas.TIPO}.
	 * @param pColor Color de la camiseta. pColor != null.
	 */
	public Camiseta( int pX, int pY, String pTipo, Color pColor )
	{
		super( pX, pY, ALTO, ANCHO, pTipo, pColor );
		colorSecundario = calcularColorMonocromatico( pColor, 0.8 );
		manga = Manga.CORTA;
	}

	/**
	 * Crea una nueva camiseta a partir de la información de los datos contenidos en el archivo.
	 * @param pLector Stream que sirve para leer el archivo. pLector != null.
	 * @param pTipo Tipo del marco. pTipo == {MarcoNube.TIPO, MarcoInferior.Tipo, MarcoSuperior.TIPO}.
	 * @throws Exception Se lanza una excepción si hay problemas leyendo el archivo o si el formato del archivo no es el esperado.
	 */
	public Camiseta( BufferedReader pLector, String pTipo ) throws Exception
	{
		super( pLector, ALTO, ANCHO, pTipo );
		String strColor;
		try
		{
			strColor = pLector.readLine( );
		}
		catch( IOException fie )
		{
			throw new Exception( "Error al leer el archivo." );
		}
		colorSecundario = new Color( Integer.parseInt( strColor ) );

		String strManga = pLector.readLine( );
		switch( strManga )
		{
		case "CORTA":
			manga = Manga.CORTA;
			break;
		case "LARGA":
			manga = Manga.LARGA;
			break;

		default:
			throw new Exception( "El tipo de manga " + strManga + " no es válido." );
		}

	}

	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------

	/**
	 * Retorna el color secundario de la camiseta.
	 * @return Color secundario de la camiseta.
	 */
	public Color darColorSecundario( )
	{
		return colorSecundario;
	}

	/**
	 * Retorna el tipo de manga de la camiseta.
	 * @return Tipo de manga de la camiseta.
	 */
	public Manga darManga( )
	{
		return manga;
	}

	/**
	 * Cambia el color secundario de la camiseta por el color dado por parámetro.<br>
	 * <b>post: </b> Se cambió el colorSecundario por el nuevo color.
	 * @param pColor
	 */
	public void cambiarColor2( Color pColor )
	{
		colorSecundario = pColor;
	}

	/**
	 * Cambia el tipo de manga de la camiseta por el tipo dado por parámetro.<br>
	 * <b>post: </b>Se cambió el tipo de manga por el nuevo tipo.
	 * @param pManga Nuevo tipo de manga. pManga != null && pManga == {Manga.CORTA, Manga.LARGA}.
	 */
	public void cambiarManga( Manga pManga )
	{
		manga = pManga;
	}

	/**
	 * Pinta la parte.<br>
	 * <b>post: </b> Se dibujó la parte en el lienzo.
	 * @param pGraphics La superficie donde se debe pintar la parte. pGraphics != null
	 */
	public void pintar( Graphics2D pGraphics )
	{
		// TODO HECHO Parte3 PuntoA. Completar el método según la documentación dada.



		BasicStroke continuo = new BasicStroke( 5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1, new float[]{ 10f, 0f }, 0 );
		pGraphics.setStroke( continuo );
		pGraphics.setColor( color );
		pGraphics.drawRect(x, y, ANCHO, ALTO);
		pGraphics.fillRect(x, y, ANCHO, ALTO);

		pintarDetalles(pGraphics);


	}




	/**
	 * Pinta los detalles de la parte. <b>post: </b> Se dibujó la parte en el lienzo.
	 * @param pGraphics La superficie donde se deben pintar los detalles de la parte. pGraphics != null
	 */
	public abstract void pintarDetalles( Graphics2D pGraphics );

	@Override
	public void pintarSeleccionada( Graphics2D pGraphics )
	{

		int largoManga = ( int ) ( alto * ( manga == Manga.CORTA ? 0.4 : 0.85 ) );
		int w = ( int ) ( largoManga * Math.cos( Math.toRadians( 30 ) ) );

		float[] dash = { 30, 10, 10, 10 };
		pGraphics.setColor( Color.black );
		BasicStroke stroke = new BasicStroke( 5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, dash, 0 );
		pGraphics.setStroke( stroke );
		pGraphics.drawRect( x - w, y, ancho + w * 2, alto );
		pGraphics.setStroke( new BasicStroke( 1 ) );

	}

	@Override
	public boolean estaDentro( int pX, int pY )
	{
		int largoManga = ( int ) ( alto * ( manga == Manga.CORTA ? 0.4 : 0.85 ) );
		int w = ( int ) ( largoManga * Math.cos( Math.toRadians( 30 ) ) );
		Rectangle2D rectangulo = new Rectangle2D.Double( x - w, y, ancho + w * 2, alto );
		return rectangulo.contains( pX, pY );
	}

	@Override
	public void guardar( PrintWriter pEscritor )
	{
		super.guardar(pEscritor);
		pEscritor.println(colorSecundario.getRGB());
		pEscritor.println(darManga());
		// TODO HECHO Parte3 PuntoB. Completar el método según la documentación dada.
	}
}

