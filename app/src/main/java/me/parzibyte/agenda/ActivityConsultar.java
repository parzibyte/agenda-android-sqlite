package me.parzibyte.agenda;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityConsultar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        final EditText etIdBusqueda = findViewById(R.id.etIdBusqueda),
                etMostrarNombre = findViewById(R.id.etMostrarNombre),
                etMostrarTelefono = findViewById(R.id.etMostrarTelefono);

        Button btnBuscar = findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idBusqueda = etIdBusqueda.getText().toString();
                if (idBusqueda.isEmpty()) return;
                ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(ActivityConsultar.this, Utilerias.NOMBRE_BD, null, 1);
                SQLiteDatabase bd = conexion.getReadableDatabase();
                String[] parametros = {idBusqueda};
                String[] campos = {Utilerias.CAMPO_NOMBRE, Utilerias.CAMPO_TELEFONO};
                Cursor cursor = bd.query(Utilerias.TABLA_PERSONA,
                        campos,
                        Utilerias.CAMPO_ID + "=?",
                        parametros,
                        null,
                        null,
                        null);
                if (!cursor.moveToFirst()) {
                    Toast.makeText(ActivityConsultar.this, "ID Inexistente", Toast.LENGTH_SHORT).show();
                    etMostrarNombre.setText("");
                    etMostrarTelefono.setText("");
                    bd.close();
                    return;
                }

                etMostrarNombre.setText(cursor.getString(cursor.getColumnIndex(Utilerias.CAMPO_NOMBRE)));
                etMostrarTelefono.setText(cursor.getString(cursor.getColumnIndex(Utilerias.CAMPO_TELEFONO)));

            }
        });
    }
}
