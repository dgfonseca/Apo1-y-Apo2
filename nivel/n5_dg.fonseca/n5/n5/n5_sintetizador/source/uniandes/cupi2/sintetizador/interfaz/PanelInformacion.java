package uniandes.cupi2.sintetizador.interfaz;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelInformacion extends JPanel implements ActionListener {


	/**
	 * Se crea un atributo que conecta el panel con la interfaz principal
	 */
	private InterfazSintetizador sintetizador;
	/**
	 * Se crea una atributo de tipo label
	 */
	private JLabel descripcion;
	/**
	 * Se crea un campo de texto para los sonidos
	 */
	private JTextField sonidos;
	/**
	 * se crea un campo de texto para los puntajes
	 */
	private JTextField puntajes;
	/**
	 * Se crea una atributo de tipo label
	 */
	private JLabel calificacion;
	/**
	 * se crea un atributo de tipo boton
	 */
	private JButton guardar;
	/**
	 * se cre un atributo de tipo checkbox
	 */
	private JCheckBox favoritos;
	/**
	 * se cre un atributo de tipo checkbox
	 */
	private JCheckBox fantasia;
	/**
	 * se cre un atributo de tipo checkbox
	 */
	private JCheckBox divertidos;
	/**
	 * se cre un atributo de tipo checkbox
	 */


	/**
	 * Es el contructor de la clase panel informacion
	 * @param pSintetizador
	 */
	public PanelInformacion(InterfazSintetizador pSintetizador){

		sintetizador=pSintetizador;
		//layout
		setLayout(new GridLayout(2,1));
		JPanel panelArriba = new JPanel();
		panelArriba.setLayout(new GridLayout(4,1));
		setPreferredSize( new Dimension( 200, 200) );


		//label descripcion
		descripcion=new JLabel("Descripcion");
		panelArriba.add(descripcion);
		//text field sonidos
		sonidos=new JTextField("");
		sonidos.setEditable(false);
		panelArriba.add(sonidos);
		//label de calificacion
		calificacion=new JLabel("Calificacion");
		panelArriba.add(calificacion);
		//text field puntajes
		puntajes=new JTextField("");
		puntajes.setEditable(false);
		panelArriba.add(puntajes);

		add(panelArriba);
		//layout
		JPanel panelAbajo=new JPanel();
		panelAbajo.setLayout(new GridLayout(4,1));
		panelAbajo.setBorder(new TitledBorder("Grupos a los que pertenece"));
		panelAbajo.setSize(200,200);
		//check box favoritos
		favoritos=new JCheckBox("Favoritos");
		panelAbajo.add(favoritos);
		//checkbox favoritos
		fantasia=new JCheckBox("Fantasia");
		panelAbajo.add(fantasia);
		//checkbox favoritos
		divertidos=new JCheckBox("Divertidos");
		panelAbajo.add(divertidos);

		// boton de guardar
		guardar=new JButton("guardar");
		panelAbajo.add(guardar);



		add(panelAbajo);







	}

	/**
	 * Se actualiza el panel de la interfaz con los parametros dados
	 * @param pDescripcion
	 * @param pCalificacion
	 */

	public void actualizar(String pDescripcion, String pCalificacion){
		sonidos.setText(pDescripcion);
		puntajes.setText(pCalificacion);






	}



	@Override
	public void actionPerformed(ActionEvent pEvento) {

		String comando= pEvento.getActionCommand();


		if(comando.equals("guardar")){
			boolean fav=favoritos.isSelected();
			boolean fant=fantasia.isSelected();
			boolean div=fantasia.isSelected();
			sintetizador.guardar(fav, fant, div);
		}



	}







}
