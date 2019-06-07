package com.example.fichapp.utils;

import android.app.Activity;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;

import com.example.fichapp.R;

public class FocusListenerFormularios implements View.OnFocusChangeListener {

    private Activity actividad;

    public FocusListenerFormularios(Activity activity)
    {
        this.actividad = activity;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

        if (!hasFocus) {
            String texto_introducido;
            EditText cajatexto =  (EditText)v;
            texto_introducido = cajatexto.getText().toString();
            switch (String.valueOf(v.getTag())){
                case "cif":
                    validarCif(texto_introducido,v);
                    break;
                case "nombreempresa":
                case "responsable":
                case "tagnombre":
                case "tagapellidos":
                case "tagusername":
                    validarNombre(texto_introducido,v);
                    break;
                case "email":
                    validarEmail(texto_introducido,v);
                    break;
                case "tagrepcontraseña":
                    validarPass(texto_introducido,texto_introducido,v);////// aqui mirar como hacer
                    break;
            }
        }
    }

    public void validarCif (String cif,View v){
        if (!Utilidades.cifValido (cif))
        {
            TextInputLayout wrapmail = (TextInputLayout)actividad.findViewById(R.id.tilcif);
            wrapmail.setError("CIF Incorrecto");
        }
    }

    public void validarNombre (String empresa, View v){
        if (!Utilidades.validarNombre(empresa)){
            TextInputLayout wrapmail = (TextInputLayout)actividad.findViewById(R.id.tilcif);
            wrapmail.setError("Nombre empresa incorrecto");
        }
    }

    public void validarEmail (String email, View v) {
        if (!Utilidades.emailValido (email))
        {
            TextInputLayout wrapmail = (TextInputLayout)actividad.findViewById(R.id.tilemail);
            wrapmail.setError("Mail incorrecto");
        }
    }

    public void validarPass (String pass1, String pass2, View v){
        if (!Utilidades.comprobarIgual(pass1,pass2)){
            TextInputLayout wrapmail = (TextInputLayout)actividad.findViewById(R.id.tilemail);
            wrapmail.setError("Mail incorrecto");
        }
    }
}