package data;

import com.mycompany.proyecto_personal.util.ConnectionUtil;
import domain.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jmedina
 */
public class EmpleadoDao {
    private static final String GET_EMPLEADOS = "select * from empleados";
    
    private static final String CREATE_EMPLEADO = "INSERT INTO public.empleados\n" 
            + "(tipo_identificacion, identificacion, nombres, apellidos, estado_civil, sexo, direccion, telefono, fecha_de_nacimiento)\n" 
            + "VALUES(?,?,?,?,?,?,?,?,?,?)";
    
    private static final String GET_EMPLEADO_BY_ID = "select * from empleados where id = ?";
    
    private static final String UPDATE_EMPLEADO = "update empleados set tipo_identificacion = ?, identificacion = ?, nombres = ?, apellidos = ?, estado_civil = ?,"
            + " sexo = ?, direccion = ?, telefono = ?,fecha_de_nacimiento = ? where id = ?";
    
    private static final String DELETE_EMPLEADO = " delete from empleados where id = ?";
    
    public List<Empleado> obtenerEmpleados()throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Empleado> empleados = new ArrayList<>();
        
        try {
        connection = ConnectionUtil.getConnection();
        preparedStatement = connection.prepareStatement(GET_EMPLEADOS);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            
            Empleado empleado = new Empleado();
            empleado.setTipo_identificacion(resultSet.getString("tipo_identificacion"));
            empleado.setIdentificacion(resultSet.getInt("identificacion"));
            empleado.setNombres(resultSet.getString("nombres"));
            empleado.setApellidos(resultSet.getString("apellidos"));
            empleado.setEstado_civil(resultSet.getString("estado_civil"));
            empleado.setSexo(resultSet.getString("sexo"));
            empleado.setDireccion(resultSet.getString("direccion"));
            empleado.setTelefono(resultSet.getString("telefono"));
            empleado.setFecha_de_nacimiento(resultSet.getString("fecha_de_nacimiento"));
            empleados.add(empleado);
            
        }
        return empleados;
        
        } finally {
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null){
                preparedStatement.close();
            }
            
            if(resultSet != null){
                resultSet.close();
            }
        }  
    }
    
    public void crear (Empleado empleado) throws SQLException{
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_EMPLEADO);
            preparedStatement.setString(1, empleado.getTipo_identificacion());
            preparedStatement.setInt(2, empleado.getIdentificacion());
            preparedStatement.setString(3, empleado.getNombres());
            preparedStatement.setString(4, empleado.getApellidos());
            preparedStatement.setString(5, empleado.getEstado_civil());
            preparedStatement.setString(6, empleado.getSexo());
            preparedStatement.setString(7, empleado.getDireccion());
            preparedStatement.setString(8, empleado.getTelefono());
            preparedStatement.setString(9, empleado.getFecha_de_nacimiento());
            preparedStatement.executeUpdate();
            
        } finally {
            if (connection != null){
                connection.close();
            }
        }
    }
    
    public Empleado obtenerEmpleado(int id) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Empleado empleado = null;
        
        try {
            
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_EMPLEADO_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()){
                empleado = new Empleado();
                empleado.setTipo_identificacion(resultSet.getString("tipo_identificacion"));
                empleado.setIdentificacion(resultSet.getInt("identificacion"));
                empleado.setNombres(resultSet.getString("nombres"));
                empleado.setApellidos(resultSet.getString("apellidos"));
                empleado.setEstado_civil(resultSet.getString("estado_civil"));
                empleado.setSexo(resultSet.getString("sexo"));
                empleado.setDireccion(resultSet.getString("direccion"));
                empleado.setTelefono(resultSet.getString("telefono"));
                empleado.setFecha_de_nacimiento(resultSet.getString("fecha_de_nacimiento"));
            }
            return empleado;
            
        } finally {
            if (connection != null){
                connection.close();
            }
        }
    }
    
    public void actualizarEmpleado (int id, Empleado empleado) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_EMPLEADO);
            preparedStatement.setString(1, empleado.getTipo_identificacion());
            preparedStatement.setInt(2, empleado.getIdentificacion());
            preparedStatement.setString(3, empleado.getNombres());
            preparedStatement.setString(4, empleado.getApellidos());
            preparedStatement.setString(5, empleado.getEstado_civil());
            preparedStatement.setString(6, empleado.getSexo());
            preparedStatement.setString(7, empleado.getDireccion());
            preparedStatement.setString(8, empleado.getTelefono());
            preparedStatement.setString(9, empleado.getFecha_de_nacimiento());
            preparedStatement.executeUpdate();
            
        } finally {
            if (connection != null){
                connection.close();
            }
            
            if(preparedStatement != null){
                preparedStatement.close();
            }
        }
    }
    
    public void eliminarEmpleado(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_EMPLEADO);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        } finally{
            if (connection != null){
                connection.close();
            }
            
            if (preparedStatement != null){
                preparedStatement.close();
            }
        }
    }
}
