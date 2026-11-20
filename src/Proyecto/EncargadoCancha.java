/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author ROporto
 */
public class EncargadoCancha extends Empleado  
{
    public EncargadoCancha(int dni, String nombres, String apellidos, String usuario, String clave) 
    {
        super(dni, nombres, apellidos, usuario, clave, ROL_ENCAR);
    }

    @Override
    public String Permisos() 
    {
        return "Inicio, cierre e incidencias de partidos";
    }
}
