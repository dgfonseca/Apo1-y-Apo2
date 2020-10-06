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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel con la información de una línea telefónica.
 */
public class PanelLineaTelefonica extends JPanel implements ActionListener
{

    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Comando para agregar una llamada.
     */
    private static final String AGREGAR = "AGREGAR";

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazLineasTelefonicas principal;

    /**
     * Número del línea telefónica.
     */
    private int numeroLinea;

    //-----------------------------------------------------------------
    // Atributos de Interfaz
    //-----------------------------------------------------------------

    /**
     * Etiqueta con la imagen del teléfono.
     */
    private JLabel etiquetaImagen;

    /**
     * Etiqueta costo de llamadas.
     */
    private JLabel etiquetaCosto;

    /**
     * Etiqueta número de llamadas.
     */
    private JLabel etiquetaNumeroLlamadas;

    /**
     * Etiqueta minutos consumidos.
     */
    private JLabel etiquetaMinutos;
    
    /**
     * Campo de texto para el número de llamadas.
     */
    private JTextField txtNumeroLlamadas;
    
    /**
     * Campo de texto para los minutos consumidos
     */
    private JTextField txtMinutos;

    /**
     * Botón Agregar llamada.
     */
    private JButton btnAgregar;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor del panel.
     * <b>post: </b> Se construyó el panel.
     * @param pPrincipal Ventana principal. pPrincipal != null.
     * @param pNumeroLinea Número de la línea. pNumeroLinea>0 && pNumeroLinea<4.
     */
    public PanelLineaTelefonica( InterfazLineasTelefonicas pPrincipal, int pNumeroLinea )
    {
        principal = pPrincipal;
        numeroLinea = pNumeroLinea;
        setBorder( new TitledBorder( "Línea " + numeroLinea ) );
        setLayout( new GridLayout( 2, 1 ) );
        setPreferredSize( new Dimension( 260, 220 ) );

        //Etiqueta de Imagen
        ImageIcon icono = new ImageIcon( "data/linea" + numeroLinea + ".png" );
        etiquetaImagen = new JLabel( "" );
        etiquetaImagen.setIcon( icono );
        etiquetaImagen.setHorizontalAlignment( JLabel.CENTER );

        //Etiqueta Costo
        etiquetaCosto = new JLabel( formatearValor( 0 ) );
        etiquetaCosto.setForeground( Color.BLUE.darker( ) );
        etiquetaCosto.setFont( new Font( "Times New Roman", Font.BOLD, 18 ) );
        etiquetaCosto.setHorizontalAlignment( JLabel.CENTER );

        //Etiqueta Número de llamadas
        etiquetaNumeroLlamadas = new JLabel( "Número llamadas: " );

        //Etiqueta Total de Minutos
        etiquetaMinutos = new JLabel( "Número minutos: " );

        //Campo de texto Número de llamadas
        txtNumeroLlamadas = new JTextField( 4 );
        txtNumeroLlamadas.setEditable( false );
        txtNumeroLlamadas.setText( "0" );
        
        //Campo de texto Total de Minutos
        txtMinutos = new JTextField( 4 );
        txtMinutos.setEditable( false );
        txtMinutos.setText( "0" );
        
        //Botón Agregar llamada
        btnAgregar = new JButton( "Agregar llamada" );
        btnAgregar.setPreferredSize( new Dimension( 150, 25 ) );
        btnAgregar.setActionCommand( AGREGAR );
        btnAgregar.addActionListener( this );

        //Organización.
        JPanel panelDatos = new JPanel( new GridLayout( 4, 1 ) );
        JPanel panelLlamadas = new JPanel( new BorderLayout( ) );
        JPanel panelMinutos = new JPanel( new BorderLayout( ) );
        
        panelDatos.setBorder( new EmptyBorder( 8, 0, 8, 0 ) );
        panelDatos.add( etiquetaCosto );
        panelDatos.add( panelLlamadas );
        panelDatos.add( panelMinutos );
        panelDatos.add( btnAgregar );
  
        panelLlamadas.add( etiquetaNumeroLlamadas, BorderLayout.CENTER );
        panelLlamadas.add( txtNumeroLlamadas, BorderLayout.EAST );
        panelMinutos.add( etiquetaMinutos, BorderLayout.CENTER );
        panelMinutos.add( txtMinutos, BorderLayout.EAST );
        
        add ( etiquetaImagen );
        add ( panelDatos );
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Actualiza la visualización de la información.
     * @param pCostoLlamadas Costo total de las llamadas realizadas en esta línea. pCostoLlamadas>=0. 
     * @param pTotalLLamadas Total número de llamadas. pTotalLlamadas>=0.
     * @param pTotalMinutos Total número de minutos. pTotalMinutos>=0.
     */
    public void actualizar( double pCostoLlamadas, int pTotalLLamadas, int pTotalMinutos)
    {
        etiquetaCosto.setText( formatearValor( pCostoLlamadas) );
        txtNumeroLlamadas.setText( formatearValorEntero( pTotalLLamadas ) );
        txtMinutos.setText( formatearValorEntero( pTotalMinutos ) );
    }

    /**
     * Formatea un valor numérico para presentar en la interfaz.
     * @param pValor Valor numérico a ser formateado. pValor>0.
     * @return Cadena con el valor formateado con puntos y signos.
     */
    private String formatearValor( double pValor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$ ###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( pValor );
    }

    /**
     * Formatea un valor numérico para presentar en la interfaz <br>
     * @param pValor Valor numérico a ser formateado. pValor >0.
     * @return Retorna una cadena con el valor formateado con puntos y signos.
     */
    private String formatearValorEntero( int pValor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( " ###,###" );
        df.setMinimumFractionDigits( 0 );
        return df.format( pValor );
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Evento de click sobre un botón. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        if( AGREGAR.equals( pEvento.getActionCommand( ) ) )
        {
            principal.agregarLlamada( numeroLinea );
        }
    }

}
