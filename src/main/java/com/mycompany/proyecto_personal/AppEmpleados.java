package com.mycompany.proyecto_personal;

import controller.EmpleadoController;
import domain.Empleado;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author jmedina
 */
public class AppEmpleados {
    
    public static void crear(EmpleadoController empleadoController){
            
        try {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Digite el tipo de documento");
            String tipo_de_identificacion = sc.nextLine();
            System.out.println("El tipo de documento es: " + tipo_de_identificacion);
            
            System.out.println("Digite el documento de identificacion");
            String identificacion = sc.nextLine();
            System.out.println("El documento es: " + identificacion);
            
            System.out.println("Digite el nombre");
            String nombre = sc.nextLine();
            System.out.println("El nombre es: " + nombre);
            
            System.out.println("Digite el apellido");
            String apellido= sc.nextLine();
            System.out.println("El apellido es: " + apellido);
            
            System.out.println("Digite el estado civil");
            String estado_civil = sc.nextLine();
            System.out.println("El estado_civil es: " + estado_civil);
            
            System.out.println("Digite el sexo");
            String sexo = sc.nextLine();
            System.out.println("El sexo es: " + sexo);
            
            System.out.println("Digite la direccion");
            String direccion = sc.nextLine();
            System.out.println("La direccion es: " + direccion);
            
            System.out.println("Digite el telefono");
            String telefono = sc.nextLine();
            System.out.println("El telefono es: " + telefono);
            
            System.out.println("Digite la fecha de nacimiento");
            String fecha_de_nacimiento = sc.nextLine();
            System.out.println("La fecha_de_nacimiento es: " + fecha_de_nacimiento );
            
            Empleado empleado = new Empleado();
            empleado.setTipo_identificacion(tipo_de_identificacion);
            empleado.setIdentificacion(0);
            empleado.setNombres(nombre);
            empleado.setApellidos(apellido);
            empleado.setEstado_civil(estado_civil);
            empleado.setSexo(sexo);
            empleado.setDireccion(direccion);
            empleado.setTelefono(telefono);
            empleado.setFecha_de_nacimiento(fecha_de_nacimiento);
            empleadoController.crear(empleado);
            System.out.println("Empleado creado con exito ");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            
    }
    
    public static void main (String[] args){
        EmpleadoController empleadoController = new EmpleadoController();
        crear(empleadoController);
    }
    
}
