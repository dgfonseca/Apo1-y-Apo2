package uniandes.cupi2.exploradorCuevas.interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BorderFactory;
import javax.swing.JButton;

import javax.swing.JPanel;

@SuppressWarnings("serial")
/**
 * Este es el panel donde están los botones que controlan la aplicación
 */
public class Opciones extends JPanel implements ActionListener
{

	 //-----------------------------------------------------------------
    // Constantes
    //------------------------------------------------------------------
	
	public static final String CARGAR = "cargar";
	public static final String REINICIAR = "reiniciar";
	public static final String OPCION_1 = "opcion1";
	public static final String OPCION_2 = "opcion2";
	
	//-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

	/**
     * Es una referencia a la clase principal de la interfaz
     */
	private InterfazPrincipal ventana;
	
	 //-----------------------------------------------------------------
    // Atributos de la Interfaz
    //-----------------------------------------------------------------
	
	 /**
     * Es el botón para cargar el juego
     */
	private JButton botonCargar;
	 /**
     * Es el botón para reiniciar el juego desde el principio
     */
	private JButton botonReiniciar;
	
	 /**
     * Es el botón para ejecutar el punto de extensión 1
     */
	private JButton botonOpcion1;
	
	 /**
     * Es el botón para ejecutar el punto de extensión 2
     */
	private JButton botonOpcion2;
	
	
	//-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Inicializa un nuevo panel de opciones
     * @param nueva - Es una referencia a la clase principal de la interfaz
     */
	public Opciones (InterfazPrincipal nueva)
	{
		ventana = nueva;
		setBorder(BorderFactory.createTitledBorder("Opciones"));
		setLayout(new GridLayout(1,4));
		botonCargar = new JButton ("Cargar");
		botonCargar.setActionCommand(CARGAR);
		botonCargar.addActionListener(this);
		
		
		botonReiniciar = new JButton ("Reiniciar");
		botonReiniciar.setActionCommand(REINICIAR);
		botonReiniciar.addActionListener(this);
		
		
		botonOpcion1 = new JButton ("Opcion 1");
		botonOpcion1.setActionCommand(OPCION_1);
		botonOpcion1.addActionListener(this);
		
		botonOpcion2 = new JButton ("Opcion 2");
		botonOpcion2.setActionCommand(OPCION_2);
		botonOpcion2.addActionListener(this);
		
		add (botonCargar);
		add (botonReiniciar);
		add (botonOpcion1);
		add (botonOpcion2);
		
		
		
		
		
	}
	
	
	
	//-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Este método se ejecuta cuando se hace click sobre un botón
     * @param pEvento El evento del click sobre un botón. pEvento != null.
     */
	
	public void actionPerformed(ActionEvent pEvento)
	{
		String comando = pEvento.getActionCommand();
		
		if (comando.equals(CARGAR))
		{
			ventana.cargar();
		}
		else if (comando.equals(REINICIAR))
		{	
			ventana.reiniciar();
		}
		else if (comando.equals(OPCION_1))
		{
			ventana.metodo1();
		}
		else if (comando.equals(OPCION_2))
		{
			ventana.metodo2();
		}
	}
	

	
	
	
	
	
	
}
