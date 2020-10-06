package uniandes.cupi2.fabricaDeUniformes.mundo;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import uniandes.cupi2.fabricaDeUniformes.mundo.Camiseta.Manga;

public abstract class Logo extends Parte
{
	/**
	 * Constante que representa el ancho de la pantaloneta.
	 */
	private final static int ANCHO = 80;

	/**
	 * Constante que representa el alto de la pantaloneta.
	 */
	private final static int ALTO = 80;

	protected String texto;
	protected Color colorTexto;
	protected Color colorBorde;


	public Logo( int pX, int pY , String pTipo, Color pColor, String pTexto)
	{
		super( pX, pY, ALTO, ANCHO, pTipo, pColor );
		colorBorde = calcularColorMonocromatico( pColor, 0.8 );
		colorTexto= calcularColorMonocromatico( pColor, 0.8 );
		texto=pTexto;





	}
	public Logo( BufferedReader pLector, String pTipo ) throws Exception
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
		calcularColorTexto();
		colorBorde = Color.BLACK;
		texto=pLector.readLine();



	}
	public String darTexto()
	{
		return texto;

	}

	private void pintarTexto(Graphics2D pGraphics)
	{
		int centroX = Math.abs( x+20 );
		int centroY = Math.abs( y+70);


		pGraphics.setColor( Color.BLACK );
		pGraphics.drawString( texto, centroX, centroY );
	}

	public abstract void pintarDetalles( Graphics2D pGraphics );

	public void pintar(Graphics2D pGraphics)
	{

		pGraphics.drawOval(x, y, ANCHO, ALTO);
		pGraphics.setColor(color);
		pGraphics.fillOval(x, y, ANCHO, ALTO);
		
		
		pintarDetalles(pGraphics);
		pintarTexto(pGraphics);



	}

	public void guardar(PrintWriter out)
	{
		super.guardar(out);
		out.println(darTexto());

	}




	/**  * Calcula el color del texto a partir del color principal del logo.  */    
	protected void calcularColorTexto( )     
	{       colorTexto = Color.BLACK; 
	int brillo = ( int )Math.sqrt( color.getRed( ) * color.getRed( ) * .241 + color.getGreen( ) * color.getGreen( ) * .691 + color.getBlue( ) * color.getBlue( ) * .068 );      
	if(brillo<130)       
	{         
		colorTexto = Color.WHITE;       
	}
	}
}
