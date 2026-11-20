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
    
    // El DNI identifica al empleado y no se modifica
    public String Modificar(int dni, String nombres, String apellidos, String usuario, String clave, String rol)
    {
        String error = Validar(dni, nombres, apellidos, usuario, clave, rol);
        if(error.equalsIgnoreCase("")==false)
        {
            return error;
        }
        int pos = BuscarPosDni(dni);
        if(pos==-1)
        {
            return "Error: no existe un empleado con el DNI " + dni;
        }
        int posUsu = BuscarPosUsuario(usuario);
        if(posUsu!=-1 && posUsu!=pos)
        {
            return "Error: el usuario " + usuario + " ya esta en uso";
        }
        // Se vuelve a crear el objeto porque el rol puede cambiar de subclase
        arreglo[pos] = Crear(dni, nombres, apellidos, usuario, clave, rol);
        return "Empleado modificado correctamente";
    }
    
    public String Eliminar(int dni)
    {
        int pos = BuscarPosDni(dni);
        if(pos==-1)
        {
            return "Error: no existe un empleado con el DNI " + dni;
        }
        for(int j=pos;j<conta-1;j++)
        {
            arreglo[j]=arreglo[j+1];
        }
        arreglo[conta-1]=null;
        conta--;
        return "Empleado eliminado correctamente";
    }
    
    // ---------- Visualizacion ----------
    
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
