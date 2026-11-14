public class AssignmentOne{
    public static void main(String[] args){
        System.out.println("Health Appointment System");
        System.out.println("-------------------------");
        
        // Create general practitioners
        GeneralPractitioner gp1 = new GeneralPractitioner("1001", "Dr Smith", new String[]{"Monday", "Wednesday", "Friday"}, "City Medical Clinic");

        GeneralPractitioner gp2 = new GeneralPractitioner("1002", "Dr Brown", new String[]{"Tuesday", "Thursday", "Friday"}, "North Medical Clinic");

        GeneralPractitioner gp3 = new  GeneralPractitioner("1003", "Dr Wilson", new String[]{"Monday", "Tuesday", "Friday"}, "South Medical Clinic");

        // Create other health professionals
        Specialist specialist = new Specialist("2001", "Dr Taylor", new String[]{"Monday", "Thursday"}, "Cardiology");

        Nurse nurse = new Nurse("3001", "Nurse Johnson", new String[]{"Tuesday", "Wednesday"}, "Emergency");

        Dietitian dietitian = new Dietitian("4001", "Dr Davis", new String[]{"Monday", "Friday"}, "Registered Dietitian");

        // Store different professionals using a common type
        HealthProfessional[] professionals = {
            gp1, gp2, gp3, specialist, nurse, dietitian
        };

          // Display professional information using polymorphism
        System.out.println("\nHealth Professional Details");
        System.out.println("---------------------------");

        for (int i = 0; i < professionals.length; i++) {
            System.out.println(professionals[i]);
            System.out.println("--------------------");
        }

        // Create appointment manager
        AppointmentManager manager = new AppointmentManager();

        // Create appointments
        Appointment appointment1 = new Appointment(
            "Alice", "0411111111", "09:00", gp1
        );

        Appointment appointment2 = new Appointment(
            "Bob", "0422222222", "10:00", gp1
        );

        Appointment appointment3 = new Appointment(
            "Charlie", "0433333333", "09:00", gp2
        );

        Appointment appointment4 = new Appointment(
            "David", "0444444444", "11:00", specialist
        );

        Appointment appointment5 = new Appointment(
            "Emily", "0455555555", "08:30", nurse
        );

        Appointment appointment6 = new Appointment(
            "Frank", "0466666666", "13:00", dietitian
        );

        Appointment appointment7 = new Appointment("Grace", "0488888888", "14:00", gp3);

        // Add appointments
        System.out.println("\nAdding Appointments");
        System.out.println("-------------------");

        manager.addAppointment(appointment1);
        manager.addAppointment(appointment2);
        manager.addAppointment(appointment3);
        manager.addAppointment(appointment4);
        manager.addAppointment(appointment5);
        manager.addAppointment(appointment6);
        manager.addAppointment(appointment7);
        // Test double booking using the same professional ID
        GeneralPractitioner duplicateGP = new GeneralPractitioner(
            "1001", "Another Doctor",
            new String[]{"Monday", "Friday"},
            "Other Clinic"
        );

        Appointment duplicateAppointment = new Appointment(
            "George", "0477777777", "09:00", duplicateGP
        );

        System.out.println("\nTesting Double Booking");
        System.out.println("----------------------");
        manager.addAppointment(duplicateAppointment);

        // Display all appointments
        System.out.println("\nAll Appointments");
        System.out.println("----------------");
        manager.viewAppointments();

        // Search by professional ID
        System.out.println("\nSearch by Professional ID");
        System.out.println("-------------------------");
        manager.searchByProfessionalId("1001");

        // Search by patient mobile number
        System.out.println("\nSearch by Patient Mobile Number");
        System.out.println("--------------------------------");
        manager.searchMobileNumber("0433333333");

        // Sort appointments by time
        System.out.println("\nSort Appointments");
        System.out.println("-----------------");
        manager.sortAppointmentsByTime();

        // Cancel appointment by professional ID and time
        System.out.println("\nCancel by Professional ID and Time");
        System.out.println("----------------------------------");
        manager.cancelAppointmentByProfessionalId("1001", "09:00");

        // Cancel appointments by patient mobile number
        System.out.println("\nCancel by Patient Mobile Number");
        System.out.println("-------------------------------");
        manager.cancelAppointmentsByMobileNumber("0444444444");

        // Test unsuccessful cancellation
        System.out.println("\nTest Unsuccessful Cancellation");
        System.out.println("------------------------------");
        manager.cancelAppointmentByProfessionalId("9999", "15:00");

        // Display remaining appointments
        System.out.println("\nRemaining Appointments");
        System.out.println("----------------------");
        manager.viewAppointments();
    }
}