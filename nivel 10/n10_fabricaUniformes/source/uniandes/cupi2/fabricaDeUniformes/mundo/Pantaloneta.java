package uniandes.cupi2.fabricaDeUniformes.mundo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;

public class Pantaloneta extends Parte
{
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Constante que representa el tipo pantaloneta.
	 */
	public final static String TIPO = "Pantaloneta";

	/**
	 * Constante que representa el ancho de la pantaloneta.
	 */
	private final static int ANCHO = 132;

	/**
	 * Constante que representa el alto de la pantaloneta.
	 */
	private final static int ALTO = 120;

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
	public Pantaloneta( int pX, int pY, Color pColor, String pTipo )
	{
		super(pX, pY, ALTO, ANCHO, pTipo, pColor);


	}

	/**
	 * Crea una nueva camiseta rayada a partir de la información de los datos contenidos en el archivo.<br>
	 * @param pLector Stream que sirve para leer el archivo. pLector != null.
	 * @throws Exception Se lanza una excepción si hay problemas leyendo el archivo o si el formato del archivo no es el esperado.
	 */
	public Pantaloneta( BufferedReader pLector ) throws Exception
	{
		super( pLector, ANCHO, ALTO, TIPO);
	}


	public void pintar(Graphics2D pGraphics)
	{
		pGraphics.setColor(color);

		pGraphics.fillRect(x, y, (int)ancho/2-3, alto);
		pGraphics.fillRect(x+ancho/2+3, y, (int)ancho/2-3, alto);
		pGraphics.fillRect(x, y, ancho, (int)alto/2);












	}
}
