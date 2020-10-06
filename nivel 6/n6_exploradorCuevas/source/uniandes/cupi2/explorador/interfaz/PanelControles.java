package uniandes.cupi2.explorador.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelControles extends JPanel implements ActionListener {





	private InterfazExplorador principal;




	public PanelControles(InterfazExplorador pPrincipal){

		principal=pPrincipal;
		setLayout(new GridLayout(3, 3));



		for(int i = 0; i < 9; i ++){
			JButton boton = new JButton();
			if(i != 4){

				boton.setIcon(new ImageIcon("./data/imagenes/direccion-"+ i + ".png"));
				boton.setActionCommand(Integer.toString(i));
				boton.addActionListener(this);
				add(boton);
			}
			else{
				add(new JLabel(""));
			}

		}


	}




	public void actionPerformed(ActionEvent pEvent){



		String comando = pEvent.getActionCommand();
		try {
			principal.moverJugador(Integer.parseInt(comando));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}







	}








}