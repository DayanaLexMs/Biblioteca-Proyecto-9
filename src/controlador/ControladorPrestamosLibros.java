package controlador;

import vista.JFPrestamos;
import java.util.ArrayList;
import modelo.Libro;
import modelo.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Administrativo;
import modelo.Profesor;
import modelo.Estudiante;
import modelo.Referencia;
import modelo.ColeccionGen;
import modelo.EstadoPres;
import modelo.Fecha;
import modelo.Prestamo;

/**
 *
 * @author USUARIO
 */
public class ControladorPrestamosLibros implements ActionListener {

    private JFPrestamos frmPrestamos;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Prestamo> listaPrestamosAc;
    private ArrayList<Prestamo> listaPrestamosHistorial;

    public ControladorPrestamosLibros(JFPrestamos frmPrestamos) {
        this.frmPrestamos = frmPrestamos;
        this.listaUsuarios = new ArrayList<>();
        this.listaLibros = new ArrayList<>();
        this.listaPrestamosAc = new ArrayList<>();
        this.listaPrestamosHistorial = new ArrayList<>();
        deshabilitarInicio();
        registrarLibros();
        this.frmPrestamos.btnRegistrar.addActionListener(this);
        this.frmPrestamos.btnHacerPrestamos.addActionListener(this);
        this.frmPrestamos.btnCrearPrest.addActionListener(this);
        this.frmPrestamos.btnDevolver.addActionListener(this);
        this.frmPrestamos.btnConsultar.addActionListener(this);
        this.frmPrestamos.btnConsultarrrrr.addActionListener(this);
        this.frmPrestamos.pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmPrestamos.btnRegistrar) {
            registrarUsuario();
        }
        if (e.getSource() == this.frmPrestamos.btnHacerPrestamos) {
            habilitarRealizarPrestamos();
        }
        if (e.getSource() == this.frmPrestamos.btnCrearPrest) {
            realizarPrestamo();
            hacerNuevoPrestamo();
        }
        if (e.getSource() == this.frmPrestamos.btnDevolver) {
            devolverLibro();
        }
        if (e.getSource() == this.frmPrestamos.btnConsultarrrrr) {
            abrirPanelConsultar();
        }
        if (e.getSource() == this.frmPrestamos.btnConsultar) {
            mostrarInfoPrestamoSeleccionado();
        }
    }

    private void deshabilitarInicio() {
        this.frmPrestamos.panelPrestamo.setVisible(false);
        this.frmPrestamos.btnHacerPrestamos.setVisible(false);
        this.frmPrestamos.panelDevolucion.setVisible(false);
        this.frmPrestamos.panelConsultar.setVisible(false);
    }

    public void registrarUsuario() {
        String id = this.frmPrestamos.txtId.getText();
        String nombre = this.frmPrestamos.txtNombre.getText();
        String tipoU = this.frmPrestamos.cmbTipoUsuario.getSelectedItem().toString();

        if (id.isEmpty() || nombre.isEmpty() || tipoU.isEmpty()) {
            JOptionPane.showMessageDialog(frmPrestamos, "CAMPOS IMCOMPLETOS");
            return;
        }
        if (this.validarIdentidadUsuario()) {
            return;
        }

        Usuario usuarioN = null;
        if (tipoU.equals("ADMINISTRATIVO")) {
            usuarioN = new Administrativo(id, nombre);
        } else if (tipoU.equals("PROFESOR")) {
            usuarioN = new Profesor(id, nombre);
        } else if (tipoU.equals("ESTUDIANTE")) {
            usuarioN = new Estudiante(id, nombre);
        } else {
            JOptionPane.showMessageDialog(frmPrestamos, "USUARIO INVÁLIDO, NO PUDO REGISTRARSE");
            return;
        }
        this.listaUsuarios.add(usuarioN);
        JOptionPane.showMessageDialog(frmPrestamos, "USUARIO REGISTRADO");
        this.frmPrestamos.cmbUsuario.removeAllItems();
        if (!this.listaUsuarios.isEmpty()) {
            for (Usuario u : listaUsuarios) {
                this.frmPrestamos.cmbUsuario.addItem(u.getNombre());
            }
        }

        this.frmPrestamos.btnHacerPrestamos.setVisible(true);
        this.frmPrestamos.pack();

    }

    private boolean validarIdentidadUsuario() {
        String id = this.frmPrestamos.txtId.getText();
        if (!this.listaUsuarios.isEmpty()) {
            for (Usuario u : listaUsuarios) {
                if (u.getId().equals(id)) {
                    JOptionPane.showMessageDialog(frmPrestamos, "ESTE USUARIO YA ESTÁ REGISTRADO, INGRESE OTRA IDENTIFICACIÓN");
                    return true;
                }
            }

        }
        return false;
    }

    public Fecha crearFecha(String fechaa) {

        String[] fechas = fechaa.split("/");
        int[] fecha = new int[fechas.length];

        for (int i = 0; i < 3; i++) {
            fecha[i] = Integer.parseInt(fechas[i]);
        }

        Fecha f = new Fecha(fecha[0], fecha[1], fecha[2]);

        return f;
    }

    private void registrarLibros() {

        listaLibros.add(new Referencia("Diccionario de la Lengua Española", "Real Academia Española", "978-84-670-1234-5", 2022, "Espasa", 2));
        listaLibros.add(new Referencia("Enciclopedia Universal Ilustrada", "Varios Autores", "978-84-670-5678-9", 2020, "Planeta", 2));
        listaLibros.add(new Referencia("Atlas Geográfico Mundial", "Instituto Geográfico", "978-84-670-9012-3", 2021, "Santillana", 2));
        listaLibros.add(new ColeccionGen("Cien años de soledad", "Gabriel García Márquez", "978-84-376-0494-7", 1967, "Sudamericana", 5));
        listaLibros.add(new ColeccionGen("El amor en los tiempos del cólera", "Gabriel García Márquez", "978-84-376-0495-4", 1985, "Sudamericana", 3));
        listaLibros.add(new ColeccionGen("Don Quijote de la Mancha", "Miguel de Cervantes", "978-84-376-0496-1", 1605, "Alfaguara", 4));
        listaLibros.add(new ColeccionGen("La sombra del viento", "Carlos Ruiz Zafón", "978-84-376-0497-8", 2001, "Planeta", 6));
        listaLibros.add(new ColeccionGen("Física Universitaria", "Sears - Zemansky", "978-84-376-0498-5", 2018, "Pearson", 3));
        for (Libro l : listaLibros) {
            this.frmPrestamos.cmbLibro.addItem(l.getTitulo());
        }
    }

    private void realizarPrestamo() {

        String libroEscogido = this.frmPrestamos.cmbLibro.getSelectedItem().toString();
        String usuario = this.frmPrestamos.cmbUsuario.getSelectedItem().toString();
        String fechaPrestamo = this.frmPrestamos.txtFechaPres.getText();
        if (libroEscogido.isEmpty() || usuario.isEmpty() || fechaPrestamo.isEmpty()) {
            JOptionPane.showMessageDialog(frmPrestamos, "CAMPOS IMCOMPLETOS");
            return;

        }
        if (!this.validarDisponibilidadLibro()) {
            JOptionPane.showMessageDialog(frmPrestamos, "NO HAY COPIAS DISPONIBLES DEL LIBRO");
            return;
        }

        //Aquí empiezo lo del préstamo
        Libro libroPrestar = null;
        for (Libro l : listaLibros) {
            if (l.getTitulo().equalsIgnoreCase(libroEscogido)) {
                libroPrestar = l;
                break;
            }
        }

        Usuario usuarioPr = null;
        for (Usuario u : listaUsuarios) {
            if (u.getNombre().equals(usuario)) {
                usuarioPr = u;
                break;
            }
        }

        Fecha fechaP = this.crearFecha(fechaPrestamo);
        /*int plazo = 0;
        if(usuarioPr instanceof Estudiante || usuarioPr instanceof Profesor){
            plazo = 15;
        }else if(usuarioPr instanceof Administrativo){
            plazo  = 3;
        }
        
        Fecha fechaDev = fechaP.sumarDias(plazo);*/

        Prestamo prestN = new Prestamo(fechaP, usuarioPr, libroPrestar);
        libroPrestar.setCanCopias(libroPrestar.getCanCopias() - 1);
        prestN.setEstado(EstadoPres.PRESTADO);
        listaPrestamosAc.add(prestN);
        this.frmPrestamos.txtInfoPrest.setText(prestN.toString());
        llenarComboPrestamosActivos();
        this.frmPrestamos.panelDevolucion.setVisible(true);
        this.frmPrestamos.pack();

    }

    private boolean validarDisponibilidadLibro() {
        String libroE = this.frmPrestamos.cmbLibro.getSelectedItem().toString();
        for (Libro l : listaLibros) {
            if (l.getTitulo().equalsIgnoreCase(libroE)) {
                if (l.getCanCopias() > 0) {
                    return true;
                } else {
                    return false;
                }
            }

        }
        return false;

    }

    private void habilitarRealizarPrestamos() {
        this.frmPrestamos.panelPrestamo.setVisible(true);
        this.frmPrestamos.panelRegistro.setVisible(false);
        this.frmPrestamos.btnHacerPrestamos.setVisible(false);
        this.frmPrestamos.pack();
    }

    private void hacerNuevoPrestamo() {
        this.frmPrestamos.txtId.setText("");
        this.frmPrestamos.txtNombre.setText("");
        this.frmPrestamos.txtFechaPres.setText("");

    }

    private void devolverLibro() {
        String prestamoDevolver = this.frmPrestamos.cmbPrestamosActivos.getSelectedItem().toString();
        String fechaEntregado = this.frmPrestamos.txtFechaDevFinal.getText();

        if (prestamoDevolver.isEmpty() || fechaEntregado.isEmpty()) {
            JOptionPane.showMessageDialog(frmPrestamos, "CAMPOS IMCOMPLETOS");
            return;
        }

        Prestamo prestamo = this.buscarPrestamo(prestamoDevolver);
        Fecha fechaF = this.crearFecha(fechaEntregado);

        if (fechaF.esDespues(prestamo.getFechaDev())) {
            prestamo.setEstado(EstadoPres.MULTADO);
            this.frmPrestamos.txtResulDev.setText("MULTADO DEBIDO A ENTREGA FUERA DE PLAZO");
        } else {
            prestamo.setEstado(EstadoPres.DEVUELTO);
            this.frmPrestamos.txtResulDev.setText("ENTREGADO");
        }

        Libro libroDevuelto = prestamo.getLibroPrestado();
        libroDevuelto.setCanCopias(libroDevuelto.getCanCopias() + 1);

        listaPrestamosHistorial.add(prestamo);
        listaPrestamosAc.remove(prestamo);
        llenarComboPrestamosActivos();
        this.frmPrestamos.txtFechaDevFinal.setText("");
        this.frmPrestamos.pack();

    }

    private void llenarComboPrestamosActivos() {
        this.frmPrestamos.cmbPrestamosActivos.removeAllItems();

        for (Prestamo p : listaPrestamosAc) {
            String texto = p.getUsuario().getNombre() + " - " + p.getLibroPrestado().getTitulo() + " - " + p.getFechaDev();
            this.frmPrestamos.cmbPrestamosActivos.addItem(texto);
        }
    }

    private void llenarComboPrestamosConsultar() {
        this.frmPrestamos.cmbPrestamosBuscar.removeAllItems();

        // Préstamos activos
        for (Prestamo p : listaPrestamosAc) {
            String texto = p.getUsuario().getNombre() + " - " + p.getLibroPrestado().getTitulo();
            this.frmPrestamos.cmbPrestamosBuscar.addItem(texto);
        }

        // Préstamos del historial
        for (Prestamo p : listaPrestamosHistorial) {
            String texto = p.getUsuario().getNombre() + " - " + p.getLibroPrestado().getTitulo();
            this.frmPrestamos.cmbPrestamosBuscar.addItem(texto);
        }
    }

    private Prestamo buscarPrestamo(String textoSeleccionado) {
        for (Prestamo p : listaPrestamosAc) {
            String textoPrestamo = p.getUsuario().getNombre() + " - " + p.getLibroPrestado().getTitulo() + " - " + p.getFechaDev();
            if (textoPrestamo.equals(textoSeleccionado)) {
                return p;
            }
        }
        return null;
    }

    private void abrirPanelConsultar() {
        llenarComboPrestamosConsultar();
        this.frmPrestamos.panelConsultar.setVisible(true);
        this.frmPrestamos.pack();
    }

    private void mostrarInfoPrestamoSeleccionado() {
        int idx = this.frmPrestamos.cmbPrestamosBuscar.getSelectedIndex();

        if (idx == -1) {
            JOptionPane.showMessageDialog(frmPrestamos, "Seleccione un préstamo");
            return;
        }

        Prestamo prestamo = null;
        if (idx < listaPrestamosAc.size()) {
            prestamo = listaPrestamosAc.get(idx);
        } else {
            int idxHistorial = idx - listaPrestamosAc.size();
            if (idxHistorial < listaPrestamosHistorial.size()) {
                prestamo = listaPrestamosHistorial.get(idxHistorial);
            }
        }

        if (prestamo == null) {
            JOptionPane.showMessageDialog(frmPrestamos, "Préstamo no encontrado");
            return;
        }

        String info = "INFORMACIÓN DEL PRÉSTAMO \n\n" +
                      "Usuario: " + prestamo.getUsuario().getNombre() + "\n" +
                      "ID: " + prestamo.getUsuario().getId() + "\n" +
                      "Libro: " + prestamo.getLibroPrestado().getTitulo() + "\n" +
                      "Autor: " + prestamo.getLibroPrestado().getAutor() + "\n" +
                      "Fecha préstamo: " + prestamo.getFechaInicio() + "\n" +
                      "Fecha límite: " + prestamo.getFechaDev() + "\n" +
                      "Estado: " + prestamo.getEstado();

        JOptionPane.showMessageDialog(frmPrestamos, info);
        this.frmPrestamos.pack();
    }
}