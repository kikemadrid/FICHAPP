package com.example.fichapp.utils;

import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidades {


    //########################## VALIDACIONES FORMULARIOS REGISTRO #######################################

    private static final String letras_validas = "ABCDEFGHJPQRSUV";

    private static final String PATRON_PWD = "\\w{6,45}";

    /* Caracteres de control */
    private static final String caracteres_de_control = "JABCDEFGHI";

    /* tipos donde el carácter de control tiene que ser una letra */
    private static final String tipo_de_letra = "PQS";

    /* tipos donde el carácter de control tiene que ser un nombre */
    private static final String tipo_de_nombre = "ABEH";


    /**
     * VALIDA QUE EL EMAIL PASADO COMO PARÁMETRO SEA VÁLIDO
     * @param email
     * @return TRUE EN CASO DE QUE ESTE CORRECTO EL EMAIL
     */

    public static boolean emailValido (String email)
    {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    /**
     * VALIDA QUE EL CIF ESTE INGRESADO CORRECTAMENTE
     * @param cif
     * @return TRUE EN CASO DE QUE ESTE CORRECTO EL CIF
     */

    public static boolean cifValido (String cif){
        boolean resultado = false;
        int digito_de_control;

        try {
            /* Un CIF tiene que tener nueve dígitos */
            if (cif.length() == 9) {

                /* Toma la primera letra del CIF */
                char letra_CIF = cif.charAt(0);

                /* Comprueba si la primera letra del CIF es válida */
                if (letras_validas.indexOf(letra_CIF) >= 0) {

                    if (Character.isDigit(cif.charAt(8))) {
                        digito_de_control = Character.getNumericValue(cif
                                .charAt(8));
                        if (tipo_de_letra.indexOf(letra_CIF) >= 0)
                            digito_de_control = 100;
                    } else {
                        digito_de_control = caracteres_de_control.indexOf(cif
                                .charAt(8));
                        if (tipo_de_nombre.indexOf(letra_CIF) >= 0)
                            digito_de_control = 100;
                    }

                    int a = 0, b = 0, c = 0;
                    byte[] impares = { 0, 2, 4, 6, 8, 1, 3, 5, 7, 9 };

                    /* Calcula A y B. */
                    for (int t = 1; t <= 6; t = t + 2) {

                        /* Suma los pares */
                        a = a + Character.getNumericValue(cif.charAt(t + 1));
                        b = b
                                + impares[Character.getNumericValue(cif
                                .charAt(t))];
                    }

                    b = b + impares[Character.getNumericValue(cif.charAt(7))];
                    /* Calcula C */
                    c = 10 - ((a + b) % 10);
                    /* Compara C con los dígitos de control */
                    resultado = (c == digito_de_control);
                }
            }
        } catch (Exception e) {
            resultado = false;
        }
        return resultado;
    }

    /**
     * Valida que una cadena tenga un tamaño. Se usa para validar nombre de usuario y empresa
     * @param nombre
     * @return TRUE EN CASO CORRECTO
     */
    
    public static boolean validarNombre (String nombre){
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        return patron.matcher(nombre).matches() || nombre.length() < 4;
    }

    /**
     * VALIDA QUE LAS CONTRASEÑAS COINCIDAN
     * @param pass1
     * @param pass2
     * @return TRUE EN CASO CORRECTO
     */
    public static boolean comprobarIgual(
            String pass1, String pass2){
        return pass1.equals(pass2);
    }

    /**
     * VALIDA QUE LA CONTRASEÑA SEA VALIDA CON UN PATRÓN DECLARADO
     * @param p1
     * @return TRUE EN CASO CORRECTO
     */

    public static boolean contrasenaValida (String p1)
    {
        boolean bdev = false;

        Pattern p = Pattern.compile(PATRON_PWD);
        Matcher m = p.matcher(p1);
        bdev = m.matches();

        return bdev;
    }


    //########################## FIN VALIDACIONES FORMULARIOS REGISTRO #######################################
}