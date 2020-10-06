package uniandes.cupi2.almacen.test;

import uniandes.cupi2.almacen.mundo.Categoria;
import uniandes.cupi2.almacen.mundo.Marca;
import uniandes.cupi2.almacen.mundo.NodoAlmacen;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Clase de prueba para la clase NodoAlmacen.
 * @author Cupi2
 */
public class NodoAlmacenTest
{

    /**
     * Nodo sobre el cual se realizaran las pruebas.
     */
    private NodoAlmacen nodo;

    /**
     * Inicializa el objeto de prueba como una categoría con datos de prueba.
     */
    @Before
    public void setupescenario1( )
    {
        nodo = new Categoria( "A001", "N-A001" );
    }

    /**
     * Inicializa el objeto de prueba como una marca con datos de prueba.
     */
    private void setupescenario2( )
    {
        nodo = new Marca( "A001", "N-A001" );
    }

    /**
     * <b>Prueba 1</b> : verifica el método constructor de la clase.<br>
     * <b>Métodos a probar:</b><br>
     * 1. NodoAlmacen.<br>
     * 2. darIdentificador. <br>
     * <b>Casos de prueba:</b><br>
     * 1. Se prueba para un nodo de tipo categoría<br>
     * 2. Se prueba para un nodo de tipo marca.
     */
    @Test
    public void testNodo( )
    {
        // Caso de prueba 1
        assertEquals( "El tipo no es el esperado.", "Categoria", nodo.darTipo( ) );
        assertEquals( "El identificador no es el esperado.", "A001", nodo.darIdentificador( ) );
        assertEquals( "El nombre no es el esperado.", "N-A001", nodo.darNombre( ));

        // Caso de prueba 2
        setupescenario2( );
        assertEquals( "El tipo no es el esperado.", "Marca", nodo.darTipo( ) );
        assertEquals( "El identificador no es el esperado.", "A001", nodo.darIdentificador( ) );
        assertEquals( "El nombre no es el esperado.", "N-A001", nodo.darNombre( ) );

    }

}
