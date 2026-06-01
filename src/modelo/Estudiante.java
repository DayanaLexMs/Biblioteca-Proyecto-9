/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Estudiante extends Usuario {

    public Estudiante(String id, String nombre) {
        super(id, nombre);
    }
    @Override
    public int obtenerTiempoPrestamo(){
        return 15;
    }
}
