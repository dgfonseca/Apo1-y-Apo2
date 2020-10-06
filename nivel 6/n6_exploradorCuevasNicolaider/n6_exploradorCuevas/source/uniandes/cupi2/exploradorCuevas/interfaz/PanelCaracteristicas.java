package uniandes.cupi2.exploradorCuevas.interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PanelCaracteristicas extends JPanel implements ActionListener {

	 //-----------------------------------------------------------------
   // Constantes
   //-----------------------------------------------------------------
	
	/**
	 * Constantes de los botones de movimiento
	 */
	public static final int ARRIBAIZQ   = 0;
	public static final int ARRIBA = 1;
	public static final int ARRIBADER  = 2;
	public static final int IZQUIERDA = 3;
	public static final int DERECHA    = 5;
	public static final int ABAJOIZQ    = 6;
	public static final int ABAJO    = 7;
	public static final int ABAJODER    = 8;
	
	//-----------------------------------------------------------------
   // Atributos
   //-----------------------------------------------------------------

   /**
    * Es una referencia a la clase principal de la interfaz
    */
	private InterfazPrincipal principal;
	
	/**
    * Número de filas del tablero que se cargará.
    */
	private int filas;
	/**
	* Número de columnas del tablero que se cargará.
	*/
	private int columnas;
	
	 //-----------------------------------------------------------------
   // Atributos de la Interfaz
   //-----------------------------------------------------------------
	/**
    * Es una matriz de los botones que se agregarán al tablero
    */
	private JButton[][] botonesTablero;
	/**
	    * Es un label con el numero de movimientos restantes
	    */
	private JLabel movimientos;
	
	/**
	    * Es un textField con el total de bombas
	    */
	private JLabel total;
	
	/**
	    * Es un textField con las bombas en la fila actual
	    */
	private JLabel bombasFila;
	
	/**
	    * Es un textField con las bombas en la columna actual
	    */
	private JLabel bombasColumna;
	
	/**
	    * Es el panel de los controles.
	    */
	private JPanel panelControles;
	
	/**
	    * Es el sub-panel de los controles.
	    */
	private JPanel subPanelControles;
	
	 // -----------------------------------------------------------------
   // Constructores
   // -----------------------------------------------------------------

   /**
    * Construye el panel sin ningún juego cargado
    * @param nuevaInterfaz - Es una referencia a la clase principal de la interfaz - nuevaInterfaz != null
    */
	
	
	public PanelCaracteristicas (InterfazPrincipal interfaz) 
	{
		
		principal = interfaz;
		setLayout (new BorderLayout ());
		JPanel panelMovimientos = new JPanel();
		panelMovimientos.setBorder(new TitledBorder("Movimientos Restantes"));
		movimientos = new JLabel("--");
		movimientos.setFont(new Font("Arial",Font.BOLD,40));
		panelMovimientos.add(movimientos);
		
		panelControles = new JPanel();
		Border border = new TitledBorder("Controles");
		Border margin = BorderFactory.createEmptyBorder(50,0,50, 0);
		panelControles.setBorder(BorderFactory.createCompoundBorder(border,margin));

		subPanelControles = new JPanel();

		subPanelControles.setLayout(new GridLayout(3,3,4,4));
		for(int i = 0; i < 9; i ++){
			JButton boton = new JButton();
			if(i != 4){
			boton.setPreferredSize(new Dimension(60,60));
			boton.setIcon(new ImageIcon("./data/imagenes/direccion-"+ i + ".png"));
			boton.setEnabled(false);
			subPanelControles.add(boton);
			}
			else{
				subPanelControles.add(new JLabel(""));
			}
		}
		panelControles.add(subPanelControles);
		
		
		JPanel panelCaracteristicas = new JPanel();
		panelCaracteristicas.setBorder(new TitledBorder("Cantidad bombas"));
		panelCaracteristicas.setPreferredSize(new Dimension(50,150));
		panelCaracteristicas.setLayout(new GridLayout(3,2));
		JLabel totalLabel = new JLabel("Total");
		JLabel filaLabel = new JLabel("Fila actual:");
		JLabel columnaLabel = new JLabel("Columna actual:");

		total = new JLabel();
		bombasFila = new JLabel();
		bombasColumna = new JLabel();
		total.setBorder(BorderFactory.createTitledBorder(""));
		bombasFila.setBorder(BorderFactory.createTitledBorder(""));
		bombasColumna.setBorder(BorderFactory.createTitledBorder(""));
		panelCaracteristicas.add(totalLabel);
		panelCaracteristicas.add(total);
		
		panelCaracteristicas.add(filaLabel);
		panelCaracteristicas.add(bombasFila);
		
		panelCaracteristicas.add(columnaLabel);
		panelCaracteristicas.add(bombasColumna);

		add(panelMovimientos, BorderLayout.NORTH);
		add(panelControles,BorderLayout.CENTER);
		add(panelCaracteristicas, BorderLayout.SOUTH);
		
		
	}

	
	//-----------------------------------------------------------------
   // Métodos
   //-----------------------------------------------------------------

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		principal.moverJugador(Integer.parseInt(comando));
		
	}


	public int getColumnas() {
		return columnas;
	}


	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	public void actualizarCaracteristicas(){
		actualizar();
		subPanelControles.removeAll();
		panelControles.removeAll();
		for(int i = 0; i < 9; i ++){
			JButton boton = new JButton();
			if(i != 4){
				boton.setPreferredSize(new Dimension(60,60));
				boton.setIcon(new ImageIcon("./data/imagenes/direccion-"+ i + ".png"));
				boton.setActionCommand(Integer.toString(i));
				boton.addActionListener(this);
				subPanelControles.add(boton);
			}
			else{
				subPanelControles.add(new JLabel(""));
			}
		}
		panelControles.add(subPanelControles);
	}
	public void actualizar() {
		movimientos.setText(Integer.toString(principal.getMovimientos()));
		total.setText(principal.getTotalBombas());
		bombasFila.setText(principal.getBombasFilaActual());
		bombasColumna.setText(principal.getBombasColumnaActual());
		
	}

	
}
