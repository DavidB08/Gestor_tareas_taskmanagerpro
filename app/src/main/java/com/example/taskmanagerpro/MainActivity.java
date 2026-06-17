package com.example.taskmanagerpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtId, txtTitulo;

    Spinner spEstado;

    Button btnGuardar,
            btnBuscar,
            btnEditar,
            btnEliminar,
            btnMostrar;

    ListView listaTareas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtId = findViewById(R.id.txtId);
        txtTitulo = findViewById(R.id.txtTitulo);

        spEstado = findViewById(R.id.spEstado);

        btnGuardar = findViewById(R.id.btnGuardar);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnEditar = findViewById(R.id.btnEditar);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnMostrar = findViewById(R.id.btnMostrar);

        listaTareas = findViewById(R.id.listaTareas);

        String[] estados = {
                "Pendiente",
                "En Proceso",
                "Terminada"
        };

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        estados);

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spEstado.setAdapter(adapter);

        btnGuardar.setOnClickListener(v -> guardar());
        btnBuscar.setOnClickListener(v -> buscar());
        btnEditar.setOnClickListener(v -> editar());
        btnEliminar.setOnClickListener(v -> eliminar());
        btnMostrar.setOnClickListener(v -> mostrar());
    }

    private void guardar() {

        AdminSQLiteOpenHelper admin =
                new AdminSQLiteOpenHelper(this);

        SQLiteDatabase db =
                admin.getWritableDatabase();

        ContentValues registro =
                new ContentValues();

        registro.put(
                "id",
                txtId.getText().toString());

        registro.put(
                "titulo",
                txtTitulo.getText().toString());

        registro.put(
                "estado",
                spEstado.getSelectedItem().toString());

        db.insert(
                "tareas",
                null,
                registro);

        db.close();

        Toast.makeText(
                this,
                "Tarea guardada",
                Toast.LENGTH_SHORT).show();

        limpiar();
    }

    private void buscar() {

        AdminSQLiteOpenHelper admin =
                new AdminSQLiteOpenHelper(this);

        SQLiteDatabase db =
                admin.getReadableDatabase();

        Cursor fila =
                db.rawQuery(
                        "SELECT titulo,estado FROM tareas WHERE id="
                                + txtId.getText().toString(),
                        null);

        if (fila.moveToFirst()) {

            txtTitulo.setText(
                    fila.getString(0));

        } else {

            Toast.makeText(
                    this,
                    "No existe",
                    Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    private void editar() {

        AdminSQLiteOpenHelper admin =
                new AdminSQLiteOpenHelper(this);

        SQLiteDatabase db =
                admin.getWritableDatabase();

        ContentValues registro =
                new ContentValues();

        registro.put(
                "titulo",
                txtTitulo.getText().toString());

        registro.put(
                "estado",
                spEstado.getSelectedItem().toString());

        int cant =
                db.update(
                        "tareas",
                        registro,
                        "id=" + txtId.getText().toString(),
                        null);

        db.close();

        if(cant == 1){

            Toast.makeText(
                    this,
                    "Tarea actualizada",
                    Toast.LENGTH_SHORT).show();
        }

        limpiar();
    }

    private void eliminar() {

        AdminSQLiteOpenHelper admin =
                new AdminSQLiteOpenHelper(this);

        SQLiteDatabase db =
                admin.getWritableDatabase();

        int cant =
                db.delete(
                        "tareas",
                        "id=" + txtId.getText().toString(),
                        null);

        db.close();

        if(cant == 1){

            Toast.makeText(
                    this,
                    "Tarea eliminada",
                    Toast.LENGTH_SHORT).show();
        }

        limpiar();
    }

    private void mostrar() {

        AdminSQLiteOpenHelper admin =
                new AdminSQLiteOpenHelper(this);

        SQLiteDatabase db =
                admin.getReadableDatabase();

        Cursor fila =
                db.rawQuery(
                        "SELECT * FROM tareas",
                        null);

        ArrayList<String> tareas =
                new ArrayList<>();

        if(fila.moveToFirst()){

            do {

                tareas.add(
                        "ID: " + fila.getString(0)
                                + "\nTarea: " + fila.getString(1)
                                + "\nEstado: " + fila.getString(2)
                );

            }while(fila.moveToNext());
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        tareas);

        listaTareas.setAdapter(adapter);

        db.close();
    }

    private void limpiar(){

        txtId.setText("");
        txtTitulo.setText("");
    }
}