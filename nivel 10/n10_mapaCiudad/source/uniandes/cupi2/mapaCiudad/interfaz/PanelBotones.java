/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelBotones.java,v 1.1 2007/03/22 16:13:00 p-marque Exp $ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Todos los derechos reservados 2005 
 *
 * Proyecto Cupi2 
 * Ejercicio: n10_MapaCiudad 
 * Autor: Daniel Francisco Romero Acero - 25-ene-2006 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.mapaCiudad.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

/**
 * Este es el panel donde se encuentran los botones y controles de la aplicación
 */
public class PanelBotones extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante del botón color de fondo.
     */
    private static final String COLOR_FONDO = "Fondo";
    /**
     * Constante de la opción borrar.
     */
    private static final String BORRAR = "Borrar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazMapaCiudad principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el botón para seleccionar figuras
     */
    private JToggleButton botonSeleccionar;

    /**
     * Es el botón para eliminar las construcciones
     */
    private JToggleButton botonBorrar;

    /**
     * Es el botón para dibujar una calle
     */
    private JToggleButton botonCalle;

    /**
     * Es el botón para dibujar una carrera
     */
    private JToggleButton botonCarrera;

    /**
     * Es el botón para dibujar una casa
     */
    private JToggleButton botonCasa;

    /**
     * Es el botón para dibujar una glorieta
     */
    private JToggleButton botonGlorieta;

    /**
     * Es el botón para dibujar un edificio
     */
    private JToggleButton botonEdificio;

    /**
     * Es el botón para dibujar una esquina1
     */
    private JToggleButton botonEsquina1;

    /**
     * Es el botón para dibujar una esquina2
     */
    private JToggleButton botonEsquina2;

    /**
     * Es el botón para dibujar una esquina3
     */
    private JToggleButton botonEsquina3;

    /**
     * Es el botón para dibujar una esquina4
     */
    private JToggleButton botonEsquina4;

    /**
     * Es el botón para dibujar una estación de bomberos
     */
    private JToggleButton botonEstacionBomberos;

    /**
     * Es el botón para dibujar una estación de policia
     */
    private JToggleButton botonEstacionPolicia;

    /**
     * Es el botón para dibujar un hospital
     */
    private JToggleButton botonHospital;

    /**
     * Es el botón para elegir el color para el fondo de una construcción
     */
    private JButton botonColorFondo;

    /**
     * Es el grupo de los botones
     */
    private ButtonGroup grupo;

    /**
     * Etiqueta Color de Fondo
     */
    private JLabel etiquetaColorFondo;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa sus componentes
     * @param p Es una referencia a la clase principal de la interfaz
     */
    public PanelBotones( InterfazMapaCiudad p )
    {
        String dirImagenes = "./data/imagenes/";
        principal = p;

        setBorder( new TitledBorder( "" ) );

        botonSeleccionar = new JToggleButton( new ImageIcon( dirImagenes + "flecha.gif" ) );
        botonSeleccionar.setPreferredSize( new Dimension( 40, 40 ) );
        botonSeleccionar.setToolTipText( "Seleccionar" );

        botonBorrar = new JToggleButton( new ImageIcon( dirImagenes + "borrador.gif" ) );
        botonBorrar.setActionCommand( BORRAR );
        botonBorrar.addActionListener( this );
        botonBorrar.setPreferredSize( new Dimension( 40, 40 ) );
        botonBorrar.setToolTipText( "Borrar" );

        botonCalle = new JToggleButton( new ImageIcon( dirImagenes + "calleBoton.gif" ) );
        botonCalle.setPreferredSize( new Dimension( 40, 40 ) );
        botonCalle.setToolTipText( "Calle" );

        botonCarrera = new JToggleButton( new ImageIcon( dirImagenes + "carreraBoton.gif" ) );
        botonCarrera.setPreferredSize( new Dimension( 40, 40 ) );
        botonCarrera.setToolTipText( "Carrera" );

        botonCasa = new JToggleButton( new ImageIcon( dirImagenes + "casaBoton.gif" ) );
        botonCasa.setPreferredSize( new Dimension( 40, 40 ) );
        botonCasa.setToolTipText( "Casa" );

        botonColorFondo = new JButton( " " );
        botonColorFondo.setActionCommand( COLOR_FONDO );
        botonColorFondo.setBackground( Color.BLUE );
        botonColorFondo.addActionListener( this );
        botonColorFondo.setToolTipText( "Color Fondo" );

        botonGlorieta = new JToggleButton( new ImageIcon( dirImagenes + "glorietaBoton.gif" ) );
        botonGlorieta.setPreferredSize( new Dimension( 40, 40 ) );
        botonGlorieta.setToolTipText( "Glorieta" );

        botonEdificio = new JToggleButton( new ImageIcon( dirImagenes + "edificioBoton.gif" ) );
        botonEdificio.setPreferredSize( new Dimension( 40, 40 ) );
        botonEdificio.setToolTipText( "Edificio" );

        botonEsquina1 = new JToggleButton( new ImageIcon( dirImagenes + "esquina1Boton.gif" ) );
        botonEsquina1.setPreferredSize( new Dimension( 40, 40 ) );
        botonEsquina1.setToolTipText( "Esquina1" );

        botonEsquina2 = new JToggleButton( new ImageIcon( dirImagenes + "esquina2Boton.gif" ) );
        botonEsquina2.setPreferredSize( new Dimension( 40, 40 ) );
        botonEsquina2.setToolTipText( "Esquina2" );

        botonEsquina3 = new JToggleButton( new ImageIcon( dirImagenes + "esquina3Boton.gif" ) );
        botonEsquina3.setPreferredSize( new Dimension( 40, 40 ) );
        botonEsquina3.setToolTipText( "Esquina3" );

        botonEsquina4 = new JToggleButton( new ImageIcon( dirImagenes + "esquina4Boton.gif" ) );
        botonEsquina4.setPreferredSize( new Dimension( 40, 40 ) );
        botonEsquina4.setToolTipText( "Esquina4" );

        botonEstacionBomberos = new JToggleButton( new ImageIcon( dirImagenes + "estacionBomberosBoton.gif" ) );
        botonEstacionBomberos.setPreferredSize( new Dimension( 40, 40 ) );
        botonEstacionBomberos.setToolTipText( "Estación Bomberos" );

        botonEstacionPolicia = new JToggleButton( new ImageIcon( dirImagenes + "estacionPoliciaBoton.gif" ) );
        botonEstacionPolicia.setPreferredSize( new Dimension( 40, 40 ) );
        botonEstacionPolicia.setToolTipText( "Estación Policía" );

        botonHospital = new JToggleButton( new ImageIcon( dirImagenes + "hospitalBoton.gif" ) );
        botonHospital.setPreferredSize( new Dimension( 40, 40 ) );
        botonHospital.setToolTipText( "Hospital" );

        etiquetaColorFondo = new JLabel( "Color Fondo" );

        grupo = new ButtonGroup( );
        grupo.add( botonSeleccionar );
        grupo.add( botonBorrar );
        grupo.add( botonCasa );
        grupo.add( botonEdificio );
        grupo.add( botonEstacionBomberos );
        grupo.add( botonEstacionPolicia );
        grupo.add( botonHospital );
        grupo.add( botonCalle );
        grupo.add( botonCarrera );
        grupo.add( botonGlorieta );
        grupo.add( botonEsquina1 );
        grupo.add( botonEsquina2 );
        grupo.add( botonEsquina3 );
        grupo.add( botonEsquina4 );

        setLayout( new GridBagLayout( ) );
        GridBagConstraints gbc = new GridBagConstraints( 0, 0, 1, 1, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 3, 3, 3, 3 ), 0, 0 );

        add( botonSeleccionar, gbc );
        gbc.gridx = 1;
        gbc.gridy = 0;
        add( botonBorrar, gbc );

        gbc.gridx = 0;
        gbc.gridy = 1;
        add( botonCasa, gbc );

        gbc.gridx = 1;
        gbc.gridy = 1;
        add( botonEdificio, gbc );

        gbc.gridx = 0;
        gbc.gridy = 2;
        add( botonEstacionBomberos, gbc );

        gbc.gridx = 1;
        gbc.gridy = 2;
        add( botonEstacionPolicia, gbc );

        gbc.gridx = 0;
        gbc.gridy = 3;
        add( botonHospital, gbc );

        gbc.gridx = 1;
        gbc.gridy = 3;
        add( botonCalle, gbc );

        gbc.gridx = 0;
        gbc.gridy = 4;
        add( botonCarrera, gbc );

        gbc.gridx = 1;
        gbc.gridy = 4;
        add( botonGlorieta, gbc );

        gbc.gridx = 0;
        gbc.gridy = 5;
        add( botonEsquina1, gbc );

        gbc.gridx = 1;
        gbc.gridy = 5;
        add( botonEsquina2, gbc );

        gbc.gridx = 0;
        gbc.gridy = 6;
        add( botonEsquina3, gbc );

        gbc.gridx = 1;
        gbc.gridy = 6;
        add( botonEsquina4, gbc );

        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy = 7;
        add( etiquetaColorFondo, gbc );

        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy = 8;
        add( botonColorFondo, gbc );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el color elegido para el fondo de las construcciones
     * @return colorFondo
     */
    public Color darColorFondo( )
    {
        return botonColorFondo.getBackground( );
    }

    /**
     * Retorna la opción seleccionada
     * @return La opción seleccionada  en este panel.
     */
    public int darOpcionSeleccionada( )
    {
        int tipoSeleccionado = InterfazMapaCiudad.NINGUNA;

        if( botonSeleccionar.isSelected( ) )
        {
            tipoSeleccionado = InterfazMapaCiudad.SELECCIONAR;
        }
        else if( botonBorrar.isSelected( ) )
        {
            tipoSeleccionado = InterfazMapaCiudad.BORRAR;
        }
        else if( botonCalle.isSelected( ) )
        {
            tipoSeleccionado = InterfazMapaCiudad.CALLE;
        }
        else if( botonCarrera.isSelected( ) )
        {
            tipoSeleccionado = InterfazMapaCiudad.CARRERA;
        }
        else if( botonCasa.isSelected( ) )
        {
            tipoSeleccionado = InterfazMapaCiudad.CASA;
        }
        else if( botonGlorieta.isSelected( ) )
        {
            tipoSeleccionado = InterfazMapaCiudad.GLORIETA;
        }
        else if( botonEdificio.isSelected( ) )
        {
            tipoSeleccionado = InterfazMapaCiudad.EDIFICIO;
        }
        else if( botonEsquina1.isSelected( ) )
        {
            tipoSeleccionado = InterfazMapaCiudad.ESQUINA1;
        }
        else if( botonEsquina2.isSelected( ) )
        {
            tipoSeleccionado = InterfazMapaCiudad.ESQUINA2;
        }
        else if( botonEsquina3.isSelected( ) )
        {
            tipoSeleccionado = InterfazMapaCiudad.ESQUINA3;
        }
        else if( botonEsquina4.isSelected( ) )
        {
            tipoSeleccionado = InterfazMapaCiudad.ESQUINA4;
        }
        else if( botonEstacionBomberos.isSelected( ) )
        {
            tipoSeleccionado = InterfazMapaCiudad.ESTACION_BOMBEROS;
        }
        else if( botonEstacionPolicia.isSelected( ) )
        {
            tipoSeleccionado = InterfazMapaCiudad.ESTACION_POLICIA;
        }
        else if( botonHospital.isSelected( ) )
        {
            tipoSeleccionado = InterfazMapaCiudad.HOSPITAL;
        }
        return tipoSeleccionado;

    }

    /**
     * Es el método que se llama cuando se hace click sobre un botón
     * @param evento Es el evento del click sobre un botón
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( COLOR_FONDO.equals( comando ) )
        {
            Color colorFondo = JColorChooser.showDialog( this, "Color del fondo", botonColorFondo.getBackground( ) );
            botonColorFondo.setBackground( colorFondo );
        }
        else if( BORRAR.equals( comando ) )
        {
            principal.eliminar( );
        }
    }
}