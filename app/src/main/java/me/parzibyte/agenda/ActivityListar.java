package me.parzibyte.agenda;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import me.parzibyte.agenda.modelos.Persona;

public class ActivityListar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewPersonas);

        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(ActivityListar.this, Utilerias.NOMBRE_BD, null, 1);
        SQLiteDatabase bd = conexion.getReadableDatabase();
        String[] campos = {Utilerias.CAMPO_NOMBRE, Utilerias.CAMPO_TELEFONO, Utilerias.CAMPO_ID};
        Cursor cursor = bd.query(Utilerias.TABLA_PERSONA,
                campos,
                null,
                null,
                null,
                null,
                null);
        if (!cursor.moveToFirst()) {
            cursor.close();
            bd.close();
            return;
        }

        ArrayList<Persona> personas = new ArrayList<>();


        do {
            String nombre = cursor.getString(cursor.getColumnIndex(Utilerias.CAMPO_NOMBRE));
            String telefono = cursor.getString(cursor.getColumnIndex(Utilerias.CAMPO_TELEFONO));
            int id = cursor.getInt(cursor.getColumnIndex(Utilerias.CAMPO_ID));
            Persona persona = new Persona(nombre, telefono, id);
            personas.add(persona);
        } while (cursor.moveToNext());

        // Fin del ciclo. Cerramos cursor y regresamos la lista de mascotas :)
        cursor.close();


        AdaptadorPersonas adaptadorPersonas = new AdaptadorPersonas(personas);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adaptadorPersonas);

    }
}
