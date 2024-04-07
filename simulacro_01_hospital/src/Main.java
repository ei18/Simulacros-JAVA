import controller.AppointmentController;
import controller.MedicController;
import controller.PatientController;
import controller.SpecialityController;
import database.ConfigDB;
import entity.Appointment;
import entity.Speciality;
import model.SpecialityModel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int option = 0, option2 = 0;

        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("""
                    1. Administrar Especialidades
                    2. Administrar Médicos
                    3. Administrar Pacientes
                    4. Administrar Citas
                    5. Salir
                    
                    Ingrese una opción:
                    """));
            switch (option){
                case 1:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                            1. Listar Especialidades
                            2. Crear Especialidad
                            3. Actualizar Especialidad
                            4. Eliminar Especialidad
                            5. Salir
                            
                            Ingrese una opción:
                            """));

                        switch (option2){
                            case 1:
                                SpecialityController.getAll();
                                break;
                            case 2:
                                SpecialityController.insert();
                                break;
                            case 3:
                                SpecialityController.update();
                                break;
                            case 4:
                                SpecialityController.delete();
                                break;
                        }
                    }while (option2 != 5);
                    break;

                case 2:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                            1. Listar Médicos
                            2. Crear Médico
                            3. Actualizar Médico
                            4. Eliminar Médicos
                            5. Salir
                            
                            Ingrese una opción:
                            """));

                        switch (option2){
                            case 1:
                                MedicController.getAll();
                                break;

                            case 2:
                                MedicController.insert();
                                break;

                            case 3:
                                MedicController.update();
                                break;

                            case 4:
                                MedicController.delete();
                                break;
                        }

                    }while (option2 != 5);
                    break;

                case 3:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                            1. Listar Pacientes
                            2. Crear Paciente
                            3. Actualizar Paciente
                            4. Eliminar Paciente
                            5. Salir
                            
                            Ingrese una opción:
                            """));

                        switch (option2){
                            case 1:
                                PatientController.getAll();
                                break;

                            case 2:
                                PatientController.insert();
                                break;

                            case 3:
                                PatientController.update();
                                break;

                            case 4:
                                PatientController.delete();
                                break;
                        }
                    }while (option2 != 5);
                    break;

                case 4:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                            1. Listar Citas
                            2. Crear Cita
                            3. Actualizar Cita
                            4. Eliminar Cita
                            5. Salir
                            
                            Ingrese una opción:
                            """));

                        switch (option2){
                            case 1:
                                AppointmentController.getAll();
                                break;

                            case 2:
                                AppointmentController.insert();
                                break;

                            case 3:
                                AppointmentController.update();
                                break;

                            case 4:
                                AppointmentController.delete();
                                break;
                        }

                    }while (option2 != 5);
                    break;
            }
        }while (option != 5);
    }
}