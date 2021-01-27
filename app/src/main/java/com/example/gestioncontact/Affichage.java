package com.example.gestioncontact;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class Affichage extends AppCompatActivity implements AdapterView.OnItemClickListener, DialogInterface.OnClickListener {
    EditText edrech;
    ListView lv_affiche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);
        edrech=findViewById(R.id.ed_rech);


        lv_affiche=findViewById(R.id.lv_affiche);
       /* ArrayAdapter adapter=new ArrayAdapter(Affichage.this,
                android.R.layout.simple_list_item_1,
                Acceuil.data);
        */
        MonAdapter adapter=new MonAdapter(Affichage.this,Acceuil.data);
        lv_affiche.setAdapter(adapter);
        lv_affiche.setOnItemClickListener(this);
        edrech.addTextChangedListener (new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Log.d("sss",s.toString());
                adapter.getFilter().filter(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    int indice;
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        indice=position;
        AlertDialog.Builder alert=new AlertDialog.Builder(Affichage.this);
        alert.setTitle("Choisir action");
        alert.setMessage("Veuiller choisir une action!");
        alert.setPositiveButton("Modifier",this); //this c est objet courant leclasse eli enti fih
        alert.setNegativeButton("Supprimer",this);
        alert.setNeutralButton("Supprimer tout",this);
        alert.show();


    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which==dialog.BUTTON_POSITIVE){
            this.finish();
            Intent i=new Intent(Affichage.this,Modifier.class);
            i.putExtra("id", indice);
            startActivity(i);


        }
        if (which==dialog.BUTTON_NEGATIVE){
            Acceuil.data.remove(indice);
            lv_affiche.invalidateViews();//refraichissement apres suppression

        }
        if (which==dialog.BUTTON_NEUTRAL){
            Acceuil.data.clear();
            lv_affiche.invalidateViews();

        }


    }



    }
