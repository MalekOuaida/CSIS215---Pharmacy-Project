// title: Pharmacy Project
// date: Friday 14, 2023
// author: Malek Ouaida
// This code defines a class OverTheCounter which extends the Medicine class, adding the attribute
// of minimum age requirement for the medicine.
// list of methods:
        //OverTheCounter()
        //OverTheCounter(String name, String composition, int dose, int minAge)
        //OverTheCounter(String name, String composition, int dose, int quantity, double price, int minAge)
        //getMinAge()
        //setMinAge(int minAge)
        //toString()


//Declares a new class OverTheCounter that extends the Medicine class.
public class OverTheCounter extends Medicine {

    //Declares a private integer variable minAge.
    private int minAge;

    //Default constructor for the OverTheCounter class. It calls the default constructor of the Medicine class
    //using the super() method and sets the minAge variable to 18.

    public OverTheCounter() {
        super();
        setMinAge(18);
    }

    //Constructor for the OverTheCounter class
    //that takes four arguments: name, composition, dose, and minAge.
    //It calls the constructor of the Medicine class that takes three arguments using the super() method
    //and sets the minAge variable to the value passed in as an argument.

    public OverTheCounter(String name, String composition, int dose, int minAge) {
        super(name, composition, dose);
        setMinAge(minAge);
    }

    //Constructor for the OverTheCounter class
    //that takes six arguments: name, composition, dose, quantity, price, and minAge.
    //It calls the constructor of the Medicine class that takes five arguments using the super() method
    //and sets the minAge variable to the value passed in as an argument.

    public OverTheCounter(String name, String composition, int dose, int quantity, double price, int minAge) {
        super(name, composition, dose, quantity, price);
        setMinAge(minAge);
    }

    //Getter for MinAge
    public int getMinAge() {
        return minAge;
    }

    //Setter for MinAge
    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    //This block of code is an overridden toString() method
    //that returns a string representation of the OverTheCounter object,
    //including the toString() method of the Medicine class and
    //the value of the minAge variable.

    @Override
    public String toString() {
        return "Over the Counter :\n" + super.toString() + "\n" +
                "minimum Age: " + minAge;
    }
}
