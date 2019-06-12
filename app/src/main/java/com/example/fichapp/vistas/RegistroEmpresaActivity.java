package com.example.fichapp.vistas;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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


        //Activamos el escuchador que al peder el foco relizará las posteriores validaciones por cada caja del formulario
        activarFocoValidacion();

        // hay que determinar que vamos a recibir
        String accion = getIntent().getStringExtra("accion");

        logicaBotones(accion);

    }

    public void logicaBotones(String accion) {
        if (accion.equals("usuario")) {
            Button botonM = (Button) findViewById(R.id.botonmodificar);
            Button botonE = (Button) findViewById(R.id.botoneliminar);
            botonM.setEnabled(false);
            botonE.setEnabled(false);
        }
    }

    public void activarFocoValidacion() {

        cajatextocif = (EditText) findViewById(R.id.cajacif);
        cajatextocif.setOnFocusChangeListener(new FocusListenerFormularios(this));

        cajatextomail = (EditText) findViewById(R.id.cajaemail);
        cajatextomail.setOnFocusChangeListener(new FocusListenerFormularios(this));

        cajatextoresp = (EditText) findViewById(R.id.cajaresponsable);
        cajatextoresp.setOnFocusChangeListener(new FocusListenerFormularios(this));

        cajatextonombreempresa = (EditText) findViewById(R.id.cajaresponsable);
        cajatextonombreempresa.setOnFocusChangeListener(new FocusListenerFormularios(this));
    }


    public void registrar(View v) {


    }

    public void modificar(View v) {


    }

    public void eliminar(View v) {

        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Importante");
        dialogo1.setMessage("Si elimina la empresa se eliminarán todos los empleados dados de alta. ¿Desea continuar?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                // Codigo que llamará a la eliminación de la empresa
            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                // Se cancela la operación de elmiminación
            }
        });
        dialogo1.show();
    }




}