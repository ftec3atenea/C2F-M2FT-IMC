package com.example.myconversionapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Instanciar las variables
        EditText etPesoK = findViewById(R.id.etPesoK);
        EditText etAluraM = findViewById(R.id.etAluraM);
        Button btnConvertir3 = findViewById(R.id.btnConvertir3);
        TextView result3 = findViewById(R.id.result3);
        TextView result4 = findViewById(R.id.result4);
        Button btnC2C = findViewById(R.id.btnC2C);
        Button btnC2M = findViewById(R.id.btnC2M);

        // Poner un listener al botón
        btnConvertir3.setOnClickListener(v -> {
            // Verificar que el campo de entrada no esté vacío
            if ( (!etPesoK.getText().toString().isEmpty()) && (!etAluraM.getText().toString().isEmpty()) ) {
                // Obtener el valor de los grados en Celsius
                float pesoK = Float.parseFloat(etPesoK.getText().toString());
                float alturaM = Float.parseFloat(etAluraM.getText().toString());

                // Calcular IMC
                float IMC = (pesoK)/(alturaM * alturaM);

                // ---------------------------------------------------------------------------------
                // La clasificación según el IMC
                if (IMC < 18.5) {
                    result4.setText("Bajo Peso ");

                } else if ((IMC >= 18.5) && (IMC < 24.9)) {
                    result4.setText("Normal  ");

                } else if ((IMC >= 25) && (IMC < 29.9)) {
                    result4.setText("Sobrepeso ");

                } else if ((IMC >= 30) && (IMC < 34.9)) {
                    result4.setText("Obesidad I ");

                } else if ((IMC >= 35) && (IMC < 39.9)) {
                    result4.setText("Obesidad II ");

                } else if ((IMC >= 40) && (IMC < 49.9)) {
                    result4.setText("Obesidad III ");

                } else {
                    result4.setText("Obesidad IV ");
                }
                // ---------------------------------------------------------------------------------

                // Mostrar el resultado
                result3.setText(String.valueOf(IMC));
            } else {
                // Mostrar un mensaje de error si el campo de entrada está vacío
                Toast.makeText(this, "Por favor ingrese ambos datos", Toast.LENGTH_SHORT).show();
            }
        });

        // Generar los intent para cambiar de actividad
        btnC2C.setOnClickListener(v -> {
            // Aquí generamos el evento de pasar a la siguiente App
            Intent go2MFT = new Intent(this, MainActivity.class);
            // iniciamos la actividad
            startActivity(go2MFT);
        });

        btnC2M.setOnClickListener(v -> {
            // Aquí generamos el evento de pasar a la siguiente App
            Intent go2CF = new Intent(this, MainActivity2.class);
            // iniciamos la actividad
            startActivity(go2CF);
        });
    }
}