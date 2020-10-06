/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogotá - Colombia)
 * Departamento de  Ingeniería  de  Sistemas    y   Computación
 * Licenciado   bajo    el  esquema Academic Free License versión 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_sintetizador
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.sintetizador.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import uniandes.cupi2.sintetizador.mundo.Efecto;

/**
 * Clase usada para verificar que los métodos de la clase Efecto estén correctamente implementados.
 */
public class EfectoTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Efecto en el que se realizarán las pruebas.
     */
    private Efecto efecto;

    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------
    /**
     * Crea una instancia de la clase Efecto. Este método se ejecuta antes de cada método de prueba.
     */
    @Before
    public void setupEscenario1( )
    {
            efecto = new Efecto( "Actústico", "Sonido tradicional de piano", 5, 0, "" );
    }

    // -----------------------------------------------------------------
    // Métodos de prueba
    // -----------------------------------------------------------------
    /**
     * <b>Prueba 1</b> : verifica el método constructor de la clase Efecto.<br>
     * <b>Métodos a probar: </b><br>
     * Efecto<br>
     * darNombre<br>
     * darDescripcion<br>
     * darCalificacion<br>
     * darIndice<br>
     * esFavorito<br>
     * esFantasia<br>
     * esDivertido<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se crea el efecto correctamente.
     */
    @Test
    public void testEfecto( )
    {
        // Caso de prueba 1
        assertEquals( "El nombre asignado al efecto no corresponde.", "Actústico", efecto.darNombre() );
        assertEquals( "La descripción asignada al efecto no corresponde.", "Sonido tradicional de piano", efecto.darDescripcion( ) );
        assertTrue( "La calificación asignada al efecto no corresponde.", 5 == efecto.darCalificacion( ) );
        assertTrue( "El índice asignado al efecto no corresponde.", 0 == efecto.darIndice( ) );
        assertTrue("La categoría favorito no debería estar seleccionada.", !efecto.esFavorito( ));
        assertTrue("La categoría fantasía no debería estar seleccionada.", !efecto.esFantasia( ));
        assertTrue("La categoría divertido no debería estar seleccionada.", !efecto.esDivertido( ));

    }
    
    /**
     * <b>Prueba 2</b> : verifica el método guardar<br>
     * <b>Métodos a probar: </b><br>
     * guardar<br>
     * esFavorito<br>
     * esFantasia<br>
     * esDivertido<br>
     * 1. Se guarda el efecto como favorito. <br>
     * 2. Se guardan todas las categorías menos favorito.
     */
    @Test
    public void testGuardar()
    {
        //Caso de prueba 1
        efecto.guardar( true, false, false );
        assertTrue("La categoría favorito debería estar seleccionada.", efecto.esFavorito( ));
        assertTrue("La categoría fantasía no debería estar seleccionada.", !efecto.esFantasia( ));
        assertTrue("La categoría divertido no debería estar seleccionada.", !efecto.esDivertido( ));
        
        //Caso de prueba 2
        efecto.guardar( false, true, true );
        assertTrue("La categoría favorito no debería estar seleccionada.", !efecto.esFavorito( ));
        assertTrue("La categoría fantasía debería estar seleccionada.", efecto.esFantasia( ));
        assertTrue("La categoría divertido debería estar seleccionada.", efecto.esDivertido( ));
    }
    

}
