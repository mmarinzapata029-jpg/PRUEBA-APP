package com.example.primerproyecto;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Pantalla de bienvenida del primer proyecto Android.
 *
 * Requisitos cubiertos:
 *  1) Multi-idioma: los textos ("Bienvenido/Welcome/Bienvenue/Willkommen" y
 *     "Entrar/Enter/Entrer/Betreten") provienen de res/values*/strings.xml,
 *     por lo que Android selecciona automáticamente el recurso adecuado
 *     según el idioma configurado en el dispositivo (es = default).
 *  2) Fondo nine-patch: el layout usa @drawable/bg_clouds_android (un
 *     archivo .9.png) como fondo, de modo que se estira correctamente sin
 *     deformar al androide.
 *  3) Múltiples pantallas: el layout usa ConstraintLayout con posiciones
 *     porcentuales y dimensiones en dp definidas en values / values-sw600dp /
 *     values-sw720dp, además de un layout-land para orientación horizontal.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEnter = findViewById(R.id.btnEnter);
        btnEnter.setOnClickListener(v ->
                Toast.makeText(this, R.string.welcome_message, Toast.LENGTH_SHORT).show());
    }
}
