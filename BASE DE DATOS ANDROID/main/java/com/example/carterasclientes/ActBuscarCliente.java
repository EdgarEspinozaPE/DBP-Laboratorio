package com.example.carterasclientes;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.carterasclientes.BaseDatos.DatosOpenHelper;
import com.example.carterasclientes.BaseDatos.FeedReaderClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class ActBuscarCliente extends AppCompatActivity {
    private ListView lstDatos;
    private ArrayAdapter<String> adaptator;
    private ArrayList<String> clientes;

    private EditText edtNombre;
    private SQLiteDatabase conexion;
    private DatosOpenHelper datosOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_buscar_cliente);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edtNombre = (EditText) findViewById(R.id.edtNombre);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_act_buscar_cliente, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_buscar:
                if(bCamposCorrectos()){

                    lstDatos = (ListView) findViewById(R.id.lstDatos);
                    clientes = new ArrayList<String>();
                    datosOpenHelper = new DatosOpenHelper(this);
                    conexion = datosOpenHelper.getReadableDatabase();

                    String selection = FeedReaderClient.FeedEntry.COLUMN_NOMBRE + " = ?";
                    String[] selectionArgs = { edtNombre.getText().toString().trim() };

                    Cursor resultado = conexion.query(
                            FeedReaderClient.FeedEntry.TABLE_NAME,
                            null,
                            selection,
                            selectionArgs,
                            null,
                            null,
                            null,
                            null
                    );

                    if (resultado.getCount() > 0) {
                        resultado.moveToFirst();
                        do {
                            String cliente = resultado.getString(resultado.getColumnIndex(FeedReaderClient.FeedEntry.COLUMN_NOMBRE)) +
                                    ": " + resultado.getString(resultado.getColumnIndex(FeedReaderClient.FeedEntry.COLUMN_TELEFONO));
                            clientes.add(cliente);
                        } while (resultado.moveToNext());
                        resultado.close();
                    }
                    adaptator = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, clientes);
                    lstDatos.setAdapter(adaptator);
                    //conexion.close();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean bCamposCorrectos() {
        boolean res = true;
        if (edtNombre.getText().toString().trim().isEmpty()) {
            edtNombre.requestFocus();
            res = false;
        }
        return res;
    }
}