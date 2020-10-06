/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogotá - Colombia)
 * Departamento de  Ingeniería  de  Sistemas    y   Computación
 * Licenciado   bajo    el  esquema Academic Free License versión 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_hotel
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.hotel.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Diálogo para registrar un huésped en el hotel.
 */
@SuppressWarnings("serial")
public class DialogoRegistrarHuesped extends JDialog implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para agregar el huésped.
     */
    public final static String REGISTRAR = "Registrar huesped";

    /**
     * Comando para cancelar el proceso.
     */
    public final static String CANCELAR = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Instancia principal de la aplicación.
     */
    private InterfazHotel principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Campo de texto para el nombre.
     */
    private JTextField txtNombre;

    /**
     * Campo de texto para la cédula.
     */
    private JTextField txtCedula;

    /**
     * Botón para registrar el huésped
     */
    private JButton btnRegistrar;

    /**
     * Botón para cancelar el proceso.
     */
    private JButton btnCancelar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la ventana de diálogo para agregar el huésped.
     * @param pPrincipal Instancia principal de la aplicación.
     */
    public DialogoRegistrarHuesped( InterfazHotel pPrincipal )
    {
        principal = pPrincipal;
        setLayout( new BorderLayout( ) );
        setSize( 350, 170 );
        setTitle( "Registrar huésped" );
        setLocationRelativeTo( pPrincipal );

        JPanel campos = new JPanel( );
        campos.setLayout( new GridLayout( 2, 2, 3, 3) );
        campos.setBorder( new EmptyBorder( 15 , 15, 15, 15 ) );
        add( campos, BorderLayout.CENTER );

        JLabel lblNombre = new JLabel( "Nombre: " );
        campos.add( lblNombre );
        
        txtNombre = new JTextField( );
        campos.add( txtNombre );
        
        JLabel lblCedula = new JLabel( "Cédula: " );
        campos.add( lblCedula );
        
        txtCedula = new JTextField( );
        campos.add( txtCedula );

        JPanel botones = new JPanel( );
        botones.setBorder( new EmptyBorder( 0, 15, 15, 15 ) );
        botones.setLayout( new GridLayout( 1, 2, 3, 3 ) );
        add( botones, BorderLayout.SOUTH );

        btnRegistrar = new JButton( "Agregar" );
        btnRegistrar.setActionCommand( REGISTRAR );
        btnRegistrar.addActionListener( this );
        botones.add( btnRegistrar );

        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.addActionListener( this );
        btnCancelar.setActionCommand( CANCELAR );
        botones.add( btnCancelar );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de eventos del usuario.
     * @param pEvento Evento de usuario. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( REGISTRAR ) )
        {
            principal.registrarHuesped( txtNombre.getText( ), txtCedula.getText( ) );
            dispose( );
        }
        else if( comando.equals( CANCELAR ) )
        {
            dispose( );
        }

    }
}