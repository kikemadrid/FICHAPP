package com.example.fichapp.i_dao;


import com.example.fichapp.beans.Empleado;

import java.util.List;

public interface IEmpleadoDao {
    public Empleado getEmpleadoId(int id_empleado);
    public List<Empleado> getEmpleados();
    public Empleado primero();
    public Empleado ultimo();
    public List<String> getRoles();
    public Empleado getEmpleadoUsuarioClave(String usuario, String clave);
    public boolean nuevo(Empleado e);
    public boolean eliminar(int id_empleado);
    public boolean actualizar(Empleado e);
    public boolean baja(Empleado e);
}