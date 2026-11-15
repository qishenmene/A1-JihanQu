import java.util.ArrayList;
import java.util.Collections;

public class AppointmentManager {
    
    // Store all appointments
    private ArrayList<Appointment> appointments;

    // Constructor
    public AppointmentManager(){
        appointments = new ArrayList<Appointment>();
    }

    // Add a new appointment
    public void addAppointment(Appointment appointment){

        // Check whether appointment is null
        if (appointment == null){
            System.out.println("Invalid appointment.");
            return;
        }

        //Check for doublebooking
        for (int i = 0; i < appointments.size(); i++){

            Appointment existing = appointments.get(i);

            if (existing.getHealthProfessional().equals(appointment.getHealthProfessional()) && existing.getAppointmentTime().equals(appointment.getAppointmentTime())) {
                System.out.println(
                    "This health professional is already booked at this time."
                );
                return;
            }
        }

        // Add appointment
        appointments.add(appointment);

        System.out.println("Appointment added successfully.");
    }

    // Display all appointments
    public void viewAppointments(){

        if (appointments.isEmpty()){
            System.out.println("No appointments found.");
            return;
        }

        for (int i = 0; i < appointments.size(); i++){
            System.out.println(appointments.get(i));
            System.out.println("--------------------");
        }

    }

    // Search appointment by professional ID
    public void searchByProfessionalId(String professionalId){

        boolean found = false;

        for (int i = 0; i < appointments.size(); i++){

            Appointment appointment = appointments.get(i);

            if (appointment.getHealthProfessional().getId().equals(professionalId)){

                System.out.println(appointment);
                System.out.println("--------------------");
                found = true;
            }
        }

        if (!found){
            System.out.println("No appointment found for this professional.");
        }
    }

    // Search appointment by patient number
    public void searchMobileNumber(String mobileNumber){

        boolean found = false;

        for (int i = 0; i < appointments.size(); i++){

            Appointment appointment = appointments.get(i);

            if (appointment.getMobileNumber().equals(mobileNumber)){

                System.out.println(appointment);
                System.out.println("--------------------");
                found = true;
            }
        }

        if (!found){
            System.out.println("No appointments found for this patient.");
            }
    }

    // Sort appointments by time
    public void sortAppointmentsByTime(){

        if(appointments.isEmpty()){
            System.out.println("No appointments to sort.");
            return;
        }

        Collections.sort(appointments);

        System.out.println("Appointments sorted by time: ");
        viewAppointments();
    }

    // Cancel appointment by professional ID and appointment time
    public void cancelAppointmentByProfessionalId(String professionalId, String appointmentTime){

        for (int i = 0; i < appointments.size(); i++){

            Appointment appointment = appointments.get(i);

            if (appointment.getHealthProfessional().getId().equals(professionalId) && appointment.getAppointmentTime().equals(appointmentTime)){

                appointments.remove(i);
                System.out.println("Appointment cancelled successfully.");
                return;
            }
        }

        System.out.println("No matching appointment found. Cancellation failed.");
    }

    // Cancel appointment by patient mobile number
        // Cancel appointments by patient mobile number
    public void cancelAppointmentsByMobileNumber(String mobileNumber){

        boolean found = false;

        for (int i = 0; i < appointments.size(); i++){

            Appointment appointment = appointments.get(i);

            if (appointment.getMobileNumber().equals(mobileNumber)){

                appointments.remove(i);
                i--;
                found = true;
            }
        }

        if (found){
            System.out.println("Patient appointments cancelled successfully.");
        } else {
            System.out.println("No appointments found for this patient. Cancellation failed.");
        }
    }
   
}

