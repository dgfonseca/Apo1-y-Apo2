package uniandes.cupi2.sintetizador.interfaz;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelTeclado extends JPanel implements ActionListener {


	/**
	 * se crea un atributo para conectar el panel con la interfaz principal
	 */
	private InterfazSintetizador sintetizador;


	/**
	 * Constructor de la clase panel teclado
	 * @param pSintetizador
	 */
	public PanelTeclado(InterfazSintetizador pSintetizador ){
		setLayout(new GridLayout(1, 8));
		sintetizador=pSintetizador;
		//se recorren las notas
		for(int i=0; i<sintetizador.darNotas().length; i++){
			JButton boton= new JButton();
			ImageIcon icon = new ImageIcon(sintetizador.darNotas()[i].darRutaImagen());
			boton.setIcon(icon);
			boton.setActionCommand(sintetizador.darNotas()[i].darNombre());
			boton.addActionListener(this);
			add(boton);



		}

	}


	@Override
	public void actionPerformed(ActionEvent pEvento) {

		String comando=pEvento.getActionCommand();
		sintetizador.reproducir(comando);


	}


}
