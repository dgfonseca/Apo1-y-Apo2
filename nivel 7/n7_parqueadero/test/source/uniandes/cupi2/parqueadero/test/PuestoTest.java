/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_parqueadero
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.parqueadero.test;

import org.junit.Test;
import static org.junit.Assert.*;
import uniandes.cupi2.parqueadero.mundo.Carro;
import uniandes.cupi2.parqueadero.mundo.Puesto;

/**
 * Pruebas para la clase Puesto
 */
public class PuestoTest
{

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * El puesto para el escenario 1
	 */
	private Puesto puesto1;

	/**
	 * El carro para escenario 1
	 */
	private Carro carro1;

	/**
	 * El puesto para el escenario 2
	 */
	private Puesto puesto2;

	/**
	 * El carro para el escenario 2
	 */
	private Carro carro2;

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------

	/**
	 * Inicializa el escenario 1: un puesto y un carro, pero el puesto est� vac�o
	 */
	private void setupEscenario1( )
	{
		carro1 = new Carro( "aaa111", 6, "marca111", "modelo111" );
		puesto1 = new Puesto( 1 );
	}

	/**
	 * Inicializa el escenario 2: un puesto y un carro parqueado en el puesto
	 */
	private void setupEscenario2( )
	{
		carro2 = new Carro( "bbb222", 6, "marca222", "modelo222" );
		puesto2 = new Puesto( 2 );
		puesto2.ingresarCarro( carro2 );
	}

	/**
	 * Probar que el m�todo darCarro retorna lo esperado para un puesto vac�o
	 */
	@Test
	public void testDarCarro1( )
	{
		setupEscenario1( );

		assertNull( "El puesto1 est� vac�o pero darCarro no retorn� null", puesto1.darCarro( ) );
	}

	/**
	 * Probar que el m�todo darCarro retorna lo esperado para un puesto ocupado
	 */
	@Test
	public void testDarCarro2( )
	{
		setupEscenario2( );

		assertTrue( "El puesto 2 no retorn� el carro que se esperaba", carro2 == puesto2.darCarro( ) );
	}

	/**
	 * Probar el m�todo darNumeroPuesto
	 */
	@Test
	public void testDarNumeroPuesto( )
	{
		setupEscenario1( );

		assertEquals( "El n�mero retornado es incorrecto", 1, puesto1.darNumeroPuesto( ) );
	}

	/**
	 * Probar el m�todo estaOcupado
	 */
	@Test
	public void testEstaOcupado( )
	{
		setupEscenario1( );
		setupEscenario2( );

		assertFalse( "El puesto 1 deber�a estar desocupado", puesto1.estaOcupado( ) );
		assertTrue( "El puesto 2 deber�a estar ocupado", puesto2.estaOcupado( ) );
	}

	/**
	 * Probar a parquear un carro en un puesto vac�o
	 */
	@Test
	public void testParquearCarro( )
	{
		setupEscenario1( );

		assertNull( "El puesto 1 est� vac�o pero darCarro no retorn� null", puesto1.darCarro( ) );
		puesto1.ingresarCarro( carro1 );
		assertTrue( "El puesto 1 no retorn� el carro que se esperaba: el carro no qued� parqueado", carro1 == puesto1.darCarro( ) );
		assertTrue( "El puesto 1 deber�a estar ocupado", puesto1.estaOcupado( ) );
	}

	/**
	 * Probar a sacar un carro del puesto
	 */
	@Test
	public void testSacarCarro( )
	{
		setupEscenario2( );

		assertTrue( "El puesto 2 no retorn� el carro que se esperaba", carro2 == puesto2.darCarro( ) );
		puesto2.sacarCarro( );
		assertNull( "El puesto 2 deber�a estar vac�o pero darCarro no retorn� null", puesto2.darCarro( ) );
		assertFalse( "El puesto 2 deber�a estar desocupado", puesto2.estaOcupado( ) );
	}

	/**
	 * Probar el m�todo tieneCarroConPlaca
	 */
	@Test
	public void testTieneCarroConPlaca( )
	{
		setupEscenario2( );

		assertFalse( "El puesto encontr� la placa de un carro que no est� parqueado ah�", puesto2.tieneCarroConPlaca( "aaa111" ) );
		assertTrue( "El puesto no encontr� la placa del carro que est� parqueado ah�", puesto2.tieneCarroConPlaca( "bbb222" ) );
	}
}
