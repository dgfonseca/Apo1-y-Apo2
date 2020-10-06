/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_FabricaDeUniformes
 * Autor: Equipo Cupi2 2018-1
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.fabricaDeUniformes.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Barra que contiene los men�s de la aplicaci�n
 */
@SuppressWarnings("serial")
public class BarraMenu extends JMenuBar implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante para un nuevo uniforme.
     */
    private static final String NUEVO = "Nuevo";

    /**
     * Constante para abrir un uniforme.
     */
    // TODO HECHO Parte9 PuntoA. Agregue la constante de Abrir.
    private static final String ABRIR = "Abrir";


    /**
     * Constante para guardar un uniforme.
     */
    // TODO HECHO Parte9 PuntoB. Agregue la constante de Guardar.
    private static final String GUARDAR = "GUARDAR";


    /**
     * Constante para guardar, decir como se llama y donde se ubica un uniforme.
     */
    // TODO HECHO Parte7 PuntoC. Agregue la constante de GuardarComo.
    private static final String GUARDAR_COMO = "GuardarComo";


    /**
     * Constante para salir del programa.
     */
    // TODO HECHO Parte7 PuntoD. Agregue la constante de Salir.
    private static final String SALIR = "Salir";


    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz.
     */
    private InterfazFabricaDeUniformes principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * El men� archivo.
     */
    private JMenu menuArchivo;

    /**
     * La opci�n "nuevo" del men� archivo.
     */
    private JMenuItem itemNuevo;

    /**
     * La opci�n "abrir" del men� archivo.
     */
    private JMenuItem itemAbrir;
    // TODO HECHO Parte9 PuntoE. Agregue el atributo para el item Abrir.
    

    /**
     * La opci�n "guardar" del men� archivo.
     */
    private JMenuItem itemGuardar;
    // TODO HECHO Parte9 PuntoF. Agregue el atributo para el item Guardar.

    /**
     * La opci�n "guardar como" del men� archivo.
     */
    private JMenuItem itemGuardarComo;
    // TODO HECHO Parte9 PuntoG. Agregue el atributo para el item GuardarComo.

    /**
     * La opci�n Salir del men� archivo
     */
    private JMenuItem itemSalir;
    // TODO HECHO Parte9 PuntoH. Agregue el atributo para el item Salir.

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la barra de men�.
     * @param pPrincipal Es una referencia a la clase principal de la interfaz. pPrincipal != null.
     */
    public BarraMenu( InterfazFabricaDeUniformes pPrincipal )
    {
        // TODO HECHO Parte9 PuntoI. Inicialice todos los nuevos items y agreguelos a la barra.
        // Verifique que la interfaz luzca como en el documento de descripci�n.
        principal = pPrincipal;

        menuArchivo = new JMenu( "Archivo" );
        menuArchivo.setMnemonic( KeyEvent.VK_A );
        add( menuArchivo );

        itemNuevo = new JMenuItem( "Nuevo" );
        itemNuevo.setActionCommand( NUEVO );
        itemNuevo.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_N, ActionEvent.CTRL_MASK ) );
        itemNuevo.setMnemonic( KeyEvent.VK_N );
        itemNuevo.addActionListener( this );
        menuArchivo.add( itemNuevo );
        
        itemAbrir = new JMenuItem("Abrir");
        itemAbrir.setActionCommand(ABRIR);
        itemAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        itemAbrir.setMnemonic(KeyEvent.VK_N);
        itemAbrir.addActionListener(this);
        menuArchivo.add(itemAbrir);
        
        itemGuardar = new JMenuItem("Guardar");
        itemGuardar.setActionCommand(GUARDAR);
        itemGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        itemGuardar.setMnemonic(KeyEvent.VK_N);
        itemGuardar.addActionListener(this);
        menuArchivo.add(itemGuardar);
        
        itemGuardarComo = new JMenuItem("Guardar Como");
        itemGuardarComo.setActionCommand(GUARDAR_COMO);
        itemGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        itemGuardarComo.setMnemonic(KeyEvent.VK_N);
        itemGuardarComo.addActionListener(this);
        menuArchivo.add(itemGuardarComo);
        
        itemSalir = new JMenuItem("Salir");
        itemSalir.setActionCommand(SALIR);
        itemSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        itemSalir.setMnemonic(KeyEvent.VK_N);
        itemSalir.addActionListener(this);
        menuArchivo.add(itemSalir);
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Ejecuta la acci�n que corresponde a la opci�n del men� que fue seleccionada.
     * @param pEvento Es el evento de seleccionar una opci�n del men�.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        // TODO HECHO Parte7 PuntoJ. Modifique el m�todo para incluir las nuevas opciones creadas.

        String comando = pEvento.getActionCommand( );

        if( NUEVO.equals( comando ) )
        {
            principal.reiniciar( );
        }
        else if( ABRIR.equals(comando) )
        {
        	principal.abrir();
        }
        else if( GUARDAR.equals(comando))
        {
        	principal.salvar();
        }
        else if( GUARDAR_COMO.equals(comando))
        {
        principal.salvarComo();	
        }
        else if( SALIR.equals(comando))
        {
        	principal.dispose();
        }

    }

}
