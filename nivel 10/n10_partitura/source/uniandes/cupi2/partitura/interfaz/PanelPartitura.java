/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: PanelPartitura.java 600 2006-11-06 06:16:53Z da-romer $ 
 * Universidad de los Andes (Bogot� - Colombia) 
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Todos los derechos reservados 2005 
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_partitura
 * Autor: Diana Puentes - Jul 29, 2005
 * Modificado por: Daniel Francisco Romero- Marzo 21, 2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.partitura.interfaz;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.partitura.mundo.Partitura;

/**
 * Panel que muestra la partitura gu�a de la canci�n a tocar
 */
public class PanelPartitura extends JPanel implements MouseListener
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Ventana principal de la aplicaci�n
     */
    private InterfazPartitura principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un panel para visualizar una partitura
     * @param interP Es una referencia a la ventana principal de la aplicaci�n
     */
    public PanelPartitura( InterfazPartitura interP )
    {
        // dispone la organizaci�n de la partitura
        GridBagLayout gridbag1 = new GridBagLayout( );
        setLayout( gridbag1 );
        setBorder( new CompoundBorder( new EmptyBorder( 10, 10, 10, 10 ), new TitledBorder( "" ) ) );
        setDoubleBuffered( true );
        setPreferredSize( new Dimension( Partitura.ANCHO_PARTITURA, Partitura.ALTO_PARTITURA ) );
        addMouseListener( this );

        // Inicializa los atributos
        principal = interP;

        // Pinta la partitura
        actualizar( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Este m�todo se encarga de actualizar la visualizaci�n de la partitura
     */
    public void actualizar( )
    {
        repaint( );
        validate( );
    }

    /**
     * Este es el m�todo que se encarga de actualizar la visualizaci�n de la partitura
     * @param g Es la superficie del panel
     */
    public void update( Graphics2D g )
    {
        g.setStroke( new BasicStroke( 1 ) );
        g.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
        g.setColor( getBackground( ) );
        g.fillRect( 0, 0, getWidth( ), getHeight( ) );

        // Dibujar la partitura
        principal.pintarPartitura( g );

    }

    /**
     * Este es el m�todo llamado por la m�quina virtual cuando hay que repintar el panel. <br>
     * <code>super.paint( g )</code> no sabe pintar las figuras, as� que hay que<br>
     * sobrecargar el m�todo.<br>
     * @param g Es la superficie del panel
     */
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        update( ( Graphics2D )g );
    }

    /**
     * Repinta la partitura.
     * @param g La superficie del componente
     */
    public void paintComponents( Graphics g )
    {
        super.paintComponents( g );

        validate( );
    }

    /**
     * Este m�todo se llama cuando se hace click sobre la superficie del panel partitura. <br>
     * Dependiendo de la opci�n seleccionada se debe agregar una figura al mapa o se debe <br>
     * seleccionar una de las figuras existentes. <br>
     * Si la opci�n seleccionada es SELECCIONAR y se hace doble click sobre una figura se<br>
     * debe poder cambiar su texto.
     * @param evento Es el evento del clic sobre el panel
     */
    public void mouseClicked( MouseEvent evento )
    {
        if( evento.getButton( ) == MouseEvent.BUTTON1 )
        {
            if( evento.getClickCount( ) == 2 )
            {
                principal.mostrarVentanaTitulo( );
            }
        }
        else if( evento.getButton( ) == MouseEvent.BUTTON3 )
        {
            int x = evento.getX( );
            int y = evento.getY( );
            int posNota = principal.buscarNota( x, y );
            if( posNota != -1 )
            {
                PopupMenuNota menu = new PopupMenuNota( this, posNota );

                menu.setInvoker( this );
                menu.setEnabled( true );
                menu.setLocation( x, y );
                menu.setVisible( true );

            }
        }

    }

    /**
     * Este m�todo no se implementa
     * @param evento El evento
     */
    public void mousePressed( MouseEvent arg0 )
    {
        // No se requiere
    }

    /**
     * Este m�todo no se implementa
     * @param evento El evento
     */
    public void mouseReleased( MouseEvent arg0 )
    {
        // No se requiere

    }

    /**
     * Este m�todo no se implementa
     * @param evento El evento
     */
    public void mouseEntered( MouseEvent arg0 )
    {
        // No se requiere
    }

    /**
     * Este m�todo no se implementa
     * @param evento El evento
     */
    public void mouseExited( MouseEvent arg0 )
    {
        // No se requiere

    }

    /**
     * Elimina la nota en la posici�n especificada
     * @param posNota Posici�n de la nota a ser eliminada
     */
    public void eliminarNota( int posNota )
    {

        principal.eliminarNota( posNota );

    }

    /**
     * Muestra la ventana para modificar la informaci�n de la nota en la posici�n especificada
     * 
     */
    public void mostrarVentanaInformacionNota( int pos )
    {
        principal.mostrarVentanaInformacionNota( pos );

    }

}
