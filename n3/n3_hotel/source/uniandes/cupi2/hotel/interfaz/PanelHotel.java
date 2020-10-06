/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Proyecto	Cupi2	(http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_hotel
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.hotel.interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Panel con las ventanas del hotel
 */
@SuppressWarnings("serial")
public class PanelHotel extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante con la ruta a la imagen de la ventana con luz.
     */
    private static final String VENTANA_LUZ = "data/img/ventanaLuz.png";
    /**
     * Constante con la ruta a la imagen de la ventana oscura.
     */
    private static final String VENTANA_OSCURA = "data/img/ventanaOscura.png";
    /**
     * Constante con la ruta a la imagen de la ventana con luz y un hombre.
     */
    private static final String VENTANA_HOMBRE = "data/img/ventanaHombre.png";
    /**
     * Constante con la ruta a la imagen de la ventana con luz y una mujer.
     */
    private static final String VENTANA_MUJER = "data/img/ventanaMujer.png";
    /**
     * Constante con la ruta a la imagen de la ventana oscura con un hombre.
     */
    private static final String VENTANA_OSCURA_HOMBRE = "data/img/ventanaOscuraHombre.png";
    /**
     * Constante con la ruta a la imagen de la ventana oscura con una mujer.
     */
    private static final String VENTANA_OSCURA_MUJER = "data/img/ventanaOscuraMujer.png";
    /**
     * Alto de una ventana
     */
    private static final int ALTO = 110;

    /**
     * Ancho de una ventana
     */
    private static final int ANCHO = 66;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Icono de la ventana con luz.
     */
    private ImageIcon iconoVentanaLuz;

    /**
     * Icono de la ventana oscura.
     */
    private ImageIcon iconoVentanaOscura;

    /**
     * Icono de la ventana con un hombre.
     */
    private ImageIcon iconoVentanaHombre;

    /**
     * Icono de la ventana con una mujer.
     */
    private ImageIcon iconoVentanaMujer;

    /**
     * Icono de la ventana oscura con un hombre.
     */
    private ImageIcon iconoVentanaOscuraHombre;

    /**
     * Icono de la ventana oscura con una mujer.
     */
    private ImageIcon iconoVentanaOscuraMujer;

    /**
     * Botón con la ventana seleccionada actualmente.
     */
    private JButton btnHabitacionSeleccionada;

    /**
     * Arreglo de botones de la interfaz.
     */
    private JButton[] botones;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Referencia a la clase principal de la interfaz.
     */
    private InterfazHotel principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo panel con las ventanas del hotel.
     * @param pPrincipal Referencia a la clase principal.
     */
    public PanelHotel( InterfazHotel pPrincipal )
    {
        principal = pPrincipal;
        setLayout( new GridLayout( 4, 5, 0, 0 ) );
        botones = new JButton[20];

        iconoVentanaLuz = new ImageIcon( VENTANA_LUZ );
        iconoVentanaLuz = new ImageIcon( iconoVentanaLuz.getImage( ).getScaledInstance( ANCHO, ALTO, java.awt.Image.SCALE_SMOOTH ) );

        iconoVentanaOscura = new ImageIcon( VENTANA_OSCURA );
        iconoVentanaOscura = new ImageIcon( iconoVentanaOscura.getImage( ).getScaledInstance( ANCHO, ALTO, java.awt.Image.SCALE_SMOOTH ) );

        iconoVentanaHombre = new ImageIcon( VENTANA_HOMBRE );
        iconoVentanaHombre = new ImageIcon( iconoVentanaHombre.getImage( ).getScaledInstance( ANCHO, ALTO, java.awt.Image.SCALE_SMOOTH ) );

        iconoVentanaMujer = new ImageIcon( VENTANA_MUJER );
        iconoVentanaMujer = new ImageIcon( iconoVentanaMujer.getImage( ).getScaledInstance( ANCHO, ALTO, java.awt.Image.SCALE_SMOOTH ) );

        iconoVentanaOscuraHombre = new ImageIcon( VENTANA_OSCURA_HOMBRE );
        iconoVentanaOscuraHombre = new ImageIcon( iconoVentanaOscuraHombre.getImage( ).getScaledInstance( ANCHO, ALTO, java.awt.Image.SCALE_SMOOTH ) );

        iconoVentanaOscuraMujer = new ImageIcon( VENTANA_OSCURA_MUJER );
        iconoVentanaOscuraMujer = new ImageIcon( iconoVentanaOscuraMujer.getImage( ).getScaledInstance( ANCHO, ALTO, java.awt.Image.SCALE_SMOOTH ) );

        for( int i = 19; i >= 0; i-- )
        {
            JButton boton = new JButton( );

            boton.setIcon( iconoVentanaOscura );
            botones[ i ] = boton;
            boton.setBorderPainted( false );
            boton.setContentAreaFilled( false );
            boton.setFocusPainted( false );
            boton.setOpaque( true );
            boton.addActionListener( this );
            boton.setActionCommand( i + "" );
            boton.setBackground( new Color( 160, 208, 220 ) );
            add( boton );

        }
    }

    /**
     * Actualiza el botón seleccionado actualmente.
     * @param pEstaOcupada Indica si la habitación se encuentra ocupada.
     * @param pNombreHuesped Indica el nombre del huésped.
     */
    public void actualizar( boolean pEstaOcupada, String pNombreHuesped )
    {

        if( pEstaOcupada )
        {
            try
            {
                String nombreHuesped = pNombreHuesped;

                if( nombreHuesped.contains( " " ) )
                {
                    nombreHuesped = nombreHuesped.split( " " )[ 0 ];
                }

                if( nombreHuesped.endsWith( "a" ) || nombreHuesped.endsWith( "i" ) )
                {
                    btnHabitacionSeleccionada.setIcon( iconoVentanaMujer );
                }
                else
                {
                    btnHabitacionSeleccionada.setIcon( iconoVentanaHombre );
                }

            }
            catch( Exception e )
            {
                System.out.println( "Error, revisar" );
            }

        }
        else
        {
            btnHabitacionSeleccionada.setIcon( iconoVentanaLuz );
        }

    }

    /**
     * Recibe un click en un botón.
     * @param pEvento Evento recibido.
     */
    @Override
    public void actionPerformed( ActionEvent pEvento )
    {
        if( btnHabitacionSeleccionada != null )
        {
            if( btnHabitacionSeleccionada.getIcon( ).equals( iconoVentanaHombre ) )
            {
                btnHabitacionSeleccionada.setIcon( iconoVentanaOscuraHombre );
            }
            else if( btnHabitacionSeleccionada.getIcon( ).equals( iconoVentanaMujer ) )
            {
                btnHabitacionSeleccionada.setIcon( iconoVentanaOscuraMujer );
            }
            else
            {
                btnHabitacionSeleccionada.setIcon( iconoVentanaOscura );
            }
        }

        int numHabitacion = Integer.parseInt( pEvento.getActionCommand( ) );
        principal.actualizarHabitacionActual( numHabitacion + 1 );
        btnHabitacionSeleccionada = botones[ numHabitacion ];
        principal.actualizarInterfaz( );

    }

}
