package uniandes.cupi2.sintetizador.interfaz;

import java.awt.event.ActionEvent;








import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.cupi2.sintetizador.mundo.Efecto;

@SuppressWarnings("serial")
public class PanelSuperior  extends JPanel implements ActionListener {



	/**
	 * Se crean las constantes la barra superior
	 */
	private static final String PIANOS ="./data/banners/sintetizador-0.png";
	/**
	 * Se crea un atributo que conecte el panel con la interfaz principal
	 */
	private InterfazSintetizador sintetizador;
	/**
	 * se un atributo de tipo label
	 */
	private JLabel etiquetaImagen;



	/**
	 * Constructor de la clase panel superior
	 * @param pSintetizador
	 */
	public PanelSuperior (InterfazSintetizador pSintetizador){
		sintetizador=pSintetizador;
		//label de la imagen
		etiquetaImagen=new JLabel();
		etiquetaImagen.setIcon(new ImageIcon(PIANOS));
		add(etiquetaImagen);



	}	


	/**
	 * Se actualiza el panel superior cambiandolo dependiendo de la accion
	 * @param efectoActual
	 */
	public void actualizar(Efecto efectoActual){

		etiquetaImagen.setIcon(new ImageIcon(efectoActual.darRutaImagen()));


	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}





















}





