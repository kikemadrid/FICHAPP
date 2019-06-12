package com.example.fichapp.i_dao;

import com.example.fichapp.beans.Fichaje;

import java.sql.Timestamp;
import java.util.List;

public interface IFichajeDao {
    public List<Fichaje> getFicheje(int id_empleado);
    public List<Fichaje> getFichaje(Timestamp desde, Timestamp hasta);
    public Fichaje getFichajeUltimo(int id_empleado);
    public boolean nuevo(Fichaje f);
    public boolean eliminar(int id_fichaje);
    public boolean actualizar(Fichaje f);
}