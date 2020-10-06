/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelMapa.java,v 1.2 2007/04/12 14:10:27 carl-veg Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_mapaCiudad
 * Autor: Daniel Francisco Romero Acero - 25-ene-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.mapaCiudad.interfaz;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.mapaCiudad.mundo.Carretera;
import uniandes.cupi2.mapaCiudad.mundo.IConstruccion;

/**
 * Panel en el que se despliega el mapa
 */
public class PanelMapa extends JPanel implements MouseListener, MouseMotionListener
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazMapaCiudad principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel
     * @param ip Es una referencia a la clase principal de la interfaz
     */
    public PanelMapa( InterfazMapaCiudad ip )
    {
        principal = ip;

        addMouseListener( this );
        addMouseMotionListener( this );

        setDoubleBuffered( true );
        setBorder( new TitledBorder( "" ) );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Este método se encarga de actualizar la visualización del mapa
     */
    public void actualizar( )
    {
        repaint( );
    }

    /**
     * Este es el método que se encarga de actualizar la visualización del mapa
     * @param g Es la superficie del panel
     */
    public void update( Graphics2D g )
    {
        g.setStroke( new BasicStroke( 1 ) );
        g.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
        g.setColor( getBackground( ) );
        g.fillRect( 0, 0, getWidth( ), getHeight( ) );

        // Dibujar las construcciones
        principal.pintarConstrucciones( g );
        IConstruccion sombreada = principal.darSombreado( );
        if( sombreada != null )
        {
            sombreada.pintarSombreada( g );
        }

        IConstruccion seleccionada = principal.darSeleccionada( );
        if( seleccionada != null )
        {
            seleccionada.pintarSeleccionada( g );
        }
    }

    /**
     * Este es el método llamado por la máquina virtual cuando hay que repintar el panel <br>. super.paint( g ) no sabe pintar las figuras, así que hay que sobrecargar el
     * método.
     * @param g Es la superficie del panel
     */
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        update( ( Graphics2D )g );
    }

    /**
     * Este método se llama cuando se hace click sobre la superficie del panel mapa. <br>
     * Dependiendo de la opción seleccionada se debe agregar una figura al mapa o se debe seleccionar una de las figuras existentes. <br>
     * Si la opción seleccionada es SELECCIONAR y se hace doble click sobre una figura se debe poder cambiar su texto.
     * @param evento Es el evento del click sobre el panel mapa
     */
    public void mouseClicked( MouseEvent evento )
    {
        if( evento.getButton( ) == MouseEvent.BUTTON1 )
        {
            int opcion = principal.darOpcionSeleccionada( );

            int x = evento.getX( );
            int y = evento.getY( );

            if( opcion == InterfazMapaCiudad.SELECCIONAR )
            {
                principal.seleccionar( x, y );
                if( evento.getClickCount( ) > 1 )
                {
                    principal.mostrarVentanaTexto( );
                }
            }
            else if( opcion == InterfazMapaCiudad.CASA || opcion == InterfazMapaCiudad.EDIFICIO || // <br>
                    opcion == InterfazMapaCiudad.HOSPITAL || opcion == InterfazMapaCiudad.ESTACION_BOMBEROS || // <br>
                    opcion == InterfazMapaCiudad.ESTACION_POLICIA || opcion == InterfazMapaCiudad.CALLE || // <br>
                    opcion == InterfazMapaCiudad.CARRERA || opcion == InterfazMapaCiudad.GLORIETA || // <br>
                    opcion == InterfazMapaCiudad.ESQUINA1 || opcion == InterfazMapaCiudad.ESQUINA2 || // <br>
                    opcion == InterfazMapaCiudad.ESQUINA3 || opcion == InterfazMapaCiudad.ESQUINA4 )
            {
                int xReal = ( x / Carretera.ANCHO_CARRETERA ) * Carretera.ANCHO_CARRETERA;
                int yReal = ( y / Carretera.ALTO_CARRETERA ) * Carretera.ALTO_CARRETERA;

                principal.cambiarSeleccionada( null );
                principal.agregarConstruccion( xReal, yReal );
            }
        }
    }

    /**
     * Este método no se implementa
     * @param evento El evento
     */
    public void mousePressed( MouseEvent evento )
    {
        // No se requiere
    }

    /**
     * Este método no se implementa
     * @param evento El evento
     */
    public void mouseReleased( MouseEvent evento )
    {
        // No se requiere
    }

    /**
     * Este método no se implementa
     * @param evento El evento
     */
    public void mouseEntered( MouseEvent evento )
    {
        // No se requiere
    }

    /**
     * Este método se llama cuando el mouse sala del área del panel
     * @param evento El evento
     */
    public void mouseExited( MouseEvent evento )
    {
        principal.cambiarSombreada( null );
        actualizar( );
    }

    /**
     * Este método no se implementa
     * @param evento El evento
     */
    public void mouseDragged( MouseEvent evento )
    {
        // No se requiere
    }

    /**
     * Este método se llama cuando se mueve el mouse sobre la superficie del panel mapa. <br>
     * Cuando el mouse se mueve
     * @param evento Es el evento de movimiento sobre el panel mapa
     */
    public void mouseMoved( MouseEvent evento )
    {
        int x = evento.getX( );
        int y = evento.getY( );
        int xReal = ( x / Carretera.ANCHO_CARRETERA ) * Carretera.ANCHO_CARRETERA;
        int yReal = ( y / Carretera.ALTO_CARRETERA ) * Carretera.ALTO_CARRETERA;

        principal.calcularSombra( xReal, yReal );
        actualizar( );
    }
}
