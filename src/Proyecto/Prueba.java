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
        
        GE.Ingresar(12345678,"Carlos","Ramirez","admin","1234","Administrador");
        GE.Ingresar(87654321,"Lucia","Torres","ltorres","abcd","Recepcionista");
        
        int opcion = 0;
        while(opcion!=5)
        {
            System.out.println("\n===== GESTION DE PERSONAL =====");
            System.out.println("1. Registrar empleado");
            System.out.println("2. Modificar empleado");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Ver empleados");
            System.out.println("5. Salir");
            opcion = sc.nextInt();
            
            if(opcion==1)
            {
                System.out.println("DNI:");
                int dni = sc.nextInt();
                System.out.println("Nombres:");
                String nombres = sc.next();
                System.out.println("Apellidos:");
                String apellidos = sc.next();
                System.out.println("Usuario:");
                String usuario = sc.next();
                System.out.println("Contrasena:");
                String clave = sc.next();
                String rol = ElegirRol(sc);
                System.out.println(GE.Ingresar(dni, nombres, apellidos, usuario, clave, rol));
            }
            else if(opcion==2)
            {
                System.out.println("DNI del empleado a modificar:");
                int dni = sc.nextInt();
                System.out.println("Nuevos nombres:");
                String nombres = sc.next();
                System.out.println("Nuevos apellidos:");
                String apellidos = sc.next();
                System.out.println("Nuevo usuario:");
                String usuario = sc.next();
                System.out.println("Nueva contrasena:");
                String clave = sc.next();
                String rol = ElegirRol(sc);
                System.out.println(GE.Modificar(dni, nombres, apellidos, usuario, clave, rol));
            }
            else if(opcion==3)
            {
                System.out.println("DNI del empleado a eliminar:");
                int dni = sc.nextInt();
                System.out.println(GE.Eliminar(dni));
            }
            else if(opcion==4)
            {
                System.out.println(GE.VerInfo());
            }
        }
    }
}
