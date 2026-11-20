/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author ROporto
 */
public class Recepcionista extends Empleado
{
    public Recepcionista(String dni, String nombres, String apellidos, String usuario, String clave) 
    {
        super(dni, nombres, apellidos, usuario, clave, ROL_RECEP);
    }

    @Override
    public String Permisos() 
    {
        return "Jugadores y reservas";
    }
}
