/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n6_buscaminas
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.buscaminas.interfaz;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Es el panel donde se muestran los botones para jugar y los botones con las opciones de extensión.
 */
@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para activar el modo marcar.
     */
    private static final String BOTON_MODO_MARCAR = "Marcar";

    /**
     * Comando para activar el modo desmarcar.
     */
    private static final String BOTON_MODO_DESMARCAR = "Desmarcar";

    /**
     * Comando para activar el modo destapar.
     */
    private static final String BOTON_MODO_DESTAPAR = "Destapar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz.
     */
    private InterfazBuscaminas principal;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el botón para cambiar al modo marcar.
     */
    private JButton botonMarcar;

    /**
     * Es el botón para cambiar al modo desmarcar.
     */
    private JButton botonDesMarcar;

    /**
     * Es el botón para cambiar al modo destapar.
     */
    private JButton botonDestapar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con la referencia a la InterfazBuscaminas.
     * @param pPrincipal Es una referencia a la clase principal de la interfaz. pPrincipal != null.
     */
    public PanelBotones( InterfazBuscaminas pPrincipal )
    {
        principal = pPrincipal;
        setLayout( new GridLayout( 7, 1 ) );

        add( new JLabel( ) );
        add( new JLabel( ) );

        // Inicializa el botonDestapar con la imagen y los valores predeterminados
        botonDestapar = new JButton( );
        botonDestapar.setIcon( new ImageIcon( new ImageIcon( "./data/destapar.png" ).getImage( ).getScaledInstance( 45, 45, Image.SCALE_DEFAULT ) ) );
        botonDestapar.setMargin( new Insets( 1, 1, 1, 1 ) );
        botonDestapar.setToolTipText( "Destapar" );
        botonDestapar.setActionCommand( BOTON_MODO_DESTAPAR );
        botonDestapar.addActionListener( this );
        botonDestapar.setContentAreaFilled( false );
        botonDestapar.setEnabled( false );
        add( botonDestapar );

        // Inicializa el botonMarcar con la imagen y los valores predeterminados
        botonMarcar = new JButton( );
        botonMarcar.setIcon( new ImageIcon( new ImageIcon( "./data/marcar.png" ).getImage( ).getScaledInstance( 45, 45, Image.SCALE_DEFAULT ) ) );
        botonMarcar.setMargin( new Insets( 1, 1, 1, 1 ) );
        botonMarcar.setToolTipText( "Marcar" );
        botonMarcar.setActionCommand( BOTON_MODO_MARCAR );
        botonMarcar.addActionListener( this );
        botonMarcar.setContentAreaFilled( false );
        add( botonMarcar );

        // Inicializa el botonDesMarcar con la imagen y los valores predeterminados
        botonDesMarcar = new JButton( );
        botonDesMarcar.setIcon( new ImageIcon( new ImageIcon( "./data/desmarcar.png" ).getImage( ).getScaledInstance( 45, 45, Image.SCALE_DEFAULT ) ) );
        botonDesMarcar.setMargin( new Insets( 1, 1, 1, 1 ) );
        botonDesMarcar.setToolTipText( "Desmarcar" );
        botonDesMarcar.setActionCommand( BOTON_MODO_DESMARCAR );
        botonDesMarcar.addActionListener( this );
        botonDesMarcar.setContentAreaFilled( false );
        add( botonDesMarcar );

        add( new JLabel( ) );
        add( new JLabel( ) );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Este método se ejecuta cuando se hace click sobre alguno de los botones.
     * @param pEvento El evento del click sobre uno de los botones.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( BOTON_MODO_DESMARCAR.equals( comando ) )
        {
            botonDesMarcar.setEnabled( false );
            botonDestapar.setEnabled( true );
            botonMarcar.setEnabled( true );
            principal.cambiarModo( InterfazBuscaminas.MODO_DESMARCAR );
        }
        else if( BOTON_MODO_MARCAR.equals( comando ) )
        {
            botonDesMarcar.setEnabled( true );
            botonDestapar.setEnabled( true );
            botonMarcar.setEnabled( false );
            principal.cambiarModo( InterfazBuscaminas.MODO_MARCAR );
        }
        else if( BOTON_MODO_DESTAPAR.equals( comando ) )
        {
            botonDesMarcar.setEnabled( true );
            botonDestapar.setEnabled( false );
            botonMarcar.setEnabled( true );
            principal.cambiarModo( InterfazBuscaminas.MODO_DESTAPAR );
        }
    }
}
