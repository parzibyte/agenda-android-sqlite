package me.parzibyte.agenda.modelos;

public class Persona {
    private String nombre, telefono;
    private int id;

    public Persona(String nombre, String telefono, int id) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.id = id;
    }

    public Persona(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}