package com.example.fichapp.controlador;


import android.app.Application;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.fichapp.dao.EmpleadoDao;
import com.example.fichapp.dao.EmpresaDao;
import com.example.fichapp.dao.FichajeDao;
import com.example.fichapp.i_esquema.IEmpleadoEsquema;
import com.example.fichapp.i_esquema.IEmpresaEsquema;
import com.example.fichapp.i_esquema.IFichajeEsquema;

public class DB extends Application {
    private static final String APP = "APPK";
    private static final String DBNAME = "DBControl.db";
    private DBH db;
    private static final int DBVERSION = 1;
    private Context contexto ;
    public static EmpresaDao empresas;
    public static EmpleadoDao empleados;
    public static FichajeDao fichar;

    public DB open() throws SQLException {
        return this;
    }

    public void close(){
        db.close();
    }

//    public DB(Context contexto){
//        this.contexto = contexto;
//        db = new DBH(contexto);
//        SQLiteDatabase _bd = db.getWritableDatabase();
//        empresas = new EmpresaDao(_bd);
//        empleados = new EmpleadoDao(_bd);
//        fichar = new FichajeDao(_bd);
//    }

    public void onCreate() {
        super.onCreate();
        contexto = getApplicationContext();
        db = new DBH(contexto);
        SQLiteDatabase _bd = db.getWritableDatabase();
        empresas = new EmpresaDao(_bd);
        empleados = new EmpleadoDao(_bd);
        fichar = new FichajeDao(_bd);
    }

    private static class DBH extends SQLiteOpenHelper {

        public DBH(Context context) {
            super(context, DBNAME, null, DBVERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(IEmpresaEsquema.C_CREAR_TABLA);
            db.execSQL(IEmpleadoEsquema.E_CREAR_TABLA);
            db.execSQL(IFichajeEsquema.F_CREAR_TABLA);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i(APP, "Actualizando tablas de version " + oldVersion + " a " + newVersion
                    + ".  Se destruyen todos los datos anteriores");
            db.execSQL("DROP TABLE IF EXISTS "+ IEmpresaEsquema.C_TABLA);
            db.execSQL("DROP TABLE IF EXISTS "+ IEmpleadoEsquema.E_TABLA);
            db.execSQL("DROP TABLE IF EXISTS "+ IFichajeEsquema.F_TABLA);
            onCreate(db);
        }
    }
}
