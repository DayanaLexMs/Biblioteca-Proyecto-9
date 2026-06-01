/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Libro {

    protected String titulo;
    protected String autor;
    protected String issn;
    protected int añoPub;
    protected String editorial;
    protected int canCopias;

    public Libro(String titulo, String autor, String issn, int añoPub, String editorial, int canCopias) {
        this.titulo = titulo;
        this.autor = autor;
        this.issn = issn;
        this.añoPub = añoPub;
        this.editorial = editorial;
        this.canCopias = canCopias;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public int getAñoPub() {
        return añoPub;
    }

    public void setAñoPub(int añoPub) {
        this.añoPub = añoPub;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getCanCopias() {
        return canCopias;
    }

    public void setCanCopias(int canCopias) {
        this.canCopias = canCopias;
    }

    @Override
    public String toString() {
        return titulo; 
    }

}
