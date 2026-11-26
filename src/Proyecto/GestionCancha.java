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
public class GestionCancha 
{
    private Cancha[] arreglo;
    private int conta;

    public GestionCancha()
    {
        arreglo = new Cancha[10];
        conta = 0;
    }

    public Cancha[] getArreglo() {
        return arreglo;
    }

    public int getConta() {
        return conta;
    }
    
    public void Ingresar(Cancha ref)
    {
        boolean repetido=false;

        for(int i=0;i<conta;i++)
        {
            if(arreglo[i].getCodigo().equalsIgnoreCase(ref.getCodigo()))
            {
                repetido=true;
                JOptionPane.showMessageDialog(null, "El codigo ya esta registrado");
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
    
    public void Modificar(String codigo, String nombre, int capacidad, float tarifaBase, String estado)
    {
        int pos=-1;

        for(int i=0;i<conta;i++)
        {
            if(arreglo[i].getCodigo().equalsIgnoreCase(codigo))
            {
                pos=i;
            }
        }

        if(pos==-1)
        {
            JOptionPane.showMessageDialog(null, "No se encontro el codigo de la cancha");
        }
        else
        {
            arreglo[pos].setNombre(nombre);
            arreglo[pos].setCapacidad(capacidad);
            arreglo[pos].setTarifaBase(tarifaBase);
            arreglo[pos].setEstado(estado);

            JOptionPane.showMessageDialog(null, "Se modifico correctamente");
        }
    }
    
    public void Eliminar(String codigo)
    {
        boolean encontro=false;

        for(int i=0;i<conta;i++)
        {
            if(arreglo[i].getCodigo().equalsIgnoreCase(codigo))
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
            JOptionPane.showMessageDialog(null, "No se encontro el codigo de la cancha");
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
