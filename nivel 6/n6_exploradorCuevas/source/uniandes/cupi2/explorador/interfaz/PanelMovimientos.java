package uniandes.cupi2.explorador.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanelMovimientos extends JPanel {
	
	

	    // -----------------------------------------------------------------
	    // Atributos de Interfaz
	    // -----------------------------------------------------------------

	    /**
	     * Es la etiqueta donde se muestra el n�mero de minas restantes.
	     */
	    private JLabel etiquetaMovimientos;


	    // -----------------------------------------------------------------
	    // Constructores
	    // -----------------------------------------------------------------

	    /**
	     * Construye e inicializa el panel que sirve para mostrar la barra de estado.
	     */
	    public PanelMovimientos( )
	    {
	    	
	        setBorder(new TitledBorder("Movimientos Restantes"));
            setLayout(new BorderLayout());
	        Font fuente = new Font( "Tahoma", Font.BOLD, 14 );

	        etiquetaMovimientos = new JLabel( "Quedan: " );
	        etiquetaMovimientos.setFont( fuente );
	        etiquetaMovimientos.setBorder( new CompoundBorder( new EmptyBorder( 2, 2, 2, 2 ), new LineBorder( Color.GRAY ) ) );
	        add( etiquetaMovimientos, BorderLayout.CENTER );

	 
	    }

	    // -----------------------------------------------------------------
	    // M�todos
	    // -----------------------------------------------------------------

	    /**
	     * Actualiza el n�mero de minas restantes.
	     * @param pMinas El n�mero de minas restantes que deben mostrarse.
	     */
	   	public void actualizarMovimientos(int pMovimientos) {
		
		etiquetaMovimientos.setText( "Quedan " + pMovimientos + " Movimientos" );
	}
}	   	
