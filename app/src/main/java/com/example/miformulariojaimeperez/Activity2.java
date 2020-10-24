package com.example.miformulariojaimeperez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    private SeekBar seekBar;
    private TextView textSeekBar;
    private Button button;
    private RadioButton radioButtonMan;
    private RadioButton radioButtonWoman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        // Activar la flecha para volver al Main
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Se obtiene referencia de los controles
        seekBar = (SeekBar) findViewById(R.id.seekBarAge);
        textSeekBar = (TextView) findViewById(R.id.textViewSeekBar);
        button = (Button) findViewById(R.id.buttonNext);
        radioButtonMan = (RadioButton) findViewById(R.id.radioButtonMan);
        radioButtonWoman = (RadioButton) findViewById(R.id.radioButtonWoman);

        // Evento movimiento de la SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textSeekBar.setText(String.valueOf(i));
                if (i < 16 || i > 55) {
                    button.setEnabled(false);
                    Toast.makeText(Activity2.this, R.string.toast_errorAge, Toast.LENGTH_SHORT).show();
                } else {
                    button.setEnabled(true);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }


        });
        // Lanza el Activity3
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2.this, Activity3.class);
                startActivity(intent);
            }
        });

        radioButtonMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioButtonMan.setChecked(true);
                radioButtonWoman.setChecked(false);
            }
        });

        radioButtonWoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioButtonWoman.setChecked(true);
                radioButtonMan.setChecked(false);
            }
        });


    }
}