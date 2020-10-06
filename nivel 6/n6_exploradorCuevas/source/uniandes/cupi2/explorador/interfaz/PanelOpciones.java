package uniandes.cupi2.explorador.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener {
	 /**
     * Constante para el comando del bot�n iniciar.
     */
    private static final String BOTON_INICIAR = "Iniciar";

    /**
     * Constante para el comando del bot�n cargar.
     */
    private static final String BOTON_CARGAR= "Cargar";
    
    /**
     * Constante para el comando del bot�n opci�n 1.
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Constante para el comando del bot�n opci�n 2.
     */
    private static final String OPCION_2 = "OPCION_2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz.
     */
    private InterfazExplorador principal;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el bot�n para (re)iniciar el campo minado.
     */
    private JButton botonIniciar;
    
    /**
     * Es el bot�n para cargar un nuevo campo de juego
     */
    private JButton botonCargar;

    /**
     * Es el bot�n para realizar la opci�n 1.
     */
    private JButton opcion1;

    /**
     * Es el bot�n para realizar la opci�n 2.
     */
    private JButton opcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con la referencia a la InterfazBuscaminas.
     * @param pPrincipal Es una referencia a la clase principal de la interfaz. pPrincipal != null.
     */
    public PanelOpciones( InterfazExplorador pPrincipal )
    {
        principal = pPrincipal;

        botonCargar = new JButton( "Cargar" );
        botonCargar.setActionCommand( BOTON_CARGAR );
        botonCargar.setToolTipText( "Cargar campo" );
        botonCargar.addActionListener( this );
        add( botonCargar );
        
        
        botonIniciar = new JButton( "Reiniciar" );
        botonIniciar.setActionCommand( BOTON_INICIAR );
        botonIniciar.setToolTipText( "Iniciar" );
        botonIniciar.addActionListener( this );
        add( botonIniciar );

        
        opcion1 = new JButton( "Opci�n 1" );
        opcion1.setToolTipText( "Opci�n 1" );
        opcion1.setActionCommand( OPCION_1 );
        opcion1.addActionListener( this );
        add( opcion1 );

        
        opcion2 = new JButton( "Opci�n 2" );
        opcion2.setToolTipText( "Opcion 2" );
        opcion2.setActionCommand( OPCION_2 );
        opcion2.addActionListener( this );
        add( opcion2 );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Este m�todo se ejecuta cuando se hace click sobre alguno de los botones.
     * @param pEvento El evento del click sobre uno de los botones.
     */
  public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

       if( BOTON_INICIAR.equals( comando ) )
        {
            try {
				principal.reiniciar( );
			} catch (Exception e) {
				
				e.printStackTrace();
			}
        }
       else if( OPCION_1.equals( comando ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( comando ) )
        {
            principal.reqFuncOpcion2( );
        }else if(BOTON_CARGAR.equals(comando)){
        	principal.mostrarDialogoCargar();
        }
    }
}


