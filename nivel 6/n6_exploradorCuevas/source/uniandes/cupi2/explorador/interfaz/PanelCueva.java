package uniandes.cupi2.explorador.interfaz;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.cupi2.explorador.mundo.Casilla;

import uniandes.cupi2.explorador.mundo.ExploradorCuevas;
import uniandes.cupi2.explorador.mundo.ExploradorCuevas.EstadoJuego;



@SuppressWarnings("serial")
public class PanelCueva extends JPanel  {


	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	public static final ImageIcon CASILLA_NADA = new ImageIcon("./data/imagenes/casilla_vacia.png");
	public static final ImageIcon CASILLA_ILUMINADA = new ImageIcon("./data/imagenes/casilla_iluminada.png");
	public static final ImageIcon CASILLA_JUGADOR = new ImageIcon("./data/imagenes/jugador.gif");
	public static final ImageIcon CASILLA_OBSTACULO = new ImageIcon("./data/imagenes/obstaculo.png");
	public static final ImageIcon CASILLA_TESORO = new ImageIcon("./data/imagenes/tesoro.gif");
	public static final ImageIcon CASILLA_BOMBA = new ImageIcon("./data/imagenes/jugador_quemado.png");
	// -----------------------------------------------------------------

	/**
	 * Es una referencia a la clase principal de la interfaz.
	 */
	private InterfazExplorador principal;


	// Atributos de Interfaz
	// -----------------------------------------------------------------

	/**
	 * Botones de las casillas.
	 */
	private JLabel[][] imagenesCasillas;

	/**
	 * Ancho de la visualizaci�n actual.
	 */
	private int tama�o;



	private JPanel panelCueva;


	/**
	 * Construye el panel como una grilla del tama�o de la cueva.
	 * @param pPrincipal Referencia a la ventana principal. pPrincipal != null.
	 * @param pColumnas n�mero de columnas del panel.
	 * @param pFilas n�mero de filas del panel.
	 */
	public PanelCueva( InterfazExplorador pPrincipal)
	{
		principal = pPrincipal;
		panelCueva=new JPanel();
		add(panelCueva);

	}

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------

	/**
	 * Inicializa la matriz de imagenes.
	 */
	public void inicializar( String[][] estadoDesdeInicio )
	{
		panelCueva.removeAll();
		tama�o= estadoDesdeInicio.length;
		panelCueva.setLayout(new GridLayout(tama�o, tama�o));
		int[] posJugador = new int[2];
		imagenesCasillas = new JLabel[tama�o][tama�o];
		
		for(int i = 0; i<estadoDesdeInicio.length;i++){
			for(int j=0; j<estadoDesdeInicio[i].length; j++){
				String estadoActualCasilla = estadoDesdeInicio[i][j];
				JLabel casillaActual= new JLabel();
				if((estadoActualCasilla.equals(Casilla.NADA)|| estadoActualCasilla.equals(Casilla.BOMBA))&&!vecinoConJugador(i,j)){
					casillaActual.setIcon(CASILLA_NADA);
				}
				else if( estadoActualCasilla.equals(Casilla.JUGADOR)){
					casillaActual.setIcon(CASILLA_JUGADOR);
					posJugador[0]=i;
					posJugador[1]=j;


				}
				else if(estadoActualCasilla.equals(Casilla.TESORO)){
					casillaActual.setIcon(CASILLA_TESORO);
				}
				else{
					casillaActual = new JLabel(CASILLA_ILUMINADA);
					casillaActual.setText(principal.darBombasCercanas(i,j));
					casillaActual.setHorizontalAlignment(JLabel.CENTER);
				}
				imagenesCasillas[i][j] = casillaActual;
				panelCueva.add(imagenesCasillas[i][j]);

			}
		}
       panelCueva.revalidate();
       panelCueva.repaint();

	}
	
	
	public boolean vecinoConJugador(int i, int j){
		if(i<= principal.darFilaJugador()+1 && i>= principal.darFilaJugador()-1 && j<=principal.darColumnaJugador()+1 && j>=principal.darColumnaJugador()-1){
			return true;
		}
		else{
			return false;
		}
		
		
		
		
		
	}
	/**
	 * Actualiza la visualizaci�n de la cueva.
	 * @param pExplorador El la cueva a mostrar..
	 */
	public void actualizar(String[][] estadoActual )
	{
		for(int i = 0; i<estadoActual.length; i++ ){
			for(int j= 0;j<estadoActual[i].length; j++){
				String estadoCasillaActual = estadoActual[i][j];
				if((estadoCasillaActual.equals(Casilla.NADA)   || estadoCasillaActual.equals(Casilla.BOMBA))&& !vecinoConJugador(i, j)){
				imagenesCasillas[i][j].setIcon(CASILLA_NADA);
				imagenesCasillas[i][j].setText("");
			}
			else if(estadoCasillaActual.equals(Casilla.JUGADOR) ){
				imagenesCasillas[i][j].setIcon(CASILLA_JUGADOR);
				imagenesCasillas[i][j].setText("");
			}
			else if( estadoCasillaActual.equals(Casilla.OBSTACULO)){
				imagenesCasillas[i][j].setIcon(CASILLA_OBSTACULO);
			}
			else if(estadoCasillaActual.equals(Casilla.TESORO)){
				imagenesCasillas[i][j].setIcon(CASILLA_TESORO);
			}
			else{
				imagenesCasillas[i][j].setIcon(CASILLA_ILUMINADA);
				imagenesCasillas[i][j].setText(principal.darBombasCercanas(i,j));
				imagenesCasillas[i][j].setHorizontalTextPosition ( JLabel.CENTER );
				imagenesCasillas[i][j].setForeground(Color.CYAN);
			}
		}
		

		}
	}
	public void jugadorPerdioBomba(){
		
		imagenesCasillas[principal.darFilaJugador()][principal.darColumnaJugador()].setIcon(CASILLA_BOMBA);
		
	}
}