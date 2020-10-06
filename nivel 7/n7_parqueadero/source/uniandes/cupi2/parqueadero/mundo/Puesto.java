/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogot� - Colombia)
 * Departamento de  Ingenier�a  de  Sistemas    y   Computaci�n
 * Licenciado   bajo    el  esquema Academic Free License versi�n 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_Parqueadero
 * Autor: Equipo Cupi2 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.parqueadero.mundo;

/**
 * Esta clase representa un puesto en el parqueadero. <br>
 * TODO HECHO Parte 1 Punto C: Documente la invariante de la clase.
 * <b>inv: </b> <br>
 * NumeroPuesto !=null<br>
 * NumeroPuesto >=0
 * 
 * Dos puestos no pueden tener el mismo Numero
 * 
 */
public class Puesto
{
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Carro parqueado en el puesto. Si no hay ninguno, carro == null.
	 */
	private Carro carro;

	/**
	 * N�mero del puesto dentro del parqueadero.
	 */
	private int numeroPuesto;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Crea un puesto vac�o. <br>
	 * <b>post: </b> Se cre� un puesto vac�o y se le asign� su n�mero de puesto.
	 * @param pPuesto N�mero de puesto.
	 */
	public Puesto( int pPuesto )
	{
		carro = null;
		numeroPuesto = pPuesto;
	}

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------

	/**
	 * Retorna el carro del puesto. Si no hay ning�n carro retorna null.
	 * @return El carro que ocupa el puesto.
	 */
	public Carro darCarro( )
	{
		return carro;
	}


	/**
	 * Retorna el n�mero del puesto.
	 * @return El n�mero asignado al puesto.
	 */
	public int darNumeroPuesto( )
	{
		return numeroPuesto;
	}

	/**
	 * Indica si el puesto est� ocupado.
	 * @return Retorna true si el puesto est� ocupado. Retorna false en caso contrario.
	 */
	public boolean estaOcupado( )
	{
		boolean ocupado = carro != null;
		return ocupado;
	}

	/**
	 * Ingresa un carro en el puesto. <br>
	 * <b>pre: </b> El puesto est� vac�o. <br>
	 * <b>post: </b> El puesto ahora est� ocupado por el carro pCarro.
	 * @param pCarro Carro que est� ingresando. pCarro != null.
	 */
	public void ingresarCarro( Carro pCarro )
	{
		carro = pCarro;
	}

	/**
	 * Saca el carro del puesto. <br>
	 * <b>post: </b> El puesto est� vac�o.
	 */
	public void sacarCarro( )
	{
		carro = null;
	}

	/**
	 * Indica si la placa del carro parqueado en el puesto coincide con la placa recibida.
	 * @param pPlaca Placa a comparar.
	 * @return Retorna true si las placas coinciden, false en caso contrario, o si no hay ning�n carro en el puesto.
	 */
	public boolean tieneCarroConPlaca( String pPlaca )
	{
		boolean tieneCarro = false;

		if( carro != null && carro.tienePlaca( pPlaca ) )
		{
			tieneCarro = true;
		}

		return tieneCarro;
	}
	public boolean numeroValido()
	{
		int var = numeroPuesto;
		return numeroPuesto >=0 && numeroPuesto!=var;

	}
	// -----------------------------------------------------------------
	// Invariante
	// -----------------------------------------------------------------

	// TODO HECHO Parte 1 Punto D: Documente e implemente la invariante de la clase.

	/**
	 * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un AssertionError. <br>
	 * <b>inv: </b> numero no es menor a 0 ni esta repetido
	 */
	private void verificarInvariante()
	{
		assert numeroValido() : "El Numero es invalido";

	}

}