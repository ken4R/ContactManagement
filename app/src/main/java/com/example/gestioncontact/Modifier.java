package com.example.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Modifier extends AppCompatActivity implements View.OnClickListener {
    EditText ednom,edprenom,ednum;
    Button btnmod,btnqte;
    int indice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier);
        indice =  getIntent().getIntExtra("id",-1);



        ednom=findViewById(R.id.ednom_mod);
        edprenom=findViewById(R.id.edprenom_mod);
        ednum=findViewById(R.id.ednum_mod);
        btnmod=findViewById(R.id.btnmod_mod);
        btnqte=findViewById(R.id.btnqte_mod);

        ednom.setText(Acceuil.data.get(indice).getNom());
        edprenom.setText(Acceuil.data.get(indice).getPrenom());
        ednum.setText(Acceuil.data.get(indice).getNumero());
        btnqte.setOnClickListener(this);
        btnmod.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v == btnmod){
            Acceuil.data.get(indice).setNom(ednom.getText().toString());
            Acceuil.data.get(indice).setPrenom(edprenom.getText().toString());
            Acceuil.data.get(indice).setNumero(ednum.getText().toString());
            Intent i =new Intent(Modifier.this,Affichage.class);

            startActivity(i);
        }else{

            this.finish();




        }

    }
}