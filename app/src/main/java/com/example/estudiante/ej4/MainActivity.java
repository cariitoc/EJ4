package com.example.estudiante.ej4;

import android.app.Activity;
import android.icu.text.StringSearch;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.Touch;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private ListView lv_contacto;
    private ContactosAdapter customAdapter;
    private EditText et_nombre;
    private Button btn_generar;
    private EditText et_telefono;
    private Switch s_genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customAdapter = new ContactosAdapter(MainActivity.this);


        et_nombre = findViewById(R.id.et_nombre);
        btn_generar = findViewById(R.id.btn_generar);
        et_telefono = findViewById(R.id.et_telefono);
        lv_contacto = findViewById(R.id.lv_contacto);
        s_genero = findViewById(R.id.s_genero);

        lv_contacto.setAdapter(customAdapter);

        btn_generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = et_nombre.getText().toString();
                String telefono = et_telefono.getText().toString();
                String genero = "";

                if (s_genero.isChecked()) {
                    genero = "femenino";
                } else {
                    genero = "masculino";
                }


                Contacto newContacto = new Contacto(nombre, telefono, genero);
                if (nombre.equals("") && telefono.equals("")) {
                    Toast.makeText(MainActivity.this, "ingrese datos validos", Toast.LENGTH_SHORT).show();

                } else {

                    customAdapter.agregarContacto(newContacto);
                }

                et_nombre.setText("");
                et_telefono.setText("");


            }
        });

        //

    }
}
