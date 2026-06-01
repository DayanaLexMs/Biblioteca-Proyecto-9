/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Administrativo extends Usuario{

    public Administrativo(String id, String nombre) {
        super(id, nombre);
    }
    @Override
    public int obtenerTiempoPrestamo(){
        return 3;
    }
           
}
