package com.example.fichapp.vistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.fichapp.R;
import com.example.fichapp.utils.FocusListenerFormularios;

public class RegistroEmpresaActivity extends AppCompatActivity {

    EditText cajatextomail;
    EditText cajatextocif;
    EditText cajatextoresp;
    EditText cajatextonombreempresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_empresa);
        // para colocar la flecha hacia detras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // equivalente pero colocando una flecha personalizada
        //getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_launcher);
        cajatextocif = (EditText) findViewById(R.id.cajacif);
        cajatextocif.setOnFocusChangeListener(new FocusListenerFormularios(this));

    }

    public void enviar (View v){
        /*
        * TODO
        *
        * 2 - registrar datos en BD
         */


    }


}
