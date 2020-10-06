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

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.fabricaDeUniformes.mundo.IParte;

/**
 * Panel en el que se despliega el lienzo de dibujo.
 */
@SuppressWarnings("serial")
public class PanelUniforme extends JPanel implements MouseListener, MouseMotionListener
{
    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazFabricaDeUniformes principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel.
     * @param pPrincipal Ventana principal de la aplicaci�n.
     */
    public PanelUniforme( InterfazFabricaDeUniformes pPrincipal )
    {
        principal = pPrincipal;

        addMouseListener( this );
        addMouseMotionListener( this );

        setDoubleBuffered( true );
        setBorder( new TitledBorder( "" ) );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Este m�todo se encarga de actualizar la visualizaci�n del uniforme.
     */
    public void actualizar( )
    {
        repaint( );
    }

    /**
     * M�todo que se encarga de actualizar la visualizaci�n del uniforme.
     * @param pGraphics - Superficie del panel.
     */
    public void update( Graphics2D pGraphics )
    {
        pGraphics.setStroke( new BasicStroke( 1 ) );
        pGraphics.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
        pGraphics.setColor( getBackground( ) );
        pGraphics.fillRect( 0, 0, getWidth( ), getHeight( ) );

        // Dibujar las figuras.

        principal.pintarPartes( pGraphics );
        IParte sombreada = principal.darSombreado( );
        if( sombreada != null )
        {
            sombreada.pintarSombreado( pGraphics );
        }

        IParte seleccionada = principal.darSeleccionada( );
        if( seleccionada != null )
        {
            seleccionada.pintarSeleccionada( pGraphics );
        }
    }

    /**
     * M�todo llamado por la m�quina virtual cuando se requiere repintar el panel. <br>
     * super.paint( pGraphics ) no sabe pintar los dibujos, as� que hay que sobrecargar el m�todo.
     * @param pGraphics Es la superficie del panel
     */
    public void paintComponent( Graphics pGraphics )
    {
        super.paintComponent( pGraphics );

        update( ( Graphics2D )pGraphics );
    }

    /**
     * M�todo se llama cuando se hace click sobre la superficie del panel uniforme. <br>
     * Dependiendo de la opci�n seleccionada, se debe agregar un dibujo al uniforme o se debe seleccionar una de las partes existentes. <br>
     * @param pEvento - Es el evento del click sobre el panel mapa.
     */
    public void mouseClicked( MouseEvent pEvento )
    {
        ArrayList<String> opciones = principal.darOpcionesSeleccion( );
        if( pEvento.getButton( ) == MouseEvent.BUTTON1 )
        {
            String opcion = principal.darOpcionSeleccionada( );
            int x = pEvento.getX( );
            int y = pEvento.getY( );

            if( opcion == opciones.get( 1 ) )
            {
                principal.seleccionar( x, y );
            }

            for( int i = 3; i < opciones.size( ); i++ )
            {
                if( opcion.equals( opciones.get( i ) ) )
                {

                    principal.cambiarSeleccionada( null );
                    principal.agregarParte( x, y );
                }
            }
        }
    }

    /**
     * M�todo que no se implementa.
     * @param pEvento El evento.
     */
    public void mousePressed( MouseEvent pEvento )
    {
        // No se requiere.
    }

    /**
     * M�todo que no se implementa.
     * @param pEvento El evento.
     */
    public void mouseReleased( MouseEvent pEvento )
    {
        // No se requiere.
    }

    /**
     * M�todo que no se implementa.
     * @param pEvento El evento.
     */
    public void mouseEntered( MouseEvent pEvento )
    {
        // No se requiere.
    }

    /**
     * M�todo que se llama cuando el mouse sale del �rea del panel.
     * @param pEvento El evento.
     */
    public void mouseExited( MouseEvent pEvento )
    {
        principal.cambiarSombreado( null );
        actualizar( );
    }

    /**
     * M�todo que no se implementa.
     * @param pEvento El evento.
     */
    public void mouseDragged( MouseEvent pEvento )
    {
        // No se requiere.
    }

    /**
     * M�todo que se llama cuando se mueve el mouse sobre la superficie del panel. <br>
     * @param pEvento Evento de movimiento sobre el panel.
     */
    public void mouseMoved( MouseEvent pEvento )
    {
        int x = pEvento.getX( );
        int y = pEvento.getY( );
        principal.calcularSombra( x, y );
        actualizar( );
    }

}
