/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogotá - Colombia)
 * Departamento de  Ingeniería  de  Sistemas    y   Computación
 * Licenciado   bajo    el  esquema Academic Free License versión 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_hotel
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.hotel.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uniandes.cupi2.hotel.mundo.Huesped;

/**
 * Clase usada para verificar que los métodos de la clase Huesped estén correctamente implementados.
 */
public class HuespedTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Huesped en el que se realizarán las pruebas.
     */
    private Huesped huesped;

    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------
    /**
     * Crea una instancia de la clase Huesped. Este método se ejecuta antes de cada método de prueba.
     */
    @Before
    public void setupEscenario1( )
    {
    		huesped = new Huesped("Juan", "1234567");
    }
    
    /**
     * Escenario que
     */
    public void setupEscenario2( )
    {
    	
    }

    // -----------------------------------------------------------------
    // Métodos de prueba
    // -----------------------------------------------------------------
    /**
     * <b>Prueba 1</b> : verifica el método constructor de la clase Huesped.<br>
     * <b>Métodos a probar: </b><br>
     * Huesped<br>
     * darNombre<br>
     * darCedula<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se crea el huésped correctamente.
     */
    @Test
    public void testHuesped( )
    {
        // Caso de prueba 1
        assertEquals( "El nombre asignado al huésped no corresponde", "Juan", huesped.darNombre() );
        assertEquals( "La cédula asignada al huésped no corresponde", "1234567", huesped.darCedula() );

    }
    

}
