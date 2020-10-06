/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_lineasTelefonicas
 * Autor: Equipo Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.lineasTelefonicas.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel de manejo de las opciones de la aplicación.
 */
public class PanelOpciones extends JPanel implements ActionListener
{

    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Comando para reiniciar las lineas telefónicos.
     */
    private static final String REINICIAR = "REINICIAR";

    /**
     * Comando opción 1.
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Comando Opción 2
     */
    private static final String OPCION_2 = "OPCION_2";

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazLineasTelefonicas principal;

    //-----------------------------------------------------------------
    // Atributos de interfaz
    //-----------------------------------------------------------------

    /**
     * Botón reiniciar.
     */
    private JButton btnReiniciar;

    /**
     * Botón opción 1.
     */
    private JButton btnOpcion1;

    /**
     * Botón opción 2.
     */
    private JButton btnOpcion2;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor del panel.
     * <b>post: </b> Se construyó el panel.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal!=null.
     */
    public PanelOpciones( InterfazLineasTelefonicas pPrincipal )
    {
        principal = pPrincipal;

        setBorder( new TitledBorder( "Opciones" ) );
        setLayout( new GridLayout( 1, 3 ) );

        //Reiniciar
        btnReiniciar = new JButton( "Reiniciar" );
        btnReiniciar.setActionCommand( REINICIAR );
        btnReiniciar.addActionListener( this );
        add( btnReiniciar );

        //Botón opción 1
        btnOpcion1 = new JButton( "Opción 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        add( btnOpcion1 );

        //Botón opción 2
        btnOpcion2 = new JButton( "Opción 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        add( btnOpcion2 );
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Evento de click sobre un botón. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        if( OPCION_1.equals( pEvento.getActionCommand( ) ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( pEvento.getActionCommand( ) ) )
        {
            principal.reqFuncOpcion2( );
        }
        else if( REINICIAR.equals( pEvento.getActionCommand( ) ) )
        {
            principal.reiniciar( );
        }
    }

}
