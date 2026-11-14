public class Dietitian extends HealthProfessional {
    
    // Additional atrribute
    private String qualification;

    // Constructor
    public Dietitian(String id, String name, String[] availableDays, String qualification){

        super(id, name, availableDays);
        this.qualification = qualification;
    }

    // Return professional type
    @Override
    public String getProfessionalType(){
        return "Dietitian";
    }

    // Display dietition information
    @Override 
    public String toString(){
        return super.toString() + "\nQualification: " + qualification;
    }
    
}
