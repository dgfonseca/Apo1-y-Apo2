/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Proyecto	Cupi2	(http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_calculadoraNotas
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.calculadoraNotas.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Contiene los botones ubicados en la parte inferior de la ventana principal.
 */
@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para ejecutar la acción del botón btnCalcularNota.
     */
    private static final String CALCULAR_NOTA = "Calcular nota";

    /**
     * Comando para ejecutar la acción del botón btnPeorNivel.
     */
    private static final String PEOR_NIVEL = "Peor nivel";

    /**
     * Comando para ejecutar la acción del botón btnPeorNivel.
     */
    private static final String PROMEDIO_POR_TIPO = "Promedio por tipo";

    /**
     * Comando para ejecutar la acción del botón btnOpcion1.
     */
    private static final String OPCION1 = "Opción 1";

    /**
     * Comando para ejecutar la acción del botón btnOpcion2.
     */
    private static final String OPCION2 = "Opción 2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazCalculadoraNotas principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Botón que permite calcular las notas.
     */
    private JButton btnCalcularNota;

    /**
     * Botón que muestra el peor nivel del curso.
     */
    private JButton btnPeorNivel;

    /**
     * Botón que muestra el promedio por tipo de nivel.
     */
    private JButton btnPromedioPorTipo;

    /**
     * Botón para la opción 1.
     */
    private JButton btnOpcion1;

    /**
     * Botón para la opción 2.
     */
    private JButton btnOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con los botones <br>
     * <b>post:</b> Todos los botones fueron inicializados.
     * @param pInterfaz Interfaz principal de la aplicación. pInterfaz != null
     */
    public PanelOpciones( InterfazCalculadoraNotas pInterfaz )
    {
        TitledBorder b = BorderFactory.createTitledBorder( "Opciones" );
        setBorder( b );

        principal = pInterfaz;
        setLayout( new GridLayout( 1, 5 ) );

        btnCalcularNota = new JButton( CALCULAR_NOTA );
        btnPeorNivel = new JButton( PEOR_NIVEL );
        btnPromedioPorTipo = new JButton( PROMEDIO_POR_TIPO );
        btnOpcion1 = new JButton( OPCION1 );
        btnOpcion2 = new JButton( OPCION2 );

        btnCalcularNota.addActionListener( this );
        btnPeorNivel.addActionListener( this );
        btnPromedioPorTipo.addActionListener( this );
        btnOpcion1.addActionListener( this );
        btnOpcion2.addActionListener( this );

        btnCalcularNota.setActionCommand( CALCULAR_NOTA );
        btnPeorNivel.setActionCommand( PEOR_NIVEL );
        btnPromedioPorTipo.setActionCommand( PROMEDIO_POR_TIPO );
        btnOpcion1.setActionCommand( OPCION1 );
        btnOpcion2.setActionCommand( OPCION2 );

        add( btnCalcularNota );
        add( btnPeorNivel );
        add( btnPromedioPorTipo );
        add( btnOpcion1 );
        add( btnOpcion2 );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de eventos del usuario.
     * @param pEvento Evento de usuario. pEvento != null.
     */
    @Override
    public void actionPerformed( ActionEvent pEvento )
    {
        if( pEvento.getActionCommand( ).equals( OPCION1 ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( pEvento.getActionCommand( ).equals( OPCION2 ) )
        {
            principal.reqFuncOpcion2( );
        }
        else if( pEvento.getActionCommand( ).equals( PEOR_NIVEL ) )
        {
            principal.darPeorNivel( );
        }
        else if( pEvento.getActionCommand( ).equals( PROMEDIO_POR_TIPO ) )
        {
            principal.darPromedioPorTipo( );
        }
        else
        {
            principal.calcularNotas( );
        }
    }

}
