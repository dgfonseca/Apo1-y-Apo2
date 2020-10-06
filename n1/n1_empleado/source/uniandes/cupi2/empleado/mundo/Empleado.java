/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_empleado
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.empleado.mundo;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Clase que representa un empleado.
 */
public class Empleado
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del empleado.
     */
    private String nombre;

    /**
     * Apellido del empleado.
     */
    private String apellido;

    /**
     * Genero del empleado. <br>
     * 1 indica género masculino. <br>
     * 2 indica género femenino. <br>
     */
    private int genero;

    /**
     * Fecha de nacimiento del empleado.
     */
    private Fecha fechaNacimiento;

    /**
     * Fecha de ingreso del empleado a la compañía.
     */
    private Fecha fechaIngreso;

    /**
     * Ruta de la imagen.
     */
    private String imagen;

    /**
     * Salario del empleado.
     */
    private double salario;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye el empleado. <br>
     * <b>post: </b> Se creó el empleado con los siguientes valores: <br>
     * Nombre: Pedro, Apellido: Matallana, Género: masculino (1), Fecha de nacimiento: 16-6-1982, Fecha de ingreso: 5-4-2000, Imagen: empleado1.png, Salario: 1500000.
     */
    public Empleado( )
    {
        nombre = "Pedro";
        apellido = "Matallana";
        genero = 1;
        fechaNacimiento = new Fecha( 16, 6, 1982 );
        fechaIngreso = new Fecha( 5, 4, 2000 );
        imagen = "empleado1.png";
        salario = 1500000;
    }

    /**
     * Retorna el nombre del empleado.
     * @return Nombre del empleado.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna el genero del empleado.
     * @return Genero del empleado.
     */
    public int darGenero( )
    {
        return genero;
    }

    /**
     * Retorna la fecha de nacimiento del empleado en una cadena.
     * @return Fecha de nacimiento del empleado.
     */
    public String darFechaNacimiento( )
    {
        String strFecha = fechaNacimiento.toString( );
        return strFecha;
    }

    /**
     * Retorna la fecha de ingreso del empleado en una cadena.
     * @return Fecha de ingreso del empleado.
     */
    public String darFechaIngreso( )
    {
        String strFecha = fechaIngreso.toString( );
        return strFecha;
    }

    /**
     * Retorna la ruta de la imagen del empleado.
     * @return Ruta de la imagen.
     */
    public String darImagen( )
    {
        return imagen;
    }

    /**
     * Retorna el salario del empleado.
     * @return Salario del empleado.
     */
    public double darSalario( )
    {
        return salario;
    }

    /**
     * Retorna el apellido del empleado.
     * @return Apellido del empleado.
     */
    public String darApellido( )
    {
        return apellido;
    }

    /**
     * Retorna la edad del empleado en años.
     * @return Edad del empleado en años.
     */
    public int calcularEdad( )
    {
        Fecha hoy = darFechaActual( );

        int edad = fechaNacimiento.darDiferenciaEnMeses( hoy ) / 12;

        return edad;
    }

    /**
     * Retorna la antigüedad del empleado en años.
     * @return Antigüedad del empleado en años.
     */
    public int calcularAntiguedad( )
    {
        Fecha hoy = darFechaActual( );
        int antiguedad = fechaIngreso.darDiferenciaEnMeses( hoy ) / 12;

        return antiguedad;
    }

    /**
     * Retorna las prestaciones del empleado usando la fórmula: p = (a * s)/12 (p: prestaciones, a: antigüedad, s: salario). <br>
     * La antigüedad que se utiliza está dada en años, así que si un empleado lleva menos de un año en la empresa, sus prestaciones serán 0.
     * @return Prestaciones del empleado.
     */
    public double calcularPrestaciones( )
    {
        int antiguedad = calcularAntiguedad( );
        double prestaciones = ( ( double ) ( antiguedad * salario ) ) / 12;
        return prestaciones;
    }

    /**
     * Cambia la información del empleado con los valores dados por parámetro. <br>
     * <b> post: </b> El nombre, apellido, género, fecha de nacimiento, fecha de ingreso, salario e imagen fueron cambiados con los valores dados por parámetro.
     * @param pNombre Nombre del empleado. pNombre != null && pNombre != "".
     * @param pApellido Apellido del empleado. pApellido != null && pApellido != "".
     * @param pGenero Género del empleado. pGenero == 1 || pGenero == 0.
     * @param pFechaNacimiento Fecha de nacimiento del empleado. pFechaNacimiento != null.
     * @param pFechaIngreso Fecha de ingreso del empleado. pFechaIngreso != null.
     * @param pSalario Salario del empleado. pSalario > 0.
     * @param pImagen Imagen del empleado. pImagen != null && pImagen != "".
     */
    public void cambiarEmpleado( String pNombre, String pApellido, int pGenero, Fecha pFechaNacimiento, Fecha pFechaIngreso, int pSalario, String pImagen )
    {
        nombre = pNombre;
        apellido = pApellido;
        genero = pGenero;
        fechaNacimiento = pFechaNacimiento;
        fechaIngreso = pFechaIngreso;
        salario = pSalario;
        imagen = pImagen;
    }

    /**
     * Cambia el salario del empleado con el valor dado por parámetro. <br>
     * <b>post: </b> El salario tiene el valor ingresado por parámetro.
     * @param pSalario Nuevo salario del empleado. pSalario > 0.
     */
    public void cambiarSalario( double pSalario )
    {
        salario = pSalario;
    }

    /**
     * Retorna la fecha actual.
     * @return Fecha actual.
     */
    public Fecha darFechaActual( )
    {
        GregorianCalendar gc = new GregorianCalendar( );

        int dia = gc.get( Calendar.DAY_OF_MONTH );
        int mes = gc.get( Calendar.MONTH ) + 1;
        int anho = gc.get( Calendar.YEAR );
        Fecha hoy = new Fecha( dia, mes, anho );

        return hoy;

    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}