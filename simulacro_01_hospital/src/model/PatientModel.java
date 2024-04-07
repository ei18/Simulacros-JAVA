package model;

import database.CRUD;
import database.ConfigDB;
import entity.Patient;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();

        Patient objPatient = (Patient) obj;

        try {
            String sql = "INSERT INTO paciente (nombre, apellidos, fecha_nacimiento,  documento_identidad ) VALUES (?, ?, ?, ?);";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objPatient.getName());
            objPrepare.setString(2, objPatient.getLastName());
            objPrepare.setDate(3, Date.valueOf(objPatient.getBirthday()));
            objPrepare.setString(4, objPatient.getDocument());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()){
                objPatient.setId(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null,"Registro exitoso.");

        }catch (SQLException e){
            System.out.println("ERROR > " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objPatient;
    }

    @Override
    public List<Object> findAll() {
        Connection objConnection = ConfigDB.openConnection();

        List<Object> listPatient = new ArrayList<>();

        try {
            String sql = "SELECT * FROM paciente;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                Patient objPatient = new Patient();

                objPatient.setId(objResult.getInt("id"));
                objPatient.setName(objResult.getString("nombre"));
                objPatient.setLastName(objResult.getString("apellidos"));
                objPatient.setBirthday(objResult.getString("fecha_nacimiento"));
                objPatient.setDocument(objResult.getString("documento_identidad"));

                listPatient.add(objPatient);
            }

        }catch (SQLException e){
            System.out.println("ERROR > " + e.getMessage());
        }
        ConfigDB.closeConnection();

        return listPatient;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Patient objPatient = (Patient) obj;
        boolean isUpdated = false;

        try {
            String sql = "UPDATE paciente SET nombre = ?, apellidos = ?, fecha_nacimiento = ?,documento_identidad = ? WHERE id = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objPatient.getName());
            objPrepare.setString(2, objPatient.getLastName());
            objPrepare.setDate(3, Date.valueOf(objPatient.getBirthday()));
            objPrepare.setString(4, objPatient.getDocument());
            objPrepare.setInt(5, objPatient.getId());

            int totalRowAffected = objPrepare.executeUpdate();

            if (totalRowAffected > 0) {
                isUpdated = true;

                JOptionPane.showMessageDialog(null, "Registro actualizado correctamente.");
            }

        }catch (SQLException e){
            System.out.println("ERROR > " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return isUpdated;
    }

    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Patient objPatient = (Patient) obj;
        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM paciente WHERE id = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objPatient.getId());

            int totalRowAffected = objPrepare.executeUpdate();

            if (totalRowAffected > 0){
                isDeleted = true;

                JOptionPane.showMessageDialog(null,"Registro eliminado correctamente.");
            }

        }catch (SQLException e){
        System.out.println("ERROR > " + e.getMessage());
    }
        ConfigDB.closeConnection();
        return isDeleted;
    }
}
