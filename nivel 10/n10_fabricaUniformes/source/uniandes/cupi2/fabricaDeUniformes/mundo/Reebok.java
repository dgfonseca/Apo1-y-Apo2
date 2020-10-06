package uniandes.cupi2.fabricaDeUniformes.mundo;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Line2D;
import java.io.BufferedReader;

public class Reebok extends Logo
{




	// -------------------------------------------------------------
	// Constantes
	// -------------------------------------------------------------

	/**
	 * Constante que representa el tipo Adidas.
	 */
	public final static String TIPO = "Reebok";

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
	public Reebok( int pX, int pY, Color pColor, String pTexto )
	{
		super( pX, pY, TIPO, pColor, pTexto );
	}

	/**
	 * Crea un nuevo logo de Adidas a partir de la información de los datos contenidos en el archivo.<br>
	 * @param pLector Stream que sirve para leer el archivo. pLector != null.
	 * @throws Exception Se lanza una excepción si hay problemas leyendo el archivo o si el formato del archivo no es el esperado.
	 */
	public Reebok( BufferedReader pLector ) throws Exception
	{
		super( pLector, TIPO );
	}

	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------

	public void pintarDetalles( Graphics2D pGraphics )
	{

		Polygon trianguloRojo1 = new Polygon();
		trianguloRojo1.addPoint(x+15, y+50); 
		trianguloRojo1.addPoint(x+65, y+50);
		trianguloRojo1.addPoint(x+40, y+7);
		pGraphics.setColor(Color.RED);
		pGraphics.fill(trianguloRojo1);
		pGraphics.drawPolygon(trianguloRojo1);

	   Line2D linea = new Line2D.Double(x+40, y+5,x+ 40, y+29 );
		pGraphics.setColor( color );
		pGraphics.setStroke(new BasicStroke(4));
		pGraphics.draw( linea );
		
		Line2D linea2 = new Line2D.Double(x+15, y+50, x+40 ,y+35);
		pGraphics.setColor( color );
		pGraphics.setStroke(new BasicStroke(4));
		pGraphics.draw( linea2 );
		
		Line2D linea3 = new Line2D.Double(x+65, y+50, x+40 ,y+35);
		pGraphics.setColor( color );
		pGraphics.setStroke(new BasicStroke(4));
		pGraphics.draw( linea3 );

		Polygon trianguloc = new Polygon();
		trianguloc.addPoint(x+32, y+40);
		trianguloc.addPoint(x+49, y+40);
		trianguloc.addPoint(x+40, y+26);
		pGraphics.setColor(color);
		pGraphics.fill(trianguloc);
		pGraphics.drawPolygon(trianguloc);
		

	}

}


