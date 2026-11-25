/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import javax.swing.JOptionPane;
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
                JOptionPane.showMessageDialog(null, "El DNI ya esta registrado");
            }
            else
            {
                if(arreglo[i].getUsuario().equalsIgnoreCase(ref.getUsuario()))
                {
                    repetido=true;
                    JOptionPane.showMessageDialog(null, "El usuario ya esta registrado");
                }
                                                
                
            }
        }
        if(repetido==false)
        {
            if(conta<arreglo.length)
            {
                arreglo[conta]=ref;
                conta++;
                JOptionPane.showMessageDialog(null, "Se ingreso correctamente");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No hay espacio");
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
            JOptionPane.showMessageDialog(null, "No se encontro el DNI a modificar");
        }
        else
        {
            if(repetido)
            {
                JOptionPane.showMessageDialog(null, "Error, ese usuario ya esta en uso");
            }
            else
            {
                arreglo[pos].setNombre(nombre);
                arreglo[pos].setApellido(apellido);
                arreglo[pos].setUsuario(usuario);
                arreglo[pos].setContrasena(contrasena);
                arreglo[pos].setRol(rol);
                JOptionPane.showMessageDialog(null, "Se modifico correctamente");
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
            JOptionPane.showMessageDialog(null, "Se elimino correctamente");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No se encontro el DNI del empleado a eliminar");
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

}
