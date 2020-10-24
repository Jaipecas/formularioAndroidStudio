package com.example.miformulariojaimeperez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Cargar icono formulario en Action Bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_icon);

        // Obtenemos la referencia de los controles
        name = (EditText) findViewById(R.id.editTextNombre);
        next = (Button) findViewById(R.id.buttonNext);

        // Implementamos el evento onClick
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().isEmpty()) {
                    // Mensaje que informa de que el campo nombre esta vacío
                    Toast.makeText(MainActivity.this, R.string.toast_errorName, Toast.LENGTH_SHORT).show();
                } else{
                    // Se accede al Activity2
                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    startActivity(intent);
                }
            }
        });
    }
}
