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
        arreglo = new Empleado[50];
        conta = 0;
    }

    public Empleado[] getArreglo() {
        return arreglo;
    }

    public int getConta() {
        return conta;
    }
    
    // ---------- Busquedas (devuelven la posicion o -1) ----------
    
    public int BuscarPosDni(int dni)
    {
        int pos = -1;
        for(int i=0;i<conta;i++)
        {
            if(arreglo[i].getDni()==dni)
            {
                pos = i;
                break;
            }
        }
        return pos;
    }
    
    public int BuscarPosUsuario(String usuario)
    {
        int pos = -1;
        for(int i=0;i<conta;i++)
        {
            if(arreglo[i].getUsuario().equalsIgnoreCase(usuario))
            {
                pos = i;
                break;
            }
        }
        return pos;
    }
    
    // ---------- Validaciones y creacion ----------
    
    // Devuelve "" si todo esta bien, o el mensaje con la causa del error
    private String Validar(int dni, String nombres, String apellidos, String usuario, String clave, String rol)
    {
        boolean completo = true;
        if(dni<=0)
        {
            completo = false;
        }
        if(nombres.equalsIgnoreCase(""))
        {
            completo = false;
        }
        if(apellidos.equalsIgnoreCase(""))
        {
            completo = false;
        }
        if(usuario.equalsIgnoreCase(""))
        {
            completo = false;
        }
        if(clave.equalsIgnoreCase(""))
        {
            completo = false;
        }
        if(completo==false)
        {
            return "Error: todos los campos son obligatorios";
        }
        
        boolean rolValido = false;
        if(rol.equalsIgnoreCase(ROL_ADMIN))
        {
            rolValido = true;
        }
        else if(rol.equalsIgnoreCase(ROL_RECEP))
        {
            rolValido = true;
        }
        else if(rol.equalsIgnoreCase(ROL_ENCAR))
        {
            rolValido = true;
        }
        if(rolValido==false)
        {
            return "Error: el rol no es valido";
        }
        return "";
    }
    
    // Segun el rol se crea la subclase correspondiente
    private Empleado Crear(int dni, String nombres, String apellidos, String usuario, String clave, String rol)
    {
        if(rol.equalsIgnoreCase(ROL_ADMIN))
        {
            return new Administrador(dni, nombres, apellidos, usuario, clave);
        }
        else if(rol.equalsIgnoreCase(ROL_RECEP))
        {
            return new Recepcionista(dni, nombres, apellidos, usuario, clave);
        }
        else
        {
            return new EncargadoCancha(dni, nombres, apellidos, usuario, clave);
        }
    }
    
    // ---------- RF01: registrar, modificar, eliminar ----------
    
    public String Ingresar(int dni, String nombres, String apellidos, String usuario, String clave, String rol)
    {
        String error = Validar(dni, nombres, apellidos, usuario, clave, rol);
        if(error.equalsIgnoreCase("")==false)
        {
            return error;
        }
        if(conta>=arreglo.length)
        {
            return "Error: no hay espacio para mas empleados";
        }
        if(BuscarPosDni(dni)!=-1)
        {
            return "Error: ya existe un empleado con el DNI " + dni;
        }
        if(BuscarPosUsuario(usuario)!=-1)
        {
            return "Error: el usuario " + usuario + " ya esta en uso";
        }
        arreglo[conta] = Crear(dni, nombres, apellidos, usuario, clave, rol);
        conta++;
        return "Empleado registrado correctamente";
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
