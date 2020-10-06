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

/**
 * Clase de prueba para el carro
 */
public class CarroTest
{
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Carro representado
	 */
	private Carro carro;

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------

	/**
	 * Prepara los datos de prueba del escenario1
	 */
	public void setupEscenario1( )
	{
		carro = new Carro( "abc123", 12, "Renault", "4" );
	}

	/**
	 * Verifica los datos de un carro. <br>
	 * <b>M�todos a probar:</b> <br>
	 * Carro<br>
	 * darPlaca<br>
	 * darHoraIngreso <br>
	 * darMarca <br>
	 * darModelo <br>
	 * <b> Casos de prueba: </b><br>
	 * Verifica todos los datos del carro del escenario de prueba.
	 */
	@Test
	public void testDatos( )
	{
		setupEscenario1( );

		String placa = carro.darPlaca( );
		int hora = carro.darHoraIngreso( );
		String marca = carro.darMarca( );
		String modelo = carro.darModelo( );
		assertEquals( "La placa retornada por el carro es incorrecta", "abc123", placa );
		assertEquals( "La hora de llegada retornada por el carro es incorrecta", 12, hora );
		assertEquals( "La marca retornada por el carro es incorrecta", "Renault", marca );
		assertEquals( "El modelo retornado por el carro es incorrecto", "4", modelo );
	}

	/**
	 * Verifica el m�todo tiempoEnParqueadero. <br>
	 * <b>M�todos a probar:</b> <br>
	 * Carro<br>
	 * tiempoEnParqueadero<br>
	 * <b> Casos de prueba: </b><br>
	 * Verifica 4 tiempos distintos a partir de 4 horas distintas ingresadas por par�metro.
	 */
	@Test
	public void testTiempoEnParqueadero( )
	{
		setupEscenario1( );

		assertEquals( "El tiempo de parqueo que calcula el carro es incorrecto", 1, carro.darTiempoEnParqueadero( 12 ) );
		assertEquals( "El tiempo de parqueo que calcula el carro es incorrecto", 2, carro.darTiempoEnParqueadero( 13 ) );
		assertEquals( "El tiempo de parqueo que calcula el carro es incorrecto", 4, carro.darTiempoEnParqueadero( 15 ) );
		assertEquals( "El tiempo de parqueo que calcula el carro es incorrecto", 6, carro.darTiempoEnParqueadero( 17 ) );
	}

	/**
	 * Verifica el m�todo tienePlaca. <br>
	 * <b>M�todos a probar:</b> <br>
	 * Carro<br>
	 * tienePlaca<br>
	 * <b> Casos de prueba: </b><br>
	 * 1) El carro tiene la placa especificada. <br>
	 * 2) El carro no tiene la placa especificada. <br>
	 */
	@Test
	public void testTienePlaca( )
	{
		setupEscenario1( );

		assertFalse( "El carro dice que tiene una placa diferente a la suya", carro.tienePlaca( "zzz123" ) );
		assertTrue( "El carro dice que no tiene una placa igual a la suya", carro.tienePlaca( "abc123" ) );
	}

	/**
	 * Verifica el m�todo compararPorMarca. <br>
	 * <b>M�todos a probar:</b> <br>
	 * Carro<br>
	 * compararPorMarca<br>
	 * <b> Casos de prueba: </b><br>
	 * 1) Los dos carros tienen mism     * 2) El carro contra el cual se compara tiene una marca lexicogr�ficamente mayor. <br>
a la marca.<br>
	 * 2) El carro contra el cual se compara tiene una marca lexicogr�ficamente mayor. <br>
	 * 3) El carro contra le cual se compara tiene una marca lexicogr�ficamente menor. <br>
	 */
	public void testCompararPorMarca( )
	{
		// TODO HECHO Parte 2 Punto D: Completar el m�todo seg�n la documentaci�n dada.

		setupEscenario1();
		assertEquals("Los carros tienen la misma marca",0,carro.compararPorMarca(carro));
		assertEquals("El carro contra el cual se compara tiene una marca lexicogr�ficamente mayor",1,carro.compararPorMarca(carro));
		assertEquals("El Carro contra el cual se compara tiene una marca lexicograficamente menor",-1,carro.compararPorMarca(carro));
	}

	/**
	 * Verifica el m�todo compararPorModelo. <br>
	 * <b>M�todos a probar:</b> <br>
	 * Carro<br>
	 * compararPorModelo<br>
	 * <b> Casos de prueba: </b><br>
	 * 1) Los dos carros tienen el mismo modelo.<br>
	 * 2) El carro contra el cual se compara tiene un modelo lexicogr�ficamente mayor. <br>
	 * 3) El carro contra el cual se compara tiene un modelo lexicogr�ficamente menor. <br>
	 */
	public void testCompararPorModelo( )
	{
		// TODO HECHO Parte 2 Punto E: Completar el m�todo seg�n la documentaci�n dada.
		setupEscenario1();
		assertEquals("Los carros tienen el mismo modelo",0,carro.compararPorModelo(carro));
		assertEquals("El carro contra el cual se compara tiene un modelo lexicogr�ficamente mayor",1,carro.compararPorModelo(carro));
		assertEquals("El Carro contra el cual se compara tiene un modelo lexicograficamente menor",-1,carro.compararPorModelo(carro));
	}

	/**
	 * Verifica el m�todo compararPorHoraIngreso. <br>
	 * <b>M�todos a probar:</b> <br>
	 * Carro<br>
	 * compararPorHoraIngreso<br>
	 * <b> Casos de prueba: </b><br>
	 * 1) Los dos carros tienen la misma hora de ingreso.<br>
	 * 2) El carro contra el cual se compara tiene mayor hora de ingreso. <br>
	 * 3) El carro contra el cual se compara tiene menor hora de ingreso. <br>
	 */
	public void testCompararPorHoraIngreso( )
	{
		// TODO HECHO Parte 2 Punto F: Completar el m�todo seg�n la documentaci�n dada.
		setupEscenario1();
		assertEquals("Los carros tienen la misma hora de ingreso",0,carro.compararPorMarca(carro));
		assertEquals("El carro contra el cual se compara tiene mayor hora de ingreso",1,carro.compararPorHoraIngreso(carro));
		assertEquals("El Carro contra el cual se compara tiene menor hora de ingreso",-1,carro.compararPorHoraIngreso(carro));
	}
}
