package uniandes.cupi2.almacen.test;

import uniandes.cupi2.almacen.mundo.Marca;
import uniandes.cupi2.almacen.mundo.Producto;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

/**
 * Clase de prueba para la clase Marca.
 * @author Cupi2
 */
public class MarcaTest
{

    /**
     * Marca sobre la cual se realizaran las pruebas.
     */
    private Marca marca;

    /**
     * Inicializa el objeto de prueba con datos de prueba.
     */
    @Before
    public void setupescenario1( )
    {
        marca = new Marca( "Prueba","Nombre prueba" );
    }

    /**
     * Crea un escenario en el cual existe un producto de prueba para la marca.
     */
    private void setupEscenario2( )
    {
        try
        {
            marca.agregarProducto( "A001", "Prueba", "Producto de prueba", 5.5 );
        }
        catch( Exception e )
        {
            fail( "No se deber�a generar excepci�n. Verifique el m�todo agregarProducto." );
        }
    }

    /**
     * Crea un escenario en el cual existen 100 productos con c�digos del 1 al 100.
     */
    private void setupEscenario3( )
    {
        List<Producto> productos = new ArrayList<>( );
        for( int i = 0; i < 1000; i++ )
        {
            Producto p = new Producto( "P" + i, "Prueba #" + i, "Producto de prueba #" + i, i + 1 );
            productos.add( p );
            Collections.shuffle( productos );
        }

        for( Producto p : productos )
        {
            try
            {
                marca.agregarProducto( p.darCodigo( ), p.darNombre( ), p.darDescripcion( ), p.darPrecio( ) );
            }
            catch( Exception e )
            {
                fail( "No se deber�a generar excepci�n. Verifique el m�todo agregarProducto." );
            }
        }
    }

    /**
     * <b>Prueba 1</b> : verifica el m�todo constructor de la clase.<br>
     * <b>M�todos a probar:</b><br>
     * 1. Marca.<br>
     * 2. darIdentificador.<br>
     * 3. darTipo.<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se prueba el m�todo constructor de la clase<br>
     */
    @Test
    public void testMarca( )
    {
        // Caso de prueba 1
        assertEquals( "No se inicializ� correctamente el identificador.", "Prueba", marca.darIdentificador( ) );
        assertEquals( "No se inicializ� correctamente el tipo.", "Marca", marca.darTipo( ) );
    }

    /**
     * <b>prueba 2</b> : Verifica el m�todo dar cantidad de productos.<br>
     * <b>M�todos a probar:</b><br>
     * 1. agregarProducto.<br>
     * 2. darCantidadProductos.<br>
     * <b>Casos de prueba:</b><br>
     * 1. No hay productos.<br>
     * 2. Hay varios productos<br>
     */
    @Test
    public void testDarCantidadProductos( )
    {

        // Caso de prueba 1
        assertEquals( "La cantidad de productos no corresponde.", 0, marca.darCantidadProductos( ) );

        setupEscenario3( );
        // Caso de prueba 2
        assertEquals( "La cantidad de productos no corresponde.", 1000, marca.darCantidadProductos( ) );

    }

    /**
     * <b>Prueba 3</b> : verifica el m�todo agregarProducto.<br>
     * <b>M�todos a probar:</b><br>
     * 1. agregarProducto.<br>
     * 2. buscarProducto. <br>
     * <b>Casos de prueba:</b><br>
     * 1. Se agrega un producto con un c�digo nuevo.<br>
     * 2. Se agrega un producto con un c�digo existente.
     */
    @Test
    public void testAgregarProducto( )
    {
        int rand = ( int ) ( Math.random( ) * 1000 ) + 50;
        for( int i = 0; i < rand; i++ )
        {
            String codigo = UUID.randomUUID( ).toString( );
            // Caso de prueba 1
            try
            {
                marca.agregarProducto( codigo, "Producto " + i, "Producto de prueba", 0 );
            }
            catch( Exception e )
            {
                fail( "No deber�a generar excepci�n." );
            }
            Producto agregado = marca.buscarProducto( codigo );
            assertNotNull( "El producto no se encuentra.", agregado );
            assertEquals( "El nombre del producto no corresponde con el agregado.", "Producto " + i, agregado.darNombre( ) );

            // Caso de prueba 2
            try
            {
                marca.agregarProducto( codigo, "Producto " + i, "Producto de prueba", 0 );
                fail( "Se debi� generar excepci�n." );
            }
            catch( Exception e )
            {
                // Deber�a generar excepci�n
            }

        }
    }

    /**
     * <b>Prueba 3</b> : verifica el m�todo buscarProducto.<br>
     * <b>M�todos a probar:</b><br>
     * 1. buscarProducto. <br>
     * <b>Casos de prueba:</b><br>
     * 1. Se busca un producto con un c�digo existente.<br>
     * 2. Se busca un producto que no existe.
     */
    @Test
    public void testBuscarProducto( )
    {
        setupEscenario3( );
        // Caso de prueba 1
        for( int i = 0; i < 100; i++ )
        {
            Producto producto = marca.buscarProducto( "P" + i );
            assertNotNull( "No se encontro el producto.", producto );
            assertEquals( "El c�digo del producto no coincide.", "P" + i, producto.darCodigo( ) );
        }

        // Caso de prueba 2
        assertNull( "No debi� encontrar ning�n producto.", marca.buscarProducto( "P1000" ) );
    }

    /**
     * <b>Prueba 4</b> : verifica el m�todo venderProducto.<br>
     * <b>M�todos a probar:</b><br>
     * 1. venderProducto.<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se venden varias unidades de un producto.
     */
    @Test
    public void testVenderProducto( )
    {
        setupEscenario2( );

        // Caso de prueba 1
        marca.venderProducto( "A001", 10 );
        assertEquals( "El producto no se vendi� correctamente.", 10, marca.buscarProducto( "A001" ).darCantidadUnidadesVendidas( ) );
    }

    /**
     * <b>Prueba 4</b> : verifica el m�todo darValorVentas.<br>
     * <b>M�todos a probar:</b><br>
     * 1. darValorVentas.<br>
     * 2. venderProducto. <br>
     * <b>Casos de prueba:</b><br>
     * 1. No se han vendido productos.<br>
     * 2. Se venden unidades de varios productos.
     */
    @Test
    public void testDarValorVentas( )
    {
        // Caso de prueba 1
        assertEquals( "El valor de las ventas no corresponde.", 0, marca.darValorVentas( ), 0.01 );

        setupEscenario3( );
        double valorVentas = 0;
        for( int i = 0; i < 100; i++ )
        {
            // Caso de prueba 2
            int cantidad = ( int ) ( Math.random( ) * 100 );
            valorVentas += cantidad * ( i + 1 );
            marca.venderProducto( "P" + i, cantidad );
            assertEquals( "El valor de las ventas no corresponde.", valorVentas, marca.darValorVentas( ), 0.01 );

        }
    }

    /**
     * <b>Prueba 5</b> : verifica el m�todo darProductos.<br>
     * <b>M�todos a probar:</b><br>
     * 1. darProductos.<br>
     * <b>Casos de prueba:</b><br>
     * 1. Hay varios productos.<br>
     */
    @Test
    public void testDarProductos( )
    {
        setupEscenario3( );
        // Caso de prueba 1
        List<Producto> productos = new ArrayList<>( );
        marca.darProductos( productos);
        assertEquals( "No se retornaron todos los productos.", 1000, productos.size( ) );
        for( int i = 1; i < productos.size( ); i++ )
        {
            assertTrue( "El orden es incorrecto.", productos.get( i - 1 ).comparar( productos.get( i ).darCodigo( ) ) == -1 );
        }
    }
    
    /**
     * <b>Prueba 6</b> : verifica el m�todo buscarNodo.<br>
     * <b>M�todos a probar:</b><br>
     * 1. buscarNodo.<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se busca la marca.<br>
     * 2. Se busca una marca que no existe.
     */
    @Test
    public void testBuscarNodo(){
        // Caso de prueba 1
        Marca buscada = ( Marca )marca.buscarNodo( "Prueba" );
        assertNotNull("No se encontro la marca.", buscada);
        assertEquals("No retorno la marca buscada.","Nombre prueba",buscada.darNombre( ) );
    
        // Caso de prueba 2
        buscada = ( Marca )marca.buscarNodo( "NPI" );
        assertNull("No debi� haber encontrado ninguna marca.",buscada);
    }
    
    /**
     * <b>Prueba 7</b> : verifica el m�todo eliminarProducto.<br>
     * <b>M�todos a probar:</b><br>
     * 1. eliminarProducto.<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se eliminan varios productos.<br>
     */
    @Test
    public void testEliminarProducto(){
        setupEscenario3( );
        
        // Caso de prueba 1
        for(int i=0;i<1000;i++){
            String codigo= "P" + i;
            assertTrue( "Debi� eliminarse el producto", marca.eliminarProducto( codigo ) );
            assertEquals("No se elimin� correctamente el producto.", 1000-i-1, marca.darCantidadProductos( ));
            assertNull("No se elimin� el producto.", marca.buscarProducto( codigo));
        }
        
    }
}
