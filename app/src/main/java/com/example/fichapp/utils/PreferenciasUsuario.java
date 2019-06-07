package com.example.fichapp.utils;


import android.content.Context;
import android.content.SharedPreferences;

public class PreferenciasUsuario {


    public static final String NOMBRE_FICHERO = "usuario_preferences";
    public static final String CLAVE_ENTRADA = "isEntrado";



    public static void guardarEntrada (Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(NOMBRE_FICHERO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(CLAVE_ENTRADA, true);
        editor.commit();
    }


    public static boolean getEntrada(Context context){

        boolean valor = false;

        SharedPreferences sharedPreferences = context.getSharedPreferences(NOMBRE_FICHERO, Context.MODE_PRIVATE);
        valor = sharedPreferences.getBoolean(CLAVE_ENTRADA,false);

        return valor;
    }

}
