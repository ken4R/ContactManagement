package com.example.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Ajout extends AppCompatActivity {

    EditText ednom,edprenom,ednum;
    Button btnval,btnqte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        ednom=findViewById(R.id.ednom_ajout);
        edprenom=findViewById(R.id.edprenom_ajout);
        ednum=findViewById(R.id.ednum_ajout);
        btnqte=findViewById(R.id.btnqte_ajout);
        btnval=findViewById(R.id.btnval_ajout);
        btnqte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ajout.this.finish();
            }
        });
        btnval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = ednom.getText().toString();
                String p = edprenom.getText().toString();
                String num = ednum.getText().toString();
                Contact c = new Contact(n, p, num);
                Acceuil.data.add(c);
                Toast.makeText(Ajout.this, "Taille totale" + Acceuil.data.size() +"" , Toast.LENGTH_SHORT).show();

            }
        });
    }
}