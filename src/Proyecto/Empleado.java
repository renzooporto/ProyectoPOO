/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author ROporto
 */
public abstract class Empleado 
{
    protected String dni, nombres, apellidos, usuario, clave, rol;

    public Empleado(String dni, String nombres, String apellidos, String usuario, String clave, String rol) 
    {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.clave = clave;
        this.rol = rol;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    // Cada rol define sus funciones permitidas (se usara en RF10)
    public abstract String Permisos();
    
    public String VerInfo() 
    {
        return "DNI: " + dni + 
                "\nNombres: " + nombres + 
                "\nApellidos: " + apellidos + 
                "\nUsuario: " + usuario + 
                "\nRol: " + rol + 
                "\nPermisos: " + Permisos();
    }
}
