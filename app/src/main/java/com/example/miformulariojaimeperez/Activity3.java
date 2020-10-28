package com.example.miformulariojaimeperez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {
    private Button buttonInfo;
    private String stringInfo;
    private ImageButton imageButtonMail;
    private EditText editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        // Activar la flecha para volver al Main
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Obtenemos referencias
        buttonInfo = (Button) findViewById(R.id.buttonInfo);
        imageButtonMail = (ImageButton) findViewById(R.id.imageButtonMail);
        editTextEmail = (EditText) findViewById(R.id.editTextMail);

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonInfo.setVisibility(View.INVISIBLE);
                // Traemos la información del anterior intent y la mostramos
                Bundle bundleInfo = getIntent().getExtras();
                if (bundleInfo != null) {
                    stringInfo = "Hola " + bundleInfo.getString("nombre") + ", eres un " + bundleInfo.getString("sexo").toLowerCase() + " de " +
                            bundleInfo.getString("edad") + " años";
                    // Si es mujer se remplaza "un" por "una" en la String
                    if (bundleInfo.getString("sexo").equalsIgnoreCase("mujer")) {
                        stringInfo = stringInfo.replace("un", "una");
                    }
                    Toast.makeText(Activity3.this, stringInfo, Toast.LENGTH_SHORT).show();
                }
            }
        });
        // Mandar email
        imageButtonMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentEmail = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
                intentEmail.setType("plain/text");
                // Comprueba que el email esta introducido
                if (!editTextEmail.getText().toString().isEmpty()) {
                    intentEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{editTextEmail.getText().toString()});
                    intentEmail.putExtra(Intent.EXTRA_SUBJECT, "Información email");
                    intentEmail.putExtra(Intent.EXTRA_TEXT, stringInfo);
                    //Se comprueba que el dispostivo tenga alguna aplicacion para mandar emails
                    if (intentEmail.resolveActivity((getPackageManager())) != null) {
                        startActivity(intentEmail);
                    } else {
                        Toast.makeText(Activity3.this, "Su dispositivo no posee aplicaciones para realizar la acción ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Activity3.this, "Introduzca email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}