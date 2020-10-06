package uniandes.cupi2.almacen.test;

import uniandes.cupi2.almacen.mundo.AlmacenException;
import uniandes.cupi2.almacen.mundo.Categoria;
import uniandes.cupi2.almacen.mundo.Marca;
import uniandes.cupi2.almacen.mundo.NodoAlmacen;
import uniandes.cupi2.almacen.mundo.Producto;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

/**
 * Clase de prueba para la clase Categoría.
 */
public class CategoriaTest
{

    /**
     * Categoría sobre el cual se realizaran las pruebas.
     */
    private Categoria categoria;

    /**
     * Inicializa el objeto de prueba con datos de prueba.
     */
    @Before
    public void setupescenario1( )
    {
        categoria = new Categoria( "A001", "A001" );
    }

    /**
     * Crea una categoría con varios nodos.
     */
    private void setupEscenario2( )
    {
        try
        {

            categoria.agregarNodo( "A001", Categoria.TIPO, "1100", "N1100" );
            categoria.agregarNodo( "A001", Categoria.TIPO, "1200", "N1200" );
            categoria.agregarNodo( "A001", Marca.TIPO, "1300", "N1300" );

            categoria.agregarNodo( "1100", Marca.TIPO, "1110", "N1110" );
            categoria.agregarNodo( "1100", Marca.TIPO, "1120", "N1120" );

            categoria.agregarNodo( "1200", Marca.TIPO, "1210", "N1210" );
            categoria.agregarNodo( "1200", Marca.TIPO, "1220", "N1220" );

            ( ( Marca )categoria.buscarNodo( "1300" ) ).agregarProducto( "1310", "Prueba 1310", "Producto prueba", 1310 );
            ( ( Marca )categoria.buscarNodo( "1300" ) ).agregarProducto( "1320", "Prueba 1320", "Producto prueba", 1320 );
            ( ( Marca )categoria.buscarNodo( "1300" ) ).agregarProducto( "1330", "Prueba 1330", "Producto prueba", 1330 );

            ( ( Marca )categoria.buscarNodo( "1110" ) ).agregarProducto( "1111", "Prueba 1111", "Producto prueba", 1111 );
            ( ( Marca )categoria.buscarNodo( "1110" ) ).agregarProducto( "1112", "Prueba 1112", "Producto prueba", 1112 );
            ( ( Marca )categoria.buscarNodo( "1110" ) ).agregarProducto( "1113", "Prueba 1113", "Producto prueba", 1113 );

            ( ( Marca )categoria.buscarNodo( "1120" ) ).agregarProducto( "1121", "Prueba 1121", "Producto prueba", 1121 );
            ( ( Marca )categoria.buscarNodo( "1120" ) ).agregarProducto( "1122", "Prueba 1122", "Producto prueba", 1122 );
            ( ( Marca )categoria.buscarNodo( "1120" ) ).agregarProducto( "1123", "Prueba 1123", "Producto prueba", 1123 );

            ( ( Marca )categoria.buscarNodo( "1210" ) ).agregarProducto( "1211", "Prueba 1211", "Producto prueba", 1211 );
            ( ( Marca )categoria.buscarNodo( "1210" ) ).agregarProducto( "1212", "Prueba 1212", "Producto prueba", 1212 );
            ( ( Marca )categoria.buscarNodo( "1210" ) ).agregarProducto( "1213", "Prueba 1213", "Producto prueba", 1213 );

            ( ( Marca )categoria.buscarNodo( "1220" ) ).agregarProducto( "1221", "Prueba 1221", "Producto prueba", 1221 );
            ( ( Marca )categoria.buscarNodo( "1220" ) ).agregarProducto( "1222", "Prueba 1222", "Producto prueba", 1222 );
            ( ( Marca )categoria.buscarNodo( "1220" ) ).agregarProducto( "1223", "Prueba 1223", "Producto prueba", 1223 );

        }
        catch( AlmacenException e )
        {
            fail( "No debería generar excepción. Revisa el método agregarNodo." );
        }
    }

    /**
     * Se extiende el escenario 2 para que los productos tengan ventas registradas.
     */
    private void setupEscenario3( )
    {
        setupEscenario2( );
        ( ( Marca )categoria.buscarNodo( "1300" ) ).venderProducto( "1310", 10 );
        ( ( Marca )categoria.buscarNodo( "1300" ) ).venderProducto( "1320", 10 );
        ( ( Marca )categoria.buscarNodo( "1300" ) ).venderProducto( "1330", 10 );
        ( ( Marca )categoria.buscarNodo( "1110" ) ).venderProducto( "1111", 10 );
        ( ( Marca )categoria.buscarNodo( "1110" ) ).venderProducto( "1112", 10 );
        ( ( Marca )categoria.buscarNodo( "1110" ) ).venderProducto( "1113", 10 );
        ( ( Marca )categoria.buscarNodo( "1120" ) ).venderProducto( "1121", 10 );
        ( ( Marca )categoria.buscarNodo( "1120" ) ).venderProducto( "1122", 10 );
        ( ( Marca )categoria.buscarNodo( "1120" ) ).venderProducto( "1123", 10 );
        ( ( Marca )categoria.buscarNodo( "1210" ) ).venderProducto( "1211", 10 );
        ( ( Marca )categoria.buscarNodo( "1210" ) ).venderProducto( "1212", 10 );
        ( ( Marca )categoria.buscarNodo( "1210" ) ).venderProducto( "1213", 10 );
        ( ( Marca )categoria.buscarNodo( "1220" ) ).venderProducto( "1221", 10 );
        ( ( Marca )categoria.buscarNodo( "1220" ) ).venderProducto( "1222", 10 );
        ( ( Marca )categoria.buscarNodo( "1220" ) ).venderProducto( "1223", 10 );

    }

    /**
     * <b>Prueba 2</b> : verifica el método agregarNodo.<br>
     * <b>Métodos a probar:</b><br>
     * 1. agregarNodo.<br>
     * 2. buscarNodo.<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se agrega una categoría nueva.<br>
     * 2. Se agrega una categoría existente.<br>
     * 3. Se agrega una marca nueva.<br>
     * 4. Se agrega una marca existente.<br>
     */
    @Test
    public void testAgregarNodo( )
    {
        Random random = new Random( );
        int rand = random.nextInt( 1000 ) + 100;
        NodoAlmacen nodoAlmacen = null;
        NodoAlmacen nuevo = null;
        int cantNodos = 0;
        List<String> identificadores = new ArrayList<>( );
        identificadores.add( categoria.darIdentificador( ) );
        for( int i = 0; i < rand; i++ )
        {
            // Caso de prueba 1
            String identificador = UUID.randomUUID( ).toString( );
            try
            {
                nodoAlmacen = categoria.buscarNodo( identificadores.get( random.nextInt( identificadores.size( ) ) ) );
                cantNodos = ( ( Categoria )nodoAlmacen ).darNodos( ).size( );
                categoria.agregarNodo( nodoAlmacen.darIdentificador( ), Categoria.TIPO, identificador, "N-" + identificador );
                identificadores.add( identificador );
                assertEquals( "El nodo no se agregó correctamente.", cantNodos + 1, ( ( Categoria )nodoAlmacen ).darNodos( ).size( ) );

                nuevo = categoria.buscarNodo( identificador );
                assertNotNull( "No se encontró el nodo agregado.", nuevo );
                assertEquals( "El identificador no corresponde.", identificador, nuevo.darIdentificador( ) );
                assertEquals( "El tipo no corresponde.", Categoria.TIPO, nuevo.darTipo( ) );
            }
            catch( AlmacenException e )
            {
                fail( "No debería generar excepción." );
            }

            // Caso de prueba 2
            try
            {
                categoria.agregarNodo( identificadores.get( random.nextInt( identificadores.size( ) ) ), Categoria.TIPO, identificador, "N-" + identificador );
                fail( "Deberia generar excepción." );
            }
            catch( AlmacenException e )
            {
                assertEquals( "El nodo no se debió haber agregado.", cantNodos + 1, ( ( Categoria )nodoAlmacen ).darNodos( ).size( ) );
            }

            try
            {
                categoria.agregarNodo( identificadores.get( random.nextInt( identificadores.size( ) ) ), Marca.TIPO, identificador, "N-" + identificador );
                fail( "Deberia generar excepción." );
            }
            catch( AlmacenException e )
            {
                assertEquals( "El nodo no se debió haber agregado.", cantNodos + 1, ( ( Categoria )nodoAlmacen ).darNodos( ).size( ) );
            }

            // Caso de prueba 3
            identificador = UUID.randomUUID( ).toString( );
            try
            {
                nodoAlmacen = categoria.buscarNodo( identificadores.get( random.nextInt( identificadores.size( ) ) ) );
                cantNodos = ( ( Categoria )nodoAlmacen ).darNodos( ).size( );
                categoria.agregarNodo( nodoAlmacen.darIdentificador( ), Marca.TIPO, identificador, "N-" + identificador );
                assertEquals( "El nodo no se agregó correctamente.", cantNodos + 1, ( ( Categoria )nodoAlmacen ).darNodos( ).size( ) );

                nuevo = categoria.buscarNodo( identificador );
                assertNotNull( "No se encontró el nodo agregado.", nuevo );
                assertEquals( "El identificador no corresponde.", identificador, nuevo.darIdentificador( ) );
                assertEquals( "El tipo no corresponde.", Marca.TIPO, nuevo.darTipo( ) );

            }
            catch( AlmacenException e )
            {
                fail( "No debería generar excepción." );
            }

            // Caso de prueba 4

            try
            {
                categoria.agregarNodo( identificadores.get( random.nextInt( identificadores.size( ) ) ), Marca.TIPO, identificador, "N-" + identificador );
                fail( "Deberia generar excepción." );
            }
            catch( AlmacenException e )
            {
                assertEquals( "El nodo no se debió haber agregado.", cantNodos + 1, ( ( Categoria )nodoAlmacen ).darNodos( ).size( ) );
            }

            try
            {
                categoria.agregarNodo( identificadores.get( random.nextInt( identificadores.size( ) ) ), Categoria.TIPO, identificador, "N-" + identificador );
                fail( "Deberia generar excepción." );
            }
            catch( AlmacenException e )
            {
                assertEquals( "El nodo no se debió haber agregado.", cantNodos + 1, ( ( Categoria )nodoAlmacen ).darNodos( ).size( ) );
            }
        }
    }

    /**
     * <b>Prueba 3</b> : verifica el método buscarNodo.<br>
     * <b>Métodos a probar:</b><br>
     * 1. buscarNodo.<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se busca un nodo que no existe.<br>
     * 2. Se busca la raíz.<br>
     * 3. Se buscan otros nodos existentes.
     */
    @Test
    public void testBuscarNodo( )
    {
        NodoAlmacen nodoAlmacen;
        // Caso de prueba 1
        nodoAlmacen = categoria.buscarNodo( "C001" );
        assertNull( "No debería encontrar el nodo.", nodoAlmacen );

        // Caso de prueba 2
        nodoAlmacen = categoria.buscarNodo( "A001" );
        assertNotNull( "No se encontró el nodo.", nodoAlmacen );
        assertEquals( "El identificador no corresponde.", "A001", nodoAlmacen.darIdentificador( ) );

        // Caso de prueba 3
        setupEscenario2( );
        nodoAlmacen = categoria.buscarNodo( "1100" );
        assertNotNull( "No se encontró el nodo.", nodoAlmacen );
        assertEquals( "El identificador no corresponde.", "1100", nodoAlmacen.darIdentificador( ) );

        nodoAlmacen = categoria.buscarNodo( "1200" );
        assertNotNull( "No se encontró el nodo.", nodoAlmacen );
        assertEquals( "El identificador no corresponde.", "1200", nodoAlmacen.darIdentificador( ) );

        nodoAlmacen = categoria.buscarNodo( "1300" );
        assertNotNull( "No se encontró el nodo.", nodoAlmacen );
        assertEquals( "El identificador no corresponde.", "1300", nodoAlmacen.darIdentificador( ) );

        nodoAlmacen = categoria.buscarNodo( "1120" );
        assertNotNull( "No se encontró el nodo.", nodoAlmacen );
        assertEquals( "El identificador no corresponde.", "1120", nodoAlmacen.darIdentificador( ) );

        nodoAlmacen = categoria.buscarNodo( "1210" );
        assertNotNull( "No se encontró el nodo.", nodoAlmacen );
        assertEquals( "El identificador no corresponde.", "1210", nodoAlmacen.darIdentificador( ) );

    }

    /**
     * <b>Prueba 4</b> : verifica el método darValorVentas.<br>
     * <b>Métodos a probar:</b><br>
     * 1. darValorVentas.<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se prueban las ventas de la raíz.<br>
     * 2. Se prueban las ventas de subcategorías.
     */
    @Test
    public void testDarValorVentas( )
    {
        setupEscenario3( );

        // Caso de prueba 1
        assertEquals( "El valor de las ventas no corresponde.", 179640, categoria.darValorVentas( ), 0.01 );

        // Caso de prueba 2
        assertEquals( "El valor de las ventas no corresponde.", 67020, categoria.buscarNodo( "1100" ).darValorVentas( ), 0.01 );
        assertEquals( "El valor de las ventas no corresponde.", 33360, categoria.buscarNodo( "1110" ).darValorVentas( ), 0.01 );
        assertEquals( "El valor de las ventas no corresponde.", 33660, categoria.buscarNodo( "1120" ).darValorVentas( ), 0.01 );

        assertEquals( "El valor de las ventas no corresponde.", 73020, categoria.buscarNodo( "1200" ).darValorVentas( ), 0.01 );
        assertEquals( "El valor de las ventas no corresponde.", 36360, categoria.buscarNodo( "1210" ).darValorVentas( ), 0.01 );
        assertEquals( "El valor de las ventas no corresponde.", 36660, categoria.buscarNodo( "1220" ).darValorVentas( ), 0.01 );

    }

    /**
     * <b>Prueba 5</b> : verifica el método eliminarNodo.<br>
     * <b>Métodos a probar:</b><br>
     * 1. eliminarNodo.<br>
     * 2. buscarNodo <b>Casos de prueba:</b><br>
     * 1. Se eliminan varias marcas.<br>
     * 2. Se eliminan varias categorías.
     */
    @Test
    public void testEliminarNodo( )
    {
        setupEscenario2( );
        NodoAlmacen eliminado = null;
        // Caso de prueba 1
        eliminado = categoria.eliminarNodo( "1110" );
        assertNotNull( "No retorno el nodo eliminado.", eliminado );
        assertEquals( "No se elimino el nodo correcto.", "1110", eliminado.darIdentificador( ) );
        assertNull( "No se elimino el nodo.", categoria.buscarNodo( "1110" ) );

        eliminado = categoria.eliminarNodo( "1300" );
        assertNotNull( "No retorno el nodo eliminado.", eliminado );
        assertEquals( "No se elimino el nodo correcto.", "1300", eliminado.darIdentificador( ) );
        assertNull( "No se elimino el nodo.", categoria.buscarNodo( "1300" ) );

        // Caso de prueba 2

        eliminado = categoria.eliminarNodo( "1200" );
        assertNotNull( "No retorno el nodo eliminado.", eliminado );
        assertEquals( "No se elimino el nodo correcto.", "1200", eliminado.darIdentificador( ) );
        assertNull( "No se elimino el nodo.", categoria.buscarNodo( "1200" ) );

        eliminado = categoria.eliminarNodo( "1100" );
        assertNotNull( "No retorno el nodo eliminado.", eliminado );
        assertEquals( "No se elimino el nodo correcto.", "1100", eliminado.darIdentificador( ) );
        assertNull( "No se elimino el nodo.", categoria.buscarNodo( "1100" ) );
    }

    /**
     * <b>Prueba 6</b> : verifica el método buscarProducto.<br>
     * <b>Métodos a probar:</b><br>
     * 1. buscarProducto.<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se buscan productos que no existen.<br>
     * 2. Se buscan productos que existen.
     */
    @Test
    public void testBuscarProducto( )
    {
        setupEscenario2( );
        // Caso de prueba 1
        Producto buscado = categoria.buscarProducto( "1120" );
        assertNull( "El producto no existe.", buscado );

        buscado = categoria.buscarProducto( "1220" );
        assertNull( "El producto no existe.", buscado );

        buscado = categoria.buscarProducto( "1300" );
        assertNull( "El producto no existe.", buscado );

        // Caso de prueba 2
        buscado = categoria.buscarProducto( "1112" );
        assertNotNull( "No se encontro el producto.", buscado );
        assertEquals( "El codigo del producto no corresponde.", "1112", buscado.darCodigo( ) );

        buscado = categoria.buscarProducto( "1123" );
        assertNotNull( "No se encontro el producto.", buscado );
        assertEquals( "El codigo del producto no corresponde.", "1123", buscado.darCodigo( ) );

        buscado = categoria.buscarProducto( "1211" );
        assertNotNull( "No se encontro el producto.", buscado );
        assertEquals( "El codigo del producto no corresponde.", "1211", buscado.darCodigo( ) );

        buscado = categoria.buscarProducto( "1330" );
        assertNotNull( "No se encontro el producto.", buscado );
        assertEquals( "El codigo del producto no corresponde.", "1330", buscado.darCodigo( ) );

    }

    /**
     * <b>Prueba 7</b> : verifica el método buscarPadre.<br>
     * <b>Métodos a probar:</b><br>
     * 1. buscarPadre.<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se busca el padre de varios productos.<br>
     */
    @Test
    public void testBuscarPadre( )
    {
        setupEscenario2( );
        // Caso de prueba 1

        NodoAlmacen padre = categoria.buscarPadre( "1120" );
        assertNotNull( "No encontró el padre.", padre );
        assertEquals( "No encontro el nodo correcto.", "1100", padre.darIdentificador( ) );

        padre = categoria.buscarPadre( "1220" );
        assertNotNull( "No encontró el padre.", padre );
        assertEquals( "No encontro el nodo correcto.", "1200", padre.darIdentificador( ) );

        padre = categoria.buscarPadre( "1300" );
        assertNotNull( "No encontró el padre.", padre );
        assertEquals( "No encontro el nodo correcto.", "A001", padre.darIdentificador( ) );

        padre = categoria.buscarPadre( "1100" );
        assertNotNull( "No encontró el padre.", padre );
        assertEquals( "No encontro el nodo correcto.", "A001", padre.darIdentificador( ) );

    }

    /**
     * <b>Prueba 8</b> : verifica el método darProductos.<br>
     * <b>Métodos a probar:</b><br>
     * 1. darProductos.<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se obtienen todos los productos de varios nodos.<br>
     */
    @Test
    public void testDarProductos( )
    {
        setupEscenario2( );
        List<Producto> productos;
        List<String> identificadores = new ArrayList<>( );
        identificadores.add( "1121" );
        identificadores.add( "1122" );
        identificadores.add( "1123" );
        
        // Caso de prueba 1
        productos = categoria.buscarNodo( "1120" ).darProductos( );
        assertEquals( "La cantidad de productos no es la esperada.", 3, productos.size( ) );
        for(String id: identificadores){
            boolean encontrado = false;
            for(int i=0;i<productos.size( ) && !encontrado ; i++){
                encontrado = productos.get( i ).comparar( id ) == 0;
            }
            if(!encontrado){
                fail("No retorno los productos esperados. Falta el "+id);
            }
        }
        
        productos = categoria.buscarNodo( "1110" ).darProductos( );
        identificadores = new ArrayList<>( );
        identificadores.add( "1111" );
        identificadores.add( "1112" );
        identificadores.add( "1113" );
        assertEquals( "La cantidad de productos no es la esperada.", 3, productos.size( ) );
        for(String id: identificadores){
            boolean encontrado = false;
            for(int i=0;i<productos.size( ) && !encontrado ; i++){
                encontrado = productos.get( i ).comparar( id ) == 0;
            }
            if(!encontrado){
                fail("No retorno los productos esperados. Falta el "+id);
            }
        }
        
        productos = categoria.buscarNodo( "1100" ).darProductos( );
        identificadores = new ArrayList<>( );
        identificadores.add( "1111" );
        identificadores.add( "1112" );
        identificadores.add( "1113" );
        identificadores.add( "1121" );
        identificadores.add( "1122" );
        identificadores.add( "1123" );
        assertEquals( "La cantidad de productos no es la esperada.", 6, productos.size( ) );
        for(String id: identificadores){
            boolean encontrado = false;
            for(int i=0;i<productos.size( ) && !encontrado ; i++){
                encontrado = productos.get( i ).comparar( id ) == 0;
            }
            if(!encontrado){
                fail("No retorno los productos esperados. Falta el "+id);
            }
        }
        
        productos = categoria.buscarNodo( "1300" ).darProductos( );
        identificadores = new ArrayList<>( );
        identificadores.add( "1310" );
        identificadores.add( "1320" );
        identificadores.add( "1330" );
        assertEquals( "La cantidad de productos no es la esperada.", 3, productos.size( ) );
        for(String id: identificadores){
            boolean encontrado = false;
            for(int i=0;i<productos.size( ) && !encontrado ; i++){
                encontrado = productos.get( i ).comparar( id ) == 0;
            }
            if(!encontrado){
                fail("No retorno los productos esperados. Falta el "+id);
            }
        }
           
        productos = categoria.darProductos( );
        assertEquals( "La cantidad de productos no es la esperada.", 15, productos.size( ) );
    }

    /**
     * <b>Prueba 9</b> : verifica el método darMarcas.<br>
     * <b>Métodos a probar:</b><br>
     * 1. darMarcas.<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se obtienen todas las marcas de varios nodos.<br>
     */
    @Test
    public void testDarMarcas( )
    {
        setupEscenario2( );
        // Caso de prueba 1
        List<Marca> marcas = ((Categoria)categoria.buscarNodo( "1200" )).darMarcas( );
        List<String> identificadores = new ArrayList<>( );
        identificadores.add( "1210" );
        identificadores.add( "1220" );
       
        assertEquals( "La cantidad de marcas no es la esperada.", 2, marcas.size( ) );
        for(String id: identificadores){
            boolean encontrado = false;
            for(int i=0;i<marcas.size( ) && !encontrado ; i++){
                encontrado = marcas.get( i ).darIdentificador( ).equals( id );
            }
            if(!encontrado){
                fail("No retorno las marcas esperadas. Falta la "+id);
            }
        }
        
        marcas =categoria.darMarcas( );
        identificadores.add( "1110" );
        identificadores.add( "1120" );
        identificadores.add( "1300" );
        
        assertEquals( "La cantidad de marcas no es la esperada.", 5, marcas.size( ) );
        for(String id: identificadores){
            boolean encontrado = false;
            for(int i=0;i<marcas.size( ) && !encontrado ; i++){
                encontrado = marcas.get( i ).darIdentificador( ).equals( id );
            }
            if(!encontrado){
                fail("No retorno las marcas esperadas. Falta la "+id);
            }
        }
    }

    /**
     * <b>Prueba 10</b> : verifica el método darPreorden.<br>
     * <b>Métodos a probar:</b><br>
     * 1. darPreorden.<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se obtiene el preorden.<br>
     */
    @Test
    public void testDarPreorden( )
    {
       setupEscenario2( );
       // Caso de prueba 1
       List<String> identificadores = new ArrayList<>( );
       identificadores.add( "A001" );
       identificadores.add( "1100" );
       identificadores.add( "1110" );
       identificadores.add( "1120" );
       identificadores.add( "1200" );
       identificadores.add( "1210" );
       identificadores.add( "1220" );
       identificadores.add( "1300" );
       
       List<NodoAlmacen> preorden = categoria.darPreorden( );
       assertEquals("No retorno todos los productos",8,preorden.size( ));
       for(int i=0; i<preorden.size( );i++){
           if(!preorden.get( i ).darIdentificador( ).equals( identificadores.get( i ) )){
               fail("No retorno el preorden correctamente.");
           }
       }
    }

    /**
     * <b>Prueba 11</b> : verifica el método darPosorden.<br>
     * <b>Métodos a probar:</b><br>
     * 1. darPosorden.<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se obtiene el posorden.<br>
     */
    @Test
    public void testDarPosorden( )
    {
        setupEscenario2( );
        
        // Caso de prueba 1
        List<String> identificadores = new ArrayList<>( );
        identificadores.add( "1110" );
        identificadores.add( "1120" );
        identificadores.add( "1100" );
        identificadores.add( "1210" );
        identificadores.add( "1220" );
        identificadores.add( "1200" );
        identificadores.add( "1300" );
        identificadores.add( "A001" );
        
        List<NodoAlmacen> preorden = categoria.darPosorden( );
        assertEquals("No retorno todos los productos",8,preorden.size( ));
        for(int i=0; i<preorden.size( );i++){
            if(!preorden.get( i ).darIdentificador( ).equals( identificadores.get( i ) )){
                fail("No retorno el preorden correctamente.");
            }
        }
    }
}
