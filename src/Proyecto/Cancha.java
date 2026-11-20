/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author ROporto
 */
public abstract class Cancha 
{
        protected int capacidad;
        protected float tarifaBase;
        protected String codigo, nombre, tipo, estado;

        public Cancha(String codigo, String nombre, String tipo, int capacidad, String estado) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.tipo = tipo;
            this.capacidad = capacidad;
            this.estado = estado;
        }

        public int getCapacidad() {
            return capacidad;
        }

        public void setCapacidad(int capacidad) {
            this.capacidad = capacidad;
        }

        public float getTarifaBase() {
            return tarifaBase;
        }

        public void setTarifaBase(float tarifaBase) {
            this.tarifaBase = tarifaBase;
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }   

        public boolean EsNocturno(int hora)
        {
            boolean nocturno=false;
            if(hora>=18)
            {
                nocturno=true;
            }
            return nocturno;
        }

        public boolean EsReservable()
        {
            boolean reservable=true;
            if(this.estado.equalsIgnoreCase("En Mantenimiento"))
            {
                reservable=false;
            }
            return reservable;
        }

        public abstract double CalcularTarifa();


        public String VerInfo() {
            return  "codigo: " + codigo + 
                    "\nnombre: " + nombre + 
                    "\ntipo: " + tipo + 
                    "\ncapacidad: " + capacidad + 
                    "\ntarifa base: " + tarifaBase + 
                    "\nestado: " + estado;
        }    
    
    
}
