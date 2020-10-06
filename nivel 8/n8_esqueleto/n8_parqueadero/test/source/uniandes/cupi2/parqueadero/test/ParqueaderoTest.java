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

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import uniandes.cupi2.parqueadero.mundo.Carro;
import uniandes.cupi2.parqueadero.mundo.Parqueadero;
import uniandes.cupi2.parqueadero.mundo.PersistenciaException;

/**
 * Clase de prueba para el Parqueadero
 */
public class ParqueaderoTest
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Parqueadero para el escenario 1
     */
    private Parqueadero parqueadero1;

    /**
     * Parqueadero para el escenario 2
     */
    private Parqueadero parqueadero2;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construir el escenario 1
     */
    @Before
    public void setupEscenario1( )
    {
        try
        {
            parqueadero1 = new Parqueadero( "./test/data/archivoTest.data" );
        }
        catch(Exception e)
        {
            fail("No debería generar excepción");
        }
    }

    /**
     * Construir el escenario 2
     */
    private void setupEscenario2( )
    {
        try
        {
            parqueadero2 = new Parqueadero( "./test/data/archivoTest.data" );
        }
        catch(Exception e)
        {
            fail("No debería generar excepción");
        }
        try
        {
            parqueadero2.ingresarCarro( "ppp111", "Renault", "4" );
            parqueadero2.avanzarHora( );
            parqueadero2.ingresarCarro( "ppp222", "Rene", "Logan" );
            parqueadero2.avanzarHora( );
            parqueadero2.ingresarCarro( "ppp333", "Mazda", "2011" );
            parqueadero2.avanzarHora( );
            parqueadero2.ingresarCarro( "ppp444", "Pegueot", "2015" );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Verificar que la hora avance correctamente
     */
    @Test
    public void testAvanzarHora( )
    {
        int horaActual1 = parqueadero1.darHoraActual( );
        parqueadero1.avanzarHora( );
        int horaActual2 = parqueadero1.darHoraActual( );
        assertEquals( "La hora no avanza correctamente", horaActual1 + 1, horaActual2 );
    }

    /**
     * Verificar que el número de puestos libres se calcule correctamente
     */
    @Test
    public void testCalcularPuestosLibres( )
    {
        setupEscenario2( );

        assertEquals( "El parqueadero vacío no tiene el número correcto de puestos libres", Parqueadero.TAMANO, parqueadero1.calcularCantidadPuestosLibres( ) );

        assertEquals( "El parqueadero no-vacío no tiene el número correcto de puestos libres", Parqueadero.TAMANO - 4, parqueadero2.calcularCantidadPuestosLibres( ) );

        // Llenar el parqueadero
        for( int i = 0; i < Parqueadero.TAMANO; i++ )
        {
            try
            {
                if( i <= 9 )
                {
                    parqueadero1.ingresarCarro( "ppppp" + i, "Marca" + i, "Modelo" + i );
                }
                else
                {
                    parqueadero1.ingresarCarro( "pppp" + i, "Marca" + i, "Modelo" + i );
                }
            }
            catch( Exception e )
            {
                fail( "No debería generar excepción" );
            }
            assertEquals( "El parqueadero no-vacío no tiene el número correcto de puestos libres", Parqueadero.TAMANO - (i + 1), parqueadero1.calcularCantidadPuestosLibres( ) );
        }

        // Verificar que despues de lleno el parqueadero no recibe más carros ni cambia el
        // número de puestos disponibles
        try
        {
            parqueadero1.ingresarCarro( "aaaaa" + 0, "Marca" + 0, "Modelo" + 0 );
        }
        catch( Exception e )
        {
            //Debe generar excepción.
        }

        assertEquals( "El parqueadero lleno no tiene el número correcto de puestos libres", 0, parqueadero1.calcularCantidadPuestosLibres( ) );

    }

    /**
     * Verificar que la tarifa se pueda cambiar
     */
    @Test
    public void testCambiarTarifa( )
    {
        int viejaTarifa = parqueadero1.darTarifa( );
        int nuevaTarifa = 2000;

        parqueadero1.cambiarTarifa( nuevaTarifa );
        assertTrue( "La tarifa no fue modificada", viejaTarifa != nuevaTarifa && parqueadero1.darTarifa( ) == nuevaTarifa );
    }

    /**
     * Verificar que el monto en caja se calcule correctamente
     */
    @Test
    public void testDarMontoCaja( )
    {
        int tarifa = parqueadero1.darTarifa( );
        int montoEsperado = 0;
        assertTrue( "El monto inicial debería ser 0", montoEsperado == parqueadero1.darMontoCaja( ) );

        try
        {
            // Carro que entra y sale
            parqueadero1.ingresarCarro( "ppp111", "Marcappp111", "Modeloppp111" );
            parqueadero1.sacarCarro( "ppp111" );
            montoEsperado += tarifa;
            assertTrue( "Un carro durante una hora debería representar 1000", montoEsperado == parqueadero1.darMontoCaja( ) );

            // Carro que se demora una hora
            parqueadero1.ingresarCarro( "ppp222", "Marcappp222", "Modeloppp222" );
            parqueadero1.avanzarHora( );
            parqueadero1.sacarCarro( "ppp222" );
            montoEsperado += tarifa * 2;
            assertTrue( "Un carro durante dos horas debería representar 2000 más", montoEsperado == parqueadero1.darMontoCaja( ) );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Verifica la entrada normal de carros
     */
    @Test
    public void testEntrarCarro1( )
    {
        // Parquear un carro
        try
        {
            int pos1 = parqueadero1.ingresarCarro( "ppp111", "Marcappp111", "Modeloppp111" );
            assertTrue( "El puesto que se le asignó al carro aparece como no ocupado", parqueadero1.estaOcupado( pos1 ) );
        }
        catch( Exception e )
        {
            fail( "No permite entrar un carro al parqueadero abierto y vacío." );
        }

        try
        {
            parqueadero1.sacarCarro( "ppp111" );
        }
        catch( Exception e )
        {
            fail( "No permite sacar el carro." );
        }

    }

    /**
     * Verifica que durante la entrada de carros a ninguno se le asigna un puesto que ya se había asignado
     */
    @Test
    public void testEntrarCarro2( )
    {
        // Verificar que a ningún otro carro se le asigna la misma posición de un carro ya
        // parqueado
        boolean[] vacios = new boolean[Parqueadero.TAMANO];

        for( int i = 0; i < Parqueadero.TAMANO * 2; i++ )
        {
            if(i >= Parqueadero.TAMANO)
            {
                try
                {
                    parqueadero1.ingresarCarro( "pppp" + i, "Marca" + i, "Modelo" + i );
                    fail("Debe generar excepción.");
                }
                catch( Exception e )
                {
                    //Debe generar excepción.
                }
            }
            else
            {
                try
                {
                    if( i <= 9 )
                    {
                        parqueadero1.ingresarCarro( "ppppp" + i, "Marca" + i, "Modelo" + i );
                    }
                    else
                    {
                        parqueadero1.ingresarCarro( "pppp" + i, "Marca" + i, "Modelo" + i );
                    }
                }
                catch( Exception e )
                {
                    fail( "No está permitiendo ingresar carros." );
                }
            }
        }
    }

    /**
     * Verifica que durante la entrada de carros si el parqueadero está lleno siempre se informa de esto y que si hay un carro que sale entonces el siguiente carro que llegue
     * puede parquear
     */
    @Test
    public void testEntrarCarro3( )
    {
        // Llenar el parqueadero
        for( int i = 0; i < Parqueadero.TAMANO * 2; i++ )
        {
            if( i >= Parqueadero.TAMANO )
            {
                try
                {
                    parqueadero1.ingresarCarro( "ppppp" + i, "m" + i, "p" + i );
                    fail( "No lanza excepción al entrar un carro al parqueadero lleno." );
                }
                catch( Exception e )
                {
                    // Debe lanzar excepción.
                }
            }
            else
            {
                try
                {
                    if( i <= 9 )
                    {
                        parqueadero1.ingresarCarro( "ppppp" + i, "Marca" + i, "Modelo" + i );
                    }
                    else
                    {
                        parqueadero1.ingresarCarro( "pppp" + i, "Marca" + i, "Modelo" + i );
                    }
                }
                catch( Exception e )
                {
                    fail( "No debería lanzar excepción" );
                }
            }

        }

        try
        {
            parqueadero1.sacarCarro( "ppp0" );
            parqueadero1.ingresarCarro( "nuevo", "marca", "modelo" );
            fail( "No lanza excepción al ingresar un carro al parqueadero lleno." );
        }
        catch( Exception e )
        {
            // Debe lanzar excepción.
        }
    }

    /**
     * Verifica que no se puede entrar carros cuando el parqueadero está cerrado
     */
    @Test
    public void testEntrarCarro4( )
    {
        while( parqueadero1.estaAbierto( ) )
            parqueadero1.avanzarHora( );

        try
        {
            parqueadero1.ingresarCarro( "placa", "marca", "modelo" );
            fail( "No lanza excepción al ingresar un carro al parqueadero cerrado." );
        }
        catch( Exception e )
        {
            // Debe lanzar excepción.
        }
    }

    /**
     * Verifica que no se puede parquear dos carros con la misma placa en el parqueadero
     */
    @Test
    public void testEntrarCarro5( )
    {
        setupEscenario2( );

        // Parquear un carro
        try
        {
            parqueadero2.ingresarCarro( "ppp111", "ppp111", "ppp111" );
            fail( "No lanza excepción al ingresar un carro al parqueadero donde ya existe un carro con la placa especificada." );
        }
        catch( Exception e )
        {
            // Debe lanzar excepción.
        }
    }

    /**
     * Verifica el método estaAbierto
     */
    @Test
    public void testEstaAbierto( )
    {
        for( int i = parqueadero1.darHoraActual( ); i < Parqueadero.HORA_CIERRE + 2; i++ )
        {
            int actual = parqueadero1.darHoraActual( );
            if( actual >= Parqueadero.HORA_INICIAL && actual < Parqueadero.HORA_CIERRE )
            {
                assertTrue( "El parqueadero está cerrado durante el tiempo que debería esta abierto", parqueadero1.estaAbierto( ) );
            }
            else
            {
                assertFalse( "El parqueadero está abierto en una hora en la que debería esta cerrado", parqueadero1.estaAbierto( ) );
            }

            parqueadero1.avanzarHora( );
        }
    }

    /**
     * Verificar que el estado ocupado o no de cada puesto se maneja correctamente
     */
    @Test
    public void testEstaOcupado( )
    {
        // Verificar que las posiciones que se asignan quedan marcadas como ocupadas
        int[] posiciones = new int[Parqueadero.TAMANO];

        for( int i = 0; i < Parqueadero.TAMANO; i++ )
        {
            try
            {
                if( i <= 9 )
                {
                    parqueadero1.ingresarCarro( "ppppp" + i, "Marca" + i, "Modelo" + i );
                }
                else
                {
                    parqueadero1.ingresarCarro( "pppp" + i, "Marca" + i, "Modelo" + i );
                }
            }
            catch( Exception e )
            {
                fail( "No debería generar excepción." );
            }
            assertTrue( "La posición del nuevo carro no aparece marcada como ocupada", parqueadero1.estaOcupado( posiciones[ i ] ) );
        }

        // Sacar todos los carros del parqueadero y verificar que todas las posiciones
        // quedaron marcadas como vacias
        for( int i = 0; i < Parqueadero.TAMANO; i++ )
        {
            try
            {
                if( i <= 9 )
                {
                    parqueadero1.sacarCarro( "ppppp" + i );
                }
                else
                {
                    parqueadero1.sacarCarro( "pppp" + i );
                }
            }
            catch( Exception e )
            {
                fail( "No debería generar excepción." );
            }
            assertFalse( "La posición del carro que salió no aparece marcada como vacía", parqueadero1.estaOcupado( posiciones[ i ] ) );
        }
    }

    /**
     * Verificar sacarCarro
     */
    @Test
    public void testSacarCarro1( )
    {
        int tarifa = parqueadero1.darTarifa( );

        // Llenar el parqueadero
        for( int i = 0; i < Parqueadero.TAMANO; i++ )
        {
            try
            {
                if( i <= 9 )
                {
                    parqueadero1.ingresarCarro( "ppppp" + i, "Marca" + i, "Modelo" + i );
                }
                else
                {
                    parqueadero1.ingresarCarro( "pppp" + i, "Marca" + i, "Modelo" + i );
                }
            }
            catch( Exception e )
            {
                fail( "No debería generar excepción." );
            }
        }

        // Sacar todos los carros del parqueadero en la misma hora
        for( int i = 0; i < Parqueadero.TAMANO; i++ )
        {
            try
            {
                int valor = 0;
                if( i <= 9 )
                {
                    valor = parqueadero1.sacarCarro( "ppppp" + i );
                }
                else
                {
                    valor = parqueadero1.sacarCarro( "pppp" + i );
                }
                assertEquals( "La tarifa cobrada es incorrecta", tarifa, valor );
            }
            catch( Exception e )
            {
                fail( "No debería generar excepción al sacar el carro." );
            }
        }

        // Llenar el parqueadero
        for( int i = 0; i < Parqueadero.TAMANO; i++ )
        {
            try
            {
                if( i <= 9 )
                {
                    parqueadero1.ingresarCarro( "ppppp" + i, "Marca" + i, "Modelo" + i );
                }
                else
                {
                    parqueadero1.ingresarCarro( "pppp" + i, "Marca" + i, "Modelo" + i );
                }
            }
            catch( Exception e )
            {
                fail( "No debería generar excepción." );
            }
        }

        parqueadero1.avanzarHora( );

        // Sacar todos los carros del parqueadero después de una hora
        for( int i = 0; i < Parqueadero.TAMANO; i++ )
        {
            try
            {
                int valor = 0;
                if( i <= 9 )
                {
                    valor = parqueadero1.sacarCarro( "ppppp" + i );
                }
                else
                {
                    valor = parqueadero1.sacarCarro( "pppp" + i );
                }
                assertEquals( "La tarifa cobrada es incorrecta", tarifa * 2, valor );
            }
            catch( Exception e )
            {
                fail( "No debería generar excepción." );
            }
        }
    }

    /**
     * Verificar sacarCarro con carros que no estaban en el parqueadero
     */
    @Test
    public void testSacarCarro2( )
    {
        // Sacar carros del parqueadero que no estaban parqueados
        for( int i = 0; i < Parqueadero.TAMANO; i++ )
        {
            try
            {
                parqueadero1.sacarCarro( "ppp" + i );
                fail( "Se sacó un carro que no estaba parqueado." );
            }
            catch( Exception e )
            {
                // Debe lanzar excepción.
            }
        }
    }

    /**
     * Verifica que no se puede sacar carros cuando el parqueadero está cerrado
     */
    @Test
    public void testSacarCarro4( )
    {
        setupEscenario2( );

        while( parqueadero2.estaAbierto( ) )
            parqueadero2.avanzarHora( );

        try
        {
            parqueadero1.sacarCarro( "ppp111" );
            fail( "Se sacó un carro en el parqueadero cerrado." );
        }
        catch( Exception e )
        {
            // Debe lanzar excepción.
        }
    }
    
    /**
     * Verifica el método darPlacaCarro.<br>
     * <b>Métodos a probar:</b><br>
     * darPlacaCarro<br>
     * <b>Casos de prueba:</b><br>
     * 1. Da la placa correcta de un carro en el puesto especificado.
     * 2. No hay placa pues no hay un carro en el puesto especificado.
     */
    @Test
    public void testDarPlacaCarro( )
    {
        // Caso de prueba 1
        try
        {
            parqueadero1.ingresarCarro( "AAA111", "Marca1", "Modelo1" );
            parqueadero1.darPlacaCarro( 0 );
        }
        catch(Exception e)
        {
            fail("No debería generar excepción");
        }
        
        // Caso de prueba 2
        try
        {
            parqueadero1.darPlacaCarro( 5 );
            fail("Debería generar excepción pues no hay un carro en el puesto especificado.");

        }
        catch(Exception e)
        {
            //Debe generar excepción
        }
    }

    /**
     * Verifica el método ordenarPorMarca.<br>
     * <b>Métodos a probar:</b><br>
     * ordenarPorMarca<br>
     * <b>Casos de prueba:</b><br>
     * 1. Existen 4 carros en el parqueadero.
     */
    @Test
    public void testOrdenarPorMarca( )
    {
        // Caso de prueba 1
        setupEscenario2( );
        parqueadero2.ordenarPorMarca( );

        ArrayList<Carro> carros = parqueadero2.darCarros( );

        for( int i = 0; i < carros.size( ) - 1; i++ )
        {
            Carro actual = carros.get( i );
            Carro siguiente = carros.get( i + 1 );

            assertEquals( "El carro número " + i + " no está en la posición correcta", -1 ,actual.compararPorMarca( siguiente ) );
        }    
    }

    /**
     * Verifica el método ordenarPorModelo.<br>
     * <b>Métodos a probar:</b><br>
     * ordenarPorModelo<br>
     * <b>Casos de prueba:</b><br>
     * 1. Existen 4 carros en el parqueadero.
     */
    @Test
    public void testOrdenarPorModelo( )
    {
        // Caso de prueba 1
        setupEscenario2( );
        parqueadero2.ordenarPorModelo( );

        ArrayList<Carro> carros = parqueadero2.darCarros( );

        for( int i = 0; i < carros.size( ) - 1; i++ )
        {
            Carro actual = carros.get( i );
            Carro siguiente = carros.get( i + 1 );

            assertEquals( "El carro número " + i + " no está en la posición correcta", actual.compararPorModelo( siguiente ), 1 );
        }    }

    /**
     * Verifica el método ordenarPorHoraIngreso.<br>
     * <b>Métodos a probar:</b><br>
     * ordenarPorHoraIngreso<br>
     * <b>Casos de prueba:</b><br>
     * 1. Existen 4 carros en el parqueadero.
     */
    @Test
    public void testOrdenarPorHoraIngreso( )
    {
        // Caso de prueba 1
        setupEscenario2( );
        parqueadero2.ordenarPorHoraIngreso( );

        ArrayList<Carro> carros = parqueadero2.darCarros( );

        for( int i = 0; i < carros.size( ) - 1; i++ )
        {
            Carro actual = carros.get( i );
            Carro siguiente = carros.get( i + 1 );

            assertEquals( "El carro número " + i + " no está en la posición correcta", actual.compararPorHoraIngreso( siguiente ), -1 );
        }    }

    /**
     * Verifica el método buscarPorPlaca.<br>
     * <b>Métodos a probar:</b><br>
     * buscarPorPlaca<br>
     * <b>Casos de prueba:</b><br>
     * 1. El carro buscado por su placa existe en el parqueadero.<br>
     * 2. El carro buscado por su placa no existe en el parqueadero.
     */
    @Test
    public void testBuscarPorPlaca( )
    {
        setupEscenario2( );

        try
        {
            // Caso de prueba 1
            assertNotNull( "Debió encontrar el carro", parqueadero2.buscarCarroPorPlaca( "ppp111" ) );
            assertEquals( "El carro encontrado no es el correcto", parqueadero2.buscarCarroPorPlaca( "ppp111").darMarca( ), "Renault" );

        }
        catch(Exception e)
        {
            fail("No debería generar excepción.");
        }

        try
        {

            // Caso de prueba 2
            assertNull( "No debió encontrar el carro pues no existe", parqueadero2.buscarCarroPorPlaca( "ppp555") );   
            fail("Debería generar excepción.");
        }
        catch(Exception e)
        {
            //Debe generar excepción
        }
    }

    /**
     * Verifica el método buscarPorHoraIngreso.<br>
     * <b>Métodos a probar:</b><br>
     * buscarPorHoraIngreso<br>
     * <b>Casos de prueba:</b><br>
     * 1. El carro buscado por su hora de ingreso existe en el parqueadero.<br>
     * 2. El carro buscado por su hora de ingreso no existe en el parqueadero.
     */
    @Test
    public void testBuscarPorHoraIngreso( )
    {
        setupEscenario2( );

        // Caso de prueba 1
        assertNotNull( "Debió encontrar el carro", parqueadero2.buscarPorHoraIngreso( 6 ) );
        assertEquals( "El carro encontrado no es el correcto", parqueadero2.buscarPorHoraIngreso( 6 ).darModelo( ), "4" );

        // Caso de prueba 2
        assertNull( "No debió encontrar el carro pues no existe", parqueadero2.buscarPorHoraIngreso( 12 ) );    
    }
    
    /**
     * Verifica el método cargar.<br>
     * <b>Métodos a probar:</b><br>
     * cargar<br>
     * <b>Casos de prueba:</b><br>
     * 1. No se carga el archivo porque no es válido.<br>
     * 2. Se carga el archivo.
     */
    @Test
    public void testCargar( )
    {
        // Caso de prueba 1
        try
        {
            parqueadero1.cargar( "./data/archivo1.txt" );
            fail( "No debió cargar el estado pues el tipo del archivo no es válido." );
        }
        catch( PersistenciaException e )
        {
            // Debe generar excepción
        }

        // Caso de prueba 2
        try
        {
            parqueadero1.guardar( "./test/data/archivoTest.data" );
            parqueadero1.cargar( "./test/data/archivoTest.data" );
        }
        catch( PersistenciaException e )
        {
            fail( "No debió generar excepción pues este archivo es válido" );
        }
    }

    /**
     * Verifica el método guardar.<br>
     * <b>Métodos a probar:</b><br>
     * guardar<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se guarda el archivo.
     */
    @Test
    public void testGuardar( )
    {
        // Caso de prueba 1
        try
        {
            parqueadero1.guardar( "./test/data/archivoTest.data" );
        }
        catch( PersistenciaException e )
        {
            fail( "No debió generar excepción pues este archivo es válido" );
        }
    }
    
    /**
     * Verifica el método importarArchivoTexto.<br>
     * <b>Métodos a probar:</b><br>
     * importarArchivoTexto<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se importa el estado del mundo a partir el archivo de texto.
     */
    @Test
    public void testImportarArchivoTexto( )
    {
        // Caso de prueba 1
        try
        {
            parqueadero1.importarArchivoTexto( new File("./data/carros.txt") );
            assertTrue("No cargó correctamente los carros", parqueadero1.darCarros( ).size( ) == 38);
            assertTrue("No cargó correctamente la tarifa ", parqueadero1.darTarifa( ) == 1800);
            assertTrue("No cargó correctamente el valor en caja ", parqueadero1.darMontoCaja( ) == 52500);

        }
        catch( Exception e )
        {
            fail( "No debió generar excepción pues este archivo es válido" );
        }
    }

}
