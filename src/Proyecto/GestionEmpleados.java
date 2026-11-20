/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author ROporto
 */
public class GestionEmpleado 
{
    private Empleado[] arreglo;
    private int conta;

    public GestionEmpleado() 
    {
        arreglo = new Empleado[20];
        conta = 0;
    }

    public Empleado[] getArreglo() {
        return arreglo;
    }

    public int getConta() {
        return conta;
    }
    
    public void Ingresar(Empleado ref)
    {
        boolean repetido=false;
        for(int i=0;i<conta;i++)
        {
            if(arreglo[i].getDni()==ref.getDni())
            {
                repetido=true;
                System.out.println("El DNI ya esta registrado");
            }
            else
            {
                if(arreglo[i].getUsuario().equals(ref.getUsuario()))
                {
                    repetido=true;
                    System.out.println("El usuario ya esta registrado");
                }
                                                
                
            }
        }
        if(repetido==false)
        {
            if(conta<arreglo.length)
            {
                arreglo[conta]=ref;
                conta++;
                System.out.println("Se ingreso correctamente");
            }
            else
            {
                System.out.println("No hay espacio");
            }
        }
        
    }
    
    
    public void Modificar(int dni, String nombre, String apellido, String usuario, String contrasena, String rol)
    {
        int pos=-1;
        boolean repetido=false;
        for(int i=0;i<conta;i++)
        {
            if(arreglo[i].getDni()==dni)
            {
                pos=i;
            }
            else
            {
                if(arreglo[i].getUsuario().equalsIgnoreCase(usuario))
                {
                    repetido=true;
                }
            }
        }

        if(pos==-1)
        {
            System.out.println("No se encontro el DNI a modificar");
        }
        else
        {
            if(repetido)
            {
                System.out.println("Error, ese usuario ya esta en uso");
            }
            else
            {
                arreglo[pos].setNombre(nombre);
                arreglo[pos].setApellido(apellido);
                arreglo[pos].setUsuario(usuario);
                arreglo[pos].setContrasena(contrasena);
                arreglo[pos].setRol(rol);
                System.out.println("Se modifico correctamente");
            }
        }
    }
    
    public void Eliminar(int dni)
    {
        boolean encontro=false;
        for(int i=0;i<conta;i++)
        {
            if(arreglo[i].getDni()==dni)
            {
                encontro=true;
                for(int j=i;j<conta-1;j++)
                {
                    arreglo[j]=arreglo[j+1];
                }
                arreglo[conta-1]=null;
                conta--;
                break;
            }
        }
        if(encontro)
        {
            System.out.println("Se elimino correctamente");
        }
        else
        {
            System.out.println("No se encontro el DNI del empleado a eliminar");
        }
    }
    
    
    public String VerInfo()
    {
        String cad="";
        for(int i=0;i<conta;i++)
        {
            cad=cad+arreglo[i].VerInfo()+"\n\n";
        }
        return cad;
    }
    
    // Tabla de empleados (equivale a la tabla de la ventana de gestion)
    public String VerTabla()
    {
        String cad = "DNI | NOMBRES | APELLIDOS | USUARIO | ROL\n";
        cad = cad + "----------------------------------------------\n";
        for(int i=0;i<conta;i++)
        {
            cad = cad + arreglo[i].getDni() + " | " 
                      + arreglo[i].getNombres() + " | " 
                      + arreglo[i].getApellidos() + " | " 
                      + arreglo[i].getUsuario() + " | " 
                      + arreglo[i].getRol() + "\n";
        }
        cad = cad + "Total de empleados: " + conta + "\n";
        return cad;
    }
}
