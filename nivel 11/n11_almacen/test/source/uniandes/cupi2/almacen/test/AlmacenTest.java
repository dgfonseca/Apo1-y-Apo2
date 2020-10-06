package uniandes.cupi2.almacen.test;

import uniandes.cupi2.almacen.mundo.Almacen;
import uniandes.cupi2.almacen.mundo.AlmacenException;
import uniandes.cupi2.almacen.mundo.Categoria;
import uniandes.cupi2.almacen.mundo.Marca;
import uniandes.cupi2.almacen.mundo.NodoAlmacen;
import uniandes.cupi2.almacen.mundo.Producto;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

/**
 * Clase de prueba para la clase Almac�n.
 */
public class AlmacenTest
{

	/**
	 * Categor�a sobre el cual se realizaran las pruebas.
	 */
	private Almacen almacen;

	/**
	 * Inicializa el objeto de prueba con datos de prueba.
	 */
	@Before
	public void setupescenario1( )
	{
		try
		{
			almacen = new Almacen( new File( "./data/datos.txt" ) );
		}
		catch( AlmacenException e )
		{
			fail( "No deber�a generar error." );
		}
	}

	/**
	 * Prueba 1: verifica el m�todo agregarNodo.<br>
	 * <b>M�todos a probar:</b><br>
	 * 1. agregarNodo <br>
	 * 2. buscarNodo <br>
	 * <b>Casos de prueba </b><br>
	 * 1. Agrega una categor�a con identificador nuevo.<br>
	 * 2. Agrega una marca con identificador nuevo. <br>
	 * 3. Agrega una categor�a con identificador existente.<br>
	 * 4. Agrega una marca con identificador existente.
	 */
	@Test
	public void testAgregarNodo( )
	{
		try
		{
			// Caso de prueba 1
			almacen.agregarNodo( "11", Categoria.TIPO, "C-1100", "Categor�a Prueba" );
			assertNotNull( "No agreg� el nodo.", almacen.buscarNodo( "C-1100" ) );

			// Caso de prueba 2
			almacen.agregarNodo( "C-1100", Marca.TIPO, "M-1100", "Marca Prueba" );
			assertNotNull( "No agreg� el nodo.", almacen.buscarNodo( "M-1100" ) );
		}
		catch( AlmacenException e )
		{
			fail( "No deber�a generar excepci�n" );
		}

		// Caso de prueba 3
		try
		{
			almacen.agregarNodo( "1", Categoria.TIPO, "M-1100", "Categor�a Prueba" );
		}
		catch( Exception e )
		{
			// Deber�a generar excepci�n.
		}

		// Caso de prueba 4
		try
		{
			almacen.agregarNodo( "1", Marca.TIPO, "C-1100", "Marca Prueba" );
		}
		catch( Exception e )
		{
			// Deber�a generar excepci�n.
		}

	}

	/**
	 * Prueba 2: verifica el m�todo eliminarNodo.<br>
	 * <b>M�todos a probar:</b><br> 
	 * 1. eliminarNodo <br>
	 * 2. buscarNodo <br>
	 * <b>Casos de prueba </b><br>
	 * 1. Elimina una categor�a.<br>
	 * 2. Elimina una marca. <br>
	 * 3. Elimina la ra�z.
	 */
	@Test
	public void testEliminarNodo(){
		try
		{
			// Caso de prueba 1
			NodoAlmacen padre = almacen.eliminarNodo( "112" );
			assertNotNull("No retorno el padre del nodo.", padre);
			assertEquals("No retorno el padre del nodo.","11",padre.darIdentificador( ));
			assertNull("No elimin� el nodo",almacen.buscarNodo( "112" ));

			// Caso de prueba 2
			padre = almacen.eliminarNodo( "1112" );
			assertNotNull("No retorno el padre del nodo.", padre);
			assertEquals("No retorno el padre del nodo.","111",padre.darIdentificador( ));
			assertNull("No elimin� el nodo",almacen.buscarNodo( "1112" ));
		}
		catch( AlmacenException e )
		{
			fail("No deber�a generar excepci�n.");
		}

		// Caso de prueba 3
		try
		{
			almacen.eliminarNodo( "1" );
			fail("Deber�a generar excepci�n.");
		}
		catch( Exception e )
		{
			// Deber�a generar excepci�n.
			assertNotNull("No debi� elimnar el nodo",almacen.buscarNodo( "1" ));
		}
	}

	/**
	 * Prueba 3: verifica el m�todo venderProducto.<br>
	 * <b>M�todos a probar:</b><br> 
	 * 1. venderProducto <br>
	 * <b>Casos de prueba </b><br>
	 * 1. Vende una cantidad dada de un producto.<br>
	 */
	@Test
	public void testVenderProducto(){
		// Caso de prueba 1
		almacen.venderProducto( "30999821", 3 );
		Producto producto = almacen.darCategoriaRaiz( ).buscarProducto( "30999821" );
		assertEquals("No se vendieron las unidades.", 3, producto.darCantidadUnidadesVendidas( ));
	}

	/**
	 * Prueba 4: verifica el m�todo buscarNodo.<br>
	 * <b>M�todos a probar:</b><br> 
	 * 1. buscarNodo <br>
	 * <b>Casos de prueba </b><br>
	 * 1. Busca una categor�a existente.<br>
	 * 2. Busca una marca existente.<br>
	 * 3. Busca un nodo que no existe.
	 */
	@Test
	public void testBuscarNodo(){
		// Caso de prueba 1
		NodoAlmacen nodo = almacen.buscarNodo( "112" );
		assertNotNull("No se encontr� el nodo.", nodo);
		assertEquals("No se encontr� el nodo correcto.", "112", nodo.darIdentificador( ));

		// Caso de prueba 2
		nodo = almacen.buscarNodo( "1123" );
		assertNotNull("No se encontr� el nodo.", nodo);
		assertEquals("No se encontr� el nodo correcto.", "1123", nodo.darIdentificador( ));

		// Caso de prueba 3
		assertNull("No debi� encontrar ning�n nodo.", almacen.buscarNodo( "1124" ));
	}

	/**
	 * Prueba 5: verifica el m�todo agregarProducto.<br>
	 * <b>M�todos a probar:</b><br> 
	 * 1. agregarProducto <br>
	 * <b>Casos de prueba </b><br>
	 * 1. Agrega un producto con c�digo nuevo.<br>
	 * 2. Agrega un producto con c�digo existente.
	 */
	@Test
	public void testAgregarProducto(){

		// Caso de prueba 1
		try
		{
			almacen.agregarProducto( "1122", "T-1", "Producto T", "Producto de prueba", 5000 );
			Producto producto = almacen.darCategoriaRaiz( ).buscarProducto( "T-1" );
			assertNotNull("No se agreg� el producto.", producto);
		}
		catch( AlmacenException e )
		{
			fail("No deber�a generar excepci�n.");
		}

		// Caso de prueba 2
		try
		{ 
			almacen.agregarProducto( "1122", "30999801", "Producto T", "Producto de prueba", 5000 );
			fail("Deber�a generar excepci�n.");
		}
		catch( Exception e )
		{
			//Deber�a generar excepci�n.
		}
	}

	/**
	 * Prueba 6: verifica el m�todo eliminarProducto.<br>
	 * <b>M�todos a probar:</b><br> 
	 * 1. eliminarProducto <br>
	 * <b>Casos de prueba </b><br>
	 * 1. Elimina varios productos.<br>
	 */
	@Test
	public void testEliminarProductos(){
		List<Producto> productos = almacen.darCategoriaRaiz( ).darProductos( );

		// Caso de prueba 1
		for(Producto producto: productos){
			almacen.eliminarProducto( producto.darCodigo( ) );
			assertNull("No se elimin� el producto.", almacen.darCategoriaRaiz( ).buscarProducto( producto.darCodigo( ) ));
		}
	}


}
