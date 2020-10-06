/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelEditor.java,v 1.9 2010/04/19 17:34:58 lr.ruiz114 Exp $ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_paint
 * Autor: Mario S�nchez - 27/09/2005 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.paint.interfaz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import uniandes.cupi2.paint.mundo.*;

/**
 * Este es el panel que maneja la interacci�n con el rat�n y muestra las figuras dibujadas
 */
public class PanelEditor extends JPanel implements MouseListener
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazPaint principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel
     * @param ip Es una referencia a la clase principal de la interfaz
     * @param e Es una referencia al editor de la aplicaci�n
     */
    public PanelEditor( InterfazPaint ip, Dibujo e )
    {
        principal = ip;

        addMouseListener( this );

        setDoubleBuffered( true );
        setBorder( new TitledBorder( "" ) );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Este m�todo se encarga de actualizar la visualizaci�n de la composici�n
     */
    public void refrescar( )
    {
        repaint( );
    }

    /**
     * Este es el m�todo llamado por la m�quina virtual cuando hay que repintar el panel<br>. <code>super.paint( g )</code> no sabe pintar las figuras, as� que hay que
     * sobrecargar el m�todo.
     * @param g Es la superficie del panel
     */
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        Graphics2D g2 = ( Graphics2D )g;
        g2.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
        g2.setColor( getBackground( ) );
        g2.fillRect( 0, 0, getWidth( ), getHeight( ) );

        // Dibujar las figuras
        principal.dibujarFiguras( g2 );

        // dibujar el punto seleccionado si lo hay
        int xSeleccionado = principal.getXSeleccionado();
        int ySeleccionado = principal.getYSeleccionado();
        if( xSeleccionado != -1 && ySeleccionado != -1 )
        {
            g2.setColor( Color.GREEN );
            g2.fillOval( xSeleccionado - 2, ySeleccionado - 2, 3, 3 );
        }
    }

    /**
     * Este m�todo se llama cuando se hace click sobre la superficie del editor.
     * @param evento Es el evento del click sobre el editor
     */
    public void mouseClicked( MouseEvent evento )
    {
        if( evento.getButton( ) == MouseEvent.BUTTON1 )
        {
        	int numClick =  evento.getClickCount( );
        	principal.hacerClick(numClick, evento.getX(), evento.getY());
        }
    }

    /**
     * Este m�todo no se implementa
     * @param arg0 El evento
     */
    public void mousePressed( MouseEvent arg0 )
    {// No se requiere
    }

    /**
     * Este m�todo no se implementa
     * @param arg0 El evento
     */
    public void mouseReleased( MouseEvent arg0 )
    {// No se requiere
    }

    /**
     * Este m�todo no se implementa
     * @param arg0 El evento
     */
    public void mouseEntered( MouseEvent arg0 )
    {// No se requiere
    }

    /**
     * Este m�todo no se implementa
     * @param arg0 El evento
     */
    public void mouseExited( MouseEvent arg0 )
    {// No se requiere
    }
}