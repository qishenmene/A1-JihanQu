public class Appointment {
    
    // Attributes
    private String patientName;
    private String mobileNumber;
    private String appointmentTime;
    private HealthProfessional healthProfessional;

    // Constructor
    public Appointment(String patientName, String mobileNumber, String appointmentTime, HealthProfessional healthProfessional){

        // Validate patient name
        if (patientName == null || patientName.trim().isEmpty()){
            throw new IllegalArgumentException("Patient name cannot be empty.");
        }

        // Validate mobile number
        if (mobileNumber == null || mobileNumber.trim().isEmpty()){
            throw new IllegalArgumentException("Mobile number cannot be empty.");
        }

        // Validate health professional
        if (healthProfessional == null){
            throw new IllegalArgumentException("Health professional cannot be null.");
        }

        // Validate appointment time
        if (!isValidAppointmentTime(appointmentTime)){
            throw new IllegalArgumentException("Invalid appointment time.");
        }

        this.patientName = patientName.trim();
        this.mobileNumber = mobileNumber.trim();
        this.appointmentTime = appointmentTime;
        this.healthProfessional = healthProfessional;
    }

    // Check whether appointment time is valid
    private boolean isValidAppointmentTime(String time){

        if (time == null){
            return false;
        }

        String[] parts = time.split(":");

        if (parts.length != 2){
            return false;
        }

        try{
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);

            if (minute != 0 && minute != 30){
                return false;
            }
            
            if (hour < 8 || hour > 16){
                return false;
            }

            if (hour == 16 && minute != 0){
                return false;
            }

            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

       
    // Getters
    public String getMobileNumber(){
        return mobileNumber;
    }

    public String getAppointmentTime(){
        return appointmentTime;
    }

    public HealthProfessional getHealthProfessional(){
        return healthProfessional;
    }

    public String getPatientName(){
        return patientName;
    }

    // Display appointment information
    @Override 
    public String toString(){
        return "Patient Name: " + patientName + "\nMobile Number: " + mobileNumber + "\nAppointment Time: " + appointmentTime + "\n" + healthProfessional.toString();
    }

}
