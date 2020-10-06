/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Proyecto	Cupi2	(http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_hotel
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.hotel.interfaz;

import java.awt.Color;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Contiene el Banner.
 */
@SuppressWarnings("serial")
public class PanelImagen extends JPanel
{

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Construye el panel y añade el banner a la interfaz.
     */
    public PanelImagen( )
    {
        JLabel lblImagen = new JLabel( );
        Calendar ahora = Calendar.getInstance();
        int hora = ahora.get(Calendar.HOUR_OF_DAY);
        ImageIcon icono = new ImageIcon( "data/img/bannerNoche.png" );
        if(hora >= 6 && hora < 18)
        {
            icono = new ImageIcon( "data/img/bannerDia.png" );
        }
        
        setSize( icono.getIconHeight( ), icono.getIconWidth( ) );
        lblImagen = new JLabel( "" );
        lblImagen.setIcon( icono );
        add( lblImagen );

        setBackground( Color.WHITE );
    }

}
