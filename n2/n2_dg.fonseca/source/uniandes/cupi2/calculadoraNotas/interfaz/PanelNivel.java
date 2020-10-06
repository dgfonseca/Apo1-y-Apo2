/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Proyecto	Cupi2	(http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_calculadoraNotas
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.calculadoraNotas.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.calculadoraNotas.mundo.Nivel;
import uniandes.cupi2.calculadoraNotas.mundo.Nivel.Tipo;

/**
 * Contiene los campos de texto y la definitiva correspondientes a un nivel.
 */
@SuppressWarnings("serial")
public class PanelNivel extends JPanel
{

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Campo de texto que permite modificar, ver y actualizar la nota actual del ejercicio.
     */
    private JTextField txtNotaEjercicio;

    /**
     * Campo de texto que permite modificar, ver y actualizar la nota actual del examen práctico.
     */
    private JTextField txtNotaPractico;

    /**
     * Campo de texto que permite modificar, ver y actualizar la nota actual del examen teórico.
     */
    private JTextField txtNotaTeorico;

    /**
     * Etiqueta que permite ver el porcentaje del ejercicio.
     */
    private JLabel lblEjercicio;

    /**
     * Etiqueta que permite ver el porcentaje del examen práctico.
     */
    private JLabel lblPractico;

    /**
     * Etiqueta que permite el porcentaje del examen teórico.
     */
    private JLabel lblTeorico;

    /**
     * Etiqueta que permite ver la nota definitiva del nivel.
     */
    private JLabel lblNota;

    /**
     * Etiqueta que presenta la descripción del nivel.
     */
    private JLabel lblDescripcion;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazCalculadoraNotas principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con los campos de texto y la etiqueta. <br>
     * <b>post:</b> Todos los componentes de tipo JLabel y JTextField fueron inicializados.
     * @param pNivel Nivel correspondiente con la información de las notas. pNivel != null
     * @param pColor Color que representa el nivel. pColor != null
     * @param pPrincipal Ventana principal de la aplicación
     */
    public PanelNivel( Nivel pNivel, Color pColor, InterfazCalculadoraNotas pPrincipal )
    {
        principal = pPrincipal;
        NumberFormat formato = new DecimalFormat( "#0.0" );
        NumberFormat formatoSinDecimal = new DecimalFormat( "#0" );

        String tipo = "Gráfico";

        if( pNivel.darTipo( ) == Tipo.ALGORITMICO )
        {
            tipo = "Algorítmico";
        }
        else if( pNivel.darTipo( ) == Tipo.ESTRUCTURAL )
        {
            tipo = "Estructural";
        }

        TitledBorder b = BorderFactory.createTitledBorder( "Nivel " + pNivel.darNumero( ) + " (" + tipo + ")" );
        CompoundBorder brdCompound = BorderFactory.createCompoundBorder( b, new EmptyBorder( 10, 10, 10, 10 ) );
        setBorder( brdCompound );

        setLayout( new BorderLayout( ) );

        JPanel panelCentral = new JPanel( new GridLayout( 4, 2 ) );

        lblEjercicio = new JLabel( "Ejercicio (" + formatoSinDecimal.format( pNivel.darPorcentajeEjercicio( ) * 100 ) + "%)" );
        lblEjercicio.setHorizontalAlignment( JLabel.CENTER );
        panelCentral.add( lblEjercicio );

        txtNotaEjercicio = new JTextField( );
        txtNotaEjercicio.setHorizontalAlignment( SwingConstants.CENTER );
        txtNotaEjercicio.setBackground( pColor );
        txtNotaEjercicio.setText( formato.format( pNivel.darNotaEjercicio( ) ) + "" );
        panelCentral.add( txtNotaEjercicio );

        lblPractico = new JLabel( "Práctico (" + formatoSinDecimal.format( pNivel.darPorcentajePractico( ) * 100 ) + "%)" );
        lblPractico.setHorizontalAlignment( JLabel.CENTER );
        panelCentral.add( lblPractico );

        txtNotaPractico = new JTextField( );
        txtNotaPractico.setHorizontalAlignment( JTextField.CENTER );
        txtNotaPractico.setBackground( pColor );
        txtNotaPractico.setText( formato.format( pNivel.darNotaPractico( ) ) + "" );
        panelCentral.add( txtNotaPractico );

        lblTeorico = new JLabel( "Teórico (" + formatoSinDecimal.format( pNivel.darPorcentajeTeorico( ) * 100 ) + "%)" );
        lblTeorico.setHorizontalAlignment( JLabel.CENTER );
        panelCentral.add( lblTeorico );

        txtNotaTeorico = new JTextField( );
        txtNotaTeorico.setHorizontalAlignment( JTextField.CENTER );
        txtNotaTeorico.setBackground( pColor );
        txtNotaTeorico.setText( formato.format( pNivel.darNotaTeorico( ) ) + "" );
        panelCentral.add( txtNotaTeorico );

        JLabel notaNivel = new JLabel( "Nivel" );
        notaNivel.setHorizontalAlignment( JLabel.CENTER );
        panelCentral.add( notaNivel );

        lblNota = new JLabel( formato.format( pNivel.calcularNotaSobreCinco( ) ) + "" );
        lblNota.setHorizontalAlignment( JLabel.CENTER );
        panelCentral.add( lblNota );

        add( panelCentral, BorderLayout.SOUTH );

        lblDescripcion = new JLabel( "<html>" + pNivel.darTema( ) + "</html>" );
        add( lblDescripcion, BorderLayout.NORTH );

        add( new JLabel( " " ), BorderLayout.CENTER );

        try
        {
            actualizarNotas( pNivel );
        }
        catch( Exception e )
        {
            // No debe entrar a la excepción si es correctamente inicializado desde el mundo.
        }

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Permite leer las notas que los usuarios ingresaron y enviarlas al mundo. <br>
     * <b>post:</b> Las notas fueron actualizadas.
     * @param pNivel Nivel correspondiente al panel
     * @throws Exception Si el usuario introdujo un valor no numérico, si dejo alguno de los campos de texto vacíos o si la nota introducida en algún campo no se encuentra
     *         entre 0 y 5.
     */
    public void actualizarNotas( Nivel pNivel ) throws Exception
    {
        DecimalFormat formatoSinDecimal = new DecimalFormat( "#0" );
        String mensaje = "Las notas deben estar en el rango entre 0 y 5";
        double notaEjercicio;
        double notaPractico;
        double notaTeorico;
        DecimalFormat formato = new DecimalFormat( "#0.0" );

        try
        {
            notaEjercicio = Double.parseDouble( txtNotaEjercicio.getText( ).replaceAll( ",", "." ) );
            if( notaEjercicio < 0 || notaEjercicio > 5 )
            {
                txtNotaEjercicio.setText( formato.format( 0 ) );
                throw new Exception( mensaje );
            }
        }
        catch( NumberFormatException e )
        {
            mensaje = "Nota de ejercicio N" + pNivel.darNumero( ) + " inválida: ";
            if( e.getLocalizedMessage( ).equals( "empty String" ) )
            {
                mensaje += "La casilla se encuentra vacía";
            }
            else if( e.getLocalizedMessage( ).contains( "For input string:" ) )
            {
                mensaje += "Fueron introducidos caracteres no numéricos";
            }

            throw new Exception( mensaje );
        }

        try
        {
            notaPractico = Double.parseDouble( txtNotaPractico.getText( ).replaceAll( ",", "." ) );
            if( notaPractico < 0 || notaPractico > 5 )
            {
                txtNotaPractico.setText( formato.format( 0 ) );
                throw new Exception( mensaje );
            }
        }
        catch( NumberFormatException e )
        {
            mensaje = "Nota de exaem práctico N" + pNivel.darNumero( ) + " inválida: ";
            if( e.getLocalizedMessage( ).equals( "empty String" ) )
            {
                mensaje += "La casilla se encuentra vacía";
            }
            else if( e.getLocalizedMessage( ).contains( "For input string:" ) )
            {
                mensaje += "Fueron introducidos caracteres no numéricos";
            }

            throw new Exception( mensaje );
        }

        try
        {
            notaTeorico = Double.parseDouble( txtNotaTeorico.getText( ).replaceAll( ",", "." ) );
            if( notaTeorico < 0 || notaTeorico > 5 )
            {
                txtNotaTeorico.setText( formato.format( 0 ) );
                throw new Exception( mensaje );
            }
        }
        catch( NumberFormatException e )
        {
            mensaje = "Nota de exaem teórico N" + pNivel.darNumero( ) + " inválida: ";
            if( e.getLocalizedMessage( ).equals( "empty String" ) )
            {
                mensaje += "La casilla se encuentra vacía";
            }
            else if( e.getLocalizedMessage( ).contains( "For input string:" ) )
            {
                mensaje += "Fueron introducidos caracteres no numéricos";
            }

            throw new Exception( mensaje );
        }

        principal.cambiarNotaEjercicio( pNivel.darNumero( ), notaEjercicio );
        principal.cambiarNotaPractico( pNivel.darNumero( ), notaPractico );
        principal.cambiarNotaTeorico( pNivel.darNumero( ), notaTeorico );
        lblNota.setText( formato.format( pNivel.calcularNotaSobreCinco( ) ) + "" );
        lblEjercicio.setText( "Ejercicio (" + formatoSinDecimal.format( pNivel.darPorcentajeEjercicio( ) * 100 ) + "%)" );
        lblPractico.setText( "Práctico (" + formatoSinDecimal.format( pNivel.darPorcentajePractico( ) * 100 ) + "%)" );
        lblTeorico.setText( "Teórico (" + formatoSinDecimal.format( pNivel.darPorcentajeTeorico( ) * 100 ) + "%)" );

        if( pNivel.estaAnulado( ) )
        {
            ImageIcon imageIcon = new ImageIcon( new ImageIcon( "data/img/alerta.gif" ).getImage( ).getScaledInstance( 30, 30, Image.SCALE_DEFAULT ) );
            lblDescripcion.setIcon( imageIcon );
            lblDescripcion.setToolTipText( "Ejercicio anulado" );
        }
        else
        {
            lblDescripcion.setIcon( null );
            lblDescripcion.setToolTipText( null );
        }

        if( pNivel.apruebaNivel( ) )
        {
            lblNota.setForeground( Color.BLACK );
            lblNota.setToolTipText( null );
        }
        else
        {
            lblNota.setForeground( Color.RED );
            lblNota.setToolTipText( "Pierde nivel " + pNivel.darNumero( ) );
        }

    }

}
