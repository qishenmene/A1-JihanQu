public class Specialist extends HealthProfessional {
    
    // Additional attribute
    private String specialty;

    // Constructor
    public Specialist(String id, String name, String[] availableDays, String specialty) {
        super(id, name, availableDays);
        this.specialty = specialty;
    }

    // Return professional type
    @Override 
    public String getProfessionalType(){
        return "Specialist";
     }

    // Display specialist information
    @Override 
    public String toString(){
        return super.toString() + "\nSpecialty: " + specialty;
    }
}
