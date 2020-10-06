/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
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

import org.junit.Before;

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
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Prepara los datos de prueba del escenario1
     */
    @Before
    public void setupEscenario1( )
    {
        carro = new Carro( "abc123", 12, "Renault", "4" );
    }

    /**
     * Prueba que los datos básicos se recuperen adecuadamente
     */
    @Test
    public void testDatos( )
    {
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
     * Prueba que el carro calcule correctamente el tiempo que lleva en el parqueadero
     */
    @Test
    public void testTiempoEnParqueadero( )
    {
        assertEquals( "El tiempo de parqueo que calcula el carro es incorrecto", 1, carro.darTiempoEnParqueadero( 12 ) );
        assertEquals( "El tiempo de parqueo que calcula el carro es incorrecto", 2, carro.darTiempoEnParqueadero( 13 ) );
        assertEquals( "El tiempo de parqueo que calcula el carro es incorrecto", 4, carro.darTiempoEnParqueadero( 15 ) );
        assertEquals( "El tiempo de parqueo que calcula el carro es incorrecto", 6, carro.darTiempoEnParqueadero( 17 ) );
    }

    /**
     * Prueba que el carro verifique correctamente si la placa buscada es la suya
     * 
     */
    @Test
    public void testTienePlaca( )
    {
        assertFalse( "El carro dice que tiene una placa diferente a la suya", carro.tienePlaca( "zzz123" ) );
        assertTrue( "El carro dice que no tiene una placa igual a la suya", carro.tienePlaca( "abc123" ) );
    }
	
	/**
     * Verifica el método compararPorMarca. <br>
     * <b>Métodos a probar:</b> <br>
     * Carro<br>
     * compararPorMarca<br>
     * <b> Casos de prueba: </b><br>
     * 1) Los dos carros tienen misma la marca.<br>
     * 2) El carro contra el cual se compara tiene una marca lexicográficamente mayor. <br>
     * 3) El carro contra le cual se compara tiene una marca lexicográficamente menor. <br>
     */
    @Test
    public void testCompararPorMarca( )
    {
        //Caso de prueba 1
        Carro carro1 = new Carro("abc123", 12, "Renault", "4");
        assertEquals("El resultado de la comparación no es correcto", carro.compararPorMarca( carro1 ), 0);
        
        //Caso de prueba 2
        Carro carro2 = new Carro("abc123", 12, "ZZZ", "4");
        assertEquals("El resultado de la comparación no es correcto", carro.compararPorMarca( carro2 ), -1);
        
        //Caso de prueba 3
        Carro carro3 = new Carro("abc123", 12, "AAA", "4");
        assertEquals("El resultado de la comparación no es correcto", carro.compararPorMarca( carro3 ), 1);
    }

    /**
     * Verifica el método compararPorModelo. <br>
     * <b>Métodos a probar:</b> <br>
     * Carro<br>
     * compararPorModelo<br>
     * <b> Casos de prueba: </b><br>
     * 1) Los dos carros tienen el mismo modelo.<br>
     * 2) El carro contra el cual se compara tiene un modelo lexicográficamente mayor. <br>
     * 3) El carro contra el cual se compara tiene un modelo lexicográficamente menor. <br>
     */
    @Test
    public void testCompararPorModelo( )
    {
      //Caso de prueba 1
        Carro carro1 = new Carro("abc123", 12, "Renault", "4");
        assertEquals("El resultado de la comparación no es correcto", carro.compararPorModelo( carro1 ), 0);
        
        //Caso de prueba 2
        Carro carro2 = new Carro("abc123", 12, "ZZZ", "14");
        assertEquals("El resultado de la comparación no es correcto", carro.compararPorModelo( carro2 ), 1);
        
        //Caso de prueba 3
        Carro carro3 = new Carro("abc123", 12, "AAA", "54");
        assertEquals("El resultado de la comparación no es correcto", carro.compararPorModelo( carro3 ), -1);
    }

    /**
     * Verifica el método compararPorHoraIngreso. <br>
     * <b>Métodos a probar:</b> <br>
     * Carro<br>
     * compararPorHoraIngreso<br>
     * <b> Casos de prueba: </b><br>
     * 1) Los dos carros tienen la misma hora de ingreso.<br>
     * 2) El carro contra el cual se compara tiene mayor hora de ingreso. <br>
     * 3) El carro contra el cual se compara tiene menor hora de ingreso. <br>
     */
    @Test
    public void testCompararPorHoraIngreso( )
    {
      //Caso de prueba 1
        Carro carro1 = new Carro("abc123", 12, "Renault", "4");
        assertEquals("El resultado de la comparación no es correcto", carro.compararPorHoraIngreso( carro1 ), 0);
        
        //Caso de prueba 2
        Carro carro2 = new Carro("abc123", 15, "Renault", "4");
        assertEquals("El resultado de la comparación no es correcto", carro.compararPorHoraIngreso( carro2 ), -1);
        
        //Caso de prueba 3
        Carro carro3 = new Carro("abc123", 10, "Renault", "4");
        assertEquals("El resultado de la comparación no es correcto", carro.compararPorHoraIngreso( carro3 ), 1);
    }
}
