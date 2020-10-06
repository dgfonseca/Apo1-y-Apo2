/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n10_FabricaDeUniformes
 * Autor: Equipo Cupi2 2018-1
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.fabricaDeUniformes.interfaz;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase que muestra el banner de la ventana.
 */
@SuppressWarnings("serial")
public class PanelImagen extends JPanel
{

    /**
     * Coloca la imagen del banner de la aplicación.
     */
    public PanelImagen( )
    {
        JLabel imagen = new JLabel( );
        ImageIcon icono = new ImageIcon( "./data/imagenes/titulo.jpg" );
        // La agrega a la etiqueta
        imagen = new JLabel( );
        imagen.setIcon( icono );
        add( imagen );

        setBackground( null );
    }
}
