/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_empleado
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.empleado.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel con las opciones de la aplicación.
 */
@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para cambiar el empleado.
     */
    private final String CAMBIAR_EMPLEADO = "cambiarEmpleado";

    /**
     * Constante para el extensión 1.
     */
    private final String OPCION_1 = "opcion1";

    /**
     * Cosntante para la extensión 2.
     */
    private final String OPCION_2 = "opcion2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Venta principal de la aplicación.
     */
    private InterfazEmpleado principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Botón para cambiar de empleado.
     */
    private JButton btnCambiarEmpleado;

    /**
     * Botón para la extensión 1.
     */
    private JButton btnOpcion1;

    /**
     * Botón para la extensión 2.
     */
    private JButton btnOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel de opciones. <br>
     * <b>post: </b> Construyó el panel.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelOpciones( InterfazEmpleado pPrincipal )
    {
        principal = pPrincipal;

        setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 5, 0 ), new TitledBorder( "Opciones" ) ) );

        setLayout( new GridLayout( 1, 3 ) );

        btnCambiarEmpleado = new JButton( "Cambiar empleado" );
        btnCambiarEmpleado.setActionCommand( CAMBIAR_EMPLEADO );
        btnCambiarEmpleado.addActionListener( this );

        btnOpcion1 = new JButton( "Opción 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );

        btnOpcion2 = new JButton( "Opción 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );

        add( btnCambiarEmpleado );
        add( btnOpcion1 );
        add( btnOpcion2 );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( CAMBIAR_EMPLEADO.equals( comando ) )
        {
            principal.mostrarDialogoCambiarEmpleado( );
        }
        else if( OPCION_1.equals( comando ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( comando ) )
        {
            principal.reqFuncOpcion2( );
        }
    }

}
