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

import java.util.ArrayList;

import uniandes.cupi2.parqueadero.mundo.Carro;
import uniandes.cupi2.parqueadero.mundo.Parqueadero;

/**
 * Clase de prueba para el Parqueadero
 */
public class ParqueaderoTest
{
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Parqueadero para el escenario 1
	 */
	private Parqueadero parqueadero1;

	/**
	 * Parqueadero para el escenario 2
	 */
	private Parqueadero parqueadero2;

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------

	/**
	 * Construir el escenario 1
	 */
	private void setupEscenario1( )
	{
		parqueadero1 = new Parqueadero( );
	}

	/**
	 * Construir el escenario 2
	 */
	private void setupEscenario2( )
	{
		parqueadero2 = new Parqueadero( );
		try
		{
			parqueadero2.ingresarCarro( "ppp111", "Renault", "4" );
			parqueadero2.avanzarHora( );
			parqueadero2.ingresarCarro( "ppp222", "Rene", "Logan" );
			parqueadero2.avanzarHora( );
			parqueadero2.ingresarCarro( "ppp333", "Mazda", "2011" );
			parqueadero2.avanzarHora( );
			parqueadero2.ingresarCarro( "ppp444", "Pegueot", "2015" );
		}
		catch( Exception e )
		{
			fail( "No deber�a generar excepci�n." );
		}
	}

	/**
	 * Verificar que la hora avance correctamente
	 */
	@Test
	public void testAvanzarHora( )
	{
		setupEscenario1( );

		int horaActual1 = parqueadero1.darHoraActual( );
		parqueadero1.avanzarHora( );
		int horaActual2 = parqueadero1.darHoraActual( );
		assertEquals( "La hora no avanza correctamente", horaActual1 + 1, horaActual2 );
	}

	/**
	 * Verificar que el n�mero de puestos libres se calcule correctamente
	 */
	@Test
	public void testCalcularPuestosLibres( )
	{
		setupEscenario1( );
		setupEscenario2( );

		assertEquals( "El parqueadero vac�o no tiene el n�mero correcto de puestos libres", Parqueadero.TAMANO, parqueadero1.calcularCantidadPuestosLibres( ) );

		assertEquals( "El parqueadero no-vac�o no tiene el n�mero correcto de puestos libres", Parqueadero.TAMANO - 4, parqueadero2.calcularCantidadPuestosLibres( ) );

		// Llenar el parqueadero
		for( int i = 0; i < Parqueadero.TAMANO; i++ )
		{
			try
			{
				if( i <= 9 )
				{
					parqueadero1.ingresarCarro( "ppppp" + i, "Marca" + i, "Modelo" + i );
				}
				else
				{
					parqueadero1.ingresarCarro( "pppp" + i, "Marca" + i, "Modelo" + i );
				}
			}
			catch( Exception e )
			{
				fail( "No deber�a generar excepci�n" );
			}
			assertEquals( "El parqueadero no-vac�o no tiene el n�mero correcto de puestos libres", Parqueadero.TAMANO - (i + 1), parqueadero1.calcularCantidadPuestosLibres( ) );
		}

		// Verificar que despues de lleno el parqueadero no recibe m�s carros ni cambia el
		// n�mero de puestos disponibles
		try
		{
			parqueadero1.ingresarCarro( "aaaaa" + 0, "Marca" + 0, "Modelo" + 0 );
		}
		catch( Exception e )
		{
			//Debe generar excepci�n.
		}

		assertEquals( "El parqueadero lleno no tiene el n�mero correcto de puestos libres", 0, parqueadero1.calcularCantidadPuestosLibres( ) );

	}

	/**
	 * Verificar que la tarifa se pueda cambiar
	 */
	@Test
	public void testCambiarTarifa( )
	{
		setupEscenario1( );

		int viejaTarifa = parqueadero1.darTarifa( );
		int nuevaTarifa = 2000;

		parqueadero1.cambiarTarifa( nuevaTarifa );
		assertTrue( "La tarifa no fue modificada", viejaTarifa != nuevaTarifa && parqueadero1.darTarifa( ) == nuevaTarifa );
	}

	/**
	 * Verificar que el monto en caja se calcule correctamente
	 */
	@Test
	public void testDarMontoCaja( )
	{
		setupEscenario1( );

		int tarifa = parqueadero1.darTarifa( );
		int montoEsperado = 0;
		assertTrue( "El monto inicial deber�a ser 0", montoEsperado == parqueadero1.darMontoCaja( ) );

		try
		{
			// Carro que entra y sale
			parqueadero1.ingresarCarro( "ppp111", "Marcappp111", "Modeloppp111" );
			parqueadero1.sacarCarro( "ppp111" );
			montoEsperado += tarifa;
			assertTrue( "Un carro durante una hora deber�a representar 1000", montoEsperado == parqueadero1.darMontoCaja( ) );

			// Carro que se demora una hora
			parqueadero1.ingresarCarro( "ppp222", "Marcappp222", "Modeloppp222" );
			parqueadero1.avanzarHora( );
			parqueadero1.sacarCarro( "ppp222" );
			montoEsperado += tarifa * 2;
			assertTrue( "Un carro durante dos horas deber�a representar 2000 m�s", montoEsperado == parqueadero1.darMontoCaja( ) );
		}
		catch( Exception e )
		{
			fail( "No deber�a generar excepci�n." );
		}
	}

	/**
	 * Verifica la entrada normal de carros
	 */
	@Test
	public void testEntrarCarro1( )
	{
		setupEscenario1( );

		// Parquear un carro
		try
		{
			int pos1 = parqueadero1.ingresarCarro( "ppp111", "Marcappp111", "Modeloppp111" );
			assertTrue( "El puesto que se le asign� al carro aparece como no ocupado", parqueadero1.estaOcupado( pos1 ) );
		}
		catch( Exception e )
		{
			fail( "No permite entrar un carro al parqueadero abierto y vac�o." );
		}

		try
		{
			parqueadero1.sacarCarro( "ppp111" );
		}
		catch( Exception e )
		{
			fail( "No permite sacar el carro." );
		}

	}

	/**
	 * Verifica que durante la entrada de carros a ninguno se le asigna un puesto que ya se hab�a asignado
	 */
	@Test
	public void testEntrarCarro2( )
	{
		setupEscenario1( );

		// Verificar que a ning�n otro carro se le asigna la misma posici�n de un carro ya
		// parqueado
		boolean[] vacios = new boolean[Parqueadero.TAMANO];

		for( int i = 0; i < Parqueadero.TAMANO * 2; i++ )
		{
			if(i >= Parqueadero.TAMANO)
			{
				try
				{
					parqueadero1.ingresarCarro( "pppp" + i, "Marca" + i, "Modelo" + i );
					fail("Debe generar excepci�n.");
				}
				catch( Exception e )
				{
					//Debe generar excepci�n.
				}
			}
			else
			{
				try
				{
					if( i <= 9 )
					{
						parqueadero1.ingresarCarro( "ppppp" + i, "Marca" + i, "Modelo" + i );
					}
					else
					{
						parqueadero1.ingresarCarro( "pppp" + i, "Marca" + i, "Modelo" + i );
					}
				}
				catch( Exception e )
				{
					fail( "No est� permitiendo ingresar carros." );
				}
			}
		}
	}

	/**
	 * Verifica que durante la entrada de carros si el parqueadero est� lleno siempre se informa de esto y que si hay un carro que sale entonces el siguiente carro que llegue
	 * puede parquear
	 */
	@Test
	public void testEntrarCarro3( )
	{
		setupEscenario1( );

		// Llenar el parqueadero
		for( int i = 0; i < Parqueadero.TAMANO * 2; i++ )
		{
			if( i >= Parqueadero.TAMANO )
			{
				try
				{
					parqueadero1.ingresarCarro( "ppppp" + i, "m" + i, "p" + i );
					fail( "No lanza excepci�n al entrar un carro al parqueadero lleno." );
				}
				catch( Exception e )
				{
					// Debe lanzar excepci�n.
				}
			}
			else
			{
				try
				{
					if( i <= 9 )
					{
						parqueadero1.ingresarCarro( "ppppp" + i, "Marca" + i, "Modelo" + i );
					}
					else
					{
						parqueadero1.ingresarCarro( "pppp" + i, "Marca" + i, "Modelo" + i );
					}
				}
				catch( Exception e )
				{
					fail( "No deber�a lanzar excepci�n" );
				}
			}

		}

		try
		{
			parqueadero1.sacarCarro( "ppp0" );
			parqueadero1.ingresarCarro( "nuevo", "marca", "modelo" );
			fail( "No lanza excepci�n al ingresar un carro al parqueadero lleno." );
		}
		catch( Exception e )
		{
			// Debe lanzar excepci�n.
		}
	}

	/**
	 * Verifica que no se puede entrar carros cuando el parqueadero est� cerrado
	 */
	@Test
	public void testEntrarCarro4( )
	{
		setupEscenario1( );

		while( parqueadero1.estaAbierto( ) )
			parqueadero1.avanzarHora( );

		try
		{
			parqueadero1.ingresarCarro( "placa", "marca", "modelo" );
			fail( "No lanza excepci�n al ingresar un carro al parqueadero cerrado." );
		}
		catch( Exception e )
		{
			// Debe lanzar excepci�n.
		}
	}

	/**
	 * Verifica que no se puede parquear dos carros con la misma placa en el parqueadero
	 */
	@Test
	public void testEntrarCarro5( )
	{
		setupEscenario2( );

		// Parquear un carro
		try
		{
			parqueadero2.ingresarCarro( "ppp111", "ppp111", "ppp111" );
			fail( "No lanza excepci�n al ingresar un carro al parqueadero donde ya existe un carro con la placa especificada." );
		}
		catch( Exception e )
		{
			// Debe lanzar excepci�n.
		}
	}

	/**
	 * Verifica el m�todo estaAbierto
	 */
	@Test
	public void testEstaAbierto( )
	{
		setupEscenario1( );

		for( int i = parqueadero1.darHoraActual( ); i < Parqueadero.HORA_CIERRE + 2; i++ )
		{
			int actual = parqueadero1.darHoraActual( );
			if( actual >= Parqueadero.HORA_INICIAL && actual < Parqueadero.HORA_CIERRE )
			{
				assertTrue( "El parqueadero est� cerrado durante el tiempo que deber�a esta abierto", parqueadero1.estaAbierto( ) );
			}
			else
			{
				assertFalse( "El parqueadero est� abierto en una hora en la que deber�a esta cerrado", parqueadero1.estaAbierto( ) );
			}

			parqueadero1.avanzarHora( );
		}
	}

	/**
	 * Verificar que el estado ocupado o no de cada puesto se maneja correctamente
	 */
	@Test
	public void testEstaOcupado( )
	{
		setupEscenario1( );

		// Verificar que las posiciones que se asignan quedan marcadas como ocupadas
		int[] posiciones = new int[Parqueadero.TAMANO];

		for( int i = 0; i < Parqueadero.TAMANO; i++ )
		{
			try
			{
				if( i <= 9 )
				{
					parqueadero1.ingresarCarro( "ppppp" + i, "Marca" + i, "Modelo" + i );
				}
				else
				{
					parqueadero1.ingresarCarro( "pppp" + i, "Marca" + i, "Modelo" + i );
				}
			}
			catch( Exception e )
			{
				fail( "No deber�a generar excepci�n." );
			}
			assertTrue( "La posici�n del nuevo carro no aparece marcada como ocupada", parqueadero1.estaOcupado( posiciones[ i ] ) );
		}

		// Sacar todos los carros del parqueadero y verificar que todas las posiciones
		// quedaron marcadas como vacias
		for( int i = 0; i < Parqueadero.TAMANO; i++ )
		{
			try
			{
				if( i <= 9 )
				{
					parqueadero1.sacarCarro( "ppppp" + i );
				}
				else
				{
					parqueadero1.sacarCarro( "pppp" + i );
				}
			}
			catch( Exception e )
			{
				fail( "No deber�a generar excepci�n." );
			}
			assertFalse( "La posici�n del carro que sali� no aparece marcada como vac�a", parqueadero1.estaOcupado( posiciones[ i ] ) );
		}
	}

	/**
	 * Verificar sacarCarro
	 */
	@Test
	public void testSacarCarro1( )
	{
		setupEscenario1( );
		int tarifa = parqueadero1.darTarifa( );

		// Llenar el parqueadero
		for( int i = 0; i < Parqueadero.TAMANO; i++ )
		{
			try
			{
				if( i <= 9 )
				{
					parqueadero1.ingresarCarro( "ppppp" + i, "Marca" + i, "Modelo" + i );
				}
				else
				{
					parqueadero1.ingresarCarro( "pppp" + i, "Marca" + i, "Modelo" + i );
				}
			}
			catch( Exception e )
			{
				fail( "No deber�a generar excepci�n." );
			}
		}

		// Sacar todos los carros del parqueadero en la misma hora
		for( int i = 0; i < Parqueadero.TAMANO; i++ )
		{
			try
			{
				int valor = 0;
				if( i <= 9 )
				{
					valor = parqueadero1.sacarCarro( "ppppp" + i );
				}
				else
				{
					valor = parqueadero1.sacarCarro( "pppp" + i );
				}
				assertEquals( "La tarifa cobrada es incorrecta", tarifa, valor );
			}
			catch( Exception e )
			{
				fail( "No deber�a generar excepci�n al sacar el carro." );
			}
		}

		// Llenar el parqueadero
		for( int i = 0; i < Parqueadero.TAMANO; i++ )
		{
			try
			{
				if( i <= 9 )
				{
					parqueadero1.ingresarCarro( "ppppp" + i, "Marca" + i, "Modelo" + i );
				}
				else
				{
					parqueadero1.ingresarCarro( "pppp" + i, "Marca" + i, "Modelo" + i );
				}
			}
			catch( Exception e )
			{
				fail( "No deber�a generar excepci�n." );
			}
		}

		parqueadero1.avanzarHora( );

		// Sacar todos los carros del parqueadero despu�s de una hora
		for( int i = 0; i < Parqueadero.TAMANO; i++ )
		{
			try
			{
				int valor = 0;
				if( i <= 9 )
				{
					valor = parqueadero1.sacarCarro( "ppppp" + i );
				}
				else
				{
					valor = parqueadero1.sacarCarro( "pppp" + i );
				}
				assertEquals( "La tarifa cobrada es incorrecta", tarifa * 2, valor );
			}
			catch( Exception e )
			{
				fail( "No deber�a generar excepci�n." );
			}
		}
	}

	/**
	 * Verificar sacarCarro con carros que no estaban en el parqueadero
	 */
	@Test
	public void testSacarCarro2( )
	{
		setupEscenario1( );

		// Sacar carros del parqueadero que no estaban parqueados
		for( int i = 0; i < Parqueadero.TAMANO; i++ )
		{
			try
			{
				parqueadero1.sacarCarro( "ppp" + i );
				fail( "Se sac� un carro que no estaba parqueado." );
			}
			catch( Exception e )
			{
				// Debe lanzar excepci�n.
			}
		}
	}

	/**
	 * Verifica que no se puede sacar carros cuando el parqueadero est� cerrado
	 */
	@Test
	public void testSacarCarro4( )
	{
		setupEscenario2( );

		while( parqueadero2.estaAbierto( ) )
			parqueadero2.avanzarHora( );

		try
		{
			parqueadero1.sacarCarro( "ppp111" );
			fail( "Se sac� un carro en el parqueadero cerrado." );
		}
		catch( Exception e )
		{
			// Debe lanzar excepci�n.
		}
	}

	/**
	 * Verifica el m�todo ordenarPorMarca.<br>
	 * <b>M�todos a probar:</b><br>
	 * ordenarPorMarca<br>
	 * <b>Casos de prueba:</b><br>
	 * 1. Existen 4 carros en el parqueadero.
	 */
	@Test
	public void testOrdenarPorMarca( )
	{
		// TODO HECHO Parte 3 Punto D: Completar el m�todo seg�n la documentaci�n dada.
		setupEscenario2();
		parqueadero2.ordenarPorMarca();
		ArrayList carros = parqueadero2.darCarros();
		for( int i = 1; i < carros.size( ); i++ )
		{
			Carro p0 = ( Carro )carros.get( i - 1 );
			Carro p1 = ( Carro )carros.get( i );

			assertTrue( "No se orden� bien por marca", p0.darMarca().compareTo( p1.darMarca() ) <= 0 );
		}
	}


	/**
	 * Verifica el m�todo ordenarPorModelo.<br>
	 * <b>M�todos a probar:</b><br>
	 * ordenarPorModelo<br>
	 * <b>Casos de prueba:</b><br>
	 * 1. Existen 4 carros en el parqueadero.
	 */
	@Test
	public void testOrdenarPorModelo( )
	{
		setupEscenario2();
		parqueadero2.ordenarPorModelo();
		ArrayList carros = parqueadero2.darCarros();
		for( int i = 1; i < carros.size( ); i++ )
		{
			Carro p0 = ( Carro )carros.get( i - 1 );
			Carro p1 = ( Carro )carros.get( i );

			assertTrue( "No se orden� bien por modelo", p0.darModelo().compareTo( p1.darModelo() ) <= 0 );
		}
	}
	// TODO HECHO Parte 3 Punto E: Completar el m�todo seg�n la documentaci�n dada.


	/**
	 * Verifica el m�todo ordenarPorHoraIngreso.<br>
	 * <b>M�todos a probar:</b><br>
	 * ordenarPorHoraIngreso<br>
	 * <b>Casos de prueba:</b><br>
	 * 1. Existen 4 carros en el parqueadero.
	 */
	@Test
	public void testOrdenarPorHoraIngreso( )
	{
		setupEscenario2();
		parqueadero2.ordenarPorHoraIngreso();
		ArrayList carros = parqueadero2.darCarros();
		for( int i = 1; i < carros.size( ); i++ )
		{
			Carro p0 = ( Carro )carros.get( i - 1 );
			Carro p1 = ( Carro )carros.get( i );

			assertTrue( "No se orden� bien por hora", p0.darHoraIngreso()<=( p1.darHoraIngreso() )  );
		}
		// TODO HECHO Parte 3 Punto F: Completar el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Verifica el m�todo buscarPorPlaca.<br>
	 * <b>M�todos a probar:</b><br>
	 * buscarPorPlaca<br>
	 * <b>Casos de prueba:</b><br>
	 * 1. El carro buscado por su placa existe en el parqueadero.<br>
	 * 2. El carro buscado por su placa no existe en el parqueadero.
	 */
	@Test
	public void testBuscarPorPlaca( )
	{
		// TODO HECHO Parte 4 Punto C: Completar el m�todo seg�n la documentaci�n dada.
		setupEscenario2();
		parqueadero2.ordenarPorMarca();
		ArrayList carros = parqueadero2.darCarros();
		Carro p0 = ( Carro )carros.get( 0 );
		String placaCarro = p0.darPlaca();


		Carro posicion = parqueadero2.buscarCarroPorPlaca(placaCarro);
		assertTrue( "No se encontr� el perro", posicion.equals(placaCarro) );

		carros = parqueadero2.darCarros();
		Carro pn = ( Carro )carros.get( posicion );
		assertEquals( "No se encontr� el perro buscado", pn.darNombre( ), nombrePerro );

		posicion = exposicion.buscarPerro( "el perro no existe" );
		assertEquals( "No se encontr� el perro buscado", -1, posicion );
	}

	/**
	 * Verifica el m�todo buscarPorHoraIngreso.<br>
	 * <b>M�todos a probar:</b><br>
	 * buscarPorHoraIngreso<br>
	 * <b>Casos de prueba:</b><br>
	 * 1. El carro buscado por su hora de ingreso existe en el parqueadero.<br>
	 * 2. El carro buscado por su hora de ingreso no existe en el parqueadero.
	 */
	@Test
	public void testBuscarPorHoraIngreso( )
	{
		// TODO Parte 4 Punto D: Completar el m�todo seg�n la documentaci�n dada.
	}

}
