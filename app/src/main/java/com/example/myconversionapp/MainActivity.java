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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Instanciar las variables
        EditText etGradosC = findViewById(R.id.etGradosC);
        Button btnConvertir = findViewById(R.id.btnConvertir);
        TextView result = findViewById(R.id.result);
        Button btnC2M = findViewById(R.id.btnC2M);
        Button btnC2I = findViewById(R.id.btnC2I);

        // Agregar un listener al botón
        btnConvertir.setOnClickListener(v -> {
            // Verificar que el campo de entrada no esté vacío
            if ( !etGradosC.getText().toString().isEmpty() ) {
                // Obtener el valor de los grados en Celsius
                float gradosC = Float.parseFloat(etGradosC.getText().toString());

                // Convertir los grados a Fahrenheit
                float gradosF = (gradosC * 9 / 5) + 32;

                // Mostrar el resultado
                result.setText(String.format("%.2f °F", gradosF));
            } else {
                // Mostrar un mensaje de error si el campo de entrada está vacío
                Toast.makeText(this, "Por favor ingrese un dato", Toast.LENGTH_SHORT).show();
            }
        });

        // Generar los intent para cambiar de actividad
        btnC2M.setOnClickListener(v -> {
            // Aquí generamos el evento de pasar a la siguiente App
            Intent go2MFT = new Intent(this, MainActivity2.class);
            // iniciamos la actividad
            startActivity(go2MFT);
        });

        btnC2I.setOnClickListener(v -> {
            // Aquí generamos el evento de pasar a la siguiente App
            Intent go2IMC = new Intent(this, MainActivity3.class);
            // iniciamos la actividad
            startActivity(go2IMC);
        });
    }
}