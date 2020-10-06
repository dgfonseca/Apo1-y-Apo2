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

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import uniandes.cupi2.buscaminas.mundo.CampoMinado;
import uniandes.cupi2.buscaminas.mundo.CampoMinado.EstadoJuego;
import uniandes.cupi2.buscaminas.mundo.Casilla;
import uniandes.cupi2.buscaminas.mundo.Casilla.Tipo;

/**
 * Este es el panel donde se juega y se muestra el estado actual del campo minado.
 */
@SuppressWarnings("serial")
public class PanelBuscaminas extends JPanel implements ActionListener
{

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
     * Botones de las casillas.
     */
    private JButton[][] botonesCasillas;

    /**
     * Ancho de la visualización actual.
     */
    private int ancho;

    /**
     * Alto de la visualización actual.
     */
    private int alto;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel como una grilla del tamaño del campo minado.
     * @param pPrincipal Referencia a la ventana principal. pPrincipal != null.
     * @param pColumnas número de columnas del panel.
     * @param pFilas número de filas del panel.
     */
    public PanelBuscaminas( InterfazBuscaminas pPrincipal)
    {
        principal = pPrincipal;

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa la matriz de botones.
     */
    public void inicializar( int pFilas, int pColumnas  )
    {
    	alto = pFilas;
    	ancho = pColumnas;
        // Filas, Columnas
        setLayout( new GridLayout( alto, ancho ) );
        botonesCasillas = new JButton[alto][ancho];

        // Se llena la matriz
        Font fuente = new Font( "Tahoma", Font.PLAIN, 10 );

        for( int i = 0; i < alto; i++ )
        {
            for( int j = 0; j < ancho; j++ )
            {

                botonesCasillas[ i ][ j ] = new JButton( );
                botonesCasillas[ i ][ j ].addActionListener( this );
                botonesCasillas[ i ][ j ].setActionCommand( i + "," + j );
                botonesCasillas[ i ][ j ].setFont( fuente );
                botonesCasillas[ i ][ j ].setMargin( new Insets( 1, 1, 1, 1 ) );
                add( botonesCasillas[ i ][ j ] );

            }

        }
    }

    /**
     * Actualiza la visualización del campo minado.
     * @param pCampoMinado El campo minado a mostrar. pCampoMinado != null.
     */
    public void actualizar( CampoMinado pCampoMinado )
    {
        Casilla[][] casillas = pCampoMinado.darCasillas( );

        // Realiza un ciclo que recorre cada una de las casillas, revisa su estado, y repinta la casilla dependiendo de su estado
        for( int i = 0; i < pCampoMinado.darFilas( ); i++ )
        {
            for( int j = 0; j < pCampoMinado.darColumnas( ); j++ )
            {
                JButton boton = botonesCasillas[ i ][ j ];

                // Cambia el estado de una casilla cuyo estado es BOMBA_ESTALLADA
                if( casillas[ i ][ j ].darEstado( ) == Tipo.BOMBA_ESTALLADA )
                {
                    boton.setText( "" );
                    boton.setEnabled( true );
                    boton.setContentAreaFilled( false );
                    boton.setIcon( new ImageIcon( new ImageIcon( casillas[ i ][ j ].darImagen( ) ).getImage( ).getScaledInstance( 45, 45, Image.SCALE_DEFAULT ) ) );
                }
                // Cambia el estado de una casilla cuyo estado es BOMBA
                else if( casillas[ i ][ j ].darValor( ) == Tipo.MINADA && principal.darEstadoJuego( ) == EstadoJuego.JUEGO_PERDIDO )
                {
                    boton.setText( "" );
                    boton.setEnabled( true );
                    boton.setContentAreaFilled( false );
                    boton.setIcon( new ImageIcon( new ImageIcon( casillas[ i ][ j ].darImagen( ) ).getImage( ).getScaledInstance( 45, 45, Image.SCALE_DEFAULT ) ) );
                }
                // Cambia el estado de una casilla cuyo estado es MARCADA
                else if( casillas[ i ][ j ].darEstado( ) == Tipo.MARCADA )
                {
                    boton.setText( "" );
                    boton.setEnabled( true );
                    boton.setContentAreaFilled( false );
                    boton.setIcon( new ImageIcon( new ImageIcon( casillas[ i ][ j ].darImagen( ) ).getImage( ).getScaledInstance( 45, 45, Image.SCALE_DEFAULT ) ) );
                }
                // Cambia el estado de una casilla cuyo estado es MARCADA_EQUIVOCADA
                else if( casillas[ i ][ j ].darEstado( ) == Tipo.MARCADA_EQUIVOCADA )
                {
                    boton.setText( "" );
                    boton.setEnabled( true );
                    boton.setContentAreaFilled( false );
                    boton.setIcon( new ImageIcon( new ImageIcon( casillas[ i ][ j ].darImagen( ) ).getImage( ).getScaledInstance( 45, 45, Image.SCALE_DEFAULT ) ) );
                }
                // Cambia el estado de una casilla cuyo estado es TAPADA
                else if( casillas[ i ][ j ].darEstado( ) == Tipo.TAPADA )
                {
                    boton.setText( "" );
                    boton.setEnabled( true );
                    boton.setContentAreaFilled( false );
                    boton.setIcon( new ImageIcon( new ImageIcon( casillas[ i ][ j ].darImagen( ) ).getImage( ).getScaledInstance( 45, 45, Image.SCALE_DEFAULT ) ) );
                }
                else
                {
                    boton.setIcon( new ImageIcon( casillas[ i ][ j ].darImagen( ) ) );
                    boton.setEnabled( true );
                    boton.setContentAreaFilled( false );
                    boton.setIcon( new ImageIcon( new ImageIcon( casillas[ i ][ j ].darImagen( ) ).getImage( ).getScaledInstance( 45, 45, Image.SCALE_DEFAULT ) ) );

                }
            }
        }

    }

    /**
     * Este método se ejecuta cuando se hace click sobre alguno de los botones que representan las casillas.
     * @param pEvento El evento del click sobre uno de los botones.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        String[] coordenada = comando.split( "," );
        int i = Integer.parseInt( coordenada[ 0 ] );
        int j = Integer.parseInt( coordenada[ 1 ] );

        principal.jugar( i, j );
    }

}
