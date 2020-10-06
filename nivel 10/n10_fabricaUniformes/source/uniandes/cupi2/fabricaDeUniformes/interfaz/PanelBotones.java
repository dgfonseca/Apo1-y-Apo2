/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_FabricaDeUniformes
 * Autor: Equipo Cupi2 2018-1
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.fabricaDeUniformes.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.fabricaDeUniformes.mundo.Camiseta;
import uniandes.cupi2.fabricaDeUniformes.mundo.Camiseta.Manga;
import uniandes.cupi2.fabricaDeUniformes.mundo.CamisetaConRaya;
import uniandes.cupi2.fabricaDeUniformes.mundo.CamisetaConRaya.DireccionRaya;
import uniandes.cupi2.fabricaDeUniformes.mundo.CamisetaCuadros;
import uniandes.cupi2.fabricaDeUniformes.mundo.CamisetaFranjas;

/**
 * Panel de botones y controles de la aplicación.
 */
@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante del botón color de fondo.
     */
    private static final String COLOR = "Color";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Referencia a la clase principal de la interfaz.
     */
    private InterfazFabricaDeUniformes principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Arreglo de los botones.
     */
    private JToggleButton[] botones;

    /**
     * Grupo de los botones.
     */
    private ButtonGroup grupo;

    /**
     * Botón para elegir el color de la parte.
     */
    private JButton botonColor;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa sus componentes.
     * @param pPrincipal Referencia a la clase principal de la interfaz.
     */
    public PanelBotones( InterfazFabricaDeUniformes pPrincipal )
    {
        String dirImagenes = "." + File.separator + "data" + File.separator + "imagenes" + File.separator;

        principal = pPrincipal;

        setBorder( new TitledBorder( "" ) );

        ArrayList<String> tipos = pPrincipal.darOpcionesSeleccion( );
        botones = new JToggleButton[tipos.size( ) - 1];
        grupo = new ButtonGroup( );

        for( int i = 0; i < tipos.size( ) - 1; i++ )
        {
            String tipo = ( String )tipos.get( i + 1 );
            ImageIcon icono = new ImageIcon( dirImagenes + "boton" + tipo + ".png" );

            icono = new ImageIcon( icono.getImage( ).getScaledInstance( 50, 50, java.awt.Image.SCALE_SMOOTH ) );
            botones[ i ] = new JToggleButton( icono );
            botones[ i ].setPreferredSize( new Dimension( 50, 50 ) );
            botones[ i ].setToolTipText( tipo );

            botones[ i ].setActionCommand( tipo );
            botones[ i ].addActionListener( this );
            grupo.add( botones[ i ] );
        }

        botonColor = new JButton( " " );
        botonColor.setActionCommand( COLOR );
        botonColor.setBackground( Color.WHITE );
        botonColor.addActionListener( this );
        botonColor.setToolTipText( "Color Fondo" );

        setLayout( new GridBagLayout( ) );
        GridBagConstraints gbc = new GridBagConstraints( 0, 0, 1, 1, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets( 2, 2, 2, 2 ), 0, 0 );

        int b = 0;
        int tam = botones.length;
        for( int i = 0; i < tam + 1 / 2; i++ )
        {
            for( int j = 0; j < 2; j++ )
            {
                if( b != tam )
                {
                    gbc.gridx = j;
                    gbc.gridy = i;
                    add( botones[ b ], gbc );
                    b++;
                }
            }
        }

        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy = botones.length / 2 + 1;
        add( botonColor, gbc );

        botonColor.setBackground( principal.darColor( ) );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la opción seleccionada
     * @return Opción seleccionada en este panel.
     */
    public String darOpcionSeleccionada( )
    {
        ArrayList<String> opciones = principal.darOpcionesSeleccion( );
        String tipoSeleccionado = ( String )opciones.get( 0 );

        for( int i = 0; i < botones.length; i++ )
        {
            if( botones[ i ].isSelected( ) )
            {
                tipoSeleccionado = ( String ) ( opciones.get( i + 1 ) );
            }
        }
        return tipoSeleccionado;
    }

    /**
     * Quita la selección actual y selecciona el botón de seleccionar.<br>
     * <b>post: </b> Se seleccionó el botón de seleccionar.
     */
    public void reiniciarSeleccion( )
    {
        botones[ 0 ].setSelected( true );
    }

    /**
     * Método que se llama cuando se hace click sobre un botón.
     * @param pEvento Evento del click sobre un botón.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( COLOR.equals( comando ) )
        {
            Color color = JColorChooser.showDialog( this, "Color", principal.darColor( ) );
            if( color != null )
            {
                botonColor.setBackground( color );
                principal.cambiarColor( color );
            }
        }
        else if( principal.darOpcionesSeleccion( ).get( 2 ).equals( comando ) )
        {
            principal.eliminar( );
        }
        else if( comando.equals( CamisetaConRaya.TIPO ) || comando.equals( CamisetaCuadros.TIPO ) || comando.equals( CamisetaFranjas.TIPO ) )
        {
            JComboBox<Manga> cbManga = new JComboBox<>( Manga.values( ) );
            cbManga.setSelectedIndex( 0 );
            JComboBox<DireccionRaya> cbDireccion = new JComboBox<>( DireccionRaya.values( ) );
            cbDireccion.setSelectedIndex( 0 );

            final Color color2 = new Color( ( int ) ( 0.8 * principal.darColor( ).getRed( ) ), ( int ) ( 0.8 * principal.darColor( ).getGreen( ) ), ( int ) ( 0.8 * principal.darColor( ).getBlue( ) ) );
            final JButton btnColor2 = new JButton( " " );
            btnColor2.setBackground( color2 );
            btnColor2.addActionListener( new ActionListener( )
            {

                @Override
                public void actionPerformed( ActionEvent e )
                {

                    Color color = JColorChooser.showDialog( principal, "Color", color2 );
                    if( color != null )
                    {
                        btnColor2.setBackground( color );

                    }

                }
            } );
            btnColor2.setToolTipText( "Color 2" );

            Object[] message = new Object[6];
            message[ 0 ] = "Manga:";
            message[ 1 ] = cbManga;
            message[ 2 ] = "Color 2: ";
            message[ 3 ] = btnColor2;

            if( comando.equals( CamisetaConRaya.TIPO ) )
            {
                message[ 4 ] = "Direccion Raya: ";
                message[ 5 ] = cbDireccion;
            }

            Manga manga = Manga.CORTA;
            int option = JOptionPane.showConfirmDialog( null, message, comando, JOptionPane.OK_CANCEL_OPTION );
            if( option == JOptionPane.OK_OPTION )
            {
                manga = ( Manga )cbManga.getSelectedItem( );
            }

            principal.calcularSombra( 0, 0 );

            Camiseta camiseta = ( Camiseta )principal.darSombreado( );
            camiseta.cambiarManga( manga );
            camiseta.cambiarColor2( btnColor2.getBackground( ) );

            if( camiseta instanceof CamisetaConRaya )
            {
                ( ( CamisetaConRaya )camiseta ).cambiarDireccion( ( DireccionRaya )cbDireccion.getSelectedItem( ) );
            }

        }

    }

}
