/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_lineasTelefonicas
 * Autor: Equipo Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.lineasTelefonicas.interfaz;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel con la imagen de la aplicación..
 */
public class PanelImagen extends JPanel
{

    //-----------------------------------------------------------------
    // Atributos de Interfaz
    //-----------------------------------------------------------------

    /**
     * Etiqueta con la imagen de la aplicación.
     */
    private JLabel etiquetaImagen;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor del panel.
     * <b>post: </b> Se construyó el panel.
     */
    public PanelImagen( )
    {
        //Etiqueta Logo de la empresa
        ImageIcon icono = new ImageIcon( "data/Encabezado.png" );
        etiquetaImagen = new JLabel( "" );
        etiquetaImagen.setIcon( icono );

        add( etiquetaImagen );
    }

}
