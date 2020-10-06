/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogotá - Colombia)
 * Departamento de  Ingeniería  de  Sistemas    y   Computación
 * Licenciado   bajo    el  esquema Academic Free License versión 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_calculadoraNotas
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.calculadoraNotas.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import uniandes.cupi2.calculadoraNotas.mundo.CalculadoraNotas;
import uniandes.cupi2.calculadoraNotas.mundo.Nivel;
import uniandes.cupi2.calculadoraNotas.mundo.Nivel.Tipo;

/**
 * Clase principal de la interfaz
 */
@SuppressWarnings("serial")
public class InterfazCalculadoraNotas extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Asociación a la clase principal del mundo.
     */
    private CalculadoraNotas mundo;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Contiene el Banner.
     */
    private PanelImagen panelImagen;

    /**
     * Contiene las notas definitivas, ubicado en la zona superior izquierda de la interfaz.
     */
    private PanelDefinitivas panelDefinitivas;

    /**
     * Contiene el diagrama de pie, ubicado en la zona superior derecha de la interfaz.
     */
    private PanelPorcentajes panelPorcentajes;

    /**
     * Panel de botones ubicado en la zona inferior de la interfaz
     */
    private PanelOpciones panelOpciones;

    /**
     * Contiene los campos de texto y la definitiva correspondientes al nivel 1.
     */
    private PanelNivel panelN1;
    /**
     * Contiene los campos de texto y la definitiva correspondientes al nivel 2.
     */
    private PanelNivel panelN2;

    /**
     * Contiene los campos de texto y la definitiva correspondientes al nivel 3.
     */
    private PanelNivel panelN3;

    /**
     * Contiene los campos de texto y la definitiva correspondientes al nivel 4.
     */
    private PanelNivel panelN4;

    /**
     * Contiene los campos de texto y la definitiva correspondientes al nivel 5.
     */
    private PanelNivel panelN5;

    /**
     * Contiene los campos de texto y la definitiva correspondientes al nivel 6.
     */
    private PanelNivel panelN6;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la ventana principal de la aplicación. <br>
     * <b>post:</b> Todos los componentes de la interfaz fueron inicializados.
     */
    public InterfazCalculadoraNotas( )
    {
        setTitle( "Calculadora notas" );
        setSize( 710, 685 );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setResizable( false );

        mundo = new CalculadoraNotas( );

        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        panelDefinitivas = new PanelDefinitivas( );

        panelPorcentajes = new PanelPorcentajes( mundo.darNivel( 1 ).calcularPorcentajeTotal( ), mundo.darNivel( 2 ).calcularPorcentajeTotal( ), mundo.darNivel( 3 ).calcularPorcentajeTotal( ), mundo.darNivel( 4 ).calcularPorcentajeTotal( ), mundo
                .darNivel( 5 ).calcularPorcentajeTotal( ), mundo.darNivel( 6 ).calcularPorcentajeTotal( ) );

        JPanel panelSuperior = new JPanel( new BorderLayout( ) );
        panelSuperior.add( panelDefinitivas, BorderLayout.CENTER );
        panelSuperior.add( panelPorcentajes, BorderLayout.EAST );

        panelN1 = new PanelNivel( mundo.darNivel( 1 ), new Color( 255, 255, 153 ), this );
        panelN2 = new PanelNivel( mundo.darNivel( 2 ), new Color( 204, 255, 204 ), this );
        panelN3 = new PanelNivel( mundo.darNivel( 3 ), new Color( 204, 236, 255 ), this );
        panelN4 = new PanelNivel( mundo.darNivel( 4 ), new Color( 153, 204, 255 ), this );
        panelN5 = new PanelNivel( mundo.darNivel( 5 ), new Color( 255, 153, 204 ), this );
        panelN6 = new PanelNivel( mundo.darNivel( 6 ), new Color( 250, 191, 143 ), this );

        JPanel panelNiveles = new JPanel( );
        panelNiveles.setLayout( new GridLayout( 2, 3, 5, 5 ) );
        panelNiveles.add( panelN1 );
        panelNiveles.add( panelN2 );
        panelNiveles.add( panelN3 );
        panelNiveles.add( panelN4 );
        panelNiveles.add( panelN5 );
        panelNiveles.add( panelN6 );

        JPanel panelCentro = new JPanel( new BorderLayout( ) );
        panelCentro.add( panelNiveles, BorderLayout.SOUTH );
        panelCentro.add( panelSuperior, BorderLayout.CENTER );
        add( panelCentro, BorderLayout.CENTER );

        panelOpciones = new PanelOpciones( this );
        add( panelOpciones, BorderLayout.SOUTH );

        panelDefinitivas.actualizar( mundo.darNotaPromedioEjercicios( ), mundo.darNotaPromedioPracticos( ), mundo.darNotaPromedioTeoricos( ), mundo.darNotaDefinitiva( ), mundo.darPorcentajeNivelesAprobados( ) );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Pide a cada uno de los paneles de nivel que registre y actualice su nota. <br>
     * Captura la excepción que estos pueden generar y la muestra al usuario
     */
    public void calcularNotas( )
    {

        try
        {
            panelN1.actualizarNotas( mundo.darNivel( 1 ) );
            panelN2.actualizarNotas( mundo.darNivel( 2 ) );
            panelN3.actualizarNotas( mundo.darNivel( 3 ) );
            panelN4.actualizarNotas( mundo.darNivel( 4 ) );
            panelN5.actualizarNotas( mundo.darNivel( 5 ) );
            panelN6.actualizarNotas( mundo.darNivel( 6 ) );

        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Cambiar nota", JOptionPane.ERROR_MESSAGE );
        }
        panelDefinitivas.actualizar( mundo.darNotaPromedioEjercicios( ), mundo.darNotaPromedioPracticos( ), mundo.darNotaPromedioTeoricos( ), mundo.darNotaDefinitiva( ), mundo.darPorcentajeNivelesAprobados( ) );
    }

    /**
     * Muestra al usuario el peor nivel del curso
     */
    public void darPeorNivel( )
    {
        NumberFormat formato = new DecimalFormat( "#0.0" );
        Nivel peorNivel = mundo.darPeorNivel( );
        String mensaje = "El peor nivel es N" + peorNivel.darNumero( ) + ", con una nota de " + formato.format( peorNivel.calcularNotaSobreCinco( ) );
        JOptionPane.showMessageDialog( this, mensaje, "Peor nivel", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Muestra el promedio por tipo de nivel.
     */
    public void darPromedioPorTipo( )
    {
        double pEstructural = mundo.darPromedioPorTipo( Tipo.ESTRUCTURAL );
        double pAlgoritmico = mundo.darPromedioPorTipo( Tipo.ALGORITMICO );
        double pGrafico = mundo.darPromedioPorTipo( Tipo.GRAFICO );
        String[] opciones = { "Estructural", "Algorítmico", "Gráfico" };

        String respuesta = ( String )JOptionPane.showInputDialog( this, "Seleccione el tipo de nivel", "Promedio por tipo", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[ 0 ] );

        if( respuesta != null )
        {
            double promedio = pEstructural;
            String tipo = "estructurales";

            if( respuesta.equals( "Algorítmico" ) )
            {
                promedio = pAlgoritmico;
                tipo = "algorítmicos";
            }
            else if( respuesta.equals( "Gráfico" ) )
            {
                promedio = pGrafico;
                tipo = "gráficos";
            }
            NumberFormat formato = new DecimalFormat( "#0.0" );
            String mensaje = "El promedio de los niveles " + tipo + " es: " + formato.format( promedio );
            JOptionPane.showMessageDialog( this, mensaje, "Peor nivel", JOptionPane.INFORMATION_MESSAGE );
        }
    }
    
    /**
     * Cambia la nota del ejercicio del nivel especificado por parámetro.
     * @param pNivel Número del nivel del que se desea cambiar la nota.
     * @param pNota Nueva nota.
     */
    public void cambiarNotaEjercicio (int pNivel, double pNota)
    {
        mundo.darNivel( pNivel ).cambiarNotaEjercicio( pNota );
    }
    
    /**
     * Cambia la nota del examen práctico del nivel especificado por parámetro.
     * @param pNivel Número del nivel del que se desea cambiar la nota.
     * @param pNota Nueva nota.
     */
    public void cambiarNotaPractico (int pNivel, double pNota)
    {
        mundo.darNivel( pNivel ).cambiarNotaPractico( pNota );
    }
    
    /**
     * Cambia la nota del examen teórico del nivel especificado por parámetro.
     * @param pNivel Número del nivel del que se desea cambiar la nota.
     * @param pNota Nueva nota.
     */
    public void cambiarNotaTeorico (int pNivel, double pNota)
    {
        mundo.darNivel( pNivel ).cambiarNotaTeorico( pNota );
    }

    // -----------------------------------------------------------------
    // Puntos de extensión
    // -----------------------------------------------------------------

    /**
     * Extensión 1
     */
    public void reqFuncOpcion1( )
    {

        String resultado = mundo.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta 1", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Extensión 2
     */
    public void reqFuncOpcion2( )
    {

        String resultado = mundo.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta 2", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args Arreglo opcional de argumentos que se recibe por línea de comandos
     */
    public static void main( String[] args )
    {
        try
        {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazCalculadoraNotas interfaz = new InterfazCalculadoraNotas( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
