/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Prestamo {

    private Fecha fechaInicio;
    private Fecha fechaDev;
    private EstadoPres estado;
    private Usuario usuario;
    private Libro libroPrestado;

    public Prestamo(Fecha fechaInicio, Fecha fechaDev, EstadoPres estado, Usuario usuario, Libro libroPrestado) {
        this.fechaInicio = fechaInicio;
        this.fechaDev = fechaDev;
        this.estado = estado;
        this.usuario = usuario;
        this.libroPrestado = libroPrestado;
    }

    public Prestamo(Fecha fechaInicio, Usuario usuario, Libro libroPrestado) {
        this.fechaInicio = fechaInicio;
        this.usuario = usuario;
        this.libroPrestado = libroPrestado;
        this.fechaDev = calcularFechaDev();
    }
    

    public Fecha getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Fecha fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Fecha getFechaDev() {
        return fechaDev;
    }

    public void setFechaDev(Fecha fechaDev) {
        this.fechaDev = fechaDev;
    }

    public EstadoPres getEstado() {
        return estado;
    }

    public void setEstado(EstadoPres estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibroPrestado() {
        return libroPrestado;
    }

    public void setLibroPrestado(Libro libroPrestado) {
        this.libroPrestado = libroPrestado;
    }
    
    public Fecha calcularFechaDev(){
        int plazo = usuario.obtenerTiempoPrestamo();
        return fechaInicio.sumarDias(plazo);
    }

    @Override
    public String toString() {
        return "PRÉSTAMO EXITOSO: \n" + "A nombre de: " + usuario.getNombre() + 
                "\n Libro: " + libroPrestado.getTitulo() + "\n Fecha de Préstamo: " + fechaInicio + 
                "\n Fecha Límite: " + this.fechaDev;
    }
    
    

}
