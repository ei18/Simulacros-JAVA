package controller;

import entity.Medic;
import entity.Speciality;
import model.MedicModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class MedicController {

    public static void getAll(){
        String list = getAll(instanceModel().findAll());

        JOptionPane.showMessageDialog(null, list);
    }
    public static String getAll(List<Object> list){
        String listString = "Lista de registros \n";

        for (Object temp : list){
            Medic objMedic = (Medic) temp;
            listString += objMedic.toString() + "\n";
        }

        return listString;
    }

    public static void delete(){
        Object[] options = Utils.listToArray(instanceModel().findAll());

        Medic objMedic = (Medic) JOptionPane.showInputDialog(
                null,
                "Seleccione el médico a eliminar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        instanceModel().delete(objMedic);
    }
    public static void update(){
        Object[] options = Utils.listToArray(instanceModel().findAll());

        Medic objMedic = (Medic) JOptionPane.showInputDialog(
                null,
                "Seleccione el médico a actualizar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        String name = JOptionPane.showInputDialog(null,"Ingrese el nombre del médico: " + objMedic.getName());
        String lastName = JOptionPane.showInputDialog(null,"Ingrese los apellidos del médico: " + objMedic.getLastName());


        Object[] optionsSpecialities = Utils.listToArray(SpecialityController.instanceModel().findAll());

        Speciality objSpeciality = (Speciality) JOptionPane.showInputDialog(
                null,
                "Seleccione una especialidad: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsSpecialities,
                optionsSpecialities[0]
        );

        instanceModel().update(new Medic(name, lastName, objSpeciality.getId(), objSpeciality));
    }
    public static void insert(){
        String name = JOptionPane.showInputDialog("Ingrese el nombre del médico: ");
        String lastName = JOptionPane.showInputDialog("Ingrese los apellidos del médico: ");

        Object[] optionsSpecialities = Utils.listToArray(SpecialityController.instanceModel().findAll());

        Speciality objSpeciality = (Speciality) JOptionPane.showInputDialog(
                null,
                "Seleccione una especialidad: ",
                        "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsSpecialities,
                optionsSpecialities[0]
        );

        instanceModel().insert(new Medic(name, lastName, objSpeciality.getId(), objSpeciality));

        }

    public static MedicModel instanceModel(){
        return new MedicModel();
    }
}
