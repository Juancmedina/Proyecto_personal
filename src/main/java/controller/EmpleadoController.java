package controller;

import data.EmpleadoDao;
import domain.Empleado;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jmedina
 */
public class EmpleadoController {
    
    private EmpleadoDao empleadoDao;
    
    public EmpleadoController(){
        empleadoDao = new EmpleadoDao();
    }
    
    public List<Empleado> obtenerEmpleados() throws SQLException{
        return empleadoDao.obtenerEmpleados();
    }
    
    public void crear(Empleado empleado) throws SQLException {
        empleadoDao.crear(empleado);
    }
    
    public Empleado obtenerEmpleado(int id) throws SQLException {
        return empleadoDao.obtenerEmpleado(id);
    }
    
    public void actualizarEmpleado(int id,Empleado empleado) throws SQLException {
        empleadoDao.actualizarEmpleado(id, empleado);
    }
    
    public void eliminarEmpleado(int id) throws SQLException {
        empleadoDao.eliminarEmpleado(id);
    }
    
}
