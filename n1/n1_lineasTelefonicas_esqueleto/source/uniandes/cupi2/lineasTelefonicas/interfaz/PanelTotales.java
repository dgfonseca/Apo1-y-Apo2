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

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Panel con los totales.
 */
public class PanelTotales extends JPanel
{

    //-----------------------------------------------------------------
    // Atributos de Interfaz
    //-----------------------------------------------------------------

    /**
     * Etiqueta con el costo total de llamadas.
     */
    private JLabel etiquetaCosto;

    /**
     * Etiqueta total llamadas.
     */
    private JLabel etiquetaNumeroLlamadas;

    /**
     * Etiqueta total minutos.
     */
    private JLabel etiquetaMinutos;

    /**
     * Costo promedio de llamadas.
     */
    private JLabel etiquetaCostoPromedio;
    
    /**
     * Campo de texto para el costo total de llamadas.
     */
    private JTextField etiquetaMostrarCosto;
    
    /**
     * Campo de texto para el total llamadas.
     */
    private JTextField txtNumeroLlamadas;
    
    /**
     * Campo de texto para el total minutos.
     */
    private JTextField txtMinutos;
    
    /**
     * Campo de texto para el promedio de llamadas.
     */
    private JTextField txtCostoPromedio;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor del panel.
     * <b>post: </b> Se construyó el panel.
     */
    public PanelTotales( )
    {
        setBorder( new TitledBorder( "Totales" ) );
        setLayout( new GridLayout( 4, 2 ) );

        //Etiqueta Costo
        etiquetaCosto = new JLabel( "Costo total:" );
        etiquetaCosto.setForeground( Color.BLUE.darker( ) );
        etiquetaCosto.setFont( new Font( "Times New Roman", Font.BOLD, 20 ) );

        //Etiqueta Numero de llamadas
        etiquetaNumeroLlamadas = new JLabel( "Número total de llamadas:" );

        //Etiqueta Total de Minutos
        etiquetaMinutos = new JLabel( "Número total de minutos:" );

        //Etiqueta costo promedio por minuto
        etiquetaCostoPromedio = new JLabel( "Costo promedio por minuto:" );
        
        //Campo de texto Costo
        etiquetaMostrarCosto = new JTextField( 8 );
        etiquetaMostrarCosto.setForeground( Color.BLUE.darker( ) );
        etiquetaMostrarCosto.setFont( new Font( "Times New Roman", Font.BOLD, 16 ) );
        etiquetaMostrarCosto.setText( formatearValor( 0 ) );
        etiquetaMostrarCosto.setEditable( false );
        
        //Campo de texto Numero de llamadas
        txtNumeroLlamadas = new JTextField( 6 );
        txtNumeroLlamadas.setEditable( false );
        txtNumeroLlamadas.setText( "0" );
        
        //Campo de texto Total de Minutos
        txtMinutos = new JTextField( 6 );
        txtMinutos.setEditable( false );
        txtMinutos.setText( "0" );
        
        //Campo de texto costo promedio por minuto
        txtCostoPromedio = new JTextField( 6 );
        txtCostoPromedio.setEditable( false );
        txtCostoPromedio.setText( "N/A" );
        
        add( etiquetaCosto );
        add( etiquetaMostrarCosto );
        add( etiquetaNumeroLlamadas );
        add( txtNumeroLlamadas );
        add( etiquetaMinutos );
        add( txtMinutos );
        add( etiquetaCostoPromedio );
        add( txtCostoPromedio );
        
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Actualiza la información.
     * @param pCostoTotal Costo total de las llamadas de las tres líneas. pCostoTotal>=0.
     * @param pTotalLlamadas Total número de llamadas. pTotalLlamadas>=0.
     * @param pTotalMinutos Total número de minutos. pTotalMinutos>=0.
     * @param pCostoPromedio Costo promedio por minutos. pCostoPromedio>=0.
     */
    public void actualizar( double pCostoTotal, int pTotalLlamadas, int pTotalMinutos, double pCostoPromedio )
    {
    	etiquetaMostrarCosto.setText( formatearValor( pCostoTotal ) );
    	txtNumeroLlamadas.setText( formatearValorEntero( pTotalLlamadas ) );
    	txtMinutos.setText( formatearValorEntero( pTotalMinutos ) );
        if( !Double.isNaN( pCostoPromedio ) )
        {
        	txtCostoPromedio.setText( formatearValor( pCostoPromedio ) );
        }
        else
        {
        	txtCostoPromedio.setText( "N/A" );
        }
        
    }

    /**
     * Formatea un valor numérico para presentar en la interfaz. <br>
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
     * @param pValor Valor numérico a ser formateado. pValor>0.
     * @return Cadena con el valor formateado con puntos y signos.
     */
    private String formatearValorEntero( int pValor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( " ###,###" );
        df.setMinimumFractionDigits( 0 );
        return df.format( pValor );
    }

}
