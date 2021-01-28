package com.example.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    //declaration de composants
    EditText ednom,edmp;
    private Button btnval;
    private Button btnqt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mettre un fichier xml dans lecran
        setContentView(R.layout.activity_main);
        
        //recuperation de composants
        edmp=findViewById(R.id.edpass_auth);
        ednom=findViewById(R.id.ednom_auth);
        btnval=findViewById(R.id.btnval_auth);
        btnqt=findViewById(R.id.btnqte_auth);
        btnqt.setBackgroundColor(ContextCompat.getColor(this, R.color.swatch1));
        btnval.setBackgroundColor(ContextCompat.getColor(this, R.color.swatch1));

        //ecouteurs dactions
        btnqt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.this.finish();
            }
        });
        btnval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = ednom.getText().toString();
                String mp=edmp.getText().toString();
                if (nom.equalsIgnoreCase("test") &&  mp.equals("000"))
                {
                    Intent i = new Intent(MainActivity.this,Acceuil.class); // intent de acceuil
                    i.putExtra("USER",nom);
                    startActivity(i);

                }
                else {
                    Toast.makeText(MainActivity.this, " valeur non valide ", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}