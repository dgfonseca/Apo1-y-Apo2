/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogotá - Colombia)
 * Departamento de  Ingeniería  de  Sistemas    y   Computación
 * Licenciado   bajo    el  esquema Academic Free License versión 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_calculadoraNotas
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.calculadoraNotas.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import uniandes.cupi2.calculadoraNotas.mundo.Nivel;
import uniandes.cupi2.calculadoraNotas.mundo.Nivel.Tipo;

/**
 * Clase usada para verificar que los métodos de la clase Nivel estén correctamente implementados.
 */
public class NivelTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nivel en el cual se harán las pruebas
     */
    private Nivel nivel;

    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------

    /**
     * Crea un Nivel con los porcentajes correspondientes a N1 y todas las notas inicializadas en 0.
     */
    @Before
    public void setupEscenario1( )
    {
        nivel = new Nivel( 1, 0.01, 0.04, 0.05, 0.05, 0.05, "Tema del nivel", Tipo.ESTRUCTURAL );
    }

    /**
     * Escenario que asigna 5.0 al examen teórico, examen práctico y al ejercicio.
     */
    public void setupEscenario2( )
    {
        nivel.cambiarNotaEjercicio( 5 );
        nivel.cambiarNotaPractico( 5 );
        nivel.cambiarNotaTeorico( 5 );
    }

    /**
     * Escenario que asigna 1.2 al examen teórico, 2.7 al examen práctico y 3.2 al ejercicio.
     */
    public void setupEscenario3( )
    {
        nivel.cambiarNotaEjercicio( 3.2 );
        nivel.cambiarNotaPractico( 2.7 );
        nivel.cambiarNotaTeorico( 1.2 );
    }

    /**
     * Escenario que asigna 3.2 al examen teórico, 2.4 al examen práctico y 5.0 al ejercicio.
     */
    public void setupEscenario4( )
    {
        nivel.cambiarNotaEjercicio( 5 );
        nivel.cambiarNotaPractico( 2.4 );
        nivel.cambiarNotaTeorico( 3.2 );
    }

    /**
     * Escenario que asigna 0 al examen teórico, 2.4 al examen práctico y 5.0 al ejercicio.
     */
    public void setupEscenario5( )
    {
        nivel.cambiarNotaEjercicio( 5 );
        nivel.cambiarNotaPractico( 2.4 );
        nivel.cambiarNotaTeorico( 0 );
    }

    /**
     * Escenario que asigna 3 al examen teórico, 3 al examen práctico y 3 al ejercicio.
     */
    public void setupEscenario6( )
    {
        nivel.cambiarNotaEjercicio( 3 );
        nivel.cambiarNotaPractico( 3 );
        nivel.cambiarNotaTeorico( 3 );
    }

    /**
     * Escenario que crea un nivel con los porcentajes correspondientes a N4 y asigna 3 al examen teórico, 3 al examen práctico y 3 al ejercicio.
     */
    public void setupEscenario7( )
    {
        nivel = new Nivel( 4, 0.02, 0.03, 0.07, 0.04, 0.08, "Tema nivel", Tipo.ESTRUCTURAL );
        setupEscenario6( );
    }

    // -----------------------------------------------------------------
    // Métodos de prueba
    // -----------------------------------------------------------------
    /**
     * <b>Prueba 1</b> : verifica el método constructor Nivel.<br>
     * <b>Métodos a probar: </b><br>
     * Nivel<br>
     * darNumero<br>
     * darNotaEjercicio<br>
     * darNotaPractico<br>
     * darNotaTeorico<br>
     * darPorcentajeEjercicio<br>
     * darPorcentajePractico<br>
     * darPorcentajeTeorico<br>
     * darTema<br>
     * darTipo<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se crea el nivel correctamente.
     */
    @Test
    public void testNivel( )
    {
        // Caso de prueba 1
        assertEquals( "El nivel asignado no corresponde.", 1, nivel.darNumero( ) );
        assertEquals( "El porcentaje del ejercicio no corresponde.", 0.01, nivel.darPorcentajeEjercicio( ), 0.0001 );
        assertEquals( "El porcentaje del examen práctico no corresponde.", 0.04, nivel.darPorcentajePractico( ), 0.0001 );
        assertEquals( "El porcentaje del examen teórico no corresponde.", 0.05, nivel.darPorcentajeTeorico( ), 0.0001 );
        assertEquals( "El tema no corresponde.", "Tema del nivel", nivel.darTema( ) );
        assertEquals( "El tipo del nivel no corresponde", Tipo.ESTRUCTURAL, nivel.darTipo( ) );
        assertEquals( "La nota inicial del ejercicio no corresponde.", 0, nivel.darNotaEjercicio( ), 0.0001 );
        assertEquals( "La nota inicial del examen práctico no corresponde.", 0, nivel.darNotaPractico( ), 0.0001 );
        assertEquals( "La nota inicial del examen teórico no corresponde.", 0, nivel.darNotaTeorico( ), 0.0001 );

    }

    /**
     * <b>Prueba 2</b> : verifica el método darPorcentajeEjercicio.<br>
     * <b>Métodos a probar: </b><br>
     * darPorcentajeEjercicio<br>
     * estaAnulado <b>Casos de prueba:</b><br>
     * 1. Se calcula el porcentaje del ejercicio sin anulación. <br>
     * 2. Se calcula el porcentaje del ejercicio con anulación.
     */
    @Test
    public void testDarPorcentajeEjercicio( )
    {
        // Caso de prueba 1
        assertEquals( "El porcentaje del ejercicio no corresponde", 0.01, nivel.darPorcentajeEjercicio( ), 0.001 );

        // Caso de prueba 2
        setupEscenario3( );
        assertEquals( "El porcentaje del ejercicio no corresponde", 0, nivel.darPorcentajeEjercicio( ), 0.001 );
    }

    /**
     * <b>Prueba 3</b> : verifica el método darPorcentajePractico.<br>
     * <b>Métodos a probar: </b><br>
     * darPorcentajePractico<br>
     * estaAnulado <b>Casos de prueba:</b><br>
     * 1. Se calcula el porcentaje del examen práctico sin anulación. <br>
     * 2. Se calcula el porcentaje del examen práctico con anulación.
     */
    @Test
    public void testDarPorcentajePractico( )
    {
        // Caso de prueba 1
        assertEquals( "El porcentaje del examen práctico no corresponde", 0.04, nivel.darPorcentajePractico( ), 0.001 );

        // Caso de prueba 2
        setupEscenario3( );
        assertEquals( "El porcentaje del examen práctico no corresponde", 0.05, nivel.darPorcentajePractico( ), 0.001 );
    }

    /**
     * <b>Prueba 4</b> : verifica el método darPorcentajeTeorico.<br>
     * <b>Métodos a probar: </b><br>
     * darPorcentajeTeorico<br>
     * estaAnulado <b>Casos de prueba:</b><br>
     * 1. Se calcula el porcentaje del examen teórico sin anulación. <br>
     * 2. Se calcula el porcentaje del examen teórico con anulación.
     */
    @Test
    public void testDarPorcentajeTeorico( )
    {
        // Caso de prueba 1
        assertEquals( "El porcentaje del examen teórico no corresponde", 0.05, nivel.darPorcentajeTeorico( ), 0.001 );

        // Caso de prueba 2
        setupEscenario3( );
        assertEquals( "El porcentaje del examen teórico no corresponde", 0.05, nivel.darPorcentajeTeorico( ), 0.001 );
    }

    /**
     * <b>Prueba 5</b> : verifica el método calcularPorcentajeTotal.<br>
     * <b>Métodos a probar: </b><br>
     * calcularPorcentajeTotal<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se calcula correctamente el porcentaje total del nivel sin anulación. <br>
     * 2. Se calcula correctamente el porcentaje total del nivel con anulación.
     */
    @Test
    public void testCalcularPorcentajeTotal( )
    {
        // Caso de prueba 1
        assertEquals( "El porcentaje total del nivel no corresponde.", 0.1, nivel.calcularPorcentajeTotal( ), 0.001 );

        // Caso de prueba 2
        setupEscenario3( );
        assertEquals( "El porcentaje total del nivel no corresponde.", 0.1, nivel.calcularPorcentajeTotal( ), 0.001 );
    }

    /**
     * <b>Prueba 6</b> : verifica el método calcularNota.<br>
     * <b>Métodos a probar: </b><br>
     * calcularNota<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se calcula correctamente la nota del nivel, con todas las notas en 0.<br>
     * 2. Se calcula correctamente la nota del del nivel, con todas las notas en 5.<br>
     * 3. Se calcula correctamente la nota del nivel, con 3.2 en el examen teórico, 2.7 en el examen práctico y 1.2 en el ejercicio.
     */
    @Test
    public void testCalcularNota( )
    {
        // Caso de prueba 1
        assertEquals( "La nota del nivel no corresponde.", 0, nivel.calcularNota( ), 0.001 );

        // Caso de prueba 2
        setupEscenario2( );
        assertEquals( "La nota del nivel no corresponde.", 0.5, nivel.calcularNota( ), 0.1 );

        // Caso de prueba 3
        setupEscenario3( );
        assertEquals( "La nota del nivel no corresponde.", 0.2, nivel.calcularNota( ), 0.1 );
    }

    /**
     * <b>Prueba 7</b> : verifica el método calcularNotaSobreCinco.<br>
     * <b>Métodos a probar: </b><br>
     * calcularNotaSobreCinco<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se calcula correctamente la nota del nivel sobre cinco, con todas las notas en 0.<br>
     * 2. Se calcula correctamente la nota del del nivel sobre cinco, con todas las notas en 5.<br>
     * 3. Se calcula correctamente la nota del nivel sobre cinco, con 3.2 en el examen teórico, 2.7 en el examen práctico y 1.2 en el ejercicio. <br>
     * 4. Se calcula correctamente la nota del nivel sobre cinco, con 3.2 en el examen teórico, 2.4 en el examen práctico y 5.0 en el ejercicio. <br>
     * 5. Se calcula correctamente la nota del nivel sobre cinco, con 0 en el examen teórico, 2.4 en el examen práctico y 5.0 en el ejercicio. <br>
     * 6. Se calcula correctamente la nota del nivel sobre cinco, con todas las notas en 3.<br>
     * 7. Se calcula correctamente la nota del nivel sobre cinco, con todas las notas en 3 y los porcentajes del nivel 4.
     */
    @Test
    public void testCalcularNotaSobreCinco( )
    {
        // Caso de prueba 1
        assertEquals( "La nota del nivel no corresponde.", 0, nivel.calcularNotaSobreCinco( ), 0.001 );

        // Caso de prueba 2
        setupEscenario2( );
        assertEquals( "La nota del nivel no corresponde.", 5, nivel.calcularNotaSobreCinco( ), 0.1 );

        // Caso de prueba 3
        setupEscenario3( );
        assertEquals( "La nota del nivel no corresponde.", 2, nivel.calcularNotaSobreCinco( ), 0.1 );

        // Caso de prueba 4
        setupEscenario4( );
        assertEquals( "La nota del nivel no corresponde.", 2.8, nivel.calcularNotaSobreCinco( ), 0.1 );

        // Caso de prueba 5
        setupEscenario5( );
        assertEquals( "La nota del nivel no corresponde.", 1.2, nivel.calcularNotaSobreCinco( ), 0.1 );

        // Caso de prueba 6
        setupEscenario6( );
        assertEquals( "La nota del nivel no corresponde.", 3, nivel.calcularNotaSobreCinco( ), 0.001 );

        // Caso de prueba 6
        setupEscenario7( );
        assertEquals( "La nota del nivel no corresponde.", 3, nivel.calcularNotaSobreCinco( ), 0.001 );
    }

    /**
     * <b>Prueba 8</b> : verifica el método estaAnulado.<br>
     * <b>Métodos a probar: </b><br>
     * estaAnulado<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se determina correctamente la anulación con todas las notas en 0. <br>
     * 2. Se determina correctamente la anulación con todas las notas en 5. <br>
     * 3. Se determina correctamente la anulación con el examen teórico menor a 0.6*notaEjercicio <br>
     * 4. Se determina correctamente la anulación con el examen práctico menor a 0.6*notaEjercicio . <br>
     * 5. Se determina correctamente la anulación con exámenes práctico y teórico menores a 0.6*notaEjercicio. <br>
     * 6. Se determina correctamente la anulación con todas las notas en 3.
     */
    @Test
    public void testEstaAnulado( )
    {
        // Caso de prueba 1
        assertEquals( "El ejercicio no debería anularse", false, nivel.estaAnulado( ) );

        // Caso de prueba 2
        setupEscenario2( );
        assertEquals( "El ejercicio no debería anularse", false, nivel.estaAnulado( ) );

        // Caso de prueba 3
        setupEscenario3( );
        assertEquals( "El ejercicio debería anularse", true, nivel.estaAnulado( ) );

        // Caso de prueba 4
        setupEscenario4( );
        assertEquals( "El ejercicio debería anularse", true, nivel.estaAnulado( ) );

        // Caso de prueba 5
        setupEscenario5( );
        assertEquals( "El ejercicio debería anularse", true, nivel.estaAnulado( ) );

        // Caso de prueba 6
        setupEscenario6( );
        assertEquals( "El ejercicio no debería anularse", false, nivel.estaAnulado( ) );

    }

    /**
     * <b>Prueba 9</b> : verifica el método apruebaNivel.<br>
     * <b>Métodos a probar: </b><br>
     * apruebaNivel<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se determina si aprueba el nivel con todas las notas en 0. <br>
     * 2. Se determina si aprueba el nivel con todas las notas en 5. <br>
     * 3. Se determina si aprueba el nivel con nota del nivel menor a 3. <br>
     * 4. Se determina si aprueba el nivel con nota del nivel menor a 3. <br>
     * 5. Se determina si aprueba el nivel con nota del nivel menor a 3. <br>
     * 6. Se determina si aprueba el nivel con nota igual a 3. <br>
     * 7. Se determina si aprueba el nivel con nota del nivel igual a 3 y porcentajes de N4.
     */
    @Test
    public void testApruebaNivel( )
    {
        // Caso de prueba 1
        assertEquals( "No debería aprobar el nivel", false, nivel.apruebaNivel( ) );

        // Caso de prueba 2
        setupEscenario2( );
        assertEquals( "Debería aprobar el nivel", true, nivel.apruebaNivel( ) );

        // Caso de prueba 3
        setupEscenario3( );
        assertEquals( "No debería aprobar el nivel", false, nivel.apruebaNivel( ) );

        // Caso de prueba 4
        setupEscenario4( );
        assertEquals( "No debería aprobar el nivel", false, nivel.apruebaNivel( ) );

        // Caso de prueba 5
        setupEscenario5( );
        assertEquals( "No debería aprobar el nivel", false, nivel.apruebaNivel( ) );

        // Caso de prueba 6
        setupEscenario6( );
        assertEquals( "Debería aprobar el nivel", true, nivel.apruebaNivel( ) );

        // Caso de prueba 7
        setupEscenario7( );
        assertEquals( "Debería aprobar el nivel", true, nivel.apruebaNivel( ) );

    }
}
