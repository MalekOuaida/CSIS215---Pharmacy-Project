// title: Pharmacy Project
// date: Friday 14, 2023
// author: Malek Ouaida
// This code defines a subclass called "Prescription" that extends the parent class "Medicine" and adds
// a doctor's specialization to the prescription. It also provides constructors, getters, and a toString method.
// list of methods:
        //Default constructor Prescription()
        //Constructor with args Prescription(String name, String composition, int dose, String doctorSpecialization)
        //Constructor with args Prescription(String name, String composition, int dose, int quantity, double price, String doctorSpecialization)
        //Getter method getDoctorSpecialization()
        //Setter method setDoctorSpecialization(String doctorSpecialization)
        //Overridden method toString()


//Declares a new class Prescription that extends the Medicine class.
public class Prescription extends Medicine {

    //Declares a private String variable doctorSpecialization.
    private String doctorSpecialization;

    //Default constructor that calls the default constructor of the parent class "Medicine" using
    //the super() method
    public Prescription() {
        super();
    }

    //Constructor with args that creates a Prescription with the
    //given name, composition, dose, that calls the second constructor from the parent class "Medicine"
    //using the super() method and sets the doctor specialization.

    public Prescription(String name, String composition, int dose, String doctorSpecialization) {
        super(name, composition, dose);
        setDoctorSpecialization(doctorSpecialization);
    }

    //Constructor with args that creates a Prescription with the
    //given name, composition, dose, quantity and price that calls the third constructor from the parent class "Medicine"
    //using the super() method and sets the doctor specialization.

    public Prescription(String name, String composition, int dose, int quantity, double price, String doctorSpecialization) {
        super(name, composition, dose, quantity, price);
        setDoctorSpecialization(doctorSpecialization);
    }

    //Getter for doctorSpecialization
    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }

    // Sets the specialization of the doctor who prescribed the Prescription
    public void setDoctorSpecialization(String doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }

    //Returns a string representation of the Prescription, including information about the Medicine using the toString
    //in the Parent Class "Medicine" and adds the doctor's specialization.

    @Override
    public String toString() {
        return "Prescription:\n" + super.toString() + "\n" + "doctor specialization: " + doctorSpecialization;
    }
}