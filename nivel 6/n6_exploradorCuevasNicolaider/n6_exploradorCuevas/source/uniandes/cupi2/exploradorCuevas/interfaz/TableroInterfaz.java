package uniandes.cupi2.exploradorCuevas.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import uniandes.cupi2.exploradorCuevas.mundo.Casilla;







@SuppressWarnings("serial")
/**
 * Este es el panel donde se muestra el tablero del juego de damas
 */
public class TableroInterfaz extends JPanel
{
	//-----------------------------------------------------------------
	// Constantes
	//-----------------------------------------------------------------

	/**
	 * Constantes de las imagenes que se añadiran a cada casilla
	 */
	public static final ImageIcon CASILLA_NADA = new ImageIcon("./data/imagenes/casilla_vacia.png");
	public static final ImageIcon CASILLA_ILUMINADA    = new ImageIcon("./data/imagenes/casilla_iluminada.png");
	public static final ImageIcon CASILLA_JUGADOR  = new ImageIcon("./data/imagenes/jugador.gif");
	public static final ImageIcon CASILLA_OBSTACULO   = new ImageIcon("./data/imagenes/obstaculo.png");
	public static final ImageIcon CASILLA_TESORO    = new ImageIcon("./data/imagenes/tesoro.gif");
	public static final ImageIcon CASILLA_JUGADOR_QUEMADO    = new ImageIcon("./data/imagenes/jugador_quemado.png");


	//-----------------------------------------------------------------
	// Atributos
	//-----------------------------------------------------------------

	/**
	 * Es una referencia a la clase principal de la interfaz
	 */
	private InterfazPrincipal principal;

	/**
	 * Tamaño del tablero que se cargará.
	 */
	private int tamano;

	//-----------------------------------------------------------------
	// Atributos de la Interfaz
	//-----------------------------------------------------------------
	/**
	 * Es una matriz de las casillas que se agregarán al tablero
	 */
	private JLabel[][] casillasTablero;



	/**
	 * Es el panel donde se muestra el tablero
	 */
	private JPanel panelTablero;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Construye el panel sin ningún juego cargado
	 * @param nuevaInterfaz - Es una referencia a la clase principal de la interfaz - nuevaInterfaz != null
	 */


	public TableroInterfaz (InterfazPrincipal nuevaInterfaz) 
	{

		principal = nuevaInterfaz;		
		panelTablero = new JPanel();
		add(panelTablero);


	}


	//-----------------------------------------------------------------
	// Métodos
	//-----------------------------------------------------------------

	/**
	 * Inicializa la visualización del tablero de juego.
	 * @param estadoInicial matriz de números que indican las casillas que se cargarán. estadoInicial != null.
	 */
	public void iniciarTabla(String [][] estadoInicial)
	{
		panelTablero.removeAll();
		tamano = estadoInicial.length;
		panelTablero.setLayout(new GridLayout (tamano, tamano));

		casillasTablero = new JLabel[tamano][tamano];
		int[] posJugador = new int[2];
		// Crear las etiquetas de los marcadores
		for( int i = 0; i < estadoInicial.length; i++ )
		{
			for( int j = 0; j < estadoInicial[i].length; j++ )
			{

				String estadoCasillaActual = estadoInicial[i][j];
				JLabel casillaActual = new JLabel();

				if ((estadoCasillaActual.equals(Casilla.NADA) || estadoCasillaActual.equals(Casilla.BOMBA)) && !esVecinoConJugador(i,j))
				{
					casillaActual.setIcon(CASILLA_NADA);

				}
				else if (estadoCasillaActual.equals(Casilla.JUGADOR))
				{
					casillaActual.setIcon(CASILLA_JUGADOR);
					posJugador[0] = i;
					posJugador[1] = j;
				}
				else if (estadoCasillaActual.equals(Casilla.OBSTACULO))
				{
					casillaActual.setIcon(CASILLA_OBSTACULO);
				}
				else if (estadoCasillaActual.equals(Casilla.TESORO))
				{
					casillaActual.setIcon(CASILLA_TESORO);
				}
				else{
					casillaActual = new JLabel(CASILLA_ILUMINADA);
					casillaActual.setText(principal.getBombasCercanas(i,j));
					casillaActual.setHorizontalTextPosition(JLabel.CENTER);
					casillaActual.setVerticalTextPosition(JLabel.CENTER);
					casillaActual.setForeground(Color.CYAN);
				}
				casillasTablero[i][j] = casillaActual;
				panelTablero.add(casillasTablero[i][j]);
			}
		}
		principal.actualizarCaracteristicas();
		panelTablero.revalidate();
		panelTablero.repaint();


	}
	
	public boolean esVecinoConJugador(int i, int j){
		if(i<= principal.getFilaJugador()+1 && i >= principal.getFilaJugador() -1 && j <= principal.getColumnaJugador() + 1
				&& j >= principal.getColumnaJugador() - 1){
			return true;
		}
		return false;
	}
	

	/**
	 * Actualiza la información mostrada en el tablero de damas.
	 */
	public void actualizar (String[][] estadoActual)
	{

		for (int i = 0; i < estadoActual.length; i++)
		{
			for(int j = 0; j < estadoActual[i].length; j++)
			{
				String estadoCasillaActual = estadoActual[i][j];
				if ((estadoCasillaActual.equals(Casilla.NADA) || estadoCasillaActual.equals(Casilla.BOMBA)) && !esVecinoConJugador(i,j))
				{
					casillasTablero[i][j].setIcon(CASILLA_NADA);
					casillasTablero[i][j].setText("");
				}
				else if (estadoCasillaActual.equals(Casilla.JUGADOR))
				{
					casillasTablero[i][j].setIcon(CASILLA_JUGADOR);
					casillasTablero[i][j].setText("");
				}
				else if (estadoCasillaActual.equals(Casilla.OBSTACULO))
				{
					casillasTablero[i][j].setIcon(CASILLA_OBSTACULO);
				}
				else if (estadoCasillaActual.equals(Casilla.TESORO))
				{
					casillasTablero[i][j].setIcon(CASILLA_TESORO);
					
				}
				else{
					casillasTablero[i][j].setIcon(CASILLA_ILUMINADA);
					casillasTablero[i][j].setText(principal.getBombasCercanas(i,j));
					casillasTablero[i][j].setHorizontalTextPosition ( JLabel.CENTER );
					casillasTablero[i][j].setForeground(Color.CYAN);

				}
			}

		}

	}
	public void quemarJugador(){
		casillasTablero[principal.getFilaJugador()][principal.getColumnaJugador()].setIcon(CASILLA_JUGADOR_QUEMADO);
	}

}	














