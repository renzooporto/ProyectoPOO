/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author ROporto
 */
public class Administrador extends Empleado implements Constantes 
{
    public Administrador(String dni, String nombres, String apellidos, String usuario, String clave) 
    {
        super(dni, nombres, apellidos, usuario, clave, ROL_ADMIN);
    }

    @Override
    public String Permisos() 
    {
        return "Empleados, canchas, tarifas, servicios, paquetes y reportes";
    }
}
