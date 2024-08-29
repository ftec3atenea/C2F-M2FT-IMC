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

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Instanciar las variables
        EditText etMetrosM = findViewById(R.id.etMetrosM);
        Button btnConvertir2 = findViewById(R.id.btnConvertir2);
        TextView result2 = findViewById(R.id.result2);
        Button btnC2C = findViewById(R.id.btnC2C);
        Button btnC2I = findViewById(R.id.btnC2I);

        // Agregar un listener al botón
        btnConvertir2.setOnClickListener(v -> {
            // Verificar que el campo de entrada no esté vacío
            if ( !etMetrosM.getText().toString().isEmpty() ) {
                // Obtener el valor de los grados en Celsius
                float metrosM = Float.parseFloat(etMetrosM.getText().toString());

                // Convertir los grados a Fahrenheit
                float piesFT = (float) (metrosM * 3.28084);

                // Mostrar el resultado
                result2.setText(String.format("%.2f ft", piesFT));
            } else {
                // Mostrar un mensaje de error si el campo de entrada está vacío
                Toast.makeText(this, "Por favor ingrese un dato", Toast.LENGTH_SHORT).show();
            }
        });

        // Generar los intent para cambiar de actividad
        btnC2C.setOnClickListener(v -> {
            // Aquí generamos el evento de pasar a la siguiente App
            Intent go2CF = new Intent(this, MainActivity.class);
            // iniciamos la actividad
            startActivity(go2CF);
        });

        btnC2I.setOnClickListener(v -> {
            // Aquí generamos el evento de pasar a la siguiente App
            Intent go2IMC = new Intent(this, MainActivity3.class);
            // iniciamos la actividad
            startActivity(go2IMC);
        });
    }
}