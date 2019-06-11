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
            String texto_tag;

            EditText cajatexto =  (EditText)v;

            texto_introducido = cajatexto.getText().toString();
            texto_tag = String.valueOf(cajatexto.getTag());

            switch (texto_tag){
                case "tagcif":
                    validarCif(texto_introducido);
                    break;
                case "tagnombreempresa":
                    validarNombreEmpresa(texto_introducido);
                    break;
                case "tagresponsable":
                    validarNombreResponsable(texto_introducido);
                    break;
                case "tagemail":
                    validarEmail(texto_introducido);
                    break;
                case "tagnombre":
                    validarNombreEmpleado(texto_introducido);
                    break;
                case "tagapellidos":
                    validarApellidosEmpleado(texto_introducido);
                    break;
                case "tagusername":
                    validarNombreUsuario(texto_introducido);
                    break;
                case "tagcontraseña":
                    validarPass(texto_introducido);
                case "tagrepcontraseña":
                    validarPassRep(texto_introducido);
                    break;
            }
        }
    }

    public void validarCif (String cif){
        if (!Utilidades.cifValido (cif)) {

            TextInputLayout wrapmail = (TextInputLayout)actividad.findViewById(R.id.tilcif);
            wrapmail.setError("CIF Incorrecto");
        }
    }

    public void validarNombreEmpresa (String empresa) {
        if (!Utilidades.validarNombre(empresa)){
            TextInputLayout wrapmail = (TextInputLayout)actividad.findViewById(R.id.tilnombreempresa);
            wrapmail.setError("Incorrecto. Entre 4 y 30 caracteres");
        }
    }


    public void validarEmail (String email) {
        if (!Utilidades.emailValido (email))
        {
            TextInputLayout wrapmail = (TextInputLayout)actividad.findViewById(R.id.tilemail);
            wrapmail.setError("Mail incorrecto");
        }
    }


    public void validarNombreResponsable (String nombre) {
        if (!Utilidades.validarNombre(nombre)){
            TextInputLayout wrapmail = (TextInputLayout)actividad.findViewById(R.id.tilresponsable);
            wrapmail.setError("Incorrecto. Entre 1 y 30 caracteres");
        }
    }

    public void validarNombreEmpleado (String nombre) {
        if (!Utilidades.validarNombre(nombre)){
            TextInputLayout wrapmail = (TextInputLayout)actividad.findViewById(R.id.tilcajanombre);
            wrapmail.setError("Incorrecto. Entre 1 y 30 caracteres");
        }
    }
    public void validarNombreUsuario (String nombre) {
        if (!Utilidades.validarNombre(nombre)){
            TextInputLayout wrapmail = (TextInputLayout)actividad.findViewById(R.id.tilcajausername);
            wrapmail.setError("Incorrecto. Entre 1 y 30 caracteres");
        }
    }

    public void validarApellidosEmpleado (String nombre) {
        if (!Utilidades.validarNombre(nombre)){
            TextInputLayout wrapmail = (TextInputLayout)actividad.findViewById(R.id.tilcajaapellidos);
            wrapmail.setError("Incorrecto. Entre 1 y 30 caracteres");
        }
    }

    public void validarPass(String pass){
        if (!Utilidades.contrasenaValida(pass)){
            TextInputLayout wrapmail = (TextInputLayout)actividad.findViewById(R.id.tilcajacontraseña);
            wrapmail.setError("Contraseña invalida mín");
        }

    }

    public void validarPassRep (String pass2) {
        if (!Utilidades.comprobarIgual(actividad.findViewById(R.id.cajacontraseña).toString(),pass2)){
            TextInputLayout wrapmail = (TextInputLayout)actividad.findViewById(R.id.tilemail);
            wrapmail.setError("Las contraseñas no coinciden");
        }
    }
}