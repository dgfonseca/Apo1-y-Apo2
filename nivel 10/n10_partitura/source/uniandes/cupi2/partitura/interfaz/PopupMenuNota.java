/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: PopupMenuNota.java 463 2006-10-10 15:45:29Z da-romer $ 
 * Universidad de los Andes (Bogot� - Colombia) 
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Todos los derechos reservados 2005 
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_partitura
 * Autor: Daniel Francisco Romero Acero - 25-ene-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.partitura.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 * Men� con las opciones para modificar una nota
 */
public class PopupMenuNota extends JPopupMenu implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String ELIMINAR = "Eliminar";

    private static final String CAMBIAR_INFORMACION = "CambiarInformacion";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Es una referencia a la partitura en la que se despliega el men�
     */
    private PanelPartitura panel;

    /**
     * Posici�n de la nota asociada con el men�
     */
    private int posNota;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * La opci�n para eliminar una nota
     */
    JMenuItem itemEliminar;

    /**
     * la opci�n para cambiar los atributos de la nota
     */
    JMenuItem itemCambiarInformacionNota;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el popup men�
     * @param panel Es una referencia al panel en el que se despliega el men�
     * @param pNota Posici�n de la nota asociada con el men�
     */
    public PopupMenuNota( PanelPartitura pP, int pNota )
    {
        panel = pP;
        posNota = pNota;
        setInvoker( panel );

        itemCambiarInformacionNota = new JMenuItem( "Cambiar Informaci�n" );
        itemCambiarInformacionNota.setActionCommand( CAMBIAR_INFORMACION );
        itemCambiarInformacionNota.addActionListener( this );
        add( itemCambiarInformacionNota );

        itemEliminar = new JMenuItem( "Eliminar" );
        itemEliminar.setActionCommand( ELIMINAR );
        itemEliminar.addActionListener( this );
        add( itemEliminar );

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Ejecuta la acci�n que corresponde a la opci�n del men� que fue seleccionada
     * @param evento Es el evento de seleccionar una opci�n del men�
     */
    public void actionPerformed( ActionEvent evento )
    {

        String comando = evento.getActionCommand( );

        if( CAMBIAR_INFORMACION.equals( comando ) )
        {
            panel.mostrarVentanaInformacionNota( posNota );
        }
        else if( ELIMINAR.equals( comando ) )
        {
            pedirConfirmacion( );
        }
    }

    /**
     * Este m�todo solicita una confirmaci�n para eliminar una nota. <br>
     * Presenta una ventana con las opciones "Si" y "No". <br>
     * Si se selecciona "Si", entonces se elimina la nota. <br>
     * Si se selecciona "No", la nota no se elimina <br>
     */
    private void pedirConfirmacion( )
    {

        int respuesta = JOptionPane.showConfirmDialog( panel, "Desea eliminar la nota?", "Eliminar Nota", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE );

        if( respuesta == JOptionPane.YES_OPTION )
        {
            panel.eliminarNota( posNota );
        }
    }

}
