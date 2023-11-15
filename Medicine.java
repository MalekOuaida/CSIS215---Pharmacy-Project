// title: Pharmacy Project
// date: Friday 14, 2023
// author: Malek Ouaida
// The purpose of this Java class is to represent a medicine object with properties such as
// name, composition, dose, price, and quantity, and provide methods to manipulate and access these properties.
// list of methods:
        //Medicine()
        //Medicine(String name, String composition, int dose)
        //Medicine(String name, String composition, int dose, int quantity, double price)
        //getName()
        //setName(String name)
        //getComposition()
        //setComposition(String composition)
        //getDose()
        //setDose(int dose)
        //getPrice()
        //setPrice(double price)
        //getQuantity()
        //setQuantity(int quantity)
        //toString()
        //equals(Object object)

//This line defines a class named Medicine.
public class Medicine {

    //These are private instance variables of the Medicine class
    //that represent the name, composition, dose, price, and quantity of a medicine.
    private String name;
    private String composition;
    private int dose;
    private double price;
    private int quantity;

    //This is a constructor that initializes a new Medicine object with default values
    //for dose, price, and quantity.
    public Medicine() {
        setDose(1000);
        setPrice(10.0);
        setQuantity(0);
    }

    //This is a constructor that initializes a new Medicine object with the specified values for name, composition,
    //and dose, and default values for price and quantity.

    public Medicine(String name, String composition, int dose) {
        setName(name.toLowerCase());
        setComposition(composition.toLowerCase());
        setDose(dose);
        setPrice(10.0);
        setQuantity(0);
    }

    //This is a constructor that initializes a new Medicine object with the specified
    //values for name, composition, dose, quantity, and price.

    public Medicine(String name, String composition, int dose, int quantity, double price) {
        setName(name.toLowerCase());
        setComposition(composition.toLowerCase());
        setDose(dose);
        setPrice(price);
        setQuantity(quantity);
    }

    //These are getters and setters for the
    //private instance variables of the Medicine class.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition.toLowerCase();
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //This is a method that returns a string representation of a Medicine object.
    @Override
    public String toString() {
        return "name: " + name + "\n" +
                "composition: " + composition + "\n" +
                "dose: " + dose + "mg\n" +
                "price: " + price + "\n" +
                "quantity: " + quantity;
    }

    //Compares this Medicine object to another object for equality Returns true if the other
    //object is a Medicine object with the same name and dose and false otherwise.

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof Medicine other)) {
            return false;
        }
        return name.equals(other.getName()) && dose == other.getDose();
    }
}
