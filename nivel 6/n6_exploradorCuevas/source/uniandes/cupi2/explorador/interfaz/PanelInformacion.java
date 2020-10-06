package uniandes.cupi2.explorador.interfaz;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelInformacion extends JPanel 
{
	
	 // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Es la etiqueta donde se muestra el n�mero de minas restantes.
     */
    private JLabel etiquetaMinasActual;
    
    private JLabel filaActual;
    
    private JLabel columnaActual;
    
    private JTextField numMinas;
    
    private JTextField numMinasfilas;
    
    private JTextField numMinasColumna;
    
    
    
    
 // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye e inicializa el panel que sirve para mostrar la informacion sobre las minas.
     */
    public PanelInformacion()
    {
    	setBorder(new TitledBorder("Cantidad Bombas"));
    	setLayout(new GridLayout(4, 2));
    	
    	etiquetaMinasActual = new JLabel("Total");
    	add(etiquetaMinasActual);
    	
    	numMinas = new JTextField("");
    	numMinas.setEditable(false);
    	add(numMinas);
    	
    	filaActual = new JLabel("Fila Actual");
    	add(filaActual);
    	
    	numMinasfilas = new JTextField("");
    	numMinasfilas.setEditable(false);
    	add(numMinasfilas);
    	
    	columnaActual = new JLabel("Columna Actual");
    	add(columnaActual);
    	
    	numMinasColumna = new JTextField("");
    	numMinasColumna.setEditable(false);
    	add(numMinasColumna);
    	
    	
    	
    	
    	
    	
    	
    	
    	
	
    }
    
    
    
    
    public void actualizarBombas(int pBombas){
    	
    	numMinas.setText(""+pBombas);
    	numMinasColumna.setText(""+pBombas);
    	numMinasfilas.setText(""+pBombas);
    	
    }

}
