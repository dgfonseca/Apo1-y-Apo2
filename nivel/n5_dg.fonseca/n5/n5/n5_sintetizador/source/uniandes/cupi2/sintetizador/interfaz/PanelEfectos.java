package uniandes.cupi2.sintetizador.interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


@SuppressWarnings("serial")
public class PanelEfectos extends JPanel implements ActionListener {
	/**
	 * Se crean las constantes de los botones
	 */
	private final static String RUTA1= "./data/botones/anterior.png";
	private final static String RUTA2= "./data/botones/siguiente.png";
	/**
	 * se crea el atributo que conecta la interfaz principal
	 */
	private InterfazSintetizador sintetizador;
	/**
	 * se crea el boton siguiente
	 */
	private JButton btnSiguiente;
	/**
	 * se crea el boton anterior
	 */
	private JButton btnAnterior;

	/**
	 * Es el contructor del panel efectos y se inicializan los atributos
	 * @param pSintetizador
	 */
	public PanelEfectos(InterfazSintetizador pSintetizador){
		sintetizador=pSintetizador;
		setLayout(new GridLayout(2, 1));
		setPreferredSize( new Dimension( 50, 50) );


		//boton anterior
		btnAnterior=new JButton("");
		btnAnterior.addActionListener(this);
		btnAnterior.setIcon(new ImageIcon(RUTA1));
		btnAnterior.setActionCommand("a");
		add(btnAnterior);
		//boton siguiente
		btnSiguiente=new JButton("");
		btnSiguiente.addActionListener(this);
		btnSiguiente.setActionCommand("DOS");
		btnSiguiente.setIcon(new ImageIcon(RUTA2));
		add(btnSiguiente);
	}


	@Override
	/*¨
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent pEvento) {

		String comando=pEvento.getActionCommand();
		if(comando.equals("a")){
			try {
				sintetizador.darAnterior();
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		else if(comando.equals("DOS")){
			try {
				sintetizador.darSiguiente();
			} catch (Exception e) {

				e.printStackTrace();
			}
		}





	}
}
