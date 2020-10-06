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

import uniandes.cupi2.hotel.mundo.Servicio;
import uniandes.cupi2.hotel.mundo.Servicio.Tipo;

/**
 * Clase usada para verificar que los métodos de la clase Servicio estén correctamente implementados.
 */
public class ServicioTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Huesped en el que se realizarán las pruebas.
     */
    private Servicio servicio;

    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------
    /**
     * Crea una instancia de la clase Servicio. Este método se ejecuta antes de cada método de prueba.
     */
    @Before
    public void setupEscenario1( )
    {
        servicio = new Servicio( 1, Tipo.INTERNET, 500.0 );
    }

    /**
     * Escenario que
     */
    public void setupEscenario2( )
    {
        servicio = new Servicio( 2, Tipo.SPA, 900.0 );
    }

    // -----------------------------------------------------------------
    // Métodos de prueba
    // -----------------------------------------------------------------
    /**
     * <b>Prueba 1</b> : verifica el método constructor de la clase Servicio.<br>
     * <b>Métodos a probar: </b><br>
     * Servicio<br>
     * darIdentificador<br>
     * darTipo<br>
     * darCosto<br>
     * estaPagado<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se crea el servicio 1 correctamente.
     * 2. Se crea el servicio 2 correctamente.
     */
    @Test
    public void testServicio( )
    {
        // Caso de prueba 1
        assertEquals( "El identificador asignado no corresponde", 1, servicio.darIdentificador( ), 0 );
        assertEquals( "El tipo asignado no corresponde", Tipo.INTERNET, servicio.darTipo( ));
        assertEquals( "El costo asignado no corresponde", 500.0, servicio.darCosto( ), 0.0001);
        assertEquals( "El atributo 'pagado' no se inicializó correctamente", false, servicio.estaPagado( ));
        
        // Caso de prueba 2
        setupEscenario2( );
        assertEquals( "El identificador asignado no corresponde", 2, servicio.darIdentificador( ), 0 );
        assertEquals( "El tipo asignado no corresponde", Tipo.SPA, servicio.darTipo( ));
        assertEquals( "El costo asignado no corresponde", 900.0, servicio.darCosto( ), 0.0001);
        assertEquals( "El atributo 'pagado' no se inicializó correctamente", false, servicio.estaPagado( ));

    }
    
    /**
     * <b>Prueba 2</b> : verifica el método pagarServicio.<br>
     * <b>Métodos a probar: </b><br>
     * pagarServicio<br>
     * estaPagado<br>
     * <b>Casos de prueba:</b><br>
     * 1. Paga el servicio 1 correctamente.
     * 2. Paga el servicio 2 correctamente.
     */
    @Test
    public void testPagarServicio( )
    {
        // Caso de prueba 1
        servicio.pagarServicio( );
        assertEquals( "El servicio no fue pagado", true, servicio.estaPagado( ));

        
        // Caso de prueba 2
        setupEscenario2( );
        servicio.pagarServicio( );
        assertEquals( "El servicio no fue pagado", true, servicio.estaPagado( ));

    }

}
