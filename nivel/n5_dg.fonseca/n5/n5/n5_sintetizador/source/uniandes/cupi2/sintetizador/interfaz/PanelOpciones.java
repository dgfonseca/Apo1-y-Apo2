package uniandes.cupi2.sintetizador.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener 
{

	/**
	 * Se crean las constantes buscar, calificado y contar efectos
	 */
	private static final String BUSCAR="Buscar por nombre";
	private static final String CALIFICADO="Buscar mejor calificado";
	private static final String CONTAR_EFECTOS="Contar efectos por grupo";


	/**
	 * Se crea un atributo de tipo boton para el nombre
	 */
	private JButton buscarNombre;
	/**
	 * Se crea un atributo de tipo boton para el calificado
	 */
	private JButton buscarCalificado;
	/**
	 * Se crea un atributo de tipo boton para el efecto
	 */
	private JButton contarEfectos;
	/**
	 * Se crea un atributo de tipo boton para la opcion1
	 */
	private JButton opcion1;
	/**
	 * Se crea un atributo de tipo boton para la opcion2
	 */
	private JButton opcion2;
	/**
	 * Se crea un atributo para conectar el panel con la interfaz principal
	 */
	private InterfazSintetizador sintetizador;


	//constructor
	/**
	 * Constructor de la clase panel opciones
	 * @param pSintetizador
	 */
	public PanelOpciones(InterfazSintetizador pSintetizador) {


		sintetizador=pSintetizador;
		//layout
		JPanel panelinferior=new JPanel();
		panelinferior.setLayout(new GridLayout(1, 5));
		setBorder(new TitledBorder("Opciones"));
		//boton buscar nombre
		buscarNombre=new JButton(BUSCAR);
		buscarNombre.setActionCommand(BUSCAR);
		buscarNombre.addActionListener(this);

		//boton buscar calificado
		buscarCalificado=new JButton(CALIFICADO);
		buscarCalificado.addActionListener(this);
		buscarCalificado.setActionCommand(CALIFICADO);
		//boton contar efectos
		contarEfectos=new JButton(CONTAR_EFECTOS);
		contarEfectos.addActionListener(this);
		contarEfectos.setActionCommand(CONTAR_EFECTOS);
		//boton opcion1 y opcion2
		opcion1=new JButton("Opcion1");
		opcion1.addActionListener(this);
		opcion1.setActionCommand("Opcion1");
		opcion2 = new JButton("Opcion2");
		opcion2.addActionListener(this);
		opcion2.setActionCommand("Opcion2");


		add(panelinferior);
		panelinferior.add((buscarNombre));
		panelinferior.add((buscarCalificado));
		panelinferior.add((contarEfectos));
		panelinferior.add((opcion1));
		panelinferior.add((opcion2));




	}


	@Override
	public void actionPerformed(ActionEvent pEvento) {
		// TODO Auto-generated method stub
		String comando= pEvento.getActionCommand();
		if(comando.equals(BUSCAR)){
			sintetizador.buscarEfecto();
		}
		else if(comando.equals(CALIFICADO)){
			sintetizador.buscarCalificado();


		}


		// botones de opciones
		else if( comando.equals("Opcion1" ) )
		{
			sintetizador.reqFuncOpcion1( );
		}
		else if( comando.equals( "Opcion2" ) )
		{
			sintetizador.reqFuncOpcion2( );
		}
	}



}
