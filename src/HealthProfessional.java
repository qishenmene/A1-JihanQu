public abstract class HealthProfessional {

    // Attributes
    private String id;
    private String name;
    private String[] availableDays;

    //Constructor
    public HealthProfessional(String id, String name, String[] avaliableDays){

        // Validate ID
        if (id == null || id.isEmpty()){
            throw new IllegalArgumentException("ID cannot be empty.");
        }
        for (int i = 0; i < id.length(); i++){
            if (id.charAt(i) < '0' || id.charAt(i) > '9'){
                throw new IllegalArgumentException(
                    "ID must contain numbers only."
                );            }
        }
     
         // Validate availableDays
        if (availableDays == null || availableDays.length == 0){
           throw new IllegalArgumentException(
            "Available days cannot be empty.");
         }
    
         String [] valiDays = {
             "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
         };

         this.availableDays = new String[availableDays.length];

         for (int i = 0; i < availableDays.length; i++){
              boolean valid = false;
              String selectedDay = availableDays[i];

              if (selectedDay == null) {
                  throw new IllegalArgumentException("Invalid day.");
             }

              for (int j = 0; j < valiDays.length; j++){
                  if (selectedDay.equalsIgnoreCase(validDays[j])){
                      this.availableDays[i] = validDays[j];
                      valid = true;
                      break;
                   }
               }

               if (!valid){
                   throw new IllegalArgumentException("Invalid day: " + selectedDay);
                }

               // Check for duplicate days
               for (int j = 0; j < i; j++){
                   if (this.availableDays[i].equals(this.availableDays[j])){
                       throw new IllegalArgumentException("Duplicate available day.");
                   }
               }
           }

           this.id = id;
           this.name = name.trim();
     }

     // Getters
     public String getId(){
         return id;
     }

     public String getName(){
         return name;
     }

     public String[] getAvailableDays(){
         return availableDays.clone();
     }

     //Each specific professional must provide its own type
     public abstract String getProfessionalType();

     // Display information
     @Override 
     public String toString(){
         return "Professional Type: " + getProfessionalType()
                 + "\nID: " + id
                 + "\nName: " + name
                 + "\nAvailableDays: " + String.join(", ", availableDays);
     }

}