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

import uniandes.cupi2.hotel.mundo.Hotel;
import uniandes.cupi2.hotel.mundo.Habitacion.Categoria;
import uniandes.cupi2.hotel.mundo.Servicio.Tipo;

/**
 * Clase usada para verificar que los métodos de la clase Hotel estén correctamente implementados.
 */
public class HotelTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Hotel en el que se realizarán las pruebas.
     */
    private Hotel hotel;

    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------
    /**
     * Crea una instancia de la clase Hotel. Este método se ejecuta antes de cada método de prueba.
     */
    @Before
    public void setupEscenario1( )
    {
        hotel = new Hotel( );
    }

    // -----------------------------------------------------------------
    // Métodos de prueba
    // -----------------------------------------------------------------

    /**
     * <b>Prueba 1</b> : verifica el método constructor del Hotel.<br>
     * <b>Métodos a probar: </b><br>
     * Hotel<br>
     * darHabitacion<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se crea el hotel correctamente.
     */
    @Test
    public void testHotel( )
    {

        // Caso de prueba 1
        for( int i = 1; i <= 20; i++ )
        {
            assertNotNull( "La habitación debería existir.", hotel.darHabitacion( i ) );
            assertEquals( "El número de la habitación no corresponde.", i, hotel.darHabitacion( i ).darNumero( ), 0.0001 );

            Categoria categoriaEsperada = Categoria.EJECUTIVA;

            if( i >= 7 && i <= 10 )
            {
                categoriaEsperada = Categoria.DOBLE;
            }
            else if( i >= 11 && i <= 19 )
            {
                categoriaEsperada = Categoria.SUITE;
            }
            else if( i == 20 )
            {
                categoriaEsperada = Categoria.PRESIDENCIAL;
            }

            assertEquals( "La categoría de la habitación no corresponde.", categoriaEsperada, hotel.darHabitacion( i ).darCategoria( ) );

        }

    }

    /**
     * <b>Prueba 2</b> : verifica el método darHabitacion.<br>
     * <b>Métodos a probar: </b><br>
     * darHabitacion<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se retornan las habitaciones en el arreglo.<br>
     * 2. No se deben retornar las habitaciones no existentes.
     */
    @Test
    public void darHabitacion( )
    {

        // Caso de prueba 1
        for( int i = 1; i <= 20; i++ )
        {
            assertNotNull( "La habitación debería existir.", hotel.darHabitacion( i ) );
            assertEquals( "No se retorna la habitación correcta.", i, hotel.darHabitacion( i ).darNumero( ), 0.0001 );
        }

        // Caso de prueba 2
        for( int i = 21; i <= 30; i++ )
        {
            assertNull( "La habitación no debería existir.", hotel.darHabitacion( i ) );
        }

        assertNull( "La habitación no debería existir.", hotel.darHabitacion( 0 ) );

    }

    /**
     * <b>Prueba 3</b> : verifica el método darConsumo.<br>
     * <b>Métodos a probar: </b><br>
     * darConsumo<br>
     * registrarHuesped<br>
     * adquirirServicio<br>
     * pagarServicio<br>
     * <b>Casos de prueba:</b><br>
     * 1. No se realizan consumos en las habitaciones.<br>
     * 2. Se consumen servicios de internet y spa en todas las habitaciones. 3. Escenario 2 y se pagan las deudas de la aplicación.
     */
    @Test
    public void darConsumo( )
    {

        // Caso de prueba 1
        for( int i = 1; i <= 20; i++ )
        {
            hotel.registrarHuesped( i, "Carlos", "1234"+i );
            assertEquals( "El consumo no corresponde.", 0, hotel.darConsumo( i ), 0.0001 );
        }

        // Caso de prueba 2
        for( int i = 1; i <= 20; i++ )
        {
            hotel.adquirirServicio( i, Tipo.INTERNET, 100 );
            hotel.adquirirServicio( i, Tipo.SPA, 100 );
            assertEquals( "El consumo no corresponde.", 200, hotel.darConsumo( i ), 0.0001 );
        }

        // Caso de prueba 3
        for( int i = 1; i <= 20; i++ )
        {
            hotel.pagarServicio( i, 1 );
            hotel.pagarServicio( i, 2 );
        }

        for( int i = 1; i <= 20; i++ )
        {
            assertEquals( "El consumo no corresponde.", 200, hotel.darConsumo( i ), 0.0001 );
        }

    }

    /**
     * <b>Prueba 4</b> : verifica el método darDeuda.<br>
     * <b>Métodos a probar: </b><br>
     * darDeuda<br>
     * registrarHuesped<br>
     * adquirirServicio<br>
     * pagarServicio<br>
     * <b>Casos de prueba:</b><br>
     * 1. No se realizan consumos en las habitaciones.<br>
     * 2. Se consumen servicios de internet y spa en todas las habitaciones y no se pagan. <br>
     * 3. Se consumen servicios de minibar e internet en todas las habitaciones y se pagan secuencialmente. <br>
     */
    @Test
    public void darDeuda( )
    {
        // Caso de prueba 1
        for( int i = 1; i <= 20; i++ )
        {
            hotel.registrarHuesped( i, "Carlos", "1234"+i );
            assertEquals( "La deuda calculada no es correcta.", 0, hotel.darDeuda( i ), 0.0001 );
        }

        // Caso de prueba 2
        setupEscenario1( );
        for( int i = 1; i <= 20; i++ )
        {
            hotel.registrarHuesped( i, "Carlos", "1234"+i );
            hotel.adquirirServicio( i, Tipo.INTERNET, 100 );
            hotel.adquirirServicio( i, Tipo.SPA, 100 );
            assertEquals( "La deuda calculada no es correcta.", 200, hotel.darDeuda( i ), 0.0001 );
        }

        // Caso de prueba 3
        setupEscenario1( );
        for( int i = 1; i <= 20; i++ )
        {
            hotel.registrarHuesped( i, "Carlos", "1234"+i );
            hotel.adquirirServicio( i, Tipo.MINI_BAR, 100 );
            hotel.adquirirServicio( i, Tipo.INTERNET, 100 );
            assertEquals( "La deuda calculada no es correcta.", 200, hotel.darDeuda( i ), 0.0001 );
            hotel.pagarServicio( i, 1 );
            assertEquals( "La deuda calculada no es correcta.", 100, hotel.darDeuda( i ), 0.0001 );
            hotel.pagarServicio( i, 2 );
            assertEquals( "La deuda calculada no es correcta.", 0, hotel.darDeuda( i ), 0.0001 );
        }
    }

    /**
     * <b>Prueba 5</b> : verifica el método darHabitacionMayorConsumo.<br>
     * <b>Métodos a probar: </b><br>
     * darHabitacionMayorConsumo<br>
     * adquirirServicio<br>
     * pagarServicio<br>
     * <b>Casos de prueba:</b><br>
     * 1. Ninguna habitación consume servicios.<br>
     * 2. Todas las habitaciones consumen la misma cantidad. <br>
     * 3. La habitación 10 y 11 tienen el mayor consumo. <br>
     * 4. La habitación 17 tienen el mayor consumo, se paga el servicio. <br>
     */
    @Test
    public void darHabitacionMayorConsumo( )
    {
        // Caso de prueba 1
        assertNull( "No debería retornar una habitación", hotel.darHabitacionMayorConsumo( ) );

        // Caso de prueba 2
        for( int i = 1; i <= 20; i++ )
        {
            hotel.registrarHuesped( i, "Carlos", "1234"+i );
            hotel.adquirirServicio( i, Tipo.MINI_BAR, 100 );
        }

        assertEquals( "No se retorna correctamente la habitación de mayor consumo.", 20, hotel.darHabitacionMayorConsumo( ).darNumero( ), 0.0001 );

        // Caso de prueba 3
        hotel.adquirirServicio( 10, Tipo.MINI_BAR, 100 );
        hotel.adquirirServicio( 11, Tipo.MINI_BAR, 100 );
        assertEquals( "No se retorna correctamente la habitación de mayor consumo.", 11, hotel.darHabitacionMayorConsumo( ).darNumero( ), 0.0001 );

        // Caso de prueba 4
        hotel.adquirirServicio( 17, Tipo.SPA, 900 );
        assertEquals( "No se retorna correctamente la habitación de mayor consumo.", 17, hotel.darHabitacionMayorConsumo( ).darNumero( ), 0.0001 );

        // Caso de prueba 5
        hotel.adquirirServicio( 3, Tipo.INTERNET, 9000 );
        hotel.pagarServicio( 3, 2 );
        assertEquals( "No se retorna correctamente la habitación de mayor consumo.", 3, hotel.darHabitacionMayorConsumo( ).darNumero( ), 0.0001 );

    }

    /**
     * <b>Prueba 6</b> : verifica el método darHabitacionMayorDeuda.<br>
     * <b>Método a probar: </b><br>
     * darHabitacionMayorDeuda<br>
     * adquirirServicio<br>
     * pagarServicio<br>
     * <b>Casos de prueba:</b><br>
     * 1. Ninguna habitación consume servicios.<br>
     * 2. Todas las habitaciones consumen la misma cantidad. <br>
     * 3. La habitación 10 y 11 tienen la mayor deuda. <br>
     * 4. La habitación 10 tiene la mayor deuda, se paga el servicio de la habitación 17. <br>
     * 5. La habitación 1 tiene la mayor deuda. <br>
     */
    @Test
    public void darHabitacionMayorDeuda( )
    {
        // Caso de prueba 1
        assertNull( "No debería retornar una habitación", hotel.darHabitacionMayorDeuda( ) );

        // Caso de prueba 2
        for( int i = 1; i <= 20; i++ )
        {
            hotel.registrarHuesped( i, "Carlos", "1234"+i );
            hotel.adquirirServicio( i, Tipo.MINI_BAR, 100 );
        }

        assertEquals( "No se retorna correctamente la habitación de mayor deuda.", 20, hotel.darHabitacionMayorDeuda( ).darNumero( ), 0.0001 );

        // Caso de prueba 3
        hotel.adquirirServicio( 10, Tipo.MINI_BAR, 100 );
        hotel.adquirirServicio( 11, Tipo.MINI_BAR, 100 );
        assertEquals( "No se retorna correctamente la habitación de mayor deuda.", 11, hotel.darHabitacionMayorDeuda( ).darNumero( ), 0.0001 );

        // Caso de prueba 4
        hotel.adquirirServicio( 17, Tipo.SPA, 900 );
        assertEquals( "No se retorna correctamente la habitación de mayor deuda.", 17, hotel.darHabitacionMayorDeuda( ).darNumero( ), 0.0001 );

        // Caso de prueba 5
        hotel.adquirirServicio( 3, Tipo.INTERNET, 9000 );
        hotel.pagarServicio( 3, 2 );
        assertEquals( "No se retorna correctamente la habitación de mayor deuda.", 17, hotel.darHabitacionMayorDeuda( ).darNumero( ), 0.0001 );

        // Caso de prueba 5
        hotel.adquirirServicio( 1, Tipo.INTERNET, 18000 );
        assertEquals( "No se retorna correctamente la habitación de mayor deuda.", 1, hotel.darHabitacionMayorDeuda( ).darNumero( ), 0.0001 );

    }

    /**
     * <b>Prueba 7</b> : verifica el método darCantidadHabitacionesDisponibles.<br>
     * <b>Método a probar: </b><br>
     * darCantidadHabitacionesDisponibles<br>
     * registrarHuesped<br>
     * <b>Casos de prueba:</b><br>
     * 1. Todas disponibles.<br>
     * 2. Se ocupan 5 habitaciones. <br>
     * 3. Se ocupan todas las habitaciones.
     */
    @Test
    public void darCantidadHabitacionesDisponibles( )
    {
        // Caso de prueba 1
        assertEquals( "No se obtiene el número correcto de habitaciones disponibles.", 20, hotel.darCantidadHabitacionesDisponibles( ), 0.0001 );

        // Caso de prueba 2
        hotel.registrarHuesped( 1, "Juan", "1234" );
        hotel.registrarHuesped( 2, "Juan", "1234" );
        hotel.registrarHuesped( 3, "Juan", "1234" );
        hotel.registrarHuesped( 4, "Juan", "1234" );
        hotel.registrarHuesped( 5, "Juan", "1234" );
        assertEquals( "No se obtiene el número correcto de habitaciones disponibles.", 15, hotel.darCantidadHabitacionesDisponibles( ), 0.0001 );

        // Caso de prueba 3
        for( int i = 6; i <= 20; i++ )
        {
            hotel.registrarHuesped( i, i + "", i + "" );
        }
        assertEquals( "No se obtiene el número correcto de habitaciones disponibles.", 0, hotel.darCantidadHabitacionesDisponibles( ), 0.0001 );

    }

    /**
     * <b>Prueba 8</b> : verifica el método darCantidadHabitacionesOcupadas.<br>
     * <b>Método a probar: </b><br>
     * darCantidadHabitacionesOcupadas<br>
     * registrarHuesped<br>
     * <b>Casos de prueba:</b><br>
     * 1. Ninguna ocupada.<br>
     * 2. Se ocupan 5 habitaciones. <br>
     * 3. Se ocupan todas las habitaciones.
     */
    @Test
    public void darCantidadHabitacionesOcupadas( )
    {
        // Caso de prueba 1
        assertEquals( "No se obtiene el número correcto de habitaciones disponibles.", 0, hotel.darCantidadHabitacionesOcupadas( ), 0.0001 );

        // Caso de prueba 2
        hotel.registrarHuesped( 1, "Juan", "1234" );
        hotel.registrarHuesped( 2, "Juan", "1234" );
        hotel.registrarHuesped( 3, "Juan", "1234" );
        hotel.registrarHuesped( 4, "Juan", "1234" );
        hotel.registrarHuesped( 5, "Juan", "1234" );
        assertEquals( "No se obtiene el número correcto de habitaciones ocupadas.", 5, hotel.darCantidadHabitacionesOcupadas( ), 0.0001 );

        // Caso de prueba 3
        for( int i = 6; i <= 20; i++ )
        {
            hotel.registrarHuesped( i, i + "", i + "" );
        }
        assertEquals( "No se obtiene el número correcto de habitaciones ocupadas.", 20, hotel.darCantidadHabitacionesOcupadas( ), 0.0001 );

    }

    /**
     * <b>Prueba 9</b> : verifica el método darCantidadServiciosHabitacion.<br>
     * <b>Método a probar: </b><br>
     * darCantidadServiciosHabitacion<br>
     * registrarHuesped<br>
     * adquirirServicio<br>
     * <b>Casos de prueba:</b><br>
     * 1. Ninguna habitación solicita servicios.<br>
     * 2. Todas las habitaciones solicitan servicios
     */
    @Test
    public void testDarCantidadServiciosHabitacion( )
    {
        // Caso de prueba 1
        int total = 0;
        for( int i = 1; i <= 20; i++ )
        {
            total += hotel.darCantidadServiciosHabitacion( i, Tipo.INTERNET );
        }
        assertEquals( "No debería tener siervicios en ninguna habitacións.", 0, total, 0.0001 );

        // Caso de prueba 2
        for( int i = 1; i <= 20; i++ )
        {
            hotel.registrarHuesped( i, "Juan", "1234" );
            for( int j = i; j > 0; j-- )
            {
                hotel.adquirirServicio( i, Tipo.INTERNET, i * 10 );
            }

        }

        for( int i = 1; i <= 20; i++ )
        {
            assertEquals( "La cantidad de servicios no corresponde", i, hotel.darCantidadServiciosHabitacion( i, Tipo.INTERNET ), 0.0001 );
        }
    }

    /**
     * <b>Prueba 10</b> : verifica el método darServicioMasSolicitado.<br>
     * <b>Método a probar: </b><br>
     * darServicioMasSolicitado<br>
     * registrarHuesped<br>
     * adquirirServicio<br>
     * <b>Casos de prueba:</b><br>
     * 1. Ninguna habitación solicita servicios.<br>
     * 2. Calcula el servicio más solicitado en la habitación 2
     */
    @Test
    public void testDarServicioMasSolicitado( )
    {
        // Caso de prueba 1
        for( int i = 1; i <= 20; i++ )
        {
            assertNull( "La habitación no debería tener servicios", hotel.darServicioMasSolicitado( i ) );
        }

        // Caso de prueba 2
        hotel.registrarHuesped( 2, "Juan", "1234" );
        hotel.adquirirServicio( 2, Tipo.SPA, 333 );
        hotel.adquirirServicio( 2, Tipo.INTERNET, 333 );
        hotel.adquirirServicio( 2, Tipo.INTERNET, 333 );
        assertEquals( "El servicio más solicitado no se calcula correctamente", Tipo.INTERNET, hotel.darServicioMasSolicitado( 2 ) );
    }

    /**
     * <b>Prueba 11</b> : verifica el método buscarHabitacionPorHuesped.<br>
     * <b>Método a probar: </b><br>
     * buscarHabitacionPorHuesped<br>
     * registrarHuesped<br>
     * <b>Casos de prueba:</b><br>
     * 1. No encuentra los huéspedes ingresados.<br>
     * 2. Encuentra todos los huéspedes ingresados.<br>
     * 3. La habitación 13 y 17 tienen el mismo huésped.
     */
    @Test
    public void testBuscarHabitacionPorHuesped( )
    {
        // Caso de prueba 1
        for( int i = 1; i <= 20; i++ )
        {
            assertNull( "No debería encontrar al huésped", hotel.buscarHabitacionPorHuesped( i + "" ) );
        }

        // Caso de prueba 2
        for( int i = 1; i <= 20; i++ )
        {
            hotel.registrarHuesped( i, "aa" + i, "123" + i );
        }

        for( int i = 1; i <= 20; i++ )
        {
            assertEquals( "Debió encontrar el huésped", i, hotel.buscarHabitacionPorHuesped( "123" + i ).darNumero( ), 0.0001 );
        }
        
        //Caso de prueba 3
        setupEscenario1( );
        hotel.registrarHuesped( 13, "aa", "123" );
        hotel.registrarHuesped( 17, "aa", "123" );
        assertEquals( "No se encontró correctamente al huésped", 13, hotel.buscarHabitacionPorHuesped( "123").darNumero( ), 0.0001 );

    }

    /**
     * <b>Prueba 12</b> : verifica el método registrarHuesped.<br>
     * <b>Método a probar: </b><br>
     * registrarHuesped<br>
     * <b>Casos de prueba:</b><br>
     * 1. Registra el huésped.<br>
     * 2. No debería registrar el huésped (duplicado).
     */
    @Test
    public void testRegistrarHuesped( )
    {
        // Caso de prueba 1
        boolean registra = hotel.registrarHuesped( 1, "a", "123" );
        assertEquals( "Debió registrar el huésped", true, registra );

        // Caso de prueba 2
        registra = hotel.registrarHuesped( 1, "a", "123" );
        assertEquals( "No debería registrar el huésped", false, registra );

    }

    /**
     * <b>Prueba 13</b> : verifica el método darSalidaHuesped.<br>
     * <b>Método a probar: </b><br>
     * darSalidaHuesped<br>
     * registrarHuesped<br>
     * <b>Casos de prueba:</b><br>
     * 1. No hay huésped.<br>
     * 2. Da salida al huésped.<br>
     * 3. No debería salir otro huésped.
     */
    @Test
    public void testDarSalidaHuesped( )
    {
        // Caso de prueba 1
        boolean daSalida = hotel.darSalidaHuesped( 1 );
        assertEquals( "No debió dar salida", false, daSalida );

        // Caso de prueba 2
        hotel.registrarHuesped( 1, "b", "222" );
        daSalida = hotel.darSalidaHuesped( 1 );
        assertEquals( "Debió dar salida al huésped", true, daSalida );

        // Caso de prueba 3
        daSalida = hotel.darSalidaHuesped( 1 );
        assertEquals( "No debió dar salida", false, daSalida );
    }

    /**
     * <b>Prueba 14</b> : verifica el método adquirirServicio.<br>
     * <b>Método a probar: </b><br>
     * adquirirServicio<br>
     * registrarHuesped<br>
     * darCantidadServiciosHabitacion<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se adquiere un servicio correctamente.<br>
     * 2. Se adquieren 20 servicios correctamente. <br>
     */
    @Test
    public void testAdquirirServicio( )
    {
        // Caso de prueba 1
        hotel.registrarHuesped( 1, "ff", "11" );
        hotel.adquirirServicio( 1, Tipo.INTERNET, 123 );
        int servicios = hotel.darCantidadServiciosHabitacion( 1, Tipo.INTERNET );
        assertEquals( "Debe existir un servicio", 1, servicios, 0.0001 );

        // Caso de prueba 2
        hotel.registrarHuesped( 3, "ff", "11" );
        for( int i = 0; i < 20; i++ )
        {
            hotel.adquirirServicio( 3, Tipo.INTERNET, 123 );
        }
        servicios = hotel.darCantidadServiciosHabitacion( 3, Tipo.INTERNET );
        assertEquals( "Debe existir un servicio", 20, servicios, 0.0001 );

    }

    /**
     * <b>Prueba 15</b> : verifica el método pagarServicio.<br>
     * <b>Método a probar: </b><br>
     * pagarServicio<br>
     * registrarHuesped<br>
     * darDeuda<br>
     * darCantidadServiciosHabitacion<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se adquiere un servicio y se paga.<br>
     * 2. Se adquieren 2 servicios, y se paga uno. <br>
     */
    @Test
    public void testPagarServicio( )
    {
        // Caso de prueba 1
        hotel.registrarHuesped( 1, "ff", "11" );
        hotel.adquirirServicio( 1, Tipo.INTERNET, 123 );
        hotel.pagarServicio( 1, 1 );
        double deuda = hotel.darDeuda( 1 );
        assertEquals( "No debería tener deuda la habitación", 0, deuda, 0.0001 );

        // Caso de prueba 2
        hotel.adquirirServicio( 1, Tipo.MINI_BAR, 300 );
        hotel.adquirirServicio( 1, Tipo.MINI_BAR, 300 );
        hotel.pagarServicio( 1, 2 );
        deuda = hotel.darDeuda( 1 );
        assertEquals( "La deuda no es correcta", 300, deuda, 0.0001 );

    }

}
