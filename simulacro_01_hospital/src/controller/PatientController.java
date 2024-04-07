package controller;

import entity.Patient;
import model.PatientModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class PatientController {

    public static void update(){
        Object[] options = Utils.listToArray(instanceModel().findAll());

        Patient patientSelected = (Patient) JOptionPane.showInputDialog(
                null,
                "Seleccione el paciente a actualizar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        patientSelected.setName(JOptionPane.showInputDialog(null,"Ingrese el nuevo nombre", patientSelected.getName()));
        patientSelected.setLastName(JOptionPane.showInputDialog(null,"Ingrese el nuevo apellido", patientSelected.getLastName()));
        patientSelected.setBirthday(JOptionPane.showInputDialog(null,"Ingrese la nueva fecha de naciemiento YYYY-MM-DD", patientSelected.getBirthday()));
        patientSelected.setDocument(JOptionPane.showInputDialog(null,"Ingrese el nuevo número de documento", patientSelected.getDocument()));

        instanceModel().update(patientSelected);
    }
    public static void delete(){
        Object[] options = Utils.listToArray(instanceModel().findAll());

        Patient patientSelected = (Patient) JOptionPane.showInputDialog(
                null,
                "Seleccione el paciente a eliminar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        instanceModel().delete(patientSelected);
    }
    public static void getAll(){
        String list = getAll(instanceModel().findAll());

        JOptionPane.showMessageDialog(null, list);
    }
    public static String getAll(List<Object> list){
        String listString = "Lista de registros";

        for (Object temp : list){
            Patient objPatient = (Patient) temp;
            listString += objPatient.toString() + "\n";
        }
        return listString;
    }
    public static void insert(){
        String name = JOptionPane.showInputDialog("Ingresa el nombre del paciente");
        String lastName = JOptionPane.showInputDialog("Ingresa los apellidos del paciente");
        String birthday = JOptionPane.showInputDialog("Ingresa la fecha de nacimiento YYYY-MM-DD");
        String document = JOptionPane.showInputDialog("Ingresa el documento del paciente");

        instanceModel().insert(new Patient(name, lastName, birthday, document));
    }

    public static PatientModel instanceModel(){
        return new PatientModel();
    }
}
