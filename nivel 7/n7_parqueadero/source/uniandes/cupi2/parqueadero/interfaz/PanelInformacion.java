/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogot� - Colombia)
 * Departamento de  Ingenier�a  de  Sistemas    y   Computaci�n
 * Licenciado   bajo    el  esquema Academic Free License versi�n 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_Parqueadero
 * Autor: Equipo Cupi2 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.parqueadero.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel para mostrar informaci�n sobre el estado del parqueadero.
 */
@SuppressWarnings("serial")
public class PanelInformacion extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando extensi�n 1.
     */
    private final static String OPCION_1 = "OPCION 1";

    /**
     * Comando extensi�n 2.
     */
    private final static String OPCION_2 = "OPCION 2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la ventana principal de la aplicaci�n.
     */
    private InterfazParqueadero principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta para el valor de la caja.
     */
    private JLabel labValorCaja;

    /**
     * Etiqueta para el n�mero de puestos vac�os.
     */
    private JLabel labVacios;

    /**
     * Es el bot�n para ejecutar la opci�n 1.
     */
    private JButton botonOpcion1;

    /**
     * Es el bot�n para ejecutar la opci�n 2.
     */
    private JButton botonOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel. <br>
     * <b>post: </b> Se construy� el panel.
     * @param pPrincipal Instancia de la ventana principal.
     */
    public PanelInformacion( InterfazParqueadero pPrincipal )
    {
        principal = pPrincipal;
        inicializar( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Organiza el panel para mostrar el valor de la caja y el n�mero de puestos vac�os. Configura los botones.
     */
    private void inicializar( )
    {
        setLayout( new GridLayout( 2, 1 ) );
        JPanel info = new JPanel();
        info.setLayout( new GridLayout( 1, 2 ) );
        info.setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 5, 0 ), new TitledBorder( "Informaci�n" ) ) );
        JPanel opcs = new JPanel();
        opcs.setLayout( new GridLayout( 1, 2 ) );
        opcs.setBorder( new TitledBorder("Opciones") );
        add(info);
        add(opcs);
        
        labValorCaja = new JLabel( "Valor en Caja: " );
        labVacios = new JLabel( "Puestos Vac�os: " );

        botonOpcion1 = new JButton( );
        botonOpcion1.setText( "Opci�n 1" );
        botonOpcion1.setActionCommand( OPCION_1 );
        botonOpcion1.addActionListener( this );

        botonOpcion2 = new JButton( );
        botonOpcion2.setText( "Opci�n 2" );
        botonOpcion2.setActionCommand( OPCION_2 );
        botonOpcion2.addActionListener( this );
        
        info.add( labValorCaja );
        info.add( labVacios );
        opcs.add( botonOpcion1 );
        opcs.add( botonOpcion2 );
    }

    /**
     * Actualiza la informaci�n mostrada. <br>
     * <b>post: </b> Se actualiz� la informaci�n mostrada.
     * @param pVacios N�mero de puestos vac�os.
     * @param pValorCaja Cantidad de dinero en la caja.
     */
    public void actualizarDatos( int pVacios, double pValorCaja )
    {
        labVacios.setText( "Puestos Vac�os: " + pVacios );
        labValorCaja.setText( "Valor en Caja: $ " + pValorCaja );
    }

    /**
     * Ejecuta las acciones adecuadas seg�n el bot�n que haya sido presionado.
     * @param pEvento Es el evento del click sobre el bot�n.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String command = pEvento.getActionCommand( );
        if( command.equals( OPCION_1 ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( command.equals( OPCION_2 ) )
        {
            principal.reqFuncOpcion2( );
        }
    }

}
