/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author ROporto
 */
public class Prueba 
{
     public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        GestionEmpleado GE = new GestionEmpleado();
        
        GE.Ingresar(12345678,"Carlos","Ramirez","cramirez","Usuario1","Administrador");
        GE.Ingresar(87654321,"Lucia","Torres","ltorres","Usuario2","Recepcionista");
        
        int opcion = 0;
        while(opcion!=5)
        {
            System.out.println("\n===== GESTION DE PERSONAL =====");
            System.out.println("1. Ingresar empleado");
            System.out.println("2. Modificar empleado");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Ver empleados");
            System.out.println("5. Salir");
            opcion = sc.nextInt();
            
            if(opcion==1)
            {
                System.out.println("DNI: ");
                int dni = sc.nextInt();
                System.out.println("Nombre: ");
                String nombre = sc.next();
                System.out.println("Apellido: ");
                String apellido = sc.next();
                System.out.println("Usuario: ");
                String usuario = sc.next();
                System.out.println("Contrasena: ");
                String contrasena = sc.next();
                System.out.println("Rol: ");
                String rol = sc.next();
                GE.Ingresar(dni, nombre, apellido, usuario, contrasena, rol);
            }
            else if(opcion==2)
            {
                System.out.println("DNI del empleado a modificar: ");
                int dni = sc.nextInt();
                System.out.println("Nuevo nombre: ");
                String nombre = sc.next();
                System.out.println("Nuevo apellido: ");
                String apellido = sc.next();
                System.out.println("Nuevo usuario: ");
                String usuario = sc.next();
                System.out.println("Nueva contrasena: ");
                String contrasena = sc.next();
                System.out.println("Nuevo rol: ");
                String rol = sc.next();
                GE.Modificar(dni, nombre, apellido, usuario, contrasena, rol);
            }
            else if(opcion==3)
            {
                System.out.println("DNI del empleado a eliminar: ");
                int dni = sc.nextInt();
                GE.Eliminar(dni);
            }
            else if(opcion==4)
            {
                System.out.println(GE.VerInfo());
            }
        }
        System.out.println("Usted salio correctamente");
    }
}
