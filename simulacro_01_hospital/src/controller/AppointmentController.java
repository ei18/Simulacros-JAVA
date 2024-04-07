package controller;

import entity.Appointment;
import entity.Medic;
import entity.Patient;
import model.AppointmentModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class AppointmentController {
    public static void update(){
        Object[] options = Utils.listToArray(instanceModel().findAll());

        Appointment appointmentSelected = (Appointment) JOptionPane.showInputDialog(
                null,
                "Seleccione la cita a actualizar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        appointmentSelected.setDate(JOptionPane.showInputDialog(null,"Ingresa la fecha de la cita: YYYY-MM-DD", appointmentSelected.getDate()));
        appointmentSelected.setTime(JOptionPane.showInputDialog(null,"Ingresa la hora de la cita: HH:MM:SS", appointmentSelected.getTime()));
        appointmentSelected.setMotive(JOptionPane.showInputDialog(null,"Ingresa el motivo de la cita", appointmentSelected.getMotive()));

        Object[] optionsPatients = Utils.listToArray(PatientController.instanceModel().findAll());
        Object[] optionsMedics = Utils.listToArray(MedicController.instanceModel().findAll());

        appointmentSelected.setObjPatient((Patient) JOptionPane.showInputDialog(
                null,
                "Seleccione el paciente",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsPatients,
                optionsPatients[0]
        ));

        appointmentSelected.setIdPatient(appointmentSelected.getObjPatient().getId());

        appointmentSelected.setObjMedic((Medic) JOptionPane.showInputDialog(
                null,
                "Seleccione el médico asignado a la cita",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsMedics,
                optionsMedics[0]
        ));

        appointmentSelected.setIdMedic(appointmentSelected.getObjMedic().getId());

        instanceModel().update(appointmentSelected);
    }
    public static void delete(){
        Object[] options = Utils.listToArray(instanceModel().findAll());


        Appointment appointmentSelected = (Appointment) JOptionPane.showInputDialog(
                null,
                "Seleccione la cita a eliminar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        instanceModel().delete(appointmentSelected);

    }
    public static void insert(){
        String date = JOptionPane.showInputDialog("Ingresa la fecha de la cita: YYYY-MM-DD");
        String time = JOptionPane.showInputDialog("Ingresa la hora de la cita: HH:MM:SS");
        String motive = JOptionPane.showInputDialog("Ingresa el motivo de la cita");

        Object[] optionsPatients = Utils.listToArray(PatientController.instanceModel().findAll());
        Object[] optionsMedics = Utils.listToArray(MedicController.instanceModel().findAll());

        Patient patientSelected = (Patient) JOptionPane.showInputDialog(
                null,
                "Seleccione el paciente",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsPatients,
                optionsPatients[0]
        );

        Medic medicSelected = (Medic) JOptionPane.showInputDialog(
                null,
                "Seleccione el médico asignado a la cita",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsMedics,
                optionsMedics[0]
        );

        instanceModel().insert(new Appointment(date, time, motive, patientSelected.getId(), medicSelected.getId(), medicSelected, patientSelected));
    }
    public static void getAll(){
        String listString = getAll(instanceModel().findAll());

        JOptionPane.showMessageDialog(null, listString);
    }
    public static String getAll(List<Object> list){
        String listString = "Lista de registros\n";

        for (Object temp : list){
            Appointment obj = (Appointment) temp;
            listString += obj.toString() + "\n";
        }
        return listString;
    }

    public static AppointmentModel instanceModel(){
        return new AppointmentModel();
    }
}
