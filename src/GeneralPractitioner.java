public class GeneralPractitioner extends HealthProfessional{
    
    // Additional attribute
    private String clinicName;

    // Constructor
    public GeneralPractitioner(String id, String name, String[] availableDays, String clinicName){
        super(id, name, availableDays);
        this.clinicName = clinicName;
    }

    // Return professional type
    @Override 
    public String getProfessionalType(){
        return "General Practitioner";
    }

    // Display general practitioner information
    @Override 
    public String toString(){
        return super.toString() + "\nClinic Name: " + clinicName;
    }
}
