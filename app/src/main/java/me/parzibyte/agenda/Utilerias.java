package me.parzibyte.agenda;

public class Utilerias {
    public static final String TABLA_PERSONA = "Persona";
    public static final String NOMBRE_BD = "agenda";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_TELEFONO = "telefono";
    public static final String CREAR_TABLA_PERSONA = "create table "
            + TABLA_PERSONA
            + " (" + CAMPO_ID + " INTEGER, "
            + CAMPO_NOMBRE + " TEXT, " + CAMPO_TELEFONO + " TEXT)";
}
