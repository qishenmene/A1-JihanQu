public class Nurse extends HealthProfessional{

    // Additional attribute
    private String department;

    // Constructor
    public Nurse(String id, String name, String[] availableDays, String department){

        super(id, name, availableDays);
        this.department = department;
    }

    // Return professional type
    @Override
    public String getProfessionalType(){
        return "Nurse";
    }

    //Display nurse information
    @Override
    public String toString(){
        return super.toString() + "\nDepartment: " + department;
    }
}
