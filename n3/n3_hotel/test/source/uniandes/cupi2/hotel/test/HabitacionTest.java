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

import uniandes.cupi2.hotel.mundo.Habitacion;
import uniandes.cupi2.hotel.mundo.Habitacion.Categoria;
import uniandes.cupi2.hotel.mundo.Servicio.Tipo;

/**
 * Clase usada para verificar que los métodos de la clase Habitacion estén correctamente implementados.
 */
public class HabitacionTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Habitación en la que se realizarán las pruebas.
     */
    private Habitacion habitacion;

    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------
    /**
     * Crea una instancia de la clase Habitacion. Se crea con categoría EJECUTIVA.
     */
    @Before
    public void setupEscenario1( )
    {
        habitacion = new Habitacion( 1, Categoria.EJECUTIVA );
    }

    /**
     * Crea una instancia de la clase Habitacion. Se crea con categoría DOBLE.
     */
    public void setupEscenario2( )
    {
        habitacion = new Habitacion( 2, Categoria.DOBLE );
    }

    /**
     * Crea una instancia de la clase Habitacion. Se crea con categoría SUITE.
     */
    public void setupEscenario3( )
    {
        habitacion = new Habitacion( 3, Categoria.SUITE );
    }

    /**
     * Crea una instancia de la clase Habitacion. Se crea con categoría PRESIDENCIAL.
     */
    public void setupEscenario4( )
    {
        habitacion = new Habitacion( 4, Categoria.PRESIDENCIAL );
    }

    // -----------------------------------------------------------------
    // Métodos de prueba
    // -----------------------------------------------------------------
    /**
     * <b>Prueba 1</b> : verifica el método constructor de la Habitación.<br>
     * <b>Métodos a probar: </b><br>
     * Habitacion<br>
     * darNumero<br>
     * darCategoria<br>
     * darServicio<br>
     * darHuesped<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se crea la habitación EJECUTIVA correctamente.<br>
     * 2. Se crea la habitación DOBLE correctamente. <br>
     * 3. Se crea la habitación SUITE correctamente. <br>
     * 4. Se crea la habitación PRESIDENCIAL correctamente.
     */
    @Test
    public void testHabitacion( )
    {
        // Caso de prueba 1
        assertEquals( "El número asignado a la habitación no corresponde.", 1, habitacion.darNumero( ) );
        assertEquals( "La categoría asignada a la habitación no corresponde.", Categoria.EJECUTIVA, habitacion.darCategoria( ) );
        assertTrue( "El arreglo de servicios no fue inicializado.", habitacion.darServicios( ) != null );
        assertEquals( "El huésped no fue inicializado en null.", null, habitacion.darHuesped( ) );

        // Caso de prueba 2
        setupEscenario2( );
        assertEquals( "El número asignado a la habitación no corresponde.", 2, habitacion.darNumero( ) );
        assertEquals( "La categoría asignada a la habitación no corresponde.", Categoria.DOBLE, habitacion.darCategoria( ) );
        assertTrue( "El arreglo de servicios no fue inicializado.", habitacion.darServicios( ) != null );
        assertEquals( "El huésped no fue inicializado en null.", null, habitacion.darHuesped( ) );

        // Caso de prueba 3
        setupEscenario3( );
        assertEquals( "El número asignado a la habitación no corresponde.", 3, habitacion.darNumero( ) );
        assertEquals( "La categoría asignada a la habitación no corresponde.", Categoria.SUITE, habitacion.darCategoria( ) );
        assertTrue( "El arreglo de servicios no fue inicializado.", habitacion.darServicios( ) != null );
        assertEquals( "El huésped no fue inicializado en null.", null, habitacion.darHuesped( ) );

        // Caso de prueba 4
        setupEscenario4( );
        assertEquals( "El número asignado a la habitación no corresponde.", 4, habitacion.darNumero( ) );
        assertEquals( "La categoría asignada a la habitación no corresponde.", Categoria.PRESIDENCIAL, habitacion.darCategoria( ) );
        assertTrue( "El arreglo de servicios no fue inicializado.", habitacion.darServicios( ) != null );
        assertEquals( "El huésped no fue inicializado en null.", null, habitacion.darHuesped( ) );

    }

    /**
     * <b>Prueba 2</b> : verifica el método darConsumoTotal.<br>
     * <b>Métodos a probar: </b><br>
     * darConsumoTotal<br>
     * adquirirServicio<br>
     * pagarServicio<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se calcula el consumo total, todos los servicios deberían adquirirse.<br>
     * 2. Se calcula el consumo total, todos los servicios deberían adquirirse.<br>
     * 3. Se calcula el consumo total, pagando los servicios.<br>
     * 4. Se calcula el consumo total, usando el servicio de SPA y pagando servicios.
     */
    @Test
    public void testDarConsumoTotal( )
    {
        // Caso de prueba 1
        habitacion.registrarHuesped( "Juan", "1234" );
        habitacion.adquirirServicio( Tipo.INTERNET, 120 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 120, habitacion.darConsumoTotal( ), 0.001 );
        habitacion.adquirirServicio( Tipo.PELICULAS, 145 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 265, habitacion.darConsumoTotal( ), 0.001 );
        habitacion.adquirirServicio( Tipo.MINI_BAR, 20 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 285, habitacion.darConsumoTotal( ), 0.001 );

        // Caso de prueba 2
        setupEscenario2( );
        habitacion.registrarHuesped( "Juan", "1234" );
        habitacion.adquirirServicio( Tipo.INTERNET, 120 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 120, habitacion.darConsumoTotal( ), 0.001 );
        habitacion.adquirirServicio( Tipo.SPA, 145 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 265, habitacion.darConsumoTotal( ), 0.001 );
        habitacion.adquirirServicio( Tipo.MINI_BAR, 20 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 285, habitacion.darConsumoTotal( ), 0.001 );

        // Caso de prueba 3
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 285, habitacion.darConsumoTotal( ), 0.001 );
        habitacion.pagarServicio( 1 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 285, habitacion.darConsumoTotal( ), 0.001 );
        habitacion.pagarServicio( 2 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 285, habitacion.darConsumoTotal( ), 0.001 );
        habitacion.pagarServicio( 3 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 285, habitacion.darConsumoTotal( ), 0.001 );

        // Caso de prueba 4
        setupEscenario3( );
        habitacion.registrarHuesped( "Juan", "1234" );
        habitacion.adquirirServicio( Tipo.INTERNET, 145.5 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 145.5, habitacion.darConsumoTotal( ), 0.001 );
        habitacion.adquirirServicio( Tipo.MINI_BAR, 20 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 165.5, habitacion.darConsumoTotal( ), 0.001 );
        habitacion.pagarServicio( 2 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 165.5, habitacion.darConsumoTotal( ), 0.001 );
        habitacion.pagarServicio( 1 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 165.5, habitacion.darConsumoTotal( ), 0.001 );

    }

    /**
     * <b>Prueba 3</b> : verifica el método darDeudaTotal.<br>
     * <b>Métodos a probar: </b><br>
     * darDeudaTotal<br>
     * adquirirServicio<br>
     * pagarServicio<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se calcula la deuda total, todos los servicios deberían adquirirse.<br>
     * 2. Se calcula la deuda total, todos los servicios deberían adquirirse.<br>
     * 3. Se calcula la deuda total, pagando los servicios.<br>
     * 4. Se calcula la deuda total, pagando servicios.<br>
     */
    @Test
    public void testDarDeudaTotal( )
    {
        // Caso de prueba 1
        habitacion.registrarHuesped( "Juan", "1234" );
        habitacion.adquirirServicio( Tipo.INTERNET, 120 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 120, habitacion.darDeudaTotal( ), 0.001 );
        habitacion.adquirirServicio( Tipo.PELICULAS, 145 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 265, habitacion.darDeudaTotal( ), 0.001 );
        habitacion.adquirirServicio( Tipo.MINI_BAR, 20 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 285, habitacion.darDeudaTotal( ), 0.001 );

        // Caso de prueba 2
        setupEscenario2( );
        habitacion.registrarHuesped( "Juan", "1234" );
        habitacion.adquirirServicio( Tipo.INTERNET, 120 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 120, habitacion.darDeudaTotal( ), 0.001 );
        habitacion.adquirirServicio( Tipo.SPA, 145 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 265, habitacion.darDeudaTotal( ), 0.001 );
        habitacion.adquirirServicio( Tipo.MINI_BAR, 20 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 285, habitacion.darDeudaTotal( ), 0.001 );

        // Caso de prueba 3
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 285, habitacion.darDeudaTotal( ), 0.001 );
        habitacion.pagarServicio( 1 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 165, habitacion.darDeudaTotal( ), 0.001 );
        habitacion.pagarServicio( 2 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 20, habitacion.darDeudaTotal( ), 0.001 );
        habitacion.pagarServicio( 3 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 0, habitacion.darDeudaTotal( ), 0.001 );

        // Caso de prueba 4
        setupEscenario3( );
        habitacion.registrarHuesped( "Juan", "1234" );
        habitacion.adquirirServicio( Tipo.INTERNET, 145.5 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 145.5, habitacion.darDeudaTotal( ), 0.001 );
        habitacion.adquirirServicio( Tipo.SPA, 37 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 182.5, habitacion.darDeudaTotal( ), 0.001 );
        habitacion.adquirirServicio( Tipo.MINI_BAR, 20 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 202.5, habitacion.darDeudaTotal( ), 0.001 );
        habitacion.pagarServicio( 3 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 182.5, habitacion.darDeudaTotal( ), 0.001 );
        habitacion.pagarServicio( 2 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 145.5, habitacion.darDeudaTotal( ), 0.001 );
        habitacion.pagarServicio( 1 );
        assertEquals( "El consumo total de la habitación no fue calculado correctamente.", 0, habitacion.darDeudaTotal( ), 0.001 );

    }

    /**
     * <b>Prueba 4</b> : verifica el método estaOcupada.<br>
     * <b>Métodos a probar: </b><br>
     * estaOcupada<br>
     * registrarHuesped<br>
     * darSalidaHuesped<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se prueba sin huésped, se registra un huésped, y luego se le da salida de nuevo.
     */
    @Test
    public void testEstaOcupada( )
    {
        // Caso de prueba 1
        assertEquals( "La habitación no debería estar ocupada.", false, habitacion.estaOcupada( ) );
        habitacion.registrarHuesped( "Carlos", "123456" );
        assertEquals( "La habitación debería estar ocupada.", true, habitacion.estaOcupada( ) );
        habitacion.darSalidaHuesped( );
        assertEquals( "La habitación no debería estar ocupada.", false, habitacion.estaOcupada( ) );
    }

    /**
     * <b>Prueba 5</b> : verifica el método registrarHuesped.<br>
     * <b>Métodos a probar: </b><br>
     * registrarHuesped<br>
     * darSalidaHuesped<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se prueba sin huésped, se registra un huésped, y luego se le da salida de nuevo.<br>
     */
    @Test
    public void testRegistrarHuesped( )
    {
        // Caso de prueba 1
        assertEquals( "La habitación no debería estar ocupada.", false, habitacion.estaOcupada( ) );
        boolean registra = habitacion.registrarHuesped( "Carlos", "123456" );
        assertEquals( "Se debería registrar el huésped.", true, registra );
        assertEquals( "La habitación debería estar ocupada.", true, habitacion.estaOcupada( ) );
        assertEquals( "El huesped de la habitación no debería ser null", true, habitacion.darHuesped( ) != null );
    }

    /**
     * <b>Prueba 6</b> : verifica el método darSalidaHuesped.<br>
     * <b>Métodos a probar: </b><br>
     * registrarHuesped<br>
     * darSalidaHuesped<br>
     * adquirirServicio<br>
     * pagarServicio<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se da salida a un huésped sin servicios adquiridos.<br>
     * 2. No se da salida a un huésped con servicios adquiridos no pagados.<br>
     * 3. Se da salida a un huésped con servicios adquiridos y pagados.<br>
     */
    @Test
    public void testDarSalidarHuesped( )
    {
        // Caso de prueba 1
        habitacion.registrarHuesped( "Carlos", "123456" );
        boolean daSalida = habitacion.darSalidaHuesped( );
        assertEquals( "El huésped de la habitación debería ser null", true, habitacion.darHuesped( ) == null );
        assertEquals( "El método debió dar salida", true, daSalida );
        assertEquals( "El arreglo de servicios debería existir", true, habitacion.darServicios( ) != null );
        assertEquals( "No deberían existir servicios registrados", 0, habitacion.darServicios( ).size( ), 0.0001 );

        // Caso de prueba 2
        setupEscenario2( );
        habitacion.registrarHuesped( "Carlos", "123456" );
        habitacion.adquirirServicio( Tipo.INTERNET, 500 );
        daSalida = habitacion.darSalidaHuesped( );
        assertEquals( "El huésped de la habitación no debería ser null", true, habitacion.darHuesped( ) != null );
        assertEquals( "No se debió dar salida al huésped", false, daSalida );

        // Caso de prueba 3
        setupEscenario3( );
        habitacion.registrarHuesped( "Carlos", "123456" );
        habitacion.adquirirServicio( Tipo.SPA, 850 );
        habitacion.pagarServicio( 1 );
        daSalida = habitacion.darSalidaHuesped( );
        assertEquals( "El huésped de la habitación debería ser null", true, habitacion.darHuesped( ) == null );
        assertEquals( "El método debió dar salida", true, daSalida );
        assertEquals( "El arreglo de servicios debería existir", true, habitacion.darServicios( ) != null );
        assertEquals( "No deberían existir servicios registrados", 0, habitacion.darServicios( ).size( ), 0.0001 );

    }

    /**
     * <b>Prueba 7</b> : verifica el método pagarServicio.<br>
     * <b>Métodos a probar: </b><br>
     * pagarServicio<br>
     * registrarHuesped<br>
     * adquirirServicio<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se paga un servicio registrado.<br>
     * 2. Se paga un servicio de dos registrados.<br>
     * 2. Se registran 50 servicios y se pagan correctamente.<br>
     */
    @Test
    public void testPagarServicio( )
    {
        // Caso de prueba 1
        habitacion.registrarHuesped( "Carlos", "123456" );
        habitacion.adquirirServicio( Tipo.INTERNET, 500 );
        habitacion.pagarServicio( 1 );
        assertEquals( "La habitación no debería tener deuda", habitacion.darDeudaTotal( ), 0, 0.001 );

        // Caso de prueba 2
        setupEscenario2( );
        habitacion.registrarHuesped( "Carlos", "123456" );
        habitacion.adquirirServicio( Tipo.INTERNET, 500 );
        habitacion.adquirirServicio( Tipo.MINI_BAR, 500 );
        habitacion.pagarServicio( 1 );
        assertEquals( "La habitación debería tener deuda", habitacion.darDeudaTotal( ), 500, 0.001 );

        // Caso de prueba 3
        setupEscenario2( );
        habitacion.registrarHuesped( "Carlos", "123456" );
        for( int i = 0; i < 50; i++ )
        {
            habitacion.adquirirServicio( Tipo.PELICULAS, 10 );
        }

        for( int i = 50; i > 0; i-- )
        {
            assertEquals( "La habitación debería tener deuda", habitacion.darDeudaTotal( ), i * 10, 0.001 );
            habitacion.pagarServicio( i );
        }
    }

    /**
     * <b>Prueba 8</b> : verifica el método adquirirServicio.<br>
     * <b>Métodos a probar: </b><br>
     * adquirirServicio<br>
     * pagarServicio<br>
     * registrarHuesped<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se adquiere un servicio en la habitación.<br>
     * 2. Se adquieren 50 servicios en la habitación entre SPA y MINI_BAR.<br>
     */
    @Test
    public void testAdquirirServicio( )
    {
        // Caso de prueba 1
        habitacion.registrarHuesped( "Carlos", "123456" );
        habitacion.adquirirServicio( Tipo.INTERNET, 500 );
        assertEquals( "La habitación debería tener servicios", 1, habitacion.darServicios( ).size( ), 0.0001 );
        assertEquals( "El servicio debería tener '1' como identificador", 1, habitacion.darServicios( ).get( 0 ).darIdentificador( ), 0.0001 );

        // Caso de prueba 2
        setupEscenario2( );
        habitacion.registrarHuesped( "Carlos", "123456" );
        for( int i = 1; i <= 50; i++ )
        {
            Tipo tipoServicio = Tipo.SPA;

            if( i % 2 == 0 )
            {
                tipoServicio = Tipo.MINI_BAR;
            }

            habitacion.adquirirServicio( tipoServicio, 250 );
            assertEquals( "El número de servicios de la habitación no corresponde", i, habitacion.darServicios( ).size( ), 0.0001 );
            assertEquals( "El identificador del servicio no corresponde", i, habitacion.darServicios( ).get( i - 1 ).darIdentificador( ), 0.0001 );
        }

    }

    /**
     * <b>Prueba 9</b> : verifica el método darVecesServicioSolicitado.<br>
     * <b>Métodos a probar: </b><br>
     * darVecesServicioSolicitado<br>
     * adquirirServicio<br>
     * pagarServicio<br>
     * <b>Casos de prueba:</b><br>
     * 1. No se solicita ningún servicio.<br>
     * 2. Se solicitan 100 servicios de cada tipo.<br>
     */
    @Test
    public void testDarVecesServicioSolicitado( )
    {
        habitacion.registrarHuesped( "Carlos", "1234" );
        
        // Caso de prueba 1
        assertEquals( "El servicio no fue solicitado", 0, habitacion.darVecesServicioSolicitado( Tipo.INTERNET ), 0.0001 );
        assertEquals( "El servicio no fue solicitado", 0, habitacion.darVecesServicioSolicitado( Tipo.MINI_BAR ), 0.0001 );
        assertEquals( "El servicio no fue solicitado", 0, habitacion.darVecesServicioSolicitado( Tipo.SPA ), 0.0001 );
        assertEquals( "El servicio no fue solicitado", 0, habitacion.darVecesServicioSolicitado( Tipo.PELICULAS ), 0.0001 );

        // Caso de prueba 2
        for( int i = 0; i < 100; i++ )
        {
            habitacion.adquirirServicio( Tipo.INTERNET, 200 );
            habitacion.adquirirServicio( Tipo.MINI_BAR, 200 );
            habitacion.adquirirServicio( Tipo.SPA, 200 );
            habitacion.adquirirServicio( Tipo.PELICULAS, 200 );
        }

        assertEquals( "El número de veces que fue solicitado el servicio no corresponde", 100, habitacion.darVecesServicioSolicitado( Tipo.INTERNET ), 0.0001 );
        assertEquals( "El número de veces que fue solicitado el servicio no corresponde", 100, habitacion.darVecesServicioSolicitado( Tipo.MINI_BAR ), 0.0001 );
        assertEquals( "El número de veces que fue solicitado el servicio no corresponde", 100, habitacion.darVecesServicioSolicitado( Tipo.SPA ), 0.0001 );
        assertEquals( "El número de veces que fue solicitado el servicio no corresponde", 100, habitacion.darVecesServicioSolicitado( Tipo.PELICULAS ), 0.0001 );

    }

    /**
     * <b>Prueba 10</b> : verifica el método darServicioMasSolicitado.<br>
     * <b>Métodos a probar: </b><br>
     * darServicioMasSolicitado<br>
     * adquirirServicio<br>
     * <b>Casos de prueba:</b><br>
     * 1. No se solicita ningún servicio.<br>
     * 2. Se solicita 3 veces cada servicio.<br>
     * 3. Se solicita 8 veces SPA y 7 veces MINIBAR.<br>
     * 4. Se solicita 25 veces SPA y 29 veces MINIBAR, 15 veces PELICULAS y 35 veces INTERNET.<br>
     */
    @Test
    public void darServicioMasSolicitado( )
    {
        habitacion.registrarHuesped( "Juan", "1234" );
        
        // Caso de prueba 1
        assertEquals( "No debería retornar ningún servicio", null, habitacion.darServicioMasSolicitado( ) );

        // Caso de prueba 2
        for( int i = 0; i < 3; i++ )
        {
            habitacion.adquirirServicio( Tipo.INTERNET, 200 );
            habitacion.adquirirServicio( Tipo.MINI_BAR, 200 );
            habitacion.adquirirServicio( Tipo.SPA, 200 );
            habitacion.adquirirServicio( Tipo.PELICULAS, 200 );
        }

        assertEquals( "Debería retornar algún servicio", true, habitacion.darServicioMasSolicitado( ) != null );
        
        // Caso de prueba 3
        setupEscenario2( );
        habitacion.registrarHuesped( "Juan", "1234" );

        for( int i = 0; i < 8; i++ )
        {
            habitacion.adquirirServicio( Tipo.SPA, 200 );
        }
        
        for( int i = 0; i < 7; i++ )
        {
            habitacion.adquirirServicio( Tipo.MINI_BAR, 200 );
        }

        assertEquals( "El servicio retornado no corresponde", Tipo.SPA, habitacion.darServicioMasSolicitado( ) );
        
        // Caso de prueba 4
        setupEscenario2( );
        habitacion.registrarHuesped( "Juan", "1234" );

        for( int i = 0; i < 25; i++ )
        {
            habitacion.adquirirServicio( Tipo.SPA, 200 );
        }
        
        for( int i = 0; i < 29; i++ )
        {
            habitacion.adquirirServicio( Tipo.MINI_BAR, 200 );
        }
        
        for( int i = 0; i < 15; i++ )
        {
            habitacion.adquirirServicio( Tipo.PELICULAS, 200 );
        }
        
        for( int i = 0; i < 35; i++ )
        {
            habitacion.adquirirServicio( Tipo.INTERNET, 200 );
        }

        assertEquals( "El servicio retornado no corresponde", Tipo.INTERNET, habitacion.darServicioMasSolicitado( ) );
        

    }

}
