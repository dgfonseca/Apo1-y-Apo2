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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * Este panel se usa para mostrar la barra de estado del juego.
 */
@SuppressWarnings("serial")
public class PanelEstado extends JPanel
{

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Es la etiqueta donde se muestra el número de minas restantes.
     */
    private JLabel etiquetaMinas;


    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye e inicializa el panel que sirve para mostrar la barra de estado.
     */
    public PanelEstado( )
    {
        setLayout( new BorderLayout( ) );

        Font fuente = new Font( "Tahoma", Font.BOLD, 14 );

        etiquetaMinas = new JLabel( "Quedan: " );
        etiquetaMinas.setFont( fuente );
        etiquetaMinas.setBorder( new CompoundBorder( new EmptyBorder( 2, 2, 2, 2 ), new LineBorder( Color.GRAY ) ) );
        add( etiquetaMinas, BorderLayout.CENTER );

 
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza el número de minas restantes.
     * @param pMinas El número de minas restantes que deben mostrarse.
     */
    public void actualizarMinas( int pMinas )
    {
        etiquetaMinas.setText( "Quedan " + pMinas + " minas" );

    }


}
