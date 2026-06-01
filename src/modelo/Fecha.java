/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Fecha {

    private int dia;
    private int mes;
    private int año;

    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public Fecha sumarDias(int dias) {
        int diaN = this.dia + dias;
        int mesN = this.mes;
        int añoN = this.año;

        if (diaN > 30) {
            diaN = diaN - 30;
            mesN++;
        }
        if (mesN > 12) {
            mesN = 1;
            añoN++;
        }
        return new Fecha(diaN, mesN, añoN);
    }

    public boolean esDespues(Fecha otra) {
        if (this.año != otra.año) {
            return this.año > otra.año;
        }
        if (this.mes != otra.mes) {
            return this.mes > otra.mes;
        }
        return this.dia > otra.dia;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + año;
    }

}
