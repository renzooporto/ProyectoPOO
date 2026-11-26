/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author ROporto
 */
public class Cancha11 extends Cancha
{
    public Cancha11(String codigo, String nombre, String tipo, int capacidad, String estado)
    {
        super(codigo,nombre,tipo,capacidad,estado);
        this.tarifaBase = 200;
    }

    @Override
    public float CalcularTarifa(int hora)
    {
        float tarifa = this.tarifaBase;

        if(EsNocturno(hora))
        {
            tarifa = this.tarifaBase * 1.30f;
        }

        return tarifa;
    }
}
