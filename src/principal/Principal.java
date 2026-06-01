/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;
import vista.JFPrestamos;
import controlador.ControladorPrestamosLibros;

/**
 *
 * @author USUARIO
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       JFPrestamos frmPrestamos = new JFPrestamos();
       ControladorPrestamosLibros ctrl = new ControladorPrestamosLibros (frmPrestamos);
       frmPrestamos.setVisible(true);
       frmPrestamos.setLocationRelativeTo(null);
    }
    
}
