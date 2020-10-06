package uniandes.cupi2.almacen.test;

import uniandes.cupi2.almacen.mundo.AlmacenException;
import uniandes.cupi2.almacen.mundo.Producto;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

/**
 * Clase de prueba para la clase Producto.
 */
public class ProductoTest
{

    /**
     * Producto sobre el cual se realizaran las pruebas.
     */
    private Producto producto;

    /**
     * Inicializa el objeto de prueba con datos de prueba.
     */
    @Before
    public void setupescenario1( )
    {
        producto = new Producto( "b002", "Producto prueba", "Este es un producto de prueba", 2.5 );
    }

    /**
     * Crea un escenario en el cual el subárbol del producto no está vacío.
     */
    private void setupescenario2( )
    {
        int rand = ( int ) ( Math.random( ) * 1000 ) + 50;
        for( int i = 0; i < rand; i++ )
        {
            Producto p2 = new Producto( UUID.randomUUID( ).toString( ), "Producto " + i, "Producto de prueba #" + i, i + 1 );
            try
            {
                producto.agregarProducto( p2 );
            }
            catch( Exception e )
            {
                fail( "No debería generar excepción. Verifica el método agregar producto." );
            }
        }
    }

    /**
     * <b>Prueba 1</b> : verifica el método constructor de la clase.<br>
     * <b>Métodos a probar:</b><br>
     * 1. Producto.<br>
     * 2. darCodigo.<br>
     * 3. darNombre.<br>
     * 4. darPrecio.<br>
     * 5. darCantidadUnidadesVendidas.<br>
     * 6. darHijoIzquierda.<br>
     * 7. darHijoDerecha.<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se prueba el método constructor de la clase<br>
     */
    @Test
    public void testProducto( )
    {
        // Caso de prueba 1
        assertEquals( "No se inicializó correctamente el codigo.", "b002", producto.darCodigo( ) );
        assertEquals( "No se inicializó correctamente el nombre,.", "Producto prueba", producto.darNombre( ) );
        assertEquals( "No se inicializó correctamente el precio.", 2.5, producto.darPrecio( ), 0.01 );
        assertEquals( "No se inicializaron correctamente la cantidad de unidades vendidas.", 0, producto.darCantidadUnidadesVendidas( ) );
        assertNull( "No se inicializó correctamente el producto anterior.", producto.darHijoIzquierda( ) );
        assertNull( "No se inicializó correctamente el producto siguiente.", producto.darHijoDerecha( ) );

    }

    /**
     * <b>Prueba 2</b> : verifica el método vender.<br>
     * <b>Métodos a probar:</b><br>
     * 1. vender.<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se venden varias unidades del producto.<br>
     */
    @Test
    public void testVender( )
    {

        // Caso de prueba 1
        producto.vender( 1 );
        assertEquals( "La cantidad de unidades vendidas no es correcta.", 1, producto.darCantidadUnidadesVendidas( ) );

        producto.vender( 3 );
        assertEquals( "La cantidad de unidades vendidas no es correcta.", 4, producto.darCantidadUnidadesVendidas( ) );

        producto.vender( 5 );
        assertEquals( "La cantidad de unidades vendidas no es correcta.", 9, producto.darCantidadUnidadesVendidas( ) );

    }

    /**
     * <b>Prueba 3</b> : verifica el método darValorVentas.<br>
     * <b>Métodos a probar:</b><br>
     * 1. vender.<br>
     * 2. darValorVentas <b>Casos de prueba:</b><br>
     * 1. No se han vendido productos.<br>
     * 2. Se venden varias unidades del producto.<br>
     */
    @Test
    public void testDarValorVentas( )
    {

        // Caso de prueba 1
        assertEquals( "El valor de las ventas no corresponde.", 0, producto.darValorVentas( ), 0.01 );

        // Caso de prueba 2
        producto.vender( 1 );
        assertEquals( "El valor de las ventas no corresponde.", 2.5, producto.darValorVentas( ), 0.01 );

        producto.vender( 3 );
        assertEquals( "El valor de las ventas no corresponde.", 10, producto.darValorVentas( ), 0.01 );

        producto.vender( 5 );
        assertEquals( "El valor de las ventas no corresponde.", 22.5, producto.darValorVentas( ), 0.01 );

    }

    /**
     * <b>Prueba 4</b> : verifica el método comparar.<br>
     * <b>Métodos a probar:</b><br>
     * 1. comparar.<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se prueba para un código mayor<br>
     * 2. Se prueba para un código menor<br>
     * 3. Se prueba para un código igual<br>
     */
    @Test
    public void testComparar( )
    {

        // Caso de prueba 1
        assertEquals( "La comparación no es correcta.", -1, producto.comparar( "c002" ) );
        assertEquals( "La comparación no es correcta.", -1, producto.comparar( "b003" ) );
        assertEquals( "La comparación no es correcta.", -1, producto.comparar( "b101" ) );

        // Caso de prueba 2
        assertEquals( "La comparación no es correcta.", 1, producto.comparar( "a001" ) );
        assertEquals( "La comparación no es correcta.", 1, producto.comparar( "b001" ) );
        assertEquals( "La comparación no es correcta.", 1, producto.comparar( "a101" ) );

        // Caso de prueba 3
        assertEquals( "La comparación no es correcta.", 0, producto.comparar( "b002" ) );
    }

    /**
     * <b>Prueba 5</b> : verifica el método .<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se agregan varios productos.<br>
     */
    @Test
    public void testDarPeso( )
    {
        // Caso de prueba 1
        int rand = ( int ) ( Math.random( ) * 1000 ) + 50;
        for( int i = 0; i < rand; i++ )
        {
            Producto p2 = new Producto( UUID.randomUUID( ).toString( ), "Producto " + i, "Producto de prueba", 0 );
            try
            {
                producto.agregarProducto( p2 );
            }
            catch( AlmacenException e )
            {
                fail( "No debería generar excepción. Verifica el método agregar producto." );
            }
            assertEquals( "El peso no es el esperado.", i + 2, producto.darPeso( ) );
        }
    }

    /**
     * <b>Prueba 6</b> : verifica el método agregar producto.<br>
     * <b>Métodos a probar:</b><br>
     * 1. agregarProducto.<br>
     * 2. buscarProducto.<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se agrega un producto con un código nuevo.<br>
     * 2. Se agrega un producto con un código existente.<br>
     */
    @Test
    public void testAgregarProducto( )
    {

        int rand = ( int ) ( Math.random( ) * 1000 ) + 50;
        for( int i = 0; i < rand; i++ )
        {
            String codigo = UUID.randomUUID( ).toString( );
            Producto p2 = new Producto( codigo, "Producto " + i, "Producto de prueba", 0 );
            // Caso de prueba 1
            try
            {
                producto.agregarProducto( p2 );
            }
            catch( Exception e )
            {
                e.printStackTrace( );
                fail( "El producto debió ser agregado" );
            }
            Producto agregado = producto.buscarProducto( codigo );
            assertNotNull( "El producto no se encuentra.", agregado );
            assertEquals( "El nombre del producto no corresponde con el agregado.", "Producto " + i, agregado.darNombre( ) );

            // Caso de prueba 2
            try
            {
                producto.agregarProducto( p2 );
                fail( "El producto no debió ser agregado." );
            }
            catch( Exception e )
            {
                // Debe generar excepción.
            }

            // Verificar orden
            List<Producto> productos = new ArrayList<>( );
            Producto ultimo = null;
            Producto actual = producto;
            while( actual != null )
            {
                productos.add( actual );
                actual = actual.darHijoIzquierda( );
            }
            while( !productos.isEmpty( ) )
            {
                actual = productos.remove( productos.size( ) - 1 );
                if( ultimo != null )
                {
                    assertTrue( "El orden es incorrecto.", actual.comparar( ultimo.darCodigo( ) ) == 1 );
                }
                ultimo = actual;
                if( actual.darHijoDerecha( ) != null )
                {
                    actual = actual.darHijoDerecha( );
                    while( actual != null )
                    {
                        productos.add( actual );
                        actual = actual.darHijoIzquierda( );
                    }
                }
            }
        }
    }

    /**
     * <b>Prueba 7</b> : verifica el método buscar producto.<br>
     * <b>Métodos a probar:</b><br>
     * 1. agregarProducto.<br>
     * 2. buscarProducto.<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se busca el código del producto de la raíz.<br>
     * 2. Se busca un producto que no ha sido agregado.<br>
     * 3. Se buscan productos agregados previamente.<br>
     */
    @Test
    public void testBuscarProducto( )
    {
        // Caso de prueba 1
        Producto p2 = producto.buscarProducto( "b002" );
        assertNotNull( "El producto raíz no fue encontrado.", p2 );
        assertEquals( "El producto encontrado no corresponde con el buscado.", producto.darNombre( ), p2.darNombre( ) );

        int rand = ( int ) ( Math.random( ) * 1000 ) + 50;
        for( int i = 0; i < rand; i++ )
        {
            String codigo = UUID.randomUUID( ).toString( );
            p2 = new Producto( codigo, "Producto " + i, "Producto de prueba", 0 );
            Producto buscado = producto.buscarProducto( codigo );

            // Caso de prueba 2
            assertNull( "No se debió haber encontrado ningún producto.", buscado );

            // Caso de prueba 3
            try
            {
                producto.agregarProducto( p2 );
            }
            catch( Exception e )
            {
                fail( "No debería generar excepción. Verifica el método agregar producto." );
            }

            buscado = producto.buscarProducto( codigo );
            assertNotNull( "El producto no se encuentra.", buscado );
            assertEquals( "El nombre del producto no corresponde con el agregado.", "Producto " + i, buscado.darNombre( ) );

        }
    }

    /**
     * <b>prueba 8</b> : verifica el método darInorden.<br>
     * <b>Métodos a probar:</b><br>
     * 1. darInorden.<br>
     * <b>Casos de prueba:</b><br>
     * 1. Hay varios productos en el subárbol.
     */
    @Test
    public void testDarInorden( )
    {

        setupescenario2( );
        // Caso de prueba 1
        List<Producto> inorden = new ArrayList<>( );
        producto.darInorden( inorden );

        for( int i = 1; i < inorden.size( ); i++ )
        {
            assertTrue( "El inorden es incorrecto.", inorden.get( i - 1 ).comparar( inorden.get( i ).darCodigo( ) ) == -1 );
        }
    }

}
